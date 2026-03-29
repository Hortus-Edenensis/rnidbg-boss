package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.fragment.MomentDetailFragment;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wg3 {
    public static final String c = "wg3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MomentDetailFragment f21694a;
    public k23 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f21695a;
        public final /* synthetic */ Feed b;

        public a(FrameworkBaseActivity frameworkBaseActivity, Feed feed) {
            this.f21695a = frameworkBaseActivity;
            this.b = feed;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            this.f21695a.hideBaseProgressBar();
            uq3.a(this.f21695a);
            Log.d(wg3.c, "deleteFeed fail, error is " + exc.toString());
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            this.f21695a.hideBaseProgressBar();
            if (netResponse == null) {
                uq3.a(this.f21695a);
                Log.d(wg3.c, "deleteFeed fail, oriData is null");
                return;
            }
            if (netResponse.resultCode == 0) {
                tq3.e().b(this.b);
                wg3.this.f21694a.C0(this.b.getFeedId());
                lq3.f(this.b);
            } else {
                uq3.a(this.f21695a);
                Log.d(wg3.c, "deleteFeed fail, resultCode is " + netResponse.resultCode);
            }
        }
    }

    public wg3(Context context) {
        this.b = new k23(context);
    }

    public void c(FeedBean feedBean, Feed feed) {
        this.b.b(feed, new b(feed, feedBean));
    }

    public void d(MomentDetailFragment momentDetailFragment) {
        this.f21694a = momentDetailFragment;
    }

    public void e(Feed feed) {
        FrameworkBaseActivity frameworkBaseActivityI0 = this.f21694a.I0();
        if (feed == null || frameworkBaseActivityI0 == null) {
            return;
        }
        frameworkBaseActivityI0.showBaseProgressBar(R$string.deleting, false);
        if (feed.getStatus() != tq3.h && feed.getStatus() != tq3.g) {
            FeedNetDao.deleteFeed(feed.getFeedId().longValue(), feed.getFeedSource(), new a(frameworkBaseActivityI0, feed));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M41", null, jSONObject.toString());
            return;
        }
        LogUtil.i(c, "deleteMoments from local");
        frameworkBaseActivityI0.hideBaseProgressBar();
        tq3.e().b(feed);
        zq3.l().s(feed);
        this.f21694a.C0(feed.getFeedId());
        if (feed.getStatus() == tq3.h) {
            LocalBroadcastManager.getInstance(this.f21694a.getContext()).sendBroadcast(new Intent(tq3.k));
        }
        lq3.f(feed);
    }

    public void f(long j, String str, FeedNetDao.FeedNetListener feedNetListener) {
        tq3.e().d(j, feedNetListener, str);
    }

    public void g(FeedBean feedBean, Long l, Feed feed) {
        this.b.c(feed, l, new c(feed, feedBean));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f21696a;
        public final /* synthetic */ FeedBean b;

        public b(Feed feed, FeedBean feedBean) {
            this.f21696a = feed;
            this.b = feedBean;
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
            if (netResponseData == null) {
                Log.d(wg3.c, "addLike responsedata is null");
                return;
            }
            Log.d(wg3.c, "addLike success");
            tq3.e().k(netResponseData);
            this.f21696a.likes = netResponseData.likes;
            if (wg3.this.f21694a != null) {
                wg3.this.f21694a.a1(this.b);
            }
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f21697a;
        public final /* synthetic */ FeedBean b;

        public c(Feed feed, FeedBean feedBean) {
            this.f21697a = feed;
            this.b = feedBean;
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
            if (netResponseData == null) {
                Log.d("like", "unlike responsedata is null");
                return;
            }
            Log.d("like", "unlike success");
            tq3.e().c(netResponseData);
            this.f21697a.likes = netResponseData.likes;
            if (wg3.this.f21694a != null) {
                wg3.this.f21694a.a1(this.b);
            }
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
        }
    }
}
