'use strict';

var mongoose = require('mongoose'),
    Pessoa = require('../models/pessoa.model');

exports.findAll = function(req, res) {
    Pessoa.find({}).exec(function(err, pessoas) {
        if (err) {
            console.error(err);
            res.status(400).json(err);
        } else {
            res.json(pessoas);
        }
    });
};
exports.find = function(req, res) {
    res.json(req.pessoa);
};
exports.create = function(req, res) {
    var pessoa = new Pessoa(req.body);
    pessoa.save(function(err) {
        if (err) {
            res.status(400).json({
                message: err
            });
        } else {
            res.json({
                message: 'Pessoa criada com sucesso',
                pessoa: pessoa
            });
        }
    });
};
exports.update = function(req, res) {
    var pessoa = req.pessoa;
    pessoa.name = req.body.name;
    pessoa.email = req.body.email;
    pessoa.save(function(err) {
        if (err) {
            res.status(400).json({
                message: err
            });
        } else {
            res.json({
                message: 'Pessoa alterada com sucesso',
                pessoa: pessoa
            });
        }
    });
};
exports.delete = function(req, res) {
    var pessoa = req.pessoa;
    pessoa.remove(function(err) {
        if (err) {
            res.status(400).json({
                message: err
            });
        } else {
            res.json({
                message: 'Pessoa removida com sucesso',
                pessoa: pessoa
            });
        }
    });
};
exports.pessoaById = function(req, res, next, pessoaId) {
    if (!mongoose.Types.ObjectId.isValid(pessoaId)) {
        res.status(400).json({
            message: 'Pessoa inválida'
        })
    }
    Pessoa.findById(pessoaId).exec(function(err, pessoa) {
        if (err) {
            res.status(404).json(err);
        }
        req.pessoa = pessoa;
        next();
    });
}