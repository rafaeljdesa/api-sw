package br.com.sw.api.config;

import java.io.IOException;
import java.text.ParseException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import br.com.sw.api.model.Planeta;
import br.com.sw.api.service.PlanetaService;

@Configuration
public class Config {
	
	@Autowired
	private PlanetaService planetaService;
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(this.addRequestHeader("User-agent", 
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"));
		return restTemplate;
	}
	
	@Bean
	public void initDatabase(){
		Planeta planeta = new Planeta(new ObjectId() ,"Dathomir", "temperate", "forests, deserts, savannas");
		if(!this.planetaService.planetaExiste(planeta.getNome()))
			this.planetaService.criaPlaneta(planeta);		
		
		Planeta planeta2 = new Planeta(new ObjectId(), "Vulpter", "temperate, artic", "urban, barren");
		if(!this.planetaService.planetaExiste(planeta2.getNome()))
			this.planetaService.criaPlaneta(planeta2);
			
		Planeta planeta3 = new Planeta(new ObjectId(), "Troiken", "unknown", "desert, tundra, rainforests, mountains");
		if(!this.planetaService.planetaExiste(planeta3.getNome()))
			this.planetaService.criaPlaneta(planeta3);
	}


	private ClientHttpRequestInterceptor addRequestHeader(String name, String value) {

		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().set(name, value);
				return execution.execute(request, body);
			}
		};
	}
	
}
