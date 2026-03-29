package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleBean;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleEvent;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zf2 {
    public static final String b = "zf2";
    public static zf2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadsBubbleBean f22404a;

    public zf2() {
        this.f22404a = null;
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_hand_in_hand_bubble_content"), "");
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        this.f22404a = (ThreadsBubbleBean) az2.a(strN, ThreadsBubbleBean.class);
    }

    public static zf2 e() {
        if (c == null) {
            synchronized (zf2.class) {
                if (c == null) {
                    c = new zf2();
                }
            }
        }
        return c;
    }

    public void b() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_contact_permission_check_time", 0L);
        c();
    }

    public void c() {
        this.f22404a = null;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_hand_in_hand_bubble_content"), "");
        ds0.a().b(new ThreadsBubbleEvent());
    }

    public ThreadsBubbleBean d() {
        return this.f22404a;
    }

    public void f(MessageProto.Message message) {
        try {
            String extension = message.getExtension();
            if (extension != null) {
                JSONObject jSONObject = new JSONObject(extension);
                ContentValues contentValues = new ContentValues();
                String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
                contentValues.put("mid", xn3.a());
                contentValues.put("read_status", (Long) 0L);
                contentValues.put("accept_status", (Long) 0L);
                contentValues.put("from_uid", strOptString);
                JSONObject jSONObject2 = jSONObject.getJSONObject("userInfo");
                contentValues.put("from_nick_name", jSONObject2.optString("nickname"));
                contentValues.put("from_head_img_url", jSONObject2.optString("headIconUrl"));
                contentValues.put("from_signature", jSONObject2.optString(a.A));
                contentValues.put("user_info", jSONObject2.toString());
                contentValues.put("request_type", (Integer) 227);
                contentValues.put("identify_code", jSONObject.optString("identifyCode"));
                contentValues.put("recommendTitle", jSONObject.optString("recommendTitle"));
                contentValues.put("recommendText", jSONObject.optString("recommendText"));
                if (jSONObject.has("sourceType")) {
                    contentValues.put("source_type", Integer.valueOf(jSONObject.optInt("sourceType")));
                }
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + strOptString);
                contentValues.put("send_time", Long.valueOf(System.currentTimeMillis()));
                rn0.i(contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean g() {
        ThreadsBubbleBean threadsBubbleBean;
        return h() && (threadsBubbleBean = this.f22404a) != null && threadsBubbleBean.isEnable() && this.f22404a.getExpiredTime() > System.currentTimeMillis();
    }

    public boolean h() {
        return jo6.y() && bg2.d();
    }

    public void i(ThreadsBubbleBean threadsBubbleBean) {
        LogUtil.d(b, "receiveBubbleMessage");
        if (threadsBubbleBean != null) {
            this.f22404a = threadsBubbleBean;
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_hand_in_hand_bubble_content"), az2.c(threadsBubbleBean));
            ds0.a().b(new ThreadsBubbleEvent());
        }
    }

    public void j(boolean z) {
    }

    public void a() {
    }
}
