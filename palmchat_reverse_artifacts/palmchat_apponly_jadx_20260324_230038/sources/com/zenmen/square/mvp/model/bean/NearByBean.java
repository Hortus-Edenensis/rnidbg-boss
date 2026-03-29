package com.zenmen.square.mvp.model.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.qiniu.android.collect.ReportItem;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import defpackage.pv1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class NearByBean extends SquareBean {
    public static int TAG_TYPE_FEED_POLISH = 21;
    public static int TAG_TYPE_FEED_SEPARATION = 19;
    public transient pv1 adItem;
    public int age;
    public int aiChatType;
    public String avatar;
    public String city;
    public String cityCode;
    public String communicationType;
    public long distance;
    public String exid;
    public Ext ext;
    public Extra extra;
    public int from;
    public int gender;
    public String imprId;
    public boolean isBottomGuide;
    public boolean isMapFindGuideItem;
    public int itemType;
    public int jobCode;
    public String nickname;
    public boolean official;
    public int onlineStatusCode;
    public String onlineStatusDesc;
    public int page;
    public int pos;
    public String refresh_id;
    public boolean sameCity;
    public int superShowType;
    public List<String> tags;
    public String text1;
    public String text2;
    public long updateTime;
    public String userExt;
    public List<String> userLabelImg;
    public transient boolean lockTitle = false;
    public boolean hasShow = false;
    public int userType = 10;

    /* JADX INFO: compiled from: SearchBox */
    public static class Ext {
        public String channelId;
        public int channelType;
        public String sceneId;

        public boolean isValid() {
            return (TextUtils.isEmpty(this.channelId) || TextUtils.isEmpty(this.sceneId)) ? false : true;
        }

        public JSONObject toJSON() {
            HashMap map = new HashMap();
            map.put("channelId", this.channelId);
            map.put("sceneId", this.sceneId);
            map.put("channelType", Integer.valueOf(this.channelType));
            return new JSONObject(map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Extra {
        public String desc;
        public List<FeedSimpleInfo> feedList;
        public int type;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class FeedSimpleInfo {
        public long feedId;
        public int feedType;
        public int mediaSize;
        public String thumbUrl;
    }

    public Map<String, Object> genReportParams() {
        Ext ext;
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, this.reqId);
        map.put("tuid", this.exid);
        map.put("gender", Integer.valueOf(this.gender));
        map.put("distance", Long.valueOf(this.distance));
        Extra extra = this.extra;
        if (extra != null) {
            map.put("introtype", Integer.valueOf(extra.type));
        }
        map.put("onlinestate", this.onlineStatusCode == 1 ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
        map.put("impr_id", this.imprId);
        map.put("page", Integer.valueOf(this.page));
        map.put("pos", Integer.valueOf(this.pos));
        map.put("from", Integer.valueOf(this.from));
        map.put("refresh_id", this.refresh_id);
        if (this.userType != 11 || (ext = this.ext) == null) {
            map.put("phototype", 0);
        } else {
            map.put("channelId", ext.channelId);
            map.put("channelType", Integer.valueOf(this.ext.channelType));
            map.put("sceneId", this.ext.sceneId);
            map.put("phototype", 1);
        }
        map.put("superShowType", Integer.valueOf(this.superShowType));
        if (this.userType == TAG_TYPE_FEED_SEPARATION) {
            map.put("usertype", 1);
        } else {
            map.put("usertype", 0);
        }
        map.put("realUserType", Integer.valueOf(this.userType));
        return map;
    }

    public int getChatBizType(int i) {
        int i2 = this.superShowType;
        if (i2 == 1) {
            return ErrorCode.AD_POS_ID_BLOCKED;
        }
        if (i2 == 2) {
            return ErrorCode.REWARD_PAGE_SHOW_ERROR;
        }
        if (i2 == 3) {
            if (i == 1) {
                return 5057;
            }
            if (i == 2) {
                return 5056;
            }
            if (i == 3) {
                return ErrorCode.NO_AD_FILL_FOR_MULTI;
            }
        }
        return ErrorCode.AD_POS_ID_BLOCKED;
    }

    public boolean isAiChat() {
        return this.aiChatType == 1;
    }

    public boolean isSuperExpose() {
        return this.superShowType > 0;
    }
}
