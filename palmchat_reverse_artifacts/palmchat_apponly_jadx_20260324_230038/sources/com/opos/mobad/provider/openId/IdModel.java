package com.opos.mobad.provider.openId;

import android.content.Context;
import android.text.TextUtils;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class IdModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.openId.IdModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IdModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            IdModelIdentify idModelIdentify = (IdModelIdentify) iBridgeTargetIdentify;
            return IdModel.b(context.getApplicationContext(), idModelIdentify.f9165a, idModelIdentify.b);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IdModel f9164a;
    private Context b;
    private boolean c;
    private String d;
    private b e;

    private IdModel(Context context, boolean z, String str) {
        this.b = context;
        this.c = z;
        this.d = str;
        this.e = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IdModel b(Context context, boolean z, String str) {
        if (f9164a == null) {
            synchronized (IdModel.class) {
                if (f9164a == null) {
                    f9164a = new IdModel(context, z, str);
                }
            }
        }
        return f9164a;
    }

    @BridgeMethod(methodId = 3)
    public String c() {
        return "";
    }

    @BridgeMethod(methodId = 4)
    public OpenIdData d() {
        String strA = this.e.a();
        String strB = this.e.b();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.opos.cmn.an.f.a.b("IdModel", "readOutOpenId");
        return new OpenIdData(strA, strB, "");
    }

    @BridgeMethod(methodId = 5)
    public OutOpenIdWrapper e() {
        return new OutOpenIdWrapper(b.f9167a.a());
    }

    @BridgeMethod(methodId = 6)
    public boolean f() {
        return com.opos.cmn.g.a.b.e(this.b);
    }

    @BridgeMethod(methodId = 7)
    public boolean g() {
        return this.e.c();
    }

    @BridgeMethod(methodId = 1)
    public OpenIdData a() {
        String strB = com.opos.cmn.g.a.b.b(this.b);
        String strA = com.opos.cmn.g.a.b.a(this.b);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String strC = com.opos.cmn.an.f.a.b(this.b) ? null : com.opos.cmn.g.a.b.c(this.b);
        com.opos.cmn.an.f.a.b("IdModel", "readOpenId");
        return new OpenIdData(strA, strB, strC);
    }

    @BridgeMethod(methodId = 2)
    public boolean b() {
        return com.opos.cmn.g.a.b.g(this.b);
    }
}
