package com.zenmen.palmchat.zx.compat.swizzle;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.zx.annotation.SwizzleParent;
import defpackage.m5;
import defpackage.oo2;
import defpackage.r43;
import defpackage.rm2;
import defpackage.s45;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/zenmen/palmchat/zx/compat/swizzle/SwFragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/zenmen/palmchat/zx/compat/FragmentActivity;", "Lrm2;", "Loo2;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "requestedOrientation", "setRequestedOrientation", "", "q", "Z", "c0", "()Z", "set__zxcompat_denyscreenshot", "(Z)V", "__zxcompat_denyscreenshot", "Lr43;", t.k, "Lr43;", "U0", "()Lr43;", "a0", "(Lr43;)V", "__sw_loaders__", "<init>", "()V", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
@SwizzleParent(category = "compat", value = FragmentActivity.class)
public class SwFragmentActivity extends FragmentActivity implements rm2, oo2 {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean __zxcompat_denyscreenshot;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public r43 __sw_loaders__;

    @Override // defpackage.rm2
    /* JADX INFO: renamed from: U0, reason: from getter */
    public r43 get__sw_loaders__() {
        return this.__sw_loaders__;
    }

    @Override // defpackage.rm2
    public void a0(r43 r43Var) {
        this.__sw_loaders__ = r43Var;
    }

    @Override // defpackage.oo2
    /* JADX INFO: renamed from: c0, reason: from getter */
    public boolean get__zxcompat_denyscreenshot() {
        return this.__zxcompat_denyscreenshot;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        m5.c(this, savedInstanceState);
        s45.a(this, savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        if (m5.d(this, requestedOrientation)) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }
}
