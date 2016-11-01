package techkids.vn.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private EditText etName;
    private TextView tvHello;
    private Button btSayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getReferences();
        addListeners();
    }

    private void addListeners() {
        btSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "btSayHello: onClick"); // d = debug

                // 1
                String name = etName.getText().toString();

                // 2
                String sayHello = String.format("Hello %s", name);

                // 3
                tvHello.setText(sayHello);
            }
        });
    }

    private void getReferences() {
        etName = (EditText) findViewById(R.id.et_name);
        tvHello = (TextView) findViewById(R.id.tv_hello);
        btSayHello = (Button) findViewById(R.id.bt_say_hello);
    }
}
