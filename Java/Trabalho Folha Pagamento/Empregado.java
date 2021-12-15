public abstract class Empregado {
    String nome;
    Double salarioBase;
    int gratDesempenho;
    int gratHoraExtra;
    int gratTotal;

    public Empregado(String nome, Double salarioBase, int gratDesempenho, int gratHoraExtra, int gratTotal) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.gratDesempenho = gratDesempenho;
        this.gratHoraExtra = gratHoraExtra;
        this.gratTotal = gratTotal;
    }

    public Double calculaGratificacoes() {
        double valorGrat;
        valorGrat = (salarioBase * gratDesempenho * 0.05) + (salarioBase * gratHoraExtra * 0.001);
        return valorGrat;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public int getGratDesempenho() {
        return gratDesempenho;
    }

    public int getGratHoraExtra() {
        return gratHoraExtra;
    }

    public int getGratTotal() {
        return gratTotal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setGratDesempenho(int gratDesempenho) {
        this.gratDesempenho = gratDesempenho;
    }

    public void setGratHoraExtra(int gratHoraExtra) {
        this.gratHoraExtra = gratHoraExtra;
    }

    public void setGratTotal(int gratTotal) {
        this.gratTotal = gratTotal;
    }

}
