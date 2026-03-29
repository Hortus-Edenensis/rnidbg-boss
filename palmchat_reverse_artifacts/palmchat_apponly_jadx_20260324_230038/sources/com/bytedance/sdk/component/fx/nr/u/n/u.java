package com.bytedance.sdk.component.fx.nr.u.n;

import com.bytedance.sdk.component.fx.nr.u.fx;
import com.bytedance.sdk.component.fx.u.jk;
import com.bytedance.sdk.component.fx.u.l;
import com.bytedance.sdk.component.fx.u.pn;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private byte[] n;
    private byte[] x;
    private static final byte[] u = {42};
    private static final String[] nr = new String[0];
    private static final String[] fx = {"*"};
    private static final u b = new u();
    private final AtomicBoolean pn = new AtomicBoolean(false);
    private final CountDownLatch iz = new CountDownLatch(1);

    private void fx() throws IOException {
        InputStream resourceAsStream = u.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        pn pnVarU = l.u(new jk(l.u(resourceAsStream)));
        try {
            byte[] bArr = new byte[pnVarU.jk()];
            pnVarU.u(bArr);
            byte[] bArr2 = new byte[pnVarU.jk()];
            pnVarU.u(bArr2);
            synchronized (this) {
                this.x = bArr;
                this.n = bArr2;
            }
            this.iz.countDown();
        } finally {
            fx.u(pnVarU);
        }
    }

    private void nr() {
        boolean z = false;
        while (true) {
            try {
                try {
                    fx();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static u u() {
        return b;
    }

    public String u(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrU = u(strArrSplit);
        if (strArrSplit.length == strArrU.length && strArrU[0].charAt(0) != '!') {
            return null;
        }
        if (strArrU[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrU.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrU.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] u(String[] strArr) {
        String str;
        String strU;
        String strU2;
        int i = 0;
        if (!this.pn.get() && this.pn.compareAndSet(false, true)) {
            nr();
        } else {
            try {
                this.iz.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.x == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(fx.pn);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                strU = null;
                break;
            }
            strU = u(this.x, bArr, i3);
            if (strU != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = u;
                strU2 = u(this.x, bArr2, i4);
                if (strU2 != null) {
                    break;
                }
            }
            strU2 = null;
        } else {
            strU2 = null;
        }
        if (strU2 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String strU3 = u(this.n, bArr, i);
                if (strU3 != null) {
                    str = strU3;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strU == null && strU2 == null) {
            return fx;
        }
        String[] strArrSplit = strU != null ? strU.split("\\.") : nr;
        String[] strArrSplit2 = strU2 != null ? strU2.split("\\.") : nr;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String u(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & UByte.MAX_VALUE;
                }
                i4 = i3 - (bArr[i7 + i12] & UByte.MAX_VALUE);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (bArr2[i10].length != i11) {
                    z2 = z;
                } else {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    z2 = true;
                    i11 = -1;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, fx.pn);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }
}
