package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoPairs {

    public static void main(String[] args) {
        /*
         add task -> PENDING
         remove task  -> COMPLETED
         complete task by task index -> COMPLETED
         incomplete task by task index -> PENDING
         edit task by id -> PENDING/COMPLETED
        */

        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        showTasks(tasks);

        while(scanner.hasNext()) {
            String read = scanner.nextLine();
            System.out.println("Next line is: " + read);

            if (read.startsWith("add")) {
                String content = read.replace("add", "").trim();
                tasks.add(new Task(content, false));
            }

            if (read.startsWith("edit")) {
                int index = Integer.parseInt(read.replace("edit", "").trim());
                System.out.println("Input your new task: ");
                String content = scanner.nextLine();
                Task newContent = new Task(content, false);
                tasks.set(index, newContent);
            }

            if (read.startsWith("remove")) {
                int index = Integer.parseInt(read.replace("remove", "").trim());
                tasks.remove(index);
            }

            if (read.startsWith("complete")) {
                int index = Integer.parseInt(read.replace("complete", "").trim());
                Task task = tasks.get(index);
                task.setCompleted();
                tasks.set(index, task);
            }

            if (read.startsWith("incomplete")) {
                int index = Integer.parseInt(read.replace("incomplete", "").trim());
                Task task = tasks.get(index);
                task.setUncompleted();
                tasks.set(index, task);
            }

            showTasks(tasks);
        }
    }

    public static void showTasks(List<Task> tasks) {
        if(tasks.isEmpty()) {
            System.out.println("List is empty. Add todo task.");
        }

        for(int i= 0; i < tasks.size(); i++) {
            System.out.println(
                    "Index: " + i +
                            ", content: " + tasks.get(i).getContent() +
                            ", completed: " + tasks.get(i).isCompleted());

        }
    }
}
