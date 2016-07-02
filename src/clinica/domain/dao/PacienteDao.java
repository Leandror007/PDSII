package clinica.domain.dao;

import java.util.List;

import clinica.domain.Paciente;

public interface PacienteDao {
	Paciente findByCodigo(Integer codigo);
	List<Paciente> listar();
	void remover(Paciente paciente);
	Paciente salvarOuAtualizar(Paciente paciente);

}
