package com.niharinfo.chatting;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.demach.konotor.Konotor;


public class MainActivity extends Activity {

    Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFeedback = (Button)findViewById(R.id.btnFeedback);
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Konotor.getInstance(getApplicationContext())
                        .launchFeedbackScreen(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Konotor.getInstance(getApplicationContext())
                .withUserName("Chaitanya")            // optional name by which to display the user
                .withIdentifier("Chaitanya.V")            // optional unique identifier for your reference
                .withUserEmail("vedantamskc@gmail.com")        // optional email address of the user
                .withUserMeta("age", "27")            // optional metadata for your user
                .withLaunchMainActivityOnFinish(true) // to launch your app on hitting the back button on Konotor's inbox interface, in case the app was not running already
                .init("aef2a8fa-7dc3-493d-9233-3469d433768b", "97cbba49-9ff8-4c67-885b-25fc5289519b");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
