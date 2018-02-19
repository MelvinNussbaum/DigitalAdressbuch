package lab01.Datenbank.Adresse;

import java.util.List;


public interface DBAdresseDao {
	
	public abstract void insertAdresse(DBAdresse p);
	public abstract void deleteAdresse(DBAdresse p);
	public abstract List<DBAdresse> findAdresseByName(DBAdresse p);
	public abstract List<DBAdresse> getAllAdresse();
	
	public abstract void updateAdresseStrasse(DBAdresse p);
	public abstract void updateAdressePostleitzahl(DBAdresse p);
	public abstract void updateAdresseOrt(DBAdresse p);
	public abstract void updateAdresseLand(DBAdresse p);
	
}