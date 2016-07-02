package clinica.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clinica.domain.Consultas;
import clinica.domain.dao.ConsultasDao;

public class ConsultasDaoImpl implements ConsultasDao {

	@PersistenceContext(unitName = "ConsultasPU")
	private EntityManager em;

	@Override
	public Consultas salvarOuAtualizar(Consultas entity) {

		if (entity.getCodigo() != null) {
			entity = em.merge(entity);
		}

		em.persist(entity);
		
		return entity;
	}

	@Override
	public void remover(Consultas entity) {

		entity = em.merge(entity);

		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Consultas> listar() {

		Query query = em.createQuery("from Consultas");

		return query.getResultList();
	}

	@Override
	public Consultas findByCodigo(Integer codigo) {

		return em.find(Consultas.class, codigo);
	}

}
