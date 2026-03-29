package com.bytedance.sdk.component.nr.u;

import com.bytedance.sdk.component.nr.u.iz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class s {
    public l u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        String b;
        x fx;
        k iz;
        public Map<String, List<String>> nr;
        Object pn;
        com.bytedance.sdk.component.nr.u.u u;
        iz.u x;

        public u() {
            this.nr = new HashMap();
            this.x = new iz.u();
        }

        public u nr(String str, String str2) {
            if (!this.nr.containsKey(str)) {
                this.nr.put(str, new ArrayList());
            }
            this.nr.get(str).add(str2);
            return this;
        }

        public u u(com.bytedance.sdk.component.nr.u.u uVar) {
            this.u = uVar;
            return this;
        }

        public u u(Object obj) {
            this.pn = obj;
            return this;
        }

        public u u(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                x xVarFx = x.fx(str);
                if (xVarFx != null) {
                    return u(xVarFx);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            throw new NullPointerException("url == null");
        }

        public u(s sVar) {
            this.fx = sVar.nr();
            this.b = sVar.fx();
            this.nr = sVar.b();
            this.pn = sVar.u();
            this.iz = sVar.iz();
            this.u = sVar.pn();
        }

        public s nr() {
            return new s() { // from class: com.bytedance.sdk.component.nr.u.s.u.1
                @Override // com.bytedance.sdk.component.nr.u.s
                public Map b() {
                    return u.this.nr;
                }

                @Override // com.bytedance.sdk.component.nr.u.s
                public String fx() {
                    return u.this.b;
                }

                @Override // com.bytedance.sdk.component.nr.u.s
                public k iz() {
                    return u.this.iz;
                }

                @Override // com.bytedance.sdk.component.nr.u.s
                public x nr() {
                    return u.this.fx;
                }

                @Override // com.bytedance.sdk.component.nr.u.s
                public com.bytedance.sdk.component.nr.u.u pn() {
                    return u.this.u;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.nr.u.s
                public Object u() {
                    return u.this.pn;
                }
            };
        }

        public u u(x xVar) {
            this.fx = xVar;
            return this;
        }

        public u u(String str, String str2) {
            return nr(str, str2);
        }

        public u u(iz izVar) {
            if (izVar != null) {
                this.nr = izVar.nr();
            }
            return this;
        }

        public u u() {
            return u("GET", (k) null);
        }

        public u u(String str, k kVar) {
            this.b = str;
            this.iz = kVar;
            return this;
        }

        public u u(k kVar) {
            return u("POST", kVar);
        }
    }

    public abstract Map<String, List<String>> b();

    public abstract String fx();

    public k iz() {
        return null;
    }

    public abstract x nr();

    public abstract com.bytedance.sdk.component.nr.u.u pn();

    public abstract Object u();

    public void u(l lVar) {
        this.u = lVar;
    }

    public u x() {
        return new u(this);
    }
}
