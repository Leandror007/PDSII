package clinica.domain.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import clinica.domain.Paciente;
import clinica.domain.dao.PacienteDao;
import clinica.domain.service.PacienteService;

public class PacienteServiceImpl implements PacienteService {

	@Inject
	private PacienteDao dao;

	@Override
	@Transactional
	public void salvar(Paciente paciente) {

		dao.salvarOuAtualizar(paciente);
	}

	@Override
	@Transactional
	public void remover(Integer codigo) {

		dao.remover(dao.findByCodigo(codigo));
	}

	@Override
	public List<Paciente> listarTodos() {

		return dao.listar();
	}

}
