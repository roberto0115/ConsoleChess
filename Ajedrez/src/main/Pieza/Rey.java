package main.Pieza;

import main.Tablero.Tablero;

public class Rey extends Pieza {
	
	
	private int movido = 0;
	
	
	public Rey(int x, int y, int color, Tablero tablero) {
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
				movido++;
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
		//ALANTE
		if(this.y+1<tablero.GetLado()) {
		if(tablero.casillas[this.x+(this.y+1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[this.x+(this.y+1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA(this.x, (this.y+1)) == true) {
							apuntando = true;
						}
					}
					
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = this.x+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA(this.x, (this.y+1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = this.x+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//ATRAS
		if(this.y-1 >= 0) {
		if(tablero.casillas[this.x+(this.y-1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[this.x+(this.y-1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA(this.x, (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = this.x+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA(this.x, (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = this.x+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//ALANTE IZQ
		if(this.x+1<tablero.GetLado() && this.y+1<tablero.GetLado()) {
		if(tablero.casillas[(this.x+1)+(this.y+1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x+1)+(this.y+1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x+1), (this.y+1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x+1), (this.y+1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//ALANTE DERECHA
		if(this.x-1>= 0 && this.y+1<tablero.GetLado()) {
		if(tablero.casillas[(this.x-1)+(this.y+1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x-1)+(this.y+1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x-1), (this.y+1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x-1), (this.y+1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y+1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//DERECHA
		if(this.x-1 >= 0) {
		if(tablero.casillas[(this.x-1)+(this.y)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x-1)+(this.y)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x-1), (this.y)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x-1), (this.y)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//IZQUIERDA
		if(this.x+1 <tablero.GetLado()) {
		if(tablero.casillas[(this.x+1)+(this.y)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x+1)+(this.y)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
				
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x+1), (this.y)) == true) {
							apuntando = true;
						}
					}
					
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
				
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x+1), (this.y)) == true) {
							apuntando = true;
						}
					}
					
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//ABAJO IZQ
		if(this.x+1 < tablero.GetLado() && this.y-1 >= 0) {
		if(tablero.casillas[(this.x+1)+(this.y-1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x+1)+(this.y-1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x+1), (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x+1), (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x+1)+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		//ABAJO DERECHA
		if(this.x-1 >= 0 && this.y-1 >= 0) {
		if(tablero.casillas[(this.x-1)+(this.y-1)*tablero.GetLado()].getPieza().getClass() == Vacia.class || tablero.casillas[(this.x-1)+(this.y-1)*tablero.GetLado()].getPieza().getColor() != this.getColor()) {
			if(this.getColor() == 1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaNegra(i).getComida() == false) {
						if(tablero.GetPiezaNegra(i).AmenazandoA((this.x-1), (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}else if(this.getColor() == -1) {
				boolean apuntando = false;
				for(int i = 0; i<tablero.getNumPiezas();i++) {
					if(tablero.GetPiezaRoja(i).getComida() == false) {
						if(tablero.GetPiezaRoja(i).AmenazandoA((this.x-1), (this.y-1)) == true) {
							apuntando = true;
						}
					}
				}
				if(apuntando == false) {
					 MovimientosPosibles[j] = (this.x-1)+(this.y-1)*tablero.GetLado();
					 j++;
				}
			}
		}
		}
		return MovimientosPosibles;
		
	}
	
	public String Imprimir() {
		if(getComida() == false) {
			return "R";
		}else {
			return " ";
		}
	}
	
	public void EnrroqueLargo() {
		if(color == 1) {
			if(GetMovido() == false && ((Torre)tablero.GetPiezaRoja(0)).GetMovido() == false) {
				if(tablero.casillas[2].getPieza().getClass() == Vacia.class && tablero.casillas[3].getPieza().getClass() == Vacia.class && tablero.casillas[1].getPieza().getClass() == Vacia.class ) {
					boolean apuntando = false;
					for(int i = 0; i<tablero.getNumPiezas();i++) {
						if(tablero.GetPiezaNegra(i).getComida() == false) {
							if(tablero.GetPiezaNegra(i).AmenazandoA(2, 0) == true) {
								apuntando = true;
							}
						}
					}
					if(apuntando == false) {
						tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[2+0*tablero.GetLado()].setPieza(this);
						this.x = 2;
						this.y = 0;
						tablero.casillas[tablero.GetPiezaRoja(0).x+tablero.GetPiezaRoja(0).y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[3+0*tablero.GetLado()].setPieza(tablero.GetPiezaRoja(0));
						tablero.GetPiezaRoja(0).x = 3;
						tablero.GetPiezaRoja(0).y = 0;
					}else {
						System.out.println("Enrroque ilegal, jaque");
					}
				}else {
					System.out.println("Enrroque ilegal, piezas vacías");
				}
			}else {
				System.out.println("Enrroque ilegal, piezas ya movidas");
			}
		}
		if(color == -1) {
			if(GetMovido() == false && ((Torre)tablero.GetPiezaNegra(0)).GetMovido() == false) {
				if(tablero.casillas[1+7*tablero.GetLado()].getPieza().getClass() == Vacia.class && tablero.casillas[2+7*tablero.GetLado()].getPieza().getClass() == Vacia.class && tablero.casillas[3+7*tablero.GetLado()].getPieza().getClass() == Vacia.class) {
					boolean apuntando = false;
					for(int i = 0; i<tablero.getNumPiezas();i++) {
						if(tablero.GetPiezaRoja(i).getComida() == false) {
							if(tablero.GetPiezaRoja(i).AmenazandoA(2, 7) == true) {
								
								apuntando = true;
							}
						}
					}
					if(apuntando == false) {
						tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[2+7*tablero.GetLado()].setPieza(this);
						this.x = 2;
						this.y = 7;
						tablero.casillas[tablero.GetPiezaNegra(0).x+tablero.GetPiezaNegra(0).y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[3+7*tablero.GetLado()].setPieza(tablero.GetPiezaNegra(0));
						tablero.GetPiezaNegra(0).x = 4;
						tablero.GetPiezaNegra(0).y= 7;
					}else {
						System.out.println("Enrroque ilegal, jaque");
					}
				}else {
					System.out.println("Enrroque ilegal, piezas vacías");
				}
			}else {
				System.out.println("Enrroque ilegal, piezas ya movidas");
			}
			
			
			
		}
		
		
	}
	
	public void EnrroqueCorto() {
		if(color == 1) {
			if(GetMovido() == false && ((Torre)tablero.GetPiezaRoja(7)).GetMovido() == false) {
				if(tablero.casillas[5].getPieza().getClass() == Vacia.class && tablero.casillas[6].getPieza().getClass() == Vacia.class ) {
					boolean apuntando = false;
					for(int i = 0; i<tablero.getNumPiezas();i++) {
						if(tablero.GetPiezaNegra(i).getComida() == false) {
							if(tablero.GetPiezaNegra(i).AmenazandoA(6, 0) == true) {
								apuntando = true;
							}
						}
					}
					if(apuntando == false) {
						tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[6+0*tablero.GetLado()].setPieza(this);
						this.x = 6;
						this.y = 0;
						tablero.casillas[tablero.GetPiezaRoja(7).x+tablero.GetPiezaRoja(7).y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[5+0*tablero.GetLado()].setPieza(tablero.GetPiezaRoja(7));
						tablero.GetPiezaRoja(7).x = 5;
						tablero.GetPiezaRoja(7).y = 0;
					}else {
						System.out.println("Enrroque ilegal, jaque");
					}
				}else {
					System.out.println("Enrroque ilegal, piezas vacías");
				}
			}else {
				System.out.println("Enrroque ilegal, piezas ya movidas");
			}
		}
		if(color == -1) {
			if(GetMovido() == false && ((Torre)tablero.GetPiezaNegra(7)).GetMovido() == false) {
	
				if(tablero.casillas[6+7*tablero.GetLado()].getPieza().getClass() == Vacia.class && tablero.casillas[5+7*tablero.GetLado()].getPieza().getClass() == Vacia.class ) {
					boolean apuntando = false;
					for(int i = 0; i<tablero.getNumPiezas();i++) {
						if(tablero.GetPiezaRoja(i).getComida() == false) {
							if(tablero.GetPiezaRoja(i).AmenazandoA(6, 7) == true) {
								
								apuntando = true;
							}
						}
					}
					if(apuntando == false) {
						tablero.casillas[this.x+this.y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[6+7*tablero.GetLado()].setPieza(this);
						this.x = 6;
						this.y = 7;
						tablero.casillas[tablero.GetPiezaNegra(7).x+tablero.GetPiezaNegra(7).y*tablero.GetLado()].setPieza(new Vacia(x,y));
						tablero.casillas[5+7*tablero.GetLado()].setPieza(tablero.GetPiezaNegra(7));
						tablero.GetPiezaNegra(7).x = 5;
						tablero.GetPiezaNegra(7).y= 7;
					}else {
						System.out.println("Enrroque ilegal, jaque");
					}
				}else {
					System.out.println("Enrroque ilegal, piezas vacías");
				}
			}else {
				System.out.println("Enrroque ilegal, piezas ya movidas");
			}
			
			
			
		}
		
		
	
	}
	
	
	public boolean GetMovido() {
		if(movido == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	public boolean AmenazandoA(int x,int y) {
		boolean Amenazando = false;
		int pos[] = new int [8];
		int j = 0;
		for(int i = 0; i<pos.length; i++) {
			pos[i] = -1;
		}
		if(this.x+1 < tablero.GetLado()) {
			pos[j] = (this.x+1) + this.y *tablero.GetLado();
			j++;
		}
		if(this.x-1 >= 0) {
			pos[j] = (this.x-1) + this.y *tablero.GetLado();
			j++;
		}
		if(this.y+1 < tablero.GetLado()) {
			pos[j] = this.x + (this.y+1) *tablero.GetLado();
			j++;
		}
		if(this.y-1 >= 0) {
			pos[j] = (this.x) + (this.y-1) *tablero.GetLado();
			j++;
		}
		if(this.y-1 >= 0 && this.x+1 < tablero.GetLado()) {
			pos[j] = (this.x+1) + (this.y-1) *tablero.GetLado();
			j++;
		}
		if(this.y-1 >= 0 && this.x-1 >= 0) {
			pos[j] = (this.x-1) + (this.y-1) *tablero.GetLado();
			j++;
		}
		if(this.y+1 < tablero.GetLado() && this.x+1 < tablero.GetLado()) {
			pos[j] = (this.x+1) + (this.y+1) *tablero.GetLado();
			j++;
		}
		if(this.y+1 < tablero.GetLado() && this.x-1 >= 0) {
			pos[j] = (this.x-1) + (this.y+1) *tablero.GetLado();
			j++;
		}
	
		for(int i = 0; i<pos.length;i++) {
			if((x+y*tablero.GetLado()) == pos[i]) {
			
				Amenazando = true;
			}
		}
		return Amenazando;
	}
	
}
