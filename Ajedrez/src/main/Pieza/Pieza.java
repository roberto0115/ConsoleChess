package main.Pieza;

import main.Tablero.Tablero;

public abstract class Pieza {

	protected int x;
	protected int y;
	protected int color;
	private boolean comida;
	protected Tablero tablero;
	
	public void mover(int x, int y) {
		
	}
	
	public String Imprimir() {
		return "";
	}
	private int[] MovimientosPosibles;
	
	public int getColor() {
		return color;
	}
	
	public void setComida(boolean comida) {
		this.comida = comida;
	}
	public boolean getComida() {
		return comida;
	}
	
	public int[] CalcularMovimientosPosibles() {
		return null;
	}
	
	public void ImprimirMovimientosPosibles() {
		
		int[] MovDentroTablero = CalcularMovimientosPosibles();
		
		
		if(MovDentroTablero != null) {
		int[] MovPos = new int[MovDentroTablero.length];
		
		for(int i = 0; i<MovDentroTablero.length; i++) {
			MovPos[i] = -1;
		}
		for(int i = 0; i<MovDentroTablero.length; i++) {
			if(MovDentroTablero[i] != -1) {
			if(tablero.casillas[MovDentroTablero[i]].getPieza().getClass() == Vacia.class || tablero.casillas[MovDentroTablero[i]].getPieza().getColor()!= color) {
				int y =MovDentroTablero[i]/tablero.GetLado();
				
				int x = MovDentroTablero[i]-(y*tablero.GetLado());
				if(JaqueAlMoverse(x,y) == false) {
				MovPos[i] = MovDentroTablero[i];
				}
			}
			}
		}
		
	
		char[] MovPosX= new char[MovPos.length];
		int[] MovPosY = new int[MovPos.length];
		
		
		
		for(int i = 0; i<MovPos.length; i++) {
			if(MovPos[i] != -1) {
				MovPosY[i] = (MovPos[i]/tablero.GetLado())+1;
				switch(MovPos[i]- (MovPosY[i]-1)*tablero.GetLado()){
				case 0: 
					MovPosX[i] = 'A';
					break;
				case 1:
					MovPosX[i] = 'B';
					break;
				case 2: 
					MovPosX[i] = 'C';
					break;
				case 3:
					MovPosX[i] = 'D';
					break;
				case 4: 
					MovPosX[i] = 'E';
					break;
				case 5:
					MovPosX[i] = 'F';
					break;
				case 6:
					MovPosX[i] = 'G';
					break;
				case 7:
					MovPosX[i] = 'H';
					break;
				}
			}
		}
		System.out.println();
		String name = this.getClass().getName();
		String[] Name = name.split("\\.");
		char pos = ' ';
		switch (x) {
			case 0: 
				pos = 'A';
				break;
			case 1:
				pos = 'B';
				break;
			case 2: 
				pos = 'C';
				break;
			case 3:
				pos = 'D';
				break;
			case 4: 
				pos = 'E';
				break;
			case 5:
				pos = 'F';
				break;
			case 6:
				pos = 'G';
				break;
			case 7:
				pos = 'H';
				break;
		}
		
		
		if(Name[2] == "Torre" || Name[2] == "Reina"){
			String col = "";
			
			if(color == 1) {
				col = "roja";
			}else if(color == -1) {
				col = "negra";
			}
			System.out.println("Movimientos posibles de la " + Name[2] + " "+ col + " en la posicion " + pos + "-" + (y+1)  );
		}else {
			String col = "";
			
			if(color == 1) {
				col = "rojo";
			}else if(color == -1) {
				col = "negro";
			}
			

			System.out.println("Movimientos posibles del " + Name[2] + " "+ col + " en la posicion " + pos + "-" + (y+1)  );
		}
		
		
		for(int i = 0; i<MovDentroTablero.length; i++) {
			
		}
		for(int i = 0; i<MovPos.length;i++) {
			
			if(MovPos[i] != -1) {
		
			System.out.print("|| ");
			System.out.print(MovPosX[i] + "-" + MovPosY[i]+" ");
			
			}
		}
		System.out.println();
		System.out.println();
		}
	}
	
	public boolean haciendoJaque() {
		boolean Jaqueando= false;
		int[] pos = CalcularMovimientosPosibles();
		if(pos != null && comida == false) {
		
		for(int i = 0; i<pos.length; i++) {
			if(pos[i] >= 0) {
			if(tablero.casillas[pos[i]].getPieza().getClass() == Rey.class && tablero.casillas[pos[i]].getPieza().getColor() != color) {
				Jaqueando = true;
			}
			}
		}
		}
		return Jaqueando;
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
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean PuedeMoverse() {
		int[] MovPos =CalcularMovimientosPosibles();
		boolean puede = false;
		if(MovPos != null) {
			for(int i = 0; i<MovPos.length; i++) {
				if(MovPos[i] != -1 && tablero.casillas[MovPos[i]].getPieza().getColor() != color) {
					int y =MovPos[i]/tablero.GetLado();
				
					int x = MovPos[i]-(y*tablero.GetLado());
					if(JaqueAlMoverse(x,y) == false) {
						puede = true;
					}
	
				}
			}
		}
		return puede;
	}
	
	public boolean JaqueAlMoverse(int x, int y) {
		boolean jaque = false;
		
		if(color == 1) {
			Pieza prov = tablero.casillas[x+y*tablero.GetLado()].getPieza();
			tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(this.x,this.y));
			tablero.casillas[x+y*tablero.GetLado()].setPieza(this);
		
			for(int i = 0; i<tablero.getNumPiezas(); i++) {
				if(tablero.GetPiezaNegra(i).haciendoJaque() == true) {
				
					jaque = true;
				}
			}	
			
			tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(this);
			tablero.casillas[x+y*tablero.GetLado()].setPieza(prov);
			
		}else if(color == -1) {
			Pieza prov = tablero.casillas[x+y*tablero.GetLado()].getPieza();
			tablero.casillas[x+y*tablero.GetLado()].getPieza().setComida(true);
			tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(this.x,this.y));
			tablero.casillas[x+y*tablero.GetLado()].setPieza(this);
		
			for(int i = 0; i<tablero.getNumPiezas(); i++) {
				if(tablero.GetPiezaRoja(i).haciendoJaque() == true) {
					
					jaque = true;
				}
			}	
			
			tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(this);
			prov.setComida(false);
			tablero.casillas[x+y*tablero.GetLado()].setPieza(prov);
		}
		
		
		
		return jaque;
	}
	
	
}
