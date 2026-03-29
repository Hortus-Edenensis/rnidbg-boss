package com.zenmen.palmchat.paidservices.superexpose.dialog;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.zenmen.palmchat.paidservices.superexpose.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperBuyDialogBaseActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int i;
        super.onCreate(bundle);
        int i2 = 0;
        boolean booleanExtra = true;
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("dscene", 0);
            int intExtra2 = getIntent().getIntExtra("dfrom", 0);
            booleanExtra = getIntent().getBooleanExtra("isFromDeepLink", true);
            i2 = intExtra;
            i = intExtra2;
        } else {
            i = 0;
        }
        a.b().g(this, i2, i, booleanExtra);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
