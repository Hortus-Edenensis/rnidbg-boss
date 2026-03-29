package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.push.AttributionReporter;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ZXCheckBox;
import defpackage.sd3;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MessageNotifyPermissionActivity extends BaseActionBarActivity {
    public ZXCheckBox q;
    public ImageView r;
    public boolean s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ZXCheckBox.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.ZXCheckBox.a
        public void b(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                if (z) {
                    com.zenmen.palmchat.utils.a.E().G0(true);
                    MessageNotifyPermissionActivity.this.D1();
                } else {
                    MessageNotifyPermissionActivity.this.I1();
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, com.zenmen.palmchat.utils.a.E().N());
                    LogUtil.onNotifyEvent("4315", z ? "5" : "6", null, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            MessageNotifyPermissionActivity.this.F1();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().y0(MessageNotifyPermissionActivity.this);
            LogUtil.onNotifyClickEvent("4316", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            MessageNotifyPermissionActivity.this.F1();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().G0(false);
            MessageNotifyPermissionActivity.this.F1();
        }
    }

    public final void D1() {
        if (com.zenmen.palmchat.utils.a.E().N()) {
            return;
        }
        new sd3(this).j(R.string.settings_message_notify_permission_dialog).O(R.string.sr_confirm_str).M(getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.sr_cancel_str).f(new b()).h(false).Q();
    }

    public final void E1() {
        if (com.zenmen.palmchat.utils.a.E().N()) {
            this.r.setImageResource(R.drawable.message_notify_permission_enable);
        } else {
            this.r.setImageResource(R.drawable.message_notify_permission_disable);
        }
    }

    public final void F1() {
        this.q.setChecked(com.zenmen.palmchat.utils.a.E().X(), false);
    }

    public final void G1() {
        this.r = (ImageView) findViewById(R.id.notify_tips_image);
        ZXCheckBox zXCheckBox = (ZXCheckBox) findViewById(R.id.notify_checkbox);
        this.q = zXCheckBox;
        zXCheckBox.setOnCheckedChangeListener(new a());
    }

    public final void H1(boolean z) {
        this.s = z;
        LogUtil.onNotifyEvent("4317", z ? "5" : "6", null, null);
    }

    public final void I1() {
        new sd3(this).j(R.string.settings_message_notify_disable_dialog).O(R.string.sr_disable_str).M(getResources().getColor(R.color.material_dialog_button_text_color_red)).K(R.string.sr_cancel_str).f(new c()).h(false).Q();
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_message_notify);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_settings_message_permission);
        initActionBar();
        G1();
        this.s = com.zenmen.palmchat.utils.a.E().N();
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
        super.onResume();
        F1();
        E1();
        boolean zN = com.zenmen.palmchat.utils.a.E().N();
        if (this.s != zN) {
            H1(zN);
        }
    }
}
