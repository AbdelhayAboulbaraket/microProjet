package myDAOs;

import java.util.List;

import myDb.DBConnect;


public abstract class DAO<T> {

	  DBConnect connect=null;
	   
	  public DAO(){
	    this.connect =DBConnect.getInstance();
	  }
	   

	  public abstract List<T> selectAll();
	  public abstract boolean create(T obj);
	  public abstract boolean delete(T obj);
	  public abstract boolean update(T obj);
	  public abstract T find(int id);
	
}
