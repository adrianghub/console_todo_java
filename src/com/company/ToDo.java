package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {
        System.out.println("Enter sentence:");

        Scanner scanner = new Scanner(System.in);
        List<String> elements = new ArrayList<>();
        int index = 0;

        while(scanner.hasNext()) {
            String read = scanner.nextLine();
            System.out.println("Next line is: " + read);

            if (read.startsWith("add")) {
               elements.add(read.replace("add", "").trim());
            }

            if (read.startsWith("remove")) {
                elements.remove(read.replace("remove", "").trim());
            }

            System.out.println(elements);
        }
    }
}
