import java.util.ArrayList;
import java.util.List;

public class Candidato {
    private String nome;
    private String numero;
    private String partido;
    private String cargo;
    private int votos;

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getPartido() {
        return partido;
    }

    public String getCargo() {
        return cargo;
    }

    public int getVotos() {
        return votos;
    }

    public void addVoto() {
        this.votos += 1;
    }

    public Candidato(String nome, String numero, String partido, String cargo, int votos) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
        this.cargo = cargo;
        this.votos = votos;
    }
}
