package main.Pieza;

import main.Tablero.Tablero;

public class Caballo extends Pieza{



	
	public Caballo(int x, int y, int color, Tablero tablero) {
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
		int[] MovimientosPosibles = new int[8];
		for(int i = 0; i<MovimientosPosibles.length;i++) {
			MovimientosPosibles[i] = -1;
		}
		// L VERTICAL
		
			if(this.x+1 < tablero.GetLado() && this.y+2 <tablero.GetLado()) {
				MovimientosPosibles[j] = (this.x+1)+(this.y+2)*tablero.GetLado();
				j++;
			}
			if(this.x-1 >=0 && this.y+2 < tablero.GetLado()) {
				MovimientosPosibles[j] = (this.x-1)+(this.y+2)*tablero.GetLado();
				j++;
			}
			if(this.x+1 < tablero.GetLado() && this.y-2 >= 0) {
				MovimientosPosibles[j] = (this.x+1)+(this.y-2)*tablero.GetLado();
				j++;
			}
			if(this.x-1 >= 0 && this.y-2 >=0) {
				MovimientosPosibles[j] = (this.x-1)+(this.y-2)*tablero.GetLado();
				j++;
			
			}
		// L HORIZONTAL
			if(this.x+2 < tablero.GetLado() && this.y+1 <tablero.GetLado()) {
				MovimientosPosibles[j] = (this.x+2)+(this.y+1)*tablero.GetLado();
				j++;
			}
			if(this.x-2 >=0 && this.y+1 <tablero.GetLado()) {
				MovimientosPosibles[j] = (this.x-2)+(this.y+1)*tablero.GetLado();
				j++;
			}
			if(this.x+2 < tablero.GetLado() && this.y-1 >=0) {
				MovimientosPosibles[j] = (this.x+2)+(this.y-1)*tablero.GetLado();
				j++;
			}
			if(this.x-2 >=0  && this.y-1 >=0) {
				MovimientosPosibles[j] = (this.x-2)+(this.y-1)*tablero.GetLado();
				j++;
			}
		
		
		
		
		return MovimientosPosibles;
	}
	
	public String Imprimir() {
		if(getComida() == false) {
			return "C";
		}else {
			return " ";
		}
	}
	
	public boolean AmenazandoA(int x,int y) {
		boolean Amenazando = false;
		int[] pos = CalcularMovimientosPosibles();
		if(pos != null) {
			for(int i = 0; i<pos.length; i++) {
				if((x+y*tablero.GetLado()) == pos[i] ) {
					Amenazando = true;
				}
			}
		}
		return Amenazando;
	}
	

}
