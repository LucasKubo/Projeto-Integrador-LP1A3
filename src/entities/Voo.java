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
	
	//Retorna o numero do v�o
	public int getNro() {
		return nro;
	}
	
	//Retorna a data do v�o
	public String getData() {
		return data;
	}
	
	//Retorna a hora do v�o
	public String getHora() {
		return hora;
	}
	
	//Retorna avi�o
	public Aviao getAviao() {
		return aviao;
	}

}
