package Exercicio;
public class Motor {
    protected int rpm, velocidade;
    protected float peso;
    protected String tipo;

    protected Motor(int rpm, int velocidade, float peso, String tipo) {
        this.rpm = rpm;
        this.velocidade = velocidade;
        this.peso = peso;
        this.tipo = tipo;
    }

    protected int getRpm() {
        return rpm;
    }

    protected void setRpm(int rpm) {
        try {
            this.rpm = rpm;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected int getVelocidade() {
        return velocidade;
    }

    protected void setVelocidade(int velocidade) {
        try {
            this.velocidade = velocidade;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected float getPeso() {
        return peso;
    }

    protected void setPeso(float peso) {
        try {
            this.peso = peso;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        try {
            this.tipo = tipo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
