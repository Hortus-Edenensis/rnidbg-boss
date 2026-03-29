package com.bytedance.pangle.res.u;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final Logger iz = Logger.getLogger(u.class.getName());
    private final pn b;
    private final x fx;
    private final n nr;
    private C0199u pn;
    private final byte[] u;

    /* JADX INFO: renamed from: com.bytedance.pangle.res.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0199u {
        public final int b;
        public final int fx;
        public final int nr;
        public final int pn;
        public final short u;

        public C0199u(short s, int i, int i2, int i3) {
            this.u = s;
            this.nr = i;
            this.fx = i2;
            this.b = i3;
            this.pn = i3 + i2;
        }

        public static C0199u u(x xVar, pn pnVar) throws IOException {
            int iU = pnVar.u();
            try {
                return new C0199u(xVar.readShort(), xVar.readShort(), xVar.readInt(), iU);
            } catch (EOFException unused) {
                return new C0199u((short) -1, 0, 0, pnVar.u());
            }
        }
    }

    public u(byte[] bArr, n nVar) {
        pn pnVar = new pn(new ByteArrayInputStream(bArr));
        this.b = pnVar;
        this.fx = new x(new a(pnVar));
        this.u = bArr;
        this.nr = nVar;
    }

    private void a() throws IOException {
        this.fx.u((short) 8);
        this.fx.u((byte) 0);
        byte b = this.fx.readByte();
        int iU = t.u(this.fx);
        int i = this.fx.readInt();
        if (b == 1) {
            t.u(this.u, i, iU, this.nr);
        }
        if (b == 2) {
            t.u(this.u, i, iU, this.nr);
        }
    }

    private void b() throws IOException {
        pn();
        short s = t().u;
        while (s == 514) {
            pn();
            s = t().u;
        }
        while (s == 513) {
            iz();
            if (this.b.u() < this.pn.pn) {
                iz.warning("Unknown data detected. Skipping: " + (this.pn.pn - this.b.u()) + " byte(s)");
                pn pnVar = this.b;
                pnVar.skip((long) (this.pn.pn - pnVar.u()));
            }
            s = t().u;
        }
    }

    private void fx() throws IOException {
        nr(515);
        int i = this.fx.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.fx.readInt();
            this.fx.skipBytes(256);
        }
        while (t().u == 513) {
            b();
        }
    }

    private void iz() throws IOException {
        nr(513);
        this.fx.readUnsignedByte();
        this.fx.readByte();
        this.fx.skipBytes(2);
        int i = this.fx.readInt();
        int i2 = this.fx.readInt();
        jk();
        int i3 = (this.pn.b + i2) - (i * 4);
        if (i3 != this.b.u()) {
            iz.warning("Invalid data detected. Skipping: " + (i3 - this.b.u()) + " byte(s)");
            this.fx.skipBytes(i3 - this.b.u());
        }
        int[] iArrU = this.fx.u(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrU) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                x();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void jk() throws IOException {
        int i = this.fx.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.fx.readShort();
        this.fx.readShort();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readUnsignedShort();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.readByte();
        this.fx.skipBytes(1);
        this.fx.readShort();
        this.fx.readShort();
        this.fx.readShort();
        this.fx.skipBytes(2);
        if (i >= 32) {
            this.fx.readByte();
            this.fx.readByte();
            this.fx.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.fx.readShort();
            this.fx.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            u(4).toCharArray();
            u(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.fx.readByte();
            this.fx.readByte();
            this.fx.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.fx.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.fx.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                iz.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                iz.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.fx.skipBytes(i4);
        }
    }

    private void n() throws IOException {
        int iU = t.u(this.fx);
        t.u(this.u, this.fx.readInt(), iU, this.nr);
        int i = this.fx.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iU2 = t.u(this.fx);
            t.u(this.u, this.fx.readInt(), iU2, this.nr);
            a();
        }
    }

    private void nr() throws IOException {
        nr(512);
        this.fx.readInt();
        this.fx.skipBytes(256);
        this.fx.u();
        this.fx.u();
        this.fx.u();
        this.fx.u();
        if (this.pn.nr == 288 && this.fx.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        l.u(this.fx);
        l.u(this.fx);
        t();
        boolean z = true;
        while (z) {
            short s = this.pn.u;
            if (s == 514) {
                b();
            } else if (s != 515) {
                z = false;
            } else {
                fx();
            }
        }
    }

    private void pn() throws IOException {
        nr(514);
        this.fx.readUnsignedByte();
        this.fx.skipBytes(3);
        this.fx.skipBytes(this.fx.readInt() * 4);
    }

    private C0199u t() throws IOException {
        C0199u c0199uU = C0199u.u(this.fx, this.b);
        this.pn = c0199uU;
        return c0199uU;
    }

    private void x() throws IOException {
        if (this.fx.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.fx.readShort();
        this.fx.readInt();
        if ((s & 1) == 0) {
            a();
        } else {
            n();
        }
    }

    public void u() throws IOException {
        fx(2);
        int i = this.fx.readInt();
        l.u(this.fx);
        t();
        for (int i2 = 0; i2 < i; i2++) {
            nr();
        }
    }

    private String u(int i) throws IOException {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.fx.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.fx.skipBytes(i2);
        return sb.toString();
    }

    private void fx(int i) throws IOException {
        t();
        nr(i);
    }

    private void nr(int i) {
        if (this.pn.u != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.pn.u)));
        }
    }
}
