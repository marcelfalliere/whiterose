package fr.fmf.android.whiterose;

import android.app.AlarmManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity extends WearableActivity implements View.OnClickListener {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private TextView mTxtAlarm;
    private Button mButtonAction;
    final String TAG = "MainActivity";

    private ServiceFacade serviceFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mTxtAlarm = (TextView) findViewById(R.id.txt_alarm);
        mButtonAction = (Button) findViewById(R.id.btn_action);
        mButtonAction.setOnClickListener(this);

        serviceFacade = ((WearApp) getApplication()).serviceFacade();
        serviceFacade.planNext(this);

        Log.d(TAG, "Created");
    }

    @Override
    public void onClick(View v) {
        if (isStarted) {
            serviceFacade.stop(this);
            ((Button)v).setText("start");
        } else {
            serviceFacade.planNext(this);
            ((Button)v).setText("stop");
        }
    }


/*
    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {

        Log.d(TAG, String.format("Update display, is ambient : %s", String.valueOf(isAmbient())));

        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTxtAlarm.setVisibility(View.VISIBLE);

            Log.d(TAG, String.format(AMBIENT_DATE_FORMAT.format(new Date())));

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bipbip);
            mediaPlayer.start();

            mTxtAlarm.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTxtAlarm.setVisibility(View.GONE);
        }
    }*/

}
