package com.zenmen.palmchat.Vo;

import defpackage.jo6;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MomentsConfig {
    public static MomentsConfig i = new MomentsConfig();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12160a;
    public boolean b;
    public boolean c;
    public long d;
    public String e;
    public boolean f;
    public String g;
    public int h = 10;

    public MomentsConfig() {
        e();
    }

    public static MomentsConfig c() {
        return i;
    }

    public static boolean j() {
        return jo6.a("LX-9188", false);
    }

    public static MomentsConfig k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("momentsConfig")) == null) {
            return null;
        }
        MomentsConfig momentsConfig = new MomentsConfig();
        momentsConfig.f12160a = jSONObjectOptJSONObject.optBoolean("enableImageLongClick", momentsConfig.f12160a);
        momentsConfig.b = jSONObjectOptJSONObject.optBoolean("enableImageNotice", momentsConfig.b);
        momentsConfig.c = jSONObjectOptJSONObject.optBoolean("enableImageNoticeSwitch", momentsConfig.c);
        momentsConfig.d = jSONObjectOptJSONObject.optLong("imageNoticeInterval", 24L) * 60 * 60 * 1000;
        momentsConfig.e = jSONObjectOptJSONObject.optString("imageNoticeContent", momentsConfig.e);
        momentsConfig.f = jSONObjectOptJSONObject.optBoolean("pushMessageReadStatus", momentsConfig.f);
        momentsConfig.g = jSONObjectOptJSONObject.optString("nearbyHeadTitle", momentsConfig.g);
        momentsConfig.h = jSONObjectOptJSONObject.optInt("notifyChangeBackDuraion", 10);
        return momentsConfig;
    }

    public static void l(MomentsConfig momentsConfig) {
        i = momentsConfig;
    }

    public String a() {
        return this.e;
    }

    public long b() {
        return this.d;
    }

    public int d() {
        return this.h;
    }

    public final void e() {
        this.f12160a = true;
        this.b = true;
        this.c = true;
        this.d = 86400000L;
        this.e = "长按图片或<font color=\"#4C9DEA\">点击此处</font>，把照片分享给更多人。";
        this.f = true;
    }

    public boolean f() {
        return this.f12160a;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    public boolean i() {
        return this.f;
    }
}
