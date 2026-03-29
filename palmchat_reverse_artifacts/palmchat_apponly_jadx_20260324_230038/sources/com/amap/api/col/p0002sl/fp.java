package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.dt;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fp implements IWeatherSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2786a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f;

    public fp(Context context) throws AMapException {
        this.f = null;
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.f2786a = context.getApplicationContext();
        this.f = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fp.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (fp.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            di.a(e, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        }
                    }
                    if (fp.this.b.getType() == 1) {
                        try {
                            try {
                                fp fpVar = fp.this;
                                fpVar.d = fpVar.a();
                                bundle.putInt("errorCode", 1000);
                                return;
                            } finally {
                                dt.o oVar = new dt.o();
                                messageObtainMessage.what = 1301;
                                oVar.b = fp.this.c;
                                oVar.f2714a = fp.this.d;
                                messageObtainMessage.obj = oVar;
                                messageObtainMessage.setData(bundle);
                                fp.this.f.sendMessage(messageObtainMessage);
                            }
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            di.a(e2, "WeatherSearch", "searchWeatherAsyn");
                            return;
                        } catch (Throwable th) {
                            di.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                            return;
                        }
                    }
                    if (fp.this.b.getType() == 2) {
                        try {
                            try {
                                fp fpVar2 = fp.this;
                                fpVar2.e = fpVar2.b();
                                bundle.putInt("errorCode", 1000);
                            } finally {
                                dt.n nVar = new dt.n();
                                messageObtainMessage.what = 1302;
                                nVar.b = fp.this.c;
                                nVar.f2713a = fp.this.e;
                                messageObtainMessage.obj = nVar;
                                messageObtainMessage.setData(bundle);
                                fp.this.f.sendMessage(messageObtainMessage);
                            }
                        } catch (AMapException e3) {
                            bundle.putInt("errorCode", e3.getErrorCode());
                            di.a(e3, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th2) {
                            di.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        dr.a(this.f2786a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        ew ewVar = new ew(this.f2786a, weatherSearchQuery);
        return LocalWeatherForecastResult.createPagedResult(ewVar.i(), ewVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        dr.a(this.f2786a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            ex exVar = new ex(this.f2786a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult(exVar.i(), exVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
