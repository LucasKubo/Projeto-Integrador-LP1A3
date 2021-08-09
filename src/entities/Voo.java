package entities;

public class Voo {
	private Aviao aviao;
	private int nro;
	private String data;
	private String hora;
	
	public Voo(Aviao aviao, int nro, String data, String hora) {
		this.aviao = aviao;
		this.nro = nro;
		this.data = data;
		this.hora = hora;
	}
	
	//Retorna o numero do vôo
	public int getNro() {
		return nro;
	}
	
	//Retorna a data do vôo
	public String getData() {
		return data;
	}
	
	//Retorna a hora do vôo
	public String getHora() {
		return hora;
	}
	
	//Retorna avião
	public Aviao getAviao() {
		return aviao;
	}

}
