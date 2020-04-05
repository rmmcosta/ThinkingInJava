package exceptions;

import java.util.ArrayList;
import java.util.List;

class BucketElement {
    private final String name;
    public BucketElement(String name) throws BucketException {
        this.name = name;
        Bucket.addElement(this);
        if (name == "fail") {
            try {
                System.out.println("before throwing the exception:");
                Bucket.printElements();
                throw new BucketException("Failed to create bucket element!");
            } catch (BucketException e) {
                Bucket.removeElement(this);
                //this way we ensure that we revert to the state before creating this object
                System.out.println("After catching the exception:");
                throw e;
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

class Bucket {
    private static List<BucketElement> bucketElementList = new ArrayList<>();
    static void addElement(BucketElement be) {
        bucketElementList.add(be);
    }

    static void removeElement(BucketElement be) {
        bucketElementList.remove(be);
    }

    static void printElements() {
        System.out.println(bucketElementList);
    }
}

class BucketException extends Throwable {
    public BucketException(String s) {
        super(s);
    }
}

public class Ex22_2 {
    public static void main(String[] args) {
        try {
            BucketElement bucketElement1 = new BucketElement("coiso");
            BucketElement bucketElement1_1 = new BucketElement("cenas");
            BucketElement bucketElement2 = new BucketElement("fail");
        } catch (BucketException e) {
            e.printStackTrace();
        }
        Bucket.printElements();
    }
}
