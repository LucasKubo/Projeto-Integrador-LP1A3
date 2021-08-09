package entities;

public class Aviao extends Aeronave{
	//Matriz de objetos Passageiro
	public Passageiro[][] lugares;

	public Aviao(String modelo,int fileiras, int assentos) {
		super(modelo);
		this.lugares = new Passageiro [fileiras][assentos];
		
	}
	
	//Atribui um passageiro a um assento
	public void setPassageiro(int fileira, int assento, Passageiro p) {
		this.lugares[fileira][assento] = p;
	}
	
	//Retorna um passageiro
	public Passageiro getPassageiro(int fileira, int assento) {
		return lugares [fileira][assento];
	}
	
	//Retorna os lugares
	public Passageiro[][] getLugares(){
		return lugares;
	}
	
	//Verifica se há passageiro no assento. Retorna true se o lugar tiver ocupado e false se não estiver ocupado
	public boolean verificaLugarOcupado(int fileira, int assento) {
		if(this.lugares[fileira][assento] != null) { 
			return true;
		}
		return false;
	}

}
