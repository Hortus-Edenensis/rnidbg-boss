package com.zenmen.palmchat.settings;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.push.AttributionReporter;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.settings.c;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ZXCheckBox;
import defpackage.ac1;
import defpackage.eq3;
import defpackage.iq5;
import defpackage.k86;
import defpackage.ny;
import defpackage.q05;
import defpackage.r75;
import defpackage.sd3;
import defpackage.yg4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MessageNotifySettingsActivity extends BaseActionBarActivity {
    public ZXCheckBox q;
    public CheckBox r;
    public CheckBox s;
    public CheckBox t;
    public View u;
    public TextView v;
    public eq3 w;
    public boolean x;
    public Response.Listener<JSONObject> y = new d();
    public Response.ErrorListener z = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, ny.k());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, NotificationChannelManager.MessageType.MOMENT.getNotificationChannel());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, NotificationChannelManager.MessageType.SUBSCRIPTION_MSG.getNotificationChannel());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {
        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            MessageNotifySettingsActivity.this.P1();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().y0(MessageNotifySettingsActivity.this);
            LogUtil.onNotifyClickEvent("4319", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            MessageNotifySettingsActivity.this.P1();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().G0(false);
            MessageNotifySettingsActivity.this.X1();
            MessageNotifySettingsActivity.this.P1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends ZXCheckBox.a {
        public h() {
        }

        @Override // com.zenmen.palmchat.widget.ZXCheckBox.a
        public void b(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                if (z) {
                    com.zenmen.palmchat.utils.a.E().G0(true);
                    MessageNotifySettingsActivity.this.X1();
                    MessageNotifySettingsActivity.this.O1();
                } else {
                    MessageNotifySettingsActivity.this.c2();
                }
                if (MessageNotifySettingsActivity.this.Y1()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, com.zenmen.palmchat.utils.a.E().N());
                        LogUtil.onNotifyEvent("4318", z ? "5" : "6", null, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            MessageNotifySettingsActivity.this.d2(com.zenmen.palmchat.utils.a.E().X());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SAppUtil.c.d() && SAppUtil.c.c()) {
                MessageNotifySettingsActivity.this.b2(z);
            }
            int iB = yg4.b(MessageNotifySettingsActivity.this.R1(), !z, 16);
            AppContext.getContext().getTrayPreferences().f(k86.w(), iB);
            LogUtil.onEvent("4312", z ? "5" : "6", null, null);
            HashMap map = new HashMap();
            map.put("privacyConfig", Integer.valueOf(iB));
            MessageNotifySettingsActivity.this.w = new eq3(MessageNotifySettingsActivity.this.y, MessageNotifySettingsActivity.this.z);
            try {
                MessageNotifySettingsActivity.this.w.n(map);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements CompoundButton.OnCheckedChangeListener {
        public j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            r75.o(MessageNotifySettingsActivity.this, "notify_sound", z);
            if (z) {
                MessageNotifySettingsActivity.this.u.setVisibility(0);
            } else {
                MessageNotifySettingsActivity.this.u.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            r75.o(MessageNotifySettingsActivity.this, "notify_vibration", z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MessageNotifySettingsActivity.this, NotificationSoundSettingsActivity.class);
            MessageNotifySettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            MessageNotifySettingsActivity.this.Z1();
            AllNoticeSettingsActivity.N1(MessageNotifySettingsActivity.this.sInstance);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, NotificationChannelManager.MessageType.MSG.getNotificationChannel());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, NotificationChannelManager.MessageType.PUBLIC.getNotificationChannel());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.utils.a.E().j0(MessageNotifySettingsActivity.this, NotificationChannelManager.MessageType.INTERACTIVE.getNotificationChannel());
        }
    }

    public final void O1() {
        if (Y1() && !com.zenmen.palmchat.utils.a.E().N()) {
            new sd3(this).j(R.string.settings_message_notify_permission_dialog).O(R.string.sr_confirm_str).M(getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.sr_cancel_str).f(new f()).h(false).Q();
        }
    }

    public final void P1() {
        boolean zX = com.zenmen.palmchat.utils.a.E().X();
        this.q.setChecked(zX, false);
        d2(zX);
    }

    public Uri Q1() {
        return RingtoneManager.getActualDefaultRingtoneUri(this, 2);
    }

    public final int R1() {
        return AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public String S1(String str) {
        String string = "";
        try {
            RingtoneManager ringtoneManager = new RingtoneManager((Activity) this);
            ringtoneManager.setType(2);
            Cursor cursor = ringtoneManager.getCursor();
            if (cursor == null || cursor.isClosed() || !cursor.moveToFirst()) {
                return "";
            }
            while (!ContentUris.withAppendedId(Uri.parse(cursor.getString(2)), cursor.getLong(0)).toString().equals(str)) {
                if (!cursor.moveToNext()) {
                    return "";
                }
            }
            string = cursor.getString(1);
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return string;
        }
    }

    public final void T1() {
        if (V1()) {
            findViewById(R.id.notify_setting_items).setVisibility(8);
            findViewById(R.id.notify_setting_items_O).setVisibility(0);
        } else {
            findViewById(R.id.notify_setting_items).setVisibility(0);
            findViewById(R.id.notify_setting_items_O).setVisibility(8);
        }
        View viewFindViewById = findViewById(R.id.notify_O_msg);
        View viewFindViewById2 = findViewById(R.id.notify_O_msg_public);
        View viewFindViewById3 = findViewById(R.id.notify_O_msg_interactive);
        View viewFindViewById4 = findViewById(R.id.notify_O_video);
        View viewFindViewById5 = findViewById(R.id.notify_O_moment);
        if (com.zenmen.palmchat.utils.a.E().S()) {
            viewFindViewById5.setVisibility(0);
        } else {
            viewFindViewById5.setVisibility(8);
        }
        viewFindViewById.setOnClickListener(new n());
        viewFindViewById2.setOnClickListener(new o());
        viewFindViewById3.setOnClickListener(new p());
        viewFindViewById4.setOnClickListener(new a());
        viewFindViewById5.setOnClickListener(new b());
        findViewById(R.id.notify_subscription).setOnClickListener(new c());
    }

    public final void U1() {
        this.q = (ZXCheckBox) findViewById(R.id.notify_checkbox);
        this.s = (CheckBox) findViewById(R.id.sound_checkbox);
        this.u = findViewById(R.id.sound_url);
        this.r = (CheckBox) findViewById(R.id.detail_checkbox);
        this.t = (CheckBox) findViewById(R.id.vibration_checkbox);
        this.q.setOnCheckedChangeListener(new h());
        this.r.setChecked(!yg4.a(R1(), 16));
        this.r.setOnCheckedChangeListener(new i());
        boolean zD = r75.d(this, "notify_sound", true);
        this.s.setChecked(zD);
        if (zD) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        this.s.setOnCheckedChangeListener(new j());
        this.t.setChecked(r75.d(this, "notify_vibration", true));
        this.t.setOnCheckedChangeListener(new k());
        this.u.setOnClickListener(new l());
        this.v = (TextView) findViewById(R.id.sound_url_text);
        T1();
        View viewFindViewById = findViewById(R.id.other_layout);
        View viewFindViewById2 = findViewById(R.id.receive_msg_layout);
        View viewFindViewById3 = findViewById(R.id.all_notice_layout);
        if (SAppUtil.c.d() && SAppUtil.c.c()) {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            if (viewFindViewById3 != null) {
                if (AllNoticeSettingsActivity.Q1()) {
                    viewFindViewById3.setVisibility(8);
                } else {
                    viewFindViewById3.setVisibility(0);
                    a2();
                }
            }
        } else {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(8);
            }
        }
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new m());
        }
    }

    public final boolean V1() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final void W1(boolean z) {
        this.x = z;
        LogUtil.onNotifyEvent("4317", z ? "5" : "6", null, null);
    }

    public final void X1() {
        if (com.zenmen.palmchat.utils.a.E().O()) {
            LogUtil.onEvent("4311", "5", null, null);
        } else {
            LogUtil.onEvent("4311", "6", null, null);
        }
    }

    public final boolean Y1() {
        return com.zenmen.palmchat.utils.a.E().d0() || com.zenmen.palmchat.settings.c.j();
    }

    public final void Z1() {
        HashMap map = new HashMap();
        map.put("manufacturer", ac1.f1194a);
        q05.a("setpage_notification_click_settings", 2, map);
    }

    public final void a2() {
        HashMap map = new HashMap();
        map.put("manufacturer", ac1.f1194a);
        q05.a("setpage_notification_show", 1, map);
    }

    public final void b2(boolean z) {
        HashMap map = new HashMap();
        map.put("manufacturer", ac1.f1194a);
        map.put("status", z ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        q05.a("setpage_notification_click_content", 2, map);
    }

    public final void c2() {
        if (Y1()) {
            new sd3(this).j(R.string.settings_message_notify_disable_dialog).O(R.string.sr_disable_str).M(getResources().getColor(R.color.material_dialog_button_text_color_red)).K(R.string.sr_cancel_str).f(new g()).h(false).Q();
            return;
        }
        com.zenmen.palmchat.utils.a.E().G0(false);
        X1();
        P1();
    }

    public final void d2(boolean z) {
        if (z) {
            findViewById(R.id.notify_detail_container).setVisibility(0);
            findViewById(R.id.notify_detail_setting_root).setVisibility(0);
        } else {
            findViewById(R.id.notify_detail_container).setVisibility(8);
            findViewById(R.id.notify_detail_setting_root).setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 153;
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_message_notify);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_settings_message_notify);
        initActionBar();
        U1();
        X1();
        if (Y1()) {
            this.x = com.zenmen.palmchat.utils.a.E().N();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        eq3 eq3Var = this.w;
        if (eq3Var != null) {
            eq3Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean zN;
        String string;
        super.onResume();
        if (!V1()) {
            String strI = r75.i(this, "notify_sound_url");
            try {
                Uri uriQ1 = Q1();
                string = (TextUtils.isEmpty(strI) || (uriQ1 != null && uriQ1.toString().equals(strI))) ? getString(R.string.settings_message_notify_sound_url_content) : S1(strI);
            } catch (Exception unused) {
                string = "";
            }
            this.v.setText(string);
        }
        P1();
        if (Y1() && this.x != (zN = com.zenmen.palmchat.utils.a.E().N())) {
            W1(zN);
        }
        c.e eVarE = com.zenmen.palmchat.settings.c.f().e();
        if ((eVarE.f15280a && eVarE.d) && com.zenmen.palmchat.utils.a.E().N()) {
            this.q.setEnabled(false);
        } else {
            this.q.setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
