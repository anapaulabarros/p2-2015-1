package core;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
	}
	@Override
	public void compraJogo(Jogo jogo) throws Exception {
		if(getSaldo() <= jogo.getPreco())
			throw new Exception("Voce nao tem saldo suficiente para comprar esse jogo.");
		jogo.setPreco(jogo.getPreco() * 0.20);
		setSaldo(jogo.getPreco());
		jogos.add(jogo);
	}
}
