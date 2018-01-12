package sprint2;

import java.util.List;

public class ReturnIterateExpr {

	private List<Code3Address> listCode;
	private List<String> listAddr;
	
	public ReturnIterateExpr(List<String> addr, List<Code3Address> list) {
		this.listAddr = addr;
		this.listCode=list;
	}

	public List<Code3Address> getListCode() {
		return listCode;
	}

	public void setListCode(List<Code3Address> listCode) {
		this.listCode = listCode;
	}

	public List<String> getListAddr() {
		return listAddr;
	}

	public void setListAddr(List<String> addr) {
		this.listAddr = addr;
	}
	
	public int getNbAddr() {
		return listAddr.size();
	}
	
}
