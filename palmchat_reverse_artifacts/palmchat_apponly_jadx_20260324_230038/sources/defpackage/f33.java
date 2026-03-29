package defpackage;

import android.text.TextUtils;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.route.share.a;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f33 {
    public static f33 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f17426a = vw5.c(1, "LinkParseProcessor");
    public AtomicBoolean b = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);
    public Object d = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17427a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ShareLinkBean c;

        public a(c cVar, boolean z, ShareLinkBean shareLinkBean) {
            this.f17427a = cVar;
            this.b = z;
            this.c = shareLinkBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17427a.a(this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(boolean z, ShareLinkBean shareLinkBean);
    }

    public static f33 f() {
        if (e == null) {
            synchronized (f33.class) {
                if (e == null) {
                    e = new f33();
                }
            }
        }
        return e;
    }

    public static boolean i() {
        return rl0.h().d().getDynamicConfig(DynamicConfig.Type.LINKLOAD).isEnable();
    }

    public final long g() {
        if (!TextUtils.isEmpty(rl0.h().d().getDynamicConfig(DynamicConfig.Type.LINKLOAD).getExtra())) {
            try {
                return new JSONObject(r0).optInt("LoadTime", 3) * 1000;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return 3000L;
    }

    public int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public void j(ExecutorService executorService, ShareLinkBean shareLinkBean, c cVar) {
        this.f17426a.submit(new b(shareLinkBean, executorService, cVar));
    }

    public final void k(ExecutorService executorService, ShareLinkBean shareLinkBean, c cVar, boolean z) {
        executorService.submit(new a(cVar, z, shareLinkBean));
    }

    public final void l(long j) {
        synchronized (this.d) {
            try {
                this.d.wait(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLinkBean f17428a;
        public final /* synthetic */ ExecutorService b;
        public final /* synthetic */ c c;

        public b(ShareLinkBean shareLinkBean, ExecutorService executorService, c cVar) {
            this.f17428a = shareLinkBean;
            this.b = executorService;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f33.this.c.set(false);
            f33.this.b.set(true);
            AsyncTask asyncTaskC = com.zenmen.palmchat.route.share.a.c(this.f17428a, new a());
            long jB = ir5.b();
            while (f33.this.b.get()) {
                LogUtil.i("LinkParseProcessor", "process wait " + this.f17428a.getUrl() + f33.this.b.get());
                try {
                    f33.this.l(100L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (ir5.b() - jB >= f33.this.g() && !f33.this.c.get()) {
                    LogUtil.i("LinkParseProcessor", "process timeout " + this.f17428a.getUrl() + f33.this.b.get());
                    f33.this.c.set(true);
                    f33.this.b.set(false);
                    asyncTaskC.f(true);
                    f33.this.k(this.b, this.f17428a, this.c, false);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.e {
            public a() {
            }

            @Override // com.zenmen.palmchat.route.share.a.e
            public void a(ShareLinkBean shareLinkBean) {
                LogUtil.i("LinkParseProcessor", "process onFinish " + shareLinkBean);
                f33.this.b.set(false);
                if (f33.this.c.get()) {
                    return;
                }
                boolean z = !TextUtils.isEmpty(shareLinkBean.getTitle()) || hx3.m(AppContext.getContext());
                b bVar = b.this;
                f33.this.k(bVar.b, shareLinkBean, bVar.c, z);
            }

            @Override // com.zenmen.palmchat.route.share.a.e
            public void onStart() {
            }
        }
    }
}
