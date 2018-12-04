package br.com.sw.api.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sw.api.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	Optional<Planeta> findBy_id(ObjectId _id);
	
	Optional<Planeta> findByNome(String nome);
	
	boolean existsByNome(String nome);
	
}
