public class Test {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager(); // Создаем менеджер задач

        // Создаем эпик с двумя подзадачами
        Epic firstEpic = new Epic("Эпик 1 (с двумя подзадачами)", "Описание эпика 1");
        manager.createEpic(firstEpic); // Добавляем эпик в менеджер

        Subtask firstEpicFirstSubtask = new Subtask("Подзадача 1 эпика 1", "Описание подзадачи 1 эпика 1", firstEpic);
        Subtask firstEpicSecondSubtask = new Subtask("Подзадача 2 эпика 1", "Описание подзадачи 2 эпика 1", firstEpic);
        manager.createSubtask(firstEpicFirstSubtask); // Добавляем первую подзадачу к эпику
        manager.createSubtask(firstEpicSecondSubtask); // Добавляем вторую подзадачу к эпику

        // Создаем эпик с одной подзадачей
        Epic secondEpic = new Epic("Эпик 2 (с одной подзадачей)", "Описание эпика 2");
        manager.createEpic(secondEpic);
        Subtask secondEpicFirstSubtask = new Subtask("Подзадача 1 эпика 2", "Описание подзадачи 1 эпика 2", secondEpic);
        manager.createSubtask(secondEpicFirstSubtask);

        // Создаем две задачи
        Task firstTask = new Task("Задача 1", "Описание задачи 1");
        Task secondTask = new Task("Задача 2", "Описание задачи 2");
        manager.createTask(firstTask); // Добавляем первую задачу
        manager.createTask(secondTask); // Добавляем вторую задачу

        // Выводим начальные списки задач, эпиков и подзадач
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());

        // Изменяем статусы созданных объектов и выводим результаты
        System.out.println("Изначальный статус эпика: " + firstEpic.getStatus());

        // Меняем статус подзадачи на IN_PROGRESS
        firstEpicFirstSubtask.setStatus("IN_PROGRESS");
        System.out.println("Статус эпика после изменения статуса подзадачи: " + firstEpic.getStatus());

        // Меняем статус обеих подзадач на DONE
        firstEpicFirstSubtask.setStatus("DONE");
        firstEpicSecondSubtask.setStatus("DONE");
        System.out.println("Статус эпика после изменения статуса всех подзадач на \"DONE\": " + firstEpic.getStatus());

        // Удаляем одну из задач и один из эпиков
        manager.removeTaskById(6); // Удаляем задачу с ID 6
        manager.removeEpicById(4); // Удаляем эпик с ID 4

        // Выводим списки задач, эпиков и подзадач после удаления
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
    }
}