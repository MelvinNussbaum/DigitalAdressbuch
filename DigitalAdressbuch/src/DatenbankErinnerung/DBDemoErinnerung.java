package DatenbankErinnerung;

import java.sql.Connection;

public class DBDemoErinnerung {

	public static void main(String[] args) {
		DBErinnerung p = new DBErinnerung();
		Connection con = DBConnectionErinnerung.getInstance().getConnection();
		DBErinnerungDao pd = new DBErinnerungJDBCDao(con);

//		p.setZeit("9:41");
//		p.setDatum("16. August 2016");
//		p.setErinnerungsname("Blumen giessen");		/*Hier kann man eine Erinnerung erstellen */
//		pd.insertErinnerung(p);	

		
//		p.setId(3);
//		pd.deleteErinnerung(p);						/*Hier kann man eine Erinnerung löschen */ 
		
//		p.setZeit("16:20");
//		p.setId(2);									/*Hier kann man die Zeit einer bestimmten Erinnerung bearbeiten / ändern */
//		pd.updateErinnerungZeit(p);
		
//		p.setDatum("16. Februar 2018");
//		p.setId(2);									/*Hier kann man das Datum einer bestimmten Erinnerung bearbeiten / ändern */
//		pd.updateErinnerungDatum(p);
		
		p.setErinnerungsname("Melvin");
		p.setId(2);									/*Hier kann man den Namen einer bestimmten Erinnerung bearbeiten / ändern */
		pd.updateErinnerungName(p);
		
		for (DBErinnerung erinnerung : pd.getAllErinnerung()) {
			System.out.println(erinnerung.toString());		/*Mit dieser Methode kann man alle Erinnerungen printen lassen */
		}
		
//		p.setErinnerungsname("lappen weg klatschen");	
//		for (DBErinnerung erinnerung : pd.findErinnerungByName(p)) {   /*Mit diesem Befehl kann man nach einem bestimmten Erinnerungsnamen suchen */
//		System.out.println(erinnerung.toString());
//		}
		

		DBConnectionErinnerung.getInstance().closeConnection();
	}	
}
