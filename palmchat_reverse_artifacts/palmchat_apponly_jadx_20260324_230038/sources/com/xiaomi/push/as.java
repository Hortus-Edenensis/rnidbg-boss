package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f134a = new HashMap();

    public String a() {
        return this.f133a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f11422a), this.f134a.toString(), this.f133a);
    }
}
