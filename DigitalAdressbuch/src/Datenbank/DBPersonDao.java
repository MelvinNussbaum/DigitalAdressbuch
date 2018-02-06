package Datenbank;

import java.util.List;

public interface DBPersonDao {
	
	public abstract void insertPerson(DBPerson p);
	public abstract void updatePerson(DBPerson p);
	public abstract DBPerson findPersonById(String vorname);
	public abstract List<DBPerson> getAllPersons();
}