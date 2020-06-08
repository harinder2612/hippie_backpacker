package com.harinder.hippie_backpacker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateItinerary extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button captureLocation, uploadToFirebase;
    ImageView locationImage;
    EditText locationName, locationType, locationHours, locationItems, locationExperience;
    Bitmap imageBitmap;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private static final int CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_itinerary);

        //Changing the title of Action bar
        getSupportActionBar().setTitle("Upload Itinerary");

        //Setting up layout IDs
        captureLocation = findViewById(R.id.captureButton);
        locationImage = findViewById(R.id.locationImage);
        locationName = findViewById(R.id.locationName);
        locationType = findViewById(R.id.locationType);
        locationHours = findViewById(R.id.locationHours);
        locationItems = findViewById(R.id.locationItems);
        locationExperience = findViewById(R.id.locationExperience);
        uploadToFirebase = findViewById(R.id.uploadToFirebase);

        //Call for camera permission on first Installation of the app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
        }

        //Code to capture Image using camera sensor and then paste Bitmap on Imageview
        locationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(imageTakeIntent.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        //Code to capture Image using camera sensor and then paste Bitmap on Imageview
        captureLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(imageTakeIntent.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


        //Upload button code which upload the data to firebase using databasereference
        uploadToFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating Itinerary class object
                Itinerary itinerary = new Itinerary(locationName.getText().toString(),
                        locationType.getText().toString(),
                        locationHours.getText().toString(),
                        locationItems.getText().toString(),
                        locationExperience.getText().toString());

                //Initializing database reference
                databaseReference = FirebaseDatabase.getInstance().getReference();
                //Pushing new Itinerary values to real-time database
                databaseReference.child("itineraries").push().setValue(itinerary);
                Toast.makeText(CreateItinerary.this, "Itinerary Uploaded", Toast.LENGTH_SHORT).show();
            }
        });


    }

    //Function which handles the return from camera app and sets up Bitmap on Imageview
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            locationImage.setImageBitmap(imageBitmap);
        }

    }

    //Code to check camera Permission
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(CreateItinerary.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            requestPermissions(
                    new String[] { permission },
                    requestCode);
        }
    }

    //request camera permission and grant access based on request code
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(CreateItinerary.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(CreateItinerary.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }
}
