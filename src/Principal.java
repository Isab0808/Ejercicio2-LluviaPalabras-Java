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
	ArrayList<Palabra> words;
	ArrayList<Palabra> matchWords;
	
	@Override
	public void setup() {
		texts = loadStrings("./texto/string.txt");
	
		words = new ArrayList<Palabra>();
		
		matchWords = new ArrayList<Palabra>();

		for (int index = 0; index < texts.length; index++) {
		    String [] arrayWords = texts[index].split(" "); 
		    for (int j = 0; j < arrayWords.length; j++) {
		      words.add(new Palabra(arrayWords[j],(int)(random(20, 430)), (int)(random(-200, 500)), (int)(random(1, 3))));
		    }
	}
		for (int k = 0; k <= 3; k++) {
			   matchWords.add(new Palabra(words.get((int) random(words.size())).getWord(), 170+(k*50), 470, 3));
		}
	}
	
	@Override
	public void draw() {
		background(255);
		
		//Barrita de 4 palabras
		fill(200, 3, 90);
		rect(0, 450, 500, 30);
		
		fill(0);
		
		for (int index = 0; index < words.size(); index++) {
			  words.get(index).draw(this);
			  words.get(index).mover(this);
			  }
		
		for (int index = 0; index < matchWords.size(); index++) {
			fill(255);
			matchWords.get(index).draw(this);  
		}
		
	}
	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		super.mousePressed();
	}
	
	@Override
	public void mouseDragged() {
		// TODO Auto-generated method stub
		super.mouseDragged();
	}
	
	@Override
	public void mouseReleased() {
		// TODO Auto-generated method stub
		super.mouseReleased();
	}
	
	// metodo de comparar, se activa cuando esten cerca, 
	/*
	if(string.compareTo(string2)) {
		//elimine el objeto del arreglo words
		//cambie de color la palabra de matchWords
	}*/

}
