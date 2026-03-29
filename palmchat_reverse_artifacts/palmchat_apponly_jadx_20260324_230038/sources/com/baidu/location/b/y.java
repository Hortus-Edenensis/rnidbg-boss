package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f3466a;
    private long b = 0;
    private long c = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static y f3467a = new y();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends com.baidu.location.e.f {
        private boolean d = false;
        private String e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3468a = false;
        public long b = 0;

        public b() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            String strC = com.baidu.location.e.b.a().c();
            if (strC != null) {
                strC = strC + "&gnsst=" + this.b;
            }
            String strA = n.a().a(strC);
            boolean zIsEmpty = TextUtils.isEmpty(strA);
            String strReplaceAll = com.igexin.push.core.b.m;
            String strReplaceAll2 = !zIsEmpty ? strA.trim().replaceAll("\r|\n", "") : com.igexin.push.core.b.m;
            String strA2 = n.a().a(this.e);
            if (!TextUtils.isEmpty(strA2)) {
                strReplaceAll = strA2.trim().replaceAll("\r|\n", "");
            }
            try {
                this.el.put("info", URLEncoder.encode(strReplaceAll2, "utf-8"));
                this.el.put("enl", URLEncoder.encode(strReplaceAll, "utf-8"));
            } catch (Exception unused) {
            }
        }

        public boolean b() {
            return this.d;
        }

        public void a(String str, long j) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = str;
            this.b = j;
            ExecutorService executorServiceC = x.a().c();
            if (executorServiceC != null) {
                a(executorServiceC, com.baidu.location.e.d.n);
            } else {
                b(com.baidu.location.e.d.n);
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.ej != null) {
                try {
                    new JSONObject(this.ej);
                    this.f3468a = true;
                } catch (Throwable unused) {
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.d = false;
        }
    }

    public static y a() {
        return a.f3467a;
    }

    public void b() {
        ArrayList<String> arrayListB;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= 20000) {
            return;
        }
        if (this.f3466a == null) {
            this.f3466a = new b();
        }
        b bVar = this.f3466a;
        if (bVar == null || bVar.b() || (arrayListB = t.a().b()) == null || arrayListB.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayListB.iterator();
        int i = 0;
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i++;
            if (i != arrayListB.size()) {
                stringBuffer.append(com.huawei.openalliance.ad.constant.x.aQ);
            }
        }
        this.f3466a.a(stringBuffer.toString(), this.c);
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        t.a().a(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }
}
