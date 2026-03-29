package com.unicom.xiaowo.account.shield.c;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11188a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static DexClassLoader e;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append(new String(f.a("LnVuaWFjY291bnQ=")));
        sb.append(str);
        f11188a = sb.toString();
        b = new String(f.a("dW5pYWNjb3VudC5qYXI="));
        c = new String(f.a("dW5pY29tX3VwZGF0ZQ==")) + str + new String(f.a("dW5pYWNjb3VudF9jbGFzc2V6Lmphcg=="));
        d = new String(f.a("dW5pYWNjb3VudF9jbGFzc2V6Lmphcg=="));
        e = null;
    }

    public static DexClassLoader a() {
        return e;
    }

    public static void b(Context context, byte[] bArr) throws Throwable {
        try {
            File file = new File(e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String strC = c(context);
            File file2 = new File(strC);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            a.a(bArr, strC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c(Context context) {
        return e(context) + b;
    }

    public static InputStream d(Context context) {
        try {
            File file = new File(e(context) + c);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String e(Context context) {
        return context.getFilesDir().getParent() + f11188a;
    }

    public static DexClassLoader a(DexClassLoader dexClassLoader) {
        e = dexClassLoader;
        return dexClassLoader;
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            return a.a(inputStream);
        } catch (Exception unused) {
            return null;
        }
    }

    public static DexClassLoader a(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(e(context));
            sb.append("optdex");
            String string = sb.toString();
            File file = new File(string);
            if (!file.exists()) {
                file.mkdirs();
            }
            DexClassLoader dexClassLoader = new DexClassLoader(str, string, null, context.getClassLoader());
            e = dexClassLoader;
            return dexClassLoader;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, byte[] bArr) throws Throwable {
        try {
            int length = bArr.length - 16;
            int i = (length >> 2) << 2;
            byte[] bArr2 = new byte[i];
            byte[] bArr3 = new byte[length];
            for (int i2 = 0; i2 < i; i2++) {
                bArr2[i2] = bArr[i2 + 16];
            }
            for (int i3 = 0; i3 < length; i3++) {
                bArr3[i3] = bArr[i3 + 16];
            }
            byte[] bArrA = f.a(bArr2);
            for (int i4 = 0; i4 < i; i4++) {
                bArr3[i4] = bArrA[i4];
            }
            File file = new File(e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String strC = c(context);
            File file2 = new File(strC);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            a.a(bArr3, strC);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void b(Context context) {
        try {
            a.a(new File(context.getFilesDir() + c));
        } catch (Exception unused) {
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            byte[] bArr2 = new byte[15];
            for (int i = 0; i < 15; i++) {
                bArr2[i] = bArr[i];
            }
            return new String(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void a(Context context) {
        try {
            a.a(new File(c(context)));
        } catch (Exception unused) {
        }
    }
}
