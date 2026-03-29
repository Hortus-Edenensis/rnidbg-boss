package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import defpackage.k21;
import defpackage.ly6;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private final MediaPlayer aOY;
    private final a aOZ;
    private MediaDataSource aPa;
    private final Object aeG;
    private String aeH;
    private boolean aeM;
    private boolean aeO;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        public a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i != 3) {
                return bVar.notifyOnInfo(i, i2);
            }
            if (bVar.aeO) {
                return false;
            }
            b.a(bVar, true);
            return bVar.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.y(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aeG = obj;
        this.aeO = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aOY = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aOZ = new a(this);
        vy();
        setLooping(false);
    }

    private void LO() {
        MediaDataSource mediaDataSource = this.aPa;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aPa = null;
        }
    }

    private void vy() {
        this.aOY.setOnPreparedListener(this.aOZ);
        this.aOY.setOnBufferingUpdateListener(this.aOZ);
        this.aOY.setOnCompletionListener(this.aOZ);
        this.aOY.setOnSeekCompleteListener(this.aOZ);
        this.aOY.setOnVideoSizeChangedListener(this.aOZ);
        this.aOY.setOnErrorListener(this.aOZ);
        this.aOY.setOnInfoListener(this.aOZ);
        this.aOY.setOnTimedTextListener(this.aOZ);
    }

    private void vz() {
        this.aOY.setOnPreparedListener(null);
        this.aOY.setOnBufferingUpdateListener(null);
        this.aOY.setOnCompletionListener(null);
        this.aOY.setOnSeekCompleteListener(null);
        this.aOY.setOnVideoSizeChangedListener(null);
        this.aOY.setOnErrorListener(null);
        this.aOY.setOnInfoListener(null);
        this.aOY.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) throws IOException {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap map = new HashMap();
        map.put("Content-Type", "video/mp4");
        map.put(HttpHeaders.ACCEPT_RANGES, "bytes");
        map.put("Status", "206");
        map.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aOY.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aOY.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aeH;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aOY.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aOY.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aOY.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aOY.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aOY.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aOY.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aOY.prepareAsync();
        LN();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.aeM = true;
            this.aOY.release();
            LO();
            resetListeners();
            vz();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aOY.reset();
            this.aeO = false;
        } catch (IllegalStateException unused) {
        }
        LO();
        resetListeners();
        vy();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aOY.seekTo((int) j, 3);
        } else {
            this.aOY.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        this.aOY.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) throws IOException {
        this.aOY.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aeG) {
            if (!this.aeM) {
                this.aOY.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aOY.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.aOY.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                PlaybackParams playbackParams = this.aOY.getPlaybackParams();
                if (playbackParams == null) {
                    ly6.a();
                    playbackParams = k21.a();
                }
                playbackParams.setSpeed(f);
                this.aOY.setPlaybackParams(playbackParams);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aOY.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aOY.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.l(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aOY.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aOY.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean vx() {
        this.aOY.prepareAsync();
        LN();
        return true;
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.aeO = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        this.aOY.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        this.aOY.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) throws IOException {
        this.aeH = str;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.aOY.setDataSource(uri.getPath());
        } else {
            this.aOY.setDataSource(str);
        }
    }
}
