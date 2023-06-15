import java.util.ArrayList;
import java.util.List;

public class Votar {
    private List<Candidato> candidatosList = new ArrayList<>();

    public List<Candidato> getCandidatosList() {
        return candidatosList;
    }

    public void addCandidato(Candidato candidato) {
        candidatosList.add(candidato);
    }

    private List<Eleitor> eleitoresList = new ArrayList<>();

    public List<Eleitor> getEleitoresList() {
        return eleitoresList;
    }

    public void addEleitor(Eleitor eleitor) {
        eleitoresList.add(eleitor);
    }

    public Candidato getCandidatoByNumero(String numero) {
        for (Candidato cand : candidatosList) {
            if (cand.getNumero().equals(numero))
                return cand;
        }

        System.out.println("Candido com o número não encontrado.");
        return null;
    }

    public Eleitor getEleitorByCPF(String cpf) {
        for (Eleitor elei : eleitoresList) {
            if (elei.getCpf().equals(cpf))
                return elei;
        }

        System.out.println("Eleitor com o CPF não encontrado.");
        return null;
    }

    public void votar(Candidato candidato) {
        candidato.addVoto();
    }
}
