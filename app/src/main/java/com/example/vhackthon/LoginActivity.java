package com.example.vhackthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    //layouts
    TextView registerbtn;
    EditText email,password;
    Button loginbtn;

    //firebase auth
    FirebaseAuth auth;

    //progress dialogbox
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //layouts
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        loginbtn=findViewById(R.id.loginbtn);
        registerbtn=findViewById(R.id.registerbtn);

        //firebase auth
        auth=FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        //clickiing on login btn
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starting progress dialog
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setTitle("Loging In");
                progressDialog.setMessage("Please wait...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                //registering user in firebase auth(i.e. creating new user)
                loginUser(email.getText().toString(),password.getText().toString());
            }
        });
    }

    private void loginUser(String useremail, String userpassword) {

        auth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    //dismissing progress dialog
                    progressDialog.dismiss();

                    Toast.makeText(getApplicationContext(),"login Sucessfull",Toast.LENGTH_SHORT).show();
                    //going to main page
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
                else {
                    //dismissing progress dialog
                    progressDialog.hide();
                    Toast.makeText(getApplicationContext(),task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}