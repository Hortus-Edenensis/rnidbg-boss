package com.bytedance.sdk.component.fx.nr;

import com.baidu.mapapi.http.wrapper.HttpManager;
import com.bytedance.sdk.component.fx.nr.sx;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    final gi b;
    final sx fx;
    public d iz;
    final String nr;
    final Object pn;
    final bg u;
    private volatile b x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        gi b;
        sx.u fx;
        d iz;
        String nr;
        Object pn;
        bg u;

        public u() {
            this.nr = "GET";
            this.fx = new sx.u();
        }

        public u delete(gi giVar) {
            return u(HttpManager.HTTP_DELETE, giVar);
        }

        public u u(bg bgVar) {
            if (bgVar == null) {
                throw new NullPointerException("url == null");
            }
            this.u = bgVar;
            return this;
        }

        public u delete() {
            return delete(com.bytedance.sdk.component.fx.nr.u.fx.b);
        }

        public u u(URL url) {
            if (url != null) {
                bg bgVarU = bg.u(url);
                if (bgVarU != null) {
                    return u(bgVarU);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            throw new NullPointerException("url == null");
        }

        public u(z zVar) {
            this.u = zVar.u;
            this.nr = zVar.nr;
            this.b = zVar.b;
            this.pn = zVar.pn;
            this.fx = zVar.fx.nr();
            this.iz = zVar.iz;
        }

        public u u(String str, String str2) {
            this.fx.fx(str, str2);
            return this;
        }

        public u u(String str) {
            this.fx.nr(str);
            return this;
        }

        public u u(sx sxVar) {
            this.fx = sxVar.nr();
            return this;
        }

        public u u(b bVar) {
            String string = bVar.toString();
            return string.isEmpty() ? u(HttpHeaders.CACHE_CONTROL) : u(HttpHeaders.CACHE_CONTROL, string);
        }

        public u u(String str, gi giVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (giVar != null && !com.bytedance.sdk.component.fx.nr.u.fx.iz.fx(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (giVar == null && com.bytedance.sdk.component.fx.nr.u.fx.iz.nr(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.nr = str;
                    this.b = giVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public u u(Object obj) {
            this.pn = obj;
            return this;
        }

        public z u() {
            if (this.u != null) {
                return new z(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public z(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx.u();
        this.b = uVar.b;
        Object obj = uVar.pn;
        this.pn = obj == null ? this : obj;
        d dVar = uVar.iz;
        if (dVar != null) {
            this.iz = dVar;
        } else {
            this.iz = new d();
        }
    }

    public gi b() {
        return this.b;
    }

    public sx fx() {
        return this.fx;
    }

    public u iz() {
        return new u(this);
    }

    public boolean n() {
        return this.u.b();
    }

    public String nr() {
        return this.nr;
    }

    public Object pn() {
        return this.pn;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.nr);
        sb.append(", url=");
        sb.append(this.u);
        sb.append(", tag=");
        Object obj = this.pn;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public bg u() {
        return this.u;
    }

    public b x() {
        b bVar = this.x;
        if (bVar != null) {
            return bVar;
        }
        b bVarU = b.u(this.fx);
        this.x = bVarU;
        return bVarU;
    }

    public String u(String str) {
        return this.fx.u(str);
    }
}
