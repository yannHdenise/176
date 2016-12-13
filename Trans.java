public class Trans{
	String name;
	int count;

	Trans(){

	}
	Trans(String name){
		this.name = name;
		this.count = 0;
	}

	public String getName(){
  		return this.name;
  	}
  	public int getCount(){
  		return this.count;
  	}
  	public void addCount(){
  		count++;
  	}

  	
 	public void setName(String name){
  	this.name = name;
  }

}