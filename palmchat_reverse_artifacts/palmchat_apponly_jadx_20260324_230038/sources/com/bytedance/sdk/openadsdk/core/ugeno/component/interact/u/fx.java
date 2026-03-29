package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static boolean b(Context context) {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }

    public static Vibrator fx(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void nr(Context context) {
        Vibrator vibratorFx = fx(context);
        if (vibratorFx != null) {
            vibratorFx.cancel();
        }
    }

    private static boolean pn(Context context) {
        Vibrator vibratorFx = fx(context);
        return vibratorFx != null && vibratorFx.hasVibrator();
    }

    public static boolean u(Context context) {
        return b(context) && pn(context);
    }

    public static void u(Context context, h hVar) {
        new u(context, hVar).nr();
    }

    public static void u(JSONObject jSONObject, Context context, bc bcVar) {
        h hVarU;
        if (jSONObject == null || context == null) {
            return;
        }
        String strOptString = jSONObject.optString("id");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pattern");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            u(context, new h(strOptString, jSONArrayOptJSONArray));
        } else {
            if (TextUtils.isEmpty(strOptString) || bcVar == null || (hVarU = bcVar.u(strOptString)) == null) {
                return;
            }
            u(context, hVarU);
        }
    }
}
