package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ConsultasDao;
import model.domain.Consultas;
import model.facade.ConsultasFacade;

@WebService(serviceName="ws/consultas")
public class ConsultasFacadeImpl implements ConsultasFacade {
	
	@Inject
	private ConsultasDao consultasDao;
			
	@WebMethod
	public List<Consultas> getConsultass() {
		return consultasDao.getConsultass(new Consultas());
	}
	
	@Override
	@WebMethod(operationName="getConsultasCodigo")
	public List<Consultas> getConsultass(@WebParam(name="codigoConsultas") 
							Integer codigo) {
		Consultas consultas = new Consultas();
		consultas.setCodigo(codigo);
		return consultasDao.getConsultass(consultas);
	}
	
	@WebMethod
	public Consultas salvar(@WebParam(name="consultas") Consultas consultas) {
		return consultasDao.salvar(consultas);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="consultas") Consultas consultas) {
		consultasDao.atualizar(consultas);
	}
	
	@WebMethod
	public void deletarConsultas(@WebParam(name="codigoConsultas") Integer codigo) {
		Consultas consultas = new Consultas();
		consultas.setCodigo(codigo);
		consultasDao.excluir(consultas);
	}


}
