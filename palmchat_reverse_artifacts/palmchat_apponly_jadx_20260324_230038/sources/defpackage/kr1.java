package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.v;
import com.zenmen.palmchat.R;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class kr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18813a;
    public ConcurrentLinkedDeque<StyledPlayerView> b = new ConcurrentLinkedDeque<>();

    public kr1(Context context) {
        this.f18813a = context;
    }

    public final String a(String str) {
        try {
            return k86.Z(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public synchronized StyledPlayerView b(ViewGroup viewGroup, String str, ViewGroup.LayoutParams layoutParams, boolean z, int i) {
        StyledPlayerView styledPlayerViewPoll;
        styledPlayerViewPoll = this.b.poll();
        if (styledPlayerViewPoll == null) {
            styledPlayerViewPoll = (StyledPlayerView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_view_exo_player, viewGroup, false);
            styledPlayerViewPoll.setUseController(false);
            styledPlayerViewPoll.setResizeMode(2);
        }
        v player = styledPlayerViewPoll.getPlayer();
        if (player == null) {
            player = new j.b(viewGroup.getContext()).l(mw.b().c()).f();
        }
        styledPlayerViewPoll.setPlayer(player);
        viewGroup.addView(styledPlayerViewPoll, 0, layoutParams);
        player.d(new p.c().j(a(str)).a());
        player.setRepeatMode(i);
        player.prepare();
        player.setPlayWhenReady(z);
        return styledPlayerViewPoll;
    }

    public synchronized void c(StyledPlayerView styledPlayerView) {
        if (styledPlayerView == null) {
            return;
        }
        v player = styledPlayerView.getPlayer();
        if (player != null) {
            player.pause();
        }
        ViewGroup viewGroup = (ViewGroup) styledPlayerView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(styledPlayerView);
        }
        this.b.offer(styledPlayerView);
    }
}
