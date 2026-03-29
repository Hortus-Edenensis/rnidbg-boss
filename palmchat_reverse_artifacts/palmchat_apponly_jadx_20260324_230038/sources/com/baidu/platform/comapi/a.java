package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f4104a = false;
    private NAEngine b;

    public boolean a(Context context) {
        f4104a = false;
        this.b = new NAEngine();
        boolean zA = NAEngine.a(context, null);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("initEngine isEngineSuccess = " + zA);
        }
        if (zA) {
            return zA;
        }
        com.baidu.platform.comapi.d.a.a().a("engine_init_failed");
        return false;
    }

    public boolean b(Context context) {
        boolean zInitLongLinkClient = NAEngine.initLongLinkClient();
        if (zInitLongLinkClient) {
            return zInitLongLinkClient;
        }
        return false;
    }

    public boolean b() {
        f4104a = false;
        return true;
    }

    public void a() {
        if (f4104a) {
            b();
        }
        MessageProxy.destroy();
        NAEngine.c();
        if (this.b != null) {
            this.b = null;
        }
    }
}
