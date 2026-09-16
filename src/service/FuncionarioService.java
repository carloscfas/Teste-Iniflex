package service;

import model.Funcionario;

import java.util.List;

public class FuncionarioService {

    private List<Funcionario> funcionarios;

    public FuncionarioService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}