package model.dao;

import java.util.List;

import model.domain.Paciente;

public interface PacienteDao {
	List<Paciente> getPacientes(Paciente paciente);	
	public void excluir(Paciente paciente);
	Paciente salvar(Paciente paciente);
	void atualizar(Paciente paciente);

}
