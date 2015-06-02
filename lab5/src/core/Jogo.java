package core;

import java.util.HashSet;
import java.util.Set;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogadas;
	private int qtdZeradas;
	private Set<Jogabilidade> jogabilidade;
	
	
	public Jogo(String nome, double preco) throws Exception {
		if(nome == null || nome.equals(""))
			throw new Exception("nome invalido");
		if (preco < 0)
			throw new Exception("preco invalido");
		
		this.nome = nome;
		this.preco = preco;
		jogabilidade = new HashSet<Jogabilidade>();
		maiorScore = 0;
		qtdJogadas = 0;
		qtdZeradas = 0;
	}

	
	public void addJobilidade(Jogabilidade estilo) {
		jogabilidade.add(estilo);
	}

	public String getNome() {
		return nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


	public double getPreco() {
		return preco;
	}
	
	public void joga(int score, boolean zerar) throws Exception {
		if (score < 0)
			throw new Exception("valor invalido");
		if (zerar == false) {
			if (score > maiorScore)
				maiorScore = score;
		} else {
			throw new Exception("Zerou o jogo.");
		}
		
	}

	public int getMaiorScore() {
		return maiorScore;
	}
	
}
