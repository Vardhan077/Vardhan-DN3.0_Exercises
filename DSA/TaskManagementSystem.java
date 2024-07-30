

// TaskManagementSystem.java
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask(new Task(1, "Design UI", "In Progress"));
        taskList.addTask(new Task(2, "Develop Backend", "Not Started"));
        taskList.addTask(new Task(3, "Write Tests", "Not Started"));
        taskList.addTask(new Task(4, "Deploy Application", "Completed"));

        System.out.println("All tasks:");
        taskList.printAllTasks();

        System.out.println("\nSearching for task with ID 3:");
        Task task = taskList.findTaskById(3);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID 2:");
        boolean isDeleted = taskList.removeTaskById(2);
        System.out.println("Deleted: " + isDeleted);

        System.out.println("\nAll tasks after deletion:");
        taskList.printAllTasks();
    }
}


// Task.java
class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
    }
}

// Node.java
class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// TaskLinkedList.java
class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Task findTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printAllTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getTask());
            current = current.getNext();
        }
    }

    public boolean removeTaskById(int taskId) {
        if (head == null) return false;
        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return true;
        }
        Node current = head;
        while (current.getNext() != null && current.getNext().getTask().getTaskId() != taskId) {
            current = current.getNext();
        }
        if (current.getNext() == null) return false;
        current.setNext(current.getNext().getNext());
        return true;
    }
}