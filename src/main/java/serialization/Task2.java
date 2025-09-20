package serialization;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/serialization/file2.txt"));
            Animal animal = (Animal) ois.readObject();
            System.out.println(animal);
        } catch (IOException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
