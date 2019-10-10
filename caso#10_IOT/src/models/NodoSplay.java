package models;

public class NodoSplay {
	Sensor valor;
	NodoSplay hijo_derecho;
	NodoSplay hijo_izquierdo;
	NodoSplay padre;
	
	
	public NodoSplay() {
		valor = new Sensor();
	}
	
	public NodoSplay(Sensor pValor) {
		valor = new Sensor();
		this.valor=pValor;
	}
	
	public Sensor getValor() {
		return valor;
	}
	

}
