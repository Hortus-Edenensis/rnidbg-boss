package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ki0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18693a = "CommentImpl";
    public Context b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q64 f18694a;

        public a(q64 q64Var) {
            this.f18694a = q64Var;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i("CommentImpl", "publishComment fail, error is " + exc.toString());
            this.f18694a.onFail(-1, "");
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            if (netResponse == null) {
                LogUtil.i("CommentImpl", "publishComment fail, oridata is null!");
                this.f18694a.onFail(-1, "");
                return;
            }
            int i = netResponse.resultCode;
            if (i != 0) {
                this.f18694a.onFail(i, netResponse.errorMsg);
            } else {
                this.f18694a.a(netResponse.data);
            }
        }
    }

    public ki0(Context context) {
        this.b = context;
    }

    public void a(@NonNull Feed feed, Comment comment, @NonNull String str, int i, int i2, @NonNull q64 q64Var) {
        String fromUid;
        long jLongValue;
        if (q64Var == null || feed == null || feed.getUid() == null) {
            return;
        }
        if (comment != null) {
            fromUid = comment.getFromUid();
            jLongValue = comment.getId().longValue();
        } else {
            fromUid = null;
            jLongValue = 0;
        }
        FeedNetDao.publishComment(feed.getFeedId(), tq3.e, feed.getUid(), fromUid, Long.valueOf(jLongValue), str, feed.getFeedSource(), feed.getAdvId(), i, i2, new a(q64Var));
    }
}
