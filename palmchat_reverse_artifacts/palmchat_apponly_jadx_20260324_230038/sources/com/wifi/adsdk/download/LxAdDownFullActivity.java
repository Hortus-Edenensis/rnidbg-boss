package com.wifi.adsdk.download;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdStatusBarUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDownFullActivity extends AppCompatActivity {
    public static LxAdDownMdaData mdaData;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LxAdStatusBarUtil.setTranslucentStatus(this);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(LxAdDLManager.TAG_ITEM_ALL);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                LxAdLog.d("LXadsplash down LxAdDownFullActivity resData " + stringExtra);
                new LxAdDownDialog(this, new JSONObject(stringExtra), null, mdaData).show();
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mdaData = null;
    }
}
