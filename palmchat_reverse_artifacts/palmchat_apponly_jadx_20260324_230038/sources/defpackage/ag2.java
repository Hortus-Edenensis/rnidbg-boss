package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ag2 {
    public static final String c = "ag2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f1222a = vw5.d(c);
    public Handler b = new Handler(AppContext.getContext().getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f1223a;

        /* JADX INFO: renamed from: ag2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0016a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadsBubbleBean f1224a;

            public RunnableC0016a(ThreadsBubbleBean threadsBubbleBean) {
                this.f1224a = threadsBubbleBean;
            }

            @Override // java.lang.Runnable
            public void run() {
                zf2.e().i(this.f1224a);
            }
        }

        public a(List list) {
            this.f1223a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (MessageProto.Message message : this.f1223a) {
                if (message != null && fu5.o(message) == 21 && !TextUtils.isEmpty(message.getExtension())) {
                    LogUtil.d(ag2.c, "processMessage ext = " + message.getExtension());
                    ThreadsBubbleBean threadsBubbleBean = (ThreadsBubbleBean) az2.a(message.getExtension(), ThreadsBubbleBean.class);
                    if (threadsBubbleBean != null) {
                        ag2.this.b.post(new RunnableC0016a(threadsBubbleBean));
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ag2 f1225a = new ag2();
    }

    public static ag2 c() {
        return b.f1225a;
    }

    public void d(List<MessageProto.Message> list) {
        this.f1222a.execute(new a(list));
    }
}
