package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.v;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.video.LxAdVideoView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wu3 {
    public static wu3 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21804a;
    public kr1 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements v.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LxAdBaseView f21805a;
        public final /* synthetic */ StyledPlayerView b;

        public a(LxAdBaseView lxAdBaseView, StyledPlayerView styledPlayerView) {
            this.f21805a = lxAdBaseView;
            this.b = styledPlayerView;
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void B(f0 f0Var) {
            wj4.C(this, f0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void D(v vVar, v.c cVar) {
            wj4.f(this, vVar, cVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void I(p pVar, int i) {
            wj4.j(this, pVar, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void d(xr0 xr0Var) {
            wj4.b(this, xr0Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void f(Metadata metadata) {
            wj4.l(this, metadata);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void g(u uVar) {
            wj4.n(this, uVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void i(te6 te6Var) {
            wj4.D(this, te6Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void l(v.e eVar, v.e eVar2, int i) {
            wj4.u(this, eVar, eVar2, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void m(e0 e0Var, int i) {
            wj4.A(this, e0Var, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void n(q qVar) {
            wj4.k(this, qVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onCues(List list) {
            wj4.c(this, list);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            wj4.e(this, i, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            wj4.g(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            wj4.h(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onLoadingChanged(boolean z) {
            wj4.i(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            wj4.m(this, z, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public void onPlaybackStateChanged(int i) {
            LxAdVideoView lxAdVideoView;
            if (i == 4) {
                LxAdBaseView lxAdBaseView = this.f21805a;
                if (lxAdBaseView != null) {
                    lxAdBaseView.videoAdFinish();
                    return;
                }
                return;
            }
            if (i == 3) {
                LogUtil.d("LxAdNestExoVideoManager", "STATE_READY  start ");
                LxAdBaseView lxAdBaseView2 = this.f21805a;
                if (lxAdBaseView2 == null || (lxAdVideoView = lxAdBaseView2.videoView) == null) {
                    return;
                }
                lxAdVideoView.videoAdStart((int) this.b.getPlayer().getDuration());
            }
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            wj4.p(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            wj4.s(this, z, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            wj4.t(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onRenderedFirstFrame() {
            wj4.v(this);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onRepeatModeChanged(int i) {
            wj4.w(this, i);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            wj4.x(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            wj4.y(this, z);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            wj4.z(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void onVolumeChanged(float f) {
            wj4.E(this, f);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void p(PlaybackException playbackException) {
            wj4.r(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void r(k06 k06Var) {
            wj4.B(this, k06Var);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void s(PlaybackException playbackException) {
            wj4.q(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void w(v.b bVar) {
            wj4.a(this, bVar);
        }

        @Override // com.google.android.exoplayer2.v.d
        public /* synthetic */ void x(i iVar) {
            wj4.d(this, iVar);
        }
    }

    public wu3(Context context) {
        this.b = null;
        this.f21804a = context;
        this.b = new kr1(context);
    }

    public static wu3 e(Context context) {
        if (c == null) {
            synchronized (wu3.class) {
                if (c == null) {
                    c = new wu3(context);
                }
            }
        }
        return c;
    }

    public StyledPlayerView a(String str, ViewGroup viewGroup, LxAdBaseView lxAdBaseView) {
        try {
            StyledPlayerView styledPlayerViewB = this.b.b(viewGroup, str, new ViewGroup.LayoutParams(-1, -1), true, 0);
            LogUtil.d("LxAdNestExoVideoManager", "addVideoAdView playerView " + styledPlayerViewB + " videoUrl " + str);
            styledPlayerViewB.getPlayer().setVolume(0.0f);
            styledPlayerViewB.getPlayer().e(new a(lxAdBaseView, styledPlayerViewB));
            return styledPlayerViewB;
        } catch (Exception e) {
            LogUtil.d("LxAdNestExoVideoManager", "addVideoAdView Exception e " + e.toString() + " videoUrl " + str);
            return null;
        }
    }

    public void b(boolean z, StyledPlayerView styledPlayerView) {
        if (styledPlayerView != null) {
            try {
                if (styledPlayerView.getPlayer() != null) {
                    if (z) {
                        styledPlayerView.getPlayer().setVolume(1.0f);
                    } else {
                        styledPlayerView.getPlayer().setVolume(0.0f);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c(StyledPlayerView styledPlayerView, boolean z) {
        if (styledPlayerView != null) {
            try {
                if (styledPlayerView.getPlayer() != null) {
                    if (z) {
                        if (!styledPlayerView.getPlayer().isPlaying()) {
                            styledPlayerView.getPlayer().play();
                            LogUtil.d("LxAdNestExoVideoManager", "playerViewXX checkVideoResumeOrPause play  view " + styledPlayerView);
                        }
                    } else if (styledPlayerView.getPlayer().isPlaying()) {
                        styledPlayerView.getPlayer().pause();
                        LogUtil.d("LxAdNestExoVideoManager", "playerViewXX checkVideoResumeOrPause pause  view " + styledPlayerView);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void d(StyledPlayerView styledPlayerView) {
        this.b.c(styledPlayerView);
    }

    public long f(StyledPlayerView styledPlayerView) {
        if (styledPlayerView == null) {
            return 0L;
        }
        try {
            if (styledPlayerView.getPlayer() != null) {
                return styledPlayerView.getPlayer().getCurrentPosition();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void g(StyledPlayerView styledPlayerView) {
        if (styledPlayerView != null) {
            try {
                if (styledPlayerView.getPlayer() != null) {
                    if (styledPlayerView.getPlayer().getPlaybackState() == 4) {
                        styledPlayerView.getPlayer().prepare();
                    }
                    styledPlayerView.getPlayer().seekTo(0L);
                    styledPlayerView.getPlayer().play();
                }
            } catch (Exception unused) {
            }
        }
    }
}
