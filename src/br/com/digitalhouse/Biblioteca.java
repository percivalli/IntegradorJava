package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    List<Livro> livros = new ArrayList<>();

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public Biblioteca() {
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);

    }

    public void cadastrarLivro() {
        String codigo;
        String titulo;
        String autor;
        int lancamento;
        int qtdestoque;
        String ISBN;
        Double preco;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o código: ");
            codigo = scanner.next();

            System.out.println("Digite o título: ");
            titulo = scanner.next();

            System.out.println("Digite o autor: ");
            autor = scanner.next();

            System.out.println("Digite o ano de lançamento: ");
            lancamento = scanner.nextInt();

            System.out.println("Digite a quantidade: ");
            qtdestoque = scanner.nextInt();

            System.out.println("Digite o código ISBN: ");
            ISBN = scanner.next();

            System.out.println("Digite o preço: ");
            preco = scanner.nextDouble();

            Livro livro = new Livro(codigo, titulo, autor, lancamento, qtdestoque, ISBN, preco);

            if (livros.contains(livro)) {
                System.out.println("CÓDIGO DE LIVRO JÁ CADASTRADO!\n");
            } else {
                this.livros.add(livro);
                System.out.println("NOVO LIVRO CADASTRADO!\n");
            }

        } catch (Exception e) {
            System.out.println("ERRO AO CADASTRAR!"+e.getMessage());
        }

    }

    public void consultarLivro() {
        String codigo;
        Scanner scannerA = new Scanner(System.in);
        System.out.println("Digite o código (letra e números): ");
        codigo = scannerA.next();

        int posLivro = consultarCodigo(codigo);

        if (posLivro != -1) {
            System.out.println("--- LIVRO ---");
            System.out.println(livros.get(posLivro).toString());
        }else{
            System.out.println("LIVRO NÃO ENCONTRADO! \n");
        }
    }

    public void venderLivro() {
        String codigo;
        Scanner scannerA = new Scanner(System.in);
        System.out.println("Digite o código (números): ");
        codigo = scannerA.next();

        int posLivro = consultarCodigo(codigo);

        if (posLivro != -1) {
            int quantidade;
            Scanner scannerB = new Scanner(System.in);
            System.out.println("Digite a quantidade: ");
            quantidade = scannerB.nextInt();

            System.out.println("--- VENDA LIVRO ---");
            livros.get(posLivro).baixaQuantidade(quantidade);
        }else{
            System.out.println("LIVRO NÃO ENCONTRADO! \n");
        }
    }

    public int consultarCodigo(String codigo){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;

    }
}