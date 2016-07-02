package model.dao;

import java.util.List;

import model.domain.Medico;

public interface MedicoDao {
	List<Medico> getMedicos(Medico medico);	
	public void excluir(Medico medico);
	Medico salvar(Medico medico);
	void atualizar(Medico medico);

}
