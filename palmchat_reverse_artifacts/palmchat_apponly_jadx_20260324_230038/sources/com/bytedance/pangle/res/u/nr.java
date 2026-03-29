package com.bytedance.pangle.res.u;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f5070a;
    private x jk;
    private int k;
    private int[] l;
    private int[] my;
    private final n n;
    private int o;
    private boolean s;
    HashMap<Integer, Integer> u = new HashMap<>();
    boolean nr = false;
    private boolean t = false;
    private final u mv = new u();
    int fx = 0;
    int b = 1;
    int pn = 2;
    int iz = 3;
    int x = 4;

    public nr(byte[] bArr, n nVar) {
        this.n = nVar;
        this.f5070a = bArr;
        b();
    }

    private void b() {
        this.k = -1;
        this.my = null;
        this.o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e7, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r2 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0215, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pn() throws IOException {
        int[] iArr;
        if (!this.t) {
            this.jk.u(524291, 524289);
            this.jk.u();
            l.u(this.jk);
            this.mv.pn();
            this.t = true;
        }
        int i = this.k;
        if (i == this.b) {
            return;
        }
        b();
        while (true) {
            int i2 = 0;
            if (this.s) {
                this.s = false;
                this.mv.iz();
            }
            if (i == this.iz && this.mv.b() == 1 && this.mv.nr() == 0) {
                this.k = this.b;
                return;
            }
            int i3 = i == this.fx ? 1048834 : this.jk.readInt();
            if (i3 == 524672) {
                this.u.clear();
                int i4 = this.jk.readInt();
                if (i4 < 8 || i4 % 4 != 0) {
                    break;
                }
                int iU = t.u(this.jk);
                this.l = this.jk.u((i4 / 4) - 2);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int[] iArr2 = this.l;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    int iU2 = t.u(this.f5070a, iArr2[i2], (i2 * 4) + iU, this.n);
                    if (iU2 >= 2130706432) {
                        this.u.put(Integer.valueOf(i2), Integer.valueOf(iU2));
                        arrayList.add(Integer.valueOf(iU2));
                    }
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.nr = true;
                }
            } else {
                if (i3 < 1048832 || i3 > 1048836) {
                    break;
                }
                if (i3 == 1048834 && i == -1) {
                    this.k = this.fx;
                    return;
                }
                this.jk.u();
                this.jk.readInt();
                this.jk.u();
                if (i3 == 1048832 || i3 == 1048833) {
                    if (i3 == 1048832) {
                        this.mv.u(this.jk.readInt(), this.jk.readInt());
                    } else {
                        this.jk.u();
                        this.jk.u();
                        this.mv.fx();
                    }
                } else {
                    if (i3 == 1048834) {
                        this.jk.readInt();
                        this.jk.readInt();
                        this.jk.u();
                        int i5 = this.jk.readInt() & 65535;
                        this.o = (65535 & this.jk.readInt()) - 1;
                        int iU3 = t.u(this.jk);
                        int i6 = i5 * 5;
                        this.my = this.jk.u(i6);
                        int i7 = 3;
                        while (true) {
                            iArr = this.my;
                            if (i7 >= iArr.length) {
                                break;
                            }
                            iArr[i7] = iArr[i7] >>> 24;
                            i7 += 5;
                        }
                        if (iArr.length != i6) {
                            throw new RuntimeException();
                        }
                        boolean z = false;
                        while (i2 < i5) {
                            int i8 = i2 * 5;
                            if (this.u.containsKey(Integer.valueOf(this.my[i8 + 1]))) {
                                z = true;
                            }
                            int[] iArr3 = this.my;
                            int i9 = iArr3[i8 + 3];
                            if (i9 == 1 || i9 == 2) {
                                int i10 = i8 + 4;
                                t.u(this.f5070a, iArr3[i10], (i10 * 4) + iU3, this.n);
                            }
                            i2++;
                        }
                        if (z && this.nr) {
                            t.u(iU3, this.f5070a, this.my, i5, this.u);
                        }
                        this.mv.pn();
                        this.k = this.pn;
                        return;
                    }
                    if (i3 == 1048835) {
                        this.jk.readInt();
                        this.jk.readInt();
                        this.k = this.iz;
                        this.s = true;
                        return;
                    }
                    if (i3 == 1048836) {
                        this.jk.readInt();
                        this.jk.u();
                        this.jk.u();
                        this.k = this.x;
                        return;
                    }
                }
            }
        }
    }

    public int fx() throws IOException {
        return nr();
    }

    public int nr() throws IOException {
        if (this.jk == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            pn();
            return this.k;
        } catch (IOException e) {
            u();
            throw e;
        }
    }

    public void u(InputStream inputStream) {
        u();
        if (inputStream != null) {
            this.jk = new x(new a(new pn(inputStream)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private int fx;
        private int nr;
        private int[] u = new int[32];

        public int b() {
            return this.fx;
        }

        public boolean fx() {
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

        public void iz() {
            int i = this.nr;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.u[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.nr = i - (i3 + 2);
            this.fx--;
        }

        public int nr() {
            int i = this.nr;
            if (i == 0) {
                return 0;
            }
            return this.u[i - 1];
        }

        public void pn() {
            u(2);
            int i = this.nr;
            int[] iArr = this.u;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.nr = i + 2;
            this.fx++;
        }

        public void u() {
            this.nr = 0;
            this.fx = 0;
        }

        public void u(int i, int i2) {
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
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.u = iArr2;
        }
    }

    public void u() {
        if (this.t) {
            this.t = false;
            this.jk = null;
            this.l = null;
            this.mv.u();
            b();
        }
    }

    public void nr(InputStream inputStream) {
        u(inputStream);
    }
}
