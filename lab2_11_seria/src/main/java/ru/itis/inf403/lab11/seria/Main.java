package ru.itis.inf403.lab11.seria;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setAge(12);
        animal.setCategory(AnimalClass.МЛЕКОПИТАЩЕЕ);
        animal.setName("Лиса-Алиса");
        animal.setType(AnimalType.ЛИСА);


        byte[] data = new byte[0];

        try (FileOutputStream fos = new FileOutputStream("lisa.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(animal);
            fos.flush();

        }catch (IOException e){
            e.printStackTrace();
        }


        try (FileInputStream bais = new FileInputStream("lisa.obj");
             ObjectInputStream ois = new ObjectInputStream(bais)) {
 
            Animal animal1 = (Animal) ois.readObject();
            System.out.println(animal1);

        }catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}



