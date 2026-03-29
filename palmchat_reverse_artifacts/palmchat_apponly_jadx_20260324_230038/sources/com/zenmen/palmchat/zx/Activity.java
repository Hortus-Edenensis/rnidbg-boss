package com.zenmen.palmchat.zx;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.kuaishou.weapon.p0.t;
import defpackage.m5;
import defpackage.oo2;
import defpackage.q5;
import defpackage.s45;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b%\u0010&J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J/\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\"\u0010 \u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/zenmen/palmchat/zx/Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/zenmen/palmchat/zx/compat/AppCompatActivity;", "", "Loo2;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "requestedOrientation", "setRequestedOrientation", "onDestroy", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "", "q", "Z", "c0", "()Z", "set__zxcompat_denyscreenshot", "(Z)V", "__zxcompat_denyscreenshot", "Lq5;", t.k, "Lq5;", "proxyPermission", "<init>", "()V", "zx-framework_release"}, k = 1, mv = {1, 4, 0})
public abstract class Activity extends AppCompatActivity implements oo2 {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean __zxcompat_denyscreenshot;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final q5 proxyPermission = new q5(this);

    @Override // defpackage.oo2
    /* JADX INFO: renamed from: c0, reason: from getter */
    public boolean get__zxcompat_denyscreenshot() {
        return this.__zxcompat_denyscreenshot;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.proxyPermission.a(requestCode, resultCode, data);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m5.c(this, savedInstanceState);
        s45.a(this, savedInstanceState);
        this.proxyPermission.b(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.proxyPermission.c();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.proxyPermission.d(requestCode, permissions, grantResults);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        if (m5.d(this, requestedOrientation)) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }
}
