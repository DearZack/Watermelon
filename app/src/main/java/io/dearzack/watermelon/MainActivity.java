package io.dearzack.watermelon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startWatermelon();
        String a = "冲突";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopWatermelon();
    }

    private void startWatermelon() {
        Intent intent = new Intent(this, WatermelonService.class);
        startService(intent);
    }

    private void stopWatermelon() {
        Intent intent = new Intent(this, WatermelonService.class);
        stopService(intent);
    }
}