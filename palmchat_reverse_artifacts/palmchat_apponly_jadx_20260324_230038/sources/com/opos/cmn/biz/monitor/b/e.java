package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.b;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7854a;
    private String b;
    private int c;
    private int d = 0;
    private com.opos.cmn.biz.monitor.b.a e;
    private a f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(byte[] bArr);
    }

    public e(Context context, String str, int i, com.opos.cmn.biz.monitor.b.a aVar, a aVar2) {
        this.f7854a = context;
        this.b = str;
        this.c = i;
        this.e = aVar;
        this.f = aVar2;
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NetRequestExecutor", "send request:" + this.b);
        a(this.b);
    }

    public void a(int i, byte[] bArr, Map<String, String> map) {
        a aVar;
        if (200 == i) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(bArr);
                return;
            }
            return;
        }
        if (302 == i) {
            String str = map.get("location");
            if (TextUtils.isEmpty(str)) {
                str = map.get(HttpHeaders.LOCATION);
            }
            if (this.d < this.c && !TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "retry with url:" + str);
                this.d = this.d + 1;
                a(str);
                return;
            }
            aVar = this.f;
            if (aVar == null) {
                return;
            }
        } else {
            aVar = this.f;
            if (aVar == null) {
                return;
            }
        }
        aVar.a();
    }

    public void a(final String str) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.ACCEPT, "application/json");
        this.e.a(this.f7854a, new b.a(str).a(map).a(), new a.InterfaceC0652a() { // from class: com.opos.cmn.biz.monitor.b.e.1
            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0652a
            public void a() {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request fail with url:" + str);
                if (e.this.f != null) {
                    e.this.f.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0652a
            public void a(c cVar) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "result code:" + cVar.a());
                e.this.a(cVar.a(), cVar.c(), cVar.b());
            }
        });
    }

    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request success but data empty");
            return false;
        }
        try {
            int i = new JSONObject(new String(bArr)).getInt("code");
            if (i == 0) {
                return true;
            }
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request success but ret:" + i);
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("NetRequestExecutor", "request but parse fail", e);
            return false;
        }
    }
}
