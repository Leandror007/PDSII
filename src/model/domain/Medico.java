package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "TBMEDICO")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column( name = "CODM")
	private Integer codigo;	
	
	@Size(min=10,message="Nome do medico precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")	
	@Column(name = "NOME")
	private String nome;

	@Size(min=5,message="Endereço precisa ter pelo menos 5 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "ENDERECO")
	private String endereco;
	
	@Size(min=5,message="Nome bairro precisa ter pelo menos 5 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Size(min=5,message="Nome da cidade precisa ter pelo menos 5 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "CIDADE")
	private String cidade;
	
	@Size(min=10,message="Numero do medico precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "CELULAR")
	private String celular;
	
	
	@Size(min=10,message="Especialidade do medico precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "ESPECIALIDADE")
	private String especialidade;
	
	@OneToMany(mappedBy="medico")
	private List<Consultas> consultas;
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
		

	public List<Consultas> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consultas> consultas) {
		this.consultas = consultas;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Medico other = (Medico) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}	
	

}
