package fr.fmf.android.whiterose;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by fredericfalliere on 01/08/2017.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    final String TAG = "AlarmBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "Received alarm intent");

        MediaPlayer mp = MediaPlayer.create(context, R.raw.bipbip);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });


    }

}
