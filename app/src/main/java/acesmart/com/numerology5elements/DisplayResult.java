package acesmart.com.numerology5elements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class DisplayResult extends AppCompatActivity {


    Map<String, Integer> map = new HashMap<String, Integer>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        String caller = intent.getStringExtra("calling");

        parsingNumber(value);
        ShowNumbers showNumbers = new ShowNumbers();
        final View view = (View) findViewById(R.id.tvA).getRootView();

        showNumbers.ComposeResult(map, view);
//        final TextView rootnumber = (TextView) view.findViewById(R.id.tvO);
//
//        rootnumber.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent myIntent = new Intent(getApplicationContext(),
//                        DisplayDefinition.class);
//                myIntent.putExtra("key", rootnumber.getText().toString()); //Optional parameters
//                startActivity(myIntent);
//
//            }
//        });


    }

    private void parsingNumber(String value){

        String[] strkey = {"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N", "O", "P","Q","R","S","T","U","V","W","X"};
        int idxstart = 0;
        String keyvalue = "";
        int intvalue = 0;

        for (String aStrkey : strkey) {
            idxstart = value.indexOf(aStrkey);
            keyvalue = value.substring(idxstart + 3, idxstart + 4);
            intvalue = Integer.valueOf(keyvalue);
            map.put(aStrkey, intvalue);
        }

    }

    public void finishActivity(View v){
        finish();
    }


}
