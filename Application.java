import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroLeitor leitores = new CadastroLeitor();
        CadastroLivro livros = new CadastroLivro();
        
        System.out.println("Selecione o idioma de sua preferência:");
        System.out.println("(Select your preferred language:)");
        System.out.println("\n1 – Português");
        System.out.println("2 – English");
        
        int lingua = teclado.nextInt();
        teclado.nextLine();
        
        while (lingua >= 3 || lingua <= 0) {
            System.out.println ("### ERROR ###");
            System.out.println ("Por favor, digite um nº válido:");
            System.out.println ("(Please, enter a valid number:)");
            System.out.println("\n1 – Português");
            System.out.println("2 – English");
            lingua = teclado.nextInt();
            teclado.nextLine();
        }
        
        switch (lingua) {
            case 1:
                System.out.print('\u000C');
                System.out.println("    _____");
                System.out.println("   /    /|_ ___________________________________________");
                System.out.println("  /    // /|                                          /|");
                System.out.println(" (====|/ //   Bem-vindo(a) à Biblioteca Municipal!   / |");
                System.out.println("  (=====|/    Vamos dar inicio ao seu atendimento:  / .|");
                System.out.println(" (====|/                                           / /||");
                System.out.println("/_________________________________________________/ / ||");
                System.out.println("|  _____________________________________________  ||  ||");
                System.out.println("| ||                                            | ||");
                System.out.println("| ||                                            | ||");
                System.out.println("| |                                             | |");
                
                
                opcoes(teclado, livros, leitores);
                
            break;
            case 2:
                System.out.print('\u000C');
                System.out.println("    _____");
                System.out.println("   /    /|_ ___________________________________________");
                System.out.println("  /    // /|                                          /|");
                System.out.println(" (====|/ //   Welcome to the Public Library!         / |");
                System.out.println("  (=====|/    Let's start your service:             / .|");
                System.out.println(" (====|/                                           / /||");
                System.out.println("/_________________________________________________/ / ||");
                System.out.println("|  _____________________________________________  ||  ||");
                System.out.println("| ||                                            | ||");
                System.out.println("| ||                                            | ||");
                System.out.println("| |                                             | |");
                
                
                options(teclado, livros, leitores);
                
            break;
        }        
    }
    
    public static void opcoes (Scanner teclado, CadastroLivro livros, CadastroLeitor leitores){
        Random matricula = new Random();
        while(true){
            exibirMenu();
            int opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1: // incluir leitor
                    System.out.print('\u000C');
                    System.out.println("OPÇÃO ESCOLHIDA – Inserir leitor");
                    
                    System.out.println("\nInforme o nome do novo leitor: ");
                    String nome = teclado.nextLine();
                    System.out.println("Informe o email do novo leitor: ");
                    String email = teclado.nextLine();
                    int mat = matricula.nextInt(100);
                    do {
                        mat = matricula.nextInt(100);
                    } while (leitores.verificaMatricula(mat));
                    Leitor novoLeitor = new Leitor(mat, nome, email);
                    if (leitores.adicionaLeitor(novoLeitor)) {
                        System.out.println("Leitor inserido com sucesso!");
                        System.out.println(novoLeitor);
                    } else {
                        System.out.println("ERRO" + 
                        "\nNão foi possível cadastrar o(a) leitor(a) '" + nome + "'." +
                        "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                    break;
                case 2: // remover o leitor
                    System.out.print('\u000C');
                    System.out.println("OPÇÃO ESCOLHIDA – Excluir leitor");
                    
                    System.out.println("\nInforme o nome do leitor que precisa ser apagado: ");
                    nome = teclado.nextLine();
                    if (leitores.retiraLeitor(nome)) {
                        System.out.println("Cadastro de '" + nome + "' removido com sucesso!");
                    } else {
                        System.out.println("ERRO!" + "\nNenhum leitor com o nome de '" + nome + 
                        "' encontrado no sistema." + "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                    break;
                case 3: // mostrar leitores
                System.out.print('\u000C'); 
                System.out.println("OPÇÃO ESCOLHIDA – Mostrar leitores");
                
                    System.out.println("\n • Leitores cadastrados na Biblioteca: • ");
                    leitores.mostraLeitores();
                    esperarEnter(teclado);
                    break;
                case 4: // pesquisar leitor por nome
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Pesquisar leitor por nome");
                
                    System.out.println("\nInforme o nome do leitor que deseja pesquisar: ");
                    nome = teclado.nextLine();
                    Leitor leitorPesquisado = leitores.buscaLeitorPeloNome(nome);
                    if (leitorPesquisado != null) {
                        System.out.println("Leitor encontrado:\n" + leitorPesquisado);
                    } else {
                        System.out.println("Leitor não encontrado.");
                    }
                    esperarEnter(teclado);
                    break;
                case 5: // incluir livro
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Adicionar livro");
                    
                    System.out.println("\nInforme o nome do livro que deseja adicionar: ");
                    String nomeLivro = teclado.nextLine();
                    System.out.println("Informe a quantidade de exemplares que esse livro possui: ");
                    int exemplares = teclado.nextInt();
                    System.out.println("Crie um código para o cadastro do livro: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine();
                    Livro novoLivro = new Livro(codigo, nomeLivro, exemplares);
                    if (livros.adicionaLivro(novoLivro)) {
                        System.out.println("Livro adicionado com sucesso!");
                        System.out.println(novoLivro);
                    } else {
                        System.out.println("ERRO" + 
                        "\nNão foi possível cadastrar o livro '" + nomeLivro + "'." +
                        "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                    break;
                case 6: // excluir livros
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Excluir livro");
                    
                    System.out.println ("\nInforme o nome do livro que precisa ser apagado:");
                    nomeLivro = teclado.nextLine();
                    if (livros.apagaLivro(nomeLivro)) {
                        System.out.println ("O livro cadastrado foi removido com sucesso!");
                    } else {
                        System.out.println ("ERRO" + 
                        "\nNão foi possível remover o cadastro do livro '" + nomeLivro + "'." + 
                        "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    break;
                case 7: // mostrar livros
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Mostrar livros");
                    
                    System.out.println("\n • Estante de livros • ");
                    livros.mostraLivros();
                    esperarEnter(teclado);
                    break;
                case 8: // pesquisar nome do livro
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Pesquisar livro por nome");
                    
                    System.out.println("\nInforme o nome do livro que deseja pesquisar: ");
                    nomeLivro = teclado.nextLine();
                    Livro livroPesquisado = livros.buscaLivroPeloNome(nomeLivro);
                    if (livroPesquisado == null) {
                        System.out.println("O livro \"" + nomeLivro + "\" não foi encontrado no sistema.");
                    } else {
                        System.out.println("O livro foi encontrado\n" + livroPesquisado);
                    }
                    esperarEnter(teclado);
                    break;
                case 9: // retirar livro
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Retirar livro");
                
                System.out.println ("\nInforme o nome do leitor que deseja retirar um livro: ");
                nome = teclado.nextLine();
                System.out.println ("Informe o nome do livro que o leitor deseja retirar: ");
                nomeLivro = teclado.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() != null) {
                    System.out.println ("O leitor já tem um livro em empréstimo com a biblioteca.\nCaso ele deseja retirar outro livro, deve devolver o outro antes.");
                } else {
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(livros.buscaLivroPeloNome(nomeLivro));
                    if (livros.buscaLivroPeloNome(nomeLivro).retirada()) {
                        System.out.println ("O livro foi retirado com sucesso!");
                    } else {
                        System.out.println ("Não foi possível retirar o livro!" + "\nO livro não possui cópias disponíveis.");
                    }
                }
                    esperarEnter(teclado);
                    break;
                case 10: // devolver livro
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Devolver livro");
                
                System.out.println("\nInforme o nome do leitor que deseja devolver um livro:");
                nome = teclado.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() == null) {
                    System.out.println ("O leitor não tem nenhum empréstimo na Biblioteca.");
                } else {
                    livros.buscaLivroPeloNome(leitores.buscaLeitorPeloNome(nome).getLivroRetirado().getNomeLivro()).devolucao();
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(null);
                    System.out.println ("O livro foi devolvido com sucesso!");
                }
                    esperarEnter(teclado);
                    break;
                case 11: // total de exemplares
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Exemplares disponíveis");
                
                    System.out.println("\nTotal de exemplares disponíveis: " + livros.totalExemplares());
                    esperarEnter(teclado);
                    break;
                case 20:
                    System.out.print('\u000C');
                    System.out.println("   ___  _          _                 _       _ ");
                    System.out.println("  / _ \\| |__  _ __(_) __ _  __ _  __| | ___ | |");
                    System.out.println(" | | | | '_ \\| '__| |/ _` |/ _` |/ _` |/ _ \\| |");
                    System.out.println(" | |_| | |_) | |  | | (_| | (_| | (_| | (_) |_|");
                    System.out.println("  \\___/|_.__/|_|  |_|\\__, |\\__,_|\\__,_|\\___/(_)");
                    System.out.println("                     |___/                     ");
    
                    System.out.println("\n               Volte sempre! :)");
                    teclado.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n### Opção inválida! ###");
                    System.out.println("Verifique se o que foi digitado condiz com alguma das opções.");
                    esperarEnter(teclado);
            }
        }
    }
    
    
    // ingles
    public static void options (Scanner teclado, CadastroLivro livros, CadastroLeitor leitores) {
    Random matricula = new Random();
    while (true){
        showMenu();
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1: // include reader
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Add reader");
                
                System.out.println("\nEnter the name of the new reader: ");
                String nome = teclado.nextLine();
                System.out.println("Enter the email of the new reader: ");
                String email = teclado.nextLine();
                int mat = matricula.nextInt(100);
                do {
                    mat = matricula.nextInt(100);
                } while (leitores.verificaMatricula(mat));
                Leitor novoLeitor = new Leitor(mat, nome, email);
                if (leitores.adicionaLeitor(novoLeitor)) {
                    System.out.println("Reader successfully added!");
                    System.out.println(novoLeitor.toStringENG());
                } else {
                    System.out.println("ERROR" + 
                    "\nIt was not possible to register the reader '" + nome + "'." +
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 2: // remove reader
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Delete reader");
                
                System.out.println("\nEnter the name of the reader to be removed: ");
                nome = teclado.nextLine();
                if (leitores.retiraLeitor(nome)) {
                    System.out.println("Reader '" + nome + "' successfully removed!");
                } else {
                    System.out.println("ERROR!" + "\nNo reader with the name '" + nome + 
                    "' found in the system." + "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 3: // show readers
                System.out.print('\u000C'); 
                System.out.println("SELECTED OPTION – Show readers");
                
                System.out.println("\n • Registered readers: • ");
                leitores.showReaders();
                waitForEnter(teclado);
                break;
            case 4: // search reader by name
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Search reader by name");
                
                System.out.println("\nEnter the name of the reader to search: ");
                nome = teclado.nextLine();
                if (leitores.buscaLeitorPeloNome(nome) != null) {
                    System.out.println("Reader found:\n" + leitores.buscaLeitorPeloNome(nome).toStringENG());
                } else {
                    System.out.println("Reader not found.");
                }
                waitForEnter(teclado);
                break;
            case 5: // include book
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Add book");
                
                System.out.println("\nEnter the name of the book to add: ");
                String nomeLivro = teclado.nextLine();
                System.out.println("Enter the number of copies of the book: ");
                int exemplares = teclado.nextInt();
                System.out.println("Create a code for the book: ");
                int codigo = teclado.nextInt();
                teclado.nextLine();
                Livro novoLivro = new Livro(codigo, nomeLivro, exemplares);
                if (livros.adicionaLivro(novoLivro)) {
                    System.out.println("Book successfully added!");
                    System.out.println(novoLivro.toStringENG());
                } else {
                    System.out.println("ERROR" + 
                    "\nIt was not possible to register the book '" + nomeLivro + "'." +
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 6: // remove book
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Delete book");
                
                System.out.println("\nEnter the name of the book to be removed:");
                nomeLivro = teclado.nextLine();
                if (livros.apagaLivro(nomeLivro)) {
                    System.out.println("The book was successfully removed!");
                } else {
                    System.out.println("ERROR" + 
                    "\nIt was not possible to remove the book '" + nomeLivro + "'." + 
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 7: // show books
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Show books");
                
                System.out.println("\n • Bookshelf • ");
                livros.showBooks();
                waitForEnter(teclado);
                break;
            case 8: // search book by name
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Search book by name");
                
                System.out.println("\nEnter the name of the book to search: ");
                nomeLivro = teclado.nextLine();
                Livro livroPesquisado = livros.buscaLivroPeloNome(nomeLivro);
                if (livroPesquisado == null) {
                    System.out.println("The book \"" + nomeLivro + "\" was not found in the system.");
                } else {
                    System.out.println("The book was found\n" + livros.buscaLivroPeloNome(nomeLivro).toStringENG());
                }
                waitForEnter(teclado);
                break;
            case 9: // borrow book
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Borrow book");
                
                System.out.println("\nEnter the name of the reader who wants to borrow a book: ");
                nome = teclado.nextLine();
                System.out.println("Enter the name of the book the reader wants to borrow: ");
                nomeLivro = teclado.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() != null) {
                    System.out.println("The reader already has already borrowed a book.\nIf they want to borrow another book, they must return the current one first.");
                } else {
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(livros.buscaLivroPeloNome(nomeLivro));
                    if (livros.buscaLivroPeloNome(nomeLivro).retirada()) {
                        System.out.println("The book was successfully borrowed!");
                    } else {
                        System.out.println("The book doesn't have copies available.");
                    }
                }
                waitForEnter(teclado);
                break;
            case 10: // return book
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Return book");
                
                System.out.println("\nEnter the name of the reader who wants to return a book:");
                nome = teclado.nextLine();
                if (leitores.buscaLeitorPeloNome(nome).getLivroRetirado() == null) {
                    System.out.println("The reader does not have any books on loan.");
                } else {
                    livros.buscaLivroPeloNome(leitores.buscaLeitorPeloNome(nome).getLivroRetirado().getNomeLivro()).devolucao();
                    leitores.buscaLeitorPeloNome(nome).setLivroRetirado(null);
                    System.out.println("The book was successfully returned!");
                }
                waitForEnter(teclado);
                break;
            case 11: // total copies
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Available copies");
                
                System.out.println("\nTotal available copies: " + livros.totalExemplares());
                waitForEnter(teclado);
                break;
            case 20:
                System.out.print('\u000C');
                System.out.println("  _____ _                 _     __   __          _ ");
                System.out.println(" |_   _| |__   __ _ _ __ | | __ \\ \\ / /__  _   _| |");
                System.out.println("   | | | '_ \\ / _` | '_ \\| |/ /  \\ V / _ \\| | | | |");
                System.out.println("   | | | | | | (_| | | | |   <    | | (_) | |_| |_|");
                System.out.println("   |_| |_| |_|\\__,_|_| |_|_|\\_\\   |_|\\___/ \\__,_(_)");
                System.out.println("                                                   ");
                
                System.out.println("\n               Come back anytime! :)");
                teclado.close();
                System.exit(0);
                break;
            default:
                System.out.println("\n### Invalid option! ###");
                System.out.println("Please check if the option entered matches any available options.");
                waitForEnter(teclado);
        }
    }
}

    // portugues
    private static void exibirMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Digite o nº da opção que deseja executar:");
        System.out.println("\n-• LEITORES •-");
        System.out.println("\n1 – Adicionar leitor");
        System.out.println("2 – Excluir leitor");
        System.out.println("3 – Mostrar leitores");
        System.out.println("4 – Pesquisar leitor por nome");
        System.out.println("\n-----------------------------------------");
        System.out.println("-• LIVROS •-");
        System.out.println("\n5 – Adicionar livro");
        System.out.println("6 – Excluir livro");
        System.out.println("7 – Mostrar livros");
        System.out.println("8 – Pesquisar livro por nome");
        System.out.println("9 – Retirar livro");
        System.out.println("10 – Devolver livro");
        System.out.println("11 – Exemplares disponíveis");
        System.out.println("-----------------------------------------");
        System.out.println("\n20 – Sair do programa");
    }
    
    // ingles
    private static void showMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Enter the number of the option you want to execute:");
        System.out.println("\n-• READERS •-");
        System.out.println("\n1 – Add reader");
        System.out.println("2 – Delete reader");
        System.out.println("3 – Show readers");
        System.out.println("4 – Search reader by name");
        System.out.println("\n-----------------------------------------");
        System.out.println("-• BOOKS •-");
        System.out.println("\n5 – Add book");
        System.out.println("6 – Delete book");
        System.out.println("7 – Show books");
        System.out.println("8 – Search book by name");
        System.out.println("9 – Borrow book");
        System.out.println("10 – Return book");
        System.out.println("11 – Available copies");
        System.out.println("-----------------------------------------");
        System.out.println("\n20 – Exit the program");
    }


    private static void esperarEnter(Scanner teclado) {
        System.out.println("\nPressione a tecla Enter para acessar o menu...");
        teclado.nextLine();
        System.out.print('\u000C');
    }

    private static void waitForEnter(Scanner teclado) {
        System.out.println("\nPress the Enter key to display the menu...");
        teclado.nextLine();
        System.out.print('\u000C');
    }
}
