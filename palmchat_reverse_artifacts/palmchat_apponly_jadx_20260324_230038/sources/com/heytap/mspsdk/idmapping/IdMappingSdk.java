package com.heytap.mspsdk.idmapping;

import android.content.Context;
import com.heytap.mspsdk.idmapping.impl.IdMappingImpl;
import com.heytap.mspsdk.listener.a;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class IdMappingSdk {
    public static void getData(Context context, HashMap<String, String> map, a aVar, boolean z) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("map of parms should not be empty");
        }
        IdMappingImpl.getData(context, map, IdMappingImpl.obtainCallback(aVar), z, aVar);
    }

    public static void getVersionCode(Context context, a aVar, boolean z) {
        IdMappingImpl.getVersionCode(context, aVar, z);
    }

    public static void init(Context context, a aVar, boolean z) {
        IdMappingImpl.init(context, aVar, z);
    }
}
