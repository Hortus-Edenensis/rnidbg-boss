package com.opos.mobad;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.cmn.func.a;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class g implements com.opos.mobad.cmn.func.a {
    @Override // com.opos.mobad.cmn.func.a
    public void a(Context context, String str, String str2, String str3, final a.InterfaceC0722a interfaceC0722a, String str4) {
        int iIntValue;
        boolean zB = com.opos.mobad.cmn.func.b.c.b(context);
        com.opos.cmn.an.f.a.a("AdInteractor", "instant origin =" + str + ",secret =" + str2 + ",url =" + str3 + ",traceId =" + str4);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && zB) {
            com.opos.mobad.cmn.func.b.g.a(context, str, str2, str3, new Callback() { // from class: com.opos.mobad.g.1
                @Override // com.oplus.instant.router.callback.Callback
                public void onResponse(Callback.Response response) {
                    if (response.getCode() == 1) {
                        com.opos.cmn.an.f.a.a("AdInteractor", "instant jump success");
                        a.InterfaceC0722a interfaceC0722a2 = interfaceC0722a;
                        if (interfaceC0722a2 != null) {
                            interfaceC0722a2.a();
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.a("AdInteractor", "instant jump fail" + response.getCode());
                    a.InterfaceC0722a interfaceC0722a3 = interfaceC0722a;
                    if (interfaceC0722a3 != null) {
                        interfaceC0722a3.a(response.getCode(), response.getMsg());
                    }
                }
            }, str4);
            return;
        }
        if (interfaceC0722a != null) {
            String str5 = !zB ? "instant not install" : "";
            try {
                iIntValue = Integer.valueOf("0").intValue();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdInteractor", "executeInstant", e);
                iIntValue = 0;
            }
            interfaceC0722a.a(iIntValue, str5);
        }
        com.opos.cmn.an.f.a.a("AdInteractor", "executeInstant but fail");
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean b(Context context, String str, String str2) {
        return com.opos.mobad.cmn.func.b.g.b(context, str, com.opos.mobad.cmn.func.b.g.a(com.opos.mobad.c.b.j().c(), str2));
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean c(Context context, String str, String str2) {
        com.opos.cmn.an.f.a.a("AdInteractor", "open browser =" + str);
        return com.opos.cmn.biz.b.a.a(context, str, com.opos.mobad.cmn.func.b.g.a(com.opos.mobad.c.b.j().c(), str2));
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean d(Context context, String str, String str2) {
        com.opos.cmn.an.f.a.a("AdInteractor", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.mobad.cmn.func.b.g.c(context, str, com.opos.mobad.cmn.func.b.g.a(com.opos.mobad.c.b.j().c(), str2));
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean e(Context context, String str, String str2) {
        com.opos.cmn.an.f.a.a("AdInteractor", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.cmn.g.b.a.a.a(context, str, com.opos.mobad.cmn.func.b.g.a(com.opos.mobad.c.b.j().c(), str2));
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(Context context, String str, String str2, String str3, String str4) {
        com.opos.mobad.cmn.func.b.g.a(context, str, str2, str3, str4);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean b(Context context, String str, String str2, String str3) {
        return com.opos.mobad.cmn.func.b.i.b(context, str, str2, str3);
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(b bVar, String str, String str2, AdItemData adItemData, String str3, com.opos.mobad.p.a aVar) {
        AdActivity.a(bVar.b(), str, str2, adItemData, str3, aVar);
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(b bVar, String str, String str2, AdItemData adItemData, String str3, String str4, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, long j) {
        AdActivity.a(bVar.b(), str, str2, adItemData, str3, str4, aVar, cVar);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2) {
        return com.opos.mobad.cmn.func.b.g.a(context, str, com.opos.mobad.cmn.func.b.g.a(com.opos.mobad.c.b.j().c(), str2));
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2, String str3) {
        return com.opos.mobad.cmn.func.b.i.a(context, str, str2, str3);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleDLApk pkgName=");
        sb.append(str);
        sb.append(",posId=");
        sb.append(str2);
        sb.append(",channelPkg=");
        String str8 = com.igexin.push.core.b.m;
        sb.append(str3 != null ? str3 : com.igexin.push.core.b.m);
        sb.append(",trackContent=");
        sb.append(str5 != null ? str5 : com.igexin.push.core.b.m);
        sb.append(",trackReference=");
        if (str6 != null) {
            str8 = str6;
        }
        sb.append(str8);
        com.opos.cmn.an.f.a.a("AdInteractor", sb.toString());
        boolean zA = com.opos.mobad.cmn.func.b.d.a(context, str, str2, str3, str4, str5, str6, str7);
        com.opos.cmn.an.f.a.a("AdInteractor", "executeDownloadApp result = " + zA);
        return zA;
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleDLApk pkgName=");
        sb.append(str);
        sb.append(",posId=");
        sb.append(str2);
        sb.append(",channelPkg=");
        String str8 = com.igexin.push.core.b.m;
        sb.append(str3 != null ? str3 : com.igexin.push.core.b.m);
        sb.append(",trackContent=");
        sb.append(str5 != null ? str5 : com.igexin.push.core.b.m);
        sb.append(",trackReference=");
        if (str6 != null) {
            str8 = str6;
        }
        sb.append(str8);
        sb.append(",atd=");
        sb.append(z);
        com.opos.cmn.an.f.a.a("AdInteractor", sb.toString());
        boolean zA = com.opos.mobad.cmn.func.b.d.a(context, str, str2, str3, str4, str5, str6, null, str7, z);
        com.opos.cmn.an.f.a.a("AdInteractor", "executeDownloadApp result = " + zA);
        return zA;
    }
}
