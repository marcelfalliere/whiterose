package fr.fmf.android.whiterose;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by fredericfalliere on 01/08/2017.
 */

public class ServiceFacade {

    final String TAG = "ServiceFacade";

    private int NEXT_TICK = (1000 * 5);
    private PendingIntent lastPlannedIntent;
    private boolean isStarted = true;

    public void stop(Context context) {
        AlarmManager am = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        am.cancel(lastPlannedIntent);
    }

    public void planNext(Context context) {
        Log.d(TAG, String.format("Plan - le broadcast arrivera dans %s ms ...", String.valueOf(NEXT_TICK)));

        AlarmManager am=(AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        Intent nextIntent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, nextIntent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + NEXT_TICK, pi);

        lastPlannedIntent = pi;
    }

}
