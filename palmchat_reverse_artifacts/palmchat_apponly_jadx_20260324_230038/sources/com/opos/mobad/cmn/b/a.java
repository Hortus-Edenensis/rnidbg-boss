package com.opos.mobad.cmn.b;

import com.baidu.location.LocationConst;
import com.huawei.openalliance.ad.constant.bq;
import com.nearme.play.api.AdTrialGameInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static AdTrialGameInfo a(JSONObject jSONObject) {
        AdTrialGameInfo adTrialGameInfo = new AdTrialGameInfo();
        if (jSONObject != null) {
            try {
                adTrialGameInfo.setGamePic(jSONObject.optString("gamePic"));
                adTrialGameInfo.setId(jSONObject.optString("id"));
                adTrialGameInfo.setName(jSONObject.optString("name"));
                adTrialGameInfo.setOrientation(Integer.valueOf(jSONObject.optInt(bq.f.V)));
                adTrialGameInfo.setSize(Integer.valueOf(jSONObject.optInt("size")));
                adTrialGameInfo.setvId(Long.valueOf(jSONObject.optLong("vId")));
                adTrialGameInfo.setUrl(jSONObject.optString("url"));
                adTrialGameInfo.setState(Integer.valueOf(jSONObject.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE)));
                adTrialGameInfo.setPkgName(jSONObject.optString("pkgName"));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdTrialGameInfoUtils", "newInstance() fail", e);
            }
        }
        return adTrialGameInfo;
    }

    public static String b(AdTrialGameInfo adTrialGameInfo) {
        String pkgName = adTrialGameInfo != null ? adTrialGameInfo.getPkgName() : "";
        return (pkgName == null || !pkgName.endsWith(".rpk")) ? pkgName : pkgName.substring(0, pkgName.length() - 4);
    }

    public static JSONObject a(AdTrialGameInfo adTrialGameInfo) {
        JSONObject jSONObject = new JSONObject();
        if (adTrialGameInfo != null) {
            try {
                jSONObject.put("gamePic", adTrialGameInfo.getGamePic());
                jSONObject.put("id", adTrialGameInfo.getId());
                jSONObject.put("name", adTrialGameInfo.getName());
                jSONObject.put(bq.f.V, adTrialGameInfo.getOrientation());
                jSONObject.put("size", adTrialGameInfo.getSize());
                jSONObject.put("vId", adTrialGameInfo.getvId());
                jSONObject.put("url", adTrialGameInfo.getUrl());
                jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, adTrialGameInfo.getState());
                jSONObject.put("pkgName", adTrialGameInfo.getPkgName());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdTrialGameInfoUtils", "toJSONObject() fail", e);
            }
        }
        return jSONObject;
    }
}
