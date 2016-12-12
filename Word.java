import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
	String name;
	ArrayList<Trans> possible_trans;
   
   Word(){
   	this.possible_trans = new ArrayList<Trans>();
   }


   Word(String name){
   		this.name = name;
   		this.possible_trans = new ArrayList<Trans>();
   }
   
  public String getName(){
  	return this.name;
  }

 	public void setName(String name){
  	this.name = name;
  }




}

