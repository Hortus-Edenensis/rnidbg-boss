package com.xiaomi.push;

import com.xiaomi.push.bw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bs extends bw.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11452a;

    public bs(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f11452a = str3;
    }

    public static bs a(String str) {
        return new bs(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
