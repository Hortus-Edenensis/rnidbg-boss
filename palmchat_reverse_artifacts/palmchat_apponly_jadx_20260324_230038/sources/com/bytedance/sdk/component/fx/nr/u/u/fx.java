package com.bytedance.sdk.component.fx.nr.u.u;

import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.sx;
import com.bytedance.sdk.component.fx.nr.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx {
    public final h nr;
    public final z u;

    public fx(z zVar, h hVar) {
        this.u = zVar;
        this.nr = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.l().b() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean u(h hVar, z zVar) {
        int iFx = hVar.fx();
        if (iFx != 200 && iFx != 410 && iFx != 414 && iFx != 501 && iFx != 203 && iFx != 204) {
            if (iFx != 307) {
                if (iFx != 308 && iFx != 404 && iFx != 405) {
                    switch (iFx) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (hVar.u(HttpHeaders.EXPIRES) == null) {
                if (hVar.l().fx() == -1) {
                    if (!hVar.l().pn()) {
                    }
                }
            }
        }
        return (hVar.l().nr() || zVar.x().nr()) ? false : true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f5139a;
        private Date b;
        final h fx;
        private Date iz;
        private long jk;
        private int l;
        private Date n;
        final z nr;
        private String pn;
        private String t;
        final long u;
        private String x;

        public u(long j, z zVar, h hVar) {
            this.l = -1;
            this.u = j;
            this.nr = zVar;
            this.fx = hVar;
            if (hVar != null) {
                this.f5139a = hVar.mv();
                this.jk = hVar.s();
                sx sxVarX = hVar.x();
                int iU = sxVarX.u();
                for (int i = 0; i < iU; i++) {
                    String strU = sxVarX.u(i);
                    String strNr = sxVarX.nr(i);
                    if ("Date".equalsIgnoreCase(strU)) {
                        this.b = com.bytedance.sdk.component.fx.nr.u.fx.b.u(strNr);
                        this.pn = strNr;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(strU)) {
                        this.n = com.bytedance.sdk.component.fx.nr.u.fx.b.u(strNr);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(strU)) {
                        this.iz = com.bytedance.sdk.component.fx.nr.u.fx.b.u(strNr);
                        this.x = strNr;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(strU)) {
                        this.t = strNr;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(strU)) {
                        this.l = com.bytedance.sdk.component.fx.nr.u.fx.pn.nr(strNr, -1);
                    }
                }
            }
        }

        private long b() {
            Date date = this.b;
            long jMax = date != null ? Math.max(0L, this.jk - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.jk;
            return jMax + (j - this.f5139a) + (this.u - j);
        }

        private long fx() {
            if (this.fx.l().fx() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.fx());
            }
            if (this.n != null) {
                Date date = this.b;
                long time = this.n.getTime() - (date != null ? date.getTime() : this.jk);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.iz != null && this.fx.u().u().query() == null) {
                Date date2 = this.b;
                long time2 = (date2 != null ? date2.getTime() : this.f5139a) - this.iz.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private fx nr() {
            String str;
            if (this.fx == null) {
                return new fx(this.nr, null);
            }
            if (this.nr.n() && this.fx.iz() == null) {
                return new fx(this.nr, null);
            }
            if (!fx.u(this.fx, this.nr)) {
                return new fx(this.nr, null);
            }
            com.bytedance.sdk.component.fx.nr.b bVarX = this.nr.x();
            if (bVarX.u() || u(this.nr)) {
                return new fx(this.nr, null);
            }
            com.bytedance.sdk.component.fx.nr.b bVarL = this.fx.l();
            if (bVarL.jk()) {
                return new fx(null, this.fx);
            }
            long jB = b();
            long jFx = fx();
            if (bVarX.fx() != -1) {
                jFx = Math.min(jFx, TimeUnit.SECONDS.toMillis(bVarX.fx()));
            }
            long millis = 0;
            long millis2 = bVarX.n() != -1 ? TimeUnit.SECONDS.toMillis(bVarX.n()) : 0L;
            if (!bVarL.iz() && bVarX.x() != -1) {
                millis = TimeUnit.SECONDS.toMillis(bVarX.x());
            }
            if (!bVarL.u()) {
                long j = millis2 + jB;
                if (j < millis + jFx) {
                    h.u uVarA = this.fx.a();
                    if (j >= jFx) {
                        uVarA.u(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jB > 86400000 && pn()) {
                        uVarA.u(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new fx(null, uVarA.u());
                }
            }
            String str2 = this.t;
            if (str2 != null) {
                str = HttpHeaders.IF_NONE_MATCH;
            } else {
                if (this.iz != null) {
                    str2 = this.x;
                } else {
                    if (this.b == null) {
                        return new fx(this.nr, null);
                    }
                    str2 = this.pn;
                }
                str = HttpHeaders.IF_MODIFIED_SINCE;
            }
            sx.u uVarNr = this.nr.fx().nr();
            com.bytedance.sdk.component.fx.nr.u.u.u.u(uVarNr, str, str2);
            return new fx(this.nr.iz().u(uVarNr.u()).u(), this.fx);
        }

        private boolean pn() {
            return this.fx.l().fx() == -1 && this.n == null;
        }

        public fx u() {
            fx fxVarNr = nr();
            return (fxVarNr.u == null || !this.nr.x().a()) ? fxVarNr : new fx(null, null);
        }

        private static boolean u(z zVar) {
            return (zVar.u(HttpHeaders.IF_MODIFIED_SINCE) == null && zVar.u(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
