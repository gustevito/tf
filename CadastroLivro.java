public class CadastroLivro {
    private int index;
    private Livro livro[];

    // Método construtor;
    public CadastroLivro() {
        this.index = 0;
        this.livro = new Livro[10];
    }
    
    // Métodos para inserir e remover um livro no vetor;
    public boolean adicionaLivro (Livro livro) {
        if (this.index < this.livro.length) {
            this.livro[this.index] = livro;
            this.index++;
            return true;
        }
        return false;
    }
    public boolean apagaLivro (String nome) {
        int pos = 0;
        boolean achou = false;
        
        for (int i = 0; i < this.index; i++) {
            if (this.livro[i].getNomeLivro().equalsIgnoreCase(nome)) {
                pos = i;
                achou = true;
                break;
            }
        }
        if (achou) {
            for (int i = pos; i < this.livro.length-1; i++)
            {
                this.livro[i] = this.livro[i+1];
            }
            this.livro[this.livro.length-1] = null;
            index--;
            return true;
        }
        return false;
    }
    
    // Método para buscar um livro pelo nome no vetor;
    public Livro buscaLivroPeloNome (String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.livro[i].getNomeLivro().equalsIgnoreCase(nome)) {
                return this.livro[i];
            }
        }
        return null;
    }
    
    // Método para o cálculo do total de exemplares disponíveis;
    public int totalExemplares () {
        int totalExemplares = 0;
        for (int i = 0; i < this.index; i++) {
            totalExemplares += this.livro[i].getExemplares();
        }
        return totalExemplares;
    }
    
    // Método para imprimir os dados do vetor/objeto livro;
    public void mostraLivros () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.livro[i]);
        }
    }
    public void showBooks () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.livro[i].toStringENG());
        }
    }
}