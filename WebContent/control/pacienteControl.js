var app = angular.module('pacienteModule',[]);

app.controller('pacienteControl',function($scope,$http){
	
	var url = 'http://localhost:8080/Clinica/rs/paciente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (pacientesRetorno) {
			$scope.pacientes = pacientesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.paciente = {};
	}

    $scope.salvar = function() {
		if ($scope.paciente.codigo == '') {
			$http.post(url,$scope.paciente).success(function(paciente) {
				$scope.pacientes.push($scope.paciente);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.paciente).success(function(paciente) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.paciente.codigo == '') {
			alert('Selecione um paciente');
		} else {
			urlExcluir = url+'/'+$scope.paciente.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(pacienteTabela) {
		$scope.paciente = pacienteTabela;
	}
});