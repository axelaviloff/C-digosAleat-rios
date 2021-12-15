public class Email {
    String conteudo;
    String remetente;
    String destinatario;
    Data envio;

    public Email() {

    }

    public Email(String conteudo, String remetente, String destinatario, Data envio) {
        this.conteudo = conteudo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.envio = envio;
    }

    @Override
    public String toString() {
        return "Email{" +
                "conteudo='" + conteudo + '\'' +
                ", remetente='" + remetente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", envio=" + envio +
                '}';
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Data getEnvio() {
        return envio;
    }

    public void setEnvio(Data envio) {
        this.envio = envio;
    }
}
