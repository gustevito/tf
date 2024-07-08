public class Leitor {
    private int matricula;
    private String nome;
    private String email;
    private int quantidadeEmprestimos;
    Livro livroRetirado;

    public Leitor(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.quantidadeEmprestimos = 0;
        this.livroRetirado = null;
    }

    // getters
    public int getMatricula() {
        return matricula;
    }   
    public String getNome() {
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getQuantidadeEmprestimos() {
        return quantidadeEmprestimos;
    }
    public Livro getLivroRetirado() {
        return livroRetirado;
    }
    
    // setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }   
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setQuantidadeEmprestimos(int quantidadeEmprestimos) {
        this.quantidadeEmprestimos = quantidadeEmprestimos;
    }
    public void setLivroRetirado(Livro livro) {
        this.livroRetirado = livro;
    }
    
    
    // toString (portugues e ingles)
    public String toString(){
        return "\nLEITOR " + 
        "\nNome: " + nome +
        "\nMatrícula: " + matricula +
        "\nE-mail: " + email +
        "\nLivro Retirado: " + (livroRetirado != null ? livroRetirado.getNomeLivro() : "Nenhum");
    }
    public String toStringENG(){
        return "\nREADER " + 
        "\nName: " + nome +
        "\nRegistration: " + matricula +
        "\nE-mail: " + email +
        "\nBook rented: " + (livroRetirado != null ? livroRetirado.getNomeLivro() : "None");
    }
}