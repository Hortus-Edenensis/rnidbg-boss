package com.opos.mobad.cmn.func.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.opos.mobad.i.a.d;
import com.opos.mobad.i.c;
import com.opos.mobad.mediaplayer.a.e;
import com.opos.mobad.mediaplayer.a.f;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str, String str2, b bVar) {
        File file = new File(str2);
        com.opos.cmn.an.f.a.b("LoadSoUtils", "downloadSoZip: " + str2);
        if (!file.exists() && c.a(context, d.a(str, str2)) == null) {
            b(bVar, 1, "下载失败");
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("TBL_So_MD5", 0);
        Iterator<Map.Entry<String, ?>> it = sharedPreferences.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!key.equals(str)) {
                File file = new File(f.b(context, key) + ".zip");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(f.b(context, key));
                if (file2.exists()) {
                    f.b(file2);
                }
                File file3 = new File(f.a(context, key));
                if (file3.exists()) {
                    file3.delete();
                }
                sharedPreferences.edit().remove(key).apply();
            }
        }
    }

    public static void a(final Context context, final b bVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (a.class) {
                        if (a.a(context, "d41d8cd98f00b204e9800998ecf8427e") && f.a(f.b(context, "d41d8cd98f00b204e9800998ecf8427e"))) {
                            com.opos.cmn.an.f.a.b("LoadSoUtils", "SO already exist: d41d8cd98f00b204e9800998ecf8427e");
                            a.b(bVar, f.b(context, "d41d8cd98f00b204e9800998ecf8427e"));
                            return;
                        }
                        Context context2 = context;
                        String strB = a.b(context2, "https://ocs-cn-south1.heytapcs.com/ads-union/union/tblso/d41d8cd98f00b204e9800998ecf8427e.zip", f.a(context2, "d41d8cd98f00b204e9800998ecf8427e"), bVar);
                        String strB2 = f.b(context, "d41d8cd98f00b204e9800998ecf8427e");
                        if (a.b(strB, strB2, bVar)) {
                            if (!new File(strB).delete()) {
                                com.opos.cmn.an.f.a.c("LoadSoUtils", "临时文件删除失败: " + strB);
                            }
                            synchronized (a.class) {
                                a.a(context, "d41d8cd98f00b204e9800998ecf8427e", true);
                                a.c(context, "d41d8cd98f00b204e9800998ecf8427e");
                            }
                            a.b(bVar, strB2);
                        }
                    }
                } catch (Exception unused) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        a.b(bVar2, 0, ErrorCode.ERROR_MSG_UNKNOWN_ERROR);
                    }
                }
            }
        });
    }

    public static void a(Context context, String str, boolean z) {
        context.getSharedPreferences("TBL_So_MD5", 0).edit().putBoolean(str, z).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final b bVar, final int i, final String str) {
        if (bVar == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.cmn.func.b.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                bVar.a(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final b bVar, final String str) {
        if (bVar == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.cmn.func.b.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                bVar.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2, b bVar) {
        try {
            if (!e.a(str, str2)) {
                b(bVar, 2, "解压失败");
                return false;
            }
            if (f.a(str2)) {
                com.opos.cmn.an.f.a.b("LoadSoUtils", "verifyUnzip suc");
                return true;
            }
            f.b(str);
            f.b(new File(str2));
            b(bVar, 3, "校验失败");
            return false;
        } catch (Exception unused) {
            f.b(str);
            f.b(new File(str2));
            b(bVar, 0, "解压校验异常");
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        return context.getSharedPreferences("TBL_So_MD5", 0).getBoolean(str, false);
    }
}
