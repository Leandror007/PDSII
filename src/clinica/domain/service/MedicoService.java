package clinica.domain.service;

import java.util.List;

import clinica.domain.Medico;

public interface MedicoService {
	void salvar(Medico medico);
	void remover(Integer codigo);
	List<Medico> listarTodos();
}
