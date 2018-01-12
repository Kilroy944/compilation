package sprint2;

import java.util.List;

public class ReturnIterateCmd {

	private List<Code3Address> listCode;
	
	public ReturnIterateCmd(List<Code3Address> list) {
		this.listCode=list;
	}

	public List<Code3Address> getListCode() {
		return listCode;
	}

	public void setListCode(List<Code3Address> listCode) {
		this.listCode = listCode;
	}

}
