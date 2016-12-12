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

	public String get(String[] words, String[] trans){

		System.out.println(Arrays.toString(words));
		System.out.println(Arrays.toString(trans));

		if (wordList.isEmpty()){
			System.out.println("empty pa ang list");

		}else{
			System.out.println("dle na empty pa ang list");

		}




		return "naka sulod ko ani na function don****************";


	}

	public String[] stringToArray(String s){
		// String[] x = new String[3];

		List<String> myList = new ArrayList<String>(Arrays.asList(s.split("\\s+")));

		String[] array = new String[myList.size()];
		myList.toArray(array); // fill the array



		return array;

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
			         System.out.println(line + "------------------------------ mao ni siya si sb. to sstring");
			         // System.out.println(m.get());

			         // m.stringToArray(line);
			        // sb.append(System.lineSeparator());
			        


			        // asb.append(aline);
			          System.out.println(aline+ "------------------------------ mao ni siya si sb. to sstringAAAAAA");
			                // System.out.println(m.get());
			        // asb.append(System.lineSeparator());

			          System.out.println(m.get(m.stringToArray(line),m.stringToArray(aline)));
			          // m.get(m.stringToArray(line),m.stringToArray(aline));

			         line = br.readLine();
			         aline = abr.readLine();



			    }
			// everything = sb.toString();
			// aeverything = asb.toString();
			} catch(Exception e){  
         e.printStackTrace();
      }





      // System.out.println(everything+ "--------- maoo na ni si everything");
      // System.out.println(aeverything+ "--------- maoo na ni si everythingAAAAAAAAAAAA");
   }





}



// finally {
// 			    br.close();
// 			}}