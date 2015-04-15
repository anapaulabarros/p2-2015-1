package core;

import ui.Tela;

public class Conta {
	
	private Cliente titular;
	private String numConta;
	private String agencia;
	private double saldo;
	
	Tela tela = new Tela();
	
	public Conta(Cliente titular, String numero, String ag, double saldo) {
		this.titular = titular;
		this.numConta = numero;
		this.agencia = ag;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getNumero() {
		return this.numConta;
	}
	
	public String getAgencia() {
		return this.agencia;
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			tela.exibeMensagensDeAlertas(5);
		} else {
			tela.exibeMensagensDeAlertas(2);
		}
	}
	
	public void sacar(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			tela.exibeMensagensDeAlertas(3);
		} else if(valor < 0) {
			tela.exibeMensagensDeAlertas(2);
		} else {
			tela.exibeMensagensDeAlertas(1);
		}
	}
}
