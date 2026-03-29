package com.zenmen.palmchat.SwipeBackLayout.app;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout;
import defpackage.vp5;
import defpackage.y86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SwipeBackActivity extends FragmentActivity {
    public vp5 q;

    public void A1(boolean z) {
        y1().setEnableGesture(z);
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        vp5 vp5Var;
        View viewFindViewById = super.findViewById(i);
        return (viewFindViewById != null || (vp5Var = this.q) == null) ? viewFindViewById : vp5Var.b(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vp5 vp5Var = new vp5(this);
        this.q = vp5Var;
        vp5Var.d();
        A1(true);
        y1().setEdgeTrackingEnabled(1);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.q.e();
    }

    public SwipeBackLayout y1() {
        return this.q.c();
    }

    public void z1() {
        y86.a(this);
        y1().scrollToFinishActivity();
    }
}
