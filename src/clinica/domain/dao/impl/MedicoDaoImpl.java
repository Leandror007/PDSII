package clinica.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clinica.domain.Medico;
import clinica.domain.dao.MedicoDao;

public class MedicoDaoImpl implements MedicoDao {

	@PersistenceContext(unitName = "MedicoPU")
	private EntityManager em;

	@Override
	public Medico salvarOuAtualizar(Medico entity) {

		if (entity.getCodigo() != null) {
			entity = em.merge(entity);
		}

		em.persist(entity);
		
		return entity;
	}

	@Override
	public void remover(Medico entity) {

		entity = em.merge(entity);

		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Medico> listar() {

		Query query = em.createQuery("from Medico");

		return query.getResultList();
	}

	@Override
	public Medico findByCodigo(Integer codigo) {

		return em.find(Medico.class, codigo);
	}

}
