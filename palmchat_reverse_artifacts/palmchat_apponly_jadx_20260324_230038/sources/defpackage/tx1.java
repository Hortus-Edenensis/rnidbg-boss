package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class tx1 {
    public static final String b = "tx1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f21086a = vw5.d(b);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21087a;

        public a(List list) {
            this.f21087a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (MessageProto.Message message : this.f21087a) {
                if (message != null && !TextUtils.isEmpty(message.getExtension())) {
                    try {
                        String strOptString = new JSONObject(message.getExtension()).optString("floatCmd");
                        if (fu5.o(message) == 1) {
                            LogUtil.d(tx1.b, "processMessage ext = " + strOptString);
                            rt4.b().d(strOptString);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static tx1 f21088a = new tx1();
    }

    public static tx1 b() {
        return b.f21088a;
    }

    public void c(List<MessageProto.Message> list) {
        this.f21086a.execute(new a(list));
    }
}
