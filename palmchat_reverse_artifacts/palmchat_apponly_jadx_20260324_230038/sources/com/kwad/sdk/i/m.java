package com.kwad.sdk.i;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class m {
    private static final Map<String, k> aYd = new ConcurrentHashMap();
    private static long aYe;

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void B(List<k> list) {
        if (list != null) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                aYd.remove(it.next().actionId);
            }
        }
    }

    public static void Pf() {
        long jCurrentTimeMillis = System.currentTimeMillis() - aYe;
        if (aYd.size() <= 0 || jCurrentTimeMillis <= h.OS().OY()) {
            return;
        }
        aYe = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        actionList.size();
        j.Pd();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.Pd();
                m.B(actionList);
            }
        });
    }

    @WorkerThread
    public static synchronized void a(i iVar, boolean z) {
        Map<String, k> map = aYd;
        if (map.size() > 200) {
            j.al("LogRequestManger", "enqueueAction fail size limit");
        } else {
            k kVarB = b(iVar, z);
            map.put(kVarB.actionId, kVarB);
        }
        Pf();
    }

    private static k b(i iVar, boolean z) {
        com.kwai.adclient.kscommerciallogger.model.c cVarVh = (z ? c.a.Vf() : c.a.Vg()).c(BusinessType.OTHER).b(SubBusinessType.OTHER).m69if("ad_sdk_local_log").ie(iVar.aXW).B(iVar.toJson()).Vh();
        return new k(cVarVh.UZ(), cVarVh.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        Map<String, k> map = aYd;
        arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }
}
