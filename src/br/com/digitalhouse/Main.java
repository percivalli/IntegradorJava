package br.com.digitalhouse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("A0001","Java para Idiotas","Jessica",2019,2,"999999999-9", 24.99);
        Livro livro2 = new Livro("A0002","Android para Retardados Mentais","Roberto",2016,5,"888888888-9", 24.99);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);

        Scanner in = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Selecione uma operacao");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Consultar Livro");
            System.out.println("3 - Venda Livro");
            System.out.println("4 - Cadastrar Coleção");
            System.out.println("5 - Venda Coleção");
            System.out.println("6 - Sair");
            try {
                opcao = Integer.parseInt(in.nextLine());
                if (opcao > 0 && opcao < 6) {
                    processar(opcao,biblioteca);

                } else if (opcao > 6) {
                    System.out.println("Opção inválida!");
                    opcao = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                opcao = -1;
            }
        }

    }

    public static void processar(int opcaoSelecionada,Biblioteca biblioteca){
        System.out.println(opcaoSelecionada);

        switch (opcaoSelecionada) {
            case 1:
                System.out.println("---- Cadastrar Livro ----");
                biblioteca.cadastrarLivro();
                break;
            case 2:
                System.out.println("---- Consultar Livro ----");
                biblioteca.consultarLivro();
                break;
            case 3:
                System.out.println("---- Venda Livro ----");
                biblioteca.venderLivro();
                break;
        }
    }
}