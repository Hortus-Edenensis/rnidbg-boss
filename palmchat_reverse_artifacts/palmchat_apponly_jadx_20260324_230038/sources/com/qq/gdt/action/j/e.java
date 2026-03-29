package com.qq.gdt.action.j;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {
    public static void a() {
        SharedPreferences.Editor editorEdit = com.qq.gdt.action.d.a().g().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("f11874d335", com.qq.gdt.action.e.a());
        editorEdit.commit();
    }
}
