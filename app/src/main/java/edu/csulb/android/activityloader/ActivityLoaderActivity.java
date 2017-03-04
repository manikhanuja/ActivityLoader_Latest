package edu.csulb.android.activityloader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.pm.PackageManager;



public class ActivityLoaderActivity extends Activity {

    static private final String URL = "http://www.amazon.com";
    static private final String TAG = "Lab5-Intents";

    private Button makeCallButton;
    private Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        makeCallButton = (Button) findViewById(R.id.call);
        makeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeCall();
            }
        });


        // Declare and setup Browser Activation button
        browserButton = (Button) findViewById(R.id.browser);
        browserButton.setOnClickListener(new OnClickListener() {

            // Call chooseBrowserActivity() when pressed
            @Override
            public void onClick(View v) {

                chooseBrowser();

            }
        });
    }


    // Start the makeCall()

    @SuppressLint("NewApi")
    private void makeCall() {

        Log.i(TAG,"Entered makeCall()");
        Intent dialerActivity = new Intent(Intent.ACTION_DIAL, Uri.parse((getString(R.string.telephoneNumber))));
        startActivity(dialerActivity);


    }

    // Start a Browser Activity to view a web page or its URL

    private void chooseBrowser() {

        Log.i(TAG, "Entered chooseBrowser()");

        Uri webpage = Uri.parse(URL);
        Intent baseIntent = new Intent(Intent.ACTION_VIEW, webpage);

        Intent chooserIntent = Intent.createChooser(baseIntent, "Select App");
        Log.i(TAG,"Chooser Intent Action:" + chooserIntent.getAction());
        startActivity(chooserIntent);

        if (baseIntent.resolveActivity(getPackageManager()) != null) {

        }


    }

}
