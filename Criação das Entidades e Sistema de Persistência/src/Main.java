/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author JPZanirati
 */

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));

        try {
            repo1.persistir("pessoas_fisicas.txt");
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        } catch (IOException e) {
            System.err.println("Erro ao persistir dados de Pessoa Fisica: " + e.getMessage());
        }

        PessoaFisicaRepo repo2;
        
        try {
            repo2 = PessoaFisicaRepo.recuperar("pessoas_fisicas.txt");
            System.out.println("Dados de Pessoa Fisica Recuperados.");

            for (PessoaFisica pessoa : repo2.obterTodos()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao recuperar dados de Pessoa Fisica: " + e.getMessage());
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));

        try {
            repo3.persistir("pessoas_juridicas.txt");
            System.out.println("Dados de Pessoa Juridica Armazenados.");
        } catch (IOException e) {
            System.err.println("Erro ao persistir dados de Pessoa Juridica: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4;

        try {
            repo4 = PessoaJuridicaRepo.recuperar("pessoas_juridicas.txt");
            System.out.println("Dados de Pessoa Juridica Recuperados.");

            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CNPJ: " + pessoa.getCnpj());
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao recuperar dados de Pessoa Juridica: " + e.getMessage());
        }
    }
}