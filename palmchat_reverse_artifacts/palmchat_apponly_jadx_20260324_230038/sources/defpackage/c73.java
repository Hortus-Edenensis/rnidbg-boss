package defpackage;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c73 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pw2 f1911a;
    public ByteBuffer b;
    public int c;
    public int d;
    public int e;
    public String f;
    public int g;
    public int h;
    public String i;

    public c73(pw2 pw2Var, ByteBuffer byteBuffer) {
        this.f1911a = pw2Var;
        if (byteBuffer == null) {
            k63.l("LoginResponse", "No body to parse.");
        } else {
            this.b = byteBuffer;
            a();
        }
    }

    public final void a() {
        try {
            this.c = this.b.getShort();
        } catch (Throwable unused) {
            this.c = 10000;
        }
        if (this.c > 0) {
            k63.c("LoginResponse", "Response error - code:" + this.c);
        }
        ByteBuffer byteBuffer = this.b;
        this.h = -1;
        int i = this.c;
        if (i != 0) {
            if (i == 1012) {
                try {
                    this.i = cw2.d(byteBuffer);
                } catch (Throwable unused2) {
                    this.c = 10000;
                }
                ui2.a(JCoreManager.getAppContext(null), this.i);
                return;
            }
            return;
        }
        try {
            this.d = byteBuffer.getInt();
            this.e = byteBuffer.getShort();
            this.f = cw2.d(byteBuffer);
            this.g = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.c = 10000;
        }
        try {
            this.h = byteBuffer.get();
            k63.a("LoginResponse", "idc parse success, value:" + this.h);
        } catch (Throwable th) {
            k63.l("LoginResponse", "parse idc failed, error:" + th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.c + ",sid:" + this.d + ", serverVersion:" + this.e + ", sessionKey:" + this.f + ", serverTime:" + this.g + ", idc:" + this.h + ", connectInfo:" + this.i;
    }
}
