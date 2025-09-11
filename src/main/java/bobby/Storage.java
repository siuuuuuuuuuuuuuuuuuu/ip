package bobby;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveTasks(ArrayList<Task> tasks) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.toStorageString());
                writer.newLine();
            }
        }
    }

    public ArrayList<Task> loadTasks() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return tasks; // Return empty list if file doesn't exist
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isMarked = parts[1].equals("1");
                String description = parts[2];
                Task task = null;
                switch (type) {
                    case "TODO":
                        task = new ToDo(description);
                        break;
                    case "DEADLINE":
                        String by = parts[3];
                        task = new Deadline(description, by);
                        break;
                    case "EVENT":
                        String from = parts[3];
                        String to = parts[4];
                        task = new Event(description, from, to);
                        break;
                }
                if (task != null && isMarked) {
                    task.mark();
                }
                if (task != null) {
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }
}