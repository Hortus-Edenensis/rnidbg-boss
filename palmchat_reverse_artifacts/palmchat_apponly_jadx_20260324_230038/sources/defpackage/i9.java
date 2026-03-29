package defpackage;

import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class i9 {
    public static volatile i9 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, LinkedHashMap<Long, Feed>> f18124a = new LinkedHashMap<>();

    public static i9 d() {
        if (b == null) {
            synchronized (i9.class) {
                if (b == null) {
                    b = new i9();
                }
            }
        }
        return b;
    }

    public void a() {
        this.f18124a.clear();
    }

    public void b(Feed feed) {
        if (feed == null) {
            return;
        }
        new LinkedHashMap();
        LinkedHashMap<Long, Feed> linkedHashMap = this.f18124a.get(feed.getUid());
        if (linkedHashMap == null || linkedHashMap.get(feed.getFeedId()) == null) {
            return;
        }
        linkedHashMap.remove(feed.getFeedId());
    }

    public void c(NetResponseData netResponseData) {
        Feed feedF;
        if (netResponseData == null || (feedF = f(netResponseData.uid, netResponseData.feedId)) == null) {
            return;
        }
        feedF.likes = netResponseData.likes;
        j(feedF);
    }

    public Feed e(String str, long j) {
        new LinkedHashMap();
        LinkedHashMap<Long, Feed> linkedHashMap = this.f18124a.get(str);
        if (linkedHashMap == null || linkedHashMap.size() <= 0 || linkedHashMap.get(Long.valueOf(j)) == null) {
            return null;
        }
        return linkedHashMap.get(Long.valueOf(j));
    }

    public Feed f(String str, long j) {
        if (this.f18124a.get(str) == null || this.f18124a.get(str).get(Long.valueOf(j)) == null) {
            return null;
        }
        return this.f18124a.get(str).get(Long.valueOf(j));
    }

    public void g(Feed feed) {
        if (feed == null) {
            return;
        }
        LinkedHashMap<Long, Feed> linkedHashMap = this.f18124a.get(feed.getUid());
        if (linkedHashMap != null) {
            linkedHashMap.put(feed.getFeedId(), feed);
        } else {
            linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(feed.getFeedId(), feed);
        }
        this.f18124a.put(feed.getUid(), linkedHashMap);
    }

    public void h(NetResponseData netResponseData) {
        Feed feedF;
        if (netResponseData == null || (feedF = f(netResponseData.uid, netResponseData.feedId)) == null) {
            return;
        }
        feedF.setComments(netResponseData.comments);
        j(feedF);
    }

    public void i(NetResponseData netResponseData) {
        Feed feedF;
        if (netResponseData == null || (feedF = f(netResponseData.uid, netResponseData.feedId)) == null) {
            return;
        }
        feedF.likes = netResponseData.likes;
        j(feedF);
    }

    public final void j(Feed feed) {
        LinkedHashMap<Long, Feed> linkedHashMap;
        if (feed == null || (linkedHashMap = this.f18124a.get(feed.getUid())) == null || linkedHashMap.get(feed.getFeedId()) == null) {
            return;
        }
        linkedHashMap.put(feed.getFeedId(), feed);
    }
}
