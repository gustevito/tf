import java.util.ArrayList;
public class CadastroLeitor {
    private ArrayList<Leitor> leitores;

    public CadastroLeitor() {
        leitores = new ArrayList<>();
    }

    public boolean adicionaLeitor(Leitor leitor) {
        return leitores.add(leitor);
    }

    public Leitor buscaLeitorPeloNome(String nome) {
        for (Leitor leitor : leitores) {
            if (leitor.getNome().equals(nome)) {
                return leitor;
            }
        }
        return null;
    }

    public void mostraLeitores() {
        int index = 0; // index do leitor
        
        for (Leitor leitor : leitores) {
            System.out.println("\nLEITOR " + String.valueOf(1 + index++) + 
            "\nNome: " + leitor.getNome() + 
            "\nMatrícula: " + leitor.getMatricula() +
            "\nE-mail: " + leitor.getEmail() +
            "\nEmpréstimos: " + leitor.getQuantidadeEmprestimos() + 
            "\nLivro Retirado: " + (leitor.getLivroRetirado() != null ? leitor.getLivroRetirado().getNome() : "Nenhum"));
        }
    }
}