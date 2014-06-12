package remoteapps;

import java.util.ArrayList;

public class KeyRunner {
	
	ArrayList<int[]> strval;
	
	public KeyRunner() {
		strval = new ArrayList<int[]>();
		
	}
	
	public void addKeys(int[] KeysArray){
		this.strval.add(KeysArray);
	}

	public int[] getKeys(int id){
		return this.strval.get(id);
	}
	public int getKey(int keyID,int KeysArrayID){
		return strval.get(KeysArrayID)[keyID];
	}
	
	public ArrayList<int[]> getArrayList(){
		return this.strval;
	}
}