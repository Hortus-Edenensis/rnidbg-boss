package com.ss.android.socialbase.appdownloader.iz.u;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class u implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10597a;
    private iz b;
    private boolean fx = false;
    private C0856u iz = new C0856u();
    private int jk;
    private int k;
    private int[] l;
    private int mv;
    private int n;
    private b nr;
    private int[] pn;
    private int s;
    private int t;
    private boolean x;

    public u() {
        x();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n() throws IOException {
        if (this.b == null) {
            nr.u(this.nr, 524291);
            this.nr.fx();
            this.b = iz.u(this.nr);
            this.iz.pn();
            this.fx = true;
        }
        int i = this.n;
        if (i == 1) {
            return;
        }
        x();
        while (true) {
            if (this.x) {
                this.x = false;
                this.iz.iz();
            }
            int i2 = 3;
            if (i == 3 && this.iz.b() == 1 && this.iz.nr() == 0) {
                this.n = 1;
                return;
            }
            int iNr = i == 0 ? 1048834 : this.nr.nr();
            if (iNr == 524672) {
                int iNr2 = this.nr.nr();
                if (iNr2 < 8 || iNr2 % 4 != 0) {
                    break;
                } else {
                    this.pn = this.nr.nr((iNr2 / 4) - 2);
                }
            } else {
                if (iNr < 1048832 || iNr > 1048836) {
                    break;
                }
                if (iNr == 1048834 && i == -1) {
                    this.n = 0;
                    return;
                }
                this.nr.fx();
                int iNr3 = this.nr.nr();
                this.nr.fx();
                if (iNr != 1048832 && iNr != 1048833) {
                    this.f10597a = iNr3;
                    if (iNr == 1048834) {
                        this.t = this.nr.nr();
                        this.jk = this.nr.nr();
                        this.nr.fx();
                        int iNr4 = this.nr.nr();
                        this.mv = (iNr4 >>> 16) - 1;
                        int iNr5 = this.nr.nr();
                        this.k = (iNr5 >>> 16) - 1;
                        this.s = (65535 & iNr5) - 1;
                        this.l = this.nr.nr((iNr4 & 65535) * 5);
                        while (true) {
                            int[] iArr = this.l;
                            if (i2 >= iArr.length) {
                                this.iz.pn();
                                this.n = 2;
                                return;
                            } else {
                                iArr[i2] = iArr[i2] >>> 24;
                                i2 += 5;
                            }
                        }
                    } else {
                        if (iNr == 1048835) {
                            this.t = this.nr.nr();
                            this.jk = this.nr.nr();
                            this.n = 3;
                            this.x = true;
                            return;
                        }
                        if (iNr == 1048836) {
                            this.jk = this.nr.nr();
                            this.nr.fx();
                            this.nr.fx();
                            this.n = 4;
                            return;
                        }
                    }
                } else if (iNr == 1048832) {
                    this.iz.u(this.nr.nr(), this.nr.nr());
                } else {
                    this.nr.fx();
                    this.nr.fx();
                    this.iz.fx();
                }
            }
        }
    }

    private final void x() {
        this.n = -1;
        this.f10597a = -1;
        this.jk = -1;
        this.t = -1;
        this.l = null;
        this.mv = -1;
        this.s = -1;
        this.k = -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.iz.u.x
    public String b() {
        return "XML line #" + fx();
    }

    @Override // com.ss.android.socialbase.appdownloader.iz.u.x
    public int fx() {
        return this.f10597a;
    }

    @Override // com.ss.android.socialbase.appdownloader.iz.u.x
    public int iz() {
        return -1;
    }

    public int nr() throws n, IOException {
        if (this.nr == null) {
            throw new n("Parser is not opened.", this, null);
        }
        try {
            n();
            return this.n;
        } catch (IOException e) {
            u();
            throw e;
        }
    }

    public int pn() {
        if (this.n != 2) {
            return -1;
        }
        return this.l.length / 5;
    }

    public void u(InputStream inputStream) {
        u();
        if (inputStream != null) {
            this.nr = new b(inputStream, false);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.iz.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0856u {
        private int fx;
        private int nr;
        private int[] u = new int[32];

        public final int b() {
            return this.fx;
        }

        public final boolean fx() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.nr;
            if (i3 == 0 || (i2 = (iArr = this.u)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.nr = i3 - 2;
            return true;
        }

        public final void iz() {
            int i = this.nr;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.u[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.nr = i - (i3 + 2);
                    this.fx--;
                }
            }
        }

        public final int nr() {
            int i = this.nr;
            if (i == 0) {
                return 0;
            }
            return this.u[i - 1];
        }

        public final void pn() {
            u(2);
            int i = this.nr;
            int[] iArr = this.u;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.nr = i + 2;
            this.fx++;
        }

        public final void u() {
            this.nr = 0;
            this.fx = 0;
        }

        public final void u(int i, int i2) {
            if (this.fx == 0) {
                pn();
            }
            u(2);
            int i3 = this.nr;
            int i4 = i3 - 1;
            int[] iArr = this.u;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.nr = i3 + 2;
        }

        private void u(int i) {
            int[] iArr = this.u;
            int length = iArr.length;
            int i2 = this.nr;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.u = iArr2;
            }
        }
    }

    private final int pn(int i) {
        if (this.n != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.l.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public String b(int i) {
        int iPn = pn(i);
        int[] iArr = this.l;
        if (iArr[iPn + 3] != 3) {
            return "";
        }
        return this.b.u(iArr[iPn + 2]);
    }

    public int fx(int i) {
        return this.l[pn(i) + 4];
    }

    public void u() {
        if (this.fx) {
            this.fx = false;
            this.nr.u();
            this.nr = null;
            this.b = null;
            this.pn = null;
            this.iz.u();
            x();
        }
    }

    public int nr(int i) {
        return this.l[pn(i) + 3];
    }

    public String u(int i) {
        int i2 = this.l[pn(i) + 1];
        return i2 == -1 ? "" : this.b.u(i2);
    }
}
