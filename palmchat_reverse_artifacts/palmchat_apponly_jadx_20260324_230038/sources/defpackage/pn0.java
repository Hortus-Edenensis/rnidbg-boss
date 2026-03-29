package defpackage;

import com.zenmen.palmchat.kotlin.common.SPUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pn0 {
    public static void a(JSONObject jSONObject) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        sPUtil.t(scene, "key_contact_push_new_friends_content", jSONObject.toString());
        sPUtil.t(scene, "key_contact_push_new_friends_first_show_time", 0L);
    }
}
