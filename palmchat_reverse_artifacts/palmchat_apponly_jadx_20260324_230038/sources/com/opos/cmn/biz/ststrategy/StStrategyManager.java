package com.opos.cmn.biz.ststrategy;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.opos.cmn.biz.a.a;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.biz.ststrategy.utils.b;
import com.opos.cmn.g.a.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StStrategyManager {
    public static final String BRAND_OF_O = a.c;
    public static final String BRAND_OF_P = a.f7817a;
    public static final String BRAND_OF_R = a.b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7877a = "StStrategyManager";
    private static StStrategyManager b = null;
    private static int e = 3013000;
    private Context c;
    private com.opos.cmn.biz.ststrategy.interfaces.a d;

    private StStrategyManager(Context context) {
        this.d = null;
        this.c = context;
        RequestStatisticManager.getInstance().init(this.c, new InitParams.Builder().build());
        this.d = new com.opos.cmn.biz.ststrategy.impl.a(this.c);
    }

    public static StStrategyManager getInstance(Context context) {
        StStrategyManager stStrategyManager = b;
        if (stStrategyManager != null) {
            return stStrategyManager;
        }
        synchronized (StStrategyManager.class) {
            StStrategyManager stStrategyManager2 = b;
            if (stStrategyManager2 != null) {
                return stStrategyManager2;
            }
            if (context == null) {
                com.opos.cmn.an.f.a.b(f7877a, "StStrategyManager init context can not be null !");
                throw new NullPointerException("StStrategyManager init context can not be null !");
            }
            StStrategyManager stStrategyManager3 = new StStrategyManager(context.getApplicationContext());
            b = stStrategyManager3;
            return stStrategyManager3;
        }
    }

    public static int getStVerCode() {
        return e;
    }

    public static void setStVerCode(int i) {
        e = i;
    }

    @Deprecated
    public String getAnId(Context context) {
        return getCryptValueByKey("anId", b.a(context));
    }

    @Deprecated
    public String getGUID() {
        return getCryptValueByKey("guId", com.opos.cmn.g.a.b.c(this.c));
    }

    @Deprecated
    public String getImei() {
        return getCryptValueByKey(WkParams.IMEI, c.a(this.c));
    }

    public STConfigEntity getSTConfigEntity() {
        return this.d.a();
    }

    public void updateSTConfigsByDataType(String str, UpdateSTConfigListener updateSTConfigListener) {
        if (!TextUtils.isEmpty(str)) {
            this.d.a(str, updateSTConfigListener);
            return;
        }
        com.opos.cmn.an.f.a.b(f7877a, "updateParams dataType can not be null !");
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
        throw new Exception("please check your updateParams dataType");
    }

    public void updateSTConfigsByPkgName(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener) throws Exception {
        if (updateParams == null) {
            com.opos.cmn.an.f.a.b(f7877a, "updateParams can not be null !");
            if (updateSTConfigListener != null) {
                updateSTConfigListener.onFail();
            }
            throw new NullPointerException("updateParams can not be null !");
        }
        if (!TextUtils.isEmpty(updateParams.pkgName)) {
            this.d.a(updateParams, updateSTConfigListener);
            return;
        }
        com.opos.cmn.an.f.a.b(f7877a, "updateParams pkgName can not be null !");
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
        throw new Exception("please check your updateParams pkgName");
    }

    @Deprecated
    public String getCryptValueByKey(String str, String str2) {
        return str2;
    }
}
