package main;

import main.Gestor.GestorJuego;
import main.Tablero.Tablero;

public class GestorPrincipal {

	private boolean enFuncianamiento;
	private Tablero tablero;
	private GestorJuego GJuego;
	public static final String ANSI_RED = "\u001B[31m";
	public static void main (String args[]) {

		GestorPrincipal main =new GestorPrincipal();
		
		main.iniciar();
		
	}
	
	public void inicializar() {
		 tablero = new Tablero();
		 GJuego = new GestorJuego(tablero);
	}
	
	public void iniciar() {
		inicializar();
		bucle();
	}
	
	public void bucle() {

	
		GJuego.Partida();
		
	}
	
}
//((Rey) tablero.GetPiezaRoja(4)).EnrroqueLargo();