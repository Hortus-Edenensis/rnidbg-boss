package defpackage;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class pw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20119a;
    public int b;
    public int c;
    public byte d;
    public long e;
    public int f;
    public long g;
    public boolean h;

    public pw2(boolean z, byte[] bArr) {
        try {
            this.h = z;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f20119a = byteBufferWrap.getShort() & ShortCompanionObject.MAX_VALUE;
            this.b = byteBufferWrap.get();
            this.c = byteBufferWrap.get();
            this.d = byteBufferWrap.get();
            byteBufferWrap.get();
            byteBufferWrap.getInt();
            this.e = byteBufferWrap.getShort();
            if (z) {
                this.f = byteBufferWrap.getInt();
            }
            this.g = byteBufferWrap.getLong();
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f20119a);
        sb.append(", version:");
        sb.append(this.b);
        sb.append(", command:");
        sb.append(this.c);
        sb.append(", rid:");
        sb.append(this.e);
        if (this.h) {
            str = ", sid:" + this.f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.g);
        return sb.toString();
    }
}
