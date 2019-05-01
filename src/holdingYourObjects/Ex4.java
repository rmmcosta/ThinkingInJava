package holdingYourObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

interface Iterator {
    boolean hasNext();
    void reset();
}

interface StringIterator extends Iterator {
    String next();
}

class MovieCharacteres {
    private String[] chars = {"Wolverine","Optimus Prime","Bumble Bee","Capitain America"};
    private Iterator iter;
    private int curr;
    MovieCharacteres() {
        curr = 0;
        iter = new StringIterator() {
            @Override
            public String next() {
                return chars[curr++];
            }

            @Override
            public boolean hasNext() {
                if(curr<=chars.length-1)
                    return true;
                else {
                    reset();
                    return true;
                }
            }

            @Override
            public void reset() {
                curr=0;
            }
        };
    }
    public void fill(Collection<String> list, int qty){
        for(int i =0;i<qty;i++) {
            if(iter.hasNext()) {
                list.add(((StringIterator)iter).next());
            }
            else {
                throw new RuntimeException("An error was occurred and now we are out of movie characteres!");
            }
        }
    }
}

public class Ex4 {
    static String getCurrentFormatedDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
    public static void main(String[] args) {
        MovieCharacteres mc = new MovieCharacteres();
        //Array list
        List<String> arlist = new ArrayList<String>();
        System.out.println("Start filling arlist at " + getCurrentFormatedDate());
        mc.fill(arlist,10);
        System.out.println("Finished filling arlist at " + getCurrentFormatedDate());
        for (String s : arlist
             ) {
            System.out.println(s);
        }
        System.out.println("Finished print arlist at " + getCurrentFormatedDate());
        //linked list
        List<String> linklist = new LinkedList<String>();
        System.out.println("Start filling linklist at " + getCurrentFormatedDate());
        mc.fill(linklist,10);
        System.out.println("Finished filling linklist at " + getCurrentFormatedDate());
        for (String s : linklist
        ) {
            System.out.println(s);
        }
        System.out.println("Finished print linklist at " + getCurrentFormatedDate());
        //hashset
        Set<String> hash7 = new HashSet<String>();
        System.out.println("Start filling hash7 at " + getCurrentFormatedDate());
        mc.fill(hash7,10);
        System.out.println("Finished filling hashset at " + getCurrentFormatedDate());
        for (String s : hash7
        ) {
            System.out.println(s);
        }
        System.out.println("Finished print hash7 at " + getCurrentFormatedDate());

        //linked hashset
        Set<String> lhash7 = new LinkedHashSet<String>();
        System.out.println("Start filling lhash7 at " + getCurrentFormatedDate());
        mc.fill(lhash7,10);
        System.out.println("Finished filling lhashset at " + getCurrentFormatedDate());
        for (String s : lhash7
        ) {
            System.out.println(s);
        }
        System.out.println("Finished print lhash7 at " + getCurrentFormatedDate());

        //Tree hashset
        Set<String> thash7 = new TreeSet<String>();
        System.out.println("Start filling thash7 at " + getCurrentFormatedDate());
        mc.fill(thash7,10);
        System.out.println("Finished filling thashset at " + getCurrentFormatedDate());
        for (String s : thash7
        ) {
            System.out.println(s);
        }
        System.out.println("Finished print thash7 at " + getCurrentFormatedDate());
    }
}
