'use strict';

var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var PessoaSchema = new Schema({
  name:{
    type: String,
    unique: true,
    required: true
  },
  email:{
    type: String
  }
  
});

module.exports = mongoose.model('Pessoa', PessoaSchema);