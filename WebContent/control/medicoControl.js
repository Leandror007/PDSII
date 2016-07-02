var app = angular.module('medicoModule',[]);

app.controller('medicoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/Clinica/rs/medico';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (medicosRetorno) {
			$scope.medicos = medicosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.medico = {};
	}

    $scope.salvar = function() {
		if ($scope.medico.codigo == '') {
			$http.post(url,$scope.medico).success(function(medico) {
				$scope.medicos.push($scope.medico);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.medico).success(function(medico) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.medico.codigo == '') {
			alert('Selecione um medico');
		} else {
			urlExcluir = url+'/'+$scope.medico.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(medicoTabela) {
		$scope.medico = medicoTabela;
	}
});