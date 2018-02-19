package lab01.Datenbank.Person;

import java.util.List;

public interface DBPersonDao {
	
	public abstract void insertPerson(DBPerson p);
	public abstract void deletePerson(DBPerson p);
	public abstract List<DBPerson> findPersonByName(DBPerson p);;
	public abstract List<DBPerson> getAllPersons();
	
	public abstract void updatePersonVorname(DBPerson p);
	public abstract void updatePersonNachname(DBPerson p);
	public abstract void updatePersonGeschlecht(DBPerson p);
	public abstract void updatePersonTelefonnummer(DBPerson p);
	public abstract void updatePersonGeburtstag(DBPerson p);
	public abstract void updatePersonEmail(DBPerson p);
	public abstract void updatePersonNotizen(DBPerson p);
}