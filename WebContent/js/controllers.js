var crudPaciente = angular.module('crudPaciente', ["ngResource"]);

crudPaciente.controller("PacienteController", ["$resource", "$scope", function($resource, $scope) {
	
	var angularResource = $resource("/Clinica/ws/paciente");
	var angularResourceParam = $resource("/Clinica/ws/paciente/:codigo", {codigo : "@codigo"});
	
	$scope.pacientes = angularResource.query(function(){});
	
	$scope.salvar = function() {
		var newResource = new angularResource($scope.paciente);
		newResource.$save(function(){
			$scope.pacientes.push(newResource);
			$scope.novo(); 
		});
	}
	
	$scope.editar = function() {
		var newResource = new angularResource($scope.paciente);
		newResource.$save(function(){
			$scope.novo(); 
		});
	}
	
	$scope.excluir = function() {
		var newResource = new angularResourceParam($scope.paciente);
		newResource.$delete(function() {
			$scope.pacientes.splice($scope.pacientes.indexOf($scope.paciente), 1);
			$scope.novo();  
		});
	}
	
	$scope.novo = function () { 
		$scope.paciente = "";
	}; 	
	
	$scope.seleciona = function (paciente) {
		$scope.paciente = paciente; 								  
	};	
	
}])

/* --------------------------------------------------------------------------- */

var crudMedico = angular.module('crudMedico', ["ngResource"]);

crudMedico.controller("MedicoController", ["$resource", "$scope", function($resource, $scope) {
	
	var angularResource = $resource("/Clinica/ws/medico");
	var angularResourceParam = $resource("/Clinica/ws/medico/:codigo", {codigo : "@codigo"});
	
	$scope.medicos = angularResource.query(function(){});
	
	$scope.salvar = function() {
		var newResource = new angularResource($scope.medico);
		newResource.$save(function(){
			$scope.medicos.push(newResource);
			$scope.novo(); 
		});
	}
	
	$scope.editar = function() {
		var newResource = new angularResource($scope.medico);
		newResource.$save(function(){
			$scope.novo(); 
		});
	}
	
	$scope.excluir = function() {
		var newResource = new angularResourceParam($scope.medico);
		newResource.$delete(function() {
			$scope.medicos.splice($scope.medicos.indexOf($scope.medico), 1);
			$scope.novo();  
		});
	}
	
	$scope.novo = function () { 
		$scope.medico = "";
	}; 	
	
	$scope.seleciona = function (medico) {
		$scope.medico = medico; 								  
	};	
	
}])


/* -------------------------------------------------------------------------------*/


var crudConsultas = angular.module('crudConsultas', ["ngResource"]);

crudConsultas.controller("ConsultasController", ["$resource", "$scope", function($resource, $scope) {
	
	var angularResource = $resource("/Clinica/ws/consultas");
	var angularResourceParam = $resource("/Clinica/ws/consultas/:codigo", {codigo : "@codigo"});
	
	$scope.consultass = angularResource.query(function(){});
	
	$scope.salvar = function() {
		var newResource = new angularResource($scope.consultas);
		newResource.$save(function(){
			$scope.consultass.push(newResource);
			$scope.novo(); 
		});
	}
	
	$scope.editar = function() {
		var newResource = new angularResource($scope.consultas);
		newResource.$save(function(){
			$scope.novo(); 
		});
	}
	
	$scope.excluir = function() {
		var newResource = new angularResourceParam($scope.consultas);
		newResource.$delete(function() {
			$scope.consultass.splice($scope.consultass.indexOf($scope.consultas), 1);
			$scope.novo();  
		});
	}
	
	$scope.novo = function () { 
		$scope.consultas = "";
	}; 	
	
	$scope.seleciona = function (consultas) {
		$scope.consultas = consultas; 								  
	};	
	
}])