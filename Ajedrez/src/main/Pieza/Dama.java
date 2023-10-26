package main.Pieza;

import main.Tablero.Tablero;

public class Dama extends Pieza{




	
	public Dama(int x, int y, int color, Tablero tablero) {
		super.x = x;
		super.y = y;
		this.tablero = tablero;
		super.color = color;
		super.setComida(false);
		super.tablero = tablero;
	}
	public void mover(int x, int y) {
		int pos = x+y*tablero.GetLado();
		int posPosibles[] = CalcularMovimientosPosibles();
		
		for(int i = 0; i<posPosibles.length;i++) {

			if(pos == posPosibles[i]) {
				tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(this.x,this.y));
				tablero.casillas[x+y*tablero.GetLado()].getPieza().setComida(true);
				tablero.casillas[x+y*tablero.GetLado()].setPieza(this);
				this.x = x;
				this.y = y;
				
				break;
			}else if(i == posPosibles.length-1 && pos != posPosibles[i]) {
				System.out.println("movimiento ilegal del " + this.getClass().getName());
			}
			
		}
		

	}
	public int[] CalcularMovimientosPosibles() {
		int j = 0;
		int[] MovimientosPosibles = new int[24];
		for(int i = 0; i<MovimientosPosibles.length;i++) {
			MovimientosPosibles[i] = -1;
		}
		// ALFIL
		
		for(int i = 1; (this.x+i) < tablero.GetLado() && (this.y+i) < tablero.GetLado(); i++) {
			if(tablero.casillas[(this.x+i)+(this.y+i)*tablero.GetLado()].getPieza().getClass() == Vacia.class ) {
				MovimientosPosibles[j] = (this.x+i)+(this.y+i)*tablero.GetLado();
				j++;
			}else {
					MovimientosPosibles[j] = (this.x+i)+(this.y+i)*tablero.GetLado();
					j++;
					break;
			}
		}
		
		for(int i = 1; (this.x-i) >= 0 && (this.y+i)<tablero.GetLado(); i++) {
			if(tablero.casillas[(this.x-i)+(this.y+i)*tablero.GetLado()].getPieza().getClass() == Vacia.class ) {
				MovimientosPosibles[j] = (this.x-i)+(this.y+i)*tablero.GetLado();
				j++;
			}else {
					MovimientosPosibles[j] = (this.x-i)+(this.y+i)*tablero.GetLado();
					j++;
					break;
			}
		}
		for(int i = 1; (this.x-i) >= 0 && (this.y-i) >= 0; i++) {
			if(tablero.casillas[(this.x-i)+(this.y-i)*tablero.GetLado()].getPieza().getClass() == Vacia.class ) {
				MovimientosPosibles[j] = (this.x-i)+(this.y-i)*tablero.GetLado();
				j++;
			}else {
				
					MovimientosPosibles[j] = (this.x-i)+(this.y-i)*tablero.GetLado();
					j++;
					break;

			}
		}
		for(int i = 1; (this.x+i) < tablero.GetLado() && (this.y-i) >= 0; i++) {
			if(tablero.casillas[(this.x+i)+(this.y-i)*tablero.GetLado()].getPieza().getClass() == Vacia.class ) {
				MovimientosPosibles[j] = (this.x+i)+(this.y-i)*tablero.GetLado();
				j++;
			}else {
		
					MovimientosPosibles[j] = (this.x+i)+(this.y-i)*tablero.GetLado();
					j++;
					break;
			
			}
		}
		
		//TORRE
		//ARRIBA Y ABAJO
		for(int i = y+1; i<tablero.GetLado(); i++) {
			if(tablero.casillas[this.x+i*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = this.x+i*tablero.GetLado();
				j++;
			}else if(tablero.casillas[this.x+i*tablero.GetLado()].getPieza().getClass() != Vacia.class) {
					MovimientosPosibles[j] = this.x+i*tablero.GetLado();
					j++;
					break;
			}
		}
		for(int i = y-1; i>=0; i--) {
			if(tablero.casillas[this.x+i*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = this.x+i*tablero.GetLado();
				j++;
			}else if(tablero.casillas[this.x+i*tablero.GetLado()].getPieza().getClass() != Vacia.class) {

					MovimientosPosibles[j] = this.x+i*tablero.GetLado();
					j++;
					break;
			}
		}
		
		// IZQUIERDA DERECHA
		for(int i = x+1; i<tablero.GetLado(); i++) {
			if(tablero.casillas[i+this.y*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = i+this.y*tablero.GetLado();
				j++;
			}else if(tablero.casillas[i+this.y*tablero.GetLado()].getPieza().getClass() != Vacia.class) {
		
					MovimientosPosibles[j] = i+this.y*tablero.GetLado();
					j++;
					break;
			
			}
		}
		for(int i = x-1; i>=0; i--) {
			if(tablero.casillas[i+this.y*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = i+this.y*tablero.GetLado();
				j++;
			}else if(tablero.casillas[i+this.y*tablero.GetLado()].getPieza().getClass() != Vacia.class) {
			
					MovimientosPosibles[j] = i+this.y*tablero.GetLado();
					j++;
					break;
			
			}
		}
	
		
		return MovimientosPosibles;
	}
	public String Imprimir() {
		if(getComida() == false) {
			return "D";
		}else {
			return " ";
		}
	}
	

}
