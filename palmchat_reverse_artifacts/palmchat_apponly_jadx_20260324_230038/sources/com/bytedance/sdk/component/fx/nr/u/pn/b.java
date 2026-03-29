package com.bytedance.sdk.component.fx.nr.u.pn;

import com.alipay.sdk.m.x.d;
import com.bytedance.sdk.component.fx.u.bg;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.refund.RefundData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class b {
    static final Map<com.bytedance.sdk.component.fx.u.iz, Integer> nr;
    static final fx[] u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5134a;
        int b;
        fx[] fx;
        int iz;
        private boolean jk;
        private final boolean n;
        int nr;
        int pn;
        int u;
        private final com.bytedance.sdk.component.fx.u.fx x;

        public nr(com.bytedance.sdk.component.fx.u.fx fxVar) {
            this(4096, true, fxVar);
        }

        private int nr(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.fx.length;
                while (true) {
                    length--;
                    i2 = this.b;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.fx[length].f5135a;
                    i -= i4;
                    this.iz -= i4;
                    this.pn--;
                    i3++;
                }
                fx[] fxVarArr = this.fx;
                System.arraycopy(fxVarArr, i2 + 1, fxVarArr, i2 + 1 + i3, this.pn);
                fx[] fxVarArr2 = this.fx;
                int i5 = this.b;
                Arrays.fill(fxVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.b += i3;
            }
            return i3;
        }

        private void u() {
            Arrays.fill(this.fx, (Object) null);
            this.b = this.fx.length - 1;
            this.pn = 0;
            this.iz = 0;
        }

        public nr(int i, boolean z, com.bytedance.sdk.component.fx.u.fx fxVar) {
            this.f5134a = Integer.MAX_VALUE;
            this.fx = new fx[8];
            this.b = r0.length - 1;
            this.pn = 0;
            this.iz = 0;
            this.u = i;
            this.nr = i;
            this.n = z;
            this.x = fxVar;
        }

        private void u(fx fxVar) {
            int i = fxVar.f5135a;
            int i2 = this.nr;
            if (i > i2) {
                u();
                return;
            }
            nr((this.iz + i) - i2);
            int i3 = this.pn + 1;
            fx[] fxVarArr = this.fx;
            if (i3 > fxVarArr.length) {
                fx[] fxVarArr2 = new fx[fxVarArr.length * 2];
                System.arraycopy(fxVarArr, 0, fxVarArr2, fxVarArr.length, fxVarArr.length);
                this.b = this.fx.length - 1;
                this.fx = fxVarArr2;
            }
            int i4 = this.b;
            this.b = i4 - 1;
            this.fx[i4] = fxVar;
            this.pn++;
            this.iz += i;
        }

        private void nr() {
            int i = this.nr;
            int i2 = this.iz;
            if (i < i2) {
                if (i == 0) {
                    u();
                } else {
                    nr(i2 - i);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void u(List<fx> list) throws IOException {
            int length;
            int length2;
            if (this.jk) {
                int i = this.f5134a;
                if (i < this.nr) {
                    u(i, 31, 32);
                }
                this.jk = false;
                this.f5134a = Integer.MAX_VALUE;
                u(this.nr, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                fx fxVar = list.get(i2);
                com.bytedance.sdk.component.fx.u.iz izVarIz = fxVar.x.iz();
                com.bytedance.sdk.component.fx.u.iz izVar = fxVar.n;
                Integer num = b.nr.get(izVarIz);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else {
                        fx[] fxVarArr = b.u;
                        if (com.bytedance.sdk.component.fx.nr.u.fx.u(fxVarArr[length - 1].n, izVar)) {
                            length2 = length;
                        } else if (com.bytedance.sdk.component.fx.nr.u.fx.u(fxVarArr[length].n, izVar)) {
                            length2 = length;
                            length++;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length == -1) {
                    int i3 = this.b + 1;
                    int length3 = this.fx.length;
                    while (true) {
                        if (i3 >= length3) {
                            break;
                        }
                        if (com.bytedance.sdk.component.fx.nr.u.fx.u(this.fx[i3].x, izVarIz)) {
                            if (com.bytedance.sdk.component.fx.nr.u.fx.u(this.fx[i3].n, izVar)) {
                                length = b.u.length + (i3 - this.b);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i3 - this.b) + b.u.length;
                            }
                        }
                        i3++;
                    }
                }
                if (length != -1) {
                    u(length, 127, 128);
                } else if (length2 == -1) {
                    this.x.a(64);
                    u(izVarIz);
                    u(izVar);
                    u(fxVar);
                } else if (izVarIz.u(fx.u) && !fx.iz.equals(izVarIz)) {
                    u(length2, 15, 0);
                    u(izVar);
                } else {
                    u(length2, 63, 64);
                    u(izVar);
                    u(fxVar);
                }
            }
        }

        public void u(int i, int i2, int i3) {
            if (i < i2) {
                this.x.a(i | i3);
                return;
            }
            this.x.a(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.x.a(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.x.a(i4);
        }

        public void u(com.bytedance.sdk.component.fx.u.iz izVar) throws IOException {
            if (this.n && t.u().u(izVar) < izVar.x()) {
                com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
                t.u().u(izVar, fxVar);
                com.bytedance.sdk.component.fx.u.iz izVarS = fxVar.s();
                u(izVarS.x(), 127, 128);
                this.x.nr(izVarS);
                return;
            }
            u(izVar.x(), 127, 0);
            this.x.nr(izVar);
        }

        public void u(int i) {
            this.u = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.nr;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.f5134a = Math.min(this.f5134a, iMin);
            }
            this.jk = true;
            this.nr = iMin;
            nr();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        int b;
        int fx;
        private final com.bytedance.sdk.component.fx.u.pn iz;
        private int n;
        int nr;
        private final List<fx> pn;
        fx[] u;
        private final int x;

        public u(int i, bg bgVar) {
            this(i, i, bgVar);
        }

        private void b() {
            int i = this.n;
            int i2 = this.b;
            if (i < i2) {
                if (i == 0) {
                    pn();
                } else {
                    u(i2 - i);
                }
            }
        }

        private int fx(int i) {
            return this.nr + 1 + i;
        }

        private void iz() throws IOException {
            this.pn.add(new fx(b.u(fx()), fx()));
        }

        private int n() throws IOException {
            return this.iz.n() & UByte.MAX_VALUE;
        }

        private void pn() {
            Arrays.fill(this.u, (Object) null);
            this.nr = this.u.length - 1;
            this.fx = 0;
            this.b = 0;
        }

        private int u(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.u.length;
                while (true) {
                    length--;
                    i2 = this.nr;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.u[length].f5135a;
                    i -= i4;
                    this.b -= i4;
                    this.fx--;
                    i3++;
                }
                fx[] fxVarArr = this.u;
                System.arraycopy(fxVarArr, i2 + 1, fxVarArr, i2 + 1 + i3, this.fx);
                this.nr += i3;
            }
            return i3;
        }

        private void x() throws IOException {
            u(-1, new fx(b.u(fx()), fx()));
        }

        public List<fx> nr() {
            ArrayList arrayList = new ArrayList(this.pn);
            this.pn.clear();
            return arrayList;
        }

        public u(int i, int i2, bg bgVar) {
            this.pn = new ArrayList();
            this.u = new fx[8];
            this.nr = r0.length - 1;
            this.fx = 0;
            this.b = 0;
            this.x = i;
            this.n = i2;
            this.iz = com.bytedance.sdk.component.fx.u.l.u(bgVar);
        }

        public com.bytedance.sdk.component.fx.u.iz fx() throws IOException {
            int iN = n();
            boolean z = (iN & 128) == 128;
            int iU = u(iN, 127);
            return z ? com.bytedance.sdk.component.fx.u.iz.u(t.u().u(this.iz.x(iU))) : this.iz.fx(iU);
        }

        private void nr(int i) throws IOException {
            if (x(i)) {
                this.pn.add(b.u[i]);
                return;
            }
            int iFx = fx(i - b.u.length);
            if (iFx >= 0) {
                fx[] fxVarArr = this.u;
                if (iFx <= fxVarArr.length - 1) {
                    this.pn.add(fxVarArr[iFx]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void b(int i) throws IOException {
            this.pn.add(new fx(iz(i), fx()));
        }

        private com.bytedance.sdk.component.fx.u.iz iz(int i) {
            if (x(i)) {
                return b.u[i].x;
            }
            return this.u[fx(i - b.u.length)].x;
        }

        private boolean x(int i) {
            return i >= 0 && i <= b.u.length - 1;
        }

        private void pn(int i) throws IOException {
            u(-1, new fx(iz(i), fx()));
        }

        public void u() throws IOException {
            while (!this.iz.pn()) {
                int iN = this.iz.n() & UByte.MAX_VALUE;
                if (iN == 128) {
                    throw new IOException("index == 0");
                }
                if ((iN & 128) == 128) {
                    nr(u(iN, 127) - 1);
                } else if (iN == 64) {
                    x();
                } else if ((iN & 64) == 64) {
                    pn(u(iN, 63) - 1);
                } else if ((iN & 32) == 32) {
                    int iU = u(iN, 31);
                    this.n = iU;
                    if (iU >= 0 && iU <= this.x) {
                        b();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.n);
                    }
                } else if (iN != 16 && iN != 0) {
                    b(u(iN, 15) - 1);
                } else {
                    iz();
                }
            }
        }

        private void u(int i, fx fxVar) {
            this.pn.add(fxVar);
            int i2 = fxVar.f5135a;
            if (i != -1) {
                i2 -= this.u[fx(i)].f5135a;
            }
            int i3 = this.n;
            if (i2 > i3) {
                pn();
                return;
            }
            int iU = u((this.b + i2) - i3);
            if (i == -1) {
                int i4 = this.fx + 1;
                fx[] fxVarArr = this.u;
                if (i4 > fxVarArr.length) {
                    fx[] fxVarArr2 = new fx[fxVarArr.length * 2];
                    System.arraycopy(fxVarArr, 0, fxVarArr2, fxVarArr.length, fxVarArr.length);
                    this.nr = this.u.length - 1;
                    this.u = fxVarArr2;
                }
                int i5 = this.nr;
                this.nr = i5 - 1;
                this.u[i5] = fxVar;
                this.fx++;
            } else {
                this.u[i + fx(i) + iU] = fxVar;
            }
            this.b += i2;
        }

        public int u(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iN = n();
                if ((iN & 128) == 0) {
                    return i2 + (iN << i4);
                }
                i2 += (iN & 127) << i4;
                i4 += 7;
            }
        }
    }

    static {
        com.bytedance.sdk.component.fx.u.iz izVar = fx.fx;
        com.bytedance.sdk.component.fx.u.iz izVar2 = fx.b;
        com.bytedance.sdk.component.fx.u.iz izVar3 = fx.pn;
        com.bytedance.sdk.component.fx.u.iz izVar4 = fx.nr;
        u = new fx[]{new fx(fx.iz, ""), new fx(izVar, "GET"), new fx(izVar, "POST"), new fx(izVar2, "/"), new fx(izVar2, "/index.html"), new fx(izVar3, HttpHost.DEFAULT_SCHEME_NAME), new fx(izVar3, BaseConstants.SCHEME_HTTPS), new fx(izVar4, "200"), new fx(izVar4, "204"), new fx(izVar4, "206"), new fx(izVar4, "304"), new fx(izVar4, "400"), new fx(izVar4, "404"), new fx(izVar4, "500"), new fx("accept-charset", ""), new fx("accept-encoding", "gzip, deflate"), new fx("accept-language", ""), new fx("accept-ranges", ""), new fx("accept", ""), new fx("access-control-allow-origin", ""), new fx("age", ""), new fx("allow", ""), new fx("authorization", ""), new fx("cache-control", ""), new fx("content-disposition", ""), new fx("content-encoding", ""), new fx("content-language", ""), new fx("content-length", ""), new fx("content-location", ""), new fx("content-range", ""), new fx("content-type", ""), new fx("cookie", ""), new fx(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, ""), new fx("etag", ""), new fx("expect", ""), new fx(RefundData.TAG_CLOCK, ""), new fx("from", ""), new fx("host", ""), new fx("if-match", ""), new fx("if-modified-since", ""), new fx("if-none-match", ""), new fx("if-range", ""), new fx("if-unmodified-since", ""), new fx("last-modified", ""), new fx("link", ""), new fx("location", ""), new fx("max-forwards", ""), new fx("proxy-authenticate", ""), new fx("proxy-authorization", ""), new fx("range", ""), new fx("referer", ""), new fx(d.w, ""), new fx("retry-after", ""), new fx("server", ""), new fx("set-cookie", ""), new fx("strict-transport-security", ""), new fx("transfer-encoding", ""), new fx("user-agent", ""), new fx("vary", ""), new fx("via", ""), new fx("www-authenticate", "")};
        nr = u();
    }

    private static Map<com.bytedance.sdk.component.fx.u.iz, Integer> u() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.length);
        int i = 0;
        while (true) {
            fx[] fxVarArr = u;
            if (i >= fxVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(fxVarArr[i].x)) {
                linkedHashMap.put(fxVarArr[i].x, Integer.valueOf(i));
            }
            i++;
        }
    }

    public static com.bytedance.sdk.component.fx.u.iz u(com.bytedance.sdk.component.fx.u.iz izVar) throws IOException {
        int iX = izVar.x();
        for (int i = 0; i < iX; i++) {
            byte bU = izVar.u(i);
            if (bU >= 65 && bU <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + izVar.u());
            }
        }
        return izVar;
    }
}
