package com.zenmen.find.bean;

import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.palmchat.location.LocationEx;
import defpackage.az2;
import defpackage.b05;
import defpackage.uj5;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class DriftInfo {
    public LocationEx location;
    public boolean firstDrift = true;
    public int driftScene = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$mergeParams$0(DriftInfo driftInfo) {
        return "请求前的DriftInfo====>" + az2.c(driftInfo);
    }

    public void mergeParams(JSONObject jSONObject) {
        if (uj5.a()) {
            final DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
            b05.c(new b05.a() { // from class: bh1
                @Override // b05.a
                public final Object getValue() {
                    return DriftInfo.lambda$mergeParams$0(this.f1716a);
                }
            });
            if (driftInfo.valid()) {
                try {
                    jSONObject.put("drift", true);
                    jSONObject.put("driftLongitude", driftInfo.location.getLongitude());
                    jSONObject.put("driftLatitude", driftInfo.location.getLatitude());
                    jSONObject.put("firstDrift", driftInfo.firstDrift);
                    jSONObject.put("driftScene", driftInfo.driftScene);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean valid() {
        return this.location != null;
    }
}
