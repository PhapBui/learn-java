package database;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();
	public T selectById(T t);
	
	public int insert(T t);
	public int inserAll(ArrayList<T> arr);
		
	public int remove(T t);
	public int removeAll(ArrayList<T> arr);
	
	public int update(T t);
	
}
