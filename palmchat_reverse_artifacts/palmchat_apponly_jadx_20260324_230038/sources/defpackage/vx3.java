package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vx3 {
    public static final String c = "vx3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f21554a = vw5.d(c);
    public Handler b = new Handler(AppContext.getContext().getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21555a;

        /* JADX INFO: renamed from: vx3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1281a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21556a;
            public final /* synthetic */ ThreadsBubbleBean b;

            public RunnableC1281a(String str, ThreadsBubbleBean threadsBubbleBean) {
                this.f21556a = str;
                this.b = threadsBubbleBean;
            }

            @Override // java.lang.Runnable
            public void run() {
                ux3.h().l(this.f21556a, this.b);
            }
        }

        public a(List list) {
            this.f21555a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (MessageProto.Message message : this.f21555a) {
                if (message != null && fu5.o(message) == 23 && !TextUtils.isEmpty(message.getExtension())) {
                    try {
                        LogUtil.d(vx3.c, "processMessage ext = " + message.getExtension());
                        JSONObject jSONObject = new JSONObject(message.getExtension());
                        String strOptString = jSONObject.optString(WfConstant.EVENT_KEY_TASK_ID);
                        ThreadsBubbleBean threadsBubbleBean = (ThreadsBubbleBean) az2.a(message.getExtension(), ThreadsBubbleBean.class);
                        jSONObject.optJSONObject("clientAlertCmd");
                        if (threadsBubbleBean != null) {
                            vx3.this.b.post(new RunnableC1281a(strOptString, threadsBubbleBean));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static vx3 f21557a = new vx3();
    }

    public static vx3 c() {
        return b.f21557a;
    }

    public void d(List<MessageProto.Message> list) {
        this.f21554a.execute(new a(list));
    }
}
