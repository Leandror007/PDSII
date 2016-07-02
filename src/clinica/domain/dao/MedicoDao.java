package clinica.domain.dao;

import java.util.List;

import clinica.domain.Medico;

public interface MedicoDao {
	Medico findByCodigo(Integer codigo);
	List<Medico> listar();
	void remover(Medico medico);
	Medico salvarOuAtualizar(Medico medico);


}
