package innerclasses;

interface Counter{
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    public Counter getCounter(String name){
        class LocalCounter implements Counter{
            LocalCounter(){
                System.out.println("Created LocalCounter");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
        return new LocalCounter();
    }

    public Counter getCounter2(String name){
        return new Counter(){
            {
                System.out.println("Created Anonymous Counter");
            }
            @Override
            public int next(){
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args){
        LocalInnerClass l = new LocalInnerClass();
        Counter c1 = l.getCounter("Counter 1");
        System.out.println(c1.next());
        Counter c2 = l.getCounter2("Counter 2");
        System.out.println(c2.next());
        System.out.println(c2.next());
        System.out.println(c1.next());
    }

}
