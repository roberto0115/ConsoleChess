package main.Gestor;

import java.util.Scanner;

import main.Tablero.Tablero;

public class GestorJuego {

	private int turno;
	private Tablero  tablero;
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public GestorJuego(Tablero tablero) {
		this.tablero =  tablero;
		turno = -1;
	}
	
	
	public boolean iniciar() {
		System.out.println("¿Deseas iniciar una nueva partida?");
		String cons = ConsultarPorConsola();
		if(cons.equals("Si") || cons.equals("si") ) {
			System.out.println();
			System.out.println("Algunas Reglas antes de empezar:");
			System.out.println("--------------------------------");
			System.out.println("Desbes separar la posicion de A a H y de 1 a 8 con el simbolo ''");
			System.out.println("Empezemos!!");
			return true;
		}else{
			return false;
		}
	}
	
	public String ConsultarPorConsola() {
		
		Scanner Scan= new Scanner(System.in);
        String s = Scan.nextLine();
		return s;  
		
	}
	
	
	public void Partida() {
		if(iniciar() == true) {
			while(ComprobarJaqueMate() == 0 && ComporbarTablas() == false ) {
			System.out.println();
			System.out.println(" -----------------------------------");
		
			if(turno == 1) {
				System.out.println("|    -TURNO: Rojas                  |");
			}else if(turno == -1) {
				System.out.println("|    -TURNO: Negras                 |");
			}
			System.out.println("|    -SITUACIÓN ESPECIAL: Ninguna   |");
			System.out.println(" -----------------------------------");
			System.out.println();
			tablero.imprimirtablero();
			System.out.println();
			while(Movimiento() == false) {
				
			}
			if(turno == 1) {
				turno = -1;
			}else if(turno == -1) {
				turno = 1;
			}
			
			
			}
			
			
			if(ComprobarJaqueMate() == 1) {
				System.out.println();
				tablero.imprimirtablero();
				System.out.println();
				System.out.println("Negras GANAN por Jaque Mate");
				System.out.println("FIN DE LA PARTIDA");
			}else if(ComprobarJaqueMate() == -1) {
				System.out.println();
				tablero.imprimirtablero();
				System.out.println();
				System.out.println("Rojas GANAN por Jaque Mate");
				System.out.println("FIN DE LA PARTIDA");
			}
			
			
			
		}
	}
	
