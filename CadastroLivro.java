import java.util.ArrayList;
public class CadastroLivro {
    private ArrayList<Livro> livros;

    public CadastroLivro() {
        livros = new ArrayList<>();
    }

    public boolean adicionaLivro(Livro livro) {
        return livros.add(livro);
    }

    public Livro buscaLivroPeloNome(String nome) {
        for (Livro livro : livros) {
            if (livro.getNome().equals(nome)) {
                return livro;
            }
        }
        return null;
    }

    public void mostraLivros() {
        for (Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome() + 
            "\nCódigo: " + livro.getCodigo() +
            "\nExemplares: " + livro.getExemplares());
        }
    }

    public int totalExemplares() {
        int total = 0;
        for (Livro livro : livros) {
            total += livro.getExemplares();
        }
        return total;
    }
}