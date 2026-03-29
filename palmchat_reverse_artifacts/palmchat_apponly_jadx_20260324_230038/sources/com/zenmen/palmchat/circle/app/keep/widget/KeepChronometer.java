package com.zenmen.palmchat.circle.app.keep.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Chronometer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepChronometer extends Chronometer {
    private static final String TAG = "com.zenmen.palmchat.circle.app.keep.widget.KeepChronometer";
    private boolean isDestroyed;
    private long recordingTime;

    public KeepChronometer(Context context) {
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

    public KeepChronometer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDestroyed = false;
        init();
    }
}
