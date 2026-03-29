package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BaseThemeActivity extends Activity {
    protected bc pn;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        bc bcVarU = jp.u(getIntent());
        this.pn = bcVarU;
        if (bcVarU == null) {
            s.u().u("meta_null", (Throwable) null);
        } else {
            if (!bcVarU.x() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String stringExtra;
        super.onDestroy();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("multi_process_materialmeta_key")) == null) {
            return;
        }
        c.u(stringExtra);
    }
}
