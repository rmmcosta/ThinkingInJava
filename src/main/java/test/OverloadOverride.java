package test;

class TheBase {
    public void things() {

    }
}

class TheOverride extends TheBase {
    @Override
    public void things() {

    }
    /* not allowed
    public int things() {
        return 7;
    }*/
    //@Override the override will give a compile error preventing an overload
    public void things(int i) {
        System.out.println(i);
    }
}

public class OverloadOverride {
}
