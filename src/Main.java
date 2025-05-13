import java.util.ArrayList;
import java.util.Scanner;

/*
Projeto primeira fase:
Este sistema permitirá ao usuário gerenciar uma lista de livros em uma biblioteca usando.

O sistema permitirá:
    1 - Adicionar livros
    2 - Pesquisar por título
    3 - Excluir livros
    4- Listar todos os livros cadastrados. */


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> listaLivros = new ArrayList<>();
        ArrayList<String> listaAutores = new ArrayList<>();

        while (true) {
            System.out.println("Bem vindo à biblioteca Unifacisa!");
            System.out.println("""
                Escolha uma opção:
                1. Adicionar livros
                2. Pesquisar livro por título
                3. Excluir livro
                4. Listar livros cadastrados
                5. Sair
                Digite a opção desejada: 
                """);
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    //Método em que o usuário adiciona livro e autor
                    adicionarLivros(scan, listaLivros, listaAutores);
                    break;
                case 2:
                    //Método em que o usuário busca o livro pelo título
                    pesquisarLivros(scan, listaLivros, listaAutores);
                    break;
                case 3:
                    //Método em que o usuário exclui livro pelo título
                    excluirLivros(scan, listaLivros, listaAutores);
                    break;
                case 4:
                    //Método em que o usuário pode listar
                    listarLivros(listaLivros, listaAutores);
                    break;
                // Sair do sistema
                case 5:
                    System.out.println("Saindo...");
                    return;
                // Mensagem de erro
                default:
                    System.out.println("Opção inválida! Digite um número de 1 a 5!");
                    break;
            }
        }
    }
    public static void adicionarLivros (Scanner scan, ArrayList<String> livros, ArrayList<String> autores) {
        System.out.println("Você selecionou o menu para adicionar livros!");
        System.out.println("Informe o título do livro: ");
        String tituloLivro = scan.nextLine();


        System.out.println("Informe o nome do autor do livro: ");
        String autorLivro = scan.nextLine();

        if (!tituloLivro.isEmpty() && !autorLivro.isEmpty()) {
        autores.add(autorLivro);
        livros.add(tituloLivro);
        System.out.println("Livro adicionado com sucesso!");

        } else {
            System.out.println("Erro: título e autor são obrigatórios!");
        }
    }

    public static void pesquisarLivros(Scanner scan, ArrayList<String> listaLivros, ArrayList<String> listaAutores) {
        System.out.println("Você selecionou o menu para buscar livros!");
        System.out.println("Informe o título do livro a ser encontrado: ");
        String tituloLivro = scan.nextLine();

        boolean livroEncontrado = false;

        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).equalsIgnoreCase(tituloLivro)) {
                System.out.println("Livro encontrado! ");
                System.out.println("Título: " + listaLivros.get(i));
                System.out.println("Autor: " + listaAutores.get(i));
                livroEncontrado = true;
                return;
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void excluirLivros(Scanner scan, ArrayList<String> listaLivros, ArrayList<String> listaAutores) {
        System.out.println("Você selecionou o menu para excluir livros!");
        System.out.println("Digite o nome do livro a ser excluído:");
        String livroExcluir = scan.nextLine();

        for (int i = 0; i < listaLivros.size(); i++ ) {
            if (listaLivros.get(i).equalsIgnoreCase(livroExcluir)) {
                listaLivros.remove(i);
                listaAutores.remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    public static void listarLivros(ArrayList<String> livros, ArrayList<String> autores) {

        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
        } else {
            System.out.println("Lista de livros cadastrados:");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("- Título: " + livros.get(i) + "\n"+ "Autor: " + autores.get(i));
            }
        }
    }
}