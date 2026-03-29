package defpackage;

import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.platform.comapi.map.MapController;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.ChatBubbleVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatBubble;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ChatBubble f16962a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                sPUtil.t(scene, k86.a("key_chat_bubble_check_time"), Long.valueOf(System.currentTimeMillis()));
                ChatBubble chatBubbleO = b20.o(jSONObject);
                if (chatBubbleO != null) {
                    d20.f16962a = chatBubbleO;
                    sPUtil.t(scene, k86.a("key_chat_bubble"), az2.c(chatBubbleO));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void c() {
        try {
            new b20(new a(), new b()).n();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void d() {
        f16962a = null;
    }

    public static ChatBubble e() {
        if (f16962a == null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_bubble"), "");
            if (!TextUtils.isEmpty(strN)) {
                LogUtil.d("logbubble", "read: " + strN);
                f16962a = (ChatBubble) az2.a(strN, ChatBubble.class);
            }
        }
        return f16962a;
    }

    public static int f() {
        JSONObject config = vs0.a().getConfig("bubble_sysmsg");
        if (config != null) {
            return config.optInt("total_num", 5);
        }
        return 5;
    }

    public static String g() {
        JSONObject config = vs0.a().getConfig("bubble_sysmsg");
        String strOptString = config != null ? config.optString("text", "TA正在使用个性消息气泡\\n立即<a href='zenxin://activity?page=a0052&pkgId=bubble&urlExtra=%3Ffrom%3D1'>点我装扮</a>同款精美气泡") : "TA正在使用个性消息气泡\\n立即<a href='zenxin://activity?page=a0052&pkgId=bubble&urlExtra=%3Ffrom%3D1'>点我装扮</a>同款精美气泡";
        return !TextUtils.isEmpty(strOptString) ? strOptString.replace("{", "<a").replace("}", "</a>") : strOptString;
    }

    public static String h() {
        JSONObject config = vs0.a().getConfig("bubble_sysmsg");
        return config != null ? config.optString("sysmsg_show", "TA正在使用个性消息气泡，立即装扮") : "TA正在使用个性消息气泡，立即装扮";
    }

    public static int i() {
        JSONObject config = vs0.a().getConfig("bubble_sysmsg");
        if (config != null) {
            return config.optInt("person_num", 1);
        }
        return 1;
    }

    public static void j(final MessageProto.Message message) {
        new g13(new Runnable() { // from class: c20
            @Override // java.lang.Runnable
            public final void run() {
                d20.k(message);
            }
        }).start();
    }

    public static /* synthetic */ void k(MessageProto.Message message) {
        String strT = DomainHelper.t(message.getFrom());
        String strT2 = DomainHelper.t(message.getTo());
        String strC = DomainHelper.c(DomainHelper.k(strT), com.zenmen.palmchat.database.b.m(message));
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.contactRelate = strC;
        messageVo.to = strT2;
        int i = 1;
        messageVo.isRead = true;
        messageVo.isSend = false;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.attachStatus = 2;
        messageVo.from = strT;
        messageVo.extention = "";
        messageVo.text = MapController.DEFAULT_LAYER_TAG;
        messageVo.status = 2;
        messageVo.mimeType = 10000;
        messageVo.text = h();
        messageVo.data1 = "1";
        messageVo.data2 = "{\"actionTypes\":\"activity\", \"actionBody\":\"" + g() + "\"}";
        com.zenmen.palmchat.database.b.t(messageVo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
            if (!fg6.d(AppContext.getContext())) {
                i = 0;
            }
            jSONObject.put("svip_status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f("bubble_sysmsg_get", "view", jSONObject);
    }

    public static void l(MessageProto.Message message) {
        if (message == null || TextUtils.isEmpty(message.getExtension())) {
            return;
        }
        String from = message.getFrom();
        if (TextUtils.isEmpty(from) || DomainHelper.n(from) == DomainHelper.Domains.DOMAIN_GROUPCHAT || com.zenmen.palmchat.database.b.B(message)) {
            return;
        }
        ChatBubbleVo chatBubbleVo = null;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(message.getExtension()).optJSONObject("chatBubble");
            if (jSONObjectOptJSONObject != null) {
                chatBubbleVo = (ChatBubbleVo) az2.a(jSONObjectOptJSONObject.toString(), ChatBubbleVo.class);
            }
        } catch (Exception unused) {
        }
        if (chatBubbleVo == null || chatBubbleVo.bubbleType != 1) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        int iF = 0;
        int iF2 = by5.k(sPUtil.i(scene, k86.a("key_chat_bubble_tips_time"), 0L)) ? sPUtil.f(scene, k86.a("key_chat_bubble_tips_count"), 0) : 0;
        if (iF2 >= f()) {
            return;
        }
        if (by5.k(sPUtil.i(scene, k86.a("key_chat_bubble_tips_time" + from), 0L))) {
            iF = sPUtil.f(scene, k86.a("key_chat_bubble_tips_count" + from), 0);
        }
        if (iF >= i()) {
            return;
        }
        sPUtil.t(scene, k86.a("key_chat_bubble_tips_time"), Long.valueOf(System.currentTimeMillis()));
        sPUtil.t(scene, k86.a("key_chat_bubble_tips_count"), Integer.valueOf(iF2 + 1));
        sPUtil.t(scene, k86.a("key_chat_bubble_tips_time" + from), Long.valueOf(System.currentTimeMillis()));
        sPUtil.t(scene, k86.a("key_chat_bubble_tips_count" + from), Integer.valueOf(iF + 1));
        j(message);
    }

    public static void m(boolean z) {
        if (z || !by5.k(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, k86.a("key_chat_bubble_check_time"), -1L))) {
            c();
        } else {
            LogUtil.d("logbubble", "tryCheckBubble, return");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
