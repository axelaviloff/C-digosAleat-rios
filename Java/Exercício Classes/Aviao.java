package Exercicio;
//1.3
public class Aviao extends Veiculo {
    protected String identificacao;
    protected Motor motor2, motor3, motor4;

    protected Aviao() {

    }

    protected Aviao(String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }

    protected Aviao(String marca, String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        super(marca);
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }

    protected Aviao(String marca, String modelo, String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        super(marca, modelo);
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }

    protected Aviao(String marca, String modelo, String cor, String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        super(marca, modelo, cor);
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }

    protected Aviao(String marca, String modelo, String cor, float comprimento, String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        super(marca, modelo, cor, comprimento);
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }

    protected Aviao(String marca, String modelo, String cor, float comprimento, float largura, float preco, Motor motor1, String identificacao, Motor motor2, Motor motor3, Motor motor4) {
        super(marca, modelo, cor, comprimento, largura, preco, motor1);
        this.identificacao = identificacao;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.motor4 = motor4;
    }


    protected String getIdentificacao() {
        return identificacao;
    }

    protected void setIdentificacao(String identificacao) {
        try {
            this.identificacao = identificacao;
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

    protected Motor getMotor3() {
        return motor3;
    }

    protected void setMotor3(Motor motor3) {
        try {
            this.motor3 = motor3;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected Motor getMotor4() {
        return motor4;
    }

    protected void setMotor4(Motor motor4) {
        try {
            this.motor4 = motor4;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
