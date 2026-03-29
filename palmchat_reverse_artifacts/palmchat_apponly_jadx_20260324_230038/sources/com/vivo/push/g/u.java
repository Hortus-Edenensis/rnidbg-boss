package com.vivo.push.g;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class u extends aa {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    public u(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        if (vVar == null) {
            com.vivo.push.util.t.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        Context context = this.f11282a;
        boolean zD = com.vivo.push.util.z.d(context, context.getPackageName());
        if (!zD && !qVar.f()) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> map = new HashMap<>();
            map.put(com.heytap.mcssdk.constant.b.c, String.valueOf(qVar.g()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            xVar.a(map);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f11282a.getPackageName() + " isMsgNoShowOnForeground :" + qVar.g());
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(qVar.g())));
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f11282a), qVar.e(), qVar.j())) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(com.heytap.mcssdk.constant.b.c, String.valueOf(qVar.g()));
            String strA2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA2)) {
                map2.put("remoteAppId", strA2);
            }
            xVar2.a(map2);
            com.vivo.push.m.a().a(xVar2);
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "vertifyMsg not match =" + qVar.g());
            return;
        }
        InsideNotificationItem insideNotificationItemD = qVar.d();
        if (insideNotificationItemD == null) {
            com.vivo.push.util.t.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.t.c(this.f11282a, "通知内容为空，" + qVar.g());
            com.vivo.push.util.f.a(qVar.g(), 1027L);
            return;
        }
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "targetType is " + insideNotificationItemD.getTargetType() + " ; target is " + insideNotificationItemD.getTargetContent());
        com.vivo.push.t.c(new v(this, insideNotificationItemD, qVar, zD));
    }
}
