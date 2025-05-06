import animal_e_dono.animal.Pet;
import animal_e_dono.dono.Dono;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Interativo ---");
            System.out.println("1. Cadastrar Dono");
            System.out.println("2. Cadastrar Pet");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Administrar Vacina");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            
            switch (opcao) {
                case 1 -> {
                    String cpf;
                    String telefone;

                    // Verificação de CPF duplicado
                    while (true) {
                        System.out.print("Digite o CPF do dono (11 números): ");
                        cpf = scanner.nextLine();
                        if (!cpf.matches("\\d{11}")) {
                            System.out.println("CPF inválido! Certifique-se de digitar exatamente 11 números.");
                            continue;
                        }
                        if (sistema.buscarDonoPorCpf(cpf) != null) {
                            System.out.println("Erro: Esse CPF já está cadastrado no sistema. Por favor, insira outro CPF.");
                            return; // Interrompe o processo de cadastro imediatamente
                        }
                        break;
                    }

                    System.out.print("Digite o nome do dono: ");
                    String nomeDono = scanner.nextLine();

                    // Validação do telefone com no máximo 14 dígitos numéricos
                    while (true) {
                        System.out.print("Digite o telefone do dono (máximo 14 dígitos numéricos): ");
                        telefone = scanner.nextLine();
                        if (!telefone.matches("\\d{1,14}")) {
                            System.out.println("Telefone inválido! Certifique-se de digitar no máximo 14 dígitos numéricos.");
                            continue;
                        }
                        break;
                    }

                    System.out.print("Digite o endereço do dono: ");
                    String endereco = scanner.nextLine();

                    Dono dono = new Dono(cpf, nomeDono, telefone, endereco); // usando CPF como chave primária ao invés de ID
                    sistema.cadastrarDono(dono);
                    System.out.println("Dono cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o ID do pet: ");
                    int idPet = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do pet: ");
                    String nomePet = scanner.nextLine();
                    System.out.print("Digite o CPF do dono do pet: ");
                    String cpfDonoPet = scanner.nextLine();

                    Dono donoPet = sistema.buscarDonoPorCpf(cpfDonoPet);
                    if (donoPet == null) {
                        System.out.println("Dono não encontrado!");
                        break;
                    }

                    System.out.print("Digite o tipo do animal: ");
                    String tipoAnimal = scanner.nextLine();
                    System.out.print("Digite a espécie do animal: ");
                    String especie = scanner.nextLine();
                    System.out.print("Digite a raça do animal: ");
                    String raca = scanner.nextLine();
                    System.out.print("Digite a cor do animal: ");
                    String cor = scanner.nextLine();
                    System.out.print("Digite o número de patas do animal: ");
                    int patas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o som característico do animal: ");
                    String barulho = scanner.nextLine();

                    Pet pet = new Pet(idPet, nomePet, donoPet, tipoAnimal, especie, raca, cor, patas, barulho);
                    sistema.cadastrarPet(pet);
                    System.out.println("Pet cadastrado com sucesso!");
                }
                case 3 -> {
                    System.out.print("Digite o CPF do dono: ");
                    String cpfDonoConsulta = scanner.nextLine();
                    System.out.print("Digite o ID do pet: ");
                    int idPetConsulta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a data da consulta (dd/mm/aaaa): ");
                    String dataConsulta = scanner.nextLine();
                    System.out.print("Digite o nome do veterinário: ");
                    String veterinario = scanner.nextLine();

                    sistema.agendarConsulta(cpfDonoConsulta, idPetConsulta, dataConsulta, veterinario);
                    System.out.println("Consulta agendada com sucesso!");
                }
                case 4 -> {
                    System.out.print("Digite o CPF do dono: ");
                    String cpfDonoVacina = scanner.nextLine();
                    System.out.print("Digite o ID do pet: ");
                    int idPetVacina = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome da vacina: ");
                    String nomeVacina = scanner.nextLine();
                    System.out.print("Digite a data da vacina (dd/mm/aaaa): ");
                    String dataVacina = scanner.nextLine();

                    sistema.administrarVacina(cpfDonoVacina, idPetVacina, nomeVacina, dataVacina);
                    System.out.println("Vacina administrada com sucesso!");
                }
                case 5 -> {
                    sistema.salvarTodosOsDados();
                    System.out.println("Dados salvos. Saindo do sistema...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
