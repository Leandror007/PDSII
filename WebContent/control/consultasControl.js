var app = angular.module('consultasModule',[]);

app.controller('consultasControl',function($scope,$http){
	
	var url = 'http://localhost:8080/Clinica/rs/consultas';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (consultassRetorno) {
			$scope.consultass = consultassRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.consultas = {};
	}

    $scope.salvar = function() {
		if ($scope.consultas.codigo == '') {
			$http.post(url,$scope.consultas).success(function(consultas) {
				$scope.consultass.push($scope.consultas);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.consultas).success(function(consultas) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.consultas.codigo == '') {
			alert('Selecione um consultas');
		} else {
			urlExcluir = url+'/'+$scope.consultas.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(consultasTabela) {
		$scope.consultas = consultasTabela;
	}
});