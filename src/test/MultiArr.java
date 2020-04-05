package test;

abstract class MyCenasCoiso {
    abstract public void printInfo();
}

class Cenas extends MyCenasCoiso {

    private String xpto;

    public Cenas(String xpto) {
        this.xpto = xpto;
    }

    @Override
    public void printInfo() {
        System.out.println(xpto);
    }
}

class Coiso extends MyCenasCoiso {

    private int zpty;

    public Coiso(int zpty) {
        this.zpty = zpty;
    }

    @Override
    public void printInfo() {
        System.out.println(zpty);
    }
}

public class MultiArr {
    public static void main(String[] args) {
        MyCenasCoiso[][] fields = new MyCenasCoiso[3][2];
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.println("it's a coiso");
                    fields[i][j] = new Coiso(i + j);
                } else {
                    System.out.println("it's a cenas");
                    fields[i][j] = new Cenas(String.format("%d+%d", i, j));
                }
            }
        }
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                MyCenasCoiso x = fields[i][j];
                x.printInfo();
            }
        }

        Object[][] x = new Object[1][1];
        for (Object[] obj : x) {
            System.out.println(obj[0]);
        }
        x[0] = new Object[]{(Integer)1};
        for (Object[] obj : x) {
            System.out.println(obj[0]);
        }
    }
}
