package com.bytedance.sdk.component.fx.nr;

import com.umeng.analytics.pro.dn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.component.fx.u.iz f5119a;
    private final dw jk;
    private final List<nr> l;
    private long mv = -1;
    private final dw t;
    public static final dw u = dw.u("multipart/mixed");
    public static final dw nr = dw.u("multipart/alternative");
    public static final dw fx = dw.u("multipart/digest");
    public static final dw b = dw.u("multipart/parallel");
    public static final dw pn = dw.u("multipart/form-data");
    private static final byte[] iz = {58, 32};
    private static final byte[] x = {dn.k, 10};
    private static final byte[] n = {45, 45};

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private final List<nr> fx;
        private dw nr;
        private final com.bytedance.sdk.component.fx.u.iz u;

        public u() {
            this(UUID.randomUUID().toString());
        }

        public u u(dw dwVar) {
            if (dwVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!dwVar.u().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(dwVar)));
            }
            this.nr = dwVar;
            return this;
        }

        public u(String str) {
            this.nr = c.u;
            this.fx = new ArrayList();
            this.u = com.bytedance.sdk.component.fx.u.iz.u(str);
        }

        public u u(String str, String str2, gi giVar) {
            return u(nr.u(str, str2, giVar));
        }

        public u u(nr nrVar) {
            if (nrVar != null) {
                this.fx.add(nrVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public c u() {
            if (!this.fx.isEmpty()) {
                return new c(this.u, this.nr, this.fx);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public c(com.bytedance.sdk.component.fx.u.iz izVar, dw dwVar, List<nr> list) {
        this.f5119a = izVar;
        this.jk = dwVar;
        this.t = dw.u(dwVar + "; boundary=" + izVar.u());
        this.l = com.bytedance.sdk.component.fx.nr.u.fx.u(list);
    }

    @Override // com.bytedance.sdk.component.fx.nr.gi
    public long nr() throws IOException {
        long j = this.mv;
        if (j != -1) {
            return j;
        }
        long jU = u((com.bytedance.sdk.component.fx.u.b) null, true);
        this.mv = jU;
        return jU;
    }

    @Override // com.bytedance.sdk.component.fx.nr.gi
    public dw u() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.fx.nr.gi
    public void u(com.bytedance.sdk.component.fx.u.b bVar) throws IOException {
        u(bVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long u(com.bytedance.sdk.component.fx.u.b bVar, boolean z) throws IOException {
        com.bytedance.sdk.component.fx.u.fx fxVar;
        if (z) {
            bVar = new com.bytedance.sdk.component.fx.u.fx();
            fxVar = bVar;
        } else {
            fxVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            nr nrVar = this.l.get(i);
            sx sxVar = nrVar.u;
            gi giVar = nrVar.nr;
            bVar.fx(n);
            bVar.nr(this.f5119a);
            bVar.fx(x);
            if (sxVar != null) {
                int iU = sxVar.u();
                for (int i2 = 0; i2 < iU; i2++) {
                    bVar.nr(sxVar.u(i2)).fx(iz).nr(sxVar.nr(i2)).fx(x);
                }
            }
            dw dwVarU = giVar.u();
            if (dwVarU != null) {
                bVar.nr("Content-Type: ").nr(dwVarU.toString()).fx(x);
            }
            long jNr = giVar.nr();
            if (jNr != -1) {
                bVar.nr("Content-Length: ").l(jNr).fx(x);
            } else if (z) {
                fxVar.sx();
                return -1L;
            }
            byte[] bArr = x;
            bVar.fx(bArr);
            if (z) {
                j += jNr;
            } else {
                giVar.u(bVar);
            }
            bVar.fx(bArr);
        }
        byte[] bArr2 = n;
        bVar.fx(bArr2);
        bVar.nr(this.f5119a);
        bVar.fx(bArr2);
        bVar.fx(x);
        if (!z) {
            return j;
        }
        long jNr2 = j + fxVar.nr();
        fxVar.sx();
        return jNr2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {
        final gi nr;
        final sx u;

        private nr(sx sxVar, gi giVar) {
            this.u = sxVar;
            this.nr = giVar;
        }

        public static nr u(sx sxVar, gi giVar) {
            if (giVar == null) {
                throw new NullPointerException("body == null");
            }
            if (sxVar != null && sxVar.u("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (sxVar == null || sxVar.u("Content-Length") == null) {
                return new nr(sxVar, giVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static nr u(String str, String str2, gi giVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                c.u(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    c.u(sb, str2);
                }
                return u(sx.u(MIME.CONTENT_DISPOSITION, sb.toString()), giVar);
            }
            throw new NullPointerException("name == null");
        }
    }

    public static StringBuilder u(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(Typography.quote);
        return sb;
    }
}
