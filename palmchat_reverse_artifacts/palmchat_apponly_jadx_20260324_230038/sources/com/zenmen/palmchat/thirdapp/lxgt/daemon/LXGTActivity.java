package com.zenmen.palmchat.thirdapp.lxgt.daemon;

import android.app.Activity;
import android.os.Bundle;
import com.igexin.sdk.GTServiceManager;
import defpackage.n52;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LXGTActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GTServiceManager.getInstance().onActivityCreate(this);
        n52.d("newActivity");
    }
}
