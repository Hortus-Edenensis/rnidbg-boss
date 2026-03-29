package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6481a;
    public final int b;

    public w(String str) {
        this.f6481a = str;
        this.b = a(str);
    }

    public static w a(String str) {
        return new w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f6481a, ((w) obj).f6481a);
    }

    public final int hashCode() {
        return this.b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
