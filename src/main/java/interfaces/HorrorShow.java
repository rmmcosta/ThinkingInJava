package interfaces;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {}
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

public class HorrorShow {
    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }

    public DangerousMonster getDM(){
        return new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("DM destroy");
            }

            @Override
            public void menace() {
                System.out.println("DM menace");
            }
        };
    }

    public Vampire getVamp(){
        return new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("Vamp drinking blood");
            }

            @Override
            public void destroy() {
                System.out.println("Vammp destroying");
            }

            @Override
            public void kill() {
                System.out.println("Vamp killing");
            }

            @Override
            public void menace() {
                System.out.println("Vamp menace");
            }
        };
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);

        HorrorShow h = new HorrorShow();
        DangerousMonster dm = h.getDM();
        Vampire vamp = h.getVamp();
        dm.destroy();
        dm.menace();
        vamp.drinkBlood();
        vamp.destroy();
        vamp.kill();
        vamp.menace();
        h.u(dm);
        h.v(dm);
        h.u(vamp);
        h.v(vamp);
        h.w(vamp);
    }
} ///:~
