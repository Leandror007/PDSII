package model.dao;

import java.util.List;

import model.domain.Consultas;

public interface ConsultasDao {
	List<Consultas> getConsultass(Consultas consultas);	
	public void excluir(Consultas consultas);
	Consultas salvar(Consultas consultas);
	void atualizar(Consultas consultas);

}
