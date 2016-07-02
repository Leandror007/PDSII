package clinica.domain.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import clinica.domain.Medico;
import clinica.domain.dao.MedicoDao;
import clinica.domain.service.MedicoService;

public class MedicoServiceImpl implements MedicoService {

	@Inject
	private MedicoDao dao;

	@Override
	@Transactional
	public void salvar(Medico medico) {

		dao.salvarOuAtualizar(medico);
	}

	@Override
	@Transactional
	public void remover(Integer codigo) {

		dao.remover(dao.findByCodigo(codigo));
	}

	@Override
	public List<Medico> listarTodos() {

		return dao.listar();
	}

}
