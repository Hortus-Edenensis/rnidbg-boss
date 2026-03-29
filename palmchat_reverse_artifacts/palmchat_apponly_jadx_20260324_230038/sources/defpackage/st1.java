package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class st1 {
    public static volatile st1 k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20840a = 10;
    public int b = 1;
    public int c = 2;
    public int d = 6;
    public int e = 2;
    public int f = 0;
    public int g = 0;
    public LinkedHashMap<Long, Feed> h = new LinkedHashMap<>();
    public LinkedHashMap<Long, Feed> i = new LinkedHashMap<>();
    public boolean j = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Feed> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Feed feed, Feed feed2) {
            return new Long(feed2.getCreateDt().longValue()).compareTo(new Long(feed.getCreateDt().longValue()));
        }
    }

    public static st1 f() {
        if (k == null) {
            synchronized (st1.class) {
                if (k == null) {
                    k = new st1();
                }
            }
        }
        return k;
    }

    public final List<Feed> a(int i, List<Feed> list) {
        LogUtil.d("FeedCache", "ad: addAdFeeds");
        if (l6.f(7) && !WkAdxAdConfigMg.DSP_NAME_CSJ.equals(jo6.e("LX-26068"))) {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).getFeedType() != 5) {
                    if (list.get(i4).getFeedType() <= 100 || list.get(i4).getFeedType() >= 200) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
            }
            int i5 = this.c;
            if (i2 >= i5) {
                int i6 = ((i2 - i5) / this.d) + 1;
                this.g = i6;
                int i7 = this.e;
                if (i6 > i7) {
                    this.g = i7;
                }
                LinkedHashMap<Long, Feed> linkedHashMap = this.i;
                int size = linkedHashMap == null ? 0 : linkedHashMap.size();
                int i8 = this.g - size;
                LogUtil.d("FeedCache", "ad: currentAdCount = " + size + ", needAddCount = " + i8 + ", normalFeedCount = " + i2);
                if (i8 > 0) {
                    for (int i9 = 0; i9 < i8; i9++) {
                        Feed feed = new Feed();
                        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i9);
                        feed.setFeedId(Long.valueOf(jCurrentTimeMillis));
                        feed.setClientId(Long.valueOf(jCurrentTimeMillis));
                        feed.setFeedSource(wt1.b);
                        feed.setFeedType(5);
                        this.i.put(feed.getFeedId(), feed);
                        LogUtil.d("FeedCache", "ad: addAdFeed i = " + i9 + ", feedID = " + feed.getFeedId() + ", adFeedCacheSize = " + this.i.size());
                    }
                }
                Iterator<Long> it = this.i.keySet().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    Feed feed2 = this.i.get(it.next());
                    if (feed2.getAdvId() != null && feed2.getAdTime() != 0) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (jCurrentTimeMillis2 - feed2.getAdTime() > this.b * 60 * 1000) {
                            LogUtil.d("FeedCache", "ad updateAd insertItem advId is timeout, feedId = " + feed2.getFeedId() + " , currentTime = " + jCurrentTimeMillis2 + ", old time = " + feed2.getAdTime());
                            feed2.setAdvId(null);
                        }
                        o(feed2);
                    }
                    int i11 = this.c + i3 + ((this.d + 1) * i10);
                    if (i11 >= 0 && i11 <= list.size()) {
                        if (i11 >= i) {
                            list.add(i11, feed2);
                            LogUtil.d("FeedCache", "ad insert position = " + i11 + ", feedId = " + feed2.getFeedId() + ", advid = " + feed2.getAdvId() + ", adTime = " + feed2.getAdTime());
                        } else if (list.get(i11).getFeedType() == 5) {
                            list.set(i11, feed2);
                            LogUtil.d("FeedCache", "ad update position = " + i11 + ", feedId = " + feed2.getFeedId() + ", advid = " + feed2.getAdvId() + ", adTime = " + feed2.getAdTime());
                        }
                        i10++;
                    }
                }
                for (int i12 = 0; i12 < list.size(); i12++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ad after  insert position = ");
                    sb.append(i12);
                    sb.append(", feedId = ");
                    sb.append(list.get(i12).getFeedId());
                    sb.append(", isAD = ");
                    sb.append(list.get(i12).getFeedSource() == wt1.b);
                    sb.append(", advId = ");
                    sb.append(list.get(i12).getAdvId());
                    LogUtil.d("FeedCache", sb.toString());
                }
            }
        }
        return list;
    }

    public void b() {
        this.f20840a++;
    }

    public void c() {
        this.h.clear();
    }

    public void d(Feed feed) {
        if (feed == null || this.h.get(feed.getFeedId()) == null) {
            return;
        }
        this.h.remove(feed.getFeedId());
    }

    public void e(NetResponseData netResponseData) {
        Feed feedH;
        if (netResponseData == null || (feedH = h(netResponseData.feedId)) == null) {
            return;
        }
        feedH.likes = netResponseData.likes;
        p(feedH);
    }

    public List<Feed> g(List<Feed> list, List<Feed> list2) {
        int size;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
            size = list.size();
        } else {
            size = 0;
        }
        if (list2 != null) {
            LogUtil.i("FeedCache", "more size = " + list2.size());
            Collections.sort(list2, new a());
            for (Feed feed : list2) {
                StringBuilder sb = new StringBuilder();
                sb.append("getFeedListFromCache, feedID = ");
                sb.append(feed.getFeedId());
                sb.append(", isAD = ");
                sb.append(feed.getFeedSource() == wt1.b);
                sb.append(", avdId = ");
                sb.append(feed.getAdvId());
                LogUtil.i("FeedCache", sb.toString());
                arrayList.add(feed);
            }
        }
        LogUtil.i("FeedCache", "result size = " + arrayList.size());
        a(size, arrayList);
        for (Feed feed2 : arrayList) {
            if (feed2.getFeedType() == 5) {
                LogUtil.d("FeedCache", "ad retrun feedId = " + feed2.getFeedId() + ", advid = " + feed2.getAdvId() + ", adTime = " + feed2.getAdTime());
            }
        }
        return arrayList.subList(size, arrayList.size());
    }

    public Feed h(long j) {
        if (this.h.get(Long.valueOf(j)) != null) {
            return this.h.get(Long.valueOf(j));
        }
        return null;
    }

    public void i(Feed feed, boolean z) {
        Feed feedH;
        Feed feedH2;
        Feed feedH3;
        if (feed == null) {
            return;
        }
        Iterator<Long> it = this.h.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                if (feed.getFeedSource() == wt1.b) {
                    LogUtil.d("FeedCache", "updateAd insertItem advId feedID = " + feed.getFeedId());
                    if (feed.getAdvId() != null && (feedH3 = h(feed.getFeedId().longValue())) != null) {
                        LogUtil.d("FeedCache", "updateAd insertItem advId oldFeedId = " + feedH3.getFeedId() + ",advID = " + feedH3.getAdvId() + ", time = " + feedH3.getAdTime());
                        if (feedH3.getAdvId() != null && feedH3.getAdTime() != 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            LogUtil.d("FeedCache", "updateAd insertItem adRequestTime = " + this.b);
                            if (jCurrentTimeMillis - feedH3.getAdTime() > this.b * 60 * 1000) {
                                LogUtil.d("FeedCache", "updateAd insertItem advId is timeout, feedId = " + feed.getFeedId() + " , currentTime = " + jCurrentTimeMillis + ", old time = " + feedH3.getAdTime());
                                feed.setAdvId(null);
                            } else {
                                feed.setAdTime(feedH3.getAdTime());
                            }
                        }
                    }
                }
                if ((feed.getFeedType() == 3 || feed.getFeedType() == 6) && (feedH = h(feed.getFeedId().longValue())) != null && feedH.getMediaList().get(0).localPath != null) {
                    feed.getMediaList().get(0).localPath = feedH.getMediaList().get(0).localPath;
                }
                if (!z && (feedH2 = h(feed.getFeedId().longValue())) != null) {
                    feed.setVersion(feedH2.getVersion());
                }
                this.h.put(feed.getFeedId(), feed);
                return;
            }
            Long next = it.next();
            if (this.h.get(next) != null && this.h.get(next).getClientId() != null && feed.getClientId() != null && feed.getFeedSource() != wt1.b && this.h.get(next).getClientId().equals(feed.getClientId())) {
                StringBuilder sb = new StringBuilder();
                sb.append("insertItem clientId is euqueal, clientId = ");
                sb.append(feed.getClientId());
                sb.append(", feedId = ");
                sb.append(feed.getFeedId());
                sb.append(", isAd = ");
                sb.append(feed.getFeedSource() == wt1.b);
                LogUtil.i("MomentFeedCache", sb.toString());
                if (c.b() != null && v4.e(c.b()) != null && feed.getUid() != null && v4.e(c.b()).equals(feed.getUid())) {
                    return;
                }
            }
        }
    }

    public void j(NetResponseData netResponseData) {
        Feed feedH;
        if (netResponseData == null || (feedH = h(netResponseData.feedId)) == null) {
            return;
        }
        feedH.setComments(netResponseData.comments);
        p(feedH);
    }

    public void k(NetResponseData netResponseData) {
        Feed feedH;
        if (netResponseData == null || (feedH = h(netResponseData.feedId)) == null) {
            return;
        }
        feedH.likes = netResponseData.likes;
        p(feedH);
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.getInt("requestTime");
            int i = jSONObject.getInt("gapLength");
            this.d = i;
            if (i == 0) {
                this.d = 6;
            }
            this.c = jSONObject.getInt("normalLength");
            this.e = jSONObject.getInt("limit");
            this.f = jSONObject.getInt("preLoad");
            LogUtil.d("FeedCache", "setAdConfig: adRequestTime = " + this.b + "gapLength = " + this.d + ", normalLength = " + this.c + ", limit = " + this.e + "preload = " + this.f);
        } catch (Exception unused) {
        }
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o(Feed feed) {
        if (feed == null || this.i.get(feed.getFeedId()) == null) {
            return;
        }
        this.i.put(feed.getFeedId(), feed);
    }

    public void p(Feed feed) {
        if (feed == null || this.h.get(feed.getFeedId()) == null) {
            return;
        }
        this.h.put(feed.getFeedId(), feed);
    }
}
