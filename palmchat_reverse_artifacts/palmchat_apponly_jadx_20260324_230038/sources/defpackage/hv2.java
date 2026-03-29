package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hv2 {
    public static boolean a(Context context, byte[] bArr) {
        try {
            Pair<pw2, ByteBuffer> pairB = b(context, bArr, "");
            if (pairB == null) {
                return false;
            }
            long jN = fv2.n(context);
            long j = ((pw2) pairB.first).g;
            k63.a("JCommands", "uid:" + jN + ",msgUid:" + j + ",cmd:" + ((pw2) pairB.first).c);
            if (jN == 0 || j == 0 || jN == j) {
                zd1.e().c(context, (pw2) pairB.first, (ByteBuffer) pairB.second);
                return true;
            }
            k63.a("JCommands", "recv other app msg");
            o75.m().f(context, j, bArr);
            return true;
        } catch (Throwable th) {
            k63.n("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }

    public static Pair<pw2, ByteBuffer> b(Context context, byte[] bArr, String str) {
        ByteBuffer byteBufferWrap;
        if (bArr.length < 20) {
            k63.n("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        pw2 pw2Var = new pw2(false, bArr2);
        k63.a("JCommands", "parsed head - " + pw2Var.toString());
        int i = pw2Var.f20119a - 20;
        if (i < 0) {
            k63.n("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        k63.j("JCommands", "body size:" + i);
        if (TextUtils.isEmpty(str)) {
            str = cw2.a(context);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 20, bArr3, 0, i);
        k63.a("JCommands", "decode algorithm:" + ((int) pw2Var.d) + ", pwd:" + str);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i);
            byteBufferWrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                byteBufferWrap = ByteBuffer.wrap(pw2Var.d == 2 ? new c05().h(bArr3, str) : n45.a(bArr3, str, str.substring(0, 16), false));
            } catch (Exception e) {
                k63.a("JCommands", "decryptBytes error:" + e.getMessage());
                return null;
            }
        }
        return new Pair<>(pw2Var, byteBufferWrap);
    }
}
