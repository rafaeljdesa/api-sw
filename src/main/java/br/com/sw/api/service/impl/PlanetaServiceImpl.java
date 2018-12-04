package br.com.sw.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sw.api.exception.PlanetaExisteException;
import br.com.sw.api.exception.PlanetaNaoEncontradoException;
import br.com.sw.api.model.Planeta;
import br.com.sw.api.repository.PlanetaRepository;
import br.com.sw.api.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository repository;

	@Autowired
	private SwapiServiceImpl swapiService;

	@Override
	public List<Planeta> listaPlanetas() {
		List<Planeta> planetas = this.repository.findAll();
		planetas.stream().forEach(p -> this.preencheQuantidadePlanetas(p));
		return planetas;
	}

	@Override
	public Planeta buscaPlanetaPorId(ObjectId _id) {
		Optional<Planeta> planeta = this.repository.findBy_id(_id);
		if (planeta.isPresent())
			this.preencheQuantidadePlanetas(planeta.get());
		return planeta.orElseThrow(() -> new PlanetaNaoEncontradoException("Planeta de id " + _id.toString() + " não encontrado"));
	}

	@Override
	public Planeta buscaPlanetaPorNome(String nome) {
		Optional<Planeta> planeta = this.repository.findByNome(nome);
		if (planeta.isPresent())
			this.preencheQuantidadePlanetas(planeta.get());
		return planeta.orElseThrow(() -> new PlanetaNaoEncontradoException("Planeta de nome " + nome + " não encontrado"));
	}

	@Override
	public Planeta alteraPlaneta(ObjectId _id, Planeta planeta) {
		planeta.set_id(_id);
		this.repository.save(planeta);
		this.preencheQuantidadePlanetas(planeta);
		return planeta;
	}

	@Override
	public Planeta criaPlaneta(Planeta planeta) {
		if (this.planetaExiste(planeta.getNome()))
			throw new PlanetaExisteException("Planeta de nome " + planeta.getNome() + " já existe");	
		planeta.set_id(ObjectId.get());
		this.repository.save(planeta);
		this.preencheQuantidadePlanetas(planeta);
		return planeta;
	}

	@Override
	public void deletaPlaneta(ObjectId _id) {
		Optional<Planeta> planeta = this.repository.findBy_id(_id);
		if (planeta.isPresent())
			this.repository.delete(planeta.get());
		else
			throw new PlanetaNaoEncontradoException("Planeta de id " + _id.toString() + " não encontrado");
	}

	@Override
	public boolean planetaExiste(String nome) {
		return this.repository.existsByNome(nome);
	}

	public void preencheQuantidadePlanetas(Planeta planeta) {
		Integer quantidade = this.swapiService.retornaQuantidadeAparicoesPlaneta(planeta.getNome());
		planeta.setQuantidadeAparicoes(quantidade);
	}

}
