package reusingclasses;

class Component1d {
    Component1d() {
        System.out.println("Class Component1d " + this.toString());
    }

    public void dispose() {
        System.out.println("Disposing Component1d " + this.toString());
    }
}

class Component2d {
    Component2d() {
        System.out.println("Class Component2d " + this.toString());
    }

    public void dispose() {
        System.out.println("Disposing Component2d " + this.toString());
    }
}

class Component3d {
    Component3d() {
        System.out.println("Class Component3d " + this.toString());
    }

    public void dispose() {
        System.out.println("Disposing Component3d " + this.toString());
    }
}

class Rootd {
    Component1d c1;
    Component2d c2;
    Component3d c3;

    Rootd() {
        c1 = new Component1d();
        c2 = new Component2d();
        c3 = new Component3d();
        System.out.println("Class Rootd " + this.toString());
    }

    public void dispose() {
        System.out.println("Disposing Rootd " + this.toString());
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}

class Stemd extends Rootd {
    Component1d c1;
    Component2d c2;
    Component3d c3;

    Stemd() {
        c1 = new Component1d();
        c2 = new Component2d();
        c3 = new Component3d();
        System.out.println("Class Stemd " + this.toString());
    }

    public void dispose() {
        System.out.println("Disposing Stemd " + this.toString());
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Stemd s = new Stemd();
        try {
            System.out.println(s);
        } finally {
            s.dispose();
        }
    }
}
