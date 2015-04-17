package core;
import ui.Tela;

public class Main {
	public static void main(String[] args) {
			
		Tela tela = new Tela();
		Produto[] produtos = new Produto[5];
			
			
		tela.exibeMensagensAlerta(1);
			
		int opcaoEscolhida = tela.exibeMenuOpcoes();
		
		switch (opcaoEscolhida) {
			case 1:
				int cont = 0;
				String cadastra = "Sim";
				tela.exibeMensagensAlerta(5);
				while (cadastra.equals("Sim")) {
					cadastraProduto(tela, produtos, cont);
					String opcaoOperacao = tela.ContinuarCadastar();
					cont++;
					if (opcaoOperacao.equals("Nao")) {
						opcaoEscolhida = tela.exibeMenuOpcoes();
						cadastra = "Nao";
					}
				}
				break;
			case 2:
				System.out.println("venda");
				break;
			case 3:
				System.out.println("balanco");
				break;
			case 4:
				System.out.println("fim");
				System.exit(1);
				break;
			default:
				System.exit(1);
				break;
		}
				
	}

	public static void cadastraProduto(Tela tela, Produto[] produtos,int controle) {	
		produtos[controle] = new Produto(tela.lerNomeProduto(), tela.lerPrecoUnitario(), tela.lerTipoProduto());
		tela.exibeResultadoCadastro(produtos[controle].getNome());
	}
	
	public boolean buscaProduto(Produto[] produtos, String nomeProduto) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				return false;
			} else if (produtos[i].getNome().equals(nomeProduto)) {
				return true;
			} 			
		}
		return false;
	}
	
	
	
}