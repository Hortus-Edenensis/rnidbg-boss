package com.zenmen.palmchat.SwipeBackLayout.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import defpackage.vp5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SwipeBackPreferenceActivity extends PreferenceActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vp5 f12145a;

    @Override // android.app.Activity
    public View findViewById(int i) {
        vp5 vp5Var;
        View viewFindViewById = super.findViewById(i);
        return (viewFindViewById != null || (vp5Var = this.f12145a) == null) ? viewFindViewById : vp5Var.b(i);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vp5 vp5Var = new vp5(this);
        this.f12145a = vp5Var;
        vp5Var.d();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f12145a.e();
    }
}
