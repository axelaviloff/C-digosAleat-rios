import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class Gmail {
    static int TAM = 10;
    Email[] emails;

    public Gmail() {
        this.emails = new Email[TAM];
    }

    public void enviarEmail(Email e) {
        Integer posicao = obterProximaPosicao(emails);
        if (posicao == null) {
            TAM *= 2;
            emails = Arrays.copyOf(this.emails, TAM);
            posicao = obterProximaPosicao(emails);
        }
        emails[posicao] = e;
    }

    public void enviarEmail(String conteudo, String remetente, String destinatario, Data envio) {
        Email e = new Email(conteudo, remetente, destinatario, envio);
        Integer posicao = obterProximaPosicao(emails);
        if (posicao == null) {
            TAM *= 2;
            emails = Arrays.copyOf(this.emails, TAM);
            posicao = obterProximaPosicao(emails);
        }
        emails[posicao] = e;
    }
    //Retorna a quantidade de emails enviados
    public int getQuantidadeEmails() {
        int quantidade = 0;
        for (int i = 0; i < emails.length; i++) {
            if (emails[i] == null) {
                continue;
            } else {
                quantidade += 1;
            }
        }
    return quantidade;
    }
    //Procura um determinado remetente nos remetentes dos emails
    public Email[] getEmailsRemetente(String remetente) {
        Email[] emailsRemetente = new Email[10];

        for (int i = 0; i < emails.length; i++) {
            if ((emails[i].getRemetente()).equals(remetente)) {
                emailsRemetente[obterProximaPosicao(emailsRemetente)] = emails[i];
            }
        }
        if (emailsRemetente.length == 0) {
            return null;
        } else {
            return emailsRemetente;
        }
    }
    //Procura uma determinada palavra no conteúdo dos emails
    public Email[] getEmailsComPalavra(String palavra) {
        Email[] emailsPalavra = new Email[10];
        for (int i = 0; i < emails.length; i++) {
            if ((emails[i].getConteudo()).contains(palavra)) {
                emailsPalavra[obterProximaPosicao(emailsPalavra)] = emails[i];
            }
        }
        if (emailsPalavra.length == 0) {
            return null;
        } else {
            return emailsPalavra;
        }
    }
    //Remove (se houver) o e-mail mais antigo de determinado remetente
    public void removeEmailMaisAntigo(String remetente) throws ParseException {
        Integer index = getEmailMaisAntigoRemetente(remetente);
        if (index == null) {
            System.out.println("Não existe nenhum e-mail enviado com esse remetente");
        } else {
            emails[index] = null;
            System.out.println("E-mail removido com sucesso.");
        }

    }
    // retorna a próxima posição livre (null) no array
    private Integer obterProximaPosicao(Object[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                return i;
            }
        }
        return null;
    }
    //Retorna a posição do e-mail com determinado remetente
    private Integer getEmailMaisAntigoRemetente(String remetente) throws ParseException {
        Date menorData, data;
        String strMenorData = "33/13/2100 25"; //Data fictícia para a primeira data do mesmo remetente ser sempre menor
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH");
        menorData = sdf1.parse(strMenorData);
        int indexMaisAntigo = -1;

        for(int i = 0; i < emails.length; i++) {
            if (emails[i] != null && (emails[i].remetente).equals(remetente)) {
                String strData = emails[i].envio.dia + "/" + emails[i].envio.mes + "/" + emails[i].envio.ano + " " + emails[i].envio.hora;
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH");

                data = sdf2.parse(strData);

                if (data.before(menorData)) {
                    menorData = data;
                    indexMaisAntigo = i;
                }
            }
        }
        if (indexMaisAntigo >= 0) {
            return indexMaisAntigo;
        } else {
            return null;
        }
    }

}


