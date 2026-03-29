package defpackage;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uk4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f21234a;

        public a(ChatItem chatItem) {
            this.f21234a = chatItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                LogUtil.json("logportrait", jSONObject.toString(), "GetPortraits");
                List<ContactInfoItem.Portrait> listO = qk4.o(jSONObject);
                int size = listO != null ? listO.size() + 1 : 100;
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                sPUtil.t(scene, k86.a("key_portrait_chat_tips_check_time"), Long.valueOf(System.currentTimeMillis()));
                sPUtil.t(scene, k86.a("key_portrait_chat_tips_check_count"), Integer.valueOf(size));
                if (size > 1) {
                    return;
                }
                uk4.d(this.f21234a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(ChatItem chatItem) {
        try {
            new qk4(new a(chatItem), new b()).n();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void d(final ChatItem chatItem) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_portrait_chat_tips_time"), Long.valueOf(System.currentTimeMillis()));
        new g13(new Runnable() { // from class: tk4
            @Override // java.lang.Runnable
            public final void run() {
                uk4.e(chatItem);
            }
        }).start();
    }

    public static /* synthetic */ void e(ChatItem chatItem) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 10000;
        messageVoG.text = "想要展示自己的魅力？设置多图头像>>";
        messageVoG.data1 = "1";
        messageVoG.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"想要展示自己的魅力？<a href='zenxin://activity?page=a0512'>设置多图头像>></a>\"}";
        com.zenmen.palmchat.database.b.t(messageVoG);
    }

    public static void f(ChatItem chatItem) {
        if (m66.f()) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (by5.k(sPUtil.i(scene, k86.a("key_portrait_chat_tips_time"), -1L))) {
                return;
            }
            if (!by5.k(sPUtil.i(scene, k86.a("key_portrait_chat_tips_check_time"), -1L))) {
                c(chatItem);
            } else {
                if (sPUtil.f(scene, k86.a("key_portrait_chat_tips_check_count"), -1) > 1) {
                    return;
                }
                d(chatItem);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
