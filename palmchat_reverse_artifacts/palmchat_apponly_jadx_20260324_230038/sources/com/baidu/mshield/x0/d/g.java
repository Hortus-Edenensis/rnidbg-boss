package com.baidu.mshield.x0.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4059a = "";

    public static String b(Context context) {
        if (TextUtils.isEmpty(f4059a)) {
            f4059a = new g().f(context);
        }
        return f4059a;
    }

    public String a(Context context) {
        String strA = e.a(context);
        if (TextUtils.isEmpty("") && TextUtils.isEmpty(strA)) {
            return "1|" + com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());
        }
        return "0|" + com.baidu.mshield.b.f.e.a("" + strA);
    }

    public String c(Context context) {
        try {
            com.baidu.mshield.x0.l.c cVar = new com.baidu.mshield.x0.l.c(context);
            String strC = cVar.c();
            if (!TextUtils.isEmpty(strC)) {
                return strC;
            }
            String strB = cVar.b();
            if (TextUtils.isEmpty(strB)) {
                return "";
            }
            cVar.b(strB);
            return strB;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String d(Context context) {
        try {
        } catch (Throwable th) {
            d.a(th);
        }
        if (!a(context, com.kuaishou.weapon.p0.g.i)) {
            return "";
        }
        if (!com.baidu.sec.privacy.f.c.d(context)) {
            com.baidu.mshield.b.c.a.a("getNewUidBySdCard isCanRequestNetBackground=false");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append(".zp");
        sb.append(str);
        sb.append(".icosc");
        File fileA = com.baidu.mshield.b.e.a.a(context, sb.toString());
        if (fileA.exists()) {
            return a(fileA);
        }
        return "";
    }

    public String e(Context context) {
        try {
            return b(context, "com.q.zi.i");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f(Context context) {
        boolean z;
        boolean z2;
        String strC = c(context);
        boolean z3 = false;
        if (TextUtils.isEmpty(strC)) {
            strC = e(context);
            z2 = true;
            if (TextUtils.isEmpty(strC)) {
                strC = d(context);
                if (TextUtils.isEmpty(strC)) {
                    strC = a(context);
                    z = true;
                } else {
                    z = false;
                }
                z3 = true;
                if (!z3 || TextUtils.isEmpty(c(context))) {
                    new com.baidu.mshield.x0.l.c(context).a(strC);
                }
                if (!z2 || TextUtils.isEmpty(e(context))) {
                    a(context, "com.q.zi.i", strC);
                }
                if (a(context, com.kuaishou.weapon.p0.g.j) && (z || TextUtils.isEmpty(d(context)))) {
                    c(context, strC);
                }
                return strC;
            }
            z = false;
            z3 = true;
        } else {
            z = false;
        }
        z2 = false;
        if (!z3) {
            new com.baidu.mshield.x0.l.c(context).a(strC);
        }
        if (!z2) {
            a(context, "com.q.zi.i", strC);
        }
        if (a(context, com.kuaishou.weapon.p0.g.j)) {
            c(context, strC);
        }
        return strC;
    }

    public final String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int i = fileReader.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, i);
                }
                String string = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    d.a(th);
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                try {
                    d.a(th);
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            d.a(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public final String b(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.a.d(context, str);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public final void c(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            if (!com.baidu.mshield.b.e.a.d(context)) {
                com.baidu.mshield.b.c.a.a("tryPutExternalStorageValue isCanRequestNetBackground=false");
                return;
            }
            File fileA = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + ".zp");
            File file = new File(fileA, ".icosc");
            if (fileA.exists()) {
                if (!fileA.isDirectory()) {
                    fileA.delete();
                    fileA.mkdirs();
                }
            } else {
                fileA.mkdirs();
            }
            fileWriter = new FileWriter(file, false);
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    d.a(th);
                    if (fileWriter == null) {
                    } else {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable th5) {
                            d.a(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            d.a(th6);
        }
    }

    public final boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public final boolean a(Context context, String str, String str2) {
        try {
            com.baidu.mshield.b.e.a.a(context, str, str2);
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}
