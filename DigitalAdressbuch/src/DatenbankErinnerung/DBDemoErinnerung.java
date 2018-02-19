package DatenbankErinnerung;

import java.sql.Connection;

public class DBDemoErinnerung {

	public static void main(String[] args) {
		DBErinnerung p = new DBErinnerung();
		Connection con = DBConnectionErinnerung.getInstance().getConnection();
		DBErinnerungDao pd = new DBEinnerungJDBCDao(con);

//		p.setZeit("9:41");
//		p.setDatum("16. August 2016");
//		p.setErinnerungsname("Blumen giessen");
//		pd.insertErinnerung(p);

		
//		p.setId(3);
//		pd.deleteErinnerung(p);
		
//		p.setZeit("16:20");
//		p.setId(2);
//		pd.updateErinnerungZeit(p);
		
//		p.setDatum("16. Februar 2018");
//		p.setId(2);
//		pd.updateErinnerungDatum(p);
		
		p.setErinnerungsname("Melvin");
		p.setId(2);
		pd.updateErinnerungName(p);
//
//		
		
		for (DBErinnerung erinnerung : pd.getAllErinnerung()) {
			System.out.println(erinnerung.toString());
		}
		
//		p.setErinnerungsname("lappen weg klatschen");	
//		for (DBErinnerung erinnerung : pd.findErinnerungByName(p)) {
//		System.out.println(erinnerung.toString());
//		}
		

		DBConnectionErinnerung.getInstance().closeConnection();
	}	
}
