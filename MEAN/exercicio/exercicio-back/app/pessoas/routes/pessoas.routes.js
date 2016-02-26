'use strict';

module.exports = function(api){
  var pessoas = require('../controllers/pessoas.controller');
  
  api.route('/pessoas')
     .get(pessoas.findAll)
     .post(pessoas.create);
  
  api.route('/pessoas/:pessoasId')
     .get(pessoas.find)
     .put(pessoas.update)
     .delete(pessoas.delete);
  
  api.param('pessoaId', pessoas.pessoaById);
}