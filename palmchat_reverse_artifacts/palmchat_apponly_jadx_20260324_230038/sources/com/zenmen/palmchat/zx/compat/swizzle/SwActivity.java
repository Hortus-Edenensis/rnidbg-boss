package com.zenmen.palmchat.zx.compat.swizzle;

import android.app.Activity;
import android.os.Bundle;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/zenmen/palmchat/zx/compat/swizzle/SwActivity;", "Landroid/app/Activity;", "Lrm2;", "Loo2;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "requestedOrientation", "setRequestedOrientation", "", "a", "Z", "c0", "()Z", "set__zxcompat_denyscreenshot", "(Z)V", "__zxcompat_denyscreenshot", "Lr43;", t.l, "Lr43;", "U0", "()Lr43;", "a0", "(Lr43;)V", "__sw_loaders__", "<init>", "()V", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
@SwizzleParent(category = "compat", value = Activity.class)
public class SwActivity extends Activity implements rm2, oo2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean __zxcompat_denyscreenshot;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
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

    @Override // android.app.Activity
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
