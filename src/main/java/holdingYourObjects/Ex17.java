package holdingYourObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class GerbilEx17 {
    private String _name;
    private int _number;
    GerbilEx17(String name, int number) {
        set_name(name);
        set_number(number);
        GerbilMap.putGerbil(this);
    }
    GerbilEx17() {
        set_name("unknown");
        set_number(1);
        GerbilMap.putGerbil(this);
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
    }
    public void hop() {
        System.out.println("hop gerbil:" + _name);
    }
}

class GerbilMap {
    private static Map<String,GerbilEx17> gerbilDesc = new HashMap<String,GerbilEx17>();
    public static void putGerbil(GerbilEx17 gerbil) {
        gerbilDesc.put(gerbil.get_name(),gerbil);
    }
    public static void printGerbils(){
        System.out.println(gerbilDesc);
    }
    public static void hopThemAll() {
        Iterator<String> it = gerbilDesc.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            System.out.print(key+"->");
            GerbilEx17 currGerbil = gerbilDesc.get(key);
            currGerbil.hop();
        }
        Iterator<Map.Entry<String,GerbilEx17>> it2 = gerbilDesc.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry<String,GerbilEx17> currEntry= it2.next();
            System.out.print(currEntry.getKey()+"->");
            currEntry.getValue().hop();
        }
    }
}

public class Ex17 {
    public static void main(String[] args) {
        GerbilEx17 gerbil1 = new GerbilEx17("Fury",10);
        GerbilEx17 gerbil2 = new GerbilEx17();
        GerbilEx17 gerbil3 = new GerbilEx17("John",5);
        GerbilMap.printGerbils();
        GerbilMap.hopThemAll();
    }
}
