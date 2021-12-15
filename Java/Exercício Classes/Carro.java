package Exercicio;
//1.3
public class Carro extends Veiculo {
    protected String placa;

    protected Carro() {

    }

    protected Carro(String placa) {
        this.placa = placa;
    }

    protected Carro(String marca, String placa) {
        super(marca);
        this.placa = placa;
    }

    protected Carro(String marca, String modelo, String placa) {
        super(marca, modelo);
        this.placa = placa;
    }

    protected Carro(String marca, String modelo, String cor, String placa) {
        super(marca, modelo, cor);
        this.placa = placa;
    }

    protected Carro(String marca, String modelo, String cor, float comprimento, String placa) {
        super(marca, modelo, cor, comprimento);
        this.placa = placa;
    }

    protected Carro(String marca, String modelo, String cor, float comprimento, float largura, float preco, Motor motor1, String placa) {
        super(marca, modelo, cor, comprimento, largura, preco, motor1);
        this.placa = placa;
    }


    protected String getPlaca() {
        return placa;
    }

    protected void setPlaca(String placa) {
        try {
            this.placa = placa;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

    

