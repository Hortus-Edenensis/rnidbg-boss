package com.heytap.mspsdk.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.msp.ipc.a.l;
import com.heytap.msp.ipc.a.m;
import com.heytap.mspsdk.log.MspLog;
import defpackage.gh7;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements m, com.heytap.msp.ipc.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.heytap.mspsdk.core.b f6407a;

    public c(com.heytap.mspsdk.core.b bVar) {
        this.f6407a = bVar;
    }

    @Override // com.heytap.msp.ipc.a.m
    public l a(Context context, l lVar) {
        String strA = lVar.a();
        com.heytap.mspsdk.core.b bVar = this.f6407a;
        if (bVar != null) {
            strA = bVar.f();
        }
        String strB = lVar.b();
        String strC = lVar.c();
        if (!TextUtils.isEmpty(strB) && strB.contains("${applicationId}")) {
            String strReplace = strB.replace("${applicationId}", strA);
            MspLog.v("ApiProxy", "replace package = " + strReplace);
            return l.a(strA, strReplace);
        }
        if (TextUtils.isEmpty(strC)) {
            return lVar;
        }
        if (strC.contains("${applicationId}")) {
            strC = strC.replace("${applicationId}", strA);
            MspLog.v("ApiProxy", "replace package = " + strC);
        }
        return l.b(strA, strC);
    }

    @Override // com.heytap.msp.ipc.a.m
    public /* synthetic */ List a_(Context context, List list) {
        return gh7.b(this, context, list);
    }

    @Override // com.heytap.msp.ipc.c.a
    public l a(Context context, List<l> list) {
        if (list != null && !list.isEmpty()) {
            for (l lVar : list) {
                if (TextUtils.equals(lVar.a(), this.f6407a.f())) {
                    MspLog.iIgnore("ApiProxy", "filter target = " + lVar);
                    return lVar;
                }
            }
        }
        return null;
    }
}
