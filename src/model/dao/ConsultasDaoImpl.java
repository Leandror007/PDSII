package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Consultas;

public class ConsultasDaoImpl implements ConsultasDao {
	
	@PersistenceContext(unitName="ClinicaPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Consultas> getConsultass(Consultas consultas) {
		StringBuffer hql = new StringBuffer("from Consultas c"
				+ " where 1 = 1");		
		if (consultas.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (consultas.getCodigo() != null) {
			query.setParameter("codigo",consultas.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Consultas consultas) {
		consultas = entityManager.merge(consultas);
		entityManager.remove(consultas);
	}

	@Override
	@Transactional
	public Consultas salvar(Consultas consultas) {
		entityManager.persist(consultas);
		return consultas;
	}

	@Override
	@Transactional
	public void atualizar(Consultas consultas) {
		consultas = entityManager.merge(consultas);
		entityManager.persist(consultas);		
	}
	

}
