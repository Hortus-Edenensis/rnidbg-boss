package com.zenmen.palmchat.deamon.mob;

import defpackage.vt0;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum MobReportHelper {
    instance;

    public static final String EVENT_INIT = "lx_client_mob_0";
    public static final String EVENT_RECEIVER_ALIVE = "lx_client_mob_1";
    private long processInitTime = System.currentTimeMillis();

    MobReportHelper() {
    }

    public static MobReportHelper getInstance() {
        return instance;
    }

    public void reportInit(int i) {
        HashMap map = new HashMap();
        map.put("result", Integer.valueOf(i));
        zn6.j(EVENT_INIT, null, map);
    }

    public void reportReceiver(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.processInitTime;
        int i2 = jCurrentTimeMillis < 2000 ? 1 : 0;
        vt0.d().n("from_mob");
        HashMap map = new HashMap();
        map.put("wake_type", Integer.valueOf(i));
        map.put("processState", Integer.valueOf(i2));
        map.put("timeSpace", Long.valueOf(jCurrentTimeMillis));
        zn6.j(EVENT_RECEIVER_ALIVE, null, map);
    }
}
