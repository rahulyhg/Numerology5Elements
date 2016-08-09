package acesmart.com.numerology5elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mylaptop on 8/9/2016.
 */
public class NumberObject {
    Map<String, Integer> numberObject = new HashMap<String, Integer>();

    public NumberObject() {
        numberObject.put("A", -1);
        numberObject.put("B", -1);
        numberObject.put("C", -1);
        numberObject.put("D", -1);
        numberObject.put("E", -1);
        numberObject.put("F", -1);
        numberObject.put("G", -1);
        numberObject.put("H", -1);
        numberObject.put("I", -1);
        numberObject.put("J", -1);
        numberObject.put("K", -1);
        numberObject.put("L", -1);
        numberObject.put("M", -1);
        numberObject.put("N", -1);
        numberObject.put("O", -1);
        numberObject.put("P", -1);
        numberObject.put("Q", -1);
        numberObject.put("R", -1);
        numberObject.put("S", -1);
        numberObject.put("T", -1);
        numberObject.put("U", -1);
        numberObject.put("V", -1);
        numberObject.put("W", -1);
        numberObject.put("X", -1);
    }

    public void changeValue(String key, Integer value){
        numberObject.put(key,value);
    }

    public Integer getValue(String key){
        return numberObject.get(key);
    }


}

