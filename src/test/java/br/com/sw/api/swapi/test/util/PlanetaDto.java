package br.com.sw.api.swapi.test.util;

public class PlanetaDto {
	
	public PlanetaDto() {}
	
	public PlanetaDto(String _id, String nome, String terreno, String clima) {
		super();
		this._id = _id;
		this.nome = nome;
		this.terreno = terreno;
		this.clima = clima;
	}
	private String _id;
	private String nome;
	private String terreno;
	private String clima;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	
	

}
