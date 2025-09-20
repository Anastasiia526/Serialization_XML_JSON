package serialization;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Animal implements Serializable {
    private String species;
    private int weight;
    private float height;

}
class Main1{
    public static void main(String[] args) {
        Animal animal = new Animal("Giraffe", 100, 2.7f);
        File file = new File("src/main/java/serialization/file2.txt");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}