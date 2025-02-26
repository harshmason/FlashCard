package flashcardSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FlashcardMAIN {
	private static int on = 0;

	public static void main(String[] args) {
		ArrayList<Flashcard> Flashcards = new ArrayList<Flashcard>();
		
		File txt = new File("FlashCards.txt");
		
		try {
			Scanner reader = new Scanner(txt);
			
			while(reader.hasNextLine()) {
				String Line = reader.nextLine();
				String [] div = Line.split(" ");
				String termI = div[0];
				String defI = div[1];
				Flashcard s = new Flashcard(termI, defI);
				Flashcards.add(s);
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();	}
		

		Scanner userID = new Scanner(System.in);
		while(on == 0) {
			System.out.println("Would you like to: 1. Make a new flashcard. 2. Study current flashcards. 3. Remove a flashcard. Type 0 to exit.");
			String choice = userID.nextLine();
			if (choice.equals("1")) {
				System.out.println("Term:");
				String typeTerm = userID.nextLine();
				System.out.println("Definition:");
				String typeDef = userID.nextLine();
				Flashcard s = new Flashcard(typeTerm, typeDef);
				Flashcards.add(s);
				s.display();
			}
			if (choice.equals("2")){
				for (int i=0; i < Flashcards.size(); i++) {
					String defprint = Flashcards.get(i).getDefinition();
					System.out.println(Flashcards.get(i).getTerm());
					System.out.println("Write the definition...");
					String answer = userID.nextLine();
					if (answer.equals(defprint)) {
						System.out.println("True!");}
						if (!answer.equals(defprint)){
							System.out.println("Wrong!");
						}
					
				}
			}
			if (choice.equals("3")){
				System.out.print("Write which term you'd like to remove:");
				String delete = userID.nextLine();
				for (int i = 0; i<Flashcards.size(); i++) {
					if (Flashcards.get(i).getTerm().equals(delete)) {
						Flashcards.remove(i);
					}
				}
			}
			if (choice.equals("0")) {
				on++;
				
			}

			}
		userID.close();
			
		try {
			PrintWriter writer = new PrintWriter("FlashCards.txt");
			for (Flashcard termdef : Flashcards) {
					writer.println((termdef.getTerm()) + " " + (termdef.getDefinition()));
					}
			writer.close();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}
		}
		
		
		

				
				
	}

