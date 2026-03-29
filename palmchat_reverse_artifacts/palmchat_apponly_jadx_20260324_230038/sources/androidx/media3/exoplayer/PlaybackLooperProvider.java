package androidx.media3.exoplayer;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UnstableApi
public final class PlaybackLooperProvider {

    @Nullable
    @GuardedBy("lock")
    private HandlerThread internalPlaybackThread;
    private final Object lock;

    @Nullable
    @GuardedBy("lock")
    private Looper playbackLooper;

    @GuardedBy("lock")
    private int referenceCount;

    public PlaybackLooperProvider() {
        this(null);
    }

    public Looper obtainLooper() {
        Looper looper;
        synchronized (this.lock) {
            if (this.playbackLooper == null) {
                Assertions.checkState(this.referenceCount == 0 && this.internalPlaybackThread == null);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.internalPlaybackThread = handlerThread;
                handlerThread.start();
                this.playbackLooper = this.internalPlaybackThread.getLooper();
            }
            this.referenceCount++;
            looper = this.playbackLooper;
        }
        return looper;
    }

    public void releaseLooper() {
        HandlerThread handlerThread;
        synchronized (this.lock) {
            Assertions.checkState(this.referenceCount > 0);
            int i = this.referenceCount - 1;
            this.referenceCount = i;
            if (i == 0 && (handlerThread = this.internalPlaybackThread) != null) {
                handlerThread.quit();
                this.internalPlaybackThread = null;
                this.playbackLooper = null;
            }
        }
    }

    public PlaybackLooperProvider(@Nullable Looper looper) {
        this.lock = new Object();
        this.playbackLooper = looper;
        this.internalPlaybackThread = null;
        this.referenceCount = 0;
    }
}
