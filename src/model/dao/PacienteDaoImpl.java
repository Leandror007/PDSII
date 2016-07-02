package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Paciente;

public class PacienteDaoImpl implements PacienteDao {
	
	@PersistenceContext(unitName="ClinicaPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Paciente> getPacientes(Paciente paciente) {
		StringBuffer hql = new StringBuffer("from Paciente c"
				+ " where 1 = 1");		
		if (paciente.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (paciente.getCodigo() != null) {
			query.setParameter("codigo",paciente.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Paciente paciente) {
		paciente = entityManager.merge(paciente);
		entityManager.remove(paciente);
	}

	@Override
	@Transactional
	public Paciente salvar(Paciente paciente) {
		entityManager.persist(paciente);
		return paciente;
	}

	@Override
	@Transactional
	public void atualizar(Paciente paciente) {
		paciente = entityManager.merge(paciente);
		entityManager.persist(paciente);		
	}
	

}
