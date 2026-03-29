package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class o implements ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final XMPushService f11765a;

    public o(XMPushService xMPushService) {
        this.f11765a = xMPushService;
    }

    @Override // com.xiaomi.push.ge
    public void a(final List<gj> list, final String str, final String str2) {
        this.f11765a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                String strA = o.this.a(str);
                ArrayList<he> arrayListA = az.a(list, str, strA, 32768);
                if (arrayListA == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                    return;
                }
                for (he heVar : arrayListA) {
                    heVar.a("uploadWay", "longXMPushService");
                    hb hbVarA = w.a(str, strA, heVar, gf.Notification);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                        if (hbVarA.m553a() == null) {
                            gs gsVar = new gs();
                            gsVar.a("-1");
                            hbVarA.a(gsVar);
                        }
                        hbVarA.m553a().b("ext_traffic_source_pkg", str2);
                    }
                    o.this.f11765a.a(str, hp.a(hbVarA), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f11765a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}
