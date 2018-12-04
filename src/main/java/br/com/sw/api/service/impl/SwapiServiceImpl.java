package br.com.sw.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sw.api.dto.SwapiResultsDto;
import br.com.sw.api.exception.SwapiConnectionException;
import br.com.sw.api.service.SwapiService;
import br.com.sw.api.util.DecodeUtil;

@Service
public class SwapiServiceImpl implements SwapiService {
	
	@Value("${swapi.url}")
	private String swapiUrl;

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Integer retornaQuantidadeAparicoesPlaneta(String nomePlaneta) throws SwapiConnectionException {
		try {
			nomePlaneta = DecodeUtil.decode(nomePlaneta);
			SwapiResultsDto results = restTemplate.getForObject(swapiUrl + nomePlaneta, SwapiResultsDto.class);
			if (results.getResults() != null && (results.getCount() > 0))
				return results.getResults().get(0).retornaQuantidadeFilmes();
		} catch (Exception e) {
			throw new SwapiConnectionException("Falha ao conectar a SWAPI", e.getCause());
		}
		return 0;
	}
}
