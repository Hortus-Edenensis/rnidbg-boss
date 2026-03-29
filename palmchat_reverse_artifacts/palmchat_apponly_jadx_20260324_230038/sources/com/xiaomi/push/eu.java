package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.dp;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class eu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ey f412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private OutputStream f413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f416a;
    private int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    ByteBuffer f414a = ByteBuffer.allocate(2048);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private ByteBuffer f417b = ByteBuffer.allocate(4);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Adler32 f415a = new Adler32();

    public eu(OutputStream outputStream, ey eyVar) {
        this.f413a = new BufferedOutputStream(outputStream);
        this.f412a = eyVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f11554a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(er erVar) throws IOException {
        int iC = erVar.c();
        if (iC > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Blob size=" + iC + " should be less than 32768 Drop blob chid=" + erVar.a() + " id=" + erVar.e());
            return 0;
        }
        this.f414a.clear();
        int i = iC + 8 + 4;
        if (i > this.f414a.capacity() || this.f414a.capacity() > 4096) {
            this.f414a = ByteBuffer.allocate(i);
        }
        this.f414a.putShort((short) -15618);
        this.f414a.putShort((short) 5);
        this.f414a.putInt(iC);
        int iPosition = this.f414a.position();
        this.f414a = erVar.mo415a(this.f414a);
        if (!"CONN".equals(erVar.m414a())) {
            if (this.f416a == null) {
                this.f416a = this.f412a.m432a();
            }
            com.xiaomi.push.service.ar.a(this.f416a, this.f414a.array(), true, iPosition, iC);
        }
        this.f415a.reset();
        this.f415a.update(this.f414a.array(), 0, this.f414a.position());
        this.f417b.putInt(0, (int) this.f415a.getValue());
        this.f413a.write(this.f414a.array(), 0, this.f414a.position());
        this.f413a.write(this.f417b.array(), 0, 4);
        this.f413a.flush();
        int iPosition2 = this.f414a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + erVar.m414a() + ";chid=" + erVar.a() + ";len=" + iPosition2 + "}");
        return iPosition2;
    }

    public void b() throws IOException {
        er erVar = new er();
        erVar.a("CLOSE", (String) null);
        a(erVar);
        this.f413a.close();
    }

    public void a() throws IOException {
        dp.e eVar = new dp.e();
        eVar.a(106);
        eVar.a(k.a());
        eVar.b(C1401r.m661a());
        eVar.c(com.xiaomi.push.service.ax.m729a());
        eVar.b(48);
        eVar.d(this.f412a.m440b());
        eVar.e(this.f412a.mo438a());
        eVar.f(Locale.getDefault().toString());
        int i = Build.VERSION.SDK_INT;
        eVar.c(i);
        eVar.d(g.a(this.f412a.a(), "com.xiaomi.xmsf"));
        byte[] bArrMo446a = this.f412a.m437a().mo446a();
        if (bArrMo446a != null) {
            eVar.a(dp.b.a(bArrMo446a));
        }
        er erVar = new er();
        erVar.a(0);
        erVar.a("CONN", (String) null);
        erVar.a(0L, "xiaomi.com", null);
        erVar.a(eVar.m398a(), (String) null);
        a(erVar);
        com.xiaomi.channel.commonutils.logger.b.m74a("[slim] open conn: andver=" + i + " sdk=48 tz=" + this.f11554a + ":" + this.b + " Model=" + k.a() + " os=" + Build.VERSION.INCREMENTAL);
    }
}
