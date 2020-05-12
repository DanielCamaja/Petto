package petto.com.petto.Inicio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import petto.com.petto.Main2Activity;
import petto.com.petto.R;

public class SignupActivity extends AppCompatActivity {

    private EditText nombresignup;
    private EditText apellidosignup;
    private EditText emailsignup;
    private EditText passwordsignup;


    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgress;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nombresignup = (EditText) findViewById(R.id.nombreid);
        apellidosignup = (EditText) findViewById(R.id.apellidoid);
        emailsignup = (EditText) findViewById(R.id.emailid);
        passwordsignup = (EditText) findViewById(R.id.passwordid);


        mProgress = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };

    }

    public void signUp(View view) {

        final String nombre = nombresignup.getText().toString();
        final String apellido = apellidosignup.getText().toString();
        final String email = emailsignup.getText().toString();
        final String password = passwordsignup.getText().toString();


        if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mProgress.setMessage("Registering, please wait...");
            mProgress.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            mProgress.dismiss();
                            if (task.isSuccessful()) {
                                firebaseAuth.signInWithEmailAndPassword(email, password);

                                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
                                DatabaseReference currentUserDB = mDatabase.child(firebaseAuth.getCurrentUser().getUid());
                                currentUserDB.child("nombre").setValue(nombre);
                                currentUserDB.child("apellido").setValue(apellido);
                                currentUserDB.child("email").setValue(email);
                                currentUserDB.child("password").setValue(password);
                            } else {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                user.sendEmailVerification();
                            }

                        }



            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }



}
