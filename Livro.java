public class Livro {
    private int codigo;
    private String nome;
    private int exemplares;

    public Livro(int codigo, String nome, int exemplares) {
        this.codigo = codigo;
        this.nome = nome;
        this.exemplares = exemplares;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void retirarExemplar() {
        if (exemplares > 0) {
            exemplares--;
        }
    }

    public void devolverExemplar() {
        exemplares++;
    }
}