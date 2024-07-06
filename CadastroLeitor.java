public class CadastroLeitor {
    private int index;
    private Leitor leitor[];

    public CadastroLeitor() {
        this.index = 0;
        this.leitor = new Leitor[10];
    }

    public boolean adicionaLeitor(Leitor leitor) {
        if (this.index < this.leitor.length) {
            this.leitor[this.index] = leitor;
            this.index++;
            return true;
        }
        return false;
    }

    public Leitor buscaLeitorPeloNome(String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.leitor[i].getNome().equalsIgnoreCase(nome)) {
                return this.leitor[i];
            }
        }
        return null;
    }
    
    public void mostraLeitores () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.leitor[i]);
        }
    }

    /*public void mostraLeitores() {
        int index = 0; // index do leitor
        
        for (Leitor leitor : leitor) {
            System.out.println("\nLEITOR " + String.valueOf(1 + index++) + 
            "\nNome: " + leitor.getNome() + 
            "\nMatrícula: " + leitor.getMatricula() +
            "\nE-mail: " + leitor.getEmail() +
            "\nEmpréstimos: " + leitor.getQuantidadeEmprestimos() + 
            "\nLivro Retirado: " + (leitor.getLivroRetirado() != null ? leitor.getLivroRetirado().getNomeLivro() : "Nenhum"));
        }
    }*/
}