package Principal;

import java.util.List;
import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import Dominio.Cliente;
import Dominio.Funcionario;


public class Principal {

    public static void main(String[] args) {
        ClienteDAO clt = new ClienteDAO();
        FuncionarioDAO fnc = new FuncionarioDAO();
        Scanner ler = new Scanner(System.in);
        int opc = 1;
        do{
        	System.out.println("\n1 - Cadastrar Cliente");
        	System.out.println("2 - Cadastrar Funcionario");
        	System.out.println("3 - Listar Todos os Clientes");
        	System.out.println("4 - Listar Todos os Funcionários");
        	System.out.println("5 - Consultar Cliente por Nome");
        	System.out.println("6 - Consultar Funcionário por Nome");
        	System.out.println("7 - Alterar Cliente");
        	System.out.println("8 - Alterar Funcionário");
        	System.out.println("9 - Exluir Cliente");
        	System.out.println("10 - Exluir Funcionário");
        	System.out.println("0 - Sair do Sistema");
        	System.out.print("=> ");
        	opc = ler.nextInt();
            
        	if(opc < 0 || opc > 10){
                System.out.println("Informe uma opção válida");
            }
            else if(opc == 1){
                clt.Inserir();
            }
            else if(opc == 2){
            	fnc.Inserir();
            }
            else if(opc == 3){
            	List<Cliente> clientes = clt.ListarTodos();
            	if (clientes.size() == 0) {
            		System.out.println("Nenhum cliente cadastado.");
            	} else {
            		for (Cliente c : clientes) {
                		System.out.println(c);
                	}
            	}
            }
            else if (opc == 4) {
            	List<Funcionario> funcionarios = fnc.ListarTodos();
            	if (funcionarios.size() == 0) {
            		System.out.println("Nenhum funcionário cadastado.");
            	} else {
            		for (Funcionario f : funcionarios) {
                		System.out.println(f);
                	}
            	}
            }
            else if (opc == 5) {
            	List<Cliente> clientes = clt.ConsultarPorNome();
            	if (clientes.size() == 0) {
            		System.out.println("Não consta nenhum cliente com esse nome.");
            	} else {
            		for (Cliente c : clientes) {
                		System.out.println(c);
                	}
            	}
            	
            }
            else if (opc == 6) {
            	List<Funcionario> funcionarios = fnc.ConsultarPorNome();
            	if (funcionarios.size() == 0) {
            		System.out.println("Não consta nenhum funcionário com esse nome.");
            	} else {
            		for (Funcionario f : funcionarios) {
                		System.out.println(f);
                	}
            	}

            } 
            else if (opc == 7) {
            	Cliente c = new Cliente();
            	System.out.println("Informe o id do cliente a ser alterado: ");
            	c.setId(ler.nextInt());
            	
            	if (!clt.ClienteExiste(c.getId())) {
            		System.out.println("Não consta nenhum cliente com esse id");
            		continue;
            	}
            	
            	
            	ler.nextLine();
            	System.out.println("Informe o nome do cliente: ");
                c.setNome(ler.nextLine());
                System.out.println("Informe o endereço do cliente: ");
                c.setEndereco(ler.nextLine());
                
                clt.Alterar(c);
            } 
            else if (opc == 8) {
            	Funcionario f = new Funcionario();
            	System.out.println("Informe o id do funcionário a ser alterado: ");
            	f.setId(ler.nextInt());
            	
            	if (!fnc.FuncionarioExiste(f.getId())) {
            		System.out.println("Não consta nenhum funcionário com esse id");
            		continue;
            	}
            	
            	ler.nextLine();
            	System.out.println("Informe o nome do funcionário: ");
                f.setNome(ler.nextLine());
                System.out.println("Informe o endereço do funcionário: ");
                f.setEndereco(ler.nextLine());
                System.out.println("Informe o cargo do funcionário: ");
                f.setCargo(ler.nextLine());
                System.out.println("Informe o salário do funcionário: ");
                f.setSalario(ler.nextDouble());
           
            	fnc.Alterar(f);
            	
            } 
            else if (opc == 9) {
            	Cliente c = new Cliente();
                System.out.println("Informe o id do cliente a ser excluido: ");
                c.setId(ler.nextInt());
                clt.Excluir(c);
            } 
            else if (opc == 10) {
            	Funcionario f = new Funcionario();
                System.out.println("Informe o id do funcionário a ser excluido: ");
                f.setId(ler.nextInt());
                fnc.Excluir(f);
            	
            } 
            
           
        } while(opc != 0);
        ler.close();
    }

}
