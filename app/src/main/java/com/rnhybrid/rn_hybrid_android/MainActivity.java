package com.rnhybrid.rn_hybrid_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int OVERLAY_PERMISSION_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button profileButton = findViewById(R.id.profile);
        profileButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MyReactActivity.class);
                        intent.putExtra("moduleName", "Profile");
                        intent.putExtra("message", "This is Profile Screen!");
                        startActivityForResult(intent, 0);
                    }
                }
        );
        Button accountButton = findViewById(R.id.account);
        accountButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MyReactActivity.class);
                        intent.putExtra("moduleName", "Account");
                        intent.putExtra("message", "");
                        startActivityForResult(intent, 0);
                    }
                }
        );
        Button otherButton = findViewById(R.id.other);
        otherButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MyReactActivity.class);
                        intent.putExtra("moduleName", "Other");
                        intent.putExtra("message", "");
                        startActivityForResult(intent, 0);
                    }
                }
        );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                           Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted
                    Toast.makeText(this, "You need permission for overlay", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
