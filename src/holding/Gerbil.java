package holding;

import java.util.ArrayList;

public class Gerbil {
    private int gerbilNumber;
    public Gerbil(int num){
        gerbilNumber = num;
    }
    public void hop(){
        System.out.println("Hoping:"+gerbilNumber);
    }
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        gerbils.add(new Gerbil(5));
        gerbils.add(new Gerbil(13));
        gerbils.add(new Gerbil(44));
        for(int i = 0;i < gerbils.size(); i++){
            gerbils.get(i).hop();
        }
    }
}
