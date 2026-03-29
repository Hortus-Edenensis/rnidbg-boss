package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k23 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18555a = "likeImpl";
    public Context b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x64 f18556a;

        public a(x64 x64Var) {
            this.f18556a = x64Var;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i("likeImpl", "addLike fail, error is " + exc.toString());
            sy5.e(k23.this.b, R$string.square_http_error, 1).g();
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            if (netResponse == null) {
                LogUtil.i("likeImpl", "addLike fail, oridata is null!");
                sy5.e(k23.this.b, R$string.square_http_error, 1).g();
                return;
            }
            if (netResponse.resultCode == 0) {
                this.f18556a.b(netResponse.data);
                return;
            }
            LogUtil.i("likeImpl", "addLike fail, resultCode is " + netResponse.resultCode);
            if (netResponse.resultCode == 1901) {
                if (TextUtils.isEmpty(netResponse.errorMsg)) {
                    sy5.e(k23.this.b, R$string.feed_content_delete_error, 1).g();
                    return;
                } else {
                    sy5.f(k23.this.b, netResponse.errorMsg, 1).g();
                    return;
                }
            }
            if (TextUtils.isEmpty(netResponse.errorMsg)) {
                sy5.e(k23.this.b, R$string.square_http_error, 1).g();
            } else {
                sy5.f(k23.this.b, netResponse.errorMsg, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x64 f18557a;

        public b(x64 x64Var) {
            this.f18557a = x64Var;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i("likeImpl", "unLike fail, error is " + exc.toString());
            sy5.e(k23.this.b, R$string.square_http_error, 1).g();
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            if (netResponse == null) {
                sy5.e(k23.this.b, R$string.square_http_error, 1).g();
                LogUtil.i("likeImpl", "unLike fail, oridata is null!");
                return;
            }
            int i = netResponse.resultCode;
            if (i == 0) {
                this.f18557a.a(netResponse.data);
            } else {
                if (i == 1901) {
                    if (TextUtils.isEmpty(netResponse.errorMsg)) {
                        sy5.e(k23.this.b, R$string.feed_content_delete_error, 1).g();
                        return;
                    } else {
                        sy5.f(k23.this.b, netResponse.errorMsg, 1).g();
                        return;
                    }
                }
                if (TextUtils.isEmpty(netResponse.errorMsg)) {
                    sy5.e(k23.this.b, R$string.square_http_error, 1).g();
                } else {
                    sy5.f(k23.this.b, netResponse.errorMsg, 1).g();
                }
            }
        }
    }

    public k23(Context context) {
        this.b = context;
    }

    public void b(Feed feed, x64 x64Var) {
        if (x64Var == null || feed == null || feed.getUid() == null) {
            return;
        }
        FeedNetDao.publishComment(feed.getFeedId(), tq3.d, feed.getUid(), null, null, null, feed.getFeedSource(), feed.getAdvId(), 0, 0, new a(x64Var));
    }

    public void c(Feed feed, Long l, x64 x64Var) {
        if (x64Var == null || feed == null || l.longValue() == 0 || feed.getUid() == null) {
            return;
        }
        FeedNetDao.deleteComment(l, feed.getFeedId(), feed.getUid(), tq3.d, feed.getFeedSource(), feed.getAdvId(), new b(x64Var));
    }
}
