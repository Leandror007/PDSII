package clinica.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clinica.domain.Paciente;
import clinica.domain.dao.PacienteDao;

public class PacienteDaoImpl implements PacienteDao {

	@PersistenceContext(unitName = "PacientePU")
	private EntityManager em;

	@Override
	public Paciente salvarOuAtualizar(Paciente entity) {

		if (entity.getCodigo() != null) {
			entity = em.merge(entity);
		}

		em.persist(entity);
		
		return entity;
	}

	@Override
	public void remover(Paciente entity) {

		entity = em.merge(entity);

		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Paciente> listar() {

		Query query = em.createQuery("from Paciente");

		return query.getResultList();
	}

	@Override
	public Paciente findByCodigo(Integer codigo) {

		return em.find(Paciente.class, codigo);
	}

}
