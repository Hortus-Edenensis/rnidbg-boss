package com.opos.mobad.provider.monitor;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MonitorModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.monitor.MonitorModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MonitorModel.b(context.getApplicationContext());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile MonitorModel f9163a;
    private Context b;

    private MonitorModel(Context context) {
        this.b = context;
        com.opos.cmn.biz.monitor.a.a().a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MonitorModel b(Context context) {
        if (f9163a != null) {
            return f9163a;
        }
        synchronized (MonitorModel.class) {
            if (f9163a == null) {
                f9163a = new MonitorModel(context);
            }
        }
        return f9163a;
    }

    @BridgeMethod(methodId = 1)
    public void a(String str, MonitorEvent monitorEvent) {
        com.opos.cmn.biz.monitor.a.a().a(this.b, str, monitorEvent);
    }
}
