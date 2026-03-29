package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile StStrategyManager f7721a;
    private static final byte[] b = new byte[0];
    private static AtomicBoolean c = new AtomicBoolean(false);

    public static StStrategyManager a(Context context) {
        if (f7721a == null) {
            synchronized (b) {
                if (f7721a == null) {
                    f7721a = StStrategyManager.getInstance(context);
                }
            }
        }
        return f7721a;
    }

    public static void b(Context context) {
        if (context != null) {
            try {
                a(context, context.getPackageName());
            } catch (Exception e) {
                f.b("StrategyUtil", "", e);
            }
        }
    }

    public static STConfigEntity c(Context context) {
        STConfigEntity sTConfigEntity = null;
        if (context != null) {
            try {
                sTConfigEntity = a(context).getSTConfigEntity();
            } catch (Exception e) {
                f.b("StrategyUtil", "", e);
            }
            if (sTConfigEntity == null) {
                f.a("StrategyUtil", "get stConfigEntity == null");
            }
        }
        return sTConfigEntity;
    }

    public static void b(final Context context, final String str) {
        if (context != null) {
            try {
                if (c.get()) {
                    f.b("StrategyUtil", "update config by dataType do nothing!");
                } else {
                    StStrategyManager.setStVerCode(3013000);
                    a(context).updateSTConfigsByDataType(str, new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.i.2
                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public void onFail() {
                            f.a("StrategyUtil", "onFail dataType:" + str);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public void onNotNeedUpdate() {
                            f.a("StrategyUtil", "onNotNeedUpdate dataType:" + str);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public void onSuccess() {
                            f.a("StrategyUtil", "onSuccess dataType:" + str);
                            k.m(context);
                            k.l(context);
                        }
                    });
                }
            } catch (Exception e) {
                f.c("StrategyUtil", "", e);
            }
        }
    }

    public static void a(final Context context, final String str) {
        if (context != null) {
            try {
                c.set(true);
                StStrategyManager.setStVerCode(3013000);
                a(context).updateSTConfigsByPkgName(new UpdateParams.Builder().setPkgName(str).build(), new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.i.1
                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public void onFail() {
                        i.c.set(false);
                        f.a("StrategyUtil", "onFail pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public void onNotNeedUpdate() {
                        i.c.set(false);
                        f.a("StrategyUtil", "onNotNeedUpdate pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public void onSuccess() {
                        f.a("StrategyUtil", "onSuccess pkgName:" + str);
                        i.c.set(false);
                        k.m(context);
                        k.l(context);
                    }
                });
            } catch (Exception e) {
                c.set(false);
                f.b("StrategyUtil", "", e);
            }
        }
    }
}
