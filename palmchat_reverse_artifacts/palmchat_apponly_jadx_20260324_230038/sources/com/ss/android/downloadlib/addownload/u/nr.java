package com.ss.android.downloadlib.addownload.u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.l;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class nr {
    public void nr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), str, 0).edit().putString(str2, "").apply();
    }

    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> u(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.nr.u uVarU = com.ss.android.downloadlib.addownload.nr.u.u(jSONObject.optJSONObject(itKeys.next()));
                    if (uVarU != null) {
                        copyOnWriteArrayList.add(uVarU);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return copyOnWriteArrayList;
    }

    public void u(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.nr.u uVar : copyOnWriteArrayList) {
                if (uVar != null) {
                    jSONObject.put(String.valueOf(uVar.nr), uVar.u());
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
