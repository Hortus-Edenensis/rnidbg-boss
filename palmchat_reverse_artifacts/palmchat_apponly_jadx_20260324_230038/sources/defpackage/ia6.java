package defpackage;

import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Rational;
import android.view.TextureView;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.lxvertc.common.SolutionCommonDialog;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutVideoCallPanelBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ia6 extends n0 {
    public LayoutVideoCallPanelBinding q;
    public TextureView r;
    public TextureView s;
    public mb6 t;
    public final HashMap<String, Boolean> u;
    public String v;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18137a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f18137a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18137a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18137a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18137a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ia6(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable) {
        super(fragmentActivity, activityVideoCallVoipBinding, str, str2, str3, runnable);
        this.u = new HashMap<>(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(SolutionCommonDialog solutionCommonDialog, View view) {
        solutionCommonDialog.dismiss();
        this.f19399a.startActivity(new Intent("android.settings.SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        if (this.o.e()) {
            return;
        }
        this.o.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        W();
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        if (V()) {
            this.o.E();
        }
    }

    @Override // defpackage.n0
    public void E(VoipState voipState) {
        this.q.G.setVisibility(8);
        int i = a.f18137a[voipState.ordinal()];
        if (i == 2) {
            this.f.setText(R$string.calling_wait_accept);
            this.f.setVisibility(0);
            this.q.c.setVisibility(8);
            this.q.n.setVisibility(8);
            this.q.v.setVisibility(8);
            this.q.s.setText("取消");
            this.q.w.setVisibility(0);
            this.q.j.setVisibility(8);
            this.q.e.setVisibility(8);
        } else if (i == 3) {
            this.q.t.setVisibility(8);
            this.q.p.setVisibility(0);
            this.f.setVisibility(8);
            this.q.c.setVisibility(8);
            this.q.n.setVisibility(0);
            this.q.s.setText("挂断");
            this.q.w.setVisibility(8);
            this.q.j.setVisibility(0);
            this.q.e.setVisibility(0);
        } else if (i == 4) {
            this.f.setText(R$string.called_video_wait_accept);
            this.f.setVisibility(0);
            this.q.n.setVisibility(8);
            this.q.s.setText("拒绝");
            this.q.w.setVisibility(0);
            this.q.j.setVisibility(8);
            this.q.e.setVisibility(8);
        }
        K();
        J();
        k0();
        m0();
    }

    @Override // defpackage.n0
    public void F() {
        super.F();
        this.q.u.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: aa6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1185a.w(view);
            }
        }));
        this.q.x.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: ba6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1675a.x(view);
            }
        }));
        this.q.p.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: ca6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1936a.y(view);
            }
        }));
        this.q.m.setOnClickListener(M(new View.OnClickListener() { // from class: da6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17007a.z(view);
            }
        }));
        View.OnClickListener onClickListenerM = M(new View.OnClickListener() { // from class: ea6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17250a.Z(view);
            }
        });
        this.q.G.setOnClickListener(onClickListenerM);
        this.q.G.setOnClickListener(onClickListenerM);
        this.q.J.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: fa6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17492a.a0(view);
            }
        }));
    }

    @Override // defpackage.n0
    public void I(boolean z) {
        this.q.j.setVisibility(z ? 0 : 8);
        this.q.e.setVisibility(z ? 0 : 8);
        this.q.G.setVisibility((z && this.u.get(p()).booleanValue()) ? 0 : 8);
        this.q.p.setVisibility(z ? 0 : 8);
        this.q.k.setVisibility(z ? 0 : 8);
    }

    public final boolean V() {
        if (s()) {
            return true;
        }
        final SolutionCommonDialog solutionCommonDialog = new SolutionCommonDialog(this.f19399a);
        solutionCommonDialog.o(this.f19399a.getString(R$string.camera_permission_hint));
        solutionCommonDialog.setCancelable(false);
        solutionCommonDialog.p(new View.OnClickListener() { // from class: ga6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                solutionCommonDialog.dismiss();
            }
        });
        solutionCommonDialog.q(new View.OnClickListener() { // from class: ha6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17904a.Y(solutionCommonDialog, view);
            }
        });
        solutionCommonDialog.show();
        return false;
    }

    public final void W() {
        TextureView textureView = b0() ? this.s : this.r;
        i0(textureView, p());
        String strQ = q();
        TextureView textureView2 = this.s;
        if (textureView == textureView2) {
            textureView2 = this.r;
        }
        i0(textureView2, strQ);
    }

    public final void b() {
        ArrayList<RoomUserInfo> arrayList;
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ != null && (arrayList = rh6VarZ.i) != null && arrayList.size() > 0 && rh6VarZ.j != null) {
            rh6VarZ.i.get(0);
            RoomUserInfo roomUserInfo = rh6VarZ.j.uid.equals(eg5.c().a()) ? rh6VarZ.i.get(0) : rh6VarZ.j;
            if (roomUserInfo != null) {
                this.q.g.changeShapeType(1);
                this.q.g.setDegreeForRoundRectangle(13, 13);
                hc2.a(c.b()).load(k86.p(roomUserInfo.headImg)).error(R$drawable.video_call_icon_loading_fail_bg).into(this.q.g);
                this.q.f.setText(roomUserInfo.nickName);
            }
        }
        this.q.p.setVisibility(8);
    }

    public final boolean b0() {
        return TextUtils.equals((String) this.r.getTag(R$id.render_view_uid), p());
    }

    public void c0() {
        (b0() ? this.r : this.s).setVisibility(0);
    }

    public void d0(String str, String str2) {
        this.v = str;
        this.u.put(str2, Boolean.TRUE);
        i0(b0() ? this.s : this.r, str2);
        if (this.o != null) {
            m0();
        }
    }

    public void e0() {
        dr4 dr4Var;
        if (s() && (dr4Var = this.o) != null && dr4Var.e()) {
            this.o.E();
        }
    }

    public void f0(boolean z, Configuration configuration) {
        mb6 mb6Var = this.t;
        if (mb6Var != null) {
            mb6Var.e(z, this.v);
        }
    }

    public void g0(String str) {
        this.q.J.setVisibility(0);
        W();
        l0();
    }

    public void h0(String str, boolean z) {
        Object tag;
        this.u.put(str, Boolean.valueOf(z));
        TextureView textureView = this.r;
        if (textureView == null || (tag = textureView.getTag(R$id.render_view_uid)) == null) {
            return;
        }
        i0(TextUtils.equals((String) tag, str) ? this.r : this.s, str);
        if (!TextUtils.equals(p(), str)) {
            if (!z) {
                hg5.d(R$string.remote_user_close_camera);
            }
            m0();
        } else {
            k0();
            if (z) {
                return;
            }
            hg5.d(R$string.local_user_close_camera);
        }
    }

    public final void i0(TextureView textureView, String str) {
        textureView.setTag(R$id.render_view_uid, str);
        boolean z = this.u.get(str) != null && Boolean.TRUE.equals(this.u.get(str));
        if (!z || !TextUtils.equals(p(), str)) {
            textureView.setVisibility(z ? 0 : 8);
        }
        if (TextUtils.equals(p(), str)) {
            this.o.r(textureView);
        } else {
            this.o.s(str, this.v, textureView);
        }
    }

    public void j0(String str) {
        mb6 mb6Var = this.t;
        if (mb6Var != null) {
            mb6Var.i(str);
        }
    }

    public final void k0() {
        Boolean bool = this.u.get(p());
        if (bool != null) {
            this.q.m.setImageResource(bool.booleanValue() ? R$drawable.ic_re_voip_camera_close : R$drawable.ic_re_voip_camera);
            this.q.o.setText(bool.booleanValue() ? "摄像头已开" : "摄像头已关");
            this.q.G.setVisibility((bool.booleanValue() && this.n.r() == VoipState.ONTHECALL) ? 0 : 8);
        }
    }

    public final void l0() {
        boolean zB0 = b0();
        RoomUserInfo roomUserInfoR = r(zB0);
        RoomUserInfo roomUserInfoR2 = r(!zB0);
        if (roomUserInfoR != null) {
            hc2.a(c.b()).load(k86.p(roomUserInfoR.headImg)).error(R$drawable.video_call_icon_loading_fail_bg).transform(new gu(14, 3)).into(this.q.i);
        }
        if (roomUserInfoR2 != null) {
            hc2.a(c.b()).load(k86.p(roomUserInfoR2.headImg)).error(R$drawable.video_call_icon_loading_fail_bg).transform(new gu(14, 3)).into(this.q.h);
        }
    }

    public final void m0() {
        mb6 mb6Var = this.t;
        if (mb6Var == null) {
            return;
        }
        this.t.k(mb6Var.c(), this.v);
    }

    @Override // defpackage.n0
    public void n() {
        if (m()) {
            if (this.t == null) {
                FragmentActivity fragmentActivity = this.f19399a;
                ActivityVideoCallVoipBinding activityVideoCallVoipBinding = this.b;
                LayoutVideoCallPanelBinding layoutVideoCallPanelBinding = this.q;
                this.t = new mb6(fragmentActivity, activityVideoCallVoipBinding, layoutVideoCallPanelBinding.I, layoutVideoCallPanelBinding.K, this.u);
            }
            this.t.a(new Rational(90, 130), q(), this.k);
        }
    }

    @Override // defpackage.n0
    public void t() {
        dr4 dr4Var;
        boolean zS = s();
        if (!zS && (dr4Var = this.o) != null) {
            dr4Var.m(true);
        }
        this.u.put(p(), Boolean.valueOf(zS));
    }

    @Override // defpackage.n0
    public void u() {
        this.b.e.inflate();
        LayoutVideoCallPanelBinding layoutVideoCallPanelBindingA = LayoutVideoCallPanelBinding.a(this.b.getRoot().findViewById(R$id.video_call_panel));
        this.q = layoutVideoCallPanelBindingA;
        this.c = layoutVideoCallPanelBindingA.z;
        this.d = layoutVideoCallPanelBindingA.B;
        this.g = layoutVideoCallPanelBindingA.C;
        this.h = layoutVideoCallPanelBindingA.F;
        this.e = layoutVideoCallPanelBindingA.k;
        this.i = layoutVideoCallPanelBindingA.b;
        this.j = layoutVideoCallPanelBindingA.q;
        TextureView textureView = layoutVideoCallPanelBindingA.I;
        this.r = textureView;
        this.s = layoutVideoCallPanelBindingA.K;
        this.f = layoutVideoCallPanelBindingA.l;
        i0(textureView, p());
        if (!s()) {
            hg5.d(R$string.camera_permission_hint);
        }
        F();
        b();
    }
}
