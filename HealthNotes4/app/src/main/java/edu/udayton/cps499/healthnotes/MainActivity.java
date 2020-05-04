/*
    Course: CPS 499-14  Spring 2020 Semester @ The University of Dayton
    Author: Michael Graham
    Instructor Tom Ongwere

    NOTE: This was created early on and in conjunction with the RegisterActivity activity to test connectivity
        to Firebase and the sign-in/authentication within Google.

 */

package edu.udayton.cps499.healthnotes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    private SignInButton signInButtonGoogle;
    private GoogleSignInClient mGoogleSignInClient;
    private String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private Button btnSignOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signInButtonGoogle = findViewById(R.id.signInButtonGoogle);
        mAuth = FirebaseAuth.getInstance();
        btnSignOut = findViewById(R.id.signOutButton);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle();
            }
        });


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.signOut();
                Toast.makeText(MainActivity.this, "Sign Out Complete",Toast.LENGTH_SHORT).show();
                btnSignOut.setVisibility(View.INVISIBLE);
            }
        });

    }//end onCreate

    private void signInGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
         try {

             GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
             //Toast.makeText(MainActivity.this, "Signed In Successfully",Toast.LENGTH_SHORT).show();
             FirebaseGoogleAuth(acc);

         }//end Try
         catch (ApiException e ) {

             Toast.makeText(MainActivity.this, "Sign In Failed",Toast.LENGTH_SHORT).show();
             FirebaseGoogleAuth(null);
         }//end catch
    }//end handleSignInResult

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {

        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    //Toast.makeText(MainActivity.this, "Successful",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                }else {
                    Toast.makeText(MainActivity.this, "Unsuccessful",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }

            }//end onComplete
        });//end mAuth

    }//end FirebaseGoogleAuth

    private void updateUI(FirebaseUser fUser) {
        btnSignOut.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount((getApplicationContext()));
        if (account != null) {
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(MainActivity.this, "Welcome "+personName, Toast.LENGTH_SHORT).show();

            launchNextActivity(account);
        }

    }//end updateUI

    private void launchNextActivity(GoogleSignInAccount account){
        Intent nextThing = new Intent(this, RegisterActivity.class);
        startActivity(nextThing);
    }

}//end MainActivity
