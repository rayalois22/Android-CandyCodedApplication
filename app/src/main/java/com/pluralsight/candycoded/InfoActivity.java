package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    private TextView mTextViewAddress;
    private TextView mTextViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        mTextViewAddress = (TextView) findViewById(R.id.text_view_address);
        mTextViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launches google maps activity
                createMapIntent(view);
            }
        });

        mTextViewPhone = (TextView) findViewById(R.id.text_view_phone);
        mTextViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launches the phone activity
                createPhoneIntent(view);
            }
        });
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // DONE
    // ***

    public void createMapIntent(View view) {
        Uri addressUri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        intent.setPackage("com.google.android.apps.maps");

        if( intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // DONE
    // ***

    public void createPhoneIntent(View view) {
//        String phone = mTextViewPhone.getText().toString();
//        Uri phoneUri = Uri.fromParts("tel", phone, null);
        Uri phoneUri = Uri.parse("tel:0123456789");
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(phoneUri);
        startActivity(intent);
    }

}
