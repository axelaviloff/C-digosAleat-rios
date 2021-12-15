/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ditzz
 */
public class ConnectionFactoryMariaDB {
    private static String banco = "pessoas";
    private static String usuario = "root";
    private static String senha = "mypass";
    private static String url = "jdbc:mariadb://localhost:3306/";

    //atributo que garante uma única conexão com o banco
    //padrão de projeto Singleton:
    private static ConnectionFactoryMariaDB instancia = null;

    //atributo que realiza a conexão com o banco:
    private static Connection conexao = null;

    //construtor vazio e privado da Classe BancoDados
    //para nao permitir a instancia de multiplos objetos
    //faz parte do padrão Singleton
    private ConnectionFactoryMariaDB()
    {
        conectar();
    }

    //método público que permitirá o uso de uma única instância da
    //conexão com o banco. Se ainda não houver uma instância ativa,
    //este método a cria e retorna para quem "está chamando"
    //Também faz parte do padrão singleton
    public static ConnectionFactoryMariaDB getInstancia(){

        if(instancia == null)
        {
            //se não houver uma instância ativa, bora criar!
            instancia = new ConnectionFactoryMariaDB();
            //aproveitar e conectar logo ao banco!
            conectar();
        }
        //se já houver uma instância ativa, bora enviar ela!
        return instancia;
    }

    //método para realizar a conexão
    private static void conectar()
    {
        //try significa "tenta".. Tenta conectar ao banco...
        try {
            conexao  = DriverManager.getConnection(url + banco, usuario, senha);
            System.out.println("Conexão OK!");
        }
        //se não conseguir, catch.. ou seja, "pega" esse erro e exibe pra alguem!
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactoryMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método público para "pegar" a conexão ativa!
    //através deste método é que conseguiremos incluir, consultar ou alterar
    //dados em nosso banco de dados!
    public static Connection getConexao()
    {
        return conexao;
    }


    //método público para desconectar o SGBD após o uso!
    public void desconectar() {

        try {
            conexao.close();
            System.out.println("Conexão Encerrada!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactoryMariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
