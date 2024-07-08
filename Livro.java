public class Livro {
    private int codigo;
    private String nomeLivro;
    private int exemplares;

    public Livro(int codigo, String nomeLivro, int exemplares) {
        this.codigo = codigo;
        this.nomeLivro = nomeLivro;
        this.exemplares = exemplares;
    }

    // getters
    public int getCodigo() {
        return codigo;
    }
    public int getExemplares() {
        return exemplares;
    }
    public String getNomeLivro() {
        return nomeLivro;
    }
    
    // setters
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setExemplares(int exemplares){
        this.exemplares = exemplares;
    }
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }
    
    // metodos
    public boolean retirada () {
        if (this.exemplares > 0) {
            this.exemplares--;
            return true;
        }
        return false;
    }
    public void devolucao () {
        this.exemplares++;
    }
    
    // metodos toString (portugues e ingles)
    public String toString(){
        return "\nLIVRO" +
        "\nNome: " + nomeLivro +
        "\nCodigo: " + codigo +
        "\nExemplares: " + exemplares;
    }
    public String toStringENG(){
        return "\nBOOK" +
        "\nName: " + nomeLivro +
        "\nCode: " + codigo +
        "\nCopies: " + exemplares;
    }
}