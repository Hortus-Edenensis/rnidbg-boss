package com.qq.gdt.action.g;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f10523a = false;

    public static void a(Context context) {
        if (!com.qq.gdt.action.d.a().z() || f10523a) {
            return;
        }
        b.a().b();
    }

    public static void b(Context context) {
        f10523a = false;
        if (com.qq.gdt.action.d.a().z()) {
            b.a().b();
        }
    }

    public static void c(Context context) {
        f10523a = true;
    }
}
