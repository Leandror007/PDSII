package clinica.domain.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import clinica.domain.Consultas;
import clinica.domain.dao.ConsultasDao;
import clinica.domain.service.ConsultasService;

public class ConsultasServiceImpl implements ConsultasService {
	
		@Inject
		private ConsultasDao dao;

		@Override
		@Transactional
		public void salvar(Consultas consultas) {

			dao.salvarOuAtualizar(consultas);
		}

		@Override
		@Transactional
		public void remover(Integer codigo) {

			dao.remover(dao.findByCodigo(codigo));
		}

		@Override
		public List<Consultas> listarTodos() {

			return dao.listar();
		}

	}
