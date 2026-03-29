package com.zenmen.palmchat.login;

import android.os.Bundle;
import com.zenmen.palmchat.BaseActionBarActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BaseActivityWithoutCheckAccount extends BaseActionBarActivity {
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needCheckAccount = false;
        this.mNeedCheckAppIsBackground = false;
    }
}
