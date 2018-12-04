package br.com.sw.api.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import br.com.sw.api.model.Planeta;

@Component
public interface PlanetaService {
	
	List<Planeta> listaPlanetas();
	
	Planeta buscaPlanetaPorId(ObjectId _id);
	
	Planeta buscaPlanetaPorNome(String nome);
	
	Planeta alteraPlaneta(ObjectId _id, Planeta planeta);
	
	Planeta criaPlaneta(Planeta planeta);
	
	void deletaPlaneta(ObjectId _id);
	
	boolean planetaExiste(String nome);
	
}
