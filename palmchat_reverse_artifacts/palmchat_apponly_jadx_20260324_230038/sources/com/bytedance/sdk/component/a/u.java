package com.bytedance.sdk.component.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.a.b.fx;
import com.bytedance.sdk.component.a.fx.iz;
import com.bytedance.sdk.component.a.fx.x;
import com.bytedance.sdk.component.a.nr.fx;
import com.bytedance.sdk.component.a.nr.pn;
import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.utils.bq;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int fx;
    private iz nr;
    private l u;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.a.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0203u {
        private Set<String> iz;
        private com.bytedance.sdk.component.nr.u.u.u.u n;
        private Bundle x;
        boolean b = true;
        final List<a> pn = new ArrayList();
        int u = 10000;
        int nr = 10000;
        int fx = 10000;

        public C0203u fx(long j, TimeUnit timeUnit) {
            this.fx = u(WkAdConfigModel.TAG_TIMEOUT, j, timeUnit);
            return this;
        }

        public C0203u nr(long j, TimeUnit timeUnit) {
            this.nr = u(WkAdConfigModel.TAG_TIMEOUT, j, timeUnit);
            return this;
        }

        public C0203u u(long j, TimeUnit timeUnit) {
            this.u = u(WkAdConfigModel.TAG_TIMEOUT, j, timeUnit);
            return this;
        }

        public C0203u u(boolean z) {
            this.b = z;
            return this;
        }

        public C0203u u(a aVar) {
            this.pn.add(aVar);
            return this;
        }

        public C0203u u(Set<String> set) {
            this.iz = set;
            return this;
        }

        private static int u(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                }
                if (millis != 0 || j <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(str + " too small.");
            }
            throw new NullPointerException("unit == null");
        }

        public u u() {
            return new u(this);
        }
    }

    public com.bytedance.sdk.component.a.nr.nr b() {
        return new com.bytedance.sdk.component.a.nr.nr(this.u);
    }

    public fx fx() {
        return new fx(this.u);
    }

    public l iz() {
        return this.u;
    }

    public pn nr() {
        return new pn(this.u);
    }

    public com.bytedance.sdk.component.a.nr.u pn() {
        return new com.bytedance.sdk.component.a.nr.u(this.u);
    }

    public void u(Context context, boolean z, com.bytedance.sdk.component.a.fx.nr nrVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (nrVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iU = nrVar.u();
        this.fx = iU;
        iz izVar = this.nr;
        if (izVar != null) {
            izVar.u(iU);
        }
        x.u().u(this.fx).u(z);
        x.u().u(this.fx).u(nrVar);
        x.u().u(this.fx).u(context, bq.u(context));
    }

    private u(C0203u c0203u) {
        l.u uVar = new l.u();
        long j = c0203u.u;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        l.u uVarNr = uVar.u(j, timeUnit).fx(c0203u.fx, timeUnit).nr(c0203u.nr, timeUnit);
        if (c0203u.b) {
            iz izVar = new iz();
            this.nr = izVar;
            uVarNr.u(izVar);
        }
        List<a> list = c0203u.pn;
        if (list != null && list.size() > 0) {
            Iterator<a> it = c0203u.pn.iterator();
            while (it.hasNext()) {
                uVarNr.u(it.next());
            }
        }
        if (c0203u.x != null) {
            uVarNr.u(c0203u.x);
        }
        uVarNr.u(c0203u.iz);
        if (c0203u.n == null) {
            uVarNr.u(new com.bytedance.sdk.component.nr.u.u.u.nr());
        } else {
            uVarNr.u(c0203u.n);
        }
        this.u = uVarNr.u();
    }

    public void u(Context context, boolean z) {
        com.bytedance.sdk.component.a.fx.u.nr(true);
        if (u(context) || (!bq.u(context) && z)) {
            x.u().u(this.fx, context).b();
            x.u().u(this.fx, context).u();
        }
        if (bq.u(context)) {
            x.u().u(this.fx, context).b();
            x.u().u(this.fx, context).u();
        }
    }

    public static void u() {
        com.bytedance.sdk.component.a.b.fx.u(fx.u.DEBUG);
    }

    public com.bytedance.sdk.component.a.nr.nr u(String str, String str2, String str3) {
        return new com.bytedance.sdk.component.a.nr.nr(this.u, str, str2, str3);
    }

    private static boolean u(Context context) {
        String strNr = bq.nr(context);
        if (strNr != null) {
            return strNr.endsWith(":push") || strNr.endsWith(":pushservice");
        }
        return false;
    }
}
