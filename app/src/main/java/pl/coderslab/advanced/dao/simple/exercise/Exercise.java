package pl.coderslab.advanced.dao.simple.exercise;

public class Exercise implements Model{
    private Long id;
    private String title;
    private String description;

    public Exercise(String title, String description) {
        this(null, title, description);
    }

    public Exercise(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
