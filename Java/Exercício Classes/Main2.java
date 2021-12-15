package Exercicio;
//1.5
import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {
        String nome;
        String placa;
        String identificacao;
        try {
            ArrayList<Lancha>lanchas = new ArrayList();
            ArrayList<Carro>carros = new ArrayList();
            ArrayList<Aviao>avioes = new ArrayList();

            for (int i = 0; i < 3; i++) {
                nome = "Lancha " + Integer.toString(i+1);
                Lancha lancha = new Lancha();
                lancha.setNome(nome);
                lanchas.add(lancha);
            }

            for (int i = 0; i < 3; i++) {
                placa = "Carro " + Integer.toString(i+1);
                Carro carro = new Carro();
                carro.setPlaca(placa);
                carros.add(carro);
            }

            for (int i = 0; i < 3; i++) {
                identificacao = "Aviao " + Integer.toString(i+1);
                Aviao aviao = new Aviao();
                aviao.setIdentificacao(identificacao);
                avioes.add(aviao);
            }
            for (Lancha l : lanchas) {
                System.out.println(l.getNome());
            }
            System.out.println();
            for (Carro c : carros) {
                System.out.println(c.getPlaca());
            }
            System.out.println();
            for (Aviao a : avioes) {
                System.out.println(a.getIdentificacao());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}
