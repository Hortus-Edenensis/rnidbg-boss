package com.opos.mobad.cmn.b;

import android.content.Context;
import com.nearme.play.api.GameCard;
import com.nearme.play.api.GameCardSDK;
import com.nearme.play.api.InitParams;
import com.nearme.play.context.SdkCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    public static GameCard a() {
        if (!com.opos.mobad.o.c.a()) {
            return null;
        }
        try {
            return GameCardSDK.getInstance().getGlobalCard();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GameCardSDKUtils", "getGlobalCard() fail", e);
            return null;
        }
    }

    private static InitParams b() {
        if (!com.opos.mobad.o.c.a()) {
            return null;
        }
        try {
            return new InitParams.Builder().enableDebug(false).setEnv(0).build();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GameCardSDKUtils", "getInitParams() fail", e);
            return null;
        }
    }

    private static boolean c() {
        if (!com.opos.mobad.o.c.a()) {
            return false;
        }
        try {
            return GameCardSDK.getInstance().hasInit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GameCardSDKUtils", "hasInit() fail", e);
            return false;
        }
    }

    private static void a(Context context) {
        if (com.opos.mobad.o.c.a() && !c()) {
            try {
                GameCardSDK.getInstance().init(context, b());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GameCardSDKUtils", "init() fail", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SdkCallback sdkCallback) {
        try {
            GameCard gameCardA = a();
            if (gameCardA == null) {
                return;
            }
            c.a(gameCardA, sdkCallback);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GameCardSDKUtils", "preloadCore() fail", e);
        }
    }

    public static void a(Context context, final SdkCallback sdkCallback) {
        if (com.opos.mobad.o.c.a()) {
            a(context);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.b(sdkCallback);
                }
            });
            com.opos.cmn.an.f.a.b("GameCardSDKUtils", "preload()");
        }
    }
}
