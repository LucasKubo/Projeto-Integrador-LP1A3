package entities;

public class Passageiro {
	private String nome;
	private String cpf;
	
	public Passageiro(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	//Retorna nome do passageiro
	public String getNome() {
		return nome;
	}
	
	//Retorna cpf do passageiro
	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Passageiro [nome=" + nome + ", cpf=" + cpf + "]";
	}
}
