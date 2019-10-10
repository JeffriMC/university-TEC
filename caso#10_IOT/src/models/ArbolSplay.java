package models;

public class ArbolSplay<String> {
	private NodoSplay<String> raiz;

	
	public ArbolSplay() {
		raiz=null;
	}
	
	private void rotacionIzquierda(NodoSplay<String> pNodo) {
		NodoSplay<String> aux=pNodo.hijo_derecho;
		pNodo.hijo_derecho=aux.hijo_izquierdo;
		if(aux.hijo_izquierdo!=null) {
			aux.hijo_izquierdo.padre=pNodo;
		}
		aux.padre=pNodo.padre;
		if(pNodo.padre==null) {
			this.raiz=aux;
		}else if(pNodo==pNodo.hijo_izquierdo){
			pNodo.padre.hijo_izquierdo=aux;
		}else {
			pNodo.padre.hijo_derecho=aux;
		}
		aux.hijo_izquierdo=pNodo;
		pNodo.padre=aux;
	}

	private void rotacionDerecha(NodoSplay<String> pNodo) {
		NodoSplay<String> aux=pNodo.hijo_izquierdo;
		pNodo.hijo_izquierdo=aux.hijo_derecho;
		if(aux.hijo_derecho!=null) {
			aux.hijo_derecho.padre=pNodo;
		}
		aux.padre=pNodo.padre;
		if(pNodo.padre==null) {
			this.raiz=aux;
		}else if(pNodo==pNodo.padre.hijo_derecho) {
			pNodo.padre.hijo_derecho=aux;
		}else {
			pNodo.padre.hijo_izquierdo=aux;
		}
		aux.hijo_derecho=pNodo;
		pNodo.padre=aux;
	}	
	
	private NodoSplay<String> buscar_aux(NodoSplay<String> pNodo,String pValor){
		if(pNodo==null || pValor==pNodo.valor) {
			return pNodo;
		}
		if(pValor.equals(pNodo.valor)) {
			return buscar_aux(pNodo.hijo_izquierdo,pValor);
		}
		return buscar_aux(pNodo.hijo_derecho,pValor);
		
	}
	
	
	
	private void splay(NodoSplay<String> pNodo) {
		while (pNodo.padre!=null) {
			if(pNodo.padre.padre==null) {
				if(pNodo==pNodo.padre.hijo_izquierdo) {
					rotacionDerecha(pNodo.padre);
				}else {
					rotacionIzquierda(pNodo.padre);
				}
			}else if(pNodo==pNodo.padre.hijo_izquierdo && pNodo.padre==pNodo.padre.padre.hijo_izquierdo) {
				rotacionDerecha(pNodo.padre.padre);
				rotacionDerecha(pNodo.padre);
			}else if(pNodo==pNodo.padre.hijo_derecho && pNodo.padre==pNodo.padre.padre.hijo_derecho) {
				rotacionIzquierda(pNodo.padre.padre);
				rotacionIzquierda(pNodo.padre);	
			}else if(pNodo==pNodo.padre.hijo_derecho && pNodo.padre==pNodo.padre.padre.hijo_izquierdo) {
				rotacionIzquierda(pNodo.padre);
				rotacionDerecha(pNodo.padre);
			}else {
				rotacionDerecha(pNodo.padre);
				rotacionIzquierda(pNodo.padre);
			}
		}
	}
	
	public void insertar(String valor) {
		NodoSplay<String> pNodo=new NodoSplay<String>(valor);
		NodoSplay<String> aux_1=null;
		NodoSplay<String> aux_2=this.raiz;
		
		while(aux_2!=null) {
			aux_1=aux_2;
			if((int)pNodo.valor<(int)(aux_2.valor)) {
				aux_2=aux_2.hijo_izquierdo;
			}else {
				aux_2=aux_2.hijo_derecho;
			}
		}
		pNodo.padre=aux_1;
		if(aux_1==null) {
			raiz=pNodo;
		}else if((int)pNodo.valor<(int)(aux_1.valor)){
			aux_1.hijo_izquierdo=pNodo;
		}else {
			aux_1.hijo_derecho=pNodo;	
		}
		splay(pNodo);
	}
	public NodoSplay<String> buscar(String pValor){
		NodoSplay<String> pNodo=buscar_aux(raiz,pValor);
		if(pNodo!=null) {
			splay(pNodo);
		}
		return pNodo;
	}

	
}
