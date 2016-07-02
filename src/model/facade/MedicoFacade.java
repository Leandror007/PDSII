package model.facade;

import java.util.List;

import model.domain.Medico;

public interface MedicoFacade {

	List<Medico> getMedicos();
	List<Medico> getMedicos(Integer codigo);
	Medico salvar(Medico medico);
	void atualizar(Medico medico);
	void deletarMedico(Integer codigo);

}