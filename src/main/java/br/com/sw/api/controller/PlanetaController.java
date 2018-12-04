package br.com.sw.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sw.api.model.Planeta;
import br.com.sw.api.service.PlanetaService;
import br.com.sw.api.util.PlanetaResourceAssembler;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {
	
	@Autowired
	PlanetaService planetaService;
	
	@Autowired
	PlanetaResourceAssembler planetaAssembler;

	@GetMapping(value = "/")
	public Resources<Resource<Planeta>> listaPlanetas() {
		List<Resource<Planeta>> planetas = this.planetaService.listaPlanetas().stream()
				.map(this.planetaAssembler::toResource)
				.collect(Collectors.toList());
		return new Resources<>(planetas,
				linkTo(methodOn(PlanetaController.class).listaPlanetas()).withSelfRel());
	}

	@GetMapping(value = "/{id}")
	public Resource<Planeta> buscaPlanetaPorId(@PathVariable("id") ObjectId _id) {
		Planeta planeta = this.planetaService.buscaPlanetaPorId(_id);
		return this.planetaAssembler.toResource(planeta);
	}
	
	@GetMapping(value = "/nome/{nome}")
	public Resource<Planeta> buscaPlanetaPorNome(@PathVariable("nome") String nome) {
		Planeta planeta = this.planetaService.buscaPlanetaPorNome(nome);
		return this.planetaAssembler.toResource(planeta);
	}

	@PutMapping(value = "/{id}")
	public Resource<Planeta> alteraPlaneta(@PathVariable("id") ObjectId _id, @Valid @RequestBody Planeta planeta) {
		Planeta planetaResp = this.planetaService.alteraPlaneta(_id, planeta);
		return this.planetaAssembler.toResource(planetaResp);
	}

	@PostMapping(value = "/")
	public Resource<Planeta> criaPlaneta(@Valid @RequestBody Planeta planeta) {
		Planeta planetaResp = this.planetaService.criaPlaneta(planeta);
		return this.planetaAssembler.toResource(planetaResp);
	}

	@DeleteMapping(value = "/{id}")
	public void deletaPlaneta(@PathVariable("id") ObjectId _id) {
		this.planetaService.deletaPlaneta(_id);
	}
	
}
