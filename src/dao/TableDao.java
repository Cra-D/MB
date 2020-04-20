package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Data;
import bean.Table;

public class TableDao extends DBOper{
	
	public Table getObject(String sql,int crrentPage){//分页查询
	 
		
		Table table = new Table();
		crrentPage=(crrentPage==0?0:crrentPage-1);
		sql+=" limit "+crrentPage*10+",10";//默认每页显示
		ArrayList<Data> datalist = new ArrayList<Data>();
		
		
		ResultSet rs = executeQuery(sql,null);
		ResultSetMetaData resultSetMetaData;
	
		try {
			resultSetMetaData = rs.getMetaData();
			/***Column ******/
			 List<String> columlist = new ArrayList<String>();
            int columnCount = resultSetMetaData.getColumnCount();
			for(int i=1;i<=columnCount;i++){	
				System.out.println("columlist.add("+resultSetMetaData.getColumnName(i));
				columlist.add(resultSetMetaData.getColumnName(i));

			}		
		
			/**Data **/
			while(rs.next()){
				Data data = new Data();
				 List<Object>  Objlist = new ArrayList<Object>();

				for(int i=1;i<=columnCount;i++){
				
					Objlist.add(rs.getObject(i));
				
					}
				data.setObjectlist(Objlist);
		 
				table.setColumnlist(columlist);
			    datalist.add(data);
			    table.setDatalist(datalist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;	
	}

	
	
}
