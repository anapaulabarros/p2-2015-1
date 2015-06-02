package core;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	@Override
	public void compraJogo(Jogo jogo) throws Exception {
		if(getSaldo() <= jogo.getPreco())
			throw new Exception("Voce nao tem saldo suficiente para comprar esse jogo.");
		jogo.setPreco(jogo.getPreco() * 0.10);
		setSaldo(jogo.getPreco());
		jogos.add(jogo);
	}
}
