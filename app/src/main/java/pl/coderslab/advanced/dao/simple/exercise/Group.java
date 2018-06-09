package pl.coderslab.advanced.dao.simple.exercise;

public class Group implements Model {

	private Long id;
	private String name;

	public Group(String name) {
		this(null, name);
	}

	public Group(Long id, String name) {

		this.id = id;
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public Group setName(String name) {
		this.name = name;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", getId(), getName());
	}

}