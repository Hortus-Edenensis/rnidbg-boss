package com.volcengine.lxvertc.videocall.call.view;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.ss.bytertc.engine.data.AudioRoute;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ap3;
import defpackage.az2;
import defpackage.bd6;
import defpackage.eg5;
import defpackage.ex;
import defpackage.hg5;
import defpackage.hh6;
import defpackage.i86;
import defpackage.ia6;
import defpackage.n0;
import defpackage.rh6;
import defpackage.sx;
import defpackage.ti6;
import defpackage.ud2;
import defpackage.ug6;
import defpackage.vg6;
import defpackage.y02;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CallActivity extends FrameworkBaseActivity {
    public static WeakReference<CallActivity> G;
    public final ti6 A;
    public boolean B;
    public final ex C;
    public final BroadcastReceiver E;
    public Runnable F;
    public ActivityVideoCallVoipBinding q;
    public n0 r;
    public CallType s;
    public String t;
    public ArrayList<RoomUserInfo> u;
    public String v;
    public boolean w;
    public com.volcengine.lxvertc.videocall.call.a x;
    public boolean y = false;
    public final ti6.a z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ex {
        public a() {
        }

        @Override // defpackage.ex
        public void a(String str, String str2) {
            if (CallActivity.this.r instanceof ia6) {
                ((ia6) CallActivity.this.r).d0(str, str2);
            } else if (CallActivity.this.r instanceof bd6) {
                ((bd6) CallActivity.this.r).B0(str, str2);
            }
        }

        @Override // defpackage.ex
        public void b(String str) {
            if (CallActivity.this.r instanceof ia6) {
                ((ia6) CallActivity.this.r).g0(str);
            } else if (CallActivity.this.r instanceof bd6) {
                ((bd6) CallActivity.this.r).F0(str);
            }
        }

        @Override // defpackage.ex
        public void c(AudioRoute audioRoute) {
            if (CallActivity.this.r != null) {
                CallActivity.this.r.J();
            }
        }

        @Override // defpackage.ex
        public void d(String str, boolean z) {
            LogUtil.i("RTC", "onUserToggleCamera" + str);
            if (CallActivity.this.r instanceof ia6) {
                ((ia6) CallActivity.this.r).h0(str, z);
            } else if (CallActivity.this.r instanceof ud2) {
                ((ud2) CallActivity.this.r).S(str, z);
            } else if (CallActivity.this.r instanceof bd6) {
                ((bd6) CallActivity.this.r).G0(str, z);
            }
        }

        @Override // defpackage.ex
        public void e(int i) {
            String strB = i86.b(i);
            if (CallActivity.this.r.o() != null) {
                CallActivity.this.r.o().setText(strB);
            }
            if (CallActivity.this.r instanceof ia6) {
                ((ia6) CallActivity.this.r).j0(strB);
            }
            if (CallActivity.this.r instanceof hh6) {
                ((hh6) CallActivity.this.r).r0(i);
            }
            if (CallActivity.this.r instanceof bd6) {
                ((bd6) CallActivity.this.r).I0(i);
            }
        }

        @Override // defpackage.ex
        public void f(HashMap<String, Boolean> map) {
            if (CallActivity.this.r != null) {
                CallActivity.this.r.L(map);
            }
        }

        @Override // gy.b
        public void g(VoipState voipState, VoipState voipState2, rh6 rh6Var) {
            if (voipState2 == VoipState.ONTHECALL) {
                hg5.d(R$string.on_the_call);
            }
            CallActivity.this.R1();
        }

        @Override // defpackage.ex
        public void h(String str, boolean z) {
            if (!TextUtils.equals(eg5.c().a(), str)) {
                if (z || !TextUtils.isEmpty(CallActivity.this.v)) {
                    return;
                }
                hg5.d(R$string.remote_user_close_mic);
                return;
            }
            CallActivity.this.r.K();
            VoipState voipStateR = CallActivity.this.x.r();
            if (z || voipStateR == VoipState.IDLE) {
                return;
            }
            hg5.d(R$string.local_user_close_mic);
        }

        @Override // defpackage.ex
        public void i() {
            if (CallActivity.this.r instanceof ia6) {
                ((ia6) CallActivity.this.r).c0();
            } else if (CallActivity.this.r instanceof bd6) {
                ((bd6) CallActivity.this.r).A0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS") && CallActivity.this.x.r() == VoipState.ONTHECALL && !CallActivity.this.x.I() && CallActivity.this.r != null) {
                CallActivity.this.r.n();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11327a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f11327a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11327a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11327a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11327a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CallActivity() {
        ti6.a aVar = new ti6.a() { // from class: tw
            @Override // ti6.a
            public final void a(Message message) {
                message.what;
            }
        };
        this.z = aVar;
        this.A = new ti6(aVar);
        this.B = false;
        this.C = new a();
        this.E = new b();
        this.F = new Runnable() { // from class: uw
            @Override // java.lang.Runnable
            public final void run() {
                this.f21304a.Q1();
            }
        };
    }

    public static Intent H1(Context context, CallType callType) {
        return new Intent(context, (Class<?>) (callType == CallType.VIDEO ? VideoCallActivity.class : CallActivity.class));
    }

    public static Intent I1() {
        Intent intent = new Intent();
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        LogUtil.i("RTC", "buildNotificationIntent" + az2.c(rh6VarZ));
        if (rh6VarZ == null) {
            return intent;
        }
        Intent intentH1 = H1(com.zenmen.palmchat.c.b(), CallType.formValue(rh6VarZ.b));
        intentH1.putExtra("call_type", rh6VarZ.b);
        intentH1.putExtra("caller_uid", rh6VarZ.j.uid);
        intentH1.putParcelableArrayListExtra("callee_uid", rh6VarZ.i);
        intentH1.putExtra("remote_user_name", "name");
        intentH1.putExtra("call_groupid", rh6VarZ.h);
        intentH1.addFlags(268435456);
        return intentH1;
    }

    public static CallActivity J1() {
        WeakReference<CallActivity> weakReference = G;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(View view) {
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1() {
        this.A.removeMessages(10002);
        this.A.sendEmptyMessageDelayed(10002, 5000L);
    }

    public static void S1(Activity activity, CallType callType, String str, String str2, ArrayList<RoomUserInfo> arrayList, String str3) {
        if (arrayList == null || arrayList.size() <= 0 || activity == null) {
            return;
        }
        Intent intentH1 = H1(activity, callType);
        intentH1.putExtra("call_type", callType.getValue());
        intentH1.putExtra("caller_uid", str);
        intentH1.putExtra("callee_uid", arrayList);
        intentH1.putExtra("remote_user_name", str3);
        intentH1.putExtra("call_groupid", str2);
        activity.startActivity(intentH1);
    }

    public static void T1(Activity activity, CallType callType, String str, String str2, ArrayList<RoomUserInfo> arrayList, String str3, String str4) {
        if (arrayList == null || arrayList.size() <= 0 || activity == null) {
            return;
        }
        Intent intentH1 = H1(activity, callType);
        intentH1.putExtra("call_type", callType.getValue());
        intentH1.putExtra("caller_uid", str);
        intentH1.putExtra("callee_uid", arrayList);
        intentH1.putExtra("remote_user_name", str3);
        intentH1.putExtra("call_groupid", str2);
        intentH1.putExtra("switch_roominfo", str4);
        activity.startActivity(intentH1);
    }

    public static void U1(CallType callType, String str, String str2, ArrayList<RoomUserInfo> arrayList, String str3) {
        Application applicationB;
        LogUtil.i("RTC", "start " + az2.c(arrayList));
        if (arrayList == null || arrayList.size() <= 0 || (applicationB = com.zenmen.palmchat.c.b()) == null) {
            return;
        }
        Intent intentH1 = H1(applicationB, callType);
        intentH1.putExtra("call_type", callType.getValue());
        intentH1.putExtra("caller_uid", str);
        intentH1.putExtra("callee_uid", arrayList);
        intentH1.putExtra("remote_user_name", str3);
        intentH1.putExtra("call_groupid", str2);
        intentH1.addFlags(268435456);
        applicationB.startActivity(intentH1);
    }

    public final void K1() {
        this.x.A(null);
    }

    public final void L1() {
        rh6 rh6VarZ;
        Intent intent = getIntent();
        this.s = CallType.formValue(intent.getIntExtra("call_type", 0));
        String stringExtra = intent.getStringExtra("caller_uid");
        this.u = intent.getParcelableArrayListExtra("callee_uid");
        this.t = intent.getStringExtra("remote_user_name");
        this.v = intent.getStringExtra("call_groupid");
        VoiceMatchInfo voiceMatchInfo = (VoiceMatchInfo) az2.a(intent.getStringExtra("switch_roominfo"), VoiceMatchInfo.class);
        if (this.u == null && (rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z()) != null) {
            this.u = rh6VarZ.i;
            this.s = rh6VarZ.a();
            stringExtra = rh6VarZ.j.uid;
            this.t = "name";
            this.v = rh6VarZ.h;
        }
        String str = stringExtra;
        ArrayList<RoomUserInfo> arrayList = this.u;
        String str2 = (arrayList == null || arrayList.size() <= 0) ? null : this.u.get(0).uid;
        com.volcengine.lxvertc.videocall.call.a aVarT = com.volcengine.lxvertc.videocall.call.a.t();
        this.x = aVarT;
        aVarT.o(this.C);
        if (N1()) {
            if (this.s == CallType.VIDEO) {
                this.r = new bd6(this, this.q, this.t, str, str2, this.F, voiceMatchInfo);
            } else {
                this.r = new hh6(this, this.q, this.t, str, str2, this.F);
            }
        } else if (TextUtils.isEmpty(this.v)) {
            this.r = this.s == CallType.VIDEO ? new ia6(this, this.q, this.t, str, str2, this.F) : new ug6(this, this.q, this.t, str, str2, this.F);
        } else {
            ud2 ud2Var = new ud2(this, this.q, this.t, str, str2, this.F);
            ud2Var.T(this.u);
            this.r = ud2Var;
        }
        this.r.t();
        getApplication().registerReceiver(this.E, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public final void M1() {
        getWindow().addFlags(8192);
        this.r.u();
        this.q.getRoot().setOnClickListener(new View.OnClickListener() { // from class: vw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21540a.O1(view);
            }
        });
        this.y = true;
    }

    public final boolean N1() {
        return ap3.a().T().t();
    }

    public final void R1() {
        VoipState voipStateR = this.x.r();
        LogUtil.i("CallActivity", "refreshUi" + voipStateR);
        if (voipStateR == null) {
            finish();
            return;
        }
        int i = c.f11327a[voipStateR.ordinal()];
        if (i != 1) {
            if (i == 3) {
                this.A.sendEmptyMessageDelayed(10002, 1000L);
            }
        } else if (!N1()) {
            finish();
        }
        n0 n0Var = this.r;
        if (n0Var != null) {
            if (this.y) {
                n0Var.E(voipStateR);
                return;
            }
            LogUtil.i("CallActivity", "refreshUi fail ,view hasInitView = " + this.y);
        }
    }

    public boolean V1(boolean z) {
        return (this.s == CallType.VIDEO || z) ? BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_CALL) : BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL);
    }

    public final void W1() {
        if (this.x.r() != VoipState.ONTHECALL) {
            return;
        }
        this.A.removeMessages(10002);
        boolean z = this.w;
        n0 n0Var = this.r;
        if (n0Var != null) {
            n0Var.I(z);
            this.w = !z;
        }
        if (z) {
            this.A.sendEmptyMessageDelayed(10002, 5000L);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.x.r() == VoipState.IDLE) {
            super.onBackPressed();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        G = new WeakReference<>(this);
        ActivityVideoCallVoipBinding activityVideoCallVoipBindingC = ActivityVideoCallVoipBinding.c(LayoutInflater.from(this));
        this.q = activityVideoCallVoipBindingC;
        setContentView(activityVideoCallVoipBindingC.getRoot());
        L1();
        if (this.x.r() != null) {
            M1();
            R1();
            V1(false);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(), getPackageName() + ".MainTabsActivity"));
        startActivity(intent);
        finish();
        y02.a();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.r.C();
        this.x.P(this.C);
        getApplication().unregisterReceiver(this.E);
        if (sx.a(null) || this.x.I() || this.x.r() == null || this.x.r() != VoipState.IDLE || this.B || ap3.a().T().d()) {
            return;
        }
        this.x.p();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        n0 n0Var = this.r;
        if (n0Var instanceof ia6) {
            ((ia6) n0Var).e0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        if (getLifecycle().getState() == Lifecycle.State.CREATED) {
            K1();
            return;
        }
        n0 n0Var = this.r;
        if (n0Var instanceof ia6) {
            if (z) {
                W1();
            }
            ((ia6) this.r).f0(z, configuration);
        } else if (n0Var instanceof bd6) {
            if (z) {
                W1();
            }
            ((bd6) this.r).C0(z, configuration);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.volcengine.lxvertc.videocall.call.a.t().I()) {
            vg6.t().x();
        }
    }
}
