package parte_medicinal;

import animal_e_dono.animal.Pet;

public class Vacina {
    private final int id;
    private final String nomeVacina;
    private final String dataAplicacao;
    private final Pet pet;

    public Vacina(int id, String nomeVacina, String dataAplicacao, Pet pet) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
        this.pet = pet;
    }


    public String consultarVacinas() {
        return "Vacina " + nomeVacina + " aplicada em " + pet.getNome() + " na data " + dataAplicacao;
    }


    public int getId() {
        return id;
    }


    public String getNomeVacina() {
        return nomeVacina;
    }


    public String getDataAplicacao() {
        return dataAplicacao;
    }


    public Pet getPet() {
        return pet;
    }
    
}
