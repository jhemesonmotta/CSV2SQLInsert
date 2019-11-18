package Classes;

public class Pessoa {
    private String nome;
    private String cargo;
    private int id;

    public Pessoa() {
    }

    public Pessoa(String nome, String cargo, int id) {
        this.nome = nome.replaceAll(",","").replaceAll("'","");
        this.cargo = cargo.replaceAll(",","").replaceAll("'","");
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", id=" + id +
                '}';
    }
}
