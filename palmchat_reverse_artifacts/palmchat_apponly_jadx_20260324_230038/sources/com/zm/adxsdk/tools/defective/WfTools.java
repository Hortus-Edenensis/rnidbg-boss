package com.zm.adxsdk.tools.defective;

import android.text.TextUtils;
import android.util.Log;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.WfSlot;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import com.zm.adxsdk.tools.g;
import com.zm.adxsdk.tools.t;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfTools {
    public static void transportRequestResult(WfSlot wfSlot, boolean z, int i, String str) {
        g gVarA = g.a();
        gVarA.getClass();
        Log.d("DefectiveToolManager", "transportRequestResult slotId:" + (wfSlot != null ? wfSlot.getSlotId() : "") + "   result:" + z + "   code:" + i + "   msg:" + str);
        if (gVarA.c == null) {
            gVarA.c = new ConcurrentHashMap();
        }
        t tVar = new t();
        tVar.f16613a = wfSlot;
        tVar.b = z;
        tVar.c = str;
        System.currentTimeMillis();
        WfSlot wfSlot2 = tVar.f16613a;
        if (wfSlot2 == null || TextUtils.isEmpty(wfSlot2.getSlotId())) {
            return;
        }
        gVarA.c.put(tVar.f16613a.getSlotId(), tVar);
    }

    public static void transportWfConfig(WfConfig wfConfig) {
        g gVarA = g.a();
        gVarA.getClass();
        Log.d("DefectiveToolManager", "transportWfConfig :");
        if (wfConfig != null) {
            gVarA.f16604a = wfConfig;
        }
    }

    public static void transportWfRuntime(IWfRuntime iWfRuntime) {
        g gVarA = g.a();
        gVarA.getClass();
        Log.d("DefectiveToolManager", "transportWfRuntime :");
        if (iWfRuntime != null) {
            gVarA.b = iWfRuntime;
        }
    }
}
