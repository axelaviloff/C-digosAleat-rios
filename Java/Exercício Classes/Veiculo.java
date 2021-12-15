package Exercicio;
//1.2 Superclasse

public abstract class Veiculo {
    protected String marca, modelo, cor;
    protected float comprimento, largura, preco;
    protected Motor motor1;

    protected Veiculo() {

    }

    protected Veiculo(String marca) {
        this.marca = marca;
    }

    protected Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    protected Veiculo(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    protected Veiculo(String marca, String modelo, String cor, float comprimento) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.comprimento = comprimento;
    }

    protected Veiculo(String marca, String modelo, String cor, float comprimento, float largura) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.comprimento = comprimento;
        this.largura = largura;
    }

    protected Veiculo(String marca, String modelo, String cor, float comprimento, float largura, float preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.comprimento = comprimento;
        this.largura = largura;
        this.preco = preco;
    }

    protected Veiculo(String marca, String modelo, String cor, float comprimento, float largura, float preco, Motor motor1) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.comprimento = comprimento;
        this.largura = largura;
        this.preco = preco;
        this.motor1 = motor1;
    }

    protected String getMarca() {
        return marca;
    }

    protected void setMarca(String marca) {
        try {
            this.marca = marca;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected String getModelo() {
        return modelo;
    }

    protected void setModelo(String modelo) {
        try {
            this.modelo = modelo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected String getCor() {
        return cor;
    }

    protected void setCor(String cor) {
        try {
            this.cor = cor;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected float getComprimento() {
        return comprimento;
    }

    protected void setComprimento(float comprimento) {
        try {
            this.comprimento = comprimento;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected float getLargura() {
        return largura;
    }

    protected void setLargura(float largura) {
        try {
            this.largura = largura;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected float getPreco() {
        return preco;
    }

    protected void setPreco(float preco) {
        try {
            this.preco = preco;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    protected Motor getMotor1() {
        return motor1;
    }

    protected void setMotor1(Motor motor1) {
        try {
            this.motor1 = motor1;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
