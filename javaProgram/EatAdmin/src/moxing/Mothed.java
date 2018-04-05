package moxing;


import shujuku.DataSql;

public class Mothed {
	public String checkPass(String name,String password){
		String position=null;
		DataSql data=new DataSql();
		position=data.getposition(name, password);
		return position;
	}
}
