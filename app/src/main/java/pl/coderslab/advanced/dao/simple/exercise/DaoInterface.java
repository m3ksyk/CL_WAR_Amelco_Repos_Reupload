package pl.coderslab.advanced.dao.simple.exercise;

import java.util.List;

public interface DaoInterface {

	public List<Model> loadAll();

	public Model loadById(int id);

	public void save(Model object);

	public void delete(Model object);

}
