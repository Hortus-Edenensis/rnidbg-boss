package com.oplus.tblplayer.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.Surface;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.TBLExoPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RemotePlayerStub extends BaseBinderStub implements IBinder.DeathRecipient, IInterface {
    private static final String TAG = "RemotePlayerStub";
    private Context mAppContext;
    private Handler mMainThreadHandler;
    private RemoteObservable mObservable;
    private IMediaPlayer mPlayer;

    public RemotePlayerStub(Context context) {
        attachInterface(this, "RemotePlayer");
        this.mAppContext = context.getApplicationContext();
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mPlayer = (IMediaPlayer) execOnMainThread(new Callable() { // from class: gv4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f17820a.lambda$new$0();
            }
        });
    }

    private void bindObservable(IBinder iBinder) {
        try {
            RemoteObservable remoteObservable = new RemoteObservable(iBinder);
            this.mObservable = remoteObservable;
            remoteObservable.asBinder().linkToDeath(this, 0);
            IMediaPlayer iMediaPlayer = this.mPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.setOnPreparedListener(this.mObservable);
                this.mPlayer.setOnCompletionListener(this.mObservable);
                this.mPlayer.setOnBufferingUpdateListener(this.mObservable);
                this.mPlayer.setOnSeekCompleteListener(this.mObservable);
                this.mPlayer.setOnVideoSizeChangedListener(this.mObservable);
                this.mPlayer.setOnErrorListener(this.mObservable);
                this.mPlayer.setOnInfoListener(this.mObservable);
                this.mPlayer.setOnTimedTextListener(this.mObservable);
                this.mPlayer.setOnPlaybackResultListener(this.mObservable);
                this.mPlayer.setOnPlayerEventListener(this.mObservable);
            }
        } catch (RemoteException e) {
            LogUtil.e(TAG, "bindObservable: " + e.getMessage());
            release();
        }
    }

    private <T> T execOnMainThread(Callable<T> callable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        FutureTask futureTask = new FutureTask(callable);
        this.mMainThreadHandler.post(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: execTransact, reason: merged with bridge method [inline-methods] */
    public Object lambda$onTransactInternal$1(int i, Object... objArr) throws IOException {
        switch (i) {
            case 1:
                this.mPlayer.setDataSource((String) objArr[0]);
                return null;
            case 2:
                this.mPlayer.setDataSource((Uri) objArr[0]);
                return null;
            case 3:
                this.mPlayer.setDataSource((Uri) objArr[0], (Map) objArr[1]);
                return null;
            case 4:
                this.mPlayer.setDataSource((IMediaDataSource) objArr[0]);
                return null;
            case 5:
                this.mPlayer.setDataSource(((ParcelFileDescriptor) objArr[0]).getFileDescriptor());
                return null;
            case 6:
                return this.mPlayer.getDataSource();
            case 7:
                this.mPlayer.prepareAsync();
                return null;
            case 8:
                this.mPlayer.start();
                return null;
            case 9:
                this.mPlayer.stop();
                return null;
            case 10:
                this.mPlayer.pause();
                return null;
            case 11:
                this.mPlayer.seekTo(((Long) objArr[0]).longValue());
                return null;
            case 12:
                return Boolean.valueOf(this.mPlayer.isPlaying());
            case 13:
                return Boolean.valueOf(this.mPlayer.isPlayable());
            case 14:
                return Long.valueOf(this.mPlayer.getCurrentPosition());
            case 15:
                return Long.valueOf(this.mPlayer.getDuration());
            case 16:
                release();
                return null;
            case 17:
                this.mPlayer.reset();
                return null;
            case 18:
                this.mPlayer.setVolume(((Float) objArr[0]).floatValue());
                return null;
            case 19:
                this.mPlayer.setAudioStreamType(((Integer) objArr[0]).intValue());
                return null;
            case 20:
                return Integer.valueOf(this.mPlayer.getAudioSessionId());
            case 21:
                return this.mPlayer.getMediaInfo();
            case 22:
                return this.mPlayer.getTrackInfo();
            case 23:
                this.mPlayer.setKeepInBackground(((Boolean) objArr[0]).booleanValue());
                return null;
            case 24:
                return Integer.valueOf(this.mPlayer.getVideoSarNum());
            case 25:
                return Integer.valueOf(this.mPlayer.getVideoSarDen());
            case 26:
                this.mPlayer.setWakeMode(((Integer) objArr[0]).intValue());
                return null;
            case 27:
                this.mPlayer.setLooping(((Boolean) objArr[0]).booleanValue());
                return null;
            case 28:
                return Boolean.valueOf(this.mPlayer.isLooping());
            case 29:
                this.mPlayer.setScreenOnWhilePlaying(((Boolean) objArr[0]).booleanValue());
                return null;
            case 30:
                return Integer.valueOf(this.mPlayer.getVideoWidth());
            case 31:
                return Integer.valueOf(this.mPlayer.getVideoHeight());
            case 33:
                bindObservable((IBinder) objArr[0]);
            case 32:
                return null;
            case 34:
                RemoteObservable remoteObservable = this.mObservable;
                if (remoteObservable != null) {
                    remoteObservable.setNotifyFlag(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                return null;
            case 35:
                this.mPlayer.setSurface((Surface) objArr[0]);
                return null;
            case 36:
                return Long.valueOf(this.mPlayer.getContentBufferedPosition());
            case 37:
                return Boolean.valueOf(this.mPlayer.isPause());
            case 38:
                return Boolean.valueOf(this.mPlayer.isStop());
            case 39:
                return Float.valueOf(this.mPlayer.getSpeed());
            case 40:
                this.mPlayer.setNetworkType(((Integer) objArr[0]).intValue());
            case 41:
                return Long.valueOf(this.mPlayer.getBufferForPlaybackMs());
            case 42:
                return Integer.valueOf(this.mPlayer.getPlaybackState());
            default:
                return super.onTransactInternal(i, objArr);
        }
    }

    private void handleRelease() {
        execOnMainThread(new Callable() { // from class: fv4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f17607a.lambda$handleRelease$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$handleRelease$2() throws Exception {
        IMediaPlayer iMediaPlayer = this.mPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
            this.mPlayer = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ IMediaPlayer lambda$new$0() throws Exception {
        return new TBLExoPlayer(this.mAppContext);
    }

    private synchronized void release() {
        handleRelease();
        RemoteObservable remoteObservable = this.mObservable;
        if (remoteObservable != null) {
            remoteObservable.asBinder().unlinkToDeath(this, 0);
            this.mObservable = null;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        LogUtil.d(TAG, "binderDied");
        release();
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    public Object onTransactInternal(final int i, final Object... objArr) throws IOException {
        return execOnMainThread(new Callable() { // from class: hv4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f18060a.lambda$onTransactInternal$1(i, objArr);
            }
        });
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
