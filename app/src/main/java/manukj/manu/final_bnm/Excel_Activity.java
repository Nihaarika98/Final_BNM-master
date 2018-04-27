package manukj.manu.final_bnm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Excel_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_);

        TextView textView1 = findViewById(R.id.description);
        textView1.setText("A four-day training programme on “Advanced Excel” was organised for the fourth semester MBA students from April 17 to 25, 2018. The purpose of the training was to equip the students with features of Advanced Excel which will be beneficial for them for their projects as well as placements. The resource person was from FACE (Focus Academy for Career Enhancement), skill development company, Bangalore.");

    }
}
