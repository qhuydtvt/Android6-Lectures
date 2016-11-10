package techkids.vn.activityintro;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private static final String NUMBER_OF_TAPS_KEY = "numberOfTaps";

    Button btGoto2nd;
    Button btGoto3rd;
    Button btFinish;
    Button btTapMe;
    TextView tvNumberOfTaps;

    private int numberOfTaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        if (savedInstanceState != null) {
            /* There might be saved data */
            numberOfTaps = savedInstanceState.getInt(NUMBER_OF_TAPS_KEY, 0);
        }

        tvNumberOfTaps = (TextView) findViewById(R.id.tv_number_of_taps);

        tvNumberOfTaps.setText(String.format("Number of taps: %s", numberOfTaps));

        btGoto2nd = (Button) findViewById(R.id.open_2nd);
        btGoto2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to 2nd Activity
                //1: Create an intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //2: Change acitivty
                startActivity(intent);
            }
        });

        btGoto3rd = (Button) findViewById(R.id.open_3rd);
        btGoto3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1: Create an intent
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                // 2: Change activity
                startActivity(intent);
            }
        });

        btFinish = (Button) findViewById(R.id.bt_finish);
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btTapMe = (Button) findViewById(R.id.bt_tap_me);
        btTapMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTaps++;
                tvNumberOfTaps.setText(String.format("Number of taps: %s", numberOfTaps));
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(NUMBER_OF_TAPS_KEY, numberOfTaps);
        Log.d(TAG, "protected onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
