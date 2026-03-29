package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface c {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void aM(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void rE();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.video.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0617c {
        boolean m(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        boolean n(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(c cVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void vh();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void rF();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(TimedText timedText);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        void l(int i, int i2);
    }

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0617c interfaceC0617c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void a(i iVar);

    void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar);

    void b(e eVar);

    void c(d dVar);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i2);

    void setDataSource(Context context, Uri uri);

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();

    boolean vx();
}
