package core;

import java.util.List;

public class Loja {
	
	private List<Usuario> usuarios;
	private double totalArrecadado;
	private List<Jogo>  jogos;
	
	public void criaUsuaio(String nome, String login) throws Exception {
		for(int i = 0; i < usuarios.size(); i++) {
			Usuario usuarioAtual = usuarios.get(i);
			if (usuarioAtual.getLogin().equals(login))
				throw new Exception("Login ja cadastrado no sistema");
		}
		Usuario novoUsuario = new Usuario(nome, login);
		usuarios.add(novoUsuario);
	}
	
	public void criaJogo(String nome, double preco) {
		
	}
	
	public void vendeJogo(Usuario usuario, Jogo jogo) {
		
	}
	
	public void adicionaDinheiro(Usuario usuario, double valor) {
		
	}
}
