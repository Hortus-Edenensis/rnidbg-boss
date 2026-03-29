package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class ab implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentResolver f11293a;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (!m.b()) {
            return false;
        }
        this.f11293a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.f11293a, str);
        } catch (Exception e) {
            e.printStackTrace();
            t.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
