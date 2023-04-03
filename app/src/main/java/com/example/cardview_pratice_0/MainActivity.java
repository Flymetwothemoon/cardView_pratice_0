package com.example.cardview_pratice_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CardView mCardView;
    private SeekBar mSeekBar_0;
    private SeekBar mSeekBar_1;
    private SeekBar mSeekBar_2;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardView = findViewById(R.id.cardView);
        mSeekBar_0 = findViewById(R.id.seekbar_0);
        mSeekBar_1 = findViewById(R.id.seekbar_1);
        mSeekBar_2  = findViewById(R.id.seekbar_2);
        mButton = findViewById(R.id.button);

NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
    Toast.makeText(MainActivity.this,"你的手机版本超过了Android 6",Toast.LENGTH_LONG).show();
    NotificationChannel channel = new NotificationChannel("Message","通知",NotificationManager.IMPORTANCE_HIGH);
    manager.createNotificationChannel(channel);
}
mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.baidu.com"));
        PendingIntent intent1 = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        builder.setContentIntent(intent1);
        Notification notification = new NotificationCompat.Builder(MainActivity.this,"Message")
                .setContentTitle("收到嘉然的来信")
                .setContentText("我们是A-soul")
                .setContentIntent(intent1)
                .setAutoCancel(false)
                .setSmallIcon(R.mipmap.bizhi)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.bizhi)).build();
        manager.notify(1,notification);
    }
});

        mSeekBar_0.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardView.setCardElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar_2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardView.setContentPadding(progress,progress,progress,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}