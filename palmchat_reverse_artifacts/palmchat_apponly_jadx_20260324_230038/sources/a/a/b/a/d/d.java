package a.a.b.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import defpackage.pn;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1082a = new d();

    public final c a(Context context) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_bd_convert_hume_sdk", 0);
        if (sharedPreferences.getBoolean("has_read", false)) {
            return b(context);
        }
        try {
            String strA = a.a.b.a.c.a.a.a(context);
            Intrinsics.checkNotNullExpressionValue(strA, "HumeSDK.getExtra(context)");
            int length = strA.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) strA.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String string = strA.subSequence(i, length + 1).toString();
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                c cVar = new c(jSONObject.optString(AdBaseConstants.MARKET_OPEN_CLICK_ID), jSONObject.optString("click_id_nature"), jSONObject.optString("hume_channel_id"), f.APK);
                a(context, cVar);
                return cVar;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sharedPreferences.edit().putBoolean("has_read", true).apply();
        return b(context);
    }

    public final c b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_bd_convert_click_id", 0);
        f fVarValueOf = null;
        String string = sharedPreferences.getString(AdBaseConstants.MARKET_OPEN_CLICK_ID, null);
        String string2 = sharedPreferences.getString("click_id_source", null);
        String string3 = sharedPreferences.getString("click_id_nature", null);
        String string4 = sharedPreferences.getString("hume_channel_id", null);
        if (string2 != null) {
            try {
                fVarValueOf = f.valueOf(string2);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return new c(string, string3, string4, fVarValueOf);
    }

    public final void a(Context context, c info) {
        f fVarValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_bd_convert_click_id", 0);
        String strName = null;
        String string = sharedPreferences.getString("click_id_source", null);
        if (string == null) {
            fVarValueOf = null;
        } else {
            try {
                fVarValueOf = f.valueOf(string);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                fVarValueOf = null;
            }
        }
        if (fVarValueOf != null) {
            int iOrdinal = fVarValueOf.ordinal();
            f fVar = info.e;
            Intrinsics.checkNotNull(fVar);
            if (iOrdinal <= fVar.ordinal()) {
                z = true;
            }
        }
        String msg = "saveByPriority: ignore:" + z + " old:" + string + " new:" + info.e;
        Intrinsics.checkNotNullParameter("Convert:ClickIdSPUtil", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (pn.d.a().getEnableLog()) {
            Log.d("Convert:ClickIdSPUtil", msg);
        }
        if (z) {
            return;
        }
        SharedPreferences.Editor editorPutString = sharedPreferences.edit().putString(AdBaseConstants.MARKET_OPEN_CLICK_ID, info.b);
        f fVar2 = info.e;
        if (fVar2 != null) {
            Intrinsics.checkNotNull(fVar2);
            strName = fVar2.name();
        }
        editorPutString.putString("click_id_source", strName).putString("click_id_nature", info.c).putString("hume_channel_id", info.d).apply();
    }
}
