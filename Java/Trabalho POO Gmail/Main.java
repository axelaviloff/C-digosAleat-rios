import java.text.ParseException;

public class Main {
    //Testando funções
    public static void main(String[] args) throws ParseException {
        Gmail g = new Gmail();

        System.out.println("Lista de emails vazia");
        for (int i = 0; i < g.emails.length; i++) {
            System.out.println(g.emails[i]);
        }

        Data d = new Data(15, 13, 1997, 22);
        Email e = new Email("texto", "joao", "bob", d);
        g.enviarEmail(e);
        Data d2 = new Data(15, 13, 2008, 22);
        Email e2 = new Email("texto1", "joao", "patrik", d2);
        g.enviarEmail(e2);

        System.out.println(("\nApós enviar dois emails"));
        for (int i = 0; i < g.emails.length; i++) {
            System.out.println(g.emails[i]);
        }

        int qtd = g.getQuantidadeEmails();
        System.out.println("Quantidade de emails enviados: "+ qtd);

        g.removeEmailMaisAntigo(("joao"));
        System.out.println("\nApós remover o e-mail mais antigo do mesmo remetente");
        for (int i = 0; i < g.emails.length; i++) {
            System.out.println(g.emails[i]);
        }
    }
}
