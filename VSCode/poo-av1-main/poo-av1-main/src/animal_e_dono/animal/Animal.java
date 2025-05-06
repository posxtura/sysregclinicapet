package animal_e_dono.animal;

public class Animal {
    protected String especie;
    protected String raca;
    protected String tipo_animal;
    protected String cor;
    protected int num_pata;
    protected String barulho;//qual é o barulho do animal???
    
    
    public void informacoesAnimal(String especie, String raca, String tipo_animal,String cor,int pata,String barulho) {
        this.especie = especie;
        this.raca = raca;
        this.tipo_animal = tipo_animal;
        this.cor=cor;
        this.num_pata=pata;
        this.barulho=barulho;
    }
    public String getEspecie() {
        return especie;
    }
    public String getRaca() {
        return raca;
    }
    public String getTipo_animal() {
        return tipo_animal;
    }
    public int getPata(){
        return num_pata;
    }
    public String getBarulho(){
        return barulho;
    }
    public void setCor(String cor){
        this.cor=cor;
    }

        
    
}
//tralalero tralala
