package flashcardSet;

import java.util.ArrayList;

public class Flashcard {
	private String term;
	private String definition;
	ArrayList<String> flashcardtermlst = new ArrayList<>();
	ArrayList<String> flashcarddeflst = new ArrayList<>();
	
	public Flashcard(String term, String definition) {
		this.term = term;
		this.definition = definition;
		
	}
		public String getTerm() {
			return term;
		}
		public String getDefinition() {
			return definition;
		}
		
		public void display() {
			System.out.println("Term: " + term);
			System.out.println("Definition: " + definition);
		}

		public void study() {
	
		}
	}
	
	

