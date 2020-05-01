package edu.udayton.cps499.healthnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button homeBtn = (Button) findViewById(R.id.homeButton);
        Button editProfileBtn = (Button) findViewById(R.id.editProfileButton);
        Button logOutBtn = (Button) findViewById(R.id.logOutButton);

        //onClick of Home Button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomeActivity();
            }
        });

        //onClick of Edit Profile Button
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openEditProfileActivity();
            }
        });

//        THIS BLOCK BELOW IS A LITTLE IFFY, SO IT'S COMMENTED OUT FOR NOW
//        //onClick of Log Out Button
//        logOutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openSignInActivity();
//            }
//        });
    } // end onCreate

    // Navigates from Profile -> Home
    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    } // end openHomeActivity

    // Navigates from Profile -> EditProfile
    public void openEditProfileActivity() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);

    } // end openEditProfileActivity

//    THIS BLOCK BELOW IS A LITTLE IFFY, SO IT'S COMMENTED OUT FOR NOW
//    // Navigates from Profile -> SignIn
//    public void openSignInActivity() {
//        Intent intent = new Intent(this, SignInActivity.class);
//        startActivity(intent);
//
//    } // end openSignInActivity

} // end ProfileActivity
