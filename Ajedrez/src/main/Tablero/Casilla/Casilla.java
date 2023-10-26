package main.Tablero.Casilla;

import main.Pieza.Pieza;
import main.Tablero.Tablero;

public class Casilla {

	private int x;
	private int y;
	
	private Pieza pieza;
	private Tablero tablero;
	public Casilla (Pieza pieza,Tablero tablero) {
		this.pieza = pieza;
		this.tablero = tablero;
		
	}
	
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	
	public Pieza getPieza() {
		return pieza;
	}
	public Tablero getTablero() {
		return tablero;
	}
	
}
