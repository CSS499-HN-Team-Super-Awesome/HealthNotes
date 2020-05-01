package edu.udayton.cps499.healthnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeButton);
        Button saveBtn = (Button) findViewById(R.id.saveButton);
        Button cancelBtn = (Button) findViewById(R.id.cancelButton);

        //onClick of Home Button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomeActivity();
            }
        });

        //onClick of Save Button
        //NOTE: Current implementation does not actually store info
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openProfileActivity();
            }
        });

        //onClick of Cancel Button
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openProfileActivity();
            }
        });
    } // end onCreate

    // Navigates from Profile -> Home
    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    } // end openHomeActivity

    // Navigates from EditProfile -> Profile
    public void openProfileActivity() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    } // end openProfileActivity

} // end EditProfileActivity
