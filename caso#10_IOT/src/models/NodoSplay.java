package models;

public class NodoSplay<String> {
	String valor;
	NodoSplay<String> hijo_derecho;
	NodoSplay<String> hijo_izquierdo;
	NodoSplay<String> padre;
	
	
	public NodoSplay() {
		
	}
	
	public NodoSplay(String pValor) {
		this.valor=pValor;
	}
	
	public String getValor() {
		return valor;
	}
	

}
