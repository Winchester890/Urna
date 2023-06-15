import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Main {
    static Votar voto = new Votar();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("----- Simulador de Urna Eletrônica ------");
            System.out.println("1 - Cadastrar candidato");
            System.out.println("2 - Cadastrar eleitor");
            System.out.println("3 - Votar");
            System.out.println("4 - Listar candidatos e eleitores cadastrados");
            System.out.println("5 - Relatório e estatísticas");
            System.out.println("0 - Sair");
            System.out.print("Qual operação você deseja realizar? ");
            opcao = Integer.parseInt(scanner.next());

            menu(opcao);
        } while (opcao != 0);
    }

    public static void menu(int opcao) {
        Scanner scanner = new Scanner(System.in);
        switch(opcao) {
            case 1:
                System.out.print("Digite o nome do candidato: ");
                String nome = scanner.next();
                System.out.print("Digite o número: ");
                String numero = scanner.next();
                System.out.print("Digite o partido: ");
                String partido = scanner.next();
                System.out.print("Digite o cargo: ");
                String cargo = scanner.next();
                int votos = 0;

                Candidato candidato = new Candidato(nome, numero, partido, cargo, votos);
                voto.addCandidato(candidato);

                System.out.println(" ");
                System.out.println("Candidato cadastrado com sucesso!");

                break;

            case 2:
                System.out.print("Digite o nome do eleitor: ");
                String name = scanner.next();
                System.out.print("Digite o CPF: ");
                String cpf = scanner.next();

                Eleitor eleitor = new Eleitor(name, cpf);
                voto.addEleitor(eleitor);

                System.out.println(" ");
                System.out.println("Eleitor cadastrado com sucesso!");

                break;

            case 3:
                System.out.print("Indique o eleitor pelo CPF: ");
                String Cpf = scanner.next();

                Eleitor elei = voto.getEleitorByCPF(Cpf);
                System.out.println(elei + " será o votante.");

                System.out.print("Indique o candidato a receber o voto pelo número: ");
                String num = scanner.next();

                Candidato cand = voto.getCandidatoByNumero(num);
                voto.votar(cand);

                System.out.println(" ");
                System.out.println("Voto concluído com sucesso!");

                break;

            case 4:
                System.out.println("Candidatos: ");
                List<Candidato> candidatos = voto.getCandidatosList();
                for (Candidato candidat : candidatos) {
                    System.out.println("Nome: " + candidat.getNome());
                    System.out.println("Número: " + candidat.getNumero());
                    System.out.println("Partido: " + candidat.getPartido());
                    System.out.println("Cargo: " + candidat.getCargo());
                    System.out.println("Total de votos recebidos: " + candidat.getVotos());
                }
                System.out.println("----------------------------------");
                System.out.println(" ");
                System.out.println("Eleitores: ");
                List<Eleitor> eleitores = voto.getEleitoresList();
                for (Eleitor eleit : eleitores) {
                    System.out.println("Nome: " + eleit.getNome());
                    System.out.println("CPF: " + eleit.getCpf());
                }

                break;

            case 5:
                String maiorNome = voto.getCandidatosList().stream()
                        .max(Comparator.comparing(Candidato::getVotos)).get().getNome();
                String maiorPartido = voto.getCandidatosList().stream()
                        .max(Comparator.comparing(Candidato::getVotos)).get().getPartido();
                String maiorCargo = voto.getCandidatosList().stream()
                        .max(Comparator.comparing(Candidato::getVotos)).get().getCargo();
                int maiorVotos = voto.getCandidatosList().stream()
                        .max(Comparator.comparing(Candidato::getVotos)).get().getVotos();

                System.out.println("O candidato " + maiorNome + " do Partido " + maiorPartido + " concorrendo ao cargo de " + maiorCargo + " foi o mais votado: " + maiorVotos);

                break;

            case 0:
                System.out.println("Encerrando o programa.");

                break;

            default:
                System.out.println("Opção inválida!");

                break;
        }
    }
}