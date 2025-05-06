import animal_e_dono.animal.Pet;
import animal_e_dono.dono.Dono;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import parte_medicinal.Consulta;
import parte_medicinal.HistoricoMedico;
import parte_medicinal.Vacina;

public class Sistema {
    private final List<Dono> donos;
    private final List<Pet> pets;
    private final List<Consulta> consultas;
    private final List<Vacina> vacinas;

    // Adicionando controle de IDs únicos

    public Sistema() {
        donos = new ArrayList<>();
        pets = new ArrayList<>();
        consultas = new ArrayList<>();
        vacinas = new ArrayList<>();
    }

    public void salvarPetsEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Pet pet : pets) {
                if (!petJaSalvo(pet, caminhoArquivo)) {
                    writer.write("ID: " + pet.getId() +
                            ", Nome: " + pet.getNome() +
                            ", Dono: " + pet.getDono().getNome() + "\n");
                } else {
                    System.out.println("o pet " + pet.getNome() + " já foi cadastrado");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pets: " + e.getMessage());
        }
    }

    private boolean petJaSalvo(Pet pet, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID: " + pet.getId() + ", Nome: " + pet.getNome())) {
                    return true; 
                }
            }
        } catch (IOException e) {
            // se der erro (tipo arquivo não existir ainda), assume que não está salvo
            return false;
        }
        return false;
    }

    public void salvarConsultasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Consulta consulta : consultas) {
                if (!consultaJaSalvo(consulta, caminhoArquivo)) {
                    writer.write("ID Consulta: " + consulta.getId() +
                            ", Pet: " + consulta.getPet().getNome() +
                            ", Veterinário: " + consulta.getVeterinario() +
                            ", Data: " + consulta.getData() + "\n");
                } else {
                    System.out.println("Essa consulta já foi cadastrada");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    private boolean consultaJaSalvo(Consulta consulta, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID Consulta: " + consulta.getId() +
                        ", Pet: " + consulta.getPet().getNome() +
                        ", Veterinário: " + consulta.getVeterinario() +
                        ", Data: " + consulta.getData())) {
                    return true; 
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public void salvarVacinasEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Vacina vacina : vacinas) {
                if (!vacinaJaSalvo(vacina, caminhoArquivo)) {
                    writer.write("ID Vacina: " + vacina.getId() +
                            ", Pet: " + vacina.getPet().getNome() +
                            ", Nome Vacina: " + vacina.getNomeVacina() +
                            ", Data: " + vacina.getDataAplicacao() + "\n");
                } else {
                    System.out.println("Essa vacina já foi cadastrada!");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar vacinas: " + e.getMessage());
        }
    }

    private boolean vacinaJaSalvo(Vacina vacina, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("ID Vacina: " + vacina.getId() +
                        ", Pet: " + vacina.getPet().getNome() +
                        ", Nome Vacina: " + vacina.getNomeVacina() +
                        ", Data: " + vacina.getDataAplicacao())) {
                    return true; 
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public void salvarDonosEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            for (Dono dono : donos) {
                if (!donoJaSalvo(dono, caminhoArquivo)) {
                    writer.write("Nome: " + dono.getNome() +
                            ", Telefone: " + dono.getTelefone() +
                            ", Endereço: " + dono.getEndereco() +
                            ", Cpf: " + dono.getCpf() + "\n");
                } else {
                    System.out.println("Esse dono já foi cadastrado!");
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar donos: " + e.getMessage());
        }
    }

    private boolean donoJaSalvo(Dono dono, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("Nome: " + dono.getNome() +
                        ", Telefone: " + dono.getTelefone() +
                        ", Endereço: " + dono.getEndereco() +
                        ", Cpf: " + dono.getCpf())) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public void salvarTodosOsDados() {
        salvarPetsEmArquivo("pets.txt");
        salvarConsultasEmArquivo("consultas.txt");
        salvarVacinasEmArquivo("vacinas.txt");
        salvarDonosEmArquivo("donos.txt");
    }

    // uso do CPF como chave primária
    public void cadastrarDono(Dono dono) {
        // Verifica se o CPF já está no arquivo donos.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/donos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("Cpf: " + dono.getCpf())) {
                    System.out.println("Erro: Esse CPF já está cadastrado no sistema. Por favor, insira outro CPF.");
                    return; // Interrompe o cadastro imediatamente
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o arquivo donos.txt: " + e.getMessage());
            return; // Interrompe o cadastro em caso de erro ao acessar o arquivo
        }

        // Corrigindo mensagens redundantes e verificando corretamente se o dono já foi cadastrado
        for (Dono d : donos) {
            if (d.getCpf().equals(dono.getCpf())) {
                System.out.println("Erro: Esse CPF já foi cadastrado anteriormente.");
                return; // Impede o cadastro de um dono com CPF repetido
            }
        }

        donos.add(dono);
        salvarDonosEmArquivo("resources/donos.txt"); // Atualiza o arquivo imediatamente
        System.out.println("Dono " + dono.getNome() + " cadastrado com sucesso!");
    }

    public Dono buscarDonoPorCpf(String cpf) {
        for (Dono dono : donos) {
            if (dono.getCpf().equals(cpf)) {
                return dono;
            }
        }
        return null; 
    }

    public void cadastrarPet(Pet pet) {
        for (Pet p : pets) {
            if (p.getId() == pet.getId() && !p.getDono().getCpf().equals(pet.getDono().getCpf())) {
                System.out.println("Erro: O ID do Pet já está vinculado a outro CPF. Cadastro não realizado.");
                return;
            }
        }
        pets.add(pet);
        salvarPetsEmArquivo("resources/pets.txt"); // Atualiza o arquivo imediatamente
        System.out.println("Pet " + pet.getNome() + " cadastrado com sucesso!");
    }

    // método para consultar dono por CPF
    public String consultarDono(String cpf) {
        for (Dono dono : donos) {
            if (dono.getCpf().equals(cpf)) {
                return dono.getNome();
            }
        }
        return null;
    }

    public Pet consultarPet(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public Pet consultarPetPorCpfEId(String cpfDono, int idPet) {
        Dono dono = buscarDonoPorCpf(cpfDono);
        if (dono == null) {
            return null;
        }

        for (Pet pet : pets) {
            if (pet.getId() == idPet && pet.getDono().getCpf().equals(cpfDono)) {
                return pet;
            }
        }
        return null;
    }

    // Polimorfismo: sobrecarga do método agendarConsulta para lidar com consultas com ou sem diagnóstico
    public void agendarConsulta(int idConsulta, int idPet, String data, String veterinario, String diagnostico) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Consulta novaConsulta = new Consulta(idConsulta, data, pet, veterinario, diagnostico);
            consultas.add(novaConsulta);
            if (!consultaJaSalvo(novaConsulta, diagnostico)) {
                System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
            }

        } else {
            System.out.println("Pet não encontrado. Consulta não agendada.");
        }
    }

    // usar CPF como chave primária
    public void agendarConsulta(String cpfDono, int idPet, String data, String veterinario) {
        Dono dono = buscarDonoPorCpf(cpfDono);
        if (dono == null) {
            System.out.println("Dono não encontrado. Consulta não agendada.");
            return;
        }

        Pet pet = consultarPetPorCpfEId(cpfDono, idPet);
        if (pet == null) {
            System.out.println("Pet não encontrado ou não pertence ao dono. Consulta não agendada.");
            return;
        }

        for (Consulta consulta : consultas) {
            if (consulta.getPet().equals(pet) && consulta.getData().equals(data)) {
                System.out.println("Erro: Consulta já agendada no mesmo dia. Retornando ao menu...");
                return;
            }
        }

        Consulta novaConsulta = new Consulta(consultas.size() + 1, data, pet, veterinario);
        consultas.add(novaConsulta);
        salvarConsultasEmArquivo("resources/consultas.txt"); // Atualiza o arquivo imediatamente
        System.out.println("Consulta agendada para " + pet.getNome() + " com o veterinário " + veterinario);
    }

    // IDs únicos e salvamento automático
    public void administrarVacina(int idVacina, int idPet, String nomeVacina, String dataAplicacao) {
        Pet pet = consultarPet(idPet);
        if (pet != null) {
            Vacina novaVacina = new Vacina(idVacina, nomeVacina, dataAplicacao, pet);
            vacinas.add(novaVacina);
            salvarVacinasEmArquivo("resources/vacinas.txt"); 
            System.out.println("Vacina " + nomeVacina + " aplicada em " + pet.getNome());
        } else {
            System.out.println("Pet não encontrado. Vacina não aplicada.");
        }
    }

    public void administrarVacina(String cpfDono, int idPet, String nomeVacina, String dataAplicacao) {
        Dono dono = buscarDonoPorCpf(cpfDono);
        if (dono == null) {
            System.out.println("Dono não encontrado. Vacina não aplicada.");
            return;
        }

        Pet pet = consultarPetPorCpfEId(cpfDono, idPet);
        if (pet == null) {
            System.out.println("Pet não encontrado ou não pertence ao dono. Vacina não aplicada.");
            return;
        }

        for (Vacina vacina : vacinas) {
            if (vacina.getPet().equals(pet) && vacina.getDataAplicacao().equals(dataAplicacao)) {
                System.out.println("Erro: Vacina já aplicada no mesmo dia. Retornando ao menu...");
                return;
            }
        }

        Vacina novaVacina = new Vacina(vacinas.size() + 1, nomeVacina, dataAplicacao, pet);
        vacinas.add(novaVacina);
        salvarVacinasEmArquivo("resources/vacinas.txt"); // Atualiza o arquivo imediatamente
        System.out.println("Vacina " + nomeVacina + " aplicada em " + pet.getNome());
    }

    public void listarConsultas() {
        System.out.println("=== Consultas Agendadas ===");
        for (Consulta consulta : consultas) {
            System.out.println(consulta.listarConsultas());
        }
    }

    public void listarVacinas() {
        System.out.println("=== Vacinas Aplicadas ===");
        for (Vacina vacina : vacinas) {
            System.out.println(vacina.consultarVacinas());
        }
    }

    // método pra salvar o histórico médico de todos os pets
    public void salvarHistoricosMedicos() {
        for (Pet pet : pets) {
            HistoricoMedico historico = new HistoricoMedico(pet);

            // Adiciona consultas e vacinas ao histórico
            for (Consulta consulta : consultas) {
                if (consulta.getPet().equals(pet)) {
                    historico.adicionarConsulta(consulta);
                }
            }

            for (Vacina vacina : vacinas) {
                if (vacina.getPet().equals(pet)) {
                    historico.adicionarVacina(vacina);
                }
            }

            // Salva o histórico médico em um arquivo
            historico.salvarHistoricoEmArquivo("historico_medico.txt");
        }
    }

}//que Deus ajude essa nação
// fim do código