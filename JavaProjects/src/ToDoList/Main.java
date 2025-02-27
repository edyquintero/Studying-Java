package ToDoList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        String menu = "===== To-Do List =====\n" +
                "1. Agregar tarea\n" +
                "2. Mostrar todas las tareas\n" +
                "3. Marcar tarea como completada\n" +
                "4. Eliminar tarea\n" +
                "5. Mostrar tareas pendientes\n" +
                "6. Salir";

        while (true) {
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String description = sc.nextLine();
                    Task task = new Task();
                    task.setDescription(description);
                    if (taskManager.addTask(task)) {
                        System.out.println("Tarea agregada.");
                    } else {
                        System.out.println("La tarea ya existe.");
                    }
                    break;
                case 2:
                    List<Task> tasks = taskManager.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        System.out.println("===== Lista de tareas =====");
                        tasks.forEach(t -> {
                            String status = t.isDone() ? "[Completada]" : "[Pendiente]";
                            System.out.println(status + " " + t.getDescription());
                        });
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la descripción de la tarea a marcar como completada: ");
                    String taskToComplete = sc.nextLine();
                    if (taskManager.markAsCompleted(taskToComplete)) {
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la descripción de la tarea a eliminar: ");
                    String taskToDelete = sc.nextLine();
                    if (taskManager.removeTask(taskToDelete)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;
                case 5:
                    List<Task> pendingTasks = taskManager.getPendingTasks();
                    if (pendingTasks.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        System.out.println("===== Tareas pendientes =====");
                        pendingTasks.forEach(t -> System.out.println("[Pendiente] " + t.getDescription()));
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
