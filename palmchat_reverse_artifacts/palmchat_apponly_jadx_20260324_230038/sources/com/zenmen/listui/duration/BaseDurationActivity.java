package com.zenmen.listui.duration;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.qi1;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseDurationActivity extends FrameworkBaseActivity {
    public qi1 q;

    public abstract int o();

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.q = new qi1(UUID.randomUUID().toString().replace("-", ""), o());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.q.c();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.q.d();
    }
}
