package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.v;
import defpackage.g86;
import defpackage.k06;
import defpackage.m54;
import defpackage.pr0;
import defpackage.qx1;
import defpackage.te6;
import defpackage.xr0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface v {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements f {
        public static final b b = new a().e();
        public static final String c = g86.w0(0);
        public static final f.a<b> d = new f.a() { // from class: uj4
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return v.b.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qx1 f6035a;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {
            public static final int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 27, 28, 29, 30, 32};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final qx1.b f6036a = new qx1.b();

            public a a(int i) {
                this.f6036a.a(i);
                return this;
            }

            public a b(b bVar) {
                this.f6036a.b(bVar.f6035a);
                return this;
            }

            public a c(int... iArr) {
                this.f6036a.c(iArr);
                return this;
            }

            public a d(int i, boolean z) {
                this.f6036a.d(i, z);
                return this;
            }

            public b e() {
                return new b(this.f6036a.e());
            }
        }

        public static b d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(c);
            if (integerArrayList == null) {
                return b;
            }
            a aVar = new a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(integerArrayList.get(i).intValue());
            }
            return aVar.e();
        }

        public boolean c(int i) {
            return this.f6035a.a(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f6035a.equals(((b) obj).f6035a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6035a.hashCode();
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.f6035a.d(); i++) {
                arrayList.add(Integer.valueOf(this.f6035a.c(i)));
            }
            bundle.putIntegerArrayList(c, arrayList);
            return bundle;
        }

        public b(qx1 qx1Var) {
            this.f6035a = qx1Var;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qx1 f6037a;

        public c(qx1 qx1Var) {
            this.f6037a = qx1Var;
        }

        public boolean a(int i) {
            return this.f6037a.a(i);
        }

        public boolean b(int... iArr) {
            return this.f6037a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f6037a.equals(((c) obj).f6037a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6037a.hashCode();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void B(f0 f0Var);

        void D(v vVar, c cVar);

        void I(@Nullable p pVar, int i);

        void d(xr0 xr0Var);

        void f(Metadata metadata);

        void g(u uVar);

        void i(te6 te6Var);

        void l(e eVar, e eVar2, int i);

        void m(e0 e0Var, int i);

        void n(q qVar);

        @Deprecated
        void onCues(List<pr0> list);

        void onDeviceVolumeChanged(int i, boolean z);

        void onIsLoadingChanged(boolean z);

        void onIsPlayingChanged(boolean z);

        @Deprecated
        void onLoadingChanged(boolean z);

        void onPlayWhenReadyChanged(boolean z, int i);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        @Deprecated
        void onPlayerStateChanged(boolean z, int i);

        @Deprecated
        void onPositionDiscontinuity(int i);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i);

        void onShuffleModeEnabledChanged(boolean z);

        void onSkipSilenceEnabledChanged(boolean z);

        void onSurfaceSizeChanged(int i, int i2);

        void onVolumeChanged(float f);

        void p(@Nullable PlaybackException playbackException);

        void r(k06 k06Var);

        void s(PlaybackException playbackException);

        void w(b bVar);

        void x(i iVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements f {
        public static final String k = g86.w0(0);
        public static final String l = g86.w0(1);
        public static final String m = g86.w0(2);
        public static final String n = g86.w0(3);
        public static final String o = g86.w0(4);
        public static final String p = g86.w0(5);
        public static final String q = g86.w0(6);
        public static final f.a<e> r = new f.a() { // from class: yj4
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return v.e.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f6038a;

        @Deprecated
        public final int b;
        public final int c;

        @Nullable
        public final p d;

        @Nullable
        public final Object e;
        public final int f;
        public final long g;
        public final long h;
        public final int i;
        public final int j;

        public e(@Nullable Object obj, int i, @Nullable p pVar, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.f6038a = obj;
            this.b = i;
            this.c = i;
            this.d = pVar;
            this.e = obj2;
            this.f = i2;
            this.g = j;
            this.h = j2;
            this.i = i3;
            this.j = i4;
        }

        public static e b(Bundle bundle) {
            int i = bundle.getInt(k, 0);
            Bundle bundle2 = bundle.getBundle(l);
            return new e(null, i, bundle2 == null ? null : (p) p.p.fromBundle(bundle2), null, bundle.getInt(m, 0), bundle.getLong(n, 0L), bundle.getLong(o, 0L), bundle.getInt(p, -1), bundle.getInt(q, -1));
        }

        public Bundle c(boolean z, boolean z2) {
            Bundle bundle = new Bundle();
            bundle.putInt(k, z2 ? this.c : 0);
            p pVar = this.d;
            if (pVar != null && z) {
                bundle.putBundle(l, pVar.toBundle());
            }
            bundle.putInt(m, z2 ? this.f : 0);
            bundle.putLong(n, z ? this.g : 0L);
            bundle.putLong(o, z ? this.h : 0L);
            bundle.putInt(p, z ? this.i : -1);
            bundle.putInt(q, z ? this.j : -1);
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.c == eVar.c && this.f == eVar.f && this.g == eVar.g && this.h == eVar.h && this.i == eVar.i && this.j == eVar.j && m54.a(this.f6038a, eVar.f6038a) && m54.a(this.e, eVar.e) && m54.a(this.d, eVar.d);
        }

        public int hashCode() {
            return m54.b(this.f6038a, Integer.valueOf(this.c), this.d, this.e, Integer.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            return c(true, true);
        }
    }

    void a(d dVar);

    void b(u uVar);

    void c(k06 k06Var);

    void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void clearVideoTextureView(@Nullable TextureView textureView);

    void d(p pVar);

    void e(d dVar);

    Looper getApplicationLooper();

    b getAvailableCommands();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    xr0 getCurrentCues();

    int getCurrentMediaItemIndex();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    e0 getCurrentTimeline();

    f0 getCurrentTracks();

    long getDuration();

    long getMaxSeekToPreviousPosition();

    q getMediaMetadata();

    boolean getPlayWhenReady();

    u getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    @Nullable
    PlaybackException getPlayerError();

    int getRepeatMode();

    long getSeekBackIncrement();

    long getSeekForwardIncrement();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    k06 getTrackSelectionParameters();

    te6 getVideoSize();

    boolean hasNextMediaItem();

    boolean hasPreviousMediaItem();

    boolean isCommandAvailable(int i);

    boolean isCurrentMediaItemDynamic();

    boolean isCurrentMediaItemLive();

    boolean isCurrentMediaItemSeekable();

    boolean isPlaying();

    boolean isPlayingAd();

    void pause();

    void play();

    void prepare();

    void release();

    void seekBack();

    void seekForward();

    void seekTo(int i, long j);

    void seekTo(long j);

    void seekToDefaultPosition();

    void seekToNext();

    void seekToPrevious();

    void setMediaItems(List<p> list, boolean z);

    void setPlayWhenReady(boolean z);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

    void setVideoTextureView(@Nullable TextureView textureView);

    void setVolume(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f);

    void stop();
}
