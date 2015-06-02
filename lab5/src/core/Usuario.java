package core;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	protected String nome, login;
	protected double saldo;
	protected List<Jogo> jogos;
	protected int x2p;
	
	public Usuario(String nome, String login) throws Exception {
		if (nome == null || nome.equals(""))
			throw new Exception("Nome invalido.");
		if (login == null || login.equals(""))
			throw new Exception("Login invalido.");
		this.nome = nome;
		this.login = login;
		saldo = 0;
		x2p = 0;
		jogos = new ArrayList<Jogo>();
	}
	
	public void addDinheiro(double valor) throws Exception {
		if(valor < 0)
			throw new Exception("Valor informado e invalido.");
		saldo += valor;
	}
	
	public void compraJogo(Jogo jogo) throws Exception {
		if(getSaldo() <= jogo.getPreco())
			throw new Exception("Voce nao tem saldo suficiente para comprar esse jogo.");
		jogos.add(jogo);
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public int getX2p() {
		return x2p;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
