package com.tencent.matrix.batterycanary;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.util.MatrixLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class BatteryEventDelegate {
    public static final String TAG = "Matrix.battery.LifeCycle";
    static long sBackgroundBgnMillis;

    @SuppressLint({"StaticFieldLeak"})
    static volatile BatteryEventDelegate sInstance;
    final Context mContext;

    @Nullable
    BatteryMonitorCore mCore;
    final List<Listener> mListenerList = new LinkedList();
    final Handler mUiHandler = new Handler(Looper.getMainLooper());
    final BackgroundTask mAppLowEnergyTask = new BackgroundTask();
    boolean sIsForeground = true;

    /* JADX INFO: compiled from: SearchBox */
    public final class BackgroundTask implements Runnable {
        private long duringMillis;

        public BackgroundTask() {
        }

        public long reset() {
            this.duringMillis = 0L;
            setNext(300000L);
            return this.duringMillis;
        }

        @Override // java.lang.Runnable
        public void run() {
            BatteryEventDelegate batteryEventDelegate = BatteryEventDelegate.this;
            if (batteryEventDelegate.sIsForeground) {
                return;
            }
            if (!BatteryCanaryUtil.isDeviceCharging(batteryEventDelegate.mContext)) {
                BatteryEventDelegate.this.onAppLowEnergyEvent(this.duringMillis);
            }
            long j = this.duringMillis;
            if (j <= 300000) {
                BatteryEventDelegate.this.mUiHandler.postDelayed(this, setNext(300000L));
            } else if (j <= 600000) {
                BatteryEventDelegate.this.mUiHandler.postDelayed(this, setNext(1200000L));
            }
        }

        public long setNext(long j) {
            this.duringMillis += j;
            return j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class BatteryState {
        final Context mContext;

        @Nullable
        BatteryMonitorCore mCore;

        public BatteryState(Context context) {
            this.mContext = context;
        }

        public BatteryState attach(BatteryMonitorCore batteryMonitorCore) {
            if (batteryMonitorCore != null) {
                this.mCore = batteryMonitorCore;
            }
            return this;
        }

        public long getBackgroundTimeMillis() {
            if (!isForeground() && BatteryEventDelegate.sBackgroundBgnMillis > 0) {
                return SystemClock.uptimeMillis() - BatteryEventDelegate.sBackgroundBgnMillis;
            }
            return 0L;
        }

        public boolean isCharging() {
            return BatteryCanaryUtil.isDeviceCharging(this.mContext);
        }

        public boolean isForeground() {
            BatteryMonitorCore batteryMonitorCore = this.mCore;
            return batteryMonitorCore == null || batteryMonitorCore.isForeground();
        }

        public boolean isPowerSaveMode() {
            return BatteryCanaryUtil.isDeviceOnPowerSave(this.mContext);
        }

        public boolean isScreenOn() {
            return BatteryCanaryUtil.isDeviceScreenOn(this.mContext);
        }

        public String toString() {
            return "BatteryState{fg=" + isForeground() + ", charge=" + isCharging() + ", screen=" + isScreenOn() + ", doze=" + isPowerSaveMode() + ", bgMillis=" + getBackgroundTimeMillis() + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {

        /* JADX INFO: compiled from: SearchBox */
        @Retention(RetentionPolicy.SOURCE)
        public @interface BatteryEventDef {
        }

        @UiThread
        boolean onAppLowEnergy(BatteryState batteryState, long j);

        @UiThread
        boolean onStateChanged(String str);
    }

    public BatteryEventDelegate(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context should not be null");
        }
        this.mContext = context;
    }

    public static BatteryEventDelegate getInstance() {
        if (sInstance == null) {
            synchronized (TAG) {
                if (sInstance == null) {
                    throw new IllegalStateException("Call #init() first!");
                }
            }
        }
        return sInstance;
    }

    public static void init(Application application) {
        if (sInstance == null) {
            synchronized (TAG) {
                if (sInstance == null) {
                    sInstance = new BatteryEventDelegate(application);
                }
            }
        }
    }

    public static boolean isInit() {
        boolean z = true;
        if (sInstance != null) {
            return true;
        }
        synchronized (TAG) {
            if (sInstance == null) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppLowEnergyEvent(final long j) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dispatchAppLowEnergyEvent(j);
        } else {
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.matrix.batterycanary.BatteryEventDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    BatteryEventDelegate.this.dispatchAppLowEnergyEvent(j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSateChangedEvent(final Intent intent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            dispatchSateChangedEvent(intent);
        } else {
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.matrix.batterycanary.BatteryEventDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    BatteryEventDelegate.this.dispatchSateChangedEvent(intent);
                }
            });
        }
    }

    @VisibleForTesting
    public static void release() {
        sInstance = null;
    }

    public void addListener(@NonNull Listener listener) {
        synchronized (this.mListenerList) {
            if (!this.mListenerList.contains(listener)) {
                this.mListenerList.add(listener);
            }
        }
    }

    public BatteryEventDelegate attach(BatteryMonitorCore batteryMonitorCore) {
        if (batteryMonitorCore != null) {
            this.mCore = batteryMonitorCore;
        }
        return this;
    }

    public BatteryState currentState() {
        return new BatteryState(this.mContext).attach(this.mCore);
    }

    @VisibleForTesting
    public void dispatchAppLowEnergyEvent(long j) {
        synchronized (this.mListenerList) {
            Iterator<Listener> it = this.mListenerList.iterator();
            while (it.hasNext()) {
                if (it.next().onAppLowEnergy(currentState(), j)) {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public void dispatchSateChangedEvent(Intent intent) {
        MatrixLog.i(TAG, "onSateChanged >> " + intent.getAction(), new Object[0]);
        synchronized (this.mListenerList) {
            for (Listener listener : this.mListenerList) {
                if (listener.onStateChanged(intent.getAction())) {
                    removeListener(listener);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onForeground(boolean z) {
        this.sIsForeground = z;
        if (z) {
            sBackgroundBgnMillis = 0L;
            this.mUiHandler.removeCallbacks(this.mAppLowEnergyTask);
        } else {
            sBackgroundBgnMillis = SystemClock.uptimeMillis();
            Handler handler = this.mUiHandler;
            BackgroundTask backgroundTask = this.mAppLowEnergyTask;
            handler.postDelayed(backgroundTask, backgroundTask.reset());
        }
    }

    public void removeListener(@NonNull Listener listener) {
        synchronized (this.mListenerList) {
            ListIterator<Listener> listIterator = this.mListenerList.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next() == listener) {
                    listIterator.remove();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void startListening() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.matrix.batterycanary.BatteryEventDelegate.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action != null) {
                    switch (action) {
                        case "android.intent.action.SCREEN_OFF":
                        case "android.intent.action.ACTION_POWER_DISCONNECTED":
                        case "android.intent.action.SCREEN_ON":
                        case "android.intent.action.ACTION_POWER_CONNECTED":
                            BatteryEventDelegate.this.onSateChangedEvent(intent);
                            break;
                    }
                }
            }
        }, intentFilter);
    }
}
