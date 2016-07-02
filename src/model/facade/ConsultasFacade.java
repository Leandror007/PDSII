package model.facade;

import java.util.List;

import model.domain.Consultas;

public interface ConsultasFacade {

	List<Consultas> getConsultass();
	List<Consultas> getConsultass(Integer codigo);
	Consultas salvar(Consultas consultas);
	void atualizar(Consultas consultas);
	void deletarConsultas(Integer codigo);

}