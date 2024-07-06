import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random matricula = new Random();
        CadastroLeitor leitores = new CadastroLeitor();
        CadastroLivro livros = new CadastroLivro();
        
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

        while (true) {
            exibirMenu();
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1: // incluir leitor
                    System.out.print('\u000C');
                    System.out.println("Informe o nome do novo leitor: ");
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
                    System.out.println("Informe o nome do leitor que precisa ser apagado: ");
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
                    System.out.println(" • Leitores cadastrados na Biblioteca: • ");
                    leitores.mostraLeitores();
                    esperarEnter(teclado);
                    break;
                case 4: // pesquisar leitor por nome
                    System.out.print('\u000C'); 
                    System.out.println("Informe o nome do leitor que deseja pesquisar: ");
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
                    System.out.println("Informe o nome do livro que deseja inserir: ");
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
                case 6: // mostrar livros
                    System.out.print('\u000C');
                    System.out.println(" • Estante de livros • ");
                    livros.mostraLivros();
                    esperarEnter(teclado);
                    break;
                case 7: // pesquisar nome do livro
                    System.out.print('\u000C');
                    System.out.println("Informe o nome do livro que deseja pesquisar: ");
                    nomeLivro = teclado.nextLine();
                    Livro livroPesquisado = livros.buscaLivroPeloNome(nomeLivro);
                    if (livroPesquisado == null) {
                        System.out.println("O livro \"" + nomeLivro + "\" não foi encontrado no sistema.");
                    } else {
                        System.out.println("O livro foi encontrado\n" + livroPesquisado);
                    }
                    esperarEnter(teclado);
                    break;
                case 8: // retirar livro
                    System.out.print('\u000C');
                    System.out.println("Informe o nome do leitor:");
                    String nomeLeitorRetira = teclado.nextLine();
                    Leitor leitorParaRetirar = leitores.buscaLeitorPeloNome(nomeLeitorRetira);
                    if (leitorParaRetirar != null && leitorParaRetirar.getLivroRetirado() == null) {
                        System.out.println("Informe o nome do livro:");
                        String nomeLivroRetira = teclado.nextLine();
                        Livro livroParaRetirar = livros.buscaLivroPeloNome(nomeLivroRetira);
                        if (livroParaRetirar != null && livroParaRetirar.getExemplares() > 0) {
                            leitorParaRetirar.setLivroRetirado(livroParaRetirar);
                            livroParaRetirar.retirarExemplar();
                            leitorParaRetirar.incrementarEmprestimos();
                            System.out.println("Livro retirado com sucesso.");
                        } else {
                            System.out.println("Livro não disponível.");
                        }
                    } else {
                        System.out.println("Leitor não encontrado ou já possui um livro retirado.");
                    }
                    esperarEnter(teclado);
                    break;
                case 9: // devolver livro
                    System.out.print('\u000C');
                    System.out.println("Informe o nome do leitor:");
                    String nomeLeitorDevolve = teclado.nextLine();
                    Leitor leitorParaDevolver = leitores.buscaLeitorPeloNome(nomeLeitorDevolve);
                    if (leitorParaDevolver != null && leitorParaDevolver.getLivroRetirado() != null) {
                        Livro livroParaDevolver = leitorParaDevolver.getLivroRetirado();
                        livroParaDevolver.devolverExemplar();
                        leitorParaDevolver.setLivroRetirado(null);
                        System.out.println("Livro devolvido com sucesso.");
                    } else {
                        System.out.println("Leitor não encontrado ou não possui livro retirado.");
                    }
                    esperarEnter(teclado);
                    break;
                case 10: // total de exemplares
                    System.out.print('\u000C');
                    System.out.println("Exemplares disponíveis: " + livros.totalExemplares());
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
                    esperarEnter(teclado);
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Digite o nº da opção que deseja executar:");
        System.out.println("\n-• LEITORES •-");
        System.out.println("1 – Incluir leitor");
        System.out.println("2 – Remover leitor");
        System.out.println("3 – Mostrar leitores");
        System.out.println("4 – Pesquisar leitor por nome");
        System.out.println("\n-• LIVROS •-");
        System.out.println("5 – Incluir livro");
        System.out.println("6 – Mostrar livros");
        System.out.println("7 – Pesquisar livro por nome");
        System.out.println("8 – Retirar livro");
        System.out.println("9 – Devolver livro");
        System.out.println("10 – Exemplares disponíveis");
        System.out.println();
        System.out.println("20 – Sair do programa");
    }

    private static void esperarEnter(Scanner teclado) {
        System.out.println("\nPressione Enter para acessar o menu...");
        teclado.nextLine();
    }
}
