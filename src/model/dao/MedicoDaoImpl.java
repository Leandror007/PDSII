package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Medico;

public class MedicoDaoImpl implements MedicoDao {
	
	@PersistenceContext(unitName="ClinicaPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Medico> getMedicos(Medico medico) {
		StringBuffer hql = new StringBuffer("from Medico c"
				+ " where 1 = 1");		
		if (medico.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (medico.getCodigo() != null) {
			query.setParameter("codigo",medico.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Medico medico) {
		medico = entityManager.merge(medico);
		entityManager.remove(medico);
	}

	@Override
	@Transactional
	public Medico salvar(Medico medico) {
		entityManager.persist(medico);
		return medico;
	}

	@Override
	@Transactional
	public void atualizar(Medico medico) {
		medico = entityManager.merge(medico);
		entityManager.persist(medico);		
	}
	

}
