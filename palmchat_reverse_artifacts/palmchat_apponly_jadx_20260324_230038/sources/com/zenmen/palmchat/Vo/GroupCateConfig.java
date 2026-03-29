package com.zenmen.palmchat.Vo;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GroupCateConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<CateItem> f12154a = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class CateItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12155a;
        public String b;

        public CateItem(int i, String str) {
            this.f12155a = i;
            this.b = str;
        }
    }

    public GroupCateConfig() {
        a();
    }

    public static GroupCateConfig b(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("groupCategory");
            LogUtil.i("GroupCateConfig", "dictConfig" + jSONArrayOptJSONArray);
            if (jSONArrayOptJSONArray != null) {
                ArrayList<CateItem> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            arrayList.add(new CateItem(Integer.parseInt(next), jSONObject2.optString(next)));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (arrayList.size() > 0) {
                    GroupCateConfig groupCateConfig = new GroupCateConfig();
                    groupCateConfig.f12154a = arrayList;
                    return groupCateConfig;
                }
            }
        }
        return null;
    }

    public final void a() {
        this.f12154a.add(new CateItem(101, "同事同行"));
        this.f12154a.add(new CateItem(102, "置业安家"));
        this.f12154a.add(new CateItem(103, "游戏"));
        this.f12154a.add(new CateItem(104, "商家营销"));
        this.f12154a.add(new CateItem(105, "明星粉丝"));
        this.f12154a.add(new CateItem(106, "兴趣爱好"));
        this.f12154a.add(new CateItem(107, "生活休闲"));
        this.f12154a.add(new CateItem(108, "学习培训"));
        this.f12154a.add(new CateItem(109, "行业交流"));
        this.f12154a.add(new CateItem(110, "家校师生"));
        this.f12154a.add(new CateItem(111, "家人亲戚"));
        this.f12154a.add(new CateItem(112, "职场工作"));
        this.f12154a.add(new CateItem(113, "同学校友"));
        this.f12154a.add(new CateItem(114, "亲子育儿"));
        this.f12154a.add(new CateItem(115, "小区生活"));
        this.f12154a.add(new CateItem(116, "同乡同城"));
        this.f12154a.add(new CateItem(117, "招聘求职"));
        this.f12154a.add(new CateItem(118, "其他"));
    }
}
