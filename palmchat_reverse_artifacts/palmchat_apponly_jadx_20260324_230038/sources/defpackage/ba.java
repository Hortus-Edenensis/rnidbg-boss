package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ba implements ik2 {
    public static ba c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<String, Pair<String, Boolean>> f1673a = null;
    public boolean b = false;

    public static ba c() {
        if (c == null) {
            c = new ba();
        }
        return c;
    }

    @Override // defpackage.ik2
    public Pair<String, Boolean> a(String str, Amulet amulet) {
        JSONObject jSONObjectOptJSONObject;
        boolean z = true;
        boolean zBooleanValue = false;
        String strOptString = "";
        if ((!ap3.a().n("LX-53816", "A").equals("A") || this.b) && amulet != null && str != null) {
            Pair<String, Pair<String, Boolean>> pair = this.f1673a;
            if (pair == null || !str.equals(pair.first)) {
                JSONObject config = vs0.a().getConfig("amulet");
                if (config != null && (jSONObjectOptJSONObject = config.optJSONObject("findtab_bubble")) != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("text");
                    if (this.f1673a == null) {
                        long jOptInt = ((long) (jSONObjectOptJSONObject.optInt("day") * 24 * 60 * 60)) * 1000;
                        SPUtil sPUtil = SPUtil.f14322a;
                        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                        if (Math.abs(ir5.b() - sPUtil.i(scene, "key_amulet_find_tab_guide_time", 0L)) > jOptInt) {
                            sPUtil.t(scene, "key_amulet_find_tab_guide_time", Long.valueOf(ir5.b()));
                            this.f1673a = new Pair<>(str, new Pair(strOptString2, Boolean.TRUE));
                            zn6.c("findtab_amulet", "view");
                            strOptString = strOptString2;
                        } else {
                            this.f1673a = new Pair<>("-10086", new Pair("", Boolean.FALSE));
                            z = false;
                        }
                        zBooleanValue = z;
                    } else {
                        JSONArray jSONArrayOptJSONArray = config.optJSONArray("findtab_amulet_intimacy");
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                                String strOptString3 = jSONObjectOptJSONObject2.optString("giftId");
                                String str2 = amulet.itemId;
                                if ((str2 != null && str2.equals(strOptString3)) || this.b) {
                                    strOptString = jSONObjectOptJSONObject2.optString("text");
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                Object obj = this.f1673a.second;
                strOptString = (String) ((Pair) obj).first;
                zBooleanValue = ((Boolean) ((Pair) obj).second).booleanValue();
            }
        }
        return new Pair<>(strOptString, Boolean.valueOf(zBooleanValue));
    }

    @Override // defpackage.ik2
    public void b(Activity activity) {
        rk4.d(activity, 11, null, 1, -1, -1);
    }

    public final Pair<String, String> d() {
        JSONObject config = vs0.a().getConfig("amulet");
        if (config == null) {
            return null;
        }
        String strOptString = config.optString("intimacy_block_show");
        String strOptString2 = config.optString("intimacy_block");
        if (!TextUtils.isEmpty(strOptString2)) {
            strOptString2 = strOptString2.replace("{", "<a").replace("}", "</a>");
        }
        if (TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return new Pair<>(strOptString, strOptString2);
    }

    public void e(ContactInfoItem contactInfoItem) {
        Pair<String, String> pairD = d();
        if (pairD != null) {
            MessageVo messageVoG = u0.g(contactInfoItem);
            messageVoG.status = 2;
            messageVoG.mimeType = 10000;
            messageVoG.text = (String) pairD.first;
            messageVoG.data1 = "1";
            messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + ((String) pairD.second) + "\"}";
            b.u(messageVoG, false);
        }
    }
}
