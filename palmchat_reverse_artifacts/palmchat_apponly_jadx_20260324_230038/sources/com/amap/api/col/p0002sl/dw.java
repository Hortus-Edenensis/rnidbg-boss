package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dw extends da<UploadInfo, Integer> {
    private Context g;
    private UploadInfo h;

    public dw(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.g = context;
        this.h = uploadInfo;
    }

    private static Integer i() throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return i();
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.d() + "/nearby/data/create";
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(this.g));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.h.getUserID());
        LatLonPoint point = this.h.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.h.getCoordType());
        return stringBuffer.toString();
    }
}
