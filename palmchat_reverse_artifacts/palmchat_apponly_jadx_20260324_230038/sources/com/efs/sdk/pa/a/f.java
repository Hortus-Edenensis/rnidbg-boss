package com.efs.sdk.pa.a;

import android.util.Log;
import com.efs.sdk.pa.PAMsgListener;
import java.io.BufferedOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    PAMsgListener f5650a;
    boolean b;
    String c;
    BufferedOutputStream d;

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.efs.sdk.pa.b b(String str, long j, long j2) {
        String strSubstring;
        int i;
        String strSubstring2;
        int iLastIndexOf;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        com.efs.sdk.pa.b bVar = new com.efs.sdk.pa.b();
        try {
            int iIndexOf = str.indexOf(":");
            String strSubstring3 = "";
            if (iIndexOf != -1) {
                int i4 = iIndexOf + 2;
                strSubstring = i4 < str.length() ? str.substring(i4, str.length()) : "";
            }
            bVar.f5653a = strSubstring;
            if (str.contains("(") && str.contains(")")) {
                int iIndexOf2 = str.indexOf("(");
                int iIndexOf3 = str.indexOf(")");
                if (iIndexOf2 != -1 && iIndexOf3 != -1 && (i3 = iIndexOf2 + 1) < str.length() && iIndexOf3 > i3) {
                    strSubstring2 = str.substring(i3, iIndexOf3);
                }
            } else if (str.contains("{") && str.contains("}")) {
                int iIndexOf4 = str.indexOf("{");
                int iIndexOf5 = str.indexOf("}");
                if (iIndexOf4 != -1 && iIndexOf5 != -1 && (i = iIndexOf4 + 1) < str.length() && iIndexOf5 > i) {
                    strSubstring2 = str.substring(i, iIndexOf5);
                }
            } else {
                strSubstring2 = "";
            }
            bVar.b = strSubstring2;
            if (!str.contains(com.igexin.push.core.b.m) && str.contains("}") && (iLastIndexOf = str.lastIndexOf("}")) != -1 && (i2 = iLastIndexOf + 1) < str.length()) {
                strSubstring3 = str.substring(i2, str.length());
            }
            bVar.c = strSubstring3;
            bVar.d = j;
            bVar.e = j2;
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(String str, long j, long j2) {
        com.efs.sdk.pa.b bVarB = b(str, j, j2);
        if (bVarB != null) {
            if (this.b) {
                Log.e("PerformanceAnalyze", bVarB.toString());
            }
            if (this.c != null) {
                try {
                    this.d.write((bVarB.toString() + "\n").getBytes());
                } catch (Exception unused) {
                }
            }
            this.f5650a.msg(bVarB);
        }
    }
}
