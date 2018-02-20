package DatenbankTermine;

import java.sql.Connection;

public class DBDemoTermine {

	public static void main(String[] args) {
		DBTermine p = new DBTermine();
		Connection con = DBConnectionTermine.getInstance().getConnection();
		DBTermineDao pd = new DBTermineJDBCDao(con);

		// p.setStartzeit("16:00 10.2.2018");
		// p.setEndzeit("16:30 10.2.2018");
		// p.setTerminname("Meeting Costa Cova");		/*Mit der Insertmethode kann man Termine erstellen und der Datenbank hinzufügen*/
		// p.setRelevanz("Wichtig");
		// pd.insertTermine(p);

		// p.setId(6);
		// pd.deleteTermine(p);				/*Hier kann man einen Termin löschen*/

		// p.setStartzeit("17:45 27.10.2018");
		// p.setId(2);							/*Hier kann man die Startzeit eines Termines bearbeiten*/
		// pd.updateTermineStartzeit(p);
		//
		// p.setEndzeit("21:25 27.10.2018");
		// p.setId(2);							/*Hier kann man die Endzeit eines Termines bearbeiten*/
		// pd.updateTermineEndzeit(p);
		//
		// p.setTerminname("Luca Geburtstag");
		// p.setId(2);							/*Hier kann man den Terminname eines Termines ändern*/
		// pd.updateTermineName(p);
		//
		// p.setRelevanz("Nicht Wichtig");
		// p.setId(2);							/*Hier kann man die Relevanz eines Termines bearbeiten*/
		// pd.updateTermineRelevanz(p);

		// for (DBTermine termine : pd.getAllTermine()) {
		// System.out.println(termine.toString());			/* Hiermit können alle Termine aufgelistet werden */
		// }

		p.setTerminname("Luca Geburtstag");
		for (DBTermine termine : pd.findTermineByName(p)) {		/*Hier kann man nach einem bestimmten Terminname suchen*/
			System.out.println(termine.toString());		
		}

		DBConnectionTermine.getInstance().closeConnection();
	}
}
