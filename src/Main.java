public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task = new Task("задача 1", "описание 1");
        manager.createTask(task);

        Epic epic = new Epic("эпик 1", "описание 1");
        manager.createEpic(epic);

        Subtask subtask = new Subtask("подзадача 1", "описание 1", epic);
        manager.createSubtask(subtask);

        subtask.setStatus("IN_PROGRESS");
        manager.updateSubtask(subtask);

        System.out.println(epic.getStatus()); // Expected: IN_PROGRESS

        // TODO

    }
}