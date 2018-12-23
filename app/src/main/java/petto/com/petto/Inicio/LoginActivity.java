package petto.com.petto.Inicio;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import petto.com.petto.Main2Activity;
import petto.com.petto.R;

public class LoginActivity extends AppCompatActivity {


    private EditText Userlogin;
    private EditText Passwordlogin;
    private FirebaseAuth firebaseAuth;

    private Button btninicio;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btninicio = (Button) findViewById(R.id.btn_login);
        Userlogin = (EditText) findViewById(R.id.email);
        Passwordlogin = (EditText) findViewById(R.id.password);

        firebaseAuth = FirebaseAuth.getInstance();


        authStateListener =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){

                    if (!user.isEmailVerified()){
                        Toast.makeText(LoginActivity.this, "correo no verificado", Toast.LENGTH_LONG).show();
                        user.isEmailVerified();

                    }else{
                        btninicio.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                                startActivity(intent);

                            }
                        });
                    }

                }
            }
        };


    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null)
            firebaseAuth.removeAuthStateListener(authStateListener);
    }

    public void Login(View view) {
        String username = Userlogin.getText().toString();
        String password = Passwordlogin.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Error de Inicio", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void ResetPassword(View view) {
        Intent intent0 = new Intent(LoginActivity.this, ResetPasswordActivity.class);
        startActivity(intent0);
    }

}
