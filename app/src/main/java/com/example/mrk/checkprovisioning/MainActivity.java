package com.example.mrk.checkprovisioning;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String PERSISTENT_DATA_BLOCK_PROP = "ro.frp.pst";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getContentResolver();

        Button btn = (Button)findViewById(R.id.updateButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvProvisioned = (TextView)findViewById(R.id.isProvisioned);
                Integer isProvisioned = Settings.Global.getInt(MainActivity.this.getContentResolver(), Settings.Global.DEVICE_PROVISIONED, 0);
                tvProvisioned.setText(Integer.toString(isProvisioned));
                Log.v("isProvisioned=", Integer.toString(isProvisioned));

            }
        });
    }
}

