import java.io.Console;
import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(500, 500);
	}
	String [] texts;
	String [] textsNuevo;
	ArrayList<Palabra> words;
	ArrayList<Palabra> matchWords;
	
	Palabra sel;
	
	int selIndex;
	
	int xBoton;
	int yBoton;
	
	int aciertos;
	
	boolean visible;
	
	@Override
	public void setup() {
		sel = null;
		
		selIndex = 0;
		
		xBoton = 180;
		yBoton = 230;
		
		aciertos = 0;
		
		visible = true;
		
		texts = loadStrings("./texto/string.txt");
		
		textsNuevo = loadStrings("./texto/stringNuevo.txt");
	
		words = new ArrayList<Palabra>();
		
		matchWords = new ArrayList<Palabra>();

		for (int index = 0; index < texts.length; index++) {
		    String [] arrayWords = texts[index].split(" "); 
		    for (int j = 0; j < arrayWords.length; j++) {
		      words.add(new Palabra(arrayWords[j],(int)(random(20, 430)), (int)(random(-300, -100)), (int)(random(1, 3)), 0));
		    }
	}
		for (int k = 0; k <= 3; k++) {
			   matchWords.add(new Palabra(words.get((int) random(words.size())).getWord(), 140+(k*70), 464, 3, 255));
		}
	}
	
	@Override
	public void draw() {
		background(255);
		
		//Barrita 
		fill(200, 3, 90);
		rect(0, 450, 500, 30);
		
		
		for (int index = 0; index < words.size(); index++) {
			  words.get(index).draw(this);
			  words.get(index).mover(this);
			  }
		
		for (int index = 0; index < matchWords.size(); index++) {
			matchWords.get(index).draw(this);  
		}
		
		if (aciertos == 4) {
			botonGuardar();
		}
}
	
	public void botonGuardar () {
		
		if (visible == true) {
		noStroke();
		fill(0, 207, 200);
		rect(xBoton, yBoton, 130, 40);
		textSize(16);
		fill(255);
		text("GUARDAR", 246, 248);
		
		//Cuando pase por el boton cambiar de color
		if (mouseX > xBoton && mouseX < xBoton + 130 && mouseY > yBoton && mouseY < yBoton + 40) {
			fill(0, 160, 155);
			rect(xBoton, yBoton, 130, 40);
			fill(255);
			text("GUARDAR", 246, 248);
		}
	}
}
	
	public void compararPalabra () {
			for (int j = 0; j < matchWords.size(); j++) {
			if(sel.getWord().compareTo(matchWords.get(j).getWord()) == 0) {
				words.remove(selIndex);
				matchWords.get(j).setColor(0);
				aciertos ++;
			}
		}
	}

	@Override
	public void mousePressed() {
		for (int i = 0; i < words.size(); i++) {
			Palabra  p = words.get(i);
		if (mouseX > p.getPosX() - 16 && mouseX < p.getPosX() + 32 &&
			mouseY > p.getPosY() - 8 && mouseY < p.getPosY() + 16) {
			sel = words.get(i);
			selIndex = words.indexOf(sel);
			p.setQuieta(true);
		}
	}
}
	
	@Override
	public void mouseDragged() {
		if(sel != null) {
			sel.setPosX(mouseX);
			sel.setPosY(mouseY);}
	}
	
	@Override
	public void mouseReleased() {
		if (sel != null) {
			compararPalabra();
		}
	}
}
