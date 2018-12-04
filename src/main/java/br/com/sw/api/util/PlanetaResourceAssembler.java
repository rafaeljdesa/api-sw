package br.com.sw.api.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.bson.types.ObjectId;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import br.com.sw.api.controller.PlanetaController;
import br.com.sw.api.model.Planeta;

@Component
public class PlanetaResourceAssembler implements ResourceAssembler<Planeta, Resource<Planeta>> {

	@Override
	public Resource<Planeta> toResource(Planeta planeta) {
		return new Resource<>(planeta,
				linkTo(methodOn(PlanetaController.class).buscaPlanetaPorId(new ObjectId(planeta.get_id()))).withSelfRel(),
				linkTo(methodOn(PlanetaController.class).buscaPlanetaPorNome(planeta.getNome())).withSelfRel(),
				linkTo(methodOn(PlanetaController.class).listaPlanetas()).withRel("planetas"));
	}

}
