package sg.edu.rp.c346.dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;
    RadioGroup rg1, rg2, rg3;
    EditText et1;
    Button btnOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = findViewById(R.id.btnOK);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        et1 = findViewById(R.id.editText);





        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg1 = findViewById(R.id.rg1);
                int Selected1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(Selected1);

                String[] rg1info = {tv1.getText().toString(), rb1.getText().toString()};

                rg2 = findViewById(R.id.rg2);
                int Selected2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = findViewById(Selected2);

                String[] rg1info2 = {tv2.getText().toString(), rb2.getText().toString()};

                rg3 = findViewById(R.id.rg3);
                int Selected3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = findViewById(Selected3);

                String[] rg1info3 = {tv3.getText().toString(), rb3.getText().toString()};

                String[] etinfo = {tv4.getText().toString(), et1.getText().toString()};

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("info1", rg1info);
                intent.putExtra("info2", rg1info2);
                intent.putExtra("info3", rg1info3);
                intent.putExtra("etinfo", etinfo);



                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("rb1", Selected1);
                editor.putInt("rb2", Selected2);
                editor.putInt("rb3", Selected3);
                editor.putString("et", et1.getText().toString());

                editor.commit();

                startActivity(intent);



            }


        });

    }
    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);

        int SelectedOne = prefs.getInt("rb1",0);
        int SelectedTwo = prefs.getInt("rb2",0);
        int SelectedThree = prefs.getInt("rb3",0);
        String SelectedEt = prefs.getString("et",null);

        if(SelectedOne != 0){
            RadioButton rb1 = findViewById(SelectedOne);
            rb1.setChecked(true);
        }
        if(SelectedTwo !=0){
            RadioButton rb2 = findViewById(SelectedTwo);
            rb2.setChecked(true);
        }
        if(SelectedThree != 0){
            RadioButton rb3 = findViewById(SelectedThree);
            rb3.setChecked(true);
        }
        if(SelectedEt != null){
            et1.setText(SelectedEt);
        }
    }

}
