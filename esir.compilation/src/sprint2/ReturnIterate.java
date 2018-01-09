package sprint2;

import java.util.ArrayList;

public class ReturnIterate {

	private ArrayList<Code3Address> listCode;
	private String addr;
	
	public ReturnIterate(String addr,ArrayList<Code3Address> list){
		this.addr=addr;
		this.listCode=list;
	}

	public ArrayList<Code3Address> getListCode() {
		return listCode;
	}

	public void setListCode(ArrayList<Code3Address> listCode) {
		this.listCode = listCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
