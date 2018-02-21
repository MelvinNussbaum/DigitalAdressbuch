package DatenbankPerson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBPersonJDBCDao implements DBPersonDao {

	private Connection con = null;

	public DBPersonJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertPerson(DBPerson p) {
		try {
			String sql = "INSERT INTO person (vorname, nachname, geschlecht, telefonnummer, geburtstag, email, notizen, termine_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getNachname());
			ps.setString(3, p.getGeschlecht());
			ps.setString(4, p.getTelefonnummer());			/*Mit der Insertmethode kann man eine Person der Datenbank hinzufügen*/ 
			ps.setString(5, p.getGeburtstag());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getNotizen());
			ps.setInt(8, p.getTermine_id());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Insert Complete.");
		}
	}

	public List<DBPerson> findPersonByName(DBPerson p) {
		try {
			List<DBPerson> persons = new ArrayList<DBPerson>();
			String sql = "SELECT * FROM person where vorname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getVorname());
			ResultSet rs = ps.executeQuery();				/*Mit dieser Methode kann man eine bestimmte Person beim Namen suchen*/
			while (rs.next()) {
				p = new DBPerson();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setGeschlecht(rs.getString("geschlecht"));
				p.setTelefonnummer(rs.getString("telefonnummer"));
				p.setGeburtstag(rs.getString("geburtstag"));
				p.setEmail(rs.getString("email"));
				p.setNotizen(rs.getString("notizen"));
				persons.add(p);}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<DBPerson> getAllPersons() {
		try {
			List<DBPerson> persons = new ArrayList<DBPerson>();
			DBPerson p = null;
			String sql = "SELECT * FROM person";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBPerson();
				p.setId(rs.getInt("id"));					/*Mit dieser Methode kann man sich alle Personen anzeigen lassen*/
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setGeschlecht(rs.getString("geschlecht"));
				p.setTelefonnummer(rs.getString("telefonnummer"));
				p.setGeburtstag(rs.getString("geburtstag"));
				p.setEmail(rs.getString("email"));
				p.setNotizen(rs.getString("notizen"));
				p.setTermine_id(rs.getInt("termine_id"));
				persons.add(p);}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void deletePerson(DBPerson p) {
		try {
			String sql = "DELETE FROM person WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.executeUpdate();								/*Mit dieser Methode kann man eine Person löschen*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Delete Complete.");
		}
	}
	
	public void updatePersonVorname(DBPerson p) {
		try {
			String sql = "Update person set vorname = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getVorname());
			ps.setInt(2, p.getId());
			ps.executeUpdate();								/*Mit dieser Methode kann man den Vornamen einer Person ändern */
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Vorname Complete. ");
		}
	}
	public void updatePersonNachname(DBPerson p) {
		try {
			String sql = "Update person set nachname = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNachname());
			ps.setInt(2, p.getId());
			ps.executeUpdate();						/* Mit dieser Methode kann man den Nachnamen einer Person ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Nachname Complete. ");
		}
	}
	public void updatePersonGeschlecht(DBPerson p) {
		try {
			String sql = "Update person set geschlecht = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getGeschlecht());
			ps.setInt(2, p.getId());
			ps.executeUpdate();					/* Mit dieser Methode kann man das Geschlecht einer Person ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Geschlecht Complete. ");
		}
	}
	public void updatePersonTelefonnummer(DBPerson p) {
		try {
			String sql = "Update person set Telefonnummer = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getTelefonnummer());
			ps.setInt(2, p.getId());
			ps.executeUpdate();						/* Mit dieser Methode kann man die Telefonnummer einer Person ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Telefon Complete. ");
		}
	}
	public void updatePersonGeburtstag(DBPerson p) {
		try {
			String sql = "Update person set geburtstag = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getGeburtstag());
			ps.setInt(2, p.getId());
			ps.executeUpdate();						/* Mit dieser Methode kann man kann man das Geburtstagsdatum ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Geburtstag Complete. ");
		}
	}
	public void updatePersonEmail(DBPerson p) {
		try {
			String sql = "Update person set email = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getEmail());
			ps.setInt(2, p.getId());
			ps.executeUpdate();						/* Mit dieser Methode kann man die E-Mail Adresse einer Person ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Email Complete. ");
		}
	}
	public void updatePersonNotizen(DBPerson p) {
		try {
			String sql = "Update person set notizen = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNotizen());
			ps.setInt(2, p.getId());
			ps.executeUpdate();						/* Mit dieser Methode kann man die Notizen über eine Person ändern */
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Notizen Complete. ");
		}
	}
	
	public List<DBPerson> getAllKontakte() {
		try {
			List<DBPerson> persons = new ArrayList<DBPerson>();
			DBPerson p = null;
			String sql = "SELECT vorname, nachname FROM person";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBPerson();				/*Mit dieser Methode kann man sich alle Personen anzeigen lassen*/
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				persons.add(p);}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	public List<DBPerson> getAllPersonsTermine() {
		try {
			List<DBPerson> persons = new ArrayList<DBPerson>();
			DBPerson p = null;
			String sql = "SELECT person.*, termine.* from person join termine on person.termine_id=termine.id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBPerson();
				p.setId(rs.getInt("id"));					/*Mit dieser Methode kann man sich alle Personen anzeigen lassen*/
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setGeschlecht(rs.getString("geschlecht"));
				p.setTelefonnummer(rs.getString("telefonnummer"));
				p.setGeburtstag(rs.getString("geburtstag"));
				p.setEmail(rs.getString("email"));
				p.setNotizen(rs.getString("notizen"));
				p.setTermine_id(rs.getInt("termine_id"));
				p.setTerminname(rs.getString("terminname"));
				p.setStartzeit(rs.getString("startzeit"));
				p.setEndzeit(rs.getString("endzeit"));
				p.setRelevanz(rs.getString("relevanz"));
				persons.add(p);}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}