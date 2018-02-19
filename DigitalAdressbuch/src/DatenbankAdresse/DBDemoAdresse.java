package DatenbankAdresse;

import java.sql.Connection;

public class DBDemoAdresse {

	public static void main(String[] args) {
		DBAdresse p = new DBAdresse();
		Connection con = DBConnectionAdresse.getInstance().getConnection();
		DBAdresseDao pd = new DBAdresseJDBCDao(con);

//		p.setStrasse("Staufenstrasse 115");
//		p.setPostleitzahl("8157");
//		p.setOrt("Nordrhein-Westfalen");
//		p.setLand("Vatikan");
//		pd.insertAdresse(p);

		
//		p.setId(4);
//		pd.deleteAdresse(p);
		
		p.setStrasse("Landgrafenstrasse 96");
		p.setId(2);
		pd.updateAdresseStrasse(p);
		
		p.setPostleitzahl("8304");
		p.setId(2);
		pd.updateAdressePostleitzahl(p);
		
		p.setOrt("Nordrhein-Westfalen");
		p.setId(2);
		pd.updateAdresseOrt(p);
		
		p.setLand("Vatikan");
		p.setId(2);
		pd.updateAdresseLand(p);
		
		
		for (DBAdresse adresse : pd.getAllAdresse()) {
			System.out.println(adresse.toString());
		}
		
		
//		p.setStrasse("Sesamstrasse 45");	
//		for (DBAdresse adresse : pd.findAdresseByName(p)) {
//		System.out.println(adresse.toString());
//		}
		
		DBConnectionAdresse.getInstance().closeConnection();
	}	
}
