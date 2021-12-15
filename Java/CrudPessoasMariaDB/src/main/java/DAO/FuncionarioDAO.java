package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Connection.ConnectionFactoryMariaDB;
import Dominio.Funcionario;


public class FuncionarioDAO {

    Connection con;

    public FuncionarioDAO() {
        ConnectionFactoryMariaDB.getInstancia();
		con = ConnectionFactoryMariaDB.getConexao();
    }

    //CREATE - C do CRUD
    public void Inserir() {
        PreparedStatement stmt = null;
        Scanner ler = new Scanner(System.in);

        try {
        	String sql = "INSERT INTO funcionario (funcionario_nome, funcionario_endereco, funcionario_cargo, funcionario_salario) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            System.out.println("Informe o nome do Funcionário");
            String nome = ler.nextLine();
            stmt.setString(1, nome);
            System.out.println("Insira o endereço do Funcionário");
            String endereco = ler.nextLine();
            stmt.setString(2, endereco);
            System.out.println("Insira o cargo do Funcionário");
            String cargo = ler.nextLine();
            stmt.setString(3, cargo);
            System.out.println("Insira o salário do Funcionário");
            Double salario = ler.nextDouble();
            stmt.setDouble(4, salario);
            stmt.executeUpdate();
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Funcionário não cadastrado. Erro encontrado"
                    + ex.getMessage());
        }
    }

    //Read - R do CRUD
    public ArrayList<Funcionario> ListarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM funcionario";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("funcionario_id"));
                f.setNome(rs.getString("funcionario_nome"));
                f.setEndereco(rs.getString("funcionario_endereco"));
                f.setCargo(rs.getString("funcionario_cargo"));
                f.setSalario(rs.getDouble("funcionario_salario"));
                funcionarios.add(f);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível buscar as informações on Banco, erro: " + ex.getMessage());
        }
        return funcionarios;
    }

    //Método Consultar por Nome - R do CRUD
    public ArrayList<Funcionario> ConsultarPorNome() {
        String nome;
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário que deseja consultar: ");
        nome = ler.nextLine();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM funcionario WHERE funcionario_nome like '%" + nome + "%'";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	Funcionario f = new Funcionario();
            	f.setId(rs.getInt("funcionario_id"));
                f.setNome(rs.getString("funcionario_nome"));
                f.setEndereco(rs.getString("funcionario_endereco"));
                f.setCargo(rs.getString("funcionario_cargo"));
                f.setSalario(rs.getDouble("funcionario_salario"));
                funcionarios.add(f);
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível buscar as informações on Banco, erro: " + ex.getMessage());
        }
        return funcionarios;
    }
    
    //UPDATE - U do CRUD
    public void Alterar(Funcionario f){
    		
        PreparedStatement stmt = null;
        try{
            String sql = "UPDATE funcionario SET funcionario_nome = ?, funcionario_endereco = ?, funcionario_cargo = ?, funcionario_salario = ?"
                    + " WHERE funcionario_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getCargo());
            stmt.setDouble(4, f.getSalario());
            stmt.setDouble(5, f.getId());
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch(SQLException ex){
            System.out.println("Falha ao atualizar dados " +ex.getMessage());
        }
    }

    //Delete - D do CRUD
    public void Excluir(Funcionario f) {
    	
    	if (!FuncionarioExiste(f.getId())) {
    		System.out.println("Não consta nenhum funcionário com esse id");
    		return;
    	}
    	
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM funcionario WHERE funcionario_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getId());
            stmt.executeUpdate();
            System.out.println("O funcionário foi excluído com sucesso");

        } catch (SQLException ex) {
            System.out.println("Não foi possível remover o funcionário " + ex.getMessage());
        }
    }
    
    public boolean FuncionarioExiste(int id) {
    	PreparedStatement stmt = null; 
    	ResultSet rs = null;
    	int i = 0;
    	try {
    		 String sql = "SELECT * FROM funcionario WHERE funcionario_id = ?";
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
