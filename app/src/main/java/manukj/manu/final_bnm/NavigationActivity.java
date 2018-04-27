package manukj.manu.final_bnm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import manukj.manu.final_bnm.LOGIN_UPLOAD.Login_Screen;

public class NavigationActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;
    ImageView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);



        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView= (NavigationView) findViewById(R.id.shitstuff);
        View header_view = navigationView.getHeaderView(0);
        login = header_view.findViewById(R.id.login_icon);
        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(NavigationActivity.this,Login_Screen.class);
                startActivity(intent);
                return false;
            }
        });
        FM= getSupportFragmentManager();
        FT= FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public static final int REQUEST_CALL = 1;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId() == R.id.home)
                {
                    NavigationActivity.this.finish();
                }
                if (item.getItemId() == R.id.inaugralfunction)
                {

                }
                if(item.getItemId() == R.id.contact_us) {
                    phoneCall();
                }
                if (item.getItemId() == R.id.facebook)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bnmitaarohan"));
                    startActivity(browserIntent);
                }
                if(item.getItemId() == R.id.instagram)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/aarohan_18/"));
                    startActivity(browserIntent);
                }


                return false;
            }
        });


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }
    private void phoneCall(){
        if(ContextCompat.checkSelfPermission(NavigationActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(NavigationActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else{
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8553646740"));
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
