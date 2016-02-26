(function() {
    'use strict';
    
    angular
        .module('pessoa')
        .service('PessoaService', PessoaService);
    
    PessoaService.$inject = ['API','$http'];
    
    function PessoaService(API,$http) {
        this.findAll = function() {
            return $http.get(API.url + 'pessoas');
        }
        this.create = function(pessoa) {
            return $http.post(API.url + 'pessoas', pessoa);
        }
        this.update = function(pessoa) {
            return $http.put(API.url + 'pessoas/' + pessoa._id, pessoa);
        }
        this.remove = function(id) {
            return $http.delete(API.url + 'pessoas/' + id);
        }
    }
})();