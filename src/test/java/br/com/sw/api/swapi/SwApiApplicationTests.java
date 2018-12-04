package br.com.sw.api.swapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.sw.api.model.Planeta;
import br.com.sw.api.swapi.test.util.JsonUtil;
import br.com.sw.api.swapi.test.util.PlanetaDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SwApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
	}

	@Test
	public void listaPlanetasTest() throws Exception {
		this.mockMvc.perform(get("/planetas/")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void buscaPlanetaNomeTest() throws Exception {
		this.mockMvc.perform(get("/planetas/nome/Dantooine")).andDo(print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("application/hal+json;charset=UTF-8"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Dantooine"));
	}

	@Test
	public void buscaPlanetaIdTest() throws Exception {
		this.mockMvc.perform(get("/planetas/5c05d295ec00ec02e017b4c2")).andDo(print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("application/hal+json;charset=UTF-8"))
			.andExpect(MockMvcResultMatchers.jsonPath("$._id").value("5c05d295ec00ec02e017b4c2"));
	}

	@Test
	public void adicionaPlanetaTest() throws Exception {

		Planeta planeta = new Planeta(ObjectId.get(), "Dantooine", "temperate",
				"oceans, savannas, mountains, grasslands");
		PlanetaDto planetaExistente = new PlanetaDto();

		MvcResult mvcResult = this.mockMvc.perform(get("/planetas/nome/Dantooine")).andReturn();

		if (mvcResult.getResponse().getStatus() == 200) {
			planetaExistente = JsonUtil.returnObjectFormat(mvcResult.getResponse().getContentAsString());
		}

		if (planetaExistente.get_id() != null) {

			this.mockMvc
				.perform(post("/planetas/").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JsonUtil.returnJsonFormat(planeta)))
				.andDo(print()).andExpect(MockMvcResultMatchers.status().isConflict());

		} else {

			this.mockMvc
				.perform(post("/planetas/").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JsonUtil.returnJsonFormat(planeta)))
				.andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());

		}

	}

	@Test
	public void deletaPlanetaTest() throws Exception {			
		this.mockMvc.perform(delete("/planetas/5c05d1cfec00ec32501c6a28"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk());		
	}

	@Test
	public void alteraPlanetaTest() throws Exception {
		PlanetaDto planeta = new PlanetaDto();

		MvcResult mvcResult = this.mockMvc.perform(get("/planetas/nome/Dantooine")).andReturn();

		if (mvcResult.getResponse().getStatus() == 200) {
			planeta = JsonUtil.returnObjectFormat(mvcResult.getResponse().getContentAsString());

			Planeta planetaEntity = new Planeta();

			planetaEntity.set_id(new ObjectId(planeta.get_id()));
			planetaEntity.setNome("Dantooine alterado");
			planetaEntity.setClima(planeta.getClima());
			planetaEntity.setTerreno(planeta.getTerreno());

			this.mockMvc
				.perform(put("/planetas/" + planetaEntity.get_id()).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JsonUtil.returnJsonFormat(planetaEntity)))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk());
		}
	}

}
