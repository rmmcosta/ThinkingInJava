package polymorphism;

import java.util.Random;

class Game {
    public void play(){
        System.out.println("I am playing a game");
    }
}

class Football extends Game{
    @Override
    public void play() {
        System.out.println("I am playing football");
    }
}

class Basketball extends Game{
    @Override
    public void play() {
        System.out.println("I am playing Basket");
    }
}

class Swimming extends Game {
    @Override
    public void play() {
        System.out.println("I am at the swimming pool");
    }
}

public class Ex8 {
    private static Game gameGenerator() {
        Random r = new Random();
        switch(r.nextInt(3)){
            case 0: return new Football();
            case 1: return new Basketball();
            case 2: return new Swimming();
            default: return new Game();
        }
    }

    private static Game gameGenerator2() {
        Random r = new Random();
        /*
        Class.newInstance( ) creates an object of the
        class it is called for, but it can throw exceptions. Here, we create and throw a
        RuntimeException for this programming error, so your code doesn’t have to
        catch such exceptions. You can embed the cause of an error inside a thrown
        exception to pass detailed information about the condition to a client
        programmer. (We cover exceptions in detail in the chapter Error Handling with
        Exceptions.) The benefit of this design is that you can add a new type to the
        system by only adding it to the Class array; the rest of the code takes care of
        itself.
        */
        Class<?> games[] = {Game.class, Football.class, Basketball.class, Swimming.class};
        try{
            return (Game)games[r.nextInt(games.length)].newInstance();
        } catch (Exception e) {
            //System.err.println(e.getMessage());
            //return null;
            throw new RuntimeException("Cannot create game",e);
        }
    }

    private static void go(Game g) {
        g.play();
    }

    public static void main(String[] args) {
        Game[] games = new Game[5];
        for(int i =0;i<games.length;i++){
            games[i] = gameGenerator();
        }
        for(Game g : games){
            go(g);
        }
        //more elegant way
        System.out.println("games2...");
        Game[] games2 = new Game[10];
        for(int i =0;i<games2.length;i++){
            games2[i] = gameGenerator2();
        }
        for(Game g : games2){
            go(g);
        }
    }
}
