package defpackage;

import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.support.SquareSingleton;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class qj5 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20264a;

        public a(int i) {
            this.f20264a = i;
            put("status", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SquareFeed f20265a;
        public long b;
        public String c;
    }

    public static void A(int i) {
        HashMap map = new HashMap();
        map.put("lookGender", Integer.valueOf(i));
        b("filtratewindow_clickevent", "click", map);
    }

    public static void B(String str) {
        HashMap map = new HashMap();
        map.put("sid", str);
        b("pagelffriend", null, map);
        j0("pagelffriend_tabbutton", "click");
    }

    public static void C(int i, int i2) {
        HashMap map = new HashMap();
        map.put("status", Integer.valueOf(i2));
        if (i == 1) {
            b("pagediscover_top_postrecommend_load", "view", map);
        } else if (i == 2) {
            b("pagediscover_top_postfriends_load", "view", map);
        }
    }

    public static void D(int i, String str) {
        HashMap map = new HashMap();
        map.put("sid", str);
        map.put("from", Integer.valueOf(i));
        b("pagediscover_tabview", "view", map);
    }

    public static void E(SquareFeed squareFeed, int i, int i2) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("sourceType", Integer.valueOf(i2));
        b("show_feed_gift", "click", eventParams);
    }

    public static void F(String str, String str2) {
        ma3.a("report guide event " + str + " " + str2, new Object[0]);
        j0(str, str2);
    }

    public static void G(String str, String str2, int i, int i2) {
        ma3.a("report guide event " + str + " " + str2, new Object[0]);
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(i));
        map.put("exposure_type", Integer.valueOf(i2));
        b(str, str2, map);
    }

    public static void H(int i, long j) {
        HashMap map = new HashMap();
        map.put("topicId", Long.valueOf(j));
        map.put("type", Integer.valueOf(i));
        b("pagetalk_below_button", "click", map);
    }

    public static void I(int i, long j) {
        HashMap map = new HashMap();
        map.put("topicId", Long.valueOf(j));
        map.put("type", Integer.valueOf(i));
        b("pagetalk_below_clockbutton", "click", map);
    }

    public static void J(String str, long j, String str2, String str3, int i) {
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(i));
        map.put("feedid", Long.valueOf(j));
        if (!TextUtils.isEmpty(str2)) {
            map.put("targetUid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("targetExid", str3);
        }
        map.put("feedid", Long.valueOf(j));
        b(str, "click", map);
    }

    public static void K(int i) {
        HashMap map = new HashMap();
        map.put("tabname", Integer.valueOf(i));
        b("pagenewslist_tabcli", "click", map);
    }

    public static void L(SquareFeed squareFeed, int i) {
        HashMap map = new HashMap();
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("pagetype", Integer.valueOf(i));
        map.put("imprId", squareFeed.imprId);
        b("pagediscover_feeds_more", "click", map);
    }

    public static void M(SquareFeed squareFeed, int i, int i2) {
        HashMap map = new HashMap();
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("pagetype", Integer.valueOf(i));
        map.put("option", Integer.valueOf(i2));
        map.put("imprId", squareFeed.imprId);
        b("pagediscover_complain_option", "click", map);
    }

    public static void N(SquareFeed squareFeed, int i) {
        HashMap map = new HashMap();
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("pagetype", Integer.valueOf(i));
        map.put("imprId", squareFeed.imprId);
        b("pagediscover_feeds_complaint", "view", map);
    }

    public static void O(NearByBean nearByBean, String str, int i) {
        Map<String, Object> mapGenReportParams = nearByBean.genReportParams();
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            mapGenReportParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            mapGenReportParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            mapGenReportParams.put("userlocation", locationExI.getAddress());
        }
        mapGenReportParams.put("sid", str);
        mapGenReportParams.put("from", Integer.valueOf(i));
        b("pagelffriend_recommend_contentclick", "click", mapGenReportParams);
    }

    public static void P(String str, Set<NearByBean> set) {
        JSONArray jSONArray = new JSONArray();
        Iterator<NearByBean> it = set.iterator();
        while (it.hasNext()) {
            jSONArray.put(new JSONObject(it.next().genReportParams()));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", str);
            jSONObject.put("list", jSONArray);
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                jSONObject.put("userlongtude", locationExI.getLongitude());
                jSONObject.put("userlatitude", locationExI.getLatitude());
                jSONObject.put("userlocation", locationExI.getAddress());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f("pagelffriend_recommend_contentshow", "view", jSONObject);
    }

    public static void Q(String str, int i, int i2, String str2, int i3, String str3, String str4) {
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, str);
        map.put("page", Integer.valueOf(i));
        map.put("from", Integer.valueOf(i2));
        map.put("refresh_id", str2);
        map.put("refresh_cnt", Integer.valueOf(i3));
        map.put("sid", str3);
        map.put("screen", str4);
        b("pagelffriend_request", null, map);
    }

    public static void R(String str, int i, String str2) {
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, str);
        map.put("from", Integer.valueOf(i));
        map.put("sid", str2);
        b("pagelffriend_response", null, map);
    }

    public static void S(NearByBean nearByBean, String str, int i) {
        Map<String, Object> mapGenReportParams = nearByBean.genReportParams();
        mapGenReportParams.put("from", Integer.valueOf(i));
        mapGenReportParams.put("sid", str);
        b("pagelffriend_recommend_chat", "click", mapGenReportParams);
    }

    public static void T(String str, int i) {
        HashMap map = new HashMap();
        map.put("targetExid", str);
        map.put("relationtype", Integer.valueOf(i));
        b("pagefeedssum_foot_chat", "click", map);
    }

    public static void U(String str, long j, int i, String str2) {
        HashMap map = new HashMap();
        map.put("sid", str);
        map.put("tagid", Integer.valueOf(i));
        map.put("feedsnum", Long.valueOf(j));
        map.put("targetExid", str2);
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            map.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            map.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            map.put("userlocation", locationExI.getAddress());
        }
        b("pagefeedssum", "view", map);
    }

    public static void V(int i, long j) {
        HashMap map = new HashMap();
        map.put("topicId", Long.valueOf(j));
        map.put("from", Integer.valueOf(i));
        b("pagetalk", "view", map);
    }

    public static void W(String str, String str2, int i) {
        b("square_net_req", null, a(str, str2, i));
    }

    public static void X(String str, String str2, int i, long j, long j2, int i2, String str3) {
        Map<String, Object> mapA = a(str, str2, i);
        mapA.put("time", Long.valueOf(j));
        mapA.put("netTime", Long.valueOf(j2));
        mapA.put("errCode", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str3)) {
            mapA.put(WifiNestConst.OtherConst.KEY_MSG, str3);
        }
        b("square_net_resp", null, mapA);
    }

    public static void Y(JSONObject jSONObject) {
        zn6.f("open_msg_discard", "view", jSONObject);
    }

    public static void Z(SquareFeed squareFeed) {
        if (squareFeed == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("feedid", Long.valueOf(squareFeed.id));
        b("pagediscover_linkcli", "click", map);
    }

    public static Map<String, Object> a(String str, String str2, int i) {
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, str);
        map.put("apiKey", str2);
        if (i > -1) {
            map.put("page", Integer.valueOf(i));
        }
        String strF = bi5.f(str2);
        if (!TextUtils.isEmpty(strF)) {
            map.put("bus", strF);
        }
        return map;
    }

    public static void a0(String str, int i, SquareFeed squareFeed) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put(ReportItem.RequestKeyRequestId, squareFeed.reqId);
        eventParams.put("friend", Integer.valueOf(squareFeed.ifFriend ? 1 : 0));
        eventParams.put("sid", str);
        eventParams.put("pagetype", Integer.valueOf(i));
        eventParams.put("phototype", Integer.valueOf(squareFeed.liveFlag ? 1 : 0));
        if (squareFeed.liveFlag) {
            eventParams.put("channelId", squareFeed.channelId);
            eventParams.put("sceneId", squareFeed.sceneId);
            eventParams.put("channelType", Integer.valueOf(squareFeed.channelType));
        } else {
            List<Media> list = squareFeed.mediaList;
            if (list != null && list.size() > 0) {
                Media media = squareFeed.mediaList.get(0);
                eventParams.put("channelId", media.channelId);
                eventParams.put("sceneId", media.sceneId);
                eventParams.put("channelType", Integer.valueOf(media.channelType));
            }
        }
        eventParams.put("new_num", Integer.valueOf(SquareSingleton.getInstance().getLastPraiseUnReadCount() + SquareSingleton.getInstance().getLastCommentUnReadCount()));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            eventParams.put("userlocation", locationExI.getAddress());
            eventParams.put("userCity", locationExI.getCity());
        }
        if (i == 1) {
            eventParams.put("loadid", wh5.M());
        } else if (i == 2) {
            eventParams.put("loadid", wh5.J());
        } else if (i == 73) {
            eventParams.put("loadid", wh5.K());
        } else if (i == 74) {
            eventParams.put("loadid", wh5.L());
        }
        eventParams.put("superShowType", Integer.valueOf(squareFeed.superShowType));
        b("pagediscover", "view", eventParams);
    }

    public static void b(String str, String str2, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            zn6.c(str, str2);
        } else {
            zn6.j(str, str2, map);
        }
    }

    public static void b0(int i, Collection<b> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        try {
            LocationEx locationExI = d.g().i(86400000L);
            int lastUnReadCount = SquareSingleton.getInstance().getLastUnReadCount();
            for (b bVar : collection) {
                Map<String, Object> eventParams = bVar.f20265a.getEventParams();
                eventParams.put(ReportItem.RequestKeyRequestId, bVar.f20265a.reqId);
                eventParams.put("sid", bVar.c);
                eventParams.put("show_timestamp", Long.valueOf(bVar.b));
                eventParams.put("pagetype", Integer.valueOf(i));
                eventParams.put("new_num", Integer.valueOf(lastUnReadCount));
                if (locationExI != null) {
                    eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
                    eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
                    eventParams.put("userlocation", locationExI.getAddress());
                    eventParams.put("userCity", locationExI.getCity());
                }
                jSONArray.put(new JSONObject(eventParams));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("feeds", jSONArray);
        b("feedsshow", "view", map);
    }

    public static void c(int i, long j, String str, String str2, SquareFeed squareFeed) {
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(i));
        map.put("toExid", str);
        map.put("feedid", Long.valueOf(j));
        if (str2 != null) {
            map.put("imprId", str2);
        }
        if (squareFeed != null) {
            map.put("phototype", Integer.valueOf(squareFeed.liveFlag ? 1 : 0));
            if (squareFeed.liveFlag) {
                map.put("channelId", squareFeed.channelId);
                map.put("sceneId", squareFeed.sceneId);
                map.put("channelType", Integer.valueOf(squareFeed.channelType));
            }
        }
        b("pagediscover_feeds_userbutton", "click", map);
    }

    public static void c0(SquareFeed squareFeed, long j, int i) {
        HashMap map = new HashMap();
        map.put("vediotime", new DecimalFormat("0.000").format(new BigDecimal(j / 1000.0f)));
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("from", Integer.valueOf(i));
        map.put("imprId", squareFeed.imprId);
        b("feedsvediotime", null, map);
    }

    public static void d(int i) {
        if (i == 1) {
            j0("discover_locationlimits_click", "click");
        } else {
            j0("discover_locationfunction_click", "click");
        }
    }

    public static void d0(SquareFeed squareFeed, int i, int i2, int i3) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("status", Integer.valueOf(squareFeed.ifLike ? 2 : 1));
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("targetExid", squareFeed.exid);
        eventParams.put("sourceType", Integer.valueOf(i2));
        eventParams.put("type", Integer.valueOf(i3));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            eventParams.put("userlocation", locationExI.getAddress());
        }
        b("pagediscover_feeds_likebutton", "click", eventParams);
    }

    public static void e(int i) {
        if (i == 1) {
            j0("discover_locationlimits_close", "click");
        } else {
            j0("discover_locationfunction_close", "click");
        }
    }

    public static void e0(SquareFeed squareFeed, CommentViewModel commentViewModel, int i) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("status", Integer.valueOf(commentViewModel.isCRLike() ? 2 : 1));
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("targetExid", commentViewModel.getCRUser().getExid());
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            eventParams.put("userlocation", locationExI.getAddress());
        }
        b("pagediscover_feeds_likebutton", "click", eventParams);
    }

    public static void f(int i) {
        if (i == 1) {
            j0("discover_locationlimits", "view");
        } else {
            j0("discover_locationfunction", "view");
        }
    }

    public static void f0(SquareFeed squareFeed, int i, int i2, int i3) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("status", Integer.valueOf(squareFeed.ifLike ? 2 : 1));
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("targetExid", squareFeed.exid);
        eventParams.put("sourceType", Integer.valueOf(i2));
        eventParams.put("type", Integer.valueOf(i3));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            eventParams.put("userlocation", locationExI.getAddress());
        }
        b("pagediscover_feedlike", "view", eventParams);
    }

    public static void g() {
        j0("pagediscover_top_info", "click");
    }

    public static void g0(SquareFeed squareFeed, int i, int i2) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("relationtype", Integer.valueOf(i));
        eventParams.put("feedid", Long.valueOf(squareFeed.id));
        eventParams.put("imprId", squareFeed.imprId);
        eventParams.put(bd.h, squareFeed.exid);
        eventParams.put("from", Integer.valueOf(i2));
        b("pagediscover_feedpagedetail_chat", "click", eventParams);
    }

    public static void h(int i) {
        a aVar = new a(i);
        if (i == 1 && lj5.c().g != null) {
            aVar.put("postguide_ID", Long.valueOf(lj5.c().g.id));
        }
        q05.a("pagediscover_top_post", 2, aVar);
    }

    public static void h0(SquareFeed squareFeed, Map<String, Object> map) {
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("imprId", squareFeed.imprId);
        map.put(bd.h, squareFeed.exid);
        b("pagediscover_feedpagedetail_chat", "click", map);
    }

    public static void i(SquareFeed squareFeed) {
        b("pagefeedpagedetail_commentbutton", "click", squareFeed.getEventParams());
    }

    public static void i0(int i, String str) {
        HashMap map = new HashMap();
        map.put("sid", str);
        map.put("page_type", Integer.valueOf(i));
        b("findfriend_screenpage_click", "click", map);
    }

    public static void j(SquareFeed squareFeed, String str) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("targetExid", str);
        b("pagefeedpagedetail_complaintbutton", "click", eventParams);
    }

    public static void j0(String str, String str2) {
        b(str, str2, null);
    }

    public static void k(SquareFeed squareFeed, String str) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("targetExid", str);
        b("pagefeedpagedetail_complaintdel", "click", eventParams);
    }

    public static void k0(SquareFeed squareFeed, int i) {
        if (squareFeed != null) {
            HashMap map = new HashMap();
            map.put("feedid", Long.valueOf(squareFeed.id));
            map.put("targetExid", squareFeed.exid);
            map.put("pagetype", Integer.valueOf(i));
            if (squareFeed.isFriend()) {
                b("pagediscover_friendchat", "click", map);
            } else {
                b("pagediscover_feedchat", "click", map);
            }
        }
    }

    public static void l(SquareFeed squareFeed, int i, int i2) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("sourceType", Integer.valueOf(i2));
        b("feedcomment", "click", eventParams);
    }

    public static void l0(int i) {
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(i));
        b("pagediscover_top_tabclick", "click", map);
    }

    public static void m(SquareFeed squareFeed, int i) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("likenum", Integer.valueOf(squareFeed.likeNums));
        eventParams.put("status", Integer.valueOf(squareFeed.discussionNum > 0 ? 1 : 0));
        eventParams.put("from", Integer.valueOf(i));
        b("pagefeedpagedetail_commentlist", "view", eventParams);
    }

    public static void m0(int i, long j) {
        HashMap map = new HashMap();
        map.put("id", Integer.valueOf(i));
        map.put("feedid", Long.valueOf(j));
        b("pagediscover_feedpagedetail_label", "click", map);
    }

    public static void n(SquareFeed squareFeed) {
        b("pagefeedpagedetail_presscomment", "view", squareFeed.getEventParams());
    }

    public static void o(SquareFeed squareFeed) {
        b("pagefeedpagedetail_replymorebutton", "click", squareFeed.getEventParams());
    }

    public static void p(SquareFeed squareFeed, int i) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("targetExid", squareFeed.exid);
        eventParams.put("from", Integer.valueOf(i));
        b("feedcomment_show", "click", eventParams);
    }

    public static void q(SquareFeed squareFeed, int i, int i2) {
        HashMap map = new HashMap();
        map.put("status", Integer.valueOf(i));
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("from", Integer.valueOf(i2));
        map.put("imprId", squareFeed.imprId);
        b("pagediscover_feeds_del", "click", map);
    }

    public static void r(HashSet<Long> hashSet) {
        JSONArray jSONArray = new JSONArray((Collection) hashSet);
        HashMap map = new HashMap();
        map.put("feedid", jSONArray);
        b("feeddelete", null, map);
    }

    public static void s(SquareFeed squareFeed, long j, int i) {
        HashMap map = new HashMap();
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("imprId", squareFeed.imprId);
        if (j >= 0) {
            map.put("vediotime", new DecimalFormat("0.000").format(new BigDecimal(j / 1000.0f)));
        }
        map.put("from", Integer.valueOf(i));
        b("pagediscover_feedpagedetail_close", "closed", map);
    }

    public static void t(int i, SquareFeed squareFeed, int i2, String str, String str2) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("from", Integer.valueOf(i));
        eventParams.put("likenum", Integer.valueOf(squareFeed.likeNums));
        eventParams.put("loadstatus", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            eventParams.put("cityName", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            eventParams.put("sid", str2);
        }
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            eventParams.put("userlongtude", Double.valueOf(locationExI.getLongitude()));
            eventParams.put("userlatitude", Double.valueOf(locationExI.getLatitude()));
            eventParams.put("userlocation", locationExI.getAddress());
        }
        b("pagediscover_feedpagedetail", "view", eventParams);
    }

    public static void u(int i, SquareFeed squareFeed) {
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(i));
        map.put("feedid", Long.valueOf(squareFeed.id));
        map.put("imprId", squareFeed.imprId);
        map.put("feedType", Integer.valueOf(squareFeed.feedType));
        map.put("phototype", Integer.valueOf(squareFeed.liveFlag ? 1 : 0));
        if (squareFeed.liveFlag) {
            map.put("channelId", squareFeed.channelId);
            map.put("sceneId", squareFeed.sceneId);
            map.put("channelType", Integer.valueOf(squareFeed.channelType));
            map.put("room_status", 1);
        } else {
            List<Media> list = squareFeed.mediaList;
            if (list != null && list.size() > 0) {
                Media media = squareFeed.mediaList.get(0);
                map.put("channelId", media.channelId);
                map.put("sceneId", media.sceneId);
                map.put("channelType", Integer.valueOf(media.channelType));
                map.put("room_status", 0);
            }
        }
        b("pagediscover_feeds", "click", map);
    }

    public static void v(int i, int i2) {
        String str = i == 2 ? "pagemultipleedit_visiblechoose" : "pagephotoedit_visiblechoose";
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(i2));
        b(str, "click", map);
    }

    public static void w(int i, SquareFeed squareFeed) {
        Map<String, Object> eventParams = squareFeed.getEventParams();
        eventParams.put("pagetype", Integer.valueOf(i));
        b("pagediscover_feeds_chatbutton", "click", eventParams);
    }

    public static void x(int i, int i2, int i3) {
        if (i == 5) {
            return;
        }
        HashMap map = new HashMap();
        map.put("pagetype", Integer.valueOf(i));
        map.put("type", Integer.valueOf(i2));
        map.put("status", Integer.valueOf(i3));
        b("pagediscover_refresh", "view", map);
    }

    public static void y(String str, int i, int i2, String str2, int i3, String str3) {
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, str);
        map.put("page", Integer.valueOf(i));
        map.put("from", Integer.valueOf(i2));
        map.put("refresh_id", str2);
        map.put("refresh_count", Integer.valueOf(i3));
        map.put("sid", str3);
        b("feedsrequest", null, map);
    }

    public static void z(String str, List<SquareFeed> list) {
        HashMap map = new HashMap();
        if (list == null) {
            list = new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (SquareFeed squareFeed : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("feedid", squareFeed.id);
                jSONObject.put("imprId", squareFeed.imprId);
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("feeds", jSONArray);
        map.put(ReportItem.RequestKeyRequestId, str);
        b("feedsresponse", null, map);
    }
}
