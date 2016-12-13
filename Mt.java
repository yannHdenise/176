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

		if (wordList.isEmpty() == false){
			System.out.println("dle siya empty");

			//DIRI DAPAT MAG CHECKING IFNAA NA PA ANG WORD OR NOT
		
			// This loop parses a String array and checks if a particular word entry is already existing in the wordList
			for (int i = 0; i < words.length; i++) {									

				boolean isWordExisting = inWordList(words[i]); 						// Check if a particular word entry, is already in wordList 
				if (isWordExisting == true) {										// If it's already in the wordList, it calls a function
					// Call Kim's function
					
				} else {
					wordList.add(words[i]); 										// If it's not, then the String is added
				}
			} // end for loop

		}



		for (int i = 0; i < words.length; i++) {		//KANI NESTED FOR LOOP KAY PARA IBUTANG ANG ARRAY NA WORD SA WORDLIST 
					Word x = new Word();
					x.setName(words[i]);
					wordList.add(x);
					// System.out.println("word name: "+x.getName());

					//wala pa nichecking where i check if naa na na ni occur
				for (int j = 0; j < trans.length; j++) {  		//DAYUN ANG SULOD SA ARRAY NA trans KAY I HIMO UG TRANS NA OBJECT AND I SULOD SA ARRAY LIST SULOD SA WORD OBJ
					Trans g =new Trans();
					g.setName(trans[j]);
					x.possible_trans.add(g);	



					// System.out.println("trans name: --------------------- "+g.getName());
				}
			}


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
	public boolean inWordList (String passed) {

		/* A loop to traverse the wordList */
		for (int i = 0; i < wordList.size(); i++) {
			Word retrieved = (Word) wordList.get(i); 									// retrieve a word based on the index
			if (retrieved.getName().equals(passed)) {									// if the current name of the word matched the passed String
				return true;															// we return true
			}
		} // end for loop

		return false;																	// otherwise, we return false
	}



	 public static void main(String[] args) { // BASICALLY TANAN NAA SA MAIN KAY FILE READING AND  PAG TAWAG SA FUNCTIONS NA NAA SA MT

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

      //m.printing();

   }





}

