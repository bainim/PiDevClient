package com.picturenetwork.ui;

import java.util.HashMap;
import java.util.Map;

public class Session {

private static Session instance;
	
    private Session(){ 
		store= new HashMap<>();// HashMap : sans ordre des attribut
	}
	
	
	public synchronized static Session getinstance() {
		
		if(instance == null){
			instance = new Session ();
		}
		return instance;
	}
	
	//************** c'est la fin du partie singletant*******************//

	private Map<String, Object> store;

	public Map<String, Object> getStore() {
		return store;
	}

	public void setStore(Map<String, Object> store) {
		this.store = store;
	}
}
