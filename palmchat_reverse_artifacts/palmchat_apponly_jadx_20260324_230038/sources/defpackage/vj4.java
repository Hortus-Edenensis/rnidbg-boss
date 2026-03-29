package defpackage;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.BufferingStuckResult;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.PlaybackParameters;
import com.oplus.tbl.exoplayer2.Player;
import com.oplus.tbl.exoplayer2.SeekResult;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.TrackSelectionArray;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class vj4 {
    public static void e(Player.EventListener eventListener, boolean z) {
        eventListener.onLoadingChanged(z);
    }

    public static void u(Player.EventListener eventListener, Timeline timeline, int i) {
        eventListener.onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
    }

    @Deprecated
    public static void r(Player.EventListener eventListener) {
    }

    public static void a(Player.EventListener eventListener, BufferingStuckResult bufferingStuckResult) {
    }

    public static void c(Player.EventListener eventListener, boolean z) {
    }

    public static void d(Player.EventListener eventListener, boolean z) {
    }

    public static void f(Player.EventListener eventListener, boolean z) {
    }

    @Deprecated
    public static void g(Player.EventListener eventListener, boolean z) {
    }

    public static void j(Player.EventListener eventListener, PlaybackParameters playbackParameters) {
    }

    public static void k(Player.EventListener eventListener, int i) {
    }

    public static void l(Player.EventListener eventListener, int i) {
    }

    public static void m(Player.EventListener eventListener, ExoPlaybackException exoPlaybackException) {
    }

    public static void o(Player.EventListener eventListener, int i) {
    }

    public static void p(Player.EventListener eventListener, int i) {
    }

    public static void q(Player.EventListener eventListener, SeekResult seekResult) {
    }

    public static void s(Player.EventListener eventListener, boolean z) {
    }

    public static void t(Player.EventListener eventListener, List list) {
    }

    public static void b(Player.EventListener eventListener, Player player, Player.Events events) {
    }

    public static void h(Player.EventListener eventListener, @Nullable MediaItem mediaItem, int i) {
    }

    public static void i(Player.EventListener eventListener, boolean z, int i) {
    }

    @Deprecated
    public static void n(Player.EventListener eventListener, boolean z, int i) {
    }

    public static void w(Player.EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    @Deprecated
    public static void v(Player.EventListener eventListener, Timeline timeline, @Nullable Object obj, int i) {
    }
}
