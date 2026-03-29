package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.k36;
import defpackage.rl0;
import defpackage.tg4;
import defpackage.w66;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PermissionManagerActivity extends BaseActionBarActivity {
    public final ArrayList<String> q = new a();
    public LinearLayout r;
    public LinearLayout s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ArrayList<String> {
        public a() {
            add("location");
            add("camera");
            add("storage");
            add("audio");
            add("window");
            add("phone");
            add("contacts");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PermissionManagerActivity.this.getPackageName(), null));
                PermissionManagerActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final JSONArray A1() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AUTHORITYMANAGEMENT);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return null;
        }
        try {
            return new JSONObject(extra).optJSONArray(com.igexin.push.core.b.Y);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean B1(String str) {
        str.hashCode();
        switch (str) {
            case "storage":
                return tg4.b(AppContext.getContext(), g.j);
            case "camera":
                return tg4.b(AppContext.getContext(), "android.permission.CAMERA");
            case "window":
                return w66.c(AppContext.getContext());
            case "contacts":
                return tg4.b(AppContext.getContext(), "android.permission.READ_CONTACTS");
            case "audio":
                return tg4.b(AppContext.getContext(), "android.permission.RECORD_AUDIO");
            case "phone":
                return tg4.b(AppContext.getContext(), g.c);
            case "location":
                return tg4.b(AppContext.getContext(), g.g);
            default:
                return false;
        }
    }

    public final View C1(String str, String str2, String str3) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.permission_manager_list_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.permission_title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.permission_des);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.permission_switch);
        textView.setText(str2);
        textView2.setText(str3);
        imageView.setImageResource(B1(str) ? R.drawable.checkbox_background_green : R.drawable.checkbox_background_gray);
        imageView.setOnClickListener(new b());
        return linearLayout;
    }

    public final void D1() {
        this.r = (LinearLayout) findViewById(R.id.content);
        this.s = (LinearLayout) findViewById(R.id.empty_view);
    }

    public final void initActionBar() {
        initToolbar(R.string.string_permission_manager_title);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_permission_manager);
        initActionBar();
        D1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateViews();
    }

    public final void updateViews() {
        this.r.removeAllViews();
        try {
            JSONArray jSONArrayA1 = A1();
            if (jSONArrayA1 != null) {
                for (int i = 0; i < jSONArrayA1.length(); i++) {
                    JSONArray jSONArrayOptJSONArray = jSONArrayA1.optJSONArray(i);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                        String strOptString = jSONObject.optString("type");
                        String strOptString2 = jSONObject.optString("title");
                        String strOptString3 = jSONObject.optString("txt");
                        if (this.q.contains(strOptString)) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            if (i != 0 && i2 == 0) {
                                layoutParams.topMargin = k36.b(12.0f);
                            }
                            this.r.addView(C1(strOptString, strOptString2, strOptString3), layoutParams);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.s.setVisibility(this.r.getChildCount() != 0 ? 8 : 0);
    }
}
