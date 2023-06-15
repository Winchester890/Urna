import java.util.ArrayList;
import java.util.List;

public class Eleitor {
    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Eleitor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
