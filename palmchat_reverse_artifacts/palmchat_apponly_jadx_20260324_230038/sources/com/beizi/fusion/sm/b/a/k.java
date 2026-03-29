package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class k implements com.beizi.fusion.sm.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4685a;

    public k(Context context) {
        this.f4685a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f4685a == null || bVar == null) {
            return;
        }
        if (!a()) {
            com.beizi.fusion.sm.b.e.a("Only supports Android 10.0 and above for Nubia");
            bVar.a(new com.beizi.fusion.sm.b.d("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f4685a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.release();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed: " + bundleCall.getString("message"));
            }
            com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
            bVar.a(string);
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
            bVar.a(e);
        }
    }
}
