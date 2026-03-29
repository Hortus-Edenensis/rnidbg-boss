package com.wifi.ad.core.spstrategy;

import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0002J \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018R\u0086\u0001\u0010\u0003\u001an\u0012\u0004\u0012\u00020\u0005\u0012,\u0012*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b0\u0004j6\u0012\u0004\u0012\u00020\u0005\u0012,\u0012*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPPkManager;", "", "()V", "allSDKPkCfg", "Ljava/util/HashMap;", "", "", "Lcom/wifi/ad/core/spstrategy/SPSDKDspModel;", "Lkotlin/collections/HashMap;", "getAllSDKPkCfg", "()Ljava/util/HashMap;", "setAllSDKPkCfg", "(Ljava/util/HashMap;)V", "determineECPMAdPosition", "curAds", "", "getPkcfgById", "strategyId", "ecpm", "", "ratioAds", "savePkcfg", "", "pkJsonArray", "Lorg/json/JSONArray;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPPkManager {
    public static final SPPkManager INSTANCE = new SPPkManager();
    private static HashMap<String, HashMap<String, List<SPSDKDspModel>>> allSDKPkCfg = new HashMap<>();

    private SPPkManager() {
    }

    private final SPSDKDspModel determineECPMAdPosition(List<SPSDKDspModel> curAds) {
        int iNextInt;
        if (curAds == null || curAds.size() <= 0) {
            return null;
        }
        int size = curAds.size();
        if (size == 1) {
            return curAds.get(0);
        }
        int weight = 0;
        for (int i = 0; i < size; i++) {
            try {
                weight += curAds.get(i).getWeight();
            } catch (Exception unused) {
            }
        }
        if (weight > 0) {
            Random random = new Random();
            random.nextInt();
            iNextInt = random.nextInt(weight);
        } else {
            iNextInt = 0;
        }
        int weight2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            try {
                SPSDKDspModel sPSDKDspModel = curAds.get(i2);
                weight2 += sPSDKDspModel.getWeight();
                if (iNextInt < weight2) {
                    curAds.remove(i2);
                    return sPSDKDspModel;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }

    private final List<SPSDKDspModel> ratioAds(List<SPSDKDspModel> curAds) {
        if (curAds == null || curAds.size() <= 1) {
            return curAds;
        }
        ArrayList arrayList = new ArrayList();
        int size = curAds.size();
        for (int i = 0; i < size; i++) {
            SPSDKDspModel sPSDKDspModelDetermineECPMAdPosition = determineECPMAdPosition(curAds);
            if (sPSDKDspModelDetermineECPMAdPosition != null) {
                arrayList.add(sPSDKDspModelDetermineECPMAdPosition);
            }
        }
        return arrayList;
    }

    public final HashMap<String, HashMap<String, List<SPSDKDspModel>>> getAllSDKPkCfg() {
        return allSDKPkCfg;
    }

    public final List<SPSDKDspModel> getPkcfgById(String strategyId, int ecpm) {
        HashMap<String, List<SPSDKDspModel>> map;
        if (strategyId == null || ecpm <= 0 || !allSDKPkCfg.containsKey(strategyId) || (map = allSDKPkCfg.get(strategyId)) == null) {
            return null;
        }
        if (map.containsKey(String.valueOf(ecpm))) {
            return map.get(String.valueOf(ecpm));
        }
        if (map.containsKey(MapController.DEFAULT_LAYER_TAG)) {
            return map.get(MapController.DEFAULT_LAYER_TAG);
        }
        return null;
    }

    public final void savePkcfg(String strategyId, JSONArray pkJsonArray) {
        if (allSDKPkCfg.containsKey(strategyId)) {
            return;
        }
        HashMap<String, List<SPSDKDspModel>> map = new HashMap<>();
        allSDKPkCfg.put(strategyId, map);
        int length = pkJsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = pkJsonArray.optJSONObject(i);
            String key = jSONObjectOptJSONObject.optString("price_tag");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("dsp_weight");
            ArrayList arrayList = new ArrayList();
            int length2 = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                SPSDKDspModel sPSDKDspModel = new SPSDKDspModel();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                sPSDKDspModel.setDspName(jSONObjectOptJSONObject2.optString("dspname"));
                sPSDKDspModel.setWeight(jSONObjectOptJSONObject2.optInt("weight"));
                arrayList.add(sPSDKDspModel);
            }
            List<SPSDKDspModel> listRatioAds = ratioAds(arrayList);
            if (listRatioAds == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(key, "key");
            map.put(key, listRatioAds);
        }
    }

    public final void setAllSDKPkCfg(HashMap<String, HashMap<String, List<SPSDKDspModel>>> map) {
        allSDKPkCfg = map;
    }
}
