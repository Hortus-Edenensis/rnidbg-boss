package com.bytedance.sdk.component.nr.u.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.nr.u.t;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends my {
    public long b;
    public long fx;
    s nr;
    t pn = null;
    HttpURLConnection u;

    public iz(HttpURLConnection httpURLConnection, s sVar) {
        this.u = httpURLConnection;
        this.nr = sVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public boolean b() {
        return fx() >= 200 && fx() < 300;
    }

    @Override // com.bytedance.sdk.component.nr.u.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            iz().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public int fx() {
        try {
            return this.u.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public o iz() {
        try {
            return new x(this.u);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public t n() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public long nr() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String pn() throws IOException {
        return this.u.getResponseMessage();
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public long u() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public com.bytedance.sdk.component.nr.u.iz x() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.u.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || fx() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.nr.u.iz((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String u(String str) {
        return this.u.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String u(String str, String str2) {
        return !TextUtils.isEmpty(u(str)) ? u(str) : str2;
    }
}
