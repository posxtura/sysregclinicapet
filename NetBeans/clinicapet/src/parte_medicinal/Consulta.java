package parte_medicinal;

import animal_e_dono.animal.Pet;

public class Consulta {
    private final int id;
    private final String data;
    private final Pet pet;
    private final String veterinario;
    private String diagnostico;

    public Consulta(int id, String data, Pet pet, String veterinario, String diagnostico) {
        this.id = id;
        this.data = data;
        this.pet = pet;
        this.veterinario = veterinario;
        this.diagnostico = diagnostico;
    }
    //caso nao tenha um diagnostico
    public Consulta(int id, String data, Pet pet, String veterinario) {
        this.id = id;
        this.data = data;
        this.pet = pet;
        this.veterinario = veterinario;
    }

    public String listarConsultas() {
        return "Consulta de " + pet.getNome() + " com veterinário " + veterinario + " em " + data
                + ". Diagnóstico: " + diagnostico;
    }

    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    

    public int getId() {
        return id;
    }


    public String getData() {
        return data;
    }


    public Pet getPet() {
        return pet;
    }


    public String getVeterinario() {
        return veterinario;
    }


    public String getDiagnostico() {
        return diagnostico;
    }


    
}
