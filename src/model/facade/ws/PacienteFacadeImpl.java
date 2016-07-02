package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.PacienteDao;
import model.domain.Paciente;
import model.facade.PacienteFacade;

@WebService(serviceName="ws/paciente")
public class PacienteFacadeImpl implements PacienteFacade {
	
	@Inject
	private PacienteDao pacienteDao;
			
	@WebMethod
	public List<Paciente> getPacientes() {
		return pacienteDao.getPacientes(new Paciente());
	}
	
	@Override
	@WebMethod(operationName="getPacienteCodigo")
	public List<Paciente> getPacientes(@WebParam(name="codigoPaciente") 
							Integer codigo) {
		Paciente paciente = new Paciente();
		paciente.setCodigo(codigo);
		return pacienteDao.getPacientes(paciente);
	}
	
	@WebMethod
	public Paciente salvar(@WebParam(name="paciente") Paciente paciente) {
		return pacienteDao.salvar(paciente);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="paciente") Paciente paciente) {
		pacienteDao.atualizar(paciente);
	}
	
	@WebMethod
	public void deletarPaciente(@WebParam(name="codigoPaciente") Integer codigo) {
		Paciente paciente = new Paciente();
		paciente.setCodigo(codigo);
		pacienteDao.excluir(paciente);
	}


}
