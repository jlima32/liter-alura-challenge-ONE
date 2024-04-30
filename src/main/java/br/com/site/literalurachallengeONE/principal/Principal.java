package br.com.site.literalurachallengeONE.principal;

import br.com.site.literalurachallengeONE.model.Autor;
import br.com.site.literalurachallengeONE.model.DadosLivro;
import br.com.site.literalurachallengeONE.model.Livro;
import br.com.site.literalurachallengeONE.model.Resultado;
import br.com.site.literalurachallengeONE.repository.AutorRepository;
import br.com.site.literalurachallengeONE.repository.LivroRepository;
import br.com.site.literalurachallengeONE.service.ConsumoApi;
import br.com.site.literalurachallengeONE.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private LivroRepository repositorioLivro;
    private AutorRepository repositorioAutor;
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    public Principal(LivroRepository repositorioLivro, AutorRepository repositorioAutor) {
        this.repositorioLivro = repositorioLivro;
        this.repositorioAutor = repositorioAutor;
    }

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

    private Autor buscarLivro() {
        DadosLivro dadosLivro = getDadosLivro();
        if (dadosLivro != null && dadosLivro.getResults() != null && !dadosLivro.getResults().isEmpty()) {
            Resultado resultado = dadosLivro.getResults().get(0);
            var title = resultado.getTitulo();
            var downloads = resultado.getNumeroDownloads();
            var autor = resultado.getAutor().get(0);
            var idioma = resultado.getIdioma().get(0);
            System.out.println("\n---- LIVRO ----");
            System.out.println("Titulo: " + title);
            System.out.println("Autor: " + autor.getNome());
            System.out.println("Idioma: " + idioma);
            System.out.println("Número de Downloads: " + downloads);
            System.out.println("-------------------");
            Livro livro = new Livro(resultado);
            Autor novoAutor = verificaCadastroAutor(autor);
            livro.setAutor(novoAutor);
            repositorioLivro.save(livro);

        } else {
            System.out.println("Nenhum Livro encontrado");
        }

        exibeMenu();
        return null;
    }

    private Autor verificaCadastroAutor(Autor autor){
        Autor autorCadastrado = repositorioAutor.findByNome(autor.getNome());
        if(autorCadastrado != null){
            return autorCadastrado;
        }else{
            return repositorioAutor.save(autor);
        }
    }

    private DadosLivro getDadosLivro(){
        System.out.println("Digite o nome do Livro para buscar: ");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        return conversor.obterDados(json, DadosLivro.class);
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
