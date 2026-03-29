package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class er {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int f400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private dp.a f401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f403a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f404b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f405b;
    private static String b = fx.a(5) + "-";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11551a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f399a = new byte[0];

    public er() {
        this.f403a = (short) 2;
        this.f405b = f399a;
        this.f402a = null;
        this.f404b = System.currentTimeMillis();
        this.f401a = new dp.a();
        this.f400a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(b);
        long j = f11551a;
        f11551a = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m413a() {
        return this.f404b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m421b() {
        return this.f401a.m315d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m424c() {
        return this.f401a.m319f();
    }

    public String e() {
        String strM317e = this.f401a.m317e();
        if ("ID_NOT_AVAILABLE".equals(strM317e)) {
            return null;
        }
        if (this.f401a.g()) {
            return strM317e;
        }
        String strD = d();
        this.f401a.e(strD);
        return strD;
    }

    public String f() {
        return this.f402a;
    }

    public String g() {
        if (!this.f401a.m311b()) {
            return null;
        }
        return Long.toString(this.f401a.m305a()) + "@" + this.f401a.m307a() + "/" + this.f401a.m310b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m414a() + "; type=" + ((int) m416a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f401a.c(str);
        this.f401a.m306a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f401a.d(str2);
    }

    public int b() {
        return this.f401a.f();
    }

    public void c(long j) {
        this.f401a.c(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m422b() {
        return this.f401a.l();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m423c() {
        return this.f401a.m305a();
    }

    public void b(long j) {
        this.f401a.b(j);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f401a.a(j);
            this.f401a.a(strSubstring);
            this.f401a.b(strSubstring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Blob parse user err " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m420b() {
        return this.f401a.m309b();
    }

    public void b(String str) {
        this.f402a = str;
    }

    public er(dp.a aVar, short s, byte[] bArr) {
        this.f403a = (short) 2;
        this.f405b = f399a;
        this.f402a = null;
        this.f404b = System.currentTimeMillis();
        this.f401a = aVar;
        this.f403a = s;
        this.f405b = bArr;
        this.f400a = 2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m414a() {
        return this.f401a.m313c();
    }

    public void a(int i) {
        this.f401a.a(i);
    }

    public int a() {
        return this.f401a.c();
    }

    public void a(String str) {
        this.f401a.e(str);
    }

    public void a(long j) {
        this.f401a.a(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m417a() {
        return this.f401a.j();
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f401a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f401a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f401a.b(str2);
    }

    public int c() {
        return this.f401a.b() + 8 + this.f405b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f401a.c(1);
            this.f405b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f401a.c(0);
            this.f405b = bArr;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m418a() {
        return es.a(this, this.f405b);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m419a(String str) {
        if (this.f401a.e() == 1) {
            return es.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f405b));
        }
        if (this.f401a.e() == 0) {
            return es.a(this, this.f405b);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("unknow cipher = " + this.f401a.e());
        return es.a(this, this.f405b);
    }

    @Deprecated
    public static er a(fo foVar, String str) {
        int i;
        er erVar = new er();
        try {
            i = Integer.parseInt(foVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        erVar.a(i);
        erVar.a(foVar.j());
        erVar.c(foVar.m());
        erVar.b(foVar.n());
        erVar.a("XMLMSG", (String) null);
        try {
            erVar.a(foVar.mo455a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                erVar.a((short) 3);
            } else {
                erVar.a((short) 2);
                erVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Blob setPayload err： " + e2.getMessage());
        }
        return erVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo415a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f403a);
        byteBuffer.putShort((short) this.f401a.a());
        byteBuffer.putInt(this.f405b.length);
        int iPosition = byteBuffer.position();
        this.f401a.m397a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f401a.a());
        byteBuffer.position(iPosition + this.f401a.a());
        byteBuffer.put(this.f405b);
        return byteBuffer;
    }

    public static er a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s = byteBufferSlice.getShort(0);
            short s2 = byteBufferSlice.getShort(2);
            int i = byteBufferSlice.getInt(4);
            dp.a aVar = new dp.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            byteBufferSlice.position(s2 + 8);
            byteBufferSlice.get(bArr, 0, i);
            return new er(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short m416a() {
        return this.f403a;
    }

    public void a(short s) {
        this.f403a = s;
    }
}
