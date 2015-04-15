package core;

public class Cliente {
	String nome;
	
	public Cliente(String titular) {
		this.nome = titular;
	}
	
	public String getNome() {
		return this.nome;
	}
}
