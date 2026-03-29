package defpackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import defpackage.v45;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gk6 implements os1 {
    public static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17743a;
    public final jy5 b;
    public qs1 d;
    public int f;
    public final gc4 c = new gc4();
    public byte[] e = new byte[1024];

    public gk6(@Nullable String str, jy5 jy5Var) {
        this.f17743a = str;
        this.b = jy5Var;
    }

    public final c06 a(long j) {
        c06 c06VarTrack = this.d.track(0, 3);
        c06VarTrack.b(new m.b().g0("text/vtt").X(this.f17743a).k0(j).G());
        this.d.endTracks();
        return c06VarTrack;
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.d = qs1Var;
        qs1Var.d(new v45.b(-9223372036854775807L));
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        vh.e(this.d);
        int length = (int) ps1Var.getLength();
        int i = this.f;
        byte[] bArr = this.e;
        if (i == bArr.length) {
            this.e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i2 = this.f;
        int i3 = ps1Var.read(bArr2, i2, bArr2.length - i2);
        if (i3 != -1) {
            int i4 = this.f + i3;
            this.f = i4;
            if (length == -1 || i4 != length) {
                return 0;
            }
        }
        e();
        return -1;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        ps1Var.peekFully(this.e, 0, 6, false);
        this.c.S(this.e, 6);
        if (hk6.b(this.c)) {
            return true;
        }
        ps1Var.peekFully(this.e, 6, 3, false);
        this.c.S(this.e, 9);
        return hk6.b(this.c);
    }

    public final void e() throws ParserException {
        gc4 gc4Var = new gc4(this.e);
        hk6.e(gc4Var);
        long jG = 0;
        long jD = 0;
        for (String strS = gc4Var.s(); !TextUtils.isEmpty(strS); strS = gc4Var.s()) {
            if (strS.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = g.matcher(strS);
                if (!matcher.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strS, null);
                }
                Matcher matcher2 = h.matcher(strS);
                if (!matcher2.find()) {
                    throw ParserException.createForMalformedContainer("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strS, null);
                }
                jD = hk6.d((String) vh.e(matcher.group(1)));
                jG = jy5.g(Long.parseLong((String) vh.e(matcher2.group(1))));
            }
        }
        Matcher matcherA = hk6.a(gc4Var);
        if (matcherA == null) {
            a(0L);
            return;
        }
        long jD2 = hk6.d((String) vh.e(matcherA.group(1)));
        long jB = this.b.b(jy5.k((jG + jD2) - jD));
        c06 c06VarA = a(jB - jD2);
        this.c.S(this.e, this.f);
        c06VarA.d(this.c, this.f);
        c06VarA.e(jB, 1, this.f, 0, null);
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // defpackage.os1
    public void release() {
    }
}
