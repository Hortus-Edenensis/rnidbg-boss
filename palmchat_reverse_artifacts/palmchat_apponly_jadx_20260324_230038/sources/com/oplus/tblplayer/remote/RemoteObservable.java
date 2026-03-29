package com.oplus.tblplayer.remote;

import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.IRemoteObservable;
import com.oplus.tblplayer.misc.TimedText;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RemoteObservable implements IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPlaybackResultListener, IMediaPlayer.OnPlayerEventListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnTimedTextListener, IMediaPlayer.OnVideoSizeChangedListener {
    static final int FLAG_BASE = 1;
    static final int FLAG_BUFFERING_UPDATE_LISTENER = 4;
    static final int FLAG_COMPLETION_LISTENER = 2;
    static final int FLAG_ERROR_LISTENER = 32;
    static final int FLAG_INFO_LISTENER = 64;
    static final int FLAG_PLAYBACK_RESULT_LISTENER = 256;
    static final int FLAG_PLAYER_EVENT_LISTENER = 512;
    static final int FLAG_PREPARED_LISTENER = 1;
    static final int FLAG_SEEK_COMPLETION_LISTENER = 8;
    static final int FLAG_TIMED_TEXT_LISTENER = 128;
    static final int FLAG_VIDEO_SIZE_CHANGED_LISTENER = 16;
    private static final String TAG = "RemoteObservable";
    private int mNotifyFlag = 0;
    private IRemoteObservable mRemoteObservable;

    public RemoteObservable(IBinder iBinder) {
        this.mRemoteObservable = IRemoteObservable.Stub.asInterface(iBinder);
    }

    private boolean shouldNotify(int i) {
        return (i & this.mNotifyFlag) != 0;
    }

    public IBinder asBinder() {
        return this.mRemoteObservable.asBinder();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferedUpdate(IMediaPlayer iMediaPlayer, int i) {
        if (shouldNotify(4)) {
            try {
                this.mRemoteObservable.notifyBufferedUpdate(i);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onBufferedUpdate: ", e);
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        if (shouldNotify(4)) {
            try {
                this.mRemoteObservable.notifyBufferingUpdate(i);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onBufferingUpdate: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(2)) {
            try {
                this.mRemoteObservable.notifyCompletion();
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onCompletion: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onDownstreamSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyDownstreamSizeChanged(i, i2, i3, f);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onDownstreamSizeChanged: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2, String str) {
        if (!shouldNotify(32)) {
            return false;
        }
        try {
            return this.mRemoteObservable.notifyError(i, i2, str);
        } catch (RemoteException e) {
            LogUtil.e(TAG, "onError: " + e.getMessage());
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, Object... objArr) {
        if (shouldNotify(64)) {
            try {
                ArrayList arrayList = new ArrayList(2);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (obj != null) {
                            arrayList.add(String.valueOf(obj));
                        }
                    }
                }
                return this.mRemoteObservable.notifyInfo(i, arrayList);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onInfo: " + e.getMessage());
            }
        }
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onIsPlayingChanged(IMediaPlayer iMediaPlayer, boolean z) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyIsPlayingChanged(z);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onIsPlayingChanged: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener
    public boolean onPlaybackResult(IMediaPlayer iMediaPlayer, Report report) {
        if (!shouldNotify(256)) {
            return false;
        }
        try {
            this.mRemoteObservable.notifyPlaybackResult(report);
            return false;
        } catch (RemoteException e) {
            LogUtil.e(TAG, "onPlaybackResult: " + e.getMessage());
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onPlayerStateChanged(IMediaPlayer iMediaPlayer, int i) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyPlayerStateChanged(i);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onPlayerStateChanged: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(1)) {
            try {
                this.mRemoteObservable.notifyPrepared();
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onPrepared: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(8)) {
            try {
                this.mRemoteObservable.notifySeekComplete();
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onSeekComplete: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener
    public void onTimedText(IMediaPlayer iMediaPlayer, TimedText timedText) {
        if (shouldNotify(128)) {
            try {
                this.mRemoteObservable.notifyTimedText(timedText);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onTimedText: " + e.getMessage());
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f) {
        if (shouldNotify(16)) {
            try {
                this.mRemoteObservable.notifyVideoSizeChanged(i, i2, i3, f);
            } catch (RemoteException e) {
                LogUtil.e(TAG, "onVideoSizeChanged: " + e.getMessage());
            }
        }
    }

    public void setNotifyFlag(int i, int i2) {
        this.mNotifyFlag = (i & i2) | (this.mNotifyFlag & (~i));
    }
}
