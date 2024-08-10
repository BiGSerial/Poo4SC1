package data;

import java.util.Scanner;

public class AppClinic {
    
    private static PatientVet patientVet = new PatientVet(100);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1 – Cadastrar");
            System.out.println("2 – Consultar");
            System.out.println("3 – Imprimir Cadastro");
            System.out.println("4 – Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    imprimirCadastro();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);
    }

    private static void cadastrar() {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento (DD/MM/YYYY): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Digite o histórico do paciente: ");
        String historico = scanner.nextLine();
        
        Patient patient = new Patient(nome, cpf, dataNascimento, historico);
        int result = patientVet.insert(patient);
        
        if (result == 0) {
            System.out.println("Paciente cadastrado com sucesso.");
        } else if (result == -1) {
            System.out.println("Erro: Capacidade máxima de pacientes atingida.");
        } else if (result == -2) {
            System.out.println("Erro: Paciente com o mesmo CPF já cadastrado.");
        }
    }

    private static void consultar() {
        System.out.print("Digite o CPF do paciente para consulta: ");
        String cpf = scanner.nextLine();
        
        int pos = patientVet.search(cpf);
        if (pos != -1) {
            Patient patient = patientVet.getPatient(pos);
            System.out.println("Nome: " + patient.getNome());
            System.out.println("CPF: " + patient.getCpf());
            System.out.println("Data de Nascimento: " + patient.getDataNascimento());
            System.out.println("Histórico: " + patient.getHistorico());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void imprimirCadastro() {
        if (patientVet.getNElem() == 0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        for (int i = 0; i < patientVet.getNElem(); i++) {
            Patient patient = patientVet.getPatient(i);
            System.out.println("Nome: " + patient.getNome());
            System.out.println("CPF: " + patient.getCpf());
            System.out.println("Data de Nascimento: " + patient.getDataNascimento());
            System.out.println();
        }
    }
}
