(function() {
    'use strict';
    
    angular
        .module('pessoa')
        .controller('PessoaController', PessoaController);
    
    PessoaController.$inject = ['PessoaService'];
    
    function PessoaController(PessoaService) {
        var vm = this;
        vm.empty = {};
        
        vm.findAll = function() {
            PessoaService.findAll().then(function(response) {
                vm.pessoas = response.data;
            },function(error) {
                console.error(error);
            });
        }
        vm.findAll();
        
        vm.reset = function() {
            vm.pessoa = angular.copy(vm.empty);
        }
        vm.populate = function(pessoa) {
            vm.pessoa = angular.copy(pessoa);
        }
        vm.save = function(pessoa) {
            if (pessoa._id) {
                PessoaService.update(pessoa).then(function(response) {
                    vm.success = response.data;
                    vm.findAll();
                    vm.reset();
                },function(error) {
                    console.log(error);
                    vm.error = error.data;
                });
            } else {
                PessoaService.create(pessoa).then(function(response) {
                    vm.success = response.data;
                    vm.findAll();
                    vm.reset();
                }, function(error) {
                    console.error(error);
                    vm.error = error.data;
                });
            }
        }
        vm.remove = function(pessoa) {
            if (confirm('Tem certeza que gostaria de remover a pessoa ' + pessoa.name + '?')) {
                PessoaService.remove(pessoa._id).then(function(response) {
                    vm.success = response.data;
                    vm.findAll();
                }, function(error) {
                    console.error(error);
                    vm.error = error.data;
                });
            }
        }
    }
})();