package com.example.android.diabetes.BroadcastRecevier;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

import com.example.android.diabetes.R;

import java.util.Timer;
import java.util.TimerTask;

import androidx.core.app.NotificationCompat;

public class medicineAlarmReceiver extends BroadcastReceiver {

    int Id = 1;

    Uri nn ;
    Ringtone r ;
    @Override
    public void onReceive(Context context, Intent intent) {

        String medicine_name = intent.getStringExtra("name");
        Id = intent.getIntExtra("id",0);

        addNotificationForMedicien(medicine_name,context);
    }

    private void addNotificationForMedicien(String medicine_name,Context context) {


        Vibrator vibrator = ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE));
        vibrator.vibrate(2000);




        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context,
                        MyApplication.NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(R.drawable.logoo)
                        .setContentTitle("You Must Take A Medicine")
                        .setContentText(medicine_name)
                        .setStyle(new NotificationCompat.BigTextStyle())
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setAutoCancel(true)
                        .setColor(Color.BLUE);
        NotificationManager notificationManager =
                ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE));
        notificationManager.notify(Id, builder.build());
         nn = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
         r  = RingtoneManager.getRingtone(context,nn);
        r.play();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                r.stop();
            }
        };
        new Timer().schedule(timerTask,15000);



    }
    }


