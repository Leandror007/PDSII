package clinica.domain.service;

import java.util.List;

import clinica.domain.Paciente;

public interface PacienteService {
	
	void salvar(Paciente paciente);
	void remover(Integer codigo);
	List<Paciente> listarTodos();
}
