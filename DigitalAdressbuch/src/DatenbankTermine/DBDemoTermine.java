package DatenbankTermine;

import java.sql.Connection;

public class DBDemoTermine {

	public static void main(String[] args) {
		DBTermine p = new DBTermine();
		Connection con = DBConnectionTermine.getInstance().getConnection();
		DBTermineDao pd = new DBTermineJDBCDao(con);

//		p.setStartzeit("16:00 10.2.2018");
//		p.setEndzeit("16:30 10.2.2018");
//		p.setTerminname("Meeting Costa Cova");
//		p.setRelevanz("Wichtig");
//		pd.insertTermine(p);

		
//		p.setId(6);
//		pd.deleteTermine(p);
		
//		p.setStartzeit("17:45 27.10.2018");
//		p.setId(2);
//		pd.updateTermineStartzeit(p);
//		
//		p.setEndzeit("21:25 27.10.2018");
//		p.setId(2);
//		pd.updateTermineEndzeit(p);
//		
//		p.setTerminname("Luca Geburtstag");
//		p.setId(2);
//		pd.updateTermineName(p);
//		
//		p.setRelevanz("Nicht Wichtig");
//		p.setId(2);
//		pd.updateTermineRelevanz(p);
		
		
//		for (DBTermine termine : pd.getAllTermine()) {
//			System.out.println(termine.toString());
//		}
		
		
		p.setTerminname("Luca Geburtstag");	
		for (DBTermine termine : pd.findTermineByName(p)) {
		System.out.println(termine.toString());
		}
		
		DBConnectionTermine.getInstance().closeConnection();
	}	
}
