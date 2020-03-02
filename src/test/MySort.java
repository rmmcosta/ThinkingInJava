package test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySort {
    public static void main(String[] args) {
        List<Book> myBooks = new ArrayList<Book>();
        myBooks.add(new Book("Thinking in Java"));
        myBooks.add(new Book("Radical Candor"));
        Book theBook = new Book("Pragmatic Programmer");
        theBook.oneMore();
        myBooks.add(theBook);
        System.out.println(myBooks);
        Collections.sort(myBooks);
        System.out.println(myBooks);

        //now the animals that we will sort ignoring case and not ignoring
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog"));
        animals.add(new Animal("Cat"));
        Animal frog = new Animal("Frog");
        frog.oneMore();
        frog.oneMore();
        animals.add(frog);
        animals.add(new Animal("cat"));
        System.out.println(animals);
        Collections.sort(animals, Animal.CASE_INSENSITIVE_ORDER);
        System.out.println(animals);
        
        List<Animal_v2> animals_v2 = new ArrayList<>();
        animals_v2.add(new Animal_v2("Dog"));
        animals_v2.add(new Animal_v2("Cat"));
        Animal_v2 frog_v2 = new Animal_v2("Frog");
        frog_v2.oneMore();
        frog_v2.oneMore();
        animals_v2.add(frog_v2);
        animals_v2.add(new Animal_v2("cat"));
        System.out.println(animals_v2);
        //sort no case insensitive
        Collections.sort(animals_v2);
        System.out.println(animals_v2);
        //sort with case sensitive
        Collections.sort(animals_v2, Animal_v2.CASE_INSENSITIVE_ORDER);
        System.out.println(animals_v2);
    }
}

class Book implements Comparable<Book> {
    private final String title;
    private int number;

    public Book(String title) {
        this.title = title;
        number = 1;
    }

    public void oneMore() {
        number++;
    }

    @Override
    public int compareTo(@NotNull Book book) {
        return this.title.compareTo(book.title);
    }

    @Override
    public String toString() {
        return title + " (" + number + ")";
    }
}

class Animal {
    private final String race;
    private int quantity;
    //now let's create a variable that is a comparator of animal
    public static final Comparator<Animal> CASE_INSENSITIVE_ORDER = new Comparator<Animal>() {
        @Override
        public int compare(Animal animal1, Animal animal2) {
            return animal1.race.compareToIgnoreCase(animal2.race);
        }
    };

    public Animal(String race) {
        this.race = race;
        this.quantity = 1;
    }

    public void oneMore() {
        quantity++;
    }

    @Override
    public String toString() {
        return race + " (" + quantity + ")";
    }
}

class Animal_v2 implements Comparable<Animal_v2> {
    private final String race;
    private int quantity;
    //now let's create a variable that is a comparator of animal
    public static final Comparator<Animal_v2> CASE_INSENSITIVE_ORDER = new Comparator<Animal_v2>() {
        @Override
        public int compare(Animal_v2 animalV21, Animal_v2 animalV22) {
            return animalV21.race.compareToIgnoreCase(animalV22.race);
        }
    };

    public Animal_v2(String race) {
        this.race = race;
        this.quantity = 1;
    }

    public void oneMore() {
        quantity++;
    }

    @Override
    public String toString() {
        return race + " (" + quantity + ")";
    }

    @Override
    public int compareTo(@NotNull Animal_v2 animal_v2) {
        return this.race.compareTo(animal_v2.race);
    }
}
