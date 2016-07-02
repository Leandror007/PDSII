package clinica.domain.service;

import java.util.List;

import clinica.domain.Consultas;

public interface ConsultasService {
	void salvar(Consultas consultas);
	void remover(Integer codigo);
	List<Consultas> listarTodos();

}
