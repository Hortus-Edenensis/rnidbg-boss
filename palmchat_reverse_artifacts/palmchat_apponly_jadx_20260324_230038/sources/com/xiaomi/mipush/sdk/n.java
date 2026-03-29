package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11380a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f63a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return !TextUtils.isEmpty(nVar.f63a) && nVar.f63a.equals(this.f63a);
    }
}
