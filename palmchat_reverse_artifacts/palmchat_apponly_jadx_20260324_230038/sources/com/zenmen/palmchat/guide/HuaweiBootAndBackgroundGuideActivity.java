package com.zenmen.palmchat.guide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.n86;
import defpackage.ol2;
import defpackage.sb1;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class HuaweiBootAndBackgroundGuideActivity extends BaseActionBarActivity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol2 ol2VarB = sb1.b(HuaweiBootAndBackgroundGuideActivity.this);
            if (ol2VarB == null) {
                HuaweiBootAndBackgroundGuideActivity.this.C1(1);
                return;
            }
            Intent permissionActivity = ol2VarB.getPermissionActivity(3);
            if (permissionActivity == null) {
                HuaweiBootAndBackgroundGuideActivity.this.C1(2);
                return;
            }
            permissionActivity.setFlags(65536);
            if (!HuaweiBootAndBackgroundGuideActivity.this.B1(permissionActivity)) {
                HuaweiBootAndBackgroundGuideActivity.this.C1(3);
                return;
            }
            try {
                Intent intent = new Intent(HuaweiBootAndBackgroundGuideActivity.this, (Class<?>) BootAndBackgroundOverlayActivity.class);
                intent.putExtra("subtitle_res", HuaweiBootAndBackgroundGuideActivity.this.getString(R.string.added_to_safe_zone));
                intent.putExtra("title_icon_res", R.drawable.lock_huawei);
                intent.putExtra("switch_icon_res", R.drawable.ic_guide_switch);
                HuaweiBootAndBackgroundGuideActivity.this.startActivities(new Intent[]{permissionActivity, intent});
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("3703", "1", jSONObject.toString());
            } catch (Exception unused) {
                HuaweiBootAndBackgroundGuideActivity.this.C1(4);
            }
        }
    }

    public boolean B1(Intent intent) {
        ActivityInfo activityInfo;
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() == 1 && (activityInfo = listQueryIntentActivities.get(0).activityInfo) != null && activityInfo.exported;
    }

    public final void C1(int i) {
        String strB = n86.b(Build.MANUFACTURER.toLowerCase(), Locale.getDefault().toString(), Integer.toString(Build.VERSION.SDK_INT));
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", strB);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        startActivity(intent);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 1);
            jSONObject.put("failReason", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("3703", "2", jSONObject.toString());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            boolean booleanExtra = getIntent().getBooleanExtra("FROM_SOURCE_IS_NOTIFY", false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", booleanExtra ? 1 : 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("3702", null, jSONObject.toString());
        }
        setContentView(R.layout.activity_huawei_boot_and_background_guide);
        initToolbar(R.string.permission_guile_title);
        ((TextView) findViewById(R.id.background_decription)).setText(Html.fromHtml(getString(R.string.huawei_boot_and_background_permissions_description)));
        findViewById(R.id.add_to_safe_zone_btn).setOnClickListener(new a());
    }
}
