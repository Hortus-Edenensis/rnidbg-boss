package com.zenmen.palmchat.aichat;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.v8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiCHatBuyDialogBaseActivity extends FrameworkBaseActivity {
    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        long j;
        long j2;
        int i;
        int i2;
        int intExtra;
        super.onCreate(bundle);
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra("fuidL", 0L);
            long longExtra2 = getIntent().getLongExtra("uidL", 0L);
            int intExtra2 = getIntent().getIntExtra("gender", 0);
            int intExtra3 = getIntent().getIntExtra("dfrom", 0);
            i2 = intExtra2;
            intExtra = getIntent().getIntExtra("bizType", 0);
            j2 = longExtra2;
            j = longExtra;
            i = intExtra3;
        } else {
            j = 0;
            j2 = 0;
            i = 0;
            i2 = 0;
            intExtra = 0;
        }
        if (v8.N(this, i, j, j2, i2, intExtra)) {
            return;
        }
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
