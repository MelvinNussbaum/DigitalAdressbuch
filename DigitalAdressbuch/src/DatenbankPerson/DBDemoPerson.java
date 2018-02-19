package DatenbankPerson;

import java.sql.Connection;

public class DBDemoPerson {

	public static void main(String[] args) {
		DBPerson p = new DBPerson();
		Connection con = DBConnection.getInstance().getConnection();
		DBPersonDao pd = new DBPersonJDBCDao(con);

//		p.setVorname("Felix");
//		p.setNachname("Blume");
//		p.setGeschlecht("Männlich" );
//		p.setTelefonnummer("079 213 43 44");			/*Mit der Insertmethode kann man eine Person in der Datenbank einfügen*/
//		p.setGeburtstag("3. August 1984");
//		p.setEmail("Alphamusicempire@hotmail.de");
//		p.setNotizen("Rapper");
//		pd.insertPerson(p);

		
//		p.setId(6);
//		pd.deletePerson(p);							/*Hier kann man auswählen welche Person der Datenbank gelöscht werden sollte*/
		
//		p.setVorname("Farid");
//		p.setId(8);									/*Hier kann man den Vornamen von einer Person bearbeiten*/
//		pd.updatePersonVorname(p);
		
//		p.setNachname("El Abdellaoui");
//		p.setId(8);									/*Hier kann man den Nachnamen von einer Person bearbeiten*/	
//		pd.updatePersonNachname(p);
//		
//		p.setGeschlecht("Weiblich");
//		p.setId(8);									/*Hier kann man das Geschlecht von einer Person bearbeiten*/
//		pd.updatePersonGeschlecht(p);
//		
//		p.setTelefonnummer("078 310 25 17");
//		p.setId(8);									/*Hier kann man die Telefonnummer von einer Person bearbeiten*/
//		pd.updatePersonTelefonnummer(p);
//		
//		p.setGeburtstag("4. Juni 1986");
//		p.setId(8);									/*Hier kann man das Geburtstagsdatum von einer Person bearbeiten*/
//		pd.updatePersonGeburtstag(p);
//		
//		p.setEmail("Bangermusic@gmx.net");
//		p.setId(8);									/*Hier kann man die E-Mail Adresse von einer Person bearbeiten*/
//		pd.updatePersonEmail(p);
//		
//		p.setNotizen("Label Chef");
//		p.setId(8);									/*Hier kann man die Notizen über einee Person bearbeiten*/
//		pd.updatePersonNotizen(p);
//		
//		for (DBPerson person : pd.getAllPersons()) {
//			System.out.println(person.toString());			/*Hier können alle Personen aufgelistet werden*/
//		}
		
		
		p.setVorname("Felix");	
		for (DBPerson person : pd.findPersonByName(p)) {
		System.out.println(person.toString());				/*Hier kann man nach einem bestimmten Vorname suchen*/ 
		}
		DBConnection.getInstance().closeConnection();
	}	
}
