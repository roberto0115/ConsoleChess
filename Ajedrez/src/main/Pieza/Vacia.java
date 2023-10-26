package main.Pieza;

public class Vacia extends Pieza {

	
	public Vacia(int x, int y) {
		super.x = x;
		super.y = y;
		super.color = 0;
		super.setComida(false);
	}
	
	public String Imprimir() {
		return " ";
	}
	
}
