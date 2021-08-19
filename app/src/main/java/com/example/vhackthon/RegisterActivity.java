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

public class RegisterActivity extends AppCompatActivity {

    //layouts
    TextView loginbtn;
    EditText fullname,email,password,phoneNo;
    Button registerbtn;

    //firebase auth
    FirebaseAuth auth;

    //progress dialogbox
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        //layouts
        fullname= findViewById(R.id.fullname);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        phoneNo= findViewById(R.id.phoneNo);
        registerbtn=findViewById(R.id.registerbtn);
        loginbtn=findViewById(R.id.loginbtn);

        //firebase auth
        auth = FirebaseAuth.getInstance();

        //progress dialog box

        //going to Login page
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        //clicking on register btn
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starting progress dialog
                progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setTitle("Registering");
                progressDialog.setMessage("Please wait...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                //registering user in firebase auth(i.e. creating new user)
                registerUser(email.getText().toString(),password.getText().toString());
            }
        });


    }

    private void registerUser(String useremail, String userpassword) {

        auth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    //dismissing progress dialog
                    progressDialog.dismiss();

                    Toast.makeText(getApplicationContext(),"Registered Sucessfully",Toast.LENGTH_SHORT).show();
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