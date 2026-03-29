package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ew extends ey<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast g;

    public ew(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.g = new LocalWeatherForecast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public LocalWeatherForecast a(String str) throws AMapException {
        LocalWeatherForecast localWeatherForecastH = dq.h(str);
        this.g = localWeatherForecastH;
        return localWeatherForecastH;
    }

    @Override // com.amap.api.col.p0002sl.ey, com.amap.api.col.p0002sl.id
    public final /* bridge */ /* synthetic */ String f() {
        return super.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) ((cz) this).b).getCity();
        if (!dq.i(city)) {
            String strB = da.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strB);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + fr.f(((cz) this).e));
        return stringBuffer.toString();
    }
}
