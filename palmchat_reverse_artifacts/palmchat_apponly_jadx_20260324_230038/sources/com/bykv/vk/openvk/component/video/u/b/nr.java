package com.bykv.vk.openvk.component.video.u.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.component.sdk.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends com.bykv.vk.openvk.component.video.u.b.u {
    private com.bykv.vk.openvk.component.video.u.u.u b;
    private final u fx;
    private final Object iz;
    private final MediaPlayer nr;
    private Surface pn;
    private volatile boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<nr> u;

        public u(nr nrVar) {
            this.u = new WeakReference<>(nrVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    nrVar.u(i);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    nrVar.fx();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    return nrVar.u(i, i2);
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    return nrVar.nr(i, i2);
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    nrVar.nr();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    nrVar.b();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                nr nrVar = this.u.get();
                if (nrVar != null) {
                    nrVar.u(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public nr() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.iz = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.nr = mediaPlayer;
        }
        u(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.fx = new u(this);
        my();
    }

    private void k() {
        com.bykv.vk.openvk.component.video.u.u.u uVar;
        if (Build.VERSION.SDK_INT < 23 || (uVar = this.b) == null) {
            return;
        }
        try {
            uVar.close();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.b = null;
    }

    private void my() {
        this.nr.setOnPreparedListener(this.fx);
        this.nr.setOnBufferingUpdateListener(this.fx);
        this.nr.setOnCompletionListener(this.fx);
        this.nr.setOnSeekCompleteListener(this.fx);
        this.nr.setOnVideoSizeChangedListener(this.fx);
        this.nr.setOnErrorListener(this.fx);
        this.nr.setOnInfoListener(this.fx);
    }

    private void o() {
        try {
            Surface surface = this.pn;
            if (surface != null) {
                surface.release();
                this.pn = null;
            }
        } catch (Throwable unused) {
        }
    }

    private void u(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.fx.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public long a() {
        try {
            return this.nr.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void b(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.nr;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        o();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void fx(boolean z) throws Throwable {
        this.nr.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void iz() throws Throwable {
        this.nr.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public long jk() {
        try {
            return this.nr.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void l() throws Throwable {
        try {
            this.nr.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO", "reset error: ", th);
        }
        k();
        u();
        my();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public int mv() {
        MediaPlayer mediaPlayer = this.nr;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void n() {
        MediaPlayer mediaPlayer = this.nr;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void nr(boolean z) throws Throwable {
        this.nr.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void pn() throws Throwable {
        this.nr.start();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public int s() {
        MediaPlayer mediaPlayer = this.nr;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void t() throws Throwable {
        synchronized (this.iz) {
            if (!this.x) {
                this.nr.release();
                this.x = true;
                o();
                k();
                u();
                my();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void x() throws Throwable {
        this.nr.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void pn(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.nr;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void u(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.iz) {
            try {
                if (!this.x && surfaceHolder != null && surfaceHolder.getSurface() != null && this.u) {
                    this.nr.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    @TargetApi(14)
    public void u(Surface surface) {
        o();
        this.pn = surface;
        this.nr.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    @RequiresApi(api = 23)
    public void u(com.bykv.vk.openvk.component.video.api.nr nrVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.nr.setPlaybackParams(this.nr.getPlaybackParams().setSpeed(nrVar.u()));
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void u(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.nr.setDataSource(uri.getPath());
        } else {
            this.nr.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void u(FileDescriptor fileDescriptor) throws Throwable {
        this.nr.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    @RequiresApi(api = 23)
    public synchronized void u(iz izVar, com.bykv.vk.openvk.component.video.api.fx.nr nrVar) {
        this.b = com.bykv.vk.openvk.component.video.u.u.u.u(com.bykv.vk.openvk.component.video.api.fx.getContext(), nrVar, izVar);
        com.bykv.vk.openvk.component.video.u.u.nr.fx.u(izVar);
        this.nr.setDataSource(this.b);
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void u(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.nr.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.nr.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.nr.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.nr.seekTo((int) j, 2);
        } else if (i == 3) {
            this.nr.seekTo((int) j, 3);
        } else {
            this.nr.seekTo((int) j);
        }
    }
}
