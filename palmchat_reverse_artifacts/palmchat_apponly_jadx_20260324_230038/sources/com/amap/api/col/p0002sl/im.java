package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.hu;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class im {
    public static void a(Context context, ig igVar, String str, int i, int i2, String str2) {
        igVar.f2905a = hb.c(context, str);
        igVar.d = i;
        igVar.b = i2;
        igVar.c = str2;
    }

    public static ig a(WeakReference<ig> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ig());
        }
        return weakReference.get();
    }

    public static byte[] a(hu huVar, String str) {
        hu.b bVarA;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVarA = huVar.a(str);
            if (bVarA == null) {
                if (bVarA != null) {
                    try {
                        bVarA.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream inputStreamA = bVarA.a();
                if (inputStreamA == null) {
                    if (inputStreamA != null) {
                        try {
                            inputStreamA.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        bVarA.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[inputStreamA.available()];
                inputStreamA.read(bArr);
                try {
                    inputStreamA.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    bVarA.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    hd.c(th, "sui", "rdS");
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (bVarA != null) {
                        try {
                            bVarA.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    return bArr;
                } finally {
                }
            }
        } catch (Throwable th9) {
            th = th9;
            bVarA = null;
        }
    }

    public static String a() {
        return ge.a(System.currentTimeMillis());
    }

    public static String a(Context context, gd gdVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String strE = fv.e();
            sb.append("\"sim\":\"");
            sb.append(strE);
            sb.append("\",\"sdkversion\":\"");
            sb.append(gdVar.c());
            sb.append("\",\"product\":\"");
            sb.append(gdVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(gdVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(fv.c(context));
            sb.append("\",\"np\":\"");
            sb.append(fv.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(fv.d());
            sb.append("\",\"ant\":\"");
            sb.append(fv.d(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
