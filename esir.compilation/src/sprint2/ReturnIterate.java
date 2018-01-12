package sprint2;

import java.util.List;

public class ReturnIterate {

	private List<Code3Address> listCode;
	private String addr;
	
	public ReturnIterate(String addr, List<Code3Address> list) {
		this.addr=addr;
		this.listCode=list;
	}

	public List<Code3Address> getListCode() {
		return listCode;
	}

	public void setListCode(List<Code3Address> listCode) {
		this.listCode = listCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
