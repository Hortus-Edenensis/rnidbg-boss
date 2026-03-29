package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f11219a;
    private String b;
    private String c;

    public d(String str, String str2, Bundle bundle) {
        this.b = str;
        this.c = str2;
        this.f11219a = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d a(Intent intent) {
        String string;
        if (intent == null) {
            com.vivo.push.util.t.a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            string = extras.getString("client_pkgname");
            if (TextUtils.isEmpty(string)) {
                string = null;
            }
        }
        if (TextUtils.isEmpty(string)) {
            com.vivo.push.util.t.b("BundleWapper", "create warning: pkgName is null");
        }
        String str = intent.getPackage();
        if (TextUtils.isEmpty(str)) {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(packageName)) {
                com.vivo.push.util.t.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str = packageName;
        }
        return new d(string, str, extras);
    }

    public final int b(String str, int i) {
        Bundle bundle = this.f11219a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f11219a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f11219a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f11219a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f11219a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j) {
        Bundle bundle = this.f11219a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final Bundle b() {
        return this.f11219a;
    }

    public final void a(String str, int i) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putBoolean(str, z);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f11219a == null) {
            this.f11219a = new Bundle();
        }
        this.f11219a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f11219a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.b;
    }
}
