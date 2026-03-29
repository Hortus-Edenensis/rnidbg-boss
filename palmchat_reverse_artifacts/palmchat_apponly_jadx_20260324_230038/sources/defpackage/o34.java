package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.heytap.msp.push.HeytapPushManager;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.bean.BizpubIsShowNoticeReminderV1Result;
import com.zenmen.palmchat.conversations.threadnotifyguide.ExtraInfo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.SAppUtil;
import defpackage.q05;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f19678a = new Handler(new a());
    public final MainTabsActivity b;
    public boolean c;
    public boolean d;
    public h e;
    public MaterialDialog f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                o34.this.u();
            } else if (i == 2) {
                o34.this.s();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements q05.e<Boolean> {
        public b() {
        }

        @Override // q05.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            o34.this.c = true;
            o34.this.f19678a.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements q05.e<Boolean> {
        public c() {
        }

        @Override // q05.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            o34.this.c = true;
            o34.this.f19678a.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<BizpubIsShowNoticeReminderV1Result>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19682a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ q05.e d;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put(DeviceInfoUtil.UID_TAG, v4.e(o34.this.b));
            }
        }

        public d(String str, HashMap map, boolean z, q05.e eVar) {
            this.f19682a = str;
            this.b = map;
            this.c = z;
            this.d = eVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f19682a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<BizpubIsShowNoticeReminderV1Result> lXBaseNetBean, Exception exc) {
            BizpubIsShowNoticeReminderV1Result bizpubIsShowNoticeReminderV1Result;
            if (q05.o(o34.this.b)) {
                return;
            }
            if (!z || lXBaseNetBean == null || (bizpubIsShowNoticeReminderV1Result = lXBaseNetBean.data) == null || bizpubIsShowNoticeReminderV1Result.showFlag) {
                this.d.a(Boolean.TRUE);
            } else {
                q05.a("notify_show_blacklist", 0, new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put(DeviceInfoUtil.UID_TAG, v4.e(o34.this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            y24.g = false;
            ds0.a().b(new v34());
            zn6.b("pagemsg_middle_popwin-cli02");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            y24.g = false;
            ds0.a().b(new v34());
            zn6.b("pagemsg_middle_popwin-cli01");
            com.zenmen.palmchat.utils.a.E().y0(o34.this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnCancelListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Log.i("NotificationPopGuide", "onCancel: ");
            y24.g = false;
            ds0.a().b(new v34());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends BottomSheetDialog implements View.OnClickListener {
        public h(Context context) {
            super(context, R.style.ServiceAccountBottomDialog);
            View viewInflate = getLayoutInflater().inflate(R.layout.layout_notify_perm_bottom_dialog, (ViewGroup) null);
            setContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            viewInflate.findViewById(R.id.btn_cancel).setOnClickListener(this);
            viewInflate.findViewById(R.id.btn_ok).setOnClickListener(this);
            setCanceledOnTouchOutside(false);
        }

        @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            super.dismiss();
            o34.this.e = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.btn_ok) {
                zn6.b("cpgl_notice_limits_popwin_b02");
                o34.this.l();
            } else {
                zn6.b("cpgl_notice_limits_popwin_b01");
            }
            dismiss();
        }
    }

    public o34(MainTabsActivity mainTabsActivity) {
        this.b = mainTabsActivity;
    }

    public void h(q05.e<Boolean> eVar) {
        zw4.e(new d(q05.c() + "/bizpub.is.show.notice.reminder.v1", new HashMap(), false, eVar));
    }

    public void i() {
        if (this.c) {
            Log.d("NotificationPopGuide", "cancel");
            this.c = false;
            this.f19678a.removeMessages(1);
            this.f19678a.removeMessages(2);
        }
    }

    public final boolean j() {
        return y24.j(true);
    }

    public final boolean k() {
        return SPUtil.f14322a.a(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_dialog_has_show", false);
    }

    public final void l() {
        Log.d("NotificationPopGuide", "jump");
        com.zenmen.palmchat.utils.a.E().y0(this.b);
    }

    public void m() {
        if (this.c || k() || s34.c() == 1) {
            return;
        }
        Log.d("NotificationPopGuide", "newTriggerIfNeed");
        if (SAppUtil.d.b() && vp3.e()) {
            h(new c());
        } else {
            this.c = true;
            this.f19678a.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    public void n(boolean z) {
        Log.d("NotificationPopGuide", "onActivityFocusChanged: " + z);
        if (!z) {
            i();
        } else {
            y24.g = false;
            o();
        }
    }

    public void o() {
        int iC = s34.c();
        if (this.d) {
            Log.d("NotificationPopGuide", "reportOppoSysPop");
            this.d = false;
            if (iC != 0) {
                zn6.b("cpgl_notice_limits_syspopwin_success");
            } else {
                ds0.a().b(new v34());
            }
        }
        HashMap map = new HashMap();
        map.put("channel", py4.b());
        if (iC == 1) {
            map.put("type", "1");
        } else if (iC == 0) {
            map.put("type", "2");
        } else if (iC == -1) {
            map.put("type", "3");
        }
        zn6.i("open_notice_limits", map);
    }

    public final void p() {
        Log.d("NotificationPopGuide", "showBottomDialog");
        y24.k();
        h hVar = new h(this.b);
        this.e = hVar;
        hVar.show();
        q05.a("cpgl_notice_limits_popwin", 0, new e());
    }

    public final void q() {
        Log.d("NotificationPopGuide", "showNewCenterDialog");
        ExtraInfo extraInfoD = y24.d();
        if (extraInfoD == null) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_dialog_has_show", Boolean.TRUE);
        sd3 sd3Var = new sd3(this.b);
        sd3Var.U(extraInfoD.homeDialogTitle);
        sd3Var.o(R.layout.layout_dialog_new_notice_guide, false);
        sd3Var.h(true);
        sd3Var.L("下次再说");
        sd3Var.P("去打开");
        sd3Var.f(new f());
        MaterialDialog materialDialogE = sd3Var.e();
        this.f = materialDialogE;
        ((TextView) materialDialogE.findViewById(R.id.content)).setText(extraInfoD.homeDialogContent);
        this.f.setOnCancelListener(new g());
        this.f.show();
        y24.g = true;
        zn6.b("pagemsg_middle_popwin-show");
    }

    public final boolean r() {
        Log.d("NotificationPopGuide", "showNewOppoSystemDialog");
        if (!py4.d()) {
            return false;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        if (sPUtil.a(scene, "oppo_notify_perm_sys_pop", false)) {
            return false;
        }
        this.d = true;
        y24.g = true;
        HeytapPushManager.requestNotificationPermission();
        Boolean bool = Boolean.TRUE;
        sPUtil.t(scene, "oppo_notify_perm_sys_pop", bool);
        sPUtil.t(scene, "thread_notification_dialog_has_show", bool);
        zn6.b("pagemsg_middle_OPPOpopwin-show");
        return true;
    }

    public final void s() {
        MaterialDialog materialDialog;
        Log.d("NotificationPopGuide", "showNewPop");
        this.c = false;
        if (this.b.isFinishing() || this.b.isDestroyed()) {
            return;
        }
        if (this.d || ((materialDialog = this.f) != null && materialDialog.isShowing())) {
            y24.g = true;
        } else {
            if (r()) {
                return;
            }
            q();
        }
    }

    public final boolean t() {
        Log.d("NotificationPopGuide", "showOppoSystemDialog");
        if (!py4.d()) {
            return false;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        if (sPUtil.a(scene, "oppo_notify_perm_sys_pop", false)) {
            return false;
        }
        this.d = true;
        HeytapPushManager.requestNotificationPermission();
        sPUtil.t(scene, "oppo_notify_perm_sys_pop", Boolean.TRUE);
        y24.k();
        zn6.b("cpgl_notice_limits_syspopwin");
        return true;
    }

    public final void u() {
        Log.d("NotificationPopGuide", "showPop");
        this.c = false;
        if (this.b.isFinishing() || this.b.isDestroyed() || this.d) {
            return;
        }
        h hVar = this.e;
        if ((hVar == null || !hVar.isShowing()) && !t()) {
            p();
        }
    }

    public void v() {
        if (this.c || !j()) {
            return;
        }
        Log.d("NotificationPopGuide", "triggerIfNeed");
        if (SAppUtil.d.b() && vp3.e()) {
            h(new b());
        } else {
            this.c = true;
            this.f19678a.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
