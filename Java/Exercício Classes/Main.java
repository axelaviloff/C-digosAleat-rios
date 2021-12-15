package Exercicio;
//1.4
public class Main {
    public static void main(String[] args) {
    String nome;
    String placa;
    String identificacao;
        try {
            Lancha lanchas[] = new Lancha[5];
            Carro carros[] = new Carro[5];
            Aviao avioes[] = new Aviao[5];

            for (int i = 0; i < 5; i++) {
                nome = "Lancha " + Integer.toString(i+1);
                Lancha lancha = new Lancha();
                lancha.setNome(nome);
                lanchas[i] = lancha;
                System.out.println(lanchas[i].getNome());
            }
            System.out.println();
            for (int i = 0; i < 5; i++) {
                placa = "Carro " + Integer.toString(i+1);
                Carro carro = new Carro();
                carro.setPlaca(placa);
                carros[i] = carro;
                System.out.println(carros[i].getPlaca());
            }
            System.out.println();
            for (int i = 0; i < 5; i++) {
                identificacao = "Aviao " + Integer.toString(i+1);
                Aviao aviao = new Aviao();
                aviao.setIdentificacao(identificacao);
                avioes[i] = aviao;
                System.out.println(avioes[i].getIdentificacao());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}