package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        TextView textViewAddress = (TextView) findViewById(R.id.text_view_address);
        textViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launches google maps activity
                launchGoogleMapsActivity(view);
            }
        });

        TextView textViewPhone = (TextView) findViewById(R.id.text_view_phone);
        textViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launches the phone activity
                launchPhoneActivity(view);
            }
        });
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    private void launchGoogleMapsActivity(View view) {
//        https://developers.google.com/maps/documentation/urls/android-intents
        Uri addressUri = Uri.parse("geo:37.7749,-122.4194");
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        intent.setPackage("com.google.android.apps.maps");

        List<ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, 0);

        if(activities.isEmpty())
        {
            Toast.makeText(this, "Google Maps is not installed on your device!", Toast.LENGTH_LONG).show();
        }

        if(! activities.isEmpty())
        {
            startActivity(intent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

    private void launchPhoneActivity(View view) {
        // code
    }

}
