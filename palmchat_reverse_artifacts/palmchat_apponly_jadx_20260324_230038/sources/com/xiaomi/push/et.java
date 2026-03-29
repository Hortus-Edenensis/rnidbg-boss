package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class et {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ey f406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private InputStream f407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ByteBuffer f408a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Adler32 f409a = new Adler32();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ew f11553a = new ew();

    public et(InputStream inputStream, ey eyVar) {
        this.f407a = new BufferedInputStream(inputStream);
        this.f406a = eyVar;
    }

    private void c() throws IOException {
        boolean z = false;
        this.f410a = false;
        er erVarM425a = m425a();
        if ("CONN".equals(erVarM425a.m414a())) {
            dp.f fVarA = dp.f.a(erVarM425a.m418a());
            if (fVarA.m356a()) {
                this.f406a.a(fVarA.m355a());
                z = true;
            }
            if (fVarA.c()) {
                dp.b bVarM354a = fVarA.m354a();
                er erVar = new er();
                erVar.a("SYNC", "CONF");
                erVar.a(bVarM354a.m398a(), (String) null);
                this.f406a.a(erVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] CONN: host = " + fVarA.m357b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f411a = this.f406a.m432a();
        while (!this.f410a) {
            er erVarM425a2 = m425a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f406a.c();
            short sM416a = erVarM425a2.m416a();
            if (sM416a == 1) {
                this.f406a.a(erVarM425a2);
            } else if (sM416a != 2) {
                if (sM416a != 3) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] unknow blob type " + ((int) erVarM425a2.m416a()));
                } else {
                    try {
                        this.f406a.b(this.f11553a.a(erVarM425a2.m418a(), this.f406a));
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] Parse packet from Blob chid=" + erVarM425a2.a() + "; Id=" + erVarM425a2.e() + " failure:" + e.getMessage());
                    }
                }
            } else if ("SECMSG".equals(erVarM425a2.m414a()) && ((erVarM425a2.a() == 2 || erVarM425a2.a() == 3) && TextUtils.isEmpty(erVarM425a2.m421b()))) {
                try {
                    fo foVarA = this.f11553a.a(erVarM425a2.m419a(com.xiaomi.push.service.am.a().a(Integer.valueOf(erVarM425a2.a()).toString(), erVarM425a2.g()).h), this.f406a);
                    foVarA.f467a = jCurrentTimeMillis;
                    this.f406a.b(foVarA);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("[Slim] Parse packet from Blob chid=" + erVarM425a2.a() + "; Id=" + erVarM425a2.e() + " failure:" + e2.getMessage());
                }
            } else {
                this.f406a.a(erVarM425a2);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m426a() throws IOException {
        try {
            c();
        } catch (IOException e) {
            if (!this.f410a) {
                throw e;
            }
        }
    }

    public void b() {
        this.f410a = true;
    }

    private ByteBuffer a() throws IOException {
        this.f408a.clear();
        a(this.f408a, 8);
        short s = this.f408a.getShort(0);
        short s2 = this.f408a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f408a.getInt(4);
            int iPosition = this.f408a.position();
            if (i <= 32768) {
                if (i + 4 > this.f408a.remaining()) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i + 2048);
                    byteBufferAllocate.put(this.f408a.array(), 0, this.f408a.arrayOffset() + this.f408a.position());
                    this.f408a = byteBufferAllocate;
                } else if (this.f408a.capacity() > 4096 && i < 2048) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2048);
                    byteBufferAllocate2.put(this.f408a.array(), 0, this.f408a.arrayOffset() + this.f408a.position());
                    this.f408a = byteBufferAllocate2;
                }
                a(this.f408a, i);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                int i2 = this.b.getInt();
                this.f409a.reset();
                this.f409a.update(this.f408a.array(), 0, this.f408a.position());
                if (i2 == ((int) this.f409a.getValue())) {
                    byte[] bArr = this.f411a;
                    if (bArr != null) {
                        com.xiaomi.push.service.ar.a(bArr, this.f408a.array(), true, iPosition, i);
                    }
                    return this.f408a;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("CRC = " + ((int) this.f409a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public er m425a() throws IOException {
        int iPosition;
        ByteBuffer byteBufferA;
        er erVarA;
        try {
            byteBufferA = a();
            iPosition = byteBufferA.position();
        } catch (IOException e) {
            e = e;
            iPosition = 0;
        }
        try {
            byteBufferA.flip();
            byteBufferA.position(8);
            if (iPosition == 8) {
                erVarA = new ex();
            } else {
                erVarA = er.a(byteBufferA.slice());
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + erVarA.m414a() + ";chid=" + erVarA.a() + ";len=" + iPosition + "}");
            return erVarA;
        } catch (IOException e2) {
            e = e2;
            if (iPosition == 0) {
                iPosition = this.f408a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] bArrArray = this.f408a.array();
            if (iPosition > 128) {
                iPosition = 128;
            }
            sb.append(ab.a(bArrArray, 0, iPosition));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
            throw e;
        }
    }

    private void a(ByteBuffer byteBuffer, int i) throws IOException {
        int iPosition = byteBuffer.position();
        do {
            int i2 = this.f407a.read(byteBuffer.array(), iPosition, i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i -= i2;
            iPosition += i2;
        } while (i > 0);
        byteBuffer.position(iPosition);
    }
}
