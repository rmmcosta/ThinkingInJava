package test;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

class HouseRooms implements Iterable<String> {
    private enum rooms {
        KITCHEN, UPSTAIRSROOM, DOWNSTAIRSROOM, LEAVINGROOM, BATHROOM
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < rooms.values().length;
            }

            @Override
            public Object next() {
                return rooms.values()[pos++].toString();
            }
        };
    }
}

public class Foreach {
    public static void main(String[] args) {
        for (String s : new HouseRooms()) {
            System.out.println(s);
        }
    }
}
