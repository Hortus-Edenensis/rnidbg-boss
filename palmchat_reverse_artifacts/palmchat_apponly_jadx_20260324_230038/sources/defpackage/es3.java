package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Pair;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class es3 {
    public static boolean a(String str) {
        int iIntValue;
        if (!TextUtils.isEmpty(str)) {
            if (ve.d(str) || bu3.g().e(AppContext.getContext(), str) != null) {
                return true;
            }
            Pair<Integer, ContentValues> pairG = mb4.g(str);
            if (pairG != null && ((iIntValue = ((Integer) pairG.first).intValue()) == 0 || iIntValue == 6 || iIntValue == 1 || iIntValue == 4 || iIntValue == 5 || iIntValue == 8)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("gbCfg");
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optBoolean("unknownSchemeDiscard", false);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(String str, String str2, int i) {
        Map<String, y56> mapA;
        boolean z = false;
        if (i == 10002) {
            if (!TextUtils.isEmpty(str) && b(str) && i == 10002 && (mapA = new x36(d(str2)).a()) != null && mapA.size() > 0) {
                Iterator<Map.Entry<String, y56>> it = mapA.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!a(it.next().getKey())) {
                        z = true;
                        break;
                    }
                }
            }
            LogUtil.i("MsgSchemeProcessor", "needDiscardWithUnknownScheme" + z + " type=" + i + " ext=" + str + " text=" + str2);
        }
        return z;
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }
}
