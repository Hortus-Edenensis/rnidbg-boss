package com.wifi.adsdk.download;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdStatusBarUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDownDeleteActivity extends AppCompatActivity {
    private JSONObject dataObj = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LxAdStatusBarUtil.setTranslucentStatus(this);
        try {
            if (getIntent() != null) {
                this.dataObj = new JSONObject(getIntent().getStringExtra(LxAdDLManager.TAG_ITEM_ALL));
                LxAdLog.d("LXadsplash LxAdDownDeleteActivity start .dataObj  " + this.dataObj);
                new LxAdDeleteDialog(this, this.dataObj).show();
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
