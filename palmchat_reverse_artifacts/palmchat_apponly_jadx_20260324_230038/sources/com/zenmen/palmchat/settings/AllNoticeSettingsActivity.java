package com.zenmen.palmchat.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.ActivityAllNoticeSettingsBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.settings.AllNoticeSettingsActivity;
import com.zenmen.palmchat.utils.SetpageNotificationConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.b05;
import defpackage.q05;
import defpackage.sd3;
import defpackage.t34;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AllNoticeSettingsActivity extends BaseActionBarActivity {
    public ActivityAllNoticeSettingsBinding q;
    public boolean r = false;
    public boolean s = false;
    public int t = 0;
    public SetpageNotificationConfig.MsgShowSwitch u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AllNoticeSettingsActivity.this.r = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            AllNoticeSettingsActivity.this.r = false;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            AllNoticeSettingsActivity.this.r = false;
            com.zenmen.palmchat.utils.a.E().y0(AllNoticeSettingsActivity.this);
            LogUtil.onNotifyClickEvent("4319", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f15120a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public c(CheckBox checkBox, int i, String str) {
            this.f15120a = checkBox;
            this.b = i;
            this.c = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (AllNoticeSettingsActivity.this.s) {
                return;
            }
            if (z && !com.zenmen.palmchat.utils.a.E().N()) {
                this.f15120a.setChecked(false);
                AllNoticeSettingsActivity.this.M1();
                return;
            }
            AllNoticeSettingsActivity allNoticeSettingsActivity = AllNoticeSettingsActivity.this;
            allNoticeSettingsActivity.t = t34.g(allNoticeSettingsActivity.t, z, this.b);
            AllNoticeSettingsActivity allNoticeSettingsActivity2 = AllNoticeSettingsActivity.this;
            allNoticeSettingsActivity2.Y1(allNoticeSettingsActivity2.t);
            AllNoticeSettingsActivity allNoticeSettingsActivity3 = AllNoticeSettingsActivity.this;
            allNoticeSettingsActivity3.c2(allNoticeSettingsActivity3.t, this.c, z);
        }
    }

    public static void N1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) AllNoticeSettingsActivity.class));
    }

    public static boolean Q1() {
        SetpageNotificationConfig setpageNotificationConfig = SetpageNotificationConfig.getSetpageNotificationConfig();
        if (setpageNotificationConfig == null || setpageNotificationConfig.getMsgShowSwitch() == null) {
            return false;
        }
        SetpageNotificationConfig.MsgShowSwitch msgShowSwitch = setpageNotificationConfig.getMsgShowSwitch();
        return WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getChatFriend()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getChatStranger()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getChatMuc()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getOfficial()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getInteractionFriend()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getInteractionLike()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getInteractionComment()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getSubscribe()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getOtherNearby()) && WkInteractiveManager.TimingTypeOff.equals(msgShowSwitch.getOtherOperation());
    }

    public static /* synthetic */ Object R1(boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append("聊天通知分组UI: 好友打招呼=");
        sb.append(z ? "显示" : "隐藏");
        sb.append(", 陌生人打招呼=");
        sb.append(z2 ? "显示" : "隐藏");
        sb.append(", 群聊=");
        sb.append(z3 ? "显示" : "隐藏");
        sb.append(", 分组标题=");
        sb.append(z4 ? "显示" : "隐藏");
        return sb.toString();
    }

    public static /* synthetic */ Object S1(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("官方通知分组UI: 官方公告=");
        sb.append(z ? "显示" : "隐藏");
        return sb.toString();
    }

    public static /* synthetic */ Object T1(boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append("互动通知分组UI: 好友申请=");
        sb.append(z ? "显示" : "隐藏");
        sb.append(", 动态点赞=");
        sb.append(z2 ? "显示" : "隐藏");
        sb.append(", 动态评论=");
        sb.append(z3 ? "显示" : "隐藏");
        sb.append(", 分组标题=");
        sb.append(z4 ? "显示" : "隐藏");
        return sb.toString();
    }

    public static /* synthetic */ Object U1(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("订阅通知分组UI: 特别关注=");
        sb.append(z ? "显示" : "隐藏");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object V1() {
        return "加载消息类型配置成功: chat_friend=" + this.u.getChatFriend() + ", chat_stranger=" + this.u.getChatStranger() + ", chat_muc=" + this.u.getChatMuc() + ", official=" + this.u.getOfficial() + ", interaction_friend=" + this.u.getInteractionFriend() + ", interaction_like=" + this.u.getInteractionLike() + ", interaction_comment=" + this.u.getInteractionComment() + ", subscribe=" + this.u.getSubscribe() + ", other_nearby=" + this.u.getOtherNearby() + ", other_operation=" + this.u.getOtherOperation();
    }

    public static /* synthetic */ Object W1() {
        return "配置为空，使用默认消息类型配置";
    }

    public final void L1() {
        if (this.u == null) {
            this.u = new SetpageNotificationConfig.MsgShowSwitch();
        }
        final boolean zEquals = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getChatFriend());
        final boolean zEquals2 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getChatStranger());
        final boolean zEquals3 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getChatMuc());
        this.q.i.setVisibility(zEquals ? 0 : 8);
        this.q.G.setVisibility(zEquals2 ? 0 : 8);
        this.q.m.setVisibility(zEquals3 ? 0 : 8);
        boolean z = true;
        final boolean z2 = zEquals || zEquals2 || zEquals3;
        this.q.f13887a.setVisibility(z2 ? 0 : 8);
        b05.c(new b05.a() { // from class: p9
            @Override // b05.a
            public final Object getValue() {
                return AllNoticeSettingsActivity.R1(zEquals, zEquals2, zEquals3, z2);
            }
        });
        final boolean zEquals4 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getOfficial());
        this.q.t.setVisibility(zEquals4 ? 0 : 8);
        this.q.u.setVisibility(zEquals4 ? 0 : 8);
        b05.c(new b05.a() { // from class: q9
            @Override // b05.a
            public final Object getValue() {
                return AllNoticeSettingsActivity.S1(zEquals4);
            }
        });
        final boolean zEquals5 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getInteractionFriend());
        final boolean zEquals6 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getInteractionLike());
        final boolean zEquals7 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getInteractionComment());
        this.q.k.setVisibility(zEquals5 ? 0 : 8);
        this.q.g.setVisibility(zEquals6 ? 0 : 8);
        this.q.e.setVisibility(zEquals7 ? 0 : 8);
        final boolean z3 = zEquals5 || zEquals6 || zEquals7;
        this.q.n.setVisibility(z3 ? 0 : 8);
        b05.c(new b05.a() { // from class: r9
            @Override // b05.a
            public final Object getValue() {
                return AllNoticeSettingsActivity.T1(zEquals5, zEquals6, zEquals7, z3);
            }
        });
        final boolean zEquals8 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getSubscribe());
        this.q.E.setVisibility(zEquals8 ? 0 : 8);
        this.q.H.setVisibility(zEquals8 ? 0 : 8);
        boolean zEquals9 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getOtherNearby());
        b05.c(new b05.a() { // from class: s9
            @Override // b05.a
            public final Object getValue() {
                return AllNoticeSettingsActivity.U1(zEquals8);
            }
        });
        boolean zEquals10 = BuildConfig.USE_CLOUD_CONFIG.equals(this.u.getOtherOperation());
        this.q.r.setVisibility(zEquals9 ? 0 : 8);
        this.q.y.setVisibility(zEquals10 ? 0 : 8);
        if (!zEquals9 && !zEquals10) {
            z = false;
        }
        this.q.z.setVisibility(z ? 0 : 8);
    }

    public final void M1() {
        if (com.zenmen.palmchat.utils.a.E().N() || this.r) {
            return;
        }
        this.r = true;
        new sd3(this).j(R.string.settings_message_notify_permission_dialog).O(R.string.sr_confirm_str).M(getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.sr_cancel_str).f(new b()).r(new a()).h(false).Q();
    }

    public final void O1() {
        int iB = t34.b();
        this.t = iB;
        this.q.h.setChecked(t34.c(iB, 1));
        this.q.F.setChecked(t34.c(this.t, 2));
        this.q.l.setChecked(t34.c(this.t, 4));
        this.q.s.setChecked(t34.c(this.t, 8));
        this.q.j.setChecked(t34.c(this.t, 16));
        this.q.f.setChecked(t34.c(this.t, 32));
        this.q.d.setChecked(t34.c(this.t, 64));
        this.q.C.setChecked(t34.c(this.t, 128));
        this.q.q.setChecked(t34.c(this.t, 256));
        this.q.x.setChecked(t34.c(this.t, 512));
        Z1(this.t);
    }

    public final void P1() {
        b2(this.q.h, 1, "好友打招呼通知");
        b2(this.q.F, 2, "陌生人打招呼通知");
        b2(this.q.l, 4, "群聊消息通知");
        b2(this.q.s, 8, "官方公告通知");
        b2(this.q.j, 16, "好友申请通知");
        b2(this.q.f, 32, "动态点赞通知");
        b2(this.q.d, 64, "动态评论通知");
        b2(this.q.C, 128, "特别关注通知");
        b2(this.q.q, 256, "附近用户推荐通知");
        b2(this.q.x, 512, "其他营销通知");
    }

    public final void X1() {
        SetpageNotificationConfig setpageNotificationConfig = SetpageNotificationConfig.getSetpageNotificationConfig();
        if (setpageNotificationConfig == null || setpageNotificationConfig.getMsgShowSwitch() == null) {
            this.u = new SetpageNotificationConfig.MsgShowSwitch();
            b05.c(new b05.a() { // from class: u9
                @Override // b05.a
                public final Object getValue() {
                    return AllNoticeSettingsActivity.W1();
                }
            });
        } else {
            this.u = setpageNotificationConfig.getMsgShowSwitch();
            b05.c(new b05.a() { // from class: t9
                @Override // b05.a
                public final Object getValue() {
                    return this.f20924a.V1();
                }
            });
        }
    }

    public final void Y1(int i) {
        HashMap map = new HashMap();
        boolean zC = t34.c(i, 1);
        String str = BuildConfig.USE_CLOUD_CONFIG;
        map.put("chat_friend", zC ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("chat_stranger", t34.c(i, 2) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("chat_muc", t34.c(i, 4) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("official", t34.c(i, 8) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_friend", t34.c(i, 16) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_like", t34.c(i, 32) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_comment", t34.c(i, 64) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("subscribe", t34.c(i, 128) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("other_nearby", t34.c(i, 256) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        if (!t34.c(i, 512)) {
            str = WkInteractiveManager.TimingTypeOff;
        }
        map.put("other_operation", str);
        q05.a("setpage_notification_groupshow", 2, map);
    }

    public final void Z1(int i) {
        HashMap map = new HashMap();
        map.put("manufacturer", ac1.f1194a);
        boolean zC = t34.c(i, 1);
        String str = BuildConfig.USE_CLOUD_CONFIG;
        map.put("chat_friend", zC ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("chat_stranger", t34.c(i, 2) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("chat_muc", t34.c(i, 4) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("official", t34.c(i, 8) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_friend", t34.c(i, 16) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_like", t34.c(i, 32) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("interaction_comment", t34.c(i, 64) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("subscribe", t34.c(i, 128) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("other_nearby", t34.c(i, 256) ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        if (!t34.c(i, 512)) {
            str = WkInteractiveManager.TimingTypeOff;
        }
        map.put("other_operation", str);
        q05.a("setpage_notification_groupshow", 1, map);
    }

    public final void a2() {
        this.s = true;
        if (com.zenmen.palmchat.utils.a.E().N()) {
            this.q.h.setChecked(t34.c(this.t, 1));
            this.q.F.setChecked(t34.c(this.t, 2));
            this.q.l.setChecked(t34.c(this.t, 4));
            this.q.s.setChecked(t34.c(this.t, 8));
            this.q.j.setChecked(t34.c(this.t, 16));
            this.q.f.setChecked(t34.c(this.t, 32));
            this.q.d.setChecked(t34.c(this.t, 64));
            this.q.C.setChecked(t34.c(this.t, 128));
            this.q.q.setChecked(t34.c(this.t, 256));
            this.q.x.setChecked(t34.c(this.t, 512));
        } else {
            this.q.h.setChecked(false);
            this.q.F.setChecked(false);
            this.q.l.setChecked(false);
            this.q.s.setChecked(false);
            this.q.j.setChecked(false);
            this.q.f.setChecked(false);
            this.q.d.setChecked(false);
            this.q.C.setChecked(false);
            this.q.q.setChecked(false);
            this.q.x.setChecked(false);
        }
        this.s = false;
    }

    public final void b2(CheckBox checkBox, int i, String str) {
        checkBox.setOnCheckedChangeListener(new c(checkBox, i, str));
    }

    public final void c2(int i, String str, boolean z) {
        t34.a(this, i, new d(z, str));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = (ActivityAllNoticeSettingsBinding) DataBindingUtil.setContentView(this, R.layout.activity_all_notice_settings);
        initToolbar("通知提醒设置");
        X1();
        L1();
        O1();
        P1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q = null;
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a2();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements q05.d<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15121a;
        public final /* synthetic */ String b;

        public d(boolean z, String str) {
            this.f15121a = z;
            this.b = str;
        }

        @Override // q05.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(LXBaseNetBean<String> lXBaseNetBean) {
            if (this.f15121a) {
                return;
            }
            Toast.makeText(AllNoticeSettingsActivity.this, this.b + "已关闭！", 0).show();
        }

        @Override // q05.d
        public void a(Exception exc) {
        }
    }
}