	public int ComprobarJaqueMate() {
		
		int jaquemate = 0;
		
		//JAQUE MATE A NEGRAS
		boolean AmenazandoANegra = false;
		for(int i = 0; i < tablero.getNumPiezas(); i++) {
			if(tablero.GetPiezaRoja(i).haciendoJaque() == true) {
				AmenazandoANegra = true;
			}
		}
		boolean puedenMoverseNegras = false;
		for(int i = 0; i< tablero.getNumPiezas(); i++) {
			if(tablero.GetPiezaNegra(i).PuedeMoverse() == true) {
				puedenMoverseNegras = true;
			}
		}
		if(tablero.GetPiezaNegra(4).PuedeMoverse() == false && AmenazandoANegra == true && puedenMoverseNegras == false) {
			jaquemate = -1;
		}
		//JAQUE MATE A NEGRAS
		boolean AmenazandoARoja = false;
		for(int i = 0; i < tablero.getNumPiezas(); i++) {
			if(tablero.GetPiezaNegra(i).haciendoJaque() == true) {
				AmenazandoARoja = true;
			}
		}
		boolean puedenMoverseRojas= false;
		for(int i = 0; i< tablero.getNumPiezas(); i++) {
			if(tablero.GetPiezaRoja(i).PuedeMoverse() == true) {
				puedenMoverseRojas = true;
			}
		}
		if(tablero.GetPiezaRoja(4).PuedeMoverse() == false && AmenazandoARoja == true && puedenMoverseRojas == false) {
			jaquemate = 1;
		}
		
		return jaquemate;
	}
	public boolean ComporbarTablas() {
		
		
		return false;
	}
	
	
	public boolean Movimiento() {
		boolean Seleccionar = true;
		int casilla = -1;
		while(Seleccionar == true) {
			System.out.println();
			System.out.println("¿Qué pieza quieres mover?");
			String cons = ConsultarPorConsola();
			try {
			String[] partes = cons.split("-");
			int x;
			int y;
			y = Integer.parseInt(partes[1])-1;
			
			switch(partes[0]) {
			case "A":
				x = 0;
				break;
			case "B":
				x = 1;
				break;
			case "C":
				x = 2;
				break;
			case "D":
				x = 3;
				break;
			case "E":
				x = 4;
				break;
			case "F":
				x = 5;
				break;
			case "G":
				x = 6;
				break;
			case "H":
				x = 7;
				break;
			case "a":
				x = 0;
				break;
			case "b":
				x = 1;
				break;
			case "c":
				x = 2;
				break;
			case "d":
				x = 3;
				break;
			case "e":
				x = 4;
				break;
			case "f":
				x = 5;
				break;
			case "g":
				x = 6;
				break;
			case "h":
				x = 7;
				break;
			default:
				x = -1;
				break;
			}
			if(x >= 0 && x <tablero.GetLado() && y >= 0 && y < tablero.GetLado()) {
				if(tablero.casillas[x+y*tablero.GetLado()].getPieza().getColor() == turno) {
					if(tablero.casillas[x+y*tablero.GetLado()].getPieza().PuedeMoverse() == true) {
						casilla = x+y*tablero.GetLado();
						tablero.casillas[x+y*tablero.GetLado()].getPieza().ImprimirMovimientosPosibles();
						Seleccionar = false;
					}else {
						System.out.println(ANSI_RED+"Esa pieza no puede moverse"+ ANSI_RESET);
					}
					
				}else {
					System.out.println(ANSI_RED+"No hay ninguna pieza del color"+ ANSI_RESET);
					
				}
			}else {
				System.out.println(ANSI_RED+"Datos Incorrectos"+ ANSI_RESET);
				
			}
			}catch(Exception e) {
				System.out.println(ANSI_RED+"Datos Incorrectos"+ ANSI_RESET);
				e.printStackTrace();
			}
			
		}
		boolean Movido = false;
		
		while(Movido == false) {
			
				System.out.println("¿A que casilla quieres mover?");
				String cons = ConsultarPorConsola();
				if(!cons.equals("//return")) {
				try {
					String[] partes = cons.split("-");
					int x;
					int y;
					y = Integer.parseInt(partes[1])-1;
					
					switch(partes[0]) {
					case "A":
						x = 0;
						break;
					case "B":
						x = 1;
						break;
					case "C":
						x = 2;
						break;
					case "D":
						x = 3;
						break;
					case "E":
						x = 4;
						break;
					case "F":
						x = 5;
						break;
					case "G":
						x = 6;
						break;
					case "H":
						x = 7;
						break;
					case "a":
						x = 0;
						break;
					case "b":
						x = 1;
						break;
					case "c":
						x = 2;
						break;
					case "d":
						x = 3;
						break;
					case "e":
						x = 4;
						break;
					case "f":
						x = 5;
						break;
					case "g":
						x = 6;
						break;
					case "h":
						x = 7;
						break;
					default:
						x = -1;
						break;
					}
			
					if(x>= 0 && x <tablero.GetLado()&& y >= 0 && y<tablero.GetLado()) {
					int[] MovPos = tablero.casillas[casilla].getPieza().CalcularMovimientosPosibles();
					
					boolean enMovPos= false;
				
					for(int i = 0; i< MovPos.length; i++) {
					
						if(MovPos[i] == (x+y*tablero.GetLado())) {
							enMovPos = true;
						}
					}
					
					if(enMovPos == true) {
						if(tablero.casillas[x+y*tablero.GetLado()].getPieza().getColor() != turno) {
							if(tablero.casillas[casilla].getPieza().JaqueAlMoverse(x, y) == false) {
								tablero.casillas[casilla].getPieza().mover(x, y);
								Movido = true;
							}else{
								System.out.println(ANSI_RED+"Movimiento ilegal3"+ ANSI_RESET);
							}
						}else {
							System.out.println(ANSI_RED+"Movimiento ilegal2"+ ANSI_RESET);
						}
					}else {
						System.out.println(ANSI_RED+"Movimiento ilegal1"+ ANSI_RESET);
					}
					}else {
						System.out.println(ANSI_RED+"Datos Incorrectos"+ ANSI_RESET);
					}
					
				}catch (Exception e) {
						System.out.println(ANSI_RED+"Datos Incorrectos"+ ANSI_RESET);
				}
				
			}else if(cons.equals("//return")) {
				break;
			}
		}
		
		return Movido;
		
	}
	
	
	
	
}
