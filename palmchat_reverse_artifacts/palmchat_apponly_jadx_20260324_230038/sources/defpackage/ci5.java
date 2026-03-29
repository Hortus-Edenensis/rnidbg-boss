package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.volley.LxRetryCacheHelper;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.square.bean.ShareSmsBean;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.ProfileInviteBean;
import com.zenmen.square.bean.SquareChatCheckBean;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagListBean;
import com.zenmen.square.topic.bean.TopicListBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ci5 extends wt0 implements uo2, vo2 {
    @Override // defpackage.uo2
    public void a(JSONArray jSONArray, boolean z, tw4<CommonResponse<String>> tw4Var) {
        String str = nl0.z + "/user.tag.saves.v1";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tagId", jSONArray);
            jSONObject.put("saveType", z ? 0 : 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.d("SquareDao", "SquareDao params: " + jSONObject.toString());
        o(str, jSONObject, tw4Var);
    }

    @Override // defpackage.uo2
    public void b(ArrayList<Integer> arrayList, tw4<CommonResponse> tw4Var) {
        String str = nl0.z + "/tag.saveUserShowTagList.v1";
        Map<String, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        map.put("tagIdList", jSONArray);
        n(str, map, tw4Var);
    }

    @Override // defpackage.uo2
    public void c(int i, String str, int i2, ContactInfoItem contactInfoItem, tw4<CommonResponse<SquareChatCheckBean>> tw4Var) {
        String str2 = nl0.z + "/square.chat.check.v2";
        HashMap map = new HashMap();
        map.put("sex", Integer.valueOf(i));
        map.put("fuid", str);
        map.put("fsex", Integer.valueOf(i2));
        int bizType = contactInfoItem.getBizType();
        DomainHelper.Domains domainsO = DomainHelper.o(bizType, contactInfoItem.getChatType() == 0);
        if (domainsO != null) {
            map.put("domain", domainsO.getFilterName());
            if (domainsO == DomainHelper.Domains.DOMAIN_PRIVATE) {
                map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
            }
        }
        n(str2, map, tw4Var);
    }

    @Override // defpackage.uo2
    public void d(tw4<CommonResponse<List<Integer>>> tw4Var) {
        n(nl0.z + "/tag.all.v1", new HashMap(), tw4Var);
    }

    @Override // defpackage.uo2
    public void e(SquareShareFeedBean squareShareFeedBean, tw4<CommonResponse<SquareFeed>> tw4Var) {
        SmidHelper.x(SmidHelper.SMScene.SQUARE_PUBLISH);
        String str = nl0.z + "/square.feed.share.route.v8";
        if (squareShareFeedBean.isPortrait) {
            str = nl0.z + "/square.post.head.feed.v1";
        } else if (squareShareFeedBean.isRecallImage) {
            str = nl0.z + "/square.feed.insertRecallImgFeed.v1";
        } else if (squareShareFeedBean.isSqureUserGuideChose) {
            str = nl0.z + "/square.post.feed.guide.v1";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("feedType", Integer.valueOf(squareShareFeedBean.feedType));
        map.put("tagId", Integer.valueOf(squareShareFeedBean.tagId));
        map.put("content", TextUtils.isEmpty(squareShareFeedBean.content) ? squareShareFeedBean.content : squareShareFeedBean.content.trim());
        if (str.contains("/square.feed.share.route.v8")) {
            Object obj = squareShareFeedBean.feedCategory;
            if (obj != null) {
                map.put("feedCategory", obj);
            } else {
                map.put("feedCategory", 0);
            }
            if (kj1.b().c().booleanValue()) {
                map.put(EventParams.KEY_GROUP, 1);
            } else {
                map.put(EventParams.KEY_GROUP, 0);
            }
        } else {
            Object obj2 = squareShareFeedBean.feedCategory;
            if (obj2 != null) {
                map.put("feedCategory", obj2);
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<Media> list = squareShareFeedBean.mediaList;
        if (list != null) {
            Iterator<Media> it = list.iterator();
            while (it.hasNext()) {
                try {
                    JSONObject jSONObject = new JSONObject(az2.c(it.next()));
                    LogUtil.d("SquareDao", "publishFeed mediaObject = " + jSONObject.toString());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        map.put("mediaList", jSONArray);
        LocationEx locationEx = squareShareFeedBean.location;
        if (locationEx != null) {
            map.put("longitude", Double.valueOf(locationEx.getLongitude()));
            map.put("latitude", Double.valueOf(squareShareFeedBean.location.getLatitude()));
            map.put("location", squareShareFeedBean.location.getName());
            map.put("cityCode", squareShareFeedBean.location.getCityCode());
            map.put(DistrictSearchQuery.KEYWORDS_CITY, squareShareFeedBean.location.getCity());
            map.put(DistrictSearchQuery.KEYWORDS_PROVINCE, squareShareFeedBean.location.getProvince());
        }
        TopicListBean.Topic topic = squareShareFeedBean.topic;
        if (topic != null) {
            map.put("topicId", Long.valueOf(topic.getTopicId()));
        }
        TopicListBean.Ae ae = squareShareFeedBean.ae;
        if (ae != null) {
            map.put("aeId", Long.valueOf(ae.getAeId()));
        }
        map.put("visibleType", Integer.valueOf(squareShareFeedBean.visibleType));
        map.put("sendLxFriendFlag", Boolean.valueOf(squareShareFeedBean.sendLxFriendFlag));
        map.put("sendContactsFriendFlag", Boolean.valueOf(squareShareFeedBean.sendContactsFriendFlag));
        map.put("sdid", ac1.v());
        map.put("random", Long.toString(Calendar.getInstance().getTimeInMillis()));
        n(str, map, tw4Var);
    }

    @Override // defpackage.uo2
    public void f(String str, String str2, String str3, long j, tw4<CommonResponse<SquareDynamicLifeResponseBean>> tw4Var) {
        aw awVar;
        String str4 = nl0.z + "/userem.getUserDailyLife.v3";
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("fuid", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("reqId", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("fexid", str2);
        }
        map.put("version", Long.valueOf(j));
        Log.i("SquareDao", "getDynamicLifeList: " + map.toString());
        if (j == 0) {
            aw awVarA = aw.a(str + str2 + j);
            if (str != null && str.equals(AccountUtils.q(AppContext.getContext(), false))) {
                awVarA.d = false;
            }
            awVar = awVarA;
        } else {
            awVar = null;
        }
        p(str4, q(map), tw4Var, awVar, LxRetryCacheHelper.needRetry() ? wt0.genRetryPolicy() : null);
    }

    @Override // defpackage.uo2
    public void g(tw4<CommonResponse<String>> tw4Var) {
        n(nl0.z + "/uac.need.guide", new HashMap(), tw4Var);
    }

    @Override // defpackage.uo2
    public void h(long j, List<String> list, tw4<CommonResponse<ShareSmsBean>> tw4Var) {
        String str = nl0.z + "/muc.red.getShareMsg.v1";
        Map<String, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        map.put("reqId", xn3.a());
        map.put("feedId", Long.valueOf(j));
        map.put("receiverMobiles", jSONArray);
        n(str, map, tw4Var);
    }

    @Override // defpackage.uo2
    public void i(tw4<CommonResponse<List<Integer>>> tw4Var) {
        n(nl0.z + "/sendpost.tag.all.v1", new HashMap(), tw4Var);
    }

    @Override // defpackage.uo2
    public void j(int i, String str, String str2, tw4<CommonResponse<ProfileInviteBean>> tw4Var) {
        String str3 = nl0.z + "/friend.tab.invite.v2";
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("fuid", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("fexid", str2);
        }
        if (i > 0) {
            map.put("type", Integer.valueOf(i));
        }
        n(str3, map, tw4Var);
    }

    @Override // defpackage.uo2
    public void k(String str, String str2, int i, tw4<CommonResponse<SquareTagListBean>> tw4Var) {
        String str3 = nl0.z + "/tag.queryUserShowTagList.v1";
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put(DeviceInfoUtil.UID_TAG, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(bd.h, str2);
        }
        map.put("scene", Integer.valueOf(i));
        n(str3, map, tw4Var);
    }

    @Override // defpackage.vo2
    public void l(tw4<CommonResponse<TopicListBean>> tw4Var) {
        n(nl0.z + "/square.topic.list.v1", new HashMap(), tw4Var);
    }

    @Override // defpackage.uo2
    public void m(tw4<CommonResponse<List<Integer>>> tw4Var) {
        n(nl0.z + "/sendpost.tag.hot.v1", new HashMap(), tw4Var);
    }

    public void n(String str, Map<String, Object> map, tw4 tw4Var) {
        o(str, q(map), tw4Var);
    }

    public void o(String str, JSONObject jSONObject, tw4 tw4Var) {
        p(str, jSONObject, tw4Var, null, null);
    }

    public void p(String str, JSONObject jSONObject, tw4 tw4Var, aw awVar, RetryPolicy retryPolicy) {
        try {
            tw4Var.d();
            String strZ = k86.Z(str);
            LogUtil.json("logsquare", jSONObject.toString(), "request: " + strZ);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            vw4 vw4Var = new vw4(strZ, tw4Var);
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, vw4Var, vw4Var);
            encryptedJsonRequest.setCacheConfig(awVar);
            if (retryPolicy != null) {
                encryptedJsonRequest.setRetryPolicy(retryPolicy);
            }
            normalRequestQueue.add(encryptedJsonRequest);
        } catch (Exception unused) {
            tw4Var.b(-1, "");
            tw4Var.c();
        }
    }

    public final JSONObject q(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
