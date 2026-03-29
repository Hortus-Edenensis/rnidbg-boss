package com.oplus.tblplayer.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.oplus.tblplayer.IRemoteLinker;
import com.oplus.tblplayer.IRemoteObservable;
import com.oplus.tblplayer.misc.TimedText;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLRemotePlayer extends RemotePlayerProxy implements ServiceConnection, IBinder.DeathRecipient {
    private static final int BIND_SERVICE_TIMEOUT = 5000;
    private static final int BIND_STATE_BINDING = 1;
    private static final int BIND_STATE_BOUND = 2;
    private static final int BIND_STATE_IDLE = 0;
    private static final int BIND_STATE_RELEASE = 3;
    private static final String TAG = "TBLRemotePlayer";
    private final Context mAppContext;
    protected Handler mEventHandler;
    private IRemoteLinker mRemoteLinker;
    private final Intent mServiceIntent;
    private long startBindTime = 0;
    private long onBoundTime = 0;
    private int mBinderState = 0;
    private final Runnable mBindTimeOutRunnable = new Runnable() { // from class: nr5
        @Override // java.lang.Runnable
        public final void run() {
            this.f19585a.lambda$new$1();
        }
    };
    private IRemoteObservable mRemoteObservable = new AnonymousClass1();

    /* JADX INFO: renamed from: com.oplus.tblplayer.remote.TBLRemotePlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 extends IRemoteObservable.Stub {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyBufferedUpdate$3(int i) {
            TBLRemotePlayer.this.notifyOnBufferedUpdate(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyBufferingUpdate$2(int i) {
            TBLRemotePlayer.this.notifyOnBufferingUpdate(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyCompletion$1() {
            TBLRemotePlayer.this.notifyOnCompletion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyDownstreamSizeChanged$12(int i, int i2, int i3, float f) {
            TBLRemotePlayer.this.notifyOnDownstreamSizeChanged(i, i2, i3, f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyError$6(int i, int i2, String str) {
            TBLRemotePlayer.this.notifyOnError(i, i2, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyInfo$7(int i, List list) {
            TBLRemotePlayer.this.notifyOnInfo(i, list.toArray());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyIsPlayingChanged$11(boolean z) {
            TBLRemotePlayer.this.notifyOnIsPlayingChanged(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyPlaybackResult$9(Report report) {
            TBLRemotePlayer.this.notifyOnPlaybackResult(report);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyPlayerStateChanged$10(int i) {
            TBLRemotePlayer.this.notifyOnPlayerStateChanged(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyPrepared$0() {
            TBLRemotePlayer.this.notifyOnPrepared();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifySeekComplete$4() {
            TBLRemotePlayer.this.notifyOnSeekComplete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyTimedText$8(TimedText timedText) {
            TBLRemotePlayer.this.notifyOnTimedText(timedText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyVideoSizeChanged$5(int i, int i2, int i3, float f) {
            TBLRemotePlayer.this.notifyOnVideoSizeChanged(i, i2, i3, f);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferedUpdate(final int i) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7696a.lambda$notifyBufferedUpdate$3(i);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(final int i) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7693a.lambda$notifyBufferingUpdate$2(i);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7692a.lambda$notifyCompletion$1();
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(final int i, final int i2, final int i3, final float f) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7700a.lambda$notifyDownstreamSizeChanged$12(i, i2, i3, f);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(final int i, final int i2, final String str) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler == null) {
                return false;
            }
            handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7688a.lambda$notifyError$6(i, i2, str);
                }
            });
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(final int i, final List<String> list) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler == null) {
                return false;
            }
            handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7695a.lambda$notifyInfo$7(i, list);
                }
            });
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(final boolean z) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7697a.lambda$notifyIsPlayingChanged$11(z);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(final Report report) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7699a.lambda$notifyPlaybackResult$9(report);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(final int i) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7690a.lambda$notifyPlayerStateChanged$10(i);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7698a.lambda$notifyPrepared$0();
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7691a.lambda$notifySeekComplete$4();
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(final TimedText timedText) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7689a.lambda$notifyTimedText$8(timedText);
                    }
                });
            }
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(final int i, final int i2, final int i3, final float f) throws RemoteException {
            Handler handler = TBLRemotePlayer.this.mEventHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7694a.lambda$notifyVideoSizeChanged$5(i, i2, i3, f);
                    }
                });
            }
        }
    }

    public TBLRemotePlayer(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mServiceIntent = new Intent(applicationContext, (Class<?>) TBLRemotePlayerService.class);
        this.mEventHandler = new Handler(getLooper());
        startBindService();
    }

    public static Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    private synchronized void handleBinderDied(boolean z, int i, String str) {
        LogUtil.d(TAG, "handleBinderDied: notify is " + z + ", binder state is " + this.mBinderState);
        if (this.mBinderState != 3) {
            if (z) {
                notifyBinderError(i, str);
            }
            unbindService();
        }
    }

    private synchronized void handleServiceBound(IBinder iBinder) {
        this.onBoundTime = System.currentTimeMillis();
        LogUtil.d(TAG, "handleServiceBound: onBoundTime is " + this.onBoundTime + ", bind consuming time is " + (this.onBoundTime - this.startBindTime));
        if (this.mBinderState != 1) {
            return;
        }
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mBindTimeOutRunnable);
        }
        try {
            IRemoteLinker iRemoteLinkerAsInterface = IRemoteLinker.Stub.asInterface(iBinder);
            this.mRemoteLinker = iRemoteLinkerAsInterface;
            iRemoteLinkerAsInterface.asBinder().linkToDeath(this, 0);
            this.mRemotePlayer = this.mRemoteLinker.create();
            this.mBinderState = 2;
            invokeRemoteMethod(33, this.mRemoteObservable);
            this.mSurfaceCache.refreshSurface();
            flushPendingTaskStack();
        } catch (RemoteException e) {
            LogUtil.e(TAG, "handleServiceBound: Caught a  RemoteException.", e);
            binderDied();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        LogUtil.e(TAG, "startBindService: Fail to bind remote service because time out.");
        handleBinderDied(true, ErrorCode.REASON_BIND_TIMEOUT, "Waited for 5000ms, but service was never response.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyBinderError$0(int i, String str) {
        notifyOnError(2, i, str);
        onRelease();
    }

    private void notifyBinderError(final int i, final String str) {
        LogUtil.d(TAG, "notifyBinderError: Notify APP binder error.");
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: or5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19820a.lambda$notifyBinderError$0(i, str);
                }
            });
        }
    }

    private synchronized void startBindService() {
        this.startBindTime = System.currentTimeMillis();
        LogUtil.d(TAG, "startBindService: startBindTime is " + this.startBindTime);
        if (this.mBinderState != 0) {
            return;
        }
        try {
            if (!this.mAppContext.bindService(this.mServiceIntent, this, 1)) {
                LogUtil.e(TAG, "startBindService: Fail to bind remote service.");
                handleBinderDied(true, ErrorCode.REASON_BIND_FAILED, "Bind service failed.");
            }
            this.mBinderState = 1;
            this.mEventHandler.postDelayed(this.mBindTimeOutRunnable, 5000L);
        } catch (SecurityException e) {
            LogUtil.e(TAG, "startBindService: SecurityException.");
            handleBinderDied(true, ErrorCode.REASON_BIND_FAILED, "Bind service has exception. " + e.getMessage());
        }
    }

    private void unbindService() {
        LogUtil.d(TAG, "unbindService");
        try {
            this.mAppContext.unbindService(this);
        } catch (IllegalArgumentException e) {
            LogUtil.e(TAG, "unbindService: Service is not exist. " + e.getMessage());
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        LogUtil.d(TAG, "binderDied");
        handleBinderDied(true, ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    public <T> T execRemoteMethod(int i, T t, Object... objArr) {
        try {
            T t2 = (T) ParcelUtils.invokeRemoteMethod(this.mRemotePlayer, "RemotePlayer", i, objArr);
            return t2 == null ? t : t2;
        } catch (RemoteException e) {
            LogUtil.e(TAG, "execRemoteMethod fail [IPC]: " + e.getMessage());
            binderDied();
            return t;
        }
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    public void onRelease() {
        super.onRelease();
        this.mBinderState = 3;
        LogUtil.d(TAG, "onRelease");
        IRemoteLinker iRemoteLinker = this.mRemoteLinker;
        if (iRemoteLinker != null) {
            iRemoteLinker.asBinder().unlinkToDeath(this, 0);
            this.mRemoteLinker = null;
        }
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mEventHandler = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        handleServiceBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LogUtil.d(TAG, "onServiceDisconnected");
        handleBinderDied(true, ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    public boolean shouldInvoke() {
        return this.mRemotePlayer != null && this.mBinderState == 2;
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    public boolean shouldPending() {
        return this.mRemotePlayer == null && this.mBinderState == 1;
    }
}
