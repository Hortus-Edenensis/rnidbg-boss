package defpackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.ss.bytertc.engine.data.AudioRoute;
import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.lxvoip.vertc.R$color;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import defpackage.jy;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f19399a;
    public final ActivityVideoCallVoipBinding b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public String k;
    public String l;
    public String m;
    public a n;
    public dr4 o;
    public Runnable p;

    public n0(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable) {
        this.f19399a = fragmentActivity;
        this.b = activityVideoCallVoipBinding;
        this.k = str;
        this.l = str2;
        this.m = str3;
        a aVarT = a.t();
        this.n = aVarT;
        this.o = aVarT.w();
        this.p = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View.OnClickListener onClickListener, View view) {
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(jy.a aVar) {
        if (aVar.b) {
            return;
        }
        hg5.g((String) aVar.f18531a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        this.o.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        if (this.o.d() == AudioRoute.AUDIO_ROUTE_SPEAKERPHONE) {
            ry5.a("声音已切换为\"听筒\"");
        } else {
            ry5.a("声音已切换为\"扬声器\"");
        }
        this.o.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        D();
    }

    public void B() {
        if (l() && ((CallActivity) this.f19399a).V1(false)) {
            this.n.n(new jy() { // from class: i0
                @Override // defpackage.jy
                public final void a(jy.a aVar) {
                    n0.v(aVar);
                }
            });
        }
    }

    public void D() {
        this.n.A(null);
    }

    public abstract void E(VoipState voipState);

    public void F() {
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setOnClickListener(M(new View.OnClickListener() { // from class: j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18295a.w(view);
                }
            }));
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setOnClickListener(M(new View.OnClickListener() { // from class: k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18540a.x(view);
                }
            }));
        }
        this.i.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18868a.y(view);
            }
        }));
        this.j.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19112a.z(view);
            }
        }));
    }

    public void G(boolean z, ImageView imageView) {
        if (z) {
            imageView.clearColorFilter();
        } else {
            imageView.setColorFilter(-7829368);
        }
    }

    public void H(boolean z, TextView textView) {
        textView.setTextColor(ContextCompat.getColor(this.f19399a, z ? R$color.white : R$color.gray_86909C));
    }

    public abstract void I(boolean z);

    public void J() {
        AudioRoute audioRouteD = this.o.d();
        boolean z = audioRouteD == AudioRoute.AUDIO_ROUTE_EARPIECE || audioRouteD == AudioRoute.AUDIO_ROUTE_SPEAKERPHONE;
        ImageView imageView = this.g;
        if (imageView == null) {
            return;
        }
        G(z, imageView);
        H(z, this.h);
        if (!z) {
            this.g.setEnabled(false);
            return;
        }
        this.g.setEnabled(true);
        TextView textView = this.h;
        AudioRoute audioRoute = AudioRoute.AUDIO_ROUTE_SPEAKERPHONE;
        textView.setText(audioRouteD == audioRoute ? "扬声器已开" : "扬声器已关");
        this.g.setImageResource(audioRouteD == audioRoute ? R$drawable.ic_re_voip_speaker_enable : R$drawable.ic_re_voip_speaker);
    }

    public void K() {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(this.o.f() ? R$drawable.ic_re_voip_silence_enable : R$drawable.ic_re_voip_silence);
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.o.f() ? "麦克风已关" : "麦克风已开");
        }
    }

    public void L(HashMap<String, Boolean> map) {
        if (map == null || map.size() == 0 || this.n.r() != VoipState.ONTHECALL || this.n.z() == null || !TextUtils.isEmpty(this.n.z().h)) {
            return;
        }
        Boolean bool = map.get(p());
        Boolean bool2 = map.get(q());
        TextView textView = this.f;
        Boolean bool3 = Boolean.TRUE;
        textView.setVisibility((bool3.equals(bool) || bool3.equals(bool2)) ? 0 : 8);
        if (bool3.equals(bool)) {
            this.f.setText(R$string.local_network_bad);
        } else if (bool3.equals(bool2)) {
            this.f.setText(R$string.remote_network_bad);
        }
    }

    public View.OnClickListener M(final View.OnClickListener onClickListener) {
        return lv0.a(new View.OnClickListener() { // from class: h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17842a.A(onClickListener, view);
            }
        });
    }

    public final boolean l() {
        if (hx3.m(fh.a())) {
            return true;
        }
        hg5.d(R$string.network_link_down);
        return false;
    }

    public boolean m() {
        boolean zA = mk4.a();
        if (!zA) {
            hg5.g(i86.c(R$string.pop_background_permission, new String[0]));
        }
        return zA;
    }

    public abstract void n();

    public TextView o() {
        return this.e;
    }

    public String p() {
        return eg5.c().a();
    }

    public String q() {
        return TextUtils.equals(eg5.c().a(), this.l) ? this.m : this.l;
    }

    public RoomUserInfo r(boolean z) {
        ArrayList<RoomUserInfo> arrayList;
        RoomUserInfo roomUserInfo;
        rh6 rh6VarZ = a.t().z();
        if (rh6VarZ == null || (arrayList = rh6VarZ.i) == null || arrayList.size() <= 0 || (roomUserInfo = rh6VarZ.j) == null) {
            return null;
        }
        return roomUserInfo.uid.equals(eg5.c().a()) ? z ? rh6VarZ.i.get(0) : rh6VarZ.j : !z ? rh6VarZ.i.get(0) : rh6VarZ.j;
    }

    public boolean s() {
        return ContextCompat.checkSelfPermission(fh.a(), "android.permission.CAMERA") == 0;
    }

    public abstract void u();

    public void C() {
    }

    public void t() {
    }
}
