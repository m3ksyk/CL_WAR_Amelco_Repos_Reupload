package pl.coderslab.advanced.dao.simple.exercise;

public class User implements Model{

    private Long id;
    private String name;
    private Group group;


    public User(String name, Group group) {

        this(null, name, group);
    }

    public User(Long id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getId() {

        return id;
    }

    @Override
    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name;
    }
}
