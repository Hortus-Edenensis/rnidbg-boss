package defpackage;

import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tq3 {
    public static String c = "MomentsDataManager";
    public static int d = 0;
    public static int e = 1;
    public static int f = 1;
    public static int g = -1;
    public static int h = -2;
    public static final String i = k86.i("new_moments_message_received");
    public static final String j = k86.i("new_moments_post_received");
    public static final String k = k86.i("moments_send_fail");
    public static final String l = k86.i("moments_delete_feed");
    public static volatile tq3 m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21044a = 0;
    public long b = 0;

    public static tq3 e() {
        if (m == null) {
            synchronized (tq3.class) {
                if (m == null) {
                    m = new tq3();
                }
            }
        }
        return m;
    }

    public void a() {
        st1.f().c();
        i9.d().a();
        this.b = 0L;
        this.f21044a = 0L;
    }

    public void b(Feed feed) {
        LogUtil.i(c, "deleteFeed");
        if (feed == null) {
            return;
        }
        sq3.o().i(feed, null);
        i9.d().b(feed);
        st1.f().d(feed);
        LogUtil.i(c, "deleteFeed end");
    }

    public void c(NetResponseData netResponseData) {
        LogUtil.i(c, "deleteLikes");
        if (netResponseData == null) {
            return;
        }
        sq3.o().j(Long.valueOf(netResponseData.feedId));
        sq3.o().A(netResponseData.likes, null);
        i9.d().c(netResponseData);
        st1.f().e(netResponseData);
        LogUtil.i(c, "deleteLikes end");
    }

    public void d(long j2, FeedNetDao.FeedNetListener feedNetListener, String str) {
        LogUtil.i(c, "getFeedListForTopRefresh");
        FeedNetDao.getFeedDetail(j2, wt1.f21791a, feedNetListener, str);
    }

    public void f(String str, long j2, FeedNetDao.FeedNetListener feedNetListener) {
        LogUtil.d(c, "getPersonalAlbumList");
        FeedNetDao.getPersonalAlbumList(str, j2, feedNetListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g(List<Feed> list) {
        long jLongValue;
        if (list == null || list.size() <= 0) {
            jLongValue = 0;
        } else {
            Feed feed = list.get(list.size() - 1);
            if (feed.getCreateDt() != null) {
                jLongValue = feed.getCreateDt().longValue();
            }
        }
        LogUtil.i(c, "getTimeStampForLoadMore : " + jLongValue);
        return jLongValue;
    }

    public long h(List<Feed> list) {
        long j2 = 0;
        if (list != null && list.size() > 0) {
            long jLongValue = 0;
            for (Feed feed : list) {
                if (feed.getVersion() != null && (feed.getVersion().longValue() < jLongValue || jLongValue == 0)) {
                    jLongValue = feed.getVersion().longValue();
                }
            }
            j2 = jLongValue;
        }
        LogUtil.i(c, "getVersionForDB : " + j2);
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long i(List<Feed> list) {
        long jLongValue;
        if (list == null || list.size() <= 0) {
            jLongValue = 0;
        } else {
            Feed feed = list.get(list.size() - 1);
            if (feed.getVersion() != null) {
                jLongValue = feed.getVersion().longValue();
            }
        }
        LogUtil.i(c, "getVersionForLoadMore : " + jLongValue);
        return jLongValue;
    }

    public void j(NetResponseData netResponseData) {
        LogUtil.i(c, "insertOrUpdateComments");
        if (netResponseData == null) {
            return;
        }
        sq3.o().A(netResponseData.comments, null);
        i9.d().h(netResponseData);
        st1.f().j(netResponseData);
        LogUtil.i(c, "insertOrUpdateComments end");
    }

    public void k(NetResponseData netResponseData) {
        LogUtil.i(c, "insertOrUpdateLikes");
        if (netResponseData == null) {
            return;
        }
        sq3.o().A(netResponseData.likes, null);
        i9.d().i(netResponseData);
        st1.f().k(netResponseData);
        LogUtil.i(c, "insertOrUpdateLikes end");
    }

    public void l(String str) {
        sq3.o().f(str);
        a();
    }

    public void m(Feed feed, boolean z, boolean z2) {
        LogUtil.i(c, "saveFeed");
        if (z) {
            st1.f().i(feed, z2);
        }
        i9.d().g(feed);
        sq3.o().C(feed, z2, null);
        LogUtil.i(c, "saveFeed end");
    }
}
