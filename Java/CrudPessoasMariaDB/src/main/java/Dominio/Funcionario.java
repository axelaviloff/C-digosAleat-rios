package Dominio;

public class Funcionario {
	private int id;
	private String nome;
	private String endereco;
	private String cargo;
	private Double salario;
	
	public Funcionario() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Id = " + id + " - Nome = " + nome + " - Endereço = " + endereco + " - Cargo = " + cargo + " - Salario = R$" + salario;
	}
	
	

	
	
}
