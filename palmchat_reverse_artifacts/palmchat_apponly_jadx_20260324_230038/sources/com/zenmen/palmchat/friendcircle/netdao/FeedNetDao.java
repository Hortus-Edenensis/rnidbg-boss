package com.zenmen.palmchat.friendcircle.netdao;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.aw;
import defpackage.az2;
import defpackage.k86;
import defpackage.nl0;
import defpackage.v4;
import defpackage.xq3;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FeedNetDao {
    public static final String FEED_TIMELINE = "feeds.feed.list.v7";
    public static final int MOMENT_COMMENT_DELETED = 1911;
    public static final int MOMENT_COMMENT_FAILED = 1913;
    public static final int MOMENT_COMMENT_UNAUTH = 1912;
    public static final int MOMENT_FEED_DELETED = 1901;
    public static final int MOMENT_FEED_UNAUTH = 1902;
    public static final String FEED_DELETE = nl0.b + "/feed/v6/moment/delete";
    public static final String FEED_POST = nl0.b + "/feed/v6/moment/post";
    public static final String FEED_GET = nl0.b + "/feed/v6/moment/get";
    public static final String FEED_DETAIL = nl0.z + "/feeds.feed.get.v7";
    public static final String FEED_LIST = nl0.b + "/timeline/v6/list";
    public static final String FEED_LIST_V7 = nl0.z + "/feeds.outbox.list.v7";
    public static final String COMMENT_DELETE = nl0.b + "/feed/v6/comment/delete";
    public static final String COMMENT_POST = nl0.b + "/feed/v6/comment/post";
    public static final String COVER_POST = nl0.b + "/feed/v6/cover/post";
    public static final String COVER_GET = nl0.b + "/feed/v6/cover/get";
    public static final String ADVID_POAST = nl0.b + "/feed/v6/adv/post";

    /* JADX INFO: compiled from: SearchBox */
    public interface FeedNetListener {
        void onFail(Exception exc);

        void onSuccess(NetResponse netResponse, yy2 yy2Var);
    }

    public static void deleteComment(Long l, Long l2, String str, int i, int i2, String str2, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", l);
            jSONObject.put("fromUid", Long.parseLong(v4.e(c.b())));
            jSONObject.put("feedId", l2);
            jSONObject.put("feedUid", Long.parseLong(str));
            jSONObject.put("type", i);
            jSONObject.put("feedSource", i2);
            jSONObject.put("advId", str2);
            zw4.f(COMMENT_DELETE, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void deleteFeed(long j, int i, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, Long.parseLong(v4.e(c.b())));
            jSONObject.put("feedId", j);
            jSONObject.put("feedSource", i);
            zw4.f(FEED_DELETE, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void getFeed(long j, int i, FeedNetListener feedNetListener, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, str);
            jSONObject.put("feedId", j);
            jSONObject.put("feedSource", i);
            zw4.f(FEED_GET, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void getFeedDetail(long j, int i, FeedNetListener feedNetListener, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedUid", str);
            jSONObject.put("feedId", j);
            jSONObject.put("feedSource", i);
            zw4.f(FEED_DETAIL, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void getFeedList(int i, int i2, long j, long j2, long j3, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, j);
            jSONObject.put("action", i);
            jSONObject.put("type", i2);
            jSONObject.put("timestamp", j2);
            jSONObject.put("tipVersion", j3);
            zw4.f(FEED_LIST, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void getFeedListWithSource(int i, int i2, long j, long j2, long j3, long j4, Integer num, FeedNetListener feedNetListener) {
        LogUtil.d("FeedNetDao", "spTimestamp: " + j3);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, j);
            jSONObject.put("action", i);
            jSONObject.put("type", i2);
            jSONObject.put("timestamp", j2);
            jSONObject.put("lastTime", j3);
            jSONObject.put("tipVersion", j4);
            if (num != null) {
                jSONObject.put(az.at, num);
            }
            jSONObject.put("needAdv", false);
            LogUtil.d("FeedNetDao", "getFeedListWithSource params = " + jSONObject.toString());
            zw4.f(FEED_LIST, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void getPersonalAlbumList(String str, long j, FeedNetListener feedNetListener) {
        aw awVarA;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedUid", str);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("version", j);
            if (j == 0) {
                awVarA = aw.a(str + j);
                if (str != null && str.equals(v4.e(c.b()))) {
                    awVarA.d = false;
                }
            } else {
                awVarA = null;
            }
            LogUtil.d("logmoments", "getPersonalAlbumList params:" + jSONObject.toString());
            zw4.f(FEED_LIST_V7, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener).setCacheConfig(awVarA));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void getTimeline(String str, int i, String str2, long j, long j2, long j3, Integer num, FeedNetListener feedNetListener) {
        LogUtil.d("FeedNetDao", "lastTime: " + j2);
        xq3.b(str, FEED_TIMELINE, str2, i);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", j);
            jSONObject.put("lastTime", j2);
            jSONObject.put("tipVersion", j3);
            if (num != null) {
                jSONObject.put(az.at, num);
            }
            LogUtil.json("logmoments", jSONObject.toString(), "request url = " + nl0.z + "/" + FEED_TIMELINE);
            StringBuilder sb = new StringBuilder();
            sb.append(nl0.z);
            sb.append("/");
            sb.append(FEED_TIMELINE);
            zw4.f(sb.toString(), 1, jSONObject, new FeedNetListenerWrapper(str, FEED_TIMELINE, str2, i, feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void postCover(JSONArray jSONArray, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, Long.parseLong(v4.e(c.b())));
            jSONObject.put("cover", jSONArray);
            jSONObject.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
            zw4.f(COVER_POST, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void publishAdvId(String str, long j, String str2, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, str);
            jSONObject.put("feedId", j);
            jSONObject.put("advId", str2);
            LogUtil.i("AdViewHolder", "publishAdvId params = " + jSONObject.toString());
            zw4.f(ADVID_POAST, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void publishComment(Long l, int i, String str, String str2, Long l2, String str3, int i2, String str4, int i3, int i4, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", l);
            jSONObject.put("type", i);
            jSONObject.put("feedUid", Long.parseLong(str));
            jSONObject.put("fromUid", Long.parseLong(v4.e(c.b())));
            if (str2 != null) {
                jSONObject.put("toUid", Long.parseLong(str2));
            }
            jSONObject.put("toCommentId", l2);
            if (!TextUtils.isEmpty(str3)) {
                str3 = str3.trim();
            }
            jSONObject.put("content", str3);
            jSONObject.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
            jSONObject.put("feedSource", i2);
            jSONObject.put("advId", str4);
            jSONObject.put("from", i3);
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            String str5 = COMMENT_POST;
            sb.append(str5);
            LogUtil.json("logmoments", string, sb.toString());
            zw4.f(str5, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void publishFeed(int i, long j, String str, JSONArray jSONArray, JSONObject jSONObject, JSONObject jSONObject2, int i2, String str2, FeedNetListener feedNetListener, String str3) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(DeviceInfoUtil.UID_TAG, Long.parseLong(v4.e(c.b())));
            jSONObject3.put("clientId", j);
            jSONObject3.put("feedType", i);
            if (!TextUtils.isEmpty(str)) {
                str = str.trim();
            }
            jSONObject3.put("content", str);
            jSONObject3.put("mediaList", jSONArray);
            jSONObject3.put("location", jSONObject);
            jSONObject3.put(az.at, jSONObject2);
            jSONObject3.put("privateStatus", i2);
            jSONObject3.put("privateUids", str2);
            jSONObject3.put("sdid", ac1.v());
            zw4.p(jSONObject3);
            jSONObject3.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
            String strA0 = k86.a0(FEED_POST, str3);
            LogUtil.i("FeedNetDao", "publishFeed requestId = " + str3);
            zw4.g(strA0, 1, jSONObject3, new FeedNetListenerWrapper(feedNetListener), false);
        } catch (Exception e) {
            e.printStackTrace();
            feedNetListener.onFail(e);
        }
    }

    public static void publishLikeForCover(String str, FeedNetListener feedNetListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", Long.parseLong(str));
            jSONObject.put("type", 0);
            jSONObject.put("feedUid", Long.parseLong(str));
            jSONObject.put("fromUid", Long.parseLong(v4.e(c.b())));
            jSONObject.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
            zw4.f(COMMENT_POST, 1, jSONObject, new FeedNetListenerWrapper(feedNetListener));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class FeedNetListenerWrapper extends yw4 {
        private String api;
        private String bus;
        private FeedNetListener listener;
        private int page;
        private String reqId;
        private long startTime;

        public FeedNetListenerWrapper(FeedNetListener feedNetListener) {
            this.listener = feedNetListener;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.json("logmoments", "", "response error");
            if (!TextUtils.isEmpty(this.reqId)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = this.reqId;
                String str2 = this.api;
                String str3 = this.bus;
                int i = this.page;
                long j = this.startTime;
                xq3.c(str, str2, str3, i, jCurrentTimeMillis - j, jCurrentTimeMillis - j, -12345, "网络异常，请稍后再试");
            }
            this.listener.onFail(exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            String str;
            int i;
            LogUtil.json("logmoments", jSONObject.toString(), "response");
            if (!TextUtils.isEmpty(this.reqId)) {
                if (yy2Var != null) {
                    i = yy2Var.b;
                    str = yy2Var.c;
                } else {
                    str = "网络异常，请稍后再试";
                    i = -12345;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str2 = this.reqId;
                String str3 = this.api;
                String str4 = this.bus;
                int i2 = this.page;
                long j = this.startTime;
                xq3.c(str2, str3, str4, i2, jCurrentTimeMillis - j, jCurrentTimeMillis - j, i, str);
            }
            this.listener.onSuccess((NetResponse) az2.a(jSONObject.toString(), NetResponse.class), yy2Var);
        }

        public FeedNetListenerWrapper(String str, String str2, String str3, int i, FeedNetListener feedNetListener) {
            this.startTime = System.currentTimeMillis();
            this.listener = feedNetListener;
            this.reqId = str;
            this.api = str2;
            this.bus = str3;
            this.page = i;
        }
    }
}
