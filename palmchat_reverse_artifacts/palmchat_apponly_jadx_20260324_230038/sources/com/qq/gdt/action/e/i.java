package com.qq.gdt.action.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.q;
import com.qq.gdt.action.j.v;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class i {
    private static String a() {
        h hVar = new h("Tencent/ams/cache", "meta.dat");
        h hVar2 = new h("Android/data/com.tencent.ams/cache", "meta.dat");
        String str = null;
        if (hVar.a() && hVar2.a()) {
            String strA = hVar.a(10240);
            String strA2 = hVar2.a(10240);
            o.a("jsonUUIDString:" + strA + "/jsonUUIDStringBackup:" + strA2, new Object[0]);
            if (!v.a(strA)) {
                str = strA;
            } else if (!v.a(strA2)) {
                str = strA2;
            }
        }
        hVar.b();
        hVar2.b();
        return str;
    }

    public static String a(Context context, boolean z, boolean z2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0);
        boolean zA = a(context, z2);
        o.a("create:" + z + "/preCheck:" + zA, new Object[0]);
        if (!zA) {
            return sharedPreferences.getString("uuid_standard", "");
        }
        String string = z ? "" : sharedPreferences.getString("uuid_standard", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strA = a();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("uuid_standard", strA);
        editorEdit.apply();
        return strA;
    }

    private static boolean a(Context context, boolean z) {
        return (!z || q.a(context, com.kuaishou.weapon.p0.g.j)) && TextUtils.equals(Environment.getExternalStorageState(), "mounted");
    }
}
