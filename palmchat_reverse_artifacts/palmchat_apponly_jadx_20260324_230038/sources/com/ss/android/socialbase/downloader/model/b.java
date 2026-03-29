package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.network.x;
import java.io.IOException;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private long b;
    public final int fx;
    public final x nr;
    private long pn;
    public final String u;

    public b(String str, x xVar) throws IOException {
        this.u = str;
        this.fx = xVar.nr();
        this.nr = xVar;
    }

    public boolean a() {
        return com.ss.android.socialbase.downloader.jk.u.u(8) ? iz.fx(this.nr) : iz.nr(n());
    }

    public String b() {
        return this.nr.u("Content-Type");
    }

    public String fx() {
        return this.nr.u("Etag");
    }

    public String iz() {
        String strNr = iz.nr(this.nr, "last-modified");
        return TextUtils.isEmpty(strNr) ? iz.nr(this.nr, HttpHeaders.LAST_MODIFIED) : strNr;
    }

    public long jk() {
        if (this.pn <= 0) {
            if (a()) {
                this.pn = -1L;
            } else {
                String strPn = pn();
                if (!TextUtils.isEmpty(strPn)) {
                    this.pn = iz.nr(strPn);
                }
            }
        }
        return this.pn;
    }

    public long n() {
        if (this.b <= 0) {
            this.b = iz.u(this.nr);
        }
        return this.b;
    }

    public boolean nr() {
        return iz.u(this.fx, this.nr.u(HttpHeaders.ACCEPT_RANGES));
    }

    public String pn() {
        return iz.nr(this.nr, HttpHeaders.CONTENT_RANGE);
    }

    public long t() {
        return iz.a(x());
    }

    public boolean u() {
        return iz.fx(this.fx);
    }

    public String x() {
        return iz.nr(this.nr, HttpHeaders.CACHE_CONTROL);
    }
}
