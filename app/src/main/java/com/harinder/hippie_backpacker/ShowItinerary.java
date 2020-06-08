package com.harinder.hippie_backpacker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowItinerary extends AppCompatActivity {

    TextView title, locationName, locationType, locationHours, locationItems, locationExperience;
    ImageView mail, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_itinerary);

        getSupportActionBar().setTitle("Itinerary Details");

        Bundle extras = getIntent().getExtras();

        title = findViewById(R.id.title);
        locationName = findViewById(R.id.locationName);
        locationType = findViewById(R.id.locationType);
        locationHours = findViewById(R.id.locationHours);
        locationItems = findViewById(R.id.locationItems);
        locationExperience = findViewById(R.id.locationExperience);
        mail = findViewById(R.id.sendMail);
        share = findViewById(R.id.shareIt);

        title.setText(extras.getString("locName"));
        locationName.setText(extras.getString("locName"));
        locationType.setText(extras.getString("locType"));
        locationHours.setText(extras.getString("locHours"));
        locationItems.setText(extras.getString("locItems"));
        locationExperience.setText(extras.getString("locExperience"));

        final StringBuilder builder = new StringBuilder();

        builder.append("Location Name: "+locationName.getText()+"\n");
        builder.append("Location Type: "+locationType.getText()+"\n");
        builder.append("Location Opening Hours: "+locationHours.getText()+"\n");
        builder.append("Necessary Items to carry : "+locationItems.getText()+"\n");
        builder.append("Experience: "+locationExperience.getText());


        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, "Complete Itinerary of "+title.getText());
                email.putExtra(Intent.EXTRA_TEXT, builder.toString());

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0403140522");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", builder.toString());
                startActivity(intent);
            }
        });

    }
}
