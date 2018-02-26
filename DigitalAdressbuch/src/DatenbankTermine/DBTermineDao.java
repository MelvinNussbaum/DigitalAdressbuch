package DatenbankTermine;

import java.util.List;


public interface DBTermineDao {
	
	public abstract void insertTermine(DBTermine p);
	public abstract void deleteTermine(DBTermine p);
	public abstract List<DBTermine> findTermineByName(DBTermine p);
	public abstract List<DBTermine> getAllTermine();
	
	public abstract void updateTermineDatum(DBTermine p);
	public abstract void updateTermineStartzeit(DBTermine p);
	public abstract void updateTermineEndzeit(DBTermine p);
	public abstract void updateTermineName(DBTermine p);
	public abstract void updateTermineFarbe(DBTermine p);
	public abstract void updateTermineRelevanz(DBTermine p);
	
}