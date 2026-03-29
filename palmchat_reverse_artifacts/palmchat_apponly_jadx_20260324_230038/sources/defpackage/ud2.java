package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutGroupCallPanelBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ud2 extends n0 {
    public LayoutGroupCallPanelBinding q;
    public final HashMap<String, Boolean> r;
    public ArrayList<RoomUserInfo> s;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RcySAdapter<RoomUserInfo, RcyHolder> {
        public b(Context context, int i) {
            super(context, i);
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, RoomUserInfo roomUserInfo, int i) {
            ImageView imageView = (ImageView) rcyHolder.l(R$id.icon);
            kc2<Drawable> kc2VarLoad = hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfo.headImg));
            int i2 = R$drawable.default_portrait;
            kc2VarLoad.placeholder(i2).error(i2).into(imageView);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21194a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f21194a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21194a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21194a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21194a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ud2(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable) {
        super(fragmentActivity, activityVideoCallVoipBinding, str, str2, str3, runnable);
        this.r = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        if (((CallActivity) this.f19399a).V1(true)) {
            this.o.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        if (this.o.e()) {
            return;
        }
        this.o.C();
    }

    @Override // defpackage.n0
    public void C() {
        super.C();
        fg5.c(this);
    }

    @Override // defpackage.n0
    public void E(VoipState voipState) {
        this.q.o.setVisibility(8);
        int i = c.f21194a[voipState.ordinal()];
        if (i == 2) {
            this.f.setText("等待接听");
            this.f.setVisibility(0);
            this.q.c.setVisibility(8);
            this.q.m.setVisibility(0);
            this.q.x.setVisibility(8);
        } else if (i == 3) {
            this.f.setVisibility(8);
            this.q.x.setVisibility(8);
            this.q.c.setVisibility(8);
            this.q.m.setVisibility(0);
            this.q.f.setVisibility(0);
            this.q.y.setVisibility(0);
        } else if (i == 4) {
            this.f.setText(R$string.called_audio_wait_accept);
            this.f.setVisibility(8);
            this.q.c.setVisibility(0);
            this.q.m.setVisibility(0);
            U(this.s);
            this.q.x.setVisibility(8);
            this.q.f.setVisibility(8);
            this.q.y.setVisibility(8);
        }
        K();
        V();
        J();
    }

    @Override // defpackage.n0
    public void F() {
        super.F();
        this.q.d.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: qd2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20231a.w(view);
            }
        }));
        this.q.e.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: rd2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20455a.x(view);
            }
        }));
        this.q.i.setOnClickListener(M(new View.OnClickListener() { // from class: sd2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20718a.y(view);
            }
        }));
        this.q.x.setOnClickListener(M(new View.OnClickListener() { // from class: td2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20962a.z(view);
            }
        }));
    }

    public void R() {
        ArrayList<RoomUserInfo> arrayList = new ArrayList<>();
        for (va6 va6Var : ja6.f().e()) {
            RoomUserInfo roomUserInfo = new RoomUserInfo();
            roomUserInfo.uid = va6Var.b;
            arrayList.add(roomUserInfo);
        }
        ap3.a().c(this.f19399a, arrayList);
    }

    public void S(String str, boolean z) {
        this.r.put(str, Boolean.valueOf(z));
        if (TextUtils.equals(p(), str)) {
            V();
        }
    }

    public void T(ArrayList<RoomUserInfo> arrayList) {
        this.s = arrayList;
    }

    public final void U(ArrayList<RoomUserInfo> arrayList) {
        String str;
        String str2;
        RoomUserInfo roomUserInfo;
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ == null || (roomUserInfo = rh6VarZ.j) == null) {
            str = "name";
            str2 = "url";
        } else {
            str = roomUserInfo.nickName;
            str2 = roomUserInfo.headImg;
        }
        this.q.o.setVisibility(0);
        this.q.q.setText(str);
        kc2<Drawable> kc2VarLoad = hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(str2));
        int i = R$drawable.default_portrait;
        kc2VarLoad.placeholder(i).error(i).into(this.q.n);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (RoomUserInfo roomUserInfo2 : arrayList) {
            String str3 = roomUserInfo2.uid;
            if (str3 != null && !str3.equals(rh6VarZ.j.uid)) {
                arrayList2.add(roomUserInfo2);
            }
        }
        b bVar = new b(this.f19399a, R$layout.layout_roomcall_invite_item);
        this.q.p.setAdapter(bVar);
        this.q.p.setLayoutManager(new LinearLayoutManager(this.f19399a, 0, false));
        bVar.g(arrayList2, true);
    }

    public final void V() {
        Boolean bool = this.r.get(p());
        LayoutGroupCallPanelBinding layoutGroupCallPanelBinding = this.q;
        if (layoutGroupCallPanelBinding != null) {
            layoutGroupCallPanelBinding.i.setImageResource(bool.booleanValue() ? com.zenmen.palmchat.lxvoip.vertc.R$drawable.ic_re_voip_camera_close : com.zenmen.palmchat.lxvoip.vertc.R$drawable.ic_re_voip_camera);
            this.q.k.setText(bool.booleanValue() ? "摄像头已开" : "摄像头已关");
            this.q.x.setVisibility(bool.booleanValue() ? 0 : 8);
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

    @pm5(threadMode = ThreadMode.MAIN)
    public void onAudioPropertiesReportEvent(jk jkVar) {
        LogUtil.i("RTC", "onAudioPropertiesReportEvent" + jkVar.b);
        this.q.y.updateUserSpeakingStatus(jkVar.b, jkVar.c);
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onMediaStatusEvent(vm3 vm3Var) {
        int i = vm3Var.b;
        if (i == 0) {
            this.q.y.updateUserVideoStatus(vm3Var.f21480a, false, vm3Var.c == 1);
        } else if (i == 1) {
            this.q.y.updateUserAudioStatus(vm3Var.f21480a, vm3Var.c == 1);
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onRefreshUserLayoutEvent(yu4 yu4Var) {
        this.q.y.setUserList(yu4Var.f22282a);
    }

    @Override // defpackage.n0
    public void t() {
        super.t();
        dr4 dr4Var = this.o;
        if (dr4Var != null) {
            dr4Var.n();
            this.r.put(p(), Boolean.valueOf(!this.o.e()));
        }
    }

    @Override // defpackage.n0
    public void u() {
        this.b.b.inflate();
        LayoutGroupCallPanelBinding layoutGroupCallPanelBindingA = LayoutGroupCallPanelBinding.a(this.b.getRoot().findViewById(R$id.voice_call_panel));
        this.q = layoutGroupCallPanelBindingA;
        this.e = layoutGroupCallPanelBindingA.g;
        this.c = layoutGroupCallPanelBindingA.r;
        this.d = layoutGroupCallPanelBindingA.t;
        this.g = layoutGroupCallPanelBindingA.u;
        this.h = layoutGroupCallPanelBindingA.w;
        this.i = layoutGroupCallPanelBindingA.b;
        this.j = layoutGroupCallPanelBindingA.l;
        this.f = layoutGroupCallPanelBindingA.h;
        F();
        this.q.y.setOnUserViewClick(new a());
        fg5.b(this);
        if (ja6.f().e().size() == 0) {
            ja6.f().b(va6.a(this.s));
        } else {
            ja6.f().b(ja6.f().e());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ek2<va6> {
        public a() {
        }

        @Override // defpackage.ek2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(va6 va6Var) {
        }
    }

    @Override // defpackage.n0
    public void I(boolean z) {
    }
}
