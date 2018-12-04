package br.com.sw.api.swapi.test.util;

import com.google.gson.Gson;

import br.com.sw.api.model.Planeta;

public class JsonUtil {
	
	public static String returnJsonFormat(Planeta planeta) {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(planeta);
		
		return json;
	}
	
	public static PlanetaDto returnObjectFormat(String jsonString) {
		
		Gson gson = new Gson();
		
		PlanetaDto planeta = gson.fromJson(jsonString, PlanetaDto.class);
		
		return planeta;
	}
	
}
