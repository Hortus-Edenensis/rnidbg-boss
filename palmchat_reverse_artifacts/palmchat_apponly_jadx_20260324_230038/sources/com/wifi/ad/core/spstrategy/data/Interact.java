package com.wifi.ad.core.spstrategy.data;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.EventParams;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class Interact {
    public InteractItemType adx;
    public InteractItemType csj;
    public int fixed_interval_extra = -1;
    public InteractItemType ks;
    public String timing;

    private JSONObject getTypeObj(InteractItemType interactItemType) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wipe_screen_extra", interactItemType.wipe_screen_extra);
            List<Integer> list = interactItemType.interactive_type;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < interactItemType.interactive_type.size(); i++) {
                    jSONArray.put(interactItemType.interactive_type.get(i));
                }
                jSONObject.put(EventParams.KEY_INTERACTIVETYPE, jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fixed_interval_extra", this.fixed_interval_extra);
            jSONObject.put("timing", this.timing);
            InteractItemType interactItemType = this.adx;
            if (interactItemType != null) {
                jSONObject.put("adx", getTypeObj(interactItemType));
            }
            InteractItemType interactItemType2 = this.csj;
            if (interactItemType2 != null) {
                jSONObject.put("csj", getTypeObj(interactItemType2));
            }
            InteractItemType interactItemType3 = this.ks;
            if (interactItemType3 != null) {
                jSONObject.put("ks", getTypeObj(interactItemType3));
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
