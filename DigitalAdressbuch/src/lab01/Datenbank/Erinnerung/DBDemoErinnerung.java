package lab01.Datenbank.Erinnerung;

import java.sql.Connection;

import DatenbankErinnerung.DBConnectionErinnerung;
import DatenbankErinnerung.DBErinnerung;
import DatenbankErinnerung.DBErinnerungDao;
import DatenbankErinnerung.DBErinnerungJDBCDao;

public class DBDemoErinnerung {

	public static void main(String[] args) {
		DBErinnerung p = new DBErinnerung();
		Connection con = DBConnectionErinnerung.getInstance().getConnection();
		DBErinnerungDao pd = new DBErinnerungJDBCDao(con);

		p.setZeit("9:41");
		p.setDatum("16. August 2016");
		p.setErinnerungsname("Blumen giessen");
		pd.insertErinnerung(p);

		
		p.setId(10);
		pd.deleteErinnerung(p);
		
//		p.setZeit("16:20");
//		p.setId(2);
//		pd.updateErinnerungZeit(p);
		
//		p.setDatum("16. Februar 2018");
//		p.setId(2);
//		pd.updateErinnerungDatum(p);
//		
//		p.setErinnerungsname("Melvin");
//		p.setId(2);
//		pd.updateErinnerungName(p);
//
//		
		
//		for (DBErinnerung erinnerung : pd.getAllErinnerung()) {
//			System.out.println(erinnerung.toString());
//		}
		
		p.setErinnerungsname("Blumen giessen");	
		for (DBErinnerung erinnerung : pd.findErinnerungByName(p)) {
		System.out.println(erinnerung.toString());
		}
		

		DBConnectionErinnerung.getInstance().closeConnection();
	}	
}
