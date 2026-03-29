package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentWidget;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19056a = "MomentPresenter";
    public hn2 b;
    public ki0 c;
    public k23 d;
    public Context e;

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f19059a;
        public final /* synthetic */ Context b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements FeedNetDao.FeedNetListener {
            public a() {
            }

            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            public void onFail(Exception exc) {
                uq3.a((FrameworkBaseActivity) lq3.this.e);
                LogUtil.i("MomentPresenter", "deleteFeed fail, error is " + exc.toString());
                HashMap map = new HashMap();
                map.put("status", 2);
                map.put("feedid", c.this.f19059a.getFeedId());
                map.put("from", Integer.valueOf(lq3.this.b.o()));
                zn6.j("pagediscover_feeds_del", "click", map);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
                boolean z;
                if (netResponse == null) {
                    uq3.a((FrameworkBaseActivity) lq3.this.e);
                    LogUtil.i("MomentPresenter", "deleteFeed fail, oriData is null");
                } else {
                    if (netResponse.resultCode == 0) {
                        tq3.e().b(c.this.f19059a);
                        lq3.this.b.d0(c.this.f19059a);
                        lq3.f(c.this.f19059a);
                        z = true;
                        HashMap map = new HashMap();
                        map.put("status", Integer.valueOf(z ? 1 : 2));
                        map.put("feedid", c.this.f19059a.getFeedId());
                        map.put("from", Integer.valueOf(lq3.this.b.o()));
                        zn6.j("pagediscover_feeds_del", "click", map);
                    }
                    LogUtil.i("MomentPresenter", "deleteFeed fail, resultCode is " + netResponse.resultCode);
                    uq3.a((FrameworkBaseActivity) lq3.this.e);
                }
                z = false;
                HashMap map2 = new HashMap();
                map2.put("status", Integer.valueOf(z ? 1 : 2));
                map2.put("feedid", c.this.f19059a.getFeedId());
                map2.put("from", Integer.valueOf(lq3.this.b.o()));
                zn6.j("pagediscover_feeds_del", "click", map2);
            }
        }

        public c(Feed feed, Context context) {
            this.f19059a = feed;
            this.b = context;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (this.f19059a.getStatus() != tq3.h && this.f19059a.getStatus() != tq3.g) {
                LogUtil.i("MomentPresenter", "deleteMoments from remote");
                FeedNetDao.deleteFeed(this.f19059a.getFeedId().longValue(), this.f19059a.getFeedSource(), new a());
                return;
            }
            LogUtil.i("MomentPresenter", "deleteMoments from local");
            tq3.e().b(this.f19059a);
            zq3.l().s(this.f19059a);
            lq3.this.b.d0(this.f19059a);
            if (this.f19059a.getStatus() == tq3.h) {
                LocalBroadcastManager.getInstance(this.b).sendBroadcast(new Intent(tq3.k));
            }
            lq3.f(this.f19059a);
        }
    }

    public lq3(hn2 hn2Var, Context context) {
        this.b = hn2Var;
        this.e = context;
        this.c = new ki0(context);
        this.d = new k23(context);
    }

    public static void f(Feed feed) {
        Intent intent = new Intent(tq3.l);
        intent.putExtra("feedId", feed.getFeedId());
        LocalBroadcastManager.getInstance(com.zenmen.palmchat.c.b()).sendBroadcast(intent);
    }

    public void c(int i, Feed feed) {
        this.d.b(feed, new a(i));
    }

    public void d(Context context, @NonNull Feed feed) {
        this.b.d0(feed);
    }

    public void e(Context context, @NonNull Feed feed) {
        new sd3(context).U("提示").k("确定删除吗？").N(R$color.gen_dialogPositiveColor).L("取消").P("删除").f(new c(feed, context)).e().show();
    }

    public void g(@Nullable View view, int i, long j, @Nullable CommentWidget commentWidget) {
        hn2 hn2Var = this.b;
        if (hn2Var != null) {
            hn2Var.C(view, i, j, commentWidget);
        }
    }

    public void h(int i, Feed feed, Long l) {
        this.d.c(feed, l, new b(i));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19057a;

        public a(int i) {
            this.f19057a = i;
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
            if (netResponseData == null) {
                LogUtil.i("MomentPresenter", "addLike responsedata is null");
                return;
            }
            LogUtil.i("MomentPresenter", "addLike success");
            tq3.e().k(netResponseData);
            List<Comment> list = netResponseData.likes;
            if (lq3.this.b != null) {
                lq3.this.b.U(this.f19057a, list);
            }
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19058a;

        public b(int i) {
            this.f19058a = i;
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
            if (netResponseData == null) {
                LogUtil.i("like", "unlike responsedata is null");
                return;
            }
            LogUtil.i("like", "unlike success");
            tq3.e().c(netResponseData);
            List<Comment> list = netResponseData.likes;
            if (lq3.this.b != null) {
                lq3.this.b.U(this.f19058a, list);
            }
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
        }
    }
}
