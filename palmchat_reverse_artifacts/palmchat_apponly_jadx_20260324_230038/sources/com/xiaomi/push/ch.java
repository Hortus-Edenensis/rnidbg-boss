package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11471a;

    public ch(int i) {
        this.f11471a = i;
    }

    public abstract String a(Context context, String str, List<at> list);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m263a(Context context, String str, List<at> list) {
        return true;
    }

    public int a() {
        return this.f11471a;
    }
}
