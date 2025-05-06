package animal_e_dono.dono;

public class Dono {
    private final String nome;
    private String telefone;
    private String endereco;
    private final String cpf;

    public Dono(String cpf, String nome, String telefone, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void atualizarCadastro(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String consultarDonos() {
        return "Dono: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }
}