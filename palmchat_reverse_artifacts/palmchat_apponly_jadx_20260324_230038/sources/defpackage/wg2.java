package defpackage;

import java.io.IOException;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wg2 implements Cloneable {
    public static Random d = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21693a;
    public int b;
    public int[] c;

    public wg2(int i) {
        this.b = 256;
        g();
        h(i);
    }

    public int a(int i) {
        return this.c[i];
    }

    public int c() {
        return this.b;
    }

    public Object clone() {
        wg2 wg2Var = new wg2();
        wg2Var.f21693a = this.f21693a;
        wg2Var.b = this.b;
        int[] iArr = this.c;
        System.arraycopy(iArr, 0, wg2Var.c, 0, iArr.length);
        return wg2Var;
    }

    public int d() {
        int i;
        int i2 = this.f21693a;
        if (i2 >= 0) {
            return i2;
        }
        synchronized (this) {
            if (this.f21693a < 0) {
                this.f21693a = d.nextInt(65535);
            }
            i = this.f21693a;
        }
        return i;
    }

    public int e() {
        return this.b & 15;
    }

    public void f(int i) {
        int[] iArr = this.c;
        int i2 = iArr[i];
        if (i2 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = i2 + 1;
    }

    public final void g() {
        this.c = new int[4];
        this.b = 256;
        this.f21693a = -1;
    }

    public void h(int i) {
        if (i >= 0 && i <= 65535) {
            this.f21693a = i;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
    }

    public String i(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + d());
        stringBuffer.append("\n");
        stringBuffer.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append(k45.a(i2) + ": " + a(i2) + " ");
        }
        return stringBuffer.toString();
    }

    public void j(nt0 nt0Var) {
        nt0Var.h(d());
        nt0Var.h(this.b);
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return;
            }
            nt0Var.h(iArr[i]);
            i++;
        }
    }

    public String toString() {
        return i(e());
    }

    public wg2() {
        this.b = 256;
        g();
    }

    public wg2(lt0 lt0Var) throws IOException {
        this(lt0Var.e());
        this.b = lt0Var.e();
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = lt0Var.e();
            i++;
        }
    }
}
