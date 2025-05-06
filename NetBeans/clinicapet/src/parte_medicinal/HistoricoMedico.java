package parte_medicinal;

import animal_e_dono.animal.Pet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoMedico {
    private final Pet pet;
    private final List<Consulta> consultas;
    private final List<Vacina> vacinas;

    public HistoricoMedico(Pet pet) {
        this.pet = pet;
        this.consultas = new ArrayList<>();
        this.vacinas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarVacina(Vacina vacina) {
        vacinas.add(vacina);
    }

    public String consultarHistoricoCompleto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico médico de ").append(pet.getNome()).append(":\n");

        sb.append("Consultas:\n");
        for (Consulta consulta : consultas) {
            sb.append(consulta.listarConsultas()).append("\n");
        }

        sb.append("Vacinas:\n");
        for (Vacina vacina : vacinas) {
            sb.append(vacina.consultarVacinas()).append("\n");
        }

        return sb.toString();
    }

    // Método para salvar o histórico médico em um arquivo de texto
    public void salvarHistoricoEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            writer.write("Histórico médico de " + pet.getNome() + ":\n");

            writer.write("Consultas:\n");
            for (Consulta consulta : consultas) {
                writer.write(consulta.listarConsultas() + "\n");
            }

            writer.write("Vacinas:\n");
            for (Vacina vacina : vacinas) {
                writer.write(vacina.consultarVacinas() + "\n");
            }

            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico médico: " + e.getMessage());
        }
    }

    // Método para carregar o histórico médico de um arquivo de texto (não implementado neste momento)
    public void carregarHistoricoDeArquivo(String caminhoArquivo) {
        // Implementação futura, se necessário
    }
}
