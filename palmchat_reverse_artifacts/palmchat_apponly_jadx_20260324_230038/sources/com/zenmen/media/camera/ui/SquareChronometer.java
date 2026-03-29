package com.zenmen.media.camera.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Chronometer;
import com.zenmen.palmchat.circle.app.keep.widget.KeepChronometer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareChronometer extends Chronometer {
    private static final String TAG = KeepChronometer.class.getName();
    private boolean isDestroyed;
    private long recordingTime;

    public SquareChronometer(Context context) {
        super(context);
        this.isDestroyed = false;
        init();
    }

    private void init() {
        setFormat("%s:%s");
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        stop();
        this.recordingTime = 0L;
        this.isDestroyed = true;
    }

    public void onPause() {
        Log.d(TAG, "onPause");
        if (this.isDestroyed) {
            return;
        }
        stop();
        this.recordingTime = SystemClock.elapsedRealtime() - getBase();
    }

    public void onStart() {
        Log.d(TAG, "onStart");
        this.isDestroyed = false;
        setBase(SystemClock.elapsedRealtime() - this.recordingTime);
        start();
    }

    public SquareChronometer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDestroyed = false;
        init();
    }
}
