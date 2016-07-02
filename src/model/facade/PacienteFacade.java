package model.facade;

import java.util.List;

import model.domain.Paciente;

public interface PacienteFacade {

	List<Paciente> getPacientes();
	List<Paciente> getPacientes(Integer codigo);
	Paciente salvar(Paciente paciente);
	void atualizar(Paciente paciente);
	void deletarPaciente(Integer codigo);

}