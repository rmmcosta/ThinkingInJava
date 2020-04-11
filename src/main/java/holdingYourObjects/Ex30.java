package holdingYourObjects;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class JobsSequence implements Collection {
    private String[] jobs;
    private int elements = 0;

    public JobsSequence() {
        jobs = new String[1000];
    }

    public JobsSequence(int size) {
        jobs = new String[size];
    }

    public JobsSequence(String[] jobs) {
        this.jobs = jobs;
    }

    @Override
    public int size() {
        return jobs.length;
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (jobs.length == 0) {
            return false;
        }

        for (String s : jobs) {
            if ((String) o == s) {
                return true;
            }
        }

        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < jobs.length;
            }

            @Override
            public Object next() {
                return jobs[pos++];
            }
        };
    }

    @NotNull
    @Override
    public Object[] toArray() {
        // we can't just return jobs we need to return a copy of jobs
        Object[] newJobs = new Object[jobs.length];
        System.arraycopy(jobs, 0, newJobs, 0, jobs.length);
        return newJobs;
    }

    @Override
    public boolean add(Object o) {
        if (elements < jobs.length) {
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i] == null) {
                    jobs[i] = (String) o;
                    elements++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i] == (String) o) {
                jobs[i] = null;
                elements--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection collection) {
        if (collection.size() <= (jobs.length - elements)) {
            try {
                for (Object element : collection) {
                    for (int i = elements; i < jobs.length; i++) {
                        jobs[i] = (String) element;
                    }
                }
                return true;
            } catch (Exception e) {
                throw new ClassCastException(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public void clear() {
        jobs = null;
        elements = 0;
    }

    @Override
    public boolean retainAll(@NotNull Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(@NotNull Collection collection) {
        clear();
        return true;
    }

    @Override
    public boolean containsAll(@NotNull Collection collection) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public String[] toArray(@NotNull Object[] objects) {
        String[] strings = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            strings[i]=(String)objects[i];
        }
        return strings;
    }
}

class JobsSequenceTest {
    @Test
    void InitialSizeSuccess() {
        JobsSequence jobsSequence = new JobsSequence(5);
        assertEquals(5, jobsSequence.size());
    }

    @Test
    void InitialSizeFail() {
        JobsSequence jobsSequence = new JobsSequence(5);
        assertNotEquals(4, jobsSequence.size());
    }

    @Test
    void EmptyTest() {
        JobsSequence jobsSequence = new JobsSequence();
        assertEquals(true, jobsSequence.isEmpty());
        jobsSequence.add("Qimonda");
        assertEquals(false, jobsSequence.isEmpty());
    }

    @Test
    void ContainsAll() {
        JobsSequence jobsSequence = new JobsSequence();
        assertThrows(UnsupportedOperationException.class, () -> {
            jobsSequence.containsAll(new ArrayList(Arrays.asList(1, 4, 5)));
        });
    }

    @Test
    void NewArray() {
        JobsSequence jobsSequence = new JobsSequence(2);
        jobsSequence.add("Alfa");
        jobsSequence.add("Qimonda");
        Iterator iterator = jobsSequence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Object[] x = jobsSequence.toArray();
        jobsSequence.remove("Qimonda");
        iterator = jobsSequence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        String[] y = jobsSequence.toArray(x);
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
        }
    }
}

/*public class Ex30 {
    public static void main(String[] args) {

    }
}*/
