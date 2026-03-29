package com.opos.mobad.provider.init;

import android.content.Context;
import com.opos.cmn.an.custom.policy.PolicyConfig;
import com.opos.cmn.an.custom.policy.PolicyManager;
import com.opos.cmn.biz.a.d;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class InitModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.init.InitModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return InitModel.b(context.getApplicationContext());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile InitModel f9162a;
    private Context b;

    public InitModel(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitModel b(Context context) {
        if (f9162a != null) {
            return f9162a;
        }
        synchronized (InitModel.class) {
            if (f9162a == null) {
                f9162a = new InitModel(context);
            }
        }
        return f9162a;
    }

    private static void a() {
        HashMap map = new HashMap();
        map.put(PolicyConfig.UserData.KEY_IMEI, Boolean.FALSE);
        PolicyManager.getInstance().setPolicyConfig(new PolicyConfig.Builder().setCanReadUserDataMap(map).build());
    }

    @BridgeMethod(methodId = 1)
    public void a(boolean z, boolean z2, String str) {
        a();
        com.opos.cmn.c.a.a(this.b.getApplicationContext(), z, z2);
        d.a(this.b.getApplicationContext(), str);
        com.opos.cmn.an.f.a.b("InitModel", "init() isDebug=", Boolean.valueOf(z), "touristMode=", Boolean.valueOf(z2), "region=", str);
    }
}
