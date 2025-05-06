package animal_e_dono.animal;

import animal_e_dono.dono.Dono;
import java.util.ArrayList;
import java.util.List;
import parte_medicinal.HistoricoMedico;


public class Pet extends Animal{  
    private int id;
    private String nome;
    private String dataNascimento;
    private final Dono dono;
    private int idade;
    private final List<HistoricoMedico> historicoMedico = new ArrayList<>();
    //se for mudar so nome idade
    public void atualizarCadastro(int idade,String nome){
        this.idade = idade;
        this.nome =nome;
    }
    //se o dono ter confundido a especie/tipo de animal
    public void atualizarCadastro(int idade,String nome,String cor,String especie,String tipoAnimal){
        this.idade = idade;
        this.nome =nome;
        this.cor= cor;
        this.especie=especie;
        this.tipo_animal=tipoAnimal;
    }

    //construtores do pet
    public Pet(int id, String nome,Dono dono){
        this.id =id;
        this.nome=nome;
        this.dono=dono;
    }//se o dono souber nada

    public Pet(int id, String nome,Dono dono, String tipoAnimal, String especie, String raca,String cor,int pata,String barulho) {
        informacoesAnimal(especie, raca, tipoAnimal, cor,pata,barulho);
        this.id = id;
        this.nome = nome;
        this.dono = dono;
    } //se o dono nao souber a idade/data de nascimento

    public Pet(int id, String nome, String dataNascimento, Dono dono,int idade,String tipoAnimal,String especie, String raca,String cor,int pata,String barulho) {
        informacoesAnimal(especie, raca, tipoAnimal, cor,pata,barulho);
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.dataNascimento = dataNascimento;
        this.idade=idade;
    }//se o dono souber tudo

    
    public void atualizarHistoricoMedico(HistoricoMedico historico) {
        historicoMedico.add(historico);
    }

    public List<HistoricoMedico> consultarHistorico() {
        return historicoMedico;
    }

    public void setBarulho(String barulho){
        this.barulho=barulho;
    }
    //getters
    @Override
    public String getEspecie() {
        return especie;
    }

    @Override
    public String getRaca() {
        return raca;
    }

    @Override
    public String getTipo_animal() {
        return tipo_animal;
    }

    public String gaetDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Dono getDono() {
        return dono;
    }

    // setter para ID
    public void setId(int id) {
        this.id = id;
    }
}
//tung tung tung tung sahur
//os menor quente mandou nesse code