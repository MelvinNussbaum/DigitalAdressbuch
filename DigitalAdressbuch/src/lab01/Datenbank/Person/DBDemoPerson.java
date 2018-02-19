package lab01.Datenbank.Person;

import java.sql.Connection;

public class DBDemoPerson {

	public static void main(String[] args) {
		DBPerson p = new DBPerson();
		Connection con = DBConnection.getInstance().getConnection();
		DBPersonDao pd = new DBPersonJDBCDao(con);

//		p.setVorname("Felix");
//		p.setNachname("Blume");
//		p.setGeschlecht("Männlich" );
//		p.setTelefonnummer("079 213 43 44");
//		p.setGeburtstag("3. August 1984");
//		p.setEmail("Alphamusicempire@hotmail.de");
//		p.setNotizen("Rapper");
//		pd.insertPerson(p);

		
//		p.setId(6);
//		pd.deletePerson(p);
		
//		p.setVorname("Farid");
//		p.setId(8);
//		pd.updatePersonVorname(p);
		
//		p.setNachname("El Abdellaoui");
//		p.setId(8);
//		pd.updatePersonNachname(p);
//		
//		p.setGeschlecht("Weiblich");
//		p.setId(8);
//		pd.updatePersonGeschlecht(p);
//		
//		p.setTelefonnummer("078 310 25 17");
//		p.setId(8);
//		pd.updatePersonTelefonnummer(p);
//		
//		p.setGeburtstag("4. Juni 1986");
//		p.setId(8);
//		pd.updatePersonGeburtstag(p);
//		
//		p.setEmail("Bangermusic@gmx.net");
//		p.setId(8);
//		pd.updatePersonEmail(p);
//		
//		p.setNotizen("Label Chef");
//		p.setId(8);
//		pd.updatePersonNotizen(p);
//		
//		for (DBPerson person : pd.getAllPersons()) {
//			System.out.println(person.toString());
//		}
		
		
		p.setVorname("Felix");	
		for (DBPerson person : pd.findPersonByName(p)) {
		System.out.println(person.toString());
		}
		DBConnection.getInstance().closeConnection();
	}	
}
