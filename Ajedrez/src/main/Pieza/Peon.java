package main.Pieza;

import main.Tablero.Tablero;

public class Peon extends Pieza {



	
	
	public Peon(int x, int y, int color, Tablero tablero) {
		super.x = x;
		super.y = y;
		super.tablero = tablero;
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
		int[] MovimientosPosibles = new int[4];
		for(int i = 0; i<MovimientosPosibles.length; i++) {
			MovimientosPosibles[i] = -1;
		}

		if(tablero.casillas[this.x+(this.y+color)*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
			MovimientosPosibles[j] = this.x+(this.y+color)*tablero.GetLado();
			j++;
		}
		if(this.x+color<tablero.GetLado()){
		if(tablero.casillas[(this.x+color)+(this.y+color)*tablero.GetLado()].getPieza().getClass() != Vacia.class && tablero.casillas[(this.x+color)+(this.y+color)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			
			MovimientosPosibles[j] = (this.x+color)+(this.y+color)*tablero.GetLado();
			j++;
		}
		}
		if(this.x-color>0){
		if(tablero.casillas[(this.x-color)+(this.y+color)*tablero.GetLado()].getPieza().getClass() != Vacia.class && tablero.casillas[(this.x-color)+(this.y+color)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			MovimientosPosibles[j] = (this.x-color)+(this.y+color)*tablero.GetLado();
			j++;
		}
		}
		if(color == 1 && y == 1) {
			if(tablero.casillas[this.x+(this.y+color*2)*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = this.x+(this.y+color*2)*tablero.GetLado();
				j++;
			}
		}else if(color == -1 && y == tablero.GetLado()-1) {
			if(tablero.casillas[this.x+(this.y+color*2)*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
				MovimientosPosibles[j] = this.x+(this.y+color*2)*tablero.GetLado();
				j++;
			}
		}

		return MovimientosPosibles;
		
	}

	
	public String Imprimir() {
		if(getComida() == false) {
		return "P";
		}else {
		return " ";
		}
	}
	public boolean AmenazandoA(int x,int y) {
		boolean Amenazando = false;
		if(tablero.casillas[(this.x-color)+(this.y+color)*tablero.GetLado()] == tablero.casillas[x+y*tablero.GetLado()] ) {
			Amenazando = true;
		}else if(tablero.casillas[(this.x+color)+(this.y+color)*tablero.GetLado()] == tablero.casillas[x+y*tablero.GetLado()] ) {
			Amenazando = true;
		}

		return Amenazando;
	}

	
	public boolean AlgunaPiezaHaciendoJaque() {
		boolean jaque = false;
		if(color == 1) {
			for(int j = 0; j<tablero.getNumPiezas();j++) {
				if(tablero.GetPiezaNegra(j).haciendoJaque() == true) {
					jaque = true;
				}
			}
		}else if(color == -1) {
			for(int j = 0; j<tablero.getNumPiezas();j++) {
				if(tablero.GetPiezaRoja(j).haciendoJaque() == true) {
					jaque = true;
				}
			}
		}
		return jaque;
	}
	
}
