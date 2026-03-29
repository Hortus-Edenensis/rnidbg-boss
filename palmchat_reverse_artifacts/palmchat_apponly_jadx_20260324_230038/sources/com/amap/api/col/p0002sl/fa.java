package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fa implements IAutoTSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2736a;
    private Handler b;
    private AutoTSearch.Query c;
    private AutoTSearch.OnChargeStationListener d;

    public fa(Context context) throws AMapException {
        this.b = null;
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2736a = context.getApplicationContext();
        this.b = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            dr.a(this.f2736a);
            AutoTSearch.Query query = this.c;
            if (query != null) {
                return new cw(this.f2736a, query.m16clone()).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            throw new AMapException(e.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void searchChargeStationAsync() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fa.1
                @Override // java.lang.Runnable
                public final void run() {
                    dt.a aVar;
                    Message messageObtainMessage = fa.this.b.obtainMessage();
                    messageObtainMessage.arg1 = 20;
                    messageObtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    AutoTChargeStationResult autoTChargeStationResultSearchChargeStation = null;
                    try {
                        try {
                            autoTChargeStationResultSearchChargeStation = fa.this.searchChargeStation();
                            bundle.putInt("errorCode", 1000);
                            aVar = new dt.a();
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            aVar = new dt.a();
                        }
                        aVar.b = fa.this.d;
                        aVar.f2700a = autoTChargeStationResultSearchChargeStation;
                        messageObtainMessage.obj = aVar;
                        messageObtainMessage.setData(bundle);
                        fa.this.b.sendMessage(messageObtainMessage);
                    } catch (Throwable th) {
                        dt.a aVar2 = new dt.a();
                        aVar2.b = fa.this.d;
                        aVar2.f2700a = autoTChargeStationResultSearchChargeStation;
                        messageObtainMessage.obj = aVar2;
                        messageObtainMessage.setData(bundle);
                        fa.this.b.sendMessage(messageObtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setQuery(AutoTSearch.Query query) {
        this.c = query;
    }
}
