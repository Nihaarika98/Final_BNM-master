package manukj.manu.final_bnm.LOGIN_UPLOAD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import manukj.manu.final_bnm.R;

public class Login_Screen extends AppCompatActivity {
EditText email,passward;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        email = findViewById(R.id.Email);
        passward = findViewById(R.id.Passward);
        login = findViewById(R.id.Login_Button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("Manu")&&passward.getText().toString().equals("manukj"))
                {
                    Intent intent = new Intent(Login_Screen.this,Upload_Image_Server.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login_Screen.this,  email.getText()+"has no Access  granted" , Toast.LENGTH_SHORT).show();
                    Login_Screen.this.finish();
                }
            }
        });


    }
}
