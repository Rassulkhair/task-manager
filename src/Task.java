public class Task {
    private int id;
    private String title;
    private String description;
    private String status; // "NEW", "IN_PROGRESS", "DONE"

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "NEW";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
