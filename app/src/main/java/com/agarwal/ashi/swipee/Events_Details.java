package com.agarwal.ashi.swipee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Events_Details extends AppCompatActivity {
    EditText editText;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events__details);
         text=(TextView)findViewById(R.id.textView4);
        Button button= (Button) findViewById(R.id.button);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        String[] desc=b.getStringArray("poster_desc");
        int position=b.getInt("position");
        text.setText(desc[position]);
        editText=(EditText)findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sending_data sending_data=new Sending_data(Events_Details.this,editText,"false");
                sending_data.execute("http://500052000.000webhostapp.com/revert.php?Content="+editText.getText().toString().replaceAll(" ","+")+"&Desc="+text.getText().toString().replaceAll(" ","+"));

            }
        });
        }
}
