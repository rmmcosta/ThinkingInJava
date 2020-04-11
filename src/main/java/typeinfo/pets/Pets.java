package typeinfo.pets;

import java.util.ArrayList;
import java.util.Random;

public class Pets {
    public static ArrayList<Pet> arrayList(int num) {
        ArrayList<Pet> temp = new ArrayList<Pet>();
        Pet[] rPets = {new Hamster(), new Dog(), new Hamster()};
        Random r = new Random();
        for(int i =0;i<num;i++) {
            temp.add(rPets[r.nextInt(rPets.length)]);
        }
        return temp;
    }
}
