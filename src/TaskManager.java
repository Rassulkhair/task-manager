import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    // Хранилища для задач, эпиков и подзадач
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    // Счетчик для генерации уникальных идентификаторов
    private int uniqueId = 1;

    // Создание задачи
    public void createTask(Task task) {
        // Присваиваем задаче уникальный ID
        task.setId(getUniqueId());
        // Добавляем задачу в хранилище
        tasks.put(task.getId(), task);
    }

    // Создание эпика
    public void createEpic(Epic epic) {
        // Присваиваем эпику уникальный ID
        epic.setId(getUniqueId());
        // Добавляем эпик в хранилище
        epics.put(epic.getId(), epic);
    }

    // Создание подзадачи
    public void createSubtask(Subtask subtask) {
        // Получаем эпик, к которому относится подзадача
        Epic epic = subtask.getEpic();
        // Проверяем, существует ли эпик в хранилище
        if (epics.containsKey(epic.getId())) {
            // Присваиваем подзадаче уникальный ID
            subtask.setId(getUniqueId());

            // Добавляем подзадачу в эпик
            epic.addSubtask(subtask);
            // Обновляем статус эпика, учитывая изменения подзадач
            epic.updateStatus();

            // Добавляем подзадачу в хранилище
            subtasks.put(subtask.getId(), subtask);
        }
    }

    // Обновление задачи по ID
    public void update(int id, Task updatedTask) {
        // Заменяем задачу с заданным ID обновленной версией
        tasks.put(id, updatedTask);
    }

    // Получение задачи по ID
    public Task getTaskById(int id) {
        // Возвращаем задачу с заданным ID или null, если ее нет
        return tasks.get(id);
    }

    // Получение эпика по ID
    public Epic getEpicById(int id) {
        // Возвращаем эпик с заданным ID или null, если его нет
        return epics.get(id);
    }

    // Получение подзадачи по ID
    public Subtask getSubtaskById(int id) {
        // Возвращаем подзадачу с заданным ID или null, если ее нет
        return subtasks.get(id);
    }

    // Удаление задачи по ID
    public void removeTaskById(int id) {
        // Удаляем задачу из хранилища
        tasks.remove(id);
    }

    // Удаление эпика по ID
    public void removeEpicById(int id) {
        // Проверяем, существует ли эпик
        if (epics.containsKey(id)) {
            Epic epic = epics.get(id);
            // Проходим по всем подзадачам эпика
            for (Subtask subtask : epic.getSubtasks()) {
                // Удаляем подзадачу
                subtasks.remove(subtask.getId());
            }
            // Удаляем эпика
            epics.remove(id);
        }
    }

    // Удаление подзадачи по ID
    public void removeSubtaskById(int id) {
        // Проверяем, найдена ли подзадача
        if (subtasks.containsKey(id)) {
            // Получаем подзадачу для удаления
            Subtask subtaskToRemove = subtasks.get(id);
            // Получаем эпик, к которому относится подзадача
            Epic epic = subtaskToRemove.getEpic();
            // Удаляем подзадачу из эпика
            epic.removeSubtaskById(id);
            // Обновляем статус эпика
            epic.updateStatus();

            // Удаляем подзадачу из хранилища
            subtasks.remove(id);
        }
    }

    // Получение списка задач
    public ArrayList<Task> getTasks() {
        // Возвращаем список задач, полученный из хранилища
        return new ArrayList<>(tasks.values());
    }

    // Получение списка эпиков
    public ArrayList<Epic> getEpics() {
        // Возвращаем список эпиков, полученный из хранилища
        return new ArrayList<>(epics.values());
    }

    // Получение списка подзадач
    public ArrayList<Subtask> getSubtasks() {
        // Возвращаем список подзадач, полученный из хранилища
        return new ArrayList<>(subtasks.values());
    }

    // Получение списка подзадач для данного эпика
    public ArrayList<Subtask> getSubtasksByEpic(Epic epic) {
        // Возвращаем список подзадач, относящихся к данному эпику
        return epic.getSubtasks();
    }

    // Очистка всех хранилищ
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    // Генерация уникального ID
    private int getUniqueId() {
        return uniqueId++;
    }
}