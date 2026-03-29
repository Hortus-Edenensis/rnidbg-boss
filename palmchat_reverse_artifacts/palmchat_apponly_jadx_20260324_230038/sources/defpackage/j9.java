package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class j9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18347a = "MomentPresenter";
    public hn2 b;
    public ki0 c;
    public k23 d;

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f18350a;
        public final /* synthetic */ Context b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements FeedNetDao.FeedNetListener {
            public a() {
            }

            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            public void onFail(Exception exc) {
                Context context = c.this.b;
                if (context instanceof FrameworkBaseActivity) {
                    uq3.a((FrameworkBaseActivity) context);
                }
                Log.d("MomentPresenter", "deleteFeed fail, error is " + exc.toString());
            }

            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
                if (netResponse == null) {
                    uq3.a((FrameworkBaseActivity) c.this.b);
                    Log.d("MomentPresenter", "deleteFeed fail, oriData is null");
                } else if (netResponse.resultCode == 0) {
                    tq3.e().b(c.this.f18350a);
                    j9.this.b.d0(c.this.f18350a);
                    lq3.f(c.this.f18350a);
                } else {
                    uq3.a((FrameworkBaseActivity) c.this.b);
                    Log.d("MomentPresenter", "deleteFeed fail, resultCode is " + netResponse.resultCode);
                }
            }
        }

        public c(Feed feed, Context context) {
            this.f18350a = feed;
            this.b = context;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (this.f18350a.getStatus() != tq3.h && this.f18350a.getStatus() != tq3.g) {
                LogUtil.i("MomentPresenter", "deleteMoments from remote");
                FeedNetDao.deleteFeed(this.f18350a.getFeedId().longValue(), this.f18350a.getFeedSource(), new a());
                return;
            }
            LogUtil.i("MomentPresenter", "deleteMoments from local");
            tq3.e().b(this.f18350a);
            zq3.l().s(this.f18350a);
            j9.this.b.d0(this.f18350a);
            if (this.f18350a.getStatus() == tq3.h) {
                LocalBroadcastManager.getInstance(this.b).sendBroadcast(new Intent(tq3.k));
            }
            lq3.f(this.f18350a);
        }
    }

    public j9(hn2 hn2Var, Context context) {
        this.b = hn2Var;
        this.c = new ki0(context);
        this.d = new k23(context);
    }

    public void b(int i, Feed feed) {
        this.d.b(feed, new a(i));
    }

    public void c(Context context, @NonNull Feed feed) {
        new sd3(context).U("提示").k("确定删除吗？").N(R$color.gen_dialogPositiveColor).L("取消").P("确定").f(new c(feed, context)).e().show();
    }

    public void d(@Nullable View view, int i, long j, @Nullable CommentWidget commentWidget) {
        hn2 hn2Var = this.b;
        if (hn2Var != null) {
            hn2Var.C(view, i, j, commentWidget);
        }
    }

    public void e(int i, Feed feed, Long l) {
        this.d.c(feed, l, new b(i));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18348a;

        public a(int i) {
            this.f18348a = i;
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
            if (netResponseData == null) {
                Log.d("MomentPresenter", "addLike responsedata is null");
                return;
            }
            Log.d("MomentPresenter", "addLike success");
            tq3.e().k(netResponseData);
            List<Comment> list = netResponseData.likes;
            if (j9.this.b != null) {
                j9.this.b.U(this.f18348a, list);
            }
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements x64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18349a;

        public b(int i) {
            this.f18349a = i;
        }

        @Override // defpackage.x64
        public void a(NetResponseData netResponseData) {
            if (netResponseData == null) {
                Log.d("like", "unlike responsedata is null");
                return;
            }
            Log.d("like", "unlike success");
            tq3.e().c(netResponseData);
            List<Comment> list = netResponseData.likes;
            if (j9.this.b != null) {
                j9.this.b.U(this.f18349a, list);
            }
        }

        @Override // defpackage.x64
        public void b(NetResponseData netResponseData) {
        }
    }
}
