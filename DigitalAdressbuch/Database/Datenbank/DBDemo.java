package Datenbank;

import java.sql.Connection;

public class DBDemo {

	public static void main(String[] args) {
		DBPerson p = new DBPerson();
		Connection con = DBConnection.getInstance().getConnection();
		DBPersonDao pd = new DBPersonJDBCDao(con);

		p.setVorname("Kristoffer");
		p.setNachname("Klauss");
		p.setGeschlecht("Männlich" );
		p.setTelefonnummer("076 187 42 29");
		p.setGeburtstag("29. Juni 1988");
		p.setEmail("teamplatin@gmail.de");
		p.setNotizen("Basketballspieler");
		pd.insertPerson(p);

		for (DBPerson person : pd.getAllPersons()) {
			System.out.println(person.toString());
		}
		
		DBConnection.getInstance().closeConnection();
	}
}
