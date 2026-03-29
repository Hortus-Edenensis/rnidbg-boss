package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.f.b;
import com.opos.cmn.f.c;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StatisticModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.statistic.StatisticModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public StatisticModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            StatisticModelIdentify statisticModelIdentify = (StatisticModelIdentify) iBridgeTargetIdentify;
            return StatisticModel.a(context.getApplicationContext(), statisticModelIdentify.c, statisticModelIdentify.f9175a, statisticModelIdentify.b);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static StatisticModel f9174a;
    private Context b;

    private StatisticModel(Context context, String str, boolean z, String str2) {
        this.b = context;
        str2 = TextUtils.isEmpty(str2) ? "CN" : str2;
        b bVarA = c.a();
        Context context2 = this.b;
        bVarA.a(context2, str, com.opos.cmn.an.c.a.a(context2), str2, z);
    }

    public static StatisticModel a(Context context, String str, boolean z, String str2) {
        StatisticModel statisticModel = f9174a;
        if (statisticModel == null) {
            synchronized (StatisticModel.class) {
                statisticModel = f9174a;
                if (statisticModel == null) {
                    statisticModel = new StatisticModel(context, str, z, str2);
                    f9174a = statisticModel;
                }
            }
        }
        return statisticModel;
    }

    public Map<String, String> b(String str) throws JSONException {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return map;
    }

    @BridgeMethod(methodId = 2)
    public final void a(String str) {
    }

    @BridgeMethod(methodId = 1)
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            a(str, b(str2));
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.b("StatisticModel", "transport fail", e);
        }
    }

    private void a(String str, Map<String, String> map) {
        com.opos.cmn.an.f.a.a("StatisticModel", "report transport params =" + str);
        com.opos.cmn.an.f.a.a("StatisticModel", "report params =", map);
        c.a().a(this.b, str, map);
    }
}
