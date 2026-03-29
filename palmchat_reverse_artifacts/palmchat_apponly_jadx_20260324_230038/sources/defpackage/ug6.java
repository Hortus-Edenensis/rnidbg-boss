package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutVoiceCallPanelBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ug6 extends n0 {
    public LayoutVoiceCallPanelBinding q;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21211a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f21211a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21211a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21211a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21211a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ug6(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable) {
        super(fragmentActivity, activityVideoCallVoipBinding, str, str2, str3, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        n();
    }

    @Override // defpackage.n0
    public void E(VoipState voipState) {
        int i = a.f21211a[voipState.ordinal()];
        if (i == 2) {
            this.f.setText(R$string.calling_wait_accept);
            this.f.setVisibility(0);
            this.q.c.setVisibility(8);
            this.q.n.setVisibility(0);
            this.q.t.setVisibility(0);
            this.q.q.setVisibility(0);
            this.q.o.setText("取消");
        } else if (i == 3) {
            this.f.setVisibility(8);
            this.q.c.setVisibility(8);
            this.q.n.setVisibility(0);
            this.q.t.setVisibility(0);
            this.q.q.setVisibility(0);
            this.q.o.setText("挂断");
        } else if (i == 4) {
            this.f.setText(R$string.called_audio_wait_accept);
            this.f.setVisibility(0);
            this.q.c.setVisibility(0);
            this.q.n.setVisibility(0);
            this.q.t.setVisibility(8);
            this.q.q.setVisibility(8);
            this.q.o.setText("拒绝");
        }
        K();
        J();
    }

    @Override // defpackage.n0
    public void F() {
        super.F();
        this.q.l.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: tg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20983a.w(view);
            }
        }));
    }

    @Override // defpackage.n0
    public void I(boolean z) {
        this.q.l.setVisibility(z ? 0 : 8);
        this.q.i.setVisibility(z ? 0 : 8);
        this.q.j.setVisibility(z ? 0 : 8);
    }

    public final void b() {
        RoomUserInfo roomUserInfoR = r(true);
        if (roomUserInfoR != null) {
            kc2<Drawable> kc2VarLoad = hc2.a(c.b()).load(k86.p(roomUserInfoR.headImg));
            int i = R$drawable.video_call_icon_loading_fail_bg;
            kc2VarLoad.error(i).transform(new gu(14, 3)).into(this.q.h);
            this.q.g.changeShapeType(1);
            this.q.g.setDegreeForRoundRectangle(13, 13);
            hc2.a(c.b()).load(k86.p(roomUserInfoR.headImg)).error(i).into(this.q.g);
            this.q.f.setText(roomUserInfoR.nickName);
        }
    }

    @Override // defpackage.n0
    public void n() {
        if (m()) {
            if (!vg6.w()) {
                vg6.D(this.f19399a);
            } else {
                vg6.t().C(this.k);
                this.f19399a.finish();
            }
        }
    }

    @Override // defpackage.n0
    public void u() {
        this.b.j.inflate();
        LayoutVoiceCallPanelBinding layoutVoiceCallPanelBindingA = LayoutVoiceCallPanelBinding.a(this.b.getRoot().findViewById(R$id.voice_call_panel));
        this.q = layoutVoiceCallPanelBindingA;
        this.e = layoutVoiceCallPanelBindingA.j;
        this.c = layoutVoiceCallPanelBindingA.p;
        this.d = layoutVoiceCallPanelBindingA.r;
        this.g = layoutVoiceCallPanelBindingA.s;
        this.h = layoutVoiceCallPanelBindingA.u;
        this.i = layoutVoiceCallPanelBindingA.b;
        this.j = layoutVoiceCallPanelBindingA.m;
        this.f = layoutVoiceCallPanelBindingA.k;
        F();
        b();
    }
}
