package DatenbankErinnerung;

import java.util.List;

public interface DBErinnerungDao {
	
	public abstract void insertErinnerung(DBErinnerung p);
	public abstract void deleteErinnerung(DBErinnerung p);
	public abstract List<DBErinnerung> getAllErinnerung();
	public abstract List<DBErinnerung> findErinnerungByName(DBErinnerung p);
	
	public abstract void updateErinnerungZeit(DBErinnerung p);
	public abstract void updateErinnerungDatum(DBErinnerung p);
	public abstract void updateErinnerungName(DBErinnerung p);
	public abstract void updateErledigt(DBErinnerung p);
	
}