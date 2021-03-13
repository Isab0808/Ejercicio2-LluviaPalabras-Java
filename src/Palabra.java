import processing.core.PApplet;

public class Palabra {

	public int posX, posY, velocidad;
	public String word;
	
	public Palabra(String word, int posX, int posY, int velocidad) {
		this.posX = posX;
		this.posY = posY;
		this.velocidad = velocidad;
		this.word = word;
	}
	
	public void draw (PApplet app) {
		app.textSize(16);
		app.text(word, posX, posY);
	}
	
	public void mover (PApplet app) {
		if (posY > app.height) {
			posY = 0;
		}
		posY += velocidad;
	}
	
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

}
