package service;

import model.Funcionario;
import util.Formatador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioService {

    private List<Funcionario> funcionarios;

    public FuncionarioService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void removerPorNome(String nome) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(i);
                break;
            }
        }
    }

    public void imprimirTodos() {
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    public void aplicarAumento(BigDecimal percentual) {
        BigDecimal fator = BigDecimal.ONE.add(percentual);
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(fator);
            f.setSalario(novoSalario);
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();

        for (Funcionario f : funcionarios) {
            String funcao = f.getFuncao();

            if (!mapa.containsKey(funcao)) {
                mapa.put(funcao, new ArrayList<>());
            }

            mapa.get(funcao).add(f);
        }

        return mapa;
    }

    public void imprimirAgrupadosPorFuncao() {
        Map<String, List<Funcionario>> agrupados = agruparPorFuncao();

        for (String funcao : agrupados.keySet()) {
            System.out.println("\n--- Função: " + funcao + " ---");
            List<Funcionario> lista = agrupados.get(funcao);
            for (Funcionario f : lista) {
                System.out.println(f);
            }
        }
    }

    public void imprimirAniversariantesPorMeses(int mes1, int mes2) {
        for (Funcionario f : funcionarios) {
            int mesNascimento = f.getDataNascimento().getMonthValue();
            if (mesNascimento == mes1 || mesNascimento == mes2) {
                System.out.println(f);
            }
        }
    }

    public void imprimirMaisVelho() {
        if (funcionarios.isEmpty()) return;

        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade + " anos");
    }

    public void imprimirOrdemAlfabetica() {
        List<Funcionario> listaOrdenada = new ArrayList<>(funcionarios);
        listaOrdenada.sort((f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()));

        for (Funcionario f : listaOrdenada) {
            System.out.println(f);
        }
    }

    public BigDecimal calcularTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }
        return total;
    }

    public void imprimirSalariosMinimos(BigDecimal salarioMinimo) {
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + Formatador.formatarValor(qtdSalarios) + " salários mínimos.");
        }
    }
}