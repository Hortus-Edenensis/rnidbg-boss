package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class du extends da<String, Integer> {
    private Context g;
    private String h;

    public du(Context context, String str) {
        super(context, str);
        this.g = context;
        this.h = str;
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
        return dh.d() + "/nearby/data/delete";
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(this.g));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }
}
