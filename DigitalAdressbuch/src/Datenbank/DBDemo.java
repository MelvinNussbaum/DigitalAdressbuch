package Datenbank;

import java.sql.Connection;

public class DBDemo {

	public static void main(String[] args) {
		DBPerson p = new DBPerson();
		Connection con = DBConnection.getInstance().getConnection();
		DBPersonDao pd = new DBPersonJDBCDao(con);

		p.setVorname("Felix");
		p.setNachname("Blume");
		p.setGeschlecht("Männlich" );
		p.setTelefonnummer("079 213 43 44");
		p.setGeburtstag("3. August 1984");
		p.setEmail("Alphamusicempire@hotmail.de");
		p.setNotizen("Rapper");
		pd.insertPerson(p);

		for (DBPerson person : pd.getAllPersons()) {
			System.out.println(person.toString());
		}
		
		DBConnection.getInstance().closeConnection();
	}
}
