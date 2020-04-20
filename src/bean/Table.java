package bean;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private  List<Data> datalist = new ArrayList<Data>();
	
	private  List<String> columnlist = new ArrayList<String>();

	public  List<String> getColumnlist() {
		return columnlist;
	}

	public void setColumnlist( List<String> columnlist) {
		this.columnlist = columnlist;
	}
	public  List<Data> getDatalist() {
		return datalist;
	}
	public void setDatalist( List<Data> datalist) {
		this.datalist = datalist;
	}
	
	
}
