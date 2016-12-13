import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;

public class Mt{

	ArrayList wordList;

	Mt(){

		this.wordList = new ArrayList<Word>();		//Array list of words

	}

	public boolean toWordList(String[] words, String[] trans){

		System.out.println(Arrays.toString(words));
		System.out.println(Arrays.toString(trans));

		// if (wordList.isEmpty() == false){
		// 	System.out.println("dle siya empty");
		
			// This loop parses a String array and checks if a particular word entry is already existing in the wordList
			for (int i = 0; i < words.length; i++) {									

				Word isWordExisting = inWordList(words[i]); 						// Check if a particular word entry, is already in wordList 
				if (isWordExisting != null) {										// If it's already in the wordList, it calls a function
					// Call Kim's function
					System.out.println(isWordExisting.getName() + " is duplicated!");
					//inTransList(isWordexisting);
					for(int j = 0; j < trans.length; j++){
						inTransList(isWordExisting, trans[j]);
					}

				} else {
					Word new_word = new Word(words[i]);

					for(int j = 0; j < trans.length; j++){
						inTransList(new_word, trans[j]);
					}

					wordList.add(new_word); 

															// If it's not, then the String is added to the wordList
				

				}
			} // end for loop

		// }



		// for (int i = 0; i < words.length; i++) {		//KANI NESTED FOR LOOP KAY PARA IBUTANG ANG ARRAY NA WORD SA WORDLIST 
		// 			Word x = new Word();
		// 			x.setName(words[i]);
		// 			wordList.add(x);
		// 			// System.out.println("word name: "+x.getName());

		// 			//wala pa nichecking where i check if naa na na ni occur
		// 		for (int j = 0; j < trans.length; j++) {  		//DAYUN ANG SULOD SA ARRAY NA trans KAY I HIMO UG TRANS NA OBJECT AND I SULOD SA ARRAY LIST SULOD SA WORD OBJ
		// 			Trans g =new Trans(trans[j]);
		// 			// g.setName(trans[j]);
		// 			x.possible_trans.add(g);	



		// 			// System.out.println("trans name: --------------------- "+g.getName());
		// 		}
		// 	}


		return true;


	}

	public String[] stringToArray(String s){// I CONVERT NIYA ANG STRING INTO ARRAY OF STRINGS
		// String[] x = new String[3];

		List<String> myList = new ArrayList<String>(Arrays.asList(s.split("\\s+")));

		String[] array = new String[myList.size()];
		myList.toArray(array); // fill the array



		return array;

	}

	public void printing(){// I PRINT NIYA TANAN SULOD SA WORDLIST NA ARRAY LIST

		int i = 0;
		

		while (i < wordList.size()) {
			Word a = (Word)wordList.get(i);
			System.out.println( a.getName());
			System.out.println( "size =================="+a.possible_trans.size());
				
				int j = 0;
				while (j < a.possible_trans.size()) {
					Trans b = (Trans)a.possible_trans.get(j);
					System.out.println( "inside---------------------"+b.getName());
					System.out.println( "inside----------------------"+b.getCount());

					
					j++;
				}



			i++;
		}



	}


	// This function checks if a particular word (String) is already existing in the ArrayList called wordList
	public Word inWordList (String passed) {

		/* A loop to traverse the wordList */
		for (int i = 0; i < wordList.size(); i++) {
			Word retrieved = (Word) wordList.get(i); 									// retrieve a word based on the index
			if (retrieved.getName().equals(passed)) {									// if the current name of the word matched the passed String
				return retrieved;														// we return the Word itself
			}
		} // end for loop

		return null;																	// otherwise, we return null
	}

	// This function checks if a particular wordtranslation (String) is already existing in the ArrayList called possible_trans
	public void inTransList (Word passed, String trans_name) {

		/* A loop to traverse the possible_trans*/
		for (int i = 0; i < passed.possible_trans.size(); i++) {
			Trans retrieved = (Trans) passed.possible_trans.get(i); 									// retrieve a word based on the index
			if (retrieved.getName().equals(trans_name)) {									// if the current name of the word matched the passed String
				passed.possible_trans.get(i).addCount();															// we return true
			}
		} // end for loop
		passed.possible_trans.add(new Trans(trans_name));																// otherwise, we return false
	}

	// This function receives a String[] sentence, then returns a "translated" String[]
	public String[] translateSentence (String[] sentence) {
		String[] translated = new String[sentence.length]; 								// this will contain the translated counterpart of the sentence array (hence the same length)
					
		/* this loop will traverse the String array sentence*/																	
		for (int i = 0; i < sentence.length; i++) {										
			String tempWord = sentence[i];												// tempWord holds the current word in the sentence
			Word existingWord = inWordList(tempWord); 									// call inWordList function which will return a Word object if String is found, and null when it didn't

			if (existingWord != null) { 												// if the tempWord is indeed in the wordList

				// traverse through the array called possible_trans, and then traverse the getCount of each count object, then get the biggest one
				ArrayList<Trans> translationsArray = existingWord.possible_trans;
				Trans mostCount= translationsArray.get(0);

				/* this loop will traverse through the translationsArray and get the Trans object with the most count */
				for (int j = 0; j < translationsArray.size(); j++) {
					if (translationsArray.get(j).getCount() > mostCount.getCount()) {
						mostCount = translationsArray.get(j);
					}

				}

				translated[i] = mostCount.getName(); 									// the one with the most count will be the translated String

			} else {
				translated[i] = sentence[i]; 											// the same word is stored in the translated array****
			}
			
		}

		return translated;

	}


	 public static void main(String[] args) { // BASICALLY TANAN NAA SA MAIN KAY FILE READING AND  PAG TAWAG SA FUNCTIONS NA NAA SA MT //

	 		Mt m = new Mt();
	 		String everything ="";
	 		String aeverything ="";
	 
			try {
				BufferedReader br = new BufferedReader(new FileReader("file.txt"));
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();


			    BufferedReader abr = new BufferedReader(new FileReader("Afile.txt"));
			    StringBuilder asb = new StringBuilder();
			    String aline = abr.readLine();

			    while (line != null) {
			        
			          System.out.println(m.toWordList(m.stringToArray(line),m.stringToArray(aline)));
			          // m.get(m.stringToArray(line),m.stringToArray(aline));

			         line = br.readLine();
			         aline = abr.readLine();
			    }
			} catch(Exception e){  
         e.printStackTrace();
      }

      m.printing();

   }





}

