package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class p implements com.baidu.platform.comjni.map.basemap.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f4215a = "com.baidu.platform.comapi.map.p";
    Map<Long, InnerOverlay> b = new ConcurrentHashMap();
    AppBaseMap c;

    public p(AppBaseMap appBaseMap) {
        this.c = appBaseMap;
    }

    public void a(InnerOverlay innerOverlay) {
        this.b.put(Long.valueOf(innerOverlay.mLayerID), innerOverlay);
        innerOverlay.SetMapParam(innerOverlay.mLayerID, this.c);
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long j) {
        return this.b.containsKey(Long.valueOf(j));
    }

    @Override // com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle bundle, long j, int i) {
        long jCurrentTimeMillis = k.f4213a ? System.currentTimeMillis() : 0L;
        InnerOverlay innerOverlay = this.b.get(Long.valueOf(j));
        if (innerOverlay != null && (innerOverlay instanceof com.baidu.mapsdkplatform.comapi.map.z.a)) {
            com.baidu.mapsdkplatform.comapi.map.z.a aVar = (com.baidu.mapsdkplatform.comapi.map.z.a) innerOverlay;
            if (aVar.c()) {
                bundle.putString("statusupdate", innerOverlay.getData());
                if (!aVar.b()) {
                    aVar.c(false);
                }
                return aVar.getType();
            }
        }
        if (innerOverlay == null) {
            return 0;
        }
        String data = innerOverlay.getData();
        if (this.c.LayersIsShow(j)) {
            bundle.putString("jsondata", data);
            Bundle param = innerOverlay.getParam();
            if (param != null) {
                bundle.putBundle(RemoteMessageConst.MessageBody.PARAM, param);
            }
        } else {
            bundle.putString("jsondata", null);
        }
        if (k.f4213a) {
            k.a(f4215a, "MapLayerDataReq:" + j + " tag:" + innerOverlay.getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms] LayerData:" + data);
        }
        return innerOverlay.getType();
    }

    public void a(Overlay overlay) {
        this.b.remove(Long.valueOf(overlay.mLayerID));
    }

    public void a() {
        if (this.c != null) {
            for (Long l : this.b.keySet()) {
                if (l.longValue() > 0) {
                    this.c.ClearLayer(l.longValue());
                    this.c.RemoveLayer(l.longValue());
                }
            }
        }
        this.b.clear();
    }
}
