package test;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] _objects;

    public Sequence(Object[] objects) {
        _objects = objects;
    }

    private class SequenceSelector implements Selector {
        private int count = 0;

        @Override
        public boolean end() {
            return count == _objects.length;
        }

        @Override
        public Object current() {
            return _objects[count];
        }

        @Override
        public void next() {
            count++;
        }
    }

    public Selector getSequenceSelector() {
        return new SequenceSelector();
    }

    private class AlternateSelector implements Selector {
        private int count = 0;

        @Override
        public boolean end() {
            return count >= _objects.length;
        }

        @Override
        public Object current() {
            return _objects[count];
        }

        @Override
        public void next() {
            count += 2;
        }
    }

    public Selector getAlternateSelector() {
        return new AlternateSelector();
    }
    //example using an anonymous inner class
    public Selector getReverseSelector() {
        return new Selector() {
            {
                System.out.println("Inside new reverse constructor...");
                Sequence.this.notify("Just to test calling methods inside the anonymous class constructor...");
            }
            int count = _objects.length-1;
            @Override
            public boolean end() {
                return count<0;
            }

            @Override
            public Object current() {
                return _objects[count];
            }

            @Override
            public void next() {
                count--;
            }
        };
    }

    private void notify(String message) {
        System.out.println("My custom notify: " + message);
    }

    public static void main(String[] args) {
        Object[] ints = {1, 2, 3, 6, 7, 9};
        Sequence sequence = new Sequence(ints);
        Selector selector = sequence.getSequenceSelector();
        System.out.println("Sequence selector");
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
        System.out.println("Alternate Selector");
        Selector alternateSelector = sequence.getAlternateSelector();
        while(!alternateSelector.end()) {
            System.out.println(alternateSelector.current());
            alternateSelector.next();
        }
        System.out.println("Reverse selector");
        Selector reverse = sequence.getReverseSelector();
        while(!reverse.end()) {
            System.out.println(reverse.current());
            reverse.next();
        }
    }
}
