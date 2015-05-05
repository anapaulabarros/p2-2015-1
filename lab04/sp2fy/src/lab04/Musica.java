package lab04;

public class Musica {
	
	private String nome;
	private int duracao;
	private String genero;
	
	public Musica(String nome, int duracao, String genero) throws Exception {
		
		if (nome == null || nome.equals("")) {
			throw new Exception("Titulo da musica nao pode ser vazio.");
		}
		if (duracao < 0) {
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		if (genero == null || genero.equals("")) {
			throw new Exception("Genero da musica nao pode ser vazio.");
		}
		
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getTipo() {
		return this.genero;
	}
	public int getDuracao() {
		return this.duracao;
	}
	
	
	public boolean equals(Object outraMusica) {
		
		if (outraMusica instanceof Musica)
			return ((Musica) outraMusica).getNome().equals(nome) && ((Musica) outraMusica).getDuracao() == duracao;
		
		else 
			return false;
	}
}
