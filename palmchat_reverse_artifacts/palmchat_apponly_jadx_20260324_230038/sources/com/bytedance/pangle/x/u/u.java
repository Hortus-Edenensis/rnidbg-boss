package com.bytedance.pangle.x.u;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5073a;
    private int iz;
    private nr n;
    private iz t;
    private boolean x;
    private boolean jk = false;
    private final fx l = new fx();
    int u = 0;
    int nr = 1;
    int fx = 2;
    int b = 3;
    int pn = 4;

    public u() {
        b();
    }

    private int pn(int i) {
        if (this.iz != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.f5073a.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public String b(int i) {
        int iPn = pn(i);
        int[] iArr = this.f5073a;
        if (iArr[iPn + 3] != 3) {
            return "";
        }
        return this.t.u(iArr[iPn + 2]);
    }

    public int fx() {
        if (this.iz != 2) {
            return -1;
        }
        return this.f5073a.length / 5;
    }

    public int nr() throws IOException {
        try {
            if (this.n == null) {
                throw new IOException("Parser is not opened.");
            }
            pn();
            return this.iz;
        } catch (IOException e) {
            u();
            throw e;
        }
    }

    public void u(InputStream inputStream) {
        u();
        if (inputStream != null) {
            this.n = new nr(inputStream);
        }
    }

    public int fx(int i) {
        return this.f5073a[pn(i) + 4];
    }

    public void u() {
        if (this.jk) {
            this.jk = false;
            this.n.u();
            this.t = null;
            this.n = null;
            this.l.u();
            b();
        }
    }

    private void b() {
        this.f5073a = null;
        this.iz = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016d, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pn() throws IOException {
        if (this.t == null) {
            this.n.nr(524291);
            this.n.fx();
            this.t = iz.u(this.n);
            this.l.pn();
            this.jk = true;
        }
        int i = this.iz;
        if (i == this.nr) {
            return;
        }
        b();
        while (true) {
            if (this.x) {
                this.x = false;
                this.l.iz();
            }
            if (i == this.b && this.l.b() == 1 && this.l.nr() == 0) {
                this.iz = this.nr;
                return;
            }
            int iNr = i == this.u ? 1048834 : this.n.nr();
            if (iNr == 524672) {
                int iNr2 = this.n.nr();
                if (iNr2 < 8 || iNr2 % 4 != 0) {
                    break;
                } else {
                    this.n.u((iNr2 / 4) - 2);
                }
            } else {
                if (iNr < 1048832 || iNr > 1048836) {
                    break;
                }
                if (iNr == 1048834 && i == -1) {
                    this.iz = this.u;
                    return;
                }
                this.n.fx();
                this.n.nr();
                this.n.fx();
                if (iNr == 1048832 || iNr == 1048833) {
                    if (iNr == 1048832) {
                        this.l.u(this.n.nr(), this.n.nr());
                    } else {
                        this.n.fx();
                        this.n.fx();
                        this.l.fx();
                    }
                } else if (iNr == 1048834) {
                    this.n.nr();
                    this.n.nr();
                    this.n.fx();
                    int iNr3 = this.n.nr() & 65535;
                    this.n.nr();
                    this.f5073a = this.n.u(iNr3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.f5073a;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.l.pn();
                            this.iz = this.fx;
                            return;
                        }
                    }
                } else {
                    if (iNr == 1048835) {
                        this.n.nr();
                        this.n.nr();
                        this.iz = this.b;
                        this.x = true;
                        return;
                    }
                    if (iNr == 1048836) {
                        this.n.nr();
                        this.n.fx();
                        this.n.fx();
                        this.iz = this.pn;
                        return;
                    }
                }
            }
        }
    }

    public int nr(int i) {
        return this.f5073a[pn(i) + 3];
    }

    public String u(int i) {
        int i2 = this.f5073a[pn(i) + 1];
        return i2 == -1 ? "" : this.t.u(i2);
    }
}
