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

		this.wordList = new ArrayList<Word>();

	}

	public boolean toWordList(String[] words, String[] trans){

		System.out.println(Arrays.toString(words));
		System.out.println(Arrays.toString(trans));

		if (wordList.isEmpty() == false){
			System.out.println("dle siya empty");

			//mag checking cya
		}



		for (int i = 0; i < words.length; i++) {
					Word x = new Word();
					x.setName(words[i]);
					wordList.add(x);
					// System.out.println("word name: "+x.getName());

					//wala pa nichecking where i check if naa na na ni occur
				for (int j = 0; j < trans.length; j++) {
					Trans g =new Trans();
					g.setName(trans[j]);
					x.possible_trans.add(g);	

					// System.out.println("trans name: --------------------- "+g.getName());
				}
			}


		// 	String[] array = new String[wordList.size()];
		// wordList.toArray(array); // fill the array
		// System.out.println(array);




		



		return true;


	}

	public String[] stringToArray(String s){
		// String[] x = new String[3];

		List<String> myList = new ArrayList<String>(Arrays.asList(s.split("\\s+")));

		String[] array = new String[myList.size()];
		myList.toArray(array); // fill the array



		return array;

	}

	public void printing(){

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



	 public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
     // Word x = new Word("hello");
     // x.possible_trans.add(new Trans("shet"));

     // System.out.println(x.getName());
     // System.out.println(x.possible_trans.get(0).name);
     // System.out.println(x.possible_trans.get(0).count);
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
			        // sb.append(line);
			         // System.out.println(line + "------------------------------ mao ni siya si sb. to sstring");
			         // System.out.println(m.get());

			         // m.stringToArray(line);
			        // sb.append(System.lineSeparator());
			        


			        // asb.append(aline);
			          // System.out.println(aline+ "------------------------------ mao ni siya si sb. to sstringAAAAAA");
			                // System.out.println(m.get());
			        // asb.append(System.lineSeparator());

			          System.out.println(m.toWordList(m.stringToArray(line),m.stringToArray(aline)));
			          // m.get(m.stringToArray(line),m.stringToArray(aline));

			         line = br.readLine();
			         aline = abr.readLine();



			    }
			// everything = sb.toString();
			// aeverything = asb.toString();
			} catch(Exception e){  
         e.printStackTrace();
      }

      m.printing();




      // System.out.println(everything+ "--------- maoo na ni si everything");
      // System.out.println(aeverything+ "--------- maoo na ni si everythingAAAAAAAAAAAA");
   }





}



// finally {
// 			    br.close();
// 			}}