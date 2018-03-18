package com.kuchcinski.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

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

    private void receivedPowerDisconnected(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}

    private void receivedPowerConnected(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());    }

    private void receivedBootCompleted(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}
    private void receivedMyPackageReplaced(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}
    private void receivedScreenOff(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}
    private void receivedScreenOn(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}
    private void receivedUserPresent(Context context, Intent intent) {showMessage(context, "received "+intent.getAction());}

    private void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
