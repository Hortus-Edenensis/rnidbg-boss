package com.zenmen.palmchat.circle.app.dragon;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.core.scene.URLPackage;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DragonItem implements Serializable {
    public static final int DRAGON_TYPE_COMMON = 1;
    public static final int DRAGON_TYPE_WORDS = 2;
    public static final int FLAG_DRAGON_NOT_TOP = 0;
    public static final int FLAG_DRAGON_TOP = 1;

    @SerializedName("descr")
    public String content;

    @SerializedName("id")
    public long dragonId;

    @SerializedName("rid")
    public String groupId;
    public boolean isTopinList;
    private ArrayList<DragonConfirmItem> items;

    @SerializedName("joinCount")
    public int joinCount;
    public long optoptime;

    @SerializedName("createdAt")
    public long publishTime;
    public String publisherHeadUrl;

    @SerializedName(URLPackage.KEY_AUTHOR_ID)
    public String publisherId;

    @SerializedName("nickname")
    public String publisherName;
    public String selfContent;

    @SerializedName(bq.f.h)
    public long timeDeadLine;
    private int toTop;
    public int type = 1;
    public int top2ChatWindow = 0;
    public boolean isOverTime = false;
    public boolean isSelfJoin = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<BaseResponse<DragonItem>> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparator<DragonItem> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DragonItem dragonItem, DragonItem dragonItem2) {
            return dragonItem.getToTop() - dragonItem2.getToTop();
        }
    }

    public static DragonItem buildFromMessageVo(MessageVo messageVo) {
        if (messageVo == null) {
            return null;
        }
        try {
            BaseResponse baseResponse = (BaseResponse) new Gson().fromJson(messageVo.extention, new a().getType());
            if (baseResponse != null) {
                return (DragonItem) baseResponse.getData();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<DragonConfirmItem> getItems() {
        return this.items;
    }

    public int getToTop() {
        return this.toTop;
    }

    public void setItems(ArrayList<DragonConfirmItem> arrayList) {
        this.items = arrayList;
    }

    public void setToTop(int i) {
        this.toTop = i;
    }
}
