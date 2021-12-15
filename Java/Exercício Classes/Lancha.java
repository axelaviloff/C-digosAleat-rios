package Exercicio;
//1.3
public class Lancha extends Veiculo {
    protected String nome;
    protected Motor motor2;

    protected Lancha() {

    }

    protected Lancha(String nome, Motor moto2) {
        this.nome = nome;
        this.motor2 = moto2;
    }

    protected Lancha(String marca, String nome, Motor moto2) {
        super(marca);
        this.nome = nome;
        this.motor2 = moto2;
    }

    protected Lancha(String marca, String modelo, String nome, Motor moto2) {
        super(marca, modelo);
        this.nome = nome;
        this.motor2 = moto2;
    }

    protected Lancha(String marca, String modelo, String cor, String nome, Motor moto2) {
        super(marca, modelo, cor);
        this.nome = nome;
        this.motor2 = moto2;
    }

    protected Lancha(String marca, String modelo, String cor, float comprimento, String nome, Motor moto2) {
        super(marca, modelo, cor, comprimento);
        this.nome = nome;
        this.motor2 = moto2;
    }

    protected Lancha(String marca, String modelo, String cor, float comprimento, float largura, float preco, Motor motor1, String nome, Motor moto2) {
        super(marca, modelo, cor, comprimento, largura, preco, motor1);
        this.nome = nome;
        this.motor2 = moto2;
    }


    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        try {
            this.nome = nome;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected Motor getMotor2() {
        return motor2;
    }

    protected void setMotor2(Motor motor2) {
        try {
            this.motor2 = motor2;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
