import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

    public Epic(String title, String description) {
        super(title, description);
        subtasks = new ArrayList<>();
    }
}
