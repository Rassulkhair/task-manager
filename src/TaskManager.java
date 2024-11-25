import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, Subtask> subtasks;
    private int counter = 1;

    /**
     * Создание задачи, при создании присваиваем идентификатор задачи
     *
     * @param task создаваемая задача
     */
    public void createTask(Task task) {
        task.setId(getUniqueId());
        tasks.put(task.getId(), task);
    }

    /**
     * Получение задачи по идентификатору
     *
     * @param id идентификатор задачи
     * @return найденная задача по идентификатору, null в случае если нет задачи с таким идентификатором
     */
    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    /**
     * Получение списка всех задач
     * @return список всех задач
     */
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void createEpic(Epic epic) {
        // по аналогии как и с createTask
    }

    public Epic getEpicById(int id) {
        // по аналогии как и с getTaskById
    }

    public ArrayList<Epic> getAllEpics() {
        // по аналогии как и с getAllTasks
    }

    public void deleteEpicById(int id) {
        // TODO: Если эпик существует, удаляем все его подзадачи, затем удаляем сам эпик
    }

    public void createSubtask(Subtask subtask) {
        // TODO: необходимо проверить существует ли epic для данной подзадачи
        //  если существует, присваиваем идентификатор для подзадачи и сохраняем в subtasks
    }

    public Subtask getSubtaskById(int id) {
        // по аналогии как и с getTaskById
    }

    public ArrayList<Subtask> getAllSubtasks() {
        // по аналогии как и с getAllTasks
    }

    public void deleteSubtaskById(int id) {
        // TODO: Если подзадача существует, то удалить подзадачу из списка эпика (Epic.subtasks)
        //   удалить саму подзадачу
    }

    public void updateEpicStatus(Epic epic) {
        // 1. если у эпика нет подзадач или все подзадачи имеют статус NEW - то у эпика тоже NEW
        // 2. если у эпика все подзадачи имеют статус DONE - то у эпика тоже DONE
        // 3. иначе - IN_PROGRESS
    }

    private int getUniqueId() {
        return counter++;
    }
}
