package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
import defpackage.qp4;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zq3 {
    public static String d = "MomentsRetryManager";
    public static volatile zq3 e = null;
    public static long f = 1200000;
    public List<yo4> b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<g> f22481a = new CopyOnWriteArrayList<>();
    public ScheduledExecutorService c = vw5.e(d);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f22482a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ f c;
        public final /* synthetic */ Context d;

        /* JADX INFO: renamed from: zq3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1299a extends HashMap<String, Object> {
            public C1299a() {
                put("action", "send_feed");
                put("status", "send_end");
                put("type", Integer.valueOf(a.this.f22482a.getFeedType()));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                zq3.this.o(aVar.f22482a, aVar.d, aVar.c);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("action", "send_feed");
                put("status", "send_fail");
                put("type", Integer.valueOf(a.this.f22482a.getFeedType()));
            }
        }

        public a(Feed feed, JSONObject jSONObject, f fVar, Context context) {
            this.f22482a = feed;
            this.b = jSONObject;
            this.c = fVar;
            this.d = context;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.e(zq3.d, "publishFeed onFail , error = " + exc.toString());
            JSONObject jSONObject = this.b;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M2518", null, null, jSONObject.toString());
            }
            g gVarJ = zq3.this.j(this.f22482a);
            if (gVarJ.d) {
                LogUtil.i(zq3.d, "feed isDelete");
                f fVar = this.c;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (zq3.this.k(gVarJ)) {
                zq3.this.c.schedule(new b(), zq3.this.n(gVarJ), TimeUnit.MILLISECONDS);
            } else {
                this.f22482a.setStatus(tq3.h);
                tq3.e().m(this.f22482a, true, true);
                if (zq3.this.b != null) {
                    Iterator it = zq3.this.b.iterator();
                    while (it.hasNext()) {
                        ((yo4) it.next()).a(this.f22482a);
                    }
                }
                LocalBroadcastManager.getInstance(this.d).sendBroadcast(new Intent(tq3.k));
                f fVar2 = this.c;
                if (fVar2 != null) {
                    fVar2.p();
                }
            }
            LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(), (Throwable) null);
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            NetResponseData netResponseData;
            LogUtil.d(zq3.d, "publishFeed onSuccess , response = " + yy2Var.toString());
            Feed feed = null;
            if (yy2Var.f22300a) {
                Feed feed2 = this.f22482a;
                if (netResponse != null && (netResponseData = netResponse.data) != null) {
                    if (netResponseData.clientId == feed2.getClientId().longValue()) {
                        List<Media> mediaList = netResponseData.mediaList;
                        if (this.f22482a.getFeedType() == 2 || this.f22482a.getFeedType() == 3) {
                            mediaList = this.f22482a.getMediaList();
                        }
                        feed2 = new Feed(Long.valueOf(netResponseData.feedId), Long.valueOf(netResponseData.clientId), netResponseData.uid, Long.valueOf(netResponseData.createDt), netResponseData.content, netResponseData.feedType, netResponseData.privateStatus, netResponseData.status, netResponseData.cover, Long.valueOf(netResponseData.version), Integer.valueOf(netResponseData.feedSource), netResponseData.location, mediaList);
                        feed2.setSource(netResponseData.source);
                        tq3.e().b(this.f22482a);
                        tq3.e().m(feed2, true, true);
                        if (zq3.this.b != null) {
                            Iterator it = zq3.this.b.iterator();
                            while (it.hasNext()) {
                                ((yo4) it.next()).b(feed2);
                            }
                        }
                    }
                    LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1299a(), (Throwable) null);
                    JSONObject jSONObject = this.b;
                    if (jSONObject != null) {
                        LogUtil.uploadInfoImmediate("M2517", null, null, jSONObject.toString());
                    }
                }
                feed = feed2;
            }
            if (feed != null) {
                f fVar = this.c;
                if (fVar != null) {
                    fVar.w0(feed);
                    return;
                }
                return;
            }
            f fVar2 = this.c;
            if (fVar2 != null) {
                fVar2.p();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void p();

        void w0(Feed feed);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Feed f22497a;
        public int b;
        public long c;
        public boolean d;

        public /* synthetic */ g(zq3 zq3Var, Feed feed, yq3 yq3Var) {
            this(feed);
        }

        public g(Feed feed) {
            this.f22497a = feed;
            this.b = 0;
            this.c = 0L;
            this.d = false;
        }
    }

    public static zq3 l() {
        if (e == null) {
            synchronized (zq3.class) {
                if (e == null) {
                    e = new zq3();
                }
            }
        }
        return e;
    }

    public final synchronized g j(Feed feed) {
        g gVarM;
        gVarM = m(feed);
        if (gVarM == null) {
            if (this.f22481a == null) {
                this.f22481a = new CopyOnWriteArrayList<>();
            }
            gVarM = new g(this, feed, null);
            this.f22481a.add(gVarM);
        }
        return gVarM;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(g gVar) {
        boolean z;
        if (gVar.f22497a != null) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis() - gVar.f22497a.getCreateDt().longValue();
            gVar.c = timeInMillis;
            z = true;
            int i = gVar.b + 1;
            gVar.b = i;
            if (timeInMillis >= f || i >= 1) {
                z = false;
            } else {
                t(gVar);
            }
        }
        LogUtil.i(d, "canRetry = " + z + ", feedId = " + gVar.f22497a.getFeedId() + "; retryCount = " + gVar.b + "; inrerval = " + n(gVar) + "; retryTotalTime = " + gVar.c);
        return z;
    }

    public final synchronized g m(Feed feed) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f22481a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            for (g gVar : this.f22481a) {
                if (gVar.f22497a.getFeedId() == feed.getFeedId()) {
                    return gVar;
                }
            }
        }
        return null;
    }

    public final long n(g gVar) {
        return gVar.b * 3000;
    }

    public void o(Feed feed, Context context, f fVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        List<Media> mediaList;
        Media media;
        ds0.a().b(new fi0(2));
        if (j(feed).b < 1) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("clientId", feed.getClientId());
                jSONObject3.put("feedType", feed.getFeedType());
                if (feed.getFeedType() == 6 && (mediaList = feed.getMediaList()) != null && mediaList.size() > 0 && (media = mediaList.get(0)) != null) {
                    jSONObject3.put("title", media.title);
                    jSONObject3.put("wid", media.wid);
                    jSONObject3.put("wineFeedId", media.wineFeedId);
                }
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M2516", null, null, jSONObject3.toString());
            jSONObject = jSONObject3;
        } else {
            jSONObject = null;
        }
        JSONArray jSONArray = new JSONArray();
        if (feed.getMediaList() != null) {
            Iterator<Media> it = feed.getMediaList().iterator();
            while (it.hasNext()) {
                try {
                    JSONObject jSONObject4 = new JSONObject(az2.c(it.next()));
                    LogUtil.d(d, "publishFeed mediaObject = " + jSONObject4.toString());
                    jSONArray.put(jSONObject4);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        j(feed);
        LogUtil.i(d, "publishFeed");
        if (feed.getSource() != null) {
            try {
                jSONObject2 = new JSONObject(az2.c(feed.getSource()));
            } catch (Exception e3) {
                e3.printStackTrace();
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        FeedNetDao.publishFeed(feed.getFeedType(), feed.getClientId().longValue(), feed.getContent(), jSONArray, null, jSONObject2, 0, "", new a(feed, jSONObject, fVar, context), feed.getClientId().toString());
    }

    public void p(Feed feed, Context context, f fVar) {
        LogUtil.i(d, "publishImageAndFeed");
        ds0.a().b(new fi0(2));
        j(feed);
        tq3.e().m(feed, true, true);
        ArrayList<String> arrayList = new ArrayList<>();
        if (feed != null && feed.getMediaList() != null) {
            Iterator<Media> it = feed.getMediaList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().localPath);
            }
        }
        v(feed, arrayList, context, fVar);
    }

    public void q(Feed feed, Context context, f fVar) {
        LogUtil.i(d, "publishVideoAndFeed");
        ds0.a().b(new fi0(2));
        j(feed);
        tq3.e().m(feed, true, true);
        ArrayList<String> arrayList = new ArrayList<>();
        if (feed != null && feed.getMediaList() != null) {
            Iterator<Media> it = feed.getMediaList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().localThumbPath);
            }
        }
        String str = feed.getMediaList().get(0).localPath;
        String str2 = feed.getMediaList().get(0).localThumbPath;
        if (str != null && str2 != null) {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file2.exists()) {
                v(feed, arrayList, context, fVar);
                return;
            } else {
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
        }
        LogUtil.i(d, "publishVideoAndFeed, localPath = " + str + ", localThumbPath = " + str2);
        if (fVar != null) {
            fVar.p();
        }
    }

    public void r(Feed feed, Context context, f fVar) {
        LogUtil.i(d, "publishWebIconAndFeed");
        ds0.a().b(new fi0(2));
        j(feed);
        tq3.e().m(feed, true, true);
        ArrayList<String> arrayList = new ArrayList<>();
        if (feed != null && feed.getMediaList() != null) {
            Iterator<Media> it = feed.getMediaList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().thumbUrl);
            }
        }
        u(feed, arrayList, context, fVar);
    }

    public void s(Feed feed) {
        g gVarM = m(feed);
        if (gVarM != null) {
            LogUtil.i(d, "stopRetryFeed feedID = " + feed.getFeedId());
            gVarM.d = true;
            t(gVarM);
        }
    }

    public final synchronized void t(g gVar) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f22481a;
        if (copyOnWriteArrayList == null) {
            return;
        }
        for (g gVar2 : copyOnWriteArrayList) {
            if (gVar2.f22497a.getFeedId() == gVar.f22497a.getFeedId()) {
                this.f22481a.remove(gVar2);
                this.f22481a.add(gVar);
            }
        }
    }

    public final void u(Feed feed, ArrayList<String> arrayList, Context context, f fVar) {
        JSONObject jSONObject;
        if (j(feed).b < 1) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("clientId", feed.getClientId());
                jSONObject2.put("feedType", feed.getFeedType());
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M2513", null, null, jSONObject2.toString());
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        zo4.d(arrayList, false, 0, new d(jSONObject, feed, context, fVar, arrayList));
    }

    public final void v(Feed feed, ArrayList<String> arrayList, Context context, f fVar) {
        JSONObject jSONObject;
        if (j(feed).b < 1) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("clientId", feed.getClientId());
                jSONObject2.put("feedType", feed.getFeedType());
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M257", null, null, jSONObject2.toString());
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        zo4.d(arrayList, true, 0, new e(jSONObject, feed, fVar, context, arrayList));
    }

    public final void w(Feed feed, ArrayList<String> arrayList, Context context, f fVar) {
        JSONObject jSONObject;
        if (j(feed).b < 1) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("clientId", feed.getClientId());
                jSONObject2.put("feedType", feed.getFeedType());
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M2510", null, null, jSONObject2.toString());
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        zo4.g(arrayList, true, 2, new b(jSONObject, feed, fVar, context, arrayList), new c(feed));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f22486a;
        public final /* synthetic */ Feed b;
        public final /* synthetic */ f c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ArrayList e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                zq3.this.w(bVar.b, bVar.e, bVar.d, bVar.c);
            }
        }

        /* JADX INFO: renamed from: zq3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1300b extends HashMap<String, Object> {
            public C1300b() {
                put("action", "send_feed");
                put("status", "video_upload_fail");
                put("type", Integer.valueOf(b.this.b.getFeedType()));
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        public b(JSONObject jSONObject, Feed feed, f fVar, Context context, ArrayList arrayList) {
            this.f22486a = jSONObject;
            this.b = feed;
            this.c = fVar;
            this.d = context;
            this.e = arrayList;
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.i("QiniuMultiFileUploader", "onFailed " + exc);
            LogUtil.i(zq3.d, "uploadVideo failed, ex = " + exc);
            JSONObject jSONObject = this.f22486a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M2512", null, null, jSONObject.toString());
            }
            g gVarJ = zq3.this.j(this.b);
            if (gVarJ.d) {
                LogUtil.i(zq3.d, "feed isDelete");
                f fVar = this.c;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (zq3.this.k(gVarJ)) {
                zq3.this.c.schedule(new a(), zq3.this.n(gVarJ), TimeUnit.MILLISECONDS);
                return;
            }
            this.b.setStatus(tq3.h);
            tq3.e().m(this.b, true, true);
            if (zq3.this.b != null) {
                Iterator it = zq3.this.b.iterator();
                while (it.hasNext()) {
                    ((yo4) it.next()).a(this.b);
                }
            }
            LocalBroadcastManager.getInstance(this.d).sendBroadcast(new Intent(tq3.k));
            LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1300b(), (Throwable) null);
            f fVar2 = this.c;
            if (fVar2 != null) {
                fVar2.p();
            }
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            LogUtil.i(zq3.d, "uploadVideo,onSuccess");
            JSONObject jSONObject = this.f22486a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M2511", null, null, jSONObject.toString());
            }
            if (zq3.this.j(this.b).d) {
                LogUtil.i(zq3.d, "feed isDelete");
                f fVar = this.c;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (arrayList == null || arrayList.size() != 1) {
                f fVar2 = this.c;
                if (fVar2 != null) {
                    fVar2.p();
                    return;
                }
                return;
            }
            this.b.getMediaList().get(0).videoUrl = arrayList.get(0).url;
            tq3.e().m(this.b, true, true);
            zq3.this.o(this.b, this.d, this.c);
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements bn2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f22489a;

        public c(Feed feed) {
            this.f22489a = feed;
        }

        @Override // bn2.d
        public void b(boolean z, int i, String str) {
            if (!z) {
                LogUtil.i(zq3.d, "onCompressFinished failed");
                return;
            }
            LogUtil.i(zq3.d, "onCompressFinished success, originPath = " + this.f22489a.getMediaList().get(0).localPath + ", compressPath = " + str);
            this.f22489a.getMediaList().get(0).localPath = str;
            tq3.e().m(this.f22489a, true, true);
        }

        @Override // bn2.d
        public void a(int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f22490a;
        public final /* synthetic */ Feed b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ f d;
        public final /* synthetic */ ArrayList e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                zq3.this.u(dVar.b, dVar.e, dVar.c, dVar.d);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "send_feed");
                put("status", "send_fail");
                put("type", Integer.valueOf(d.this.b.getFeedType()));
            }
        }

        public d(JSONObject jSONObject, Feed feed, Context context, f fVar, ArrayList arrayList) {
            this.f22490a = jSONObject;
            this.b = feed;
            this.c = context;
            this.d = fVar;
            this.e = arrayList;
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.i("QiniuMultiFileUploader", "onFailed " + exc);
            LogUtil.i(zq3.d, "uploadIcon failed, ex = " + exc);
            JSONObject jSONObject = this.f22490a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M2515", null, null, jSONObject.toString());
            }
            g gVarJ = zq3.this.j(this.b);
            if (gVarJ.d) {
                f fVar = this.d;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (zq3.this.k(gVarJ)) {
                zq3.this.c.schedule(new a(), zq3.this.n(gVarJ), TimeUnit.MILLISECONDS);
                return;
            }
            this.b.setStatus(tq3.h);
            tq3.e().m(this.b, true, true);
            if (zq3.this.b != null) {
                Iterator it = zq3.this.b.iterator();
                while (it.hasNext()) {
                    ((yo4) it.next()).a(this.b);
                }
            }
            LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent(tq3.k));
            LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            f fVar2 = this.d;
            if (fVar2 != null) {
                fVar2.p();
            }
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            LogUtil.i(zq3.d, "uploadIcon,onSuccess");
            JSONObject jSONObject = this.f22490a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M2514", null, null, jSONObject.toString());
            }
            for (int i = 0; i < arrayList.size(); i++) {
                this.b.getMediaList().get(i).thumbUrl = arrayList.get(i).thumbUrl;
                LogUtil.i(zq3.d, "uploadIcon,onSuccess, thumburl = " + arrayList.get(i).thumbUrl);
            }
            tq3.e().m(this.b, true, true);
            zq3.this.o(this.b, this.c, this.d);
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f22493a;
        public final /* synthetic */ Feed b;
        public final /* synthetic */ f c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ArrayList e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                zq3.this.v(eVar.b, eVar.e, eVar.d, eVar.c);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "send_feed");
                put("status", "image_upload_fail");
                put("type", Integer.valueOf(e.this.b.getFeedType()));
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("action", "send_feed");
                put("status", "send_fail");
                put("type", Integer.valueOf(e.this.b.getFeedType()));
            }
        }

        public e(JSONObject jSONObject, Feed feed, f fVar, Context context, ArrayList arrayList) {
            this.f22493a = jSONObject;
            this.b = feed;
            this.c = fVar;
            this.d = context;
            this.e = arrayList;
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.i("QiniuMultiFileUploader", "onFailed " + exc);
            LogUtil.i(zq3.d, "uploadImage failed, ex = " + exc);
            JSONObject jSONObject = this.f22493a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M259", null, null, jSONObject.toString());
            }
            g gVarJ = zq3.this.j(this.b);
            if (gVarJ.d) {
                LogUtil.i(zq3.d, "feed isDelete");
                f fVar = this.c;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (zq3.this.k(gVarJ)) {
                zq3.this.c.schedule(new a(), zq3.this.n(gVarJ), TimeUnit.MILLISECONDS);
                return;
            }
            this.b.setStatus(tq3.h);
            tq3.e().m(this.b, true, true);
            if (zq3.this.b != null) {
                Iterator it = zq3.this.b.iterator();
                while (it.hasNext()) {
                    ((yo4) it.next()).a(this.b);
                }
            }
            LocalBroadcastManager.getInstance(this.d).sendBroadcast(new Intent(tq3.k));
            if (this.b.getFeedType() == 3) {
                LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            } else {
                LogUtil.i(zq3.d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(), (Throwable) null);
            }
            f fVar2 = this.c;
            if (fVar2 != null) {
                fVar2.p();
            }
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            LogUtil.i(zq3.d, "uploadImage,onSuccess");
            JSONObject jSONObject = this.f22493a;
            if (jSONObject != null) {
                LogUtil.uploadInfoImmediate("M258", null, null, jSONObject.toString());
            }
            for (int i = 0; i < arrayList.size(); i++) {
                this.b.getMediaList().get(i).thumbUrl = arrayList.get(i).thumbUrl;
                this.b.getMediaList().get(i).midUrl = arrayList.get(i).midUrl;
                this.b.getMediaList().get(i).url = arrayList.get(i).url;
            }
            tq3.e().m(this.b, true, true);
            if (zq3.this.j(this.b).d) {
                LogUtil.i(zq3.d, "feed isDelete");
                f fVar = this.c;
                if (fVar != null) {
                    fVar.p();
                    return;
                }
                return;
            }
            if (this.b.getFeedType() != 3) {
                zq3.this.o(this.b, this.d, this.c);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Feed feed = this.b;
            if (feed != null && feed.getMediaList() != null) {
                Iterator<Media> it = this.b.getMediaList().iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().localPath);
                }
            }
            zq3.this.w(this.b, arrayList2, this.d, this.c);
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }
}
