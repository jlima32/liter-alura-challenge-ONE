package br.com.site.literalurachallengeONE.principal;

import br.com.site.literalurachallengeONE.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    public void exibeMenu(){
        var opcao = -1;
        var menu = """
                1 - Buscar Livro Pelo Título
                2 - Listar Livros Registrados
                3 - Listar Autores Registrados
                4 - Listar Autores Vivos em um Determinado Ano
                5 - Listar Livros em um Determinado Idioma
                0 - Encerrar Aplicação
                """;

        System.out.println(menu);
        opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao){
            case 1:
                buscarLivro();
                break;
            case 2:
                listarLivros();
                break;
            case 3:
                listarAutores();
                break;
            case 4:
                listarAutoresVivosAno();
                break;
            case 5:
                listarLivrosIdioma();
                break;
            case 0:
                System.out.println("Encerrando a Aplicação...");
                break;
            default:
                System.out.println("Opção Inválida!");
        }

    }

    private void buscarLivro() {
        var json = consumo.obterDados("https://gutendex.com/books/?search=dom%20casmurro");
        System.out.println(json);
    }

    private void listarLivros() {
    }

    private void listarAutores() {
    }

    private void listarAutoresVivosAno() {
    }

    private void listarLivrosIdioma() {
    }




}
