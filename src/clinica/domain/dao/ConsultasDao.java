package clinica.domain.dao;

import java.util.List;

import clinica.domain.Consultas;

public interface ConsultasDao {
	Consultas findByCodigo(Integer codigo);
	List<Consultas> listar();
	void remover(Consultas consultas);
	Consultas salvarOuAtualizar(Consultas consultas);

}
