package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6350a = "a";

    @Override // com.heytap.mcssdk.e.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return a(intent, i);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.heytap.mcssdk.e.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseMode a(Intent intent, int i) {
        com.heytap.mcssdk.c.b bVar;
        Exception e;
        com.heytap.mcssdk.c.b bVar2 = null;
        try {
            bVar = new com.heytap.mcssdk.c.b();
            try {
                try {
                    bVar.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.y))));
                    bVar.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
                    bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
                    bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.z)));
                    bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
                    bVar.g(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.e)));
                    String str = f6350a;
                    com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() finally will get miniProgramPkg");
                    try {
                        com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
                    } catch (Exception e2) {
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e2.getMessage() + " ");
                    }
                    return bVar;
                } catch (Exception e3) {
                    e = e3;
                    com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
                    String str2 = f6350a;
                    com.heytap.mcssdk.utils.d.b(str2, "parseMessageByIntent() finally will get miniProgramPkg");
                    if (bVar != null) {
                        try {
                            com.heytap.mcssdk.utils.d.b(str2, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                            bVar.f(intent.getStringExtra("miniProgramPkg"));
                            com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
                        } catch (Exception e4) {
                            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e4.getMessage() + " ");
                        }
                    }
                    return bVar;
                }
            } catch (Throwable unused) {
                bVar2 = bVar;
                String str3 = f6350a;
                com.heytap.mcssdk.utils.d.b(str3, "parseMessageByIntent() finally will get miniProgramPkg");
                if (bVar2 != null) {
                    try {
                        com.heytap.mcssdk.utils.d.b(str3, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar2.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar2.toString());
                    } catch (Exception e5) {
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e5.getMessage() + " ");
                    }
                }
                return bVar2;
            }
        } catch (Exception e6) {
            bVar = null;
            e = e6;
        } catch (Throwable unused2) {
            String str32 = f6350a;
            com.heytap.mcssdk.utils.d.b(str32, "parseMessageByIntent() finally will get miniProgramPkg");
            if (bVar2 != null) {
            }
            return bVar2;
        }
    }
}
