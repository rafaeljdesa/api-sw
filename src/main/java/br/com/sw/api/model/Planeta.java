package br.com.sw.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Planeta {

	public Planeta() {

	}

	public Planeta(ObjectId _id, String nome, String clima, String terreno) {
		super();
		this._id = _id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}

	@Id
	private ObjectId _id;

	private String nome;

	private String clima;

	private String terreno;
	
	@Transient
	private Integer quantidadeAparicoes;

	@Override
	public String toString() {
		return "Planeta [_id=" + _id + ", nome=" + nome + ", clima=" + clima + ", terreno=" + terreno
				+ ", quantidadeAparicoes=" + quantidadeAparicoes + ", hashCode()=" + hashCode()
				+ ", getQuantidadeAparicoes()=" + getQuantidadeAparicoes() + ", get_id()=" + get_id() + ", getNome()="
				+ getNome() + ", getClima()=" + getClima() + ", getTerreno()=" + getTerreno() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((clima == null) ? 0 : clima.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((quantidadeAparicoes == null) ? 0 : quantidadeAparicoes.hashCode());
		result = prime * result + ((terreno == null) ? 0 : terreno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (clima == null) {
			if (other.clima != null)
				return false;
		} else if (!clima.equals(other.clima))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (quantidadeAparicoes == null) {
			if (other.quantidadeAparicoes != null)
				return false;
		} else if (!quantidadeAparicoes.equals(other.quantidadeAparicoes))
			return false;
		if (terreno == null) {
			if (other.terreno != null)
				return false;
		} else if (!terreno.equals(other.terreno))
			return false;
		return true;
	}

	public Integer getQuantidadeAparicoes() {
		return quantidadeAparicoes;
	}

	public void setQuantidadeAparicoes(Integer quantidadeAparicoes) {
		this.quantidadeAparicoes = quantidadeAparicoes;
	}

	public String get_id() {
		return _id.toString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

}
