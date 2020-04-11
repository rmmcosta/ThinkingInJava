package holdingYourObjects;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class PetsSunday {
    public static PetSunday[] createArray(int quantity) {
        PetSunday[] temp = new PetSunday[quantity];
        for (int i = 0; i < quantity; i++) {
            temp[i] = new PetSunday(i);
        }
        return temp;
    }
}

class PetSunday {
    private final String id;

    PetSunday(int id) {
        this.id = "Pet" + id;
    }

    @Override
    public String toString() {
        return "Hello. I'm " + id + ".";
    }
}

class PetSequence {
    protected PetSunday[] pets = PetsSunday.createArray(8);
}

class NonCollectionSequence extends PetSequence implements Iterable<PetSunday> {
    public Iterator<PetSunday> iterator() {
        return new Iterator<PetSunday>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < pets.length;
            }

            @Override
            public PetSunday next() {
                return pets[pos++];
            }
        };
    }

    public Iterable<PetSunday> reversed() {
        return new Iterable<PetSunday>() {
            @NotNull
            @Override
            public Iterator<PetSunday> iterator() {
                return new Iterator<PetSunday>() {
                    int pos = pets.length - 1;

                    @Override
                    public boolean hasNext() {
                        return pos > -1;
                    }

                    @Override
                    public PetSunday next() {
                        return pets[pos--];
                    }
                };
            }
        };
    }

    public Iterable<PetSunday> randomized() {
        return new Iterable<PetSunday>() {
            @NotNull
            @Override
            public Iterator<PetSunday> iterator() {
                List<PetSunday> randomPets = new ArrayList<PetSunday>(Arrays.asList(pets));
                Collections.shuffle(randomPets);
                return randomPets.iterator();
            }
        };
    }
}

public class Ex32 {
    public static void printIteratorElements(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
        printIteratorElements(nonCollectionSequence.iterator());
        System.out.println("-------------\nWith for each\n----------------");
        for (PetSunday p : nonCollectionSequence) {
            System.out.println(p);
        }
        System.out.println("-------------\nWith for each reversed\n----------------");
        for (PetSunday p : nonCollectionSequence.reversed()) {
            System.out.println(p);
        }
        System.out.println("-------------\nWith for each randomized\n----------------");
        for (PetSunday p : nonCollectionSequence.randomized()) {
            System.out.println(p);
        }
    }
}
