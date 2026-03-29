package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.igexin.push.core.b;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.fx;
import com.ss.android.socialbase.appdownloader.fx.l;
import com.ss.android.socialbase.appdownloader.fx.mv;
import com.ss.android.socialbase.appdownloader.n;
import com.ss.android.socialbase.appdownloader.nr;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class JumpUnknownSourceActivity extends Activity {
    private int b;

    @Nullable
    private Intent fx;
    private Intent nr;
    private JSONObject pn;
    private l u;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        u();
        n.u().u(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        n.u().u(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.nr = intent;
        if (intent != null) {
            this.fx = (Intent) intent.getParcelableExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            this.b = intent.getIntExtra("id", -1);
            try {
                this.pn = new JSONObject(intent.getStringExtra(b.Y));
            } catch (Exception unused) {
            }
        }
        if (this.pn == null) {
            fx.u((Activity) this);
            return;
        }
        nr();
        l lVar = this.u;
        if (lVar != null && !lVar.nr()) {
            this.u.u();
        } else if (this.u == null) {
            finish();
        }
    }

    private void nr() {
        if (this.u != null || this.nr == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.fx.b bVarNr = com.ss.android.socialbase.appdownloader.b.t().nr();
            mv mvVarU = bVarNr != null ? bVarNr.u(this) : null;
            if (mvVarU == null) {
                mvVarU = new com.ss.android.socialbase.appdownloader.b.u(this);
            }
            int iU = a.u(this, "tt_appdownloader_tip");
            int iU2 = a.u(this, "tt_appdownloader_label_ok");
            int iU3 = a.u(this, "tt_appdownloader_label_cancel");
            String strOptString = this.pn.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(a.u(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            mvVarU.u(iU).u(strOptString).u(iU2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (nr.u(jumpUnknownSourceActivity, jumpUnknownSourceActivity.fx, JumpUnknownSourceActivity.this.b, JumpUnknownSourceActivity.this.pn)) {
                        nr.fx(JumpUnknownSourceActivity.this.b, JumpUnknownSourceActivity.this.pn);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        nr.u((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.fx, true);
                    }
                    nr.u(JumpUnknownSourceActivity.this.b, JumpUnknownSourceActivity.this.pn);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).nr(iU3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.fx != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        nr.u((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.fx, true);
                    }
                    nr.nr(JumpUnknownSourceActivity.this.b, JumpUnknownSourceActivity.this.pn);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).u(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.fx != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        nr.u((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.fx, true);
                    }
                    nr.nr(JumpUnknownSourceActivity.this.b, JumpUnknownSourceActivity.this.pn);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).u(false);
            this.u = mvVarU.u();
        } catch (Exception unused) {
        }
    }

    private void u() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
