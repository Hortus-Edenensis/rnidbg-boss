package com.zenmen.palmchat.paidservices.voicematch;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.LayoutActivityVoiceMatchBinding;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.paidservices.voicematch.VMPrivacyDialog;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ad1;
import defpackage.ds0;
import defpackage.i53;
import defpackage.ld3;
import defpackage.lh6;
import defpackage.me1;
import defpackage.mh6;
import defpackage.n53;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sg6;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.u93;
import defpackage.z53;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VoiceMatchActivity extends BaseActionBarActivity {
    public static String B = "EXTRA_FROM_PROP_TYPE";
    public static String C = "EXTRA_FROM";
    public static String E = "EXTRA_MATCH_TYPE_VIDEO";
    public LayoutActivityVoiceMatchBinding q;
    public com.zenmen.palmchat.paidservices.voicematch.a w;
    public VoiceMatchType r = VoiceMatchType.NORMAL;
    public int s = 0;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    public boolean x = false;
    public mh6 y = new f();
    public boolean z = false;
    public boolean A = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14888a;

        public a(boolean z) {
            this.f14888a = z;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (VoiceMatchActivity.this.z || !this.f14888a) {
                return;
            }
            lh6.V().C0(VoiceMatchType.NORMAL);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14889a;

        public b(MaterialDialog materialDialog) {
            this.f14889a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lh6.V().onEvent("audioMatch_back_popup_wait");
            this.f14889a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14890a;
        public final /* synthetic */ boolean b;

        public c(MaterialDialog materialDialog, boolean z) {
            this.f14890a = materialDialog;
            this.b = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14890a.cancel();
            if (lh6.V().b0() != VoiceMatchState.CHAT) {
                lh6.V().H0();
                sy5.h(AppContext.getContext(), this.b ? "语音速配已取消" : "视频匹配已取消", 1);
            }
            VoiceMatchActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VoiceMatchActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VoiceMatchActivity.this.Q1(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements mh6 {
        public f() {
        }

        @Override // defpackage.mh6
        public void a(VoiceMatchState voiceMatchState) {
            if (VoiceMatchActivity.this.w != null) {
                VoiceMatchActivity.this.w.r(voiceMatchState);
            }
        }

        @Override // defpackage.mh6
        public void b() {
            VoiceMatchActivity.this.v = false;
            BaseActivityPermissionDispatcher.b(VoiceMatchActivity.this, BaseActivityPermissionDispatcher.PermissionType.VOICE_MATCH_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.VOICE_MATCH_LOCATION);
        }

        @Override // defpackage.mh6
        public void c(VoiceMatchType voiceMatchType) {
            LogUtil.i("VoiceMatchActivity", "onReceiveCard" + voiceMatchType + " isPause=" + VoiceMatchActivity.this.isPaused() + " state=" + lh6.V().b0());
            if (VoiceMatchActivity.this.isPaused()) {
                VoiceMatchActivity.this.r = voiceMatchType;
            } else {
                lh6.V().D0(voiceMatchType, 2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14894a;

        public g(MaterialDialog materialDialog) {
            this.f14894a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14894a.dismiss();
            VoiceMatchActivity.this.jump2Setting();
            VoiceMatchActivity.this.v = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14895a;

        public h(MaterialDialog materialDialog) {
            this.f14895a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14895a.dismiss();
            VoiceMatchActivity.this.v = true;
            VoiceMatchActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements DialogInterface.OnCancelListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            VoiceMatchActivity.this.v = true;
            VoiceMatchActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ad1.h().m(ad1.r, VoiceMatchActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ld3 f14899a;

        public l(ld3 ld3Var) {
            this.f14899a = ld3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            VoiceMatchActivity.this.w.j(this.f14899a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements VMPrivacyDialog.f {
        public m() {
        }

        @Override // com.zenmen.palmchat.paidservices.voicematch.VMPrivacyDialog.f
        public void onCheck(boolean z) {
            if (!z) {
                VoiceMatchActivity.this.finish();
                return;
            }
            VoiceMatchActivity.this.M1();
            if (VoiceMatchActivity.this.t) {
                return;
            }
            BaseActivityPermissionDispatcher.b(VoiceMatchActivity.this, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14901a;
        public final /* synthetic */ boolean b;

        public n(MaterialDialog materialDialog, boolean z) {
            this.f14901a = materialDialog;
            this.b = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VoiceMatchActivity.this.z = true;
            this.f14901a.cancel();
            if (this.b && lh6.V().h0()) {
                lh6.V().C0(VoiceMatchType.NORMAL);
            }
        }
    }

    public boolean J1() {
        boolean zK1 = K1();
        if (!zK1) {
            P1();
        }
        return !zK1;
    }

    public final boolean K1() {
        return SPUtil.f14322a.c(SPUtil.SCENE.APP_COMMON, "key_voice_match_privacy_check", false);
    }

    public final void L1() {
        boolean booleanExtra;
        int i2;
        int intExtra = getIntent().getIntExtra(B, VoiceMatchType.NORMAL.type);
        if (getIntent().hasExtra(B)) {
            this.x = true;
        }
        this.r = VoiceMatchType.buildFromType(intExtra);
        this.s = getIntent().getIntExtra(C, 0);
        if (getIntent().hasExtra(E)) {
            booleanExtra = getIntent().getBooleanExtra(E, false);
            i2 = 0;
        } else {
            booleanExtra = !SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_voice_match_last_select_voice", true);
            i2 = 2;
        }
        this.t = booleanExtra && lh6.f0();
        lh6.V().x0(this.s);
        lh6.V().A0(i2);
    }

    public final void M1() {
        SPUtil.f14322a.v(SPUtil.SCENE.APP_COMMON, "key_voice_match_privacy_check", Boolean.TRUE);
    }

    public final void N1() {
        lh6.V().onEvent("audioMatch_back_popup");
        MaterialDialog materialDialogE = new sd3(this).h(true).v(true).c(0).o(R.layout.layout_dialog_voice_match_cancel, false).e();
        boolean z = lh6.V().x().isVoiceMatch;
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            ((TextView) viewJ.findViewById(R.id.content)).setText(z ? "要放弃语音速配吗？" : "要放弃视频匹配吗？");
            TextView textView = (TextView) viewJ.findViewById(R.id.confirm);
            textView.setText("再等等");
            textView.setOnClickListener(new b(materialDialogE));
            TextView textView2 = (TextView) viewJ.findViewById(R.id.cancel);
            textView2.setText("放弃匹配");
            textView2.setOnClickListener(new c(materialDialogE, z));
        }
        materialDialogE.c(false);
        materialDialogE.show();
    }

    public final void O1() {
        View viewInflate = View.inflate(this, R.layout.dialog_square_location_permission, null);
        MaterialDialog materialDialogE = new sd3(this).p(viewInflate, false).h(true).e();
        View viewFindViewById = viewInflate.findViewById(R.id.action);
        View viewFindViewById2 = viewInflate.findViewById(R.id.close);
        viewFindViewById.setOnClickListener(new g(materialDialogE));
        viewFindViewById2.setOnClickListener(new h(materialDialogE));
        materialDialogE.setOnCancelListener(new i());
        materialDialogE.show();
    }

    public final void P1() {
        VMPrivacyDialog.D(this, new m());
    }

    public void Q1(boolean z) {
        this.z = false;
        MaterialDialog materialDialogE = new sd3(this).h(true).v(true).c(0).o(lh6.V().x().isVoiceMatch ? R.layout.layout_dialog_voice_match_rule : R.layout.layout_dialog_voice_match_rule_video, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            TextView textView = (TextView) viewJ.findViewById(R.id.content);
            String str = lh6.V().i().rule;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            ((TextView) viewJ.findViewById(R.id.confirm)).setOnClickListener(new n(materialDialogE, z));
        }
        materialDialogE.c(false);
        materialDialogE.setOnDismissListener(new a(z));
        materialDialogE.show();
    }

    public void R1() {
        new sg6().h(this);
    }

    public final void S1() {
        if (K1() && !this.u && this.v) {
            this.u = true;
            VoiceMatchType voiceMatchType = this.r;
            VoiceMatchType voiceMatchType2 = VoiceMatchType.NORMAL;
            lh6.V().D0(this.r, voiceMatchType != voiceMatchType2 ? 2 : 0);
            this.r = voiceMatchType2;
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (lh6.V().e0()) {
            N1();
            return;
        }
        if (lh6.V().b0() != VoiceMatchState.CHAT) {
            lh6.V().H0();
        }
        super.finish();
    }

    public final void initActionBar() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.m.getLayoutParams();
        layoutParams.setMargins(0, me1.h(this), 0, 0);
        this.q.m.setLayoutParams(layoutParams);
        this.q.f13902a.setOnClickListener(new d());
        this.q.g.setOnClickListener(new e());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = LayoutActivityVoiceMatchBinding.b(LayoutInflater.from(this));
        L1();
        setContentView(this.q.getRoot());
        initActionBar();
        com.zenmen.palmchat.paidservices.voicematch.a aVar = new com.zenmen.palmchat.paidservices.voicematch.a(this, this.q);
        this.w = aVar;
        aVar.h(this.t);
        lh6.V().v0(this.y);
        boolean zJ1 = J1();
        if (!this.t && !zJ1) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH);
        }
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.w.i();
        lh6.V().J0(this.y);
        ds0.a().d(this);
        super.onDestroy();
    }

    @qm5
    public void onMatchLevelEvent(ld3 ld3Var) {
        u93.b(400, new l(ld3Var));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (lh6.V().e0()) {
            this.x = true;
            lh6.V().G0(201);
        }
        this.u = false;
        this.w.k();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        z53.b("tang", "onPermissionDenied");
        super.onPermissionDenied(permissionType, permissionUsage);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        z53.b("tang", "onPermissionGrant");
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH) {
            S1();
        } else if (permissionUsage != BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO && permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.VOICE_MATCH_LOCATION) {
            showBaseProgressBar("定位中", false, false);
            com.zenmen.palmchat.location.d.g().k(LocationScene.VOICE_MATCH_CITY, new j());
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (lh6.V().x().isVoiceMatch) {
            if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL.permissionList)) {
                if (lh6.V().b0() == VoiceMatchState.IDEL) {
                    S1();
                } else if (lh6.V().b0() == VoiceMatchState.ERROR && this.r != VoiceMatchType.NORMAL) {
                    S1();
                }
            }
        } else if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL.permissionList) && this.x) {
            this.x = false;
            if (lh6.V().b0() == VoiceMatchState.IDEL) {
                S1();
            }
        }
        u93.b(1000, new k());
        this.w.l();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showPermissionDenyDialog(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.VOICE_MATCH_LOCATION) {
            O1();
        } else {
            super.showPermissionDenyDialog(permissionType, permissionUsage);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements i53 {
        public j() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            VoiceMatchActivity.this.v = true;
            VoiceMatchActivity.this.hideBaseProgressBar();
            if (i != 0 || locationEx == null) {
                lh6.V().k0();
            } else {
                lh6.V().C0(VoiceMatchType.SAME_CITY);
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
