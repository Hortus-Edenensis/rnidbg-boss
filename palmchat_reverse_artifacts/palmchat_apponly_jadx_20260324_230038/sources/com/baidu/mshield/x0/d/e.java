package com.baidu.mshield.x0.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.x0.EngineImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static String a(Context context) {
        return EngineImpl.getInstance(context).getPropertyByType("arid");
    }

    public static String b(Context context) {
        try {
            com.baidu.mshield.x0.l.c cVar = new com.baidu.mshield.x0.l.c(context);
            String strF = cVar.f();
            if (!TextUtils.isEmpty(strF)) {
                return strF;
            }
            if (Build.VERSION.SDK_INT > 25) {
                return "";
            }
            String strA = a(context);
            if (TextUtils.isEmpty("") && TextUtils.isEmpty(strA)) {
                return "";
            }
            byte[] bytes = (":" + strA).getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 246);
            }
            String strC = com.baidu.mshield.b.f.e.c(bytes);
            if (TextUtils.isEmpty(strC)) {
                return "";
            }
            cVar.f(strC);
            return strC;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
