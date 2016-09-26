package acesmart.com.numerology5elements;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mylaptop on 8/9/2016.
 */
public class ShowNumbers {

    public ShowNumbers(){

    }

    public void ComposeResult(Map<String,Integer> map, View view){
        String result = "";
        TreeMap treeMap = new TreeMap(map);
        Iterator iterator = treeMap.keySet().iterator();


        TextView txtView = null;
        boolean setbackground = false;

        while (iterator.hasNext()){
            Object key = iterator.next();
            Object value = treeMap.get(key);


            switch (key.toString()){
                case "A":
                    txtView = (TextView) view.findViewById(R.id.tvA);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "B":
                    txtView = (TextView) view.findViewById(R.id.tvB);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "C":
                    txtView = (TextView) view.findViewById(R.id.tvC);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "D":
                    txtView = (TextView) view.findViewById(R.id.tvD);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "E":
                    txtView = (TextView) view.findViewById(R.id.tvE);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "F":
                    txtView = (TextView) view.findViewById(R.id.tvF);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "G":
                    txtView = (TextView) view.findViewById(R.id.tvG);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "H":
                    txtView = (TextView) view.findViewById(R.id.tvH);
                    if (txtView != null)
                        txtView.setText(value.toString());
                    setbackground = false;
                    break;
                case "I":
                    txtView = (TextView) view.findViewById(R.id.tvI);

                    txtView.setText(value.toString());

                    setbackground = true;
                    break;
                case "J":
                    txtView = (TextView) view.findViewById(R.id.tvJ);

                    txtView.setText(value.toString());

                    setbackground = true;
                    break;
                case "K":
                    txtView = (TextView) view.findViewById(R.id.tvK);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "L":
                    txtView = (TextView) view.findViewById(R.id.tvL);

                    txtView.setText(value.toString());
                    txtView.setTextColor(Color.WHITE);
                    setbackground = true;
                    break;
                case "M":
                    txtView = (TextView) view.findViewById(R.id.tvM);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "N":
                    txtView = (TextView) view.findViewById(R.id.tvN);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "O":
                    txtView = (TextView) view.findViewById(R.id.tvO);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "P":
                    txtView = (TextView) view.findViewById(R.id.tvP);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "Q":
                    txtView = (TextView) view.findViewById(R.id.tvQ);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "R":
                    txtView = (TextView) view.findViewById(R.id.tvR);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "S":
                    txtView = (TextView) view.findViewById(R.id.tvS);
                    txtView.setText(value.toString());
                    txtView.setTextColor(Color.WHITE);
                    setbackground = true;
                    break;
                case "T":
                    txtView = (TextView) view.findViewById(R.id.tvT);
                    txtView.setText(value.toString());
                    txtView.setTextColor(Color.WHITE);
                    setbackground = true;
                    break;
                case "U":
                    txtView = (TextView) view.findViewById(R.id.tvU);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "V":
                    txtView = (TextView) view.findViewById(R.id.tvV);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "W":
                    txtView = (TextView) view.findViewById(R.id.tvW);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;
                case "X":
                    txtView = (TextView) view.findViewById(R.id.tvX);
                    txtView.setText(value.toString());
                    setbackground = true;
                    break;

            }
           // we do not put color on this version
            /*if (setbackground)
            {
            txtView.setTextColor(Color.WHITE);
                chooseColor(value.toString(),txtView);
                }
*/

        }

    }

    public  void chooseColor(String number, View view){

        switch (number){
            case "1":
                view.setBackgroundResource(R.color.colorMetal);
                break;
            case "6":
                view.setBackgroundResource(R.color.colorMetal01);
                break;
            case "2":
                view.setBackgroundResource(R.color.colorWater);
                break;
            case "7":
                view.setBackgroundResource(R.color.colorWater01);
                break;
            case "3":
                view.setBackgroundResource(R.color.colorFire);
                break;
            case "8":
                view.setBackgroundResource(R.color.colorFire01);
                break;
            case "4":
                view.setBackgroundResource(R.color.colorWood);
                break;
            case "9":
                view.setBackgroundResource(R.color.colorWood01);
                break;
            case "5":
            case "0":
                view.setBackgroundResource(R.color.colorEarth);
                break;

        }


    }

    public String composeData(View view){
        String result = "{";

        TextView textView = (TextView) view.findViewById(R.id.tvA);
        result = result +  "\"A\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvB);
        result = result +  "\"B\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvC);
        result = result +  "\"C\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvD);
        result = result +  "\"D\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvE);
        result = result +  "\"E\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvF);
        result = result +  "\"F\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvG);
        result = result +  "\"G\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvH);
        result = result +  "\"H\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvI);
        result = result +  "\"I\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvJ);
        result = result +  "\"J\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvK);
        result = result +  "\"K\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvL);
        result = result +  "\"L\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvM);
        result = result +  "\"M\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvN);
        result = result +  "\"N\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvO);
        result = result +  "\"O\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvP);
        result = result +  "\"P\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvQ);
        result = result +  "\"Q\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvR);
        result = result +  "\"R\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvS);
        result = result +  "\"S\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvT);
        result = result +  "\"T\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvU);
        result = result +  "\"U\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvV);
        result = result +  "\"V\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvW);
        result = result +  "\"W\"" + ":" +  textView.getText().toString() + ",";
        textView = (TextView) view.findViewById(R.id.tvX);
        result = result +  "\"X\"" + ":" +  textView.getText().toString() + ",";
        result = result + "}";




        return result;
    }

}
