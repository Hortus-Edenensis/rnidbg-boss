package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.os.Handler;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.c;
import com.opos.cmn.func.a.a.d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d implements a {
    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(com.opos.cmn.func.a.a.e eVar, String str) {
        if (com.opos.cmn.biz.monitor.e.a(str) && eVar != null && 200 == eVar.f7934a && eVar.d > 0 && eVar.c != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                do {
                    int i = eVar.c.read(bArr);
                    if (-1 == i) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } while (byteArrayOutputStream.size() <= 8192);
                return null;
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d("DefaultRequestResolver", "getResponseBytes error,url" + str, th);
            }
        }
        return null;
    }

    @Override // com.opos.cmn.biz.monitor.b.a
    public void a(final Context context, final b bVar, final a.InterfaceC0652a interfaceC0652a) {
        final Handler handler = new Handler(context.getMainLooper());
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                com.opos.cmn.func.a.a.e eVar = null;
                final c cVarA = null;
                eVar = null;
                try {
                    try {
                        Map<String, String> mapC = bVar.c();
                        if (mapC == null) {
                            mapC = new HashMap<>();
                        }
                        mapC.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                        com.opos.cmn.func.a.a.d dVarA = new d.a().a(bVar.d()).a(mapC).a(bVar.b()).b(bVar.a()).a();
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", "netRequest is = " + dVarA + ". url = " + dVarA.b);
                        com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(context, dVarA);
                        if (eVarA != null) {
                            try {
                                cVarA = new c.a(eVarA.f7934a).a(eVarA.e).a(d.b(eVarA, bVar.a())).a();
                            } catch (Exception e) {
                                e = e;
                                eVar = eVarA;
                                com.opos.cmn.an.f.a.d("DefaultRequestResolver", "resolve fail," + e.toString());
                                handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        interfaceC0652a.a();
                                    }
                                });
                                if (eVar != null) {
                                    eVar.a();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                eVar = eVarA;
                                if (eVar != null) {
                                    eVar.a();
                                }
                                throw th;
                            }
                        }
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", "response is = " + cVarA);
                        handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c cVar = cVarA;
                                if (cVar != null) {
                                    interfaceC0652a.a(cVar);
                                } else {
                                    interfaceC0652a.a();
                                }
                            }
                        });
                        if (eVarA != null) {
                            eVarA.a();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }
}
