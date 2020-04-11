package holdingYourObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArraysAsList {
    public static void main(String[] args) {
        List<String> shopList = new ArrayList<String>();
        shopList.addAll(Arrays.asList("Milk","Water","Coffee"));
        for (String s: shopList
             ) {
            System.out.println(s);
        }
        String shopString = "Milk,Cereals,Water,Coffee";
        String[] shopArray = shopString.split(",");
        List<String> shopList2 = new ArrayList<String>(Arrays.asList(shopArray));
        shopList2.add("Coiso");
        for(String s:shopList2) {
            System.out.println(s);
        }
        /*
        The constructor for a Collection can accept another Collection which it uses for
        initializing itself, so you can use Arrays.asList( ) to produce input for the constructor.
        However, Collections.addAll( ) runs much faster, and it’s just as easy to construct the
        Collection with no elements and then call Collections.addAll( ), so this is the preferred approach.
         */
        String shopString2 = "Milk2,Cereals,Water,Coffee";
        System.out.println("printarray:"+shopString2);
        String[] shopArray2 = shopString2.split(",");
        List<String> shopList3 = new ArrayList<String>();
        System.out.println("printList:"+shopList3);
        Collections.addAll(shopList3,shopArray2);
        System.out.println("printList:"+shopList3);
        shopList3.add("chocolates");
        for(String s:shopList3) {
            System.out.println(s);
        }

        Arrays.asList(shopArray2).add("e tal");
        Arrays.asList(shopArray2).remove(0);
        //this operations are not allowed because the base of the list is an array and arrays have fixed sizes.
    }
}
