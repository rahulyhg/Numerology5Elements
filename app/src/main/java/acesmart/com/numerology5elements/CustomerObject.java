package acesmart.com.numerology5elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mylaptop on 9/29/2016.
 */

public final class CustomerObject {

    Map<String, String> customerObj = new HashMap<>();

    public CustomerObject(){
        customerObj.put("custname","");
        customerObj.put("custdob","");
        customerObj.put("custroot","");
        customerObj.put("gender","");
    }

    public void updateObject(String key, String value){
        customerObj.put(key, value);
    }

    public String getObject(String key){
        return customerObj.get(key);
    }



}
