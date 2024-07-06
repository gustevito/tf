import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
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

        
        /*System.out.println("Boas vindas à Biblioteca Municipal!");
        System.out.println();
        System.out.println("    _/      Y      \\_");
        System.out.println("   // ~~ ~~ | ~~ ~  \\");
        System.out.println("  // ~ ~ ~~ | ~~~ ~~ \\");
        System.out.println(" //________.|.________\\");
        System.out.println("`----------`-'----------'");
        System.out.println();
        System.out.println("Vamos dar inicio ao seu atendimento...");
        System.out.println();*/
        
        
        
        
        while (true) {
            System.out.println("\n---------------------");
            System.out.println("Digite o nº da opção que deseja executar:");
            System.out.println("\n • Leitores • ");
            System.out.println("1 – Incluir leitor");
            System.out.println("2 – Remover leitor");
            System.out.println("3 – Mostrar leitores");
            System.out.println("4 – Pesquisar leitor por nome");
            System.out.println("\n • Livros • ");
            System.out.println("5 – Incluir livro");
            System.out.println("6 – Mostrar livros");
            System.out.println("7 – Pesquisar livro por nome");
            System.out.println("8 – Retirar livro");
            System.out.println("9 – Devolver livro");
            System.out.println("10 – Exemplares disponiveis");
            System.out.println();
            System.out.println("20 – Sair do programa");

            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1: // incluir leitor
                    System.out.print('\u000C');
                    System.out.println("Informe a matrícula do leitor:");
                    int matricula = teclado.nextInt();
                    teclado.nextLine(); // Consumir a nova linha
                    System.out.println("Informe o nome do leitor:");
                    String nomeLeitor = teclado.nextLine();
                    System.out.println("Informe o e-mail do leitor:");
                    String emailLeitor = teclado.nextLine();
                    Leitor leitor = new Leitor(matricula, nomeLeitor, emailLeitor);
                    leitores.adicionaLeitor(leitor);
                    break;
                case 2: // remover o leitor
                    System.out.print('\u000C');
                    System.out.println ("Informe o nome do leitor que precisa ser apagado: ");
                    String nome = teclado.nextLine();
                    if (leitores.retiraLeitor(nome)) {
                        System.out.println ("Cadastro de " + nome + " removido com sucesso.");
                    } else {
                        System.out.println ("### Erro ao cancelar o cadastro do leitor! ###");
                    }
                break;
                case 3: // mostrar leitores
                    System.out.print('\u000C'); 
                    System.out.println(" • Leitores cadastrados na Biblioteca: • ");
                    leitores.mostraLeitores();
                    break;
                case 4: // pesquisar leitor por nome
                    System.out.print('\u000C'); 
                    System.out.println("Informe o nome do leitor que deseja pesquisar:");
                    String nomeBuscaLeitor = teclado.nextLine();
                    Leitor leitorEncontrado = leitores.buscaLeitorPeloNome(nomeBuscaLeitor);
                    if (leitorEncontrado != null) {
                        System.out.println("Leitor encontrado: " + leitorEncontrado.getNome());
                    } else {
                        System.out.println("Leitor não encontrado!");
                    }
                    break;
                case 5: // incluir livro
                    System.out.print('\u000C');
                    System.out.println("Informe o código do livro:");
                    int codigo = teclado.nextInt();
                    teclado.nextLine(); // Consumir a nova linha
                    System.out.println("Informe o nome do livro:");
                    String nomeLivro = teclado.nextLine();
                    System.out.println("Informe a quantidade de exemplares:");
                    int exemplares = teclado.nextInt();
                    Livro livro = new Livro(codigo, nomeLivro, exemplares);
                    livros.adicionaLivro(livro);
                    break;
                case 6: // mostrar livros
                    System.out.print('\u000C');
                    System.out.println(" • Estante de livros • ");
                    livros.mostraLivros();
                    break;
                case 7: // pesquisar nome do livro
                    System.out.print('\u000C');
                    System.out.println("Informe o nome do livro:");
                    String nomeBuscaLivro = teclado.nextLine();
                    Livro livroEncontrado = livros.buscaLivroPeloNome(nomeBuscaLivro);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado.getNomeLivro());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
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
                    break;
                case 10: // total de exemplares
                    System.out.print('\u000C');
                    System.out.println("Exemplares disponiveis: " + livros.totalExemplares());
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
            }
        }
    }
}