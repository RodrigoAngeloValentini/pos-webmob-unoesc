(function() {
    'use strict';
    
    angular
        .module('pessoa')
        .config(Config);
    
    function Config($routeProvider) {
        $routeProvider
            .when('/pessoas', {
                templateUrl: 'pessoa/pessoa.html',
                controller: 'PessoaController',
                controllerAs: 'vm'
            });
    }
})();