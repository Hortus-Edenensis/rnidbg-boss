package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface MapSDKLayerDataInterface extends a {
    @Override // com.baidu.platform.comjni.map.basemap.a
    boolean hasLayer(long j);

    @Override // com.baidu.platform.comjni.map.basemap.a
    int mapLayerDataReq(Bundle bundle, long j, int i);
}
