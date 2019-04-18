package sg.edu.rp.c346.dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button  btn = findViewById(R.id.btnClose);

        Intent intent = getIntent();

        String[] info1 = intent.getStringArrayExtra("info1");
        String[] info2 = intent.getStringArrayExtra("info2");
        String[] info3 = intent.getStringArrayExtra("info3");
        String[] etinfo = intent.getStringArrayExtra("etinfo");

        TextView tv1 = findViewById(R.id.textView);

        tv1.setText(info1[0] + ":" + info1[1] + "\n" + info2[0] + ":" + info2[1] + "\n" + info3[0]
        + ":" + info3[1] + "\n" + etinfo[0] + ":" + etinfo[1]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
