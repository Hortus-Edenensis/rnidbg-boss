package defpackage;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cv4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pw2 f16924a;
    public ByteBuffer b;
    public int c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public cv4(pw2 pw2Var, ByteBuffer byteBuffer) {
        this.f16924a = pw2Var;
        if (byteBuffer == null) {
            k63.l("RegisterResponse", "No body to parse.");
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
            k63.c("RegisterResponse", "Response error - code:" + this.c);
        }
        ByteBuffer byteBuffer = this.b;
        int i = this.c;
        if (i == 0) {
            try {
                this.d = byteBuffer.getLong();
                this.e = cw2.d(byteBuffer);
                this.f = cw2.d(byteBuffer);
                return;
            } catch (Throwable unused2) {
                this.c = 10000;
                return;
            }
        }
        if (i == 1007) {
            try {
                this.h = cw2.d(byteBuffer);
            } catch (Throwable unused3) {
                this.c = 10000;
            }
        } else if (i == 1012) {
            try {
                this.i = cw2.d(byteBuffer);
            } catch (Throwable unused4) {
                this.c = 10000;
            }
            ui2.a(JCoreManager.getAppContext(null), this.i);
        }
    }

    public String toString() {
        return "[RegisterResponse] - code:" + this.c + ", juid:" + this.d + ", password:" + this.e + ", regId:" + this.f + ", deviceId:" + this.g + ", connectInfo:" + this.i;
    }
}
