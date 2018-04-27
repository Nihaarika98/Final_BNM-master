package manukj.manu.final_bnm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class Splash_Screen extends Activity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        videoView = findViewById(R.id.video);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.aarohan);
        videoView.setVideoURI(uri);
        videoView.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this,NavigationActivity.class);
                startActivity(intent);
                Splash_Screen.this.finish();
            }
        },3000);

    }
}
