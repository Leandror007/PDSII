package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MedicoDao;
import model.domain.Medico;
import model.facade.MedicoFacade;

@WebService(serviceName="ws/medico")
public class MedicoFacadeImpl implements MedicoFacade {
	
	@Inject
	private MedicoDao medicoDao;
			
	@WebMethod
	public List<Medico> getMedicos() {
		return medicoDao.getMedicos(new Medico());
	}
	
	@Override
	@WebMethod(operationName="getMedicoCodigo")
	public List<Medico> getMedicos(@WebParam(name="codigoMedico") 
							Integer codigo) {
		Medico medico = new Medico();
		medico.setCodigo(codigo);
		return medicoDao.getMedicos(medico);
	}
	
	@WebMethod
	public Medico salvar(@WebParam(name="medico") Medico medico) {
		return medicoDao.salvar(medico);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="medico") Medico medico) {
		medicoDao.atualizar(medico);
	}
	
	@WebMethod
	public void deletarMedico(@WebParam(name="codigoMedico") Integer codigo) {
		Medico medico = new Medico();
		medico.setCodigo(codigo);
		medicoDao.excluir(medico);
	}


}
