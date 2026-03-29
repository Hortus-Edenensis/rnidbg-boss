package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20279a = "qn0";
    public static volatile qn0 b;

    public static qn0 a() {
        if (b == null) {
            synchronized (qn0.class) {
                if (b == null) {
                    b = new qn0();
                }
            }
        }
        return b;
    }

    public final void c(MessageProto.Message message) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(message.getExtension()).optJSONObject("clientAlertCmd");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.optLong("expire") <= System.currentTimeMillis()) {
                return;
            }
            pn0.a(jSONObjectOptJSONObject);
            if (!AppContext.getContext().isBackground()) {
                ch.s().J();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d(MessageProto.Message message) {
        LogUtil.i(f20279a, "processHandInHandRecommendMessage ,extension = " + message.getExtension());
        zf2.e().f(message);
    }

    public void e(MessageProto.Message message) {
        if (fu5.o(message) == 3) {
            b(message);
        } else if (fu5.o(message) == 2) {
            c(message);
        } else if (fu5.o(message) == 22) {
            d(message);
        }
    }

    public final void b(MessageProto.Message message) {
    }
}
