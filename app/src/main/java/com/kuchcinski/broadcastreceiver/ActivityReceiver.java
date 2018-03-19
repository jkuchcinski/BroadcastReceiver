package com.kuchcinski.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.widget.Toast;

import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by jarek on 18.03.2018.
 */

public class ActivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action!=null) {
            switch (action) {
                case Intent.ACTION_BOOT_COMPLETED:
                    receivedBootCompleted(context, intent);
                    break;
                case Intent.ACTION_MY_PACKAGE_REPLACED:
                    receivedMyPackageReplaced(context, intent);
                    break;
                case Intent.ACTION_SCREEN_OFF:
                    receivedScreenOff(context, intent);
                    break;
                case Intent.ACTION_SCREEN_ON:
                    receivedScreenOn(context, intent);
                    break;
                case Intent.ACTION_USER_PRESENT:
                    receivedUserPresent(context, intent);
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    receivedPowerConnected(context, intent);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    receivedPowerDisconnected(context, intent);
                    break;


            }
        }
    }

    private void receivedPowerDisconnected(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.RED);}
    private void receivedPowerConnected(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.RED);    }
    private void receivedBootCompleted(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.YELLOW);}
    private void receivedMyPackageReplaced(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.BLUE);}
    private void receivedScreenOff(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.WHITE);}
    private void receivedScreenOn(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.WHITE);}
    private void receivedUserPresent(Context context, Intent intent) {showMessage(context, intent.getAction(), Color.BLUE);}

    private void showMessage(Context context, String message, int color) {

        android.text.format.DateFormat df = new android.text.format.DateFormat();
        CharSequence date = df.format("HH:mm:ss", new Date()); //"yyyy-MM-dd hh:mm:ss a"

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setSubText(date)
                .setContentTitle("NEW BROADCAST")
                .setContentText(message)
                .setPriority(Notification.PRIORITY_HIGH)
                .setOngoing(true);
        builder.setLights(0xff00ff00, 300, 100);
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
}
