package core;

public class Produto {
	private String nome;
	private double preco;
	private String categoria;
	private int quantidade;
	
	public Produto(String nome, double preco, String categoria, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getCategoria() {
		return this.categoria;
	}

	public int getQuantidade() {
		return this.quantidade;
	}
	public int setQuantidade(int valor) {
		this.quantidade = valor;
		return quantidade;
	}
}
