package holdingYourObjects;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

class Shape {
    private static int numShapes = 0;

    public static int getNumShapes() {
        return numShapes;
    }

    public static void resetNumShapes() {
        Shape.numShapes = 0;
    }

    public Shape() {
        numShapes++;
    }

    public void go() {
        System.out.println(getNumShapes() + ": go shape");
    }

}

class Circle extends Shape {
    private int id;

    public Circle() {
        this.id = getNumShapes();
    }

    public void go() {
        System.out.println(id + ": go circle");
    }
}

class Triangle extends Shape {
    private int id;

    public Triangle() {
        this.id = getNumShapes();
    }

    public void go() {
        System.out.println(id + ": go triangle");
    }
}

class Square extends Shape {
    private int id;

    public Square() {
        this.id = getNumShapes();
    }

    public void go() {
        System.out.println(id + ": go square");
    }
}

class RandomShapeGenerator {
    public RandomShapeGenerator() {
        Shape.resetNumShapes();
    }

    public Shape generate() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Triangle();
            default:
                return new Square();
        }
    }
}

class RandomShapeGeneratorIterable implements Iterable<Shape> {
    private final int numShapes;

    RandomShapeGeneratorIterable(int numShapes) {
        this.numShapes = numShapes;
    }

    @NotNull
    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            RandomShapeGenerator randomShapeGenerator = new RandomShapeGenerator();
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < numShapes;
            }

            @Override
            public Shape next() {
                pos++;
                return randomShapeGenerator.generate();
            }
        };
    }
}

public class Ex31 {
    public static void main(String[] args) {
        RandomShapeGenerator randomShapeGenerator = new RandomShapeGenerator();
        Shape s1 = randomShapeGenerator.generate();
        s1.go();
        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = randomShapeGenerator.generate();
        }
        for (Shape s : shapes) {
            s.go();
        }
        System.out.println("-------------------\n30 With iterable\n-----------------");
        for (Shape s : new RandomShapeGeneratorIterable(30)) {
            s.go();
        }
        System.out.println("-------------------\n1 With iterable\n-----------------");
        for (Shape s : new RandomShapeGeneratorIterable(1)) {
            s.go();
        }
    }

}
