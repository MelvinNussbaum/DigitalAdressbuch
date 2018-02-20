package DatenbankAdresse;

import java.sql.Connection;

public class DBDemoAdresse {

	public static void main(String[] args) {
		DBAdresse p = new DBAdresse();
		Connection con = DBConnectionAdresse.getInstance().getConnection();
		DBAdresseDao pd = new DBAdresseJDBCDao(con);

//		p.setStrasse("Staufenstrasse 115");
//		p.setPostleitzahl("8157");
//		p.setOrt("Nordrhein-Westfalen");		/*Hier kann man eine neue Adresse erstellen*/
//		p.setLand("Vatikan");
//		pd.insertAdresse(p);

		
//		p.setId(4);
//		pd.deleteAdresse(p);					/*Hier kann man eine bestimmten Adresse löschen*/
		
		p.setStrasse("Landgrafenstrasse 96");
		p.setId(2);								/*Hier kann man die Strasse einer bestimmten Adresse ändern*/
		pd.updateAdresseStrasse(p);
		
		p.setPostleitzahl("8304");
		p.setId(2);								/*Hier kann man die Postleitzahl einer bestimmten Adresse ändern*/
		pd.updateAdressePostleitzahl(p);
		
		p.setOrt("Nordrhein-Westfalen");
		p.setId(2);								/*Hier kann man den Ort einer bestimmten Andresse ändern*/
		pd.updateAdresseOrt(p);
		
		p.setLand("Vatikan");
		p.setId(2);								/*Hier kann man das Land einer bestimmten Adresse ändern*/
		pd.updateAdresseLand(p);
		
		
		for (DBAdresse adresse : pd.getAllAdresse()) {
			System.out.println(adresse.toString());		/*Mit dieser Methode werden alle Adressen geprintet*/
		}
		
		
//		p.setStrasse("Sesamstrasse 45");	
//		for (DBAdresse adresse : pd.findAdresseByName(p)) {		/*Hier kann man nach einer Strasse suchen und danach werden alle Adresseinfos geprintet */
//		System.out.println(adresse.toString());
//		}
		
		DBConnectionAdresse.getInstance().closeConnection();
	}	
}
