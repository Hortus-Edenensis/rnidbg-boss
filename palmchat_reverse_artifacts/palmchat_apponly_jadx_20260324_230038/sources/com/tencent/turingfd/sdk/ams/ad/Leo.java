package com.tencent.turingfd.sdk.ams.ad;

import android.os.LocaleList;
import defpackage.x43;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Leo implements LeoMinor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f10713a;

    public Leo(Object obj) {
        this.f10713a = x43.a(obj);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.LeoMinor
    public Locale a(int i) {
        return this.f10713a.get(i);
    }

    public int hashCode() {
        return this.f10713a.hashCode();
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.LeoMinor
    public int a() {
        return this.f10713a.size();
    }
}
