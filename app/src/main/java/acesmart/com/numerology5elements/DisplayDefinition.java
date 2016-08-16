package acesmart.com.numerology5elements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayDefinition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_definition);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");

        Integer intvalue = Integer.valueOf(value);

        TextView tvdef = (TextView) findViewById(R.id.tvDefinition);
        tvdef.setText(getDefinition(intvalue));


    }


    private String getDefinition(int value){

        String result = "";

        switch (value){
            case 1:
                result = getString(R.string.root_number_1);
                break;
            case 2:
                result = getString(R.string.root_number_2);
                break;
            case 3:
                result = getString(R.string.root_number_3);
                break;
            case 4:
                result = getString(R.string.root_number_4);
                break;
            case 5:
                result = getString(R.string.root_number_5);
                break;
            case 6:
                result = getString(R.string.root_number_6);
                break;
            case 7:
                result = getString(R.string.root_number_7);
                break;
            case 8:
                result = getString(R.string.root_number_8);
                break;
            case 9:
                result = getString(R.string.root_number_9);
                break;
        }

        return result;
    }

    public void finishActivity(View v){
        finish();
    }

}
