package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Connection.ConnectionFactoryMariaDB;
import Dominio.Cliente;


public class ClienteDAO {

    Connection con;

    public ClienteDAO() {
        ConnectionFactoryMariaDB.getInstancia();
		con = ConnectionFactoryMariaDB.getConexao();
    }

    //CREATE - C do CRUD
    public void Inserir() {
        PreparedStatement stmt = null;
        Scanner ler = new Scanner(System.in);

        try {
        	String sql = "INSERT INTO cliente (cliente_nome, cliente_endereco) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);
            System.out.println("Informe o nome do Cliente");
            String nome = ler.nextLine();
            stmt.setString(1, nome);
            System.out.println("Insira o endereço do Cliente");
            String endereco = ler.nextLine();
            stmt.setString(2, endereco);
            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Cliente não cadastrado. Erro encontrado"
                    + ex.getMessage());
        }
    }

    //Read - R do CRUD
    public ArrayList<Cliente> ListarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("cliente_id"));
                c.setNome(rs.getString("cliente_nome"));
                c.setEndereco(rs.getString("cliente_endereco"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível buscar as informações on Banco, erro: " + ex.getMessage());
        }
        return clientes;
    }

    //Método Consultar por Nome - R do CRUD
    public ArrayList<Cliente> ConsultarPorNome() {
        String nome;
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o nome do cliente que deseja consultar: ");
        nome = ler.nextLine();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente WHERE cliente_nome like '%" + nome + "%'";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	Cliente c = new Cliente();
            	c.setId(rs.getInt("cliente_id"));
            	c.setNome(rs.getNString("cliente_nome"));
            	c.setEndereco(rs.getNString("cliente_endereco"));
            	clientes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível buscar as informações on Banco, erro: " + ex.getMessage());
        }
        return clientes;
    }
    
    //UPDATE - U do CRUD
    public void Alterar(Cliente c){
    	
        PreparedStatement stmt = null;
        try{
            String sql = "UPDATE cliente SET cliente_nome = ?, cliente_endereco = ?"
                    + " WHERE cliente_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setInt(3, c.getId());
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch(SQLException ex){
            System.out.println("Falha ao atualizar dados " +ex.getMessage());
        }
    }

    //Delete - D do CRUD
    public void Excluir(Cliente c) {
    	
    	if (!ClienteExiste(c.getId())) {
    		System.out.println("Não consta nenhum cliente com esse id");
    		return;
    	}
    	
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM cliente WHERE cliente_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            System.out.println("O cliente foi excluído com sucesso");

        } catch (SQLException ex) {
            System.out.println("Não foi possível remover o cliente " + ex.getMessage());
        }
    }
    
    public boolean ClienteExiste(int id) {
    	PreparedStatement stmt = null; 
    	ResultSet rs = null;
    	int i = 0;
    	try {
    		 String sql = "SELECT * FROM cliente WHERE cliente_id = ?";
             stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             i = 0;
             while(rs.next()) {
                 i++;
             }
             

         } catch (SQLException ex) {
             System.out.println("Erro " + ex.getMessage());
         }
    	
    	if (i == 0) {
       	 return false;
        }
        return true;
    
    }

}
