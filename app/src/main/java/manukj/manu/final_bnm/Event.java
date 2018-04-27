package manukj.manu.final_bnm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class Event extends AppCompatActivity {
RelativeLayout relativeLayout;
    private static final int REQUEST_CALL = 1;

    String phno[] = {"9880900566","9880408341","9738859748","9164211495","8496968110","9742323671"};
    int events;
    String names[] = {"Blitzkrieg","Manstein Plan","Maneuver","Cease Fire","Annihilation","Polarity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        relativeLayout = findViewById(R.id.Event_layout);
        Bundle bundle = getIntent().getExtras();
        events =  bundle.getInt("Event");
        int event[] = {R.drawable.blitzkrieg,R.drawable.manstein_plan,R.drawable.maneuver,R.drawable.cease_fire,R.drawable.annihilation,R.drawable.polarity};
        relativeLayout.setBackgroundResource(event[events-1]);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneCall();
            }
        });
        setTitle(names[events-1]);
    }

    private void phoneCall(){
        if(ContextCompat.checkSelfPermission(Event.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Event.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else{
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phno[events-1]));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                phoneCall();

            }
        }
    }
}