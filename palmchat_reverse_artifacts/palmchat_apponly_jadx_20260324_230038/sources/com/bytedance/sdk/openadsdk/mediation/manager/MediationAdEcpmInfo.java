package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationAdEcpmInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5429a;
    private String b;
    private String fx;
    private int iz;
    private String jk;
    private String k;
    private String l;
    private String mv;
    private Map<String, String> my;
    private String n;
    private String nr;
    private String pn;
    private String s;
    private String t;
    private String u;
    private String x;

    public MediationAdEcpmInfo() {
        this.my = new HashMap();
    }

    public String getAbTestId() {
        return this.s;
    }

    public String getChannel() {
        return this.l;
    }

    public Map<String, String> getCustomData() {
        return this.my;
    }

    public String getCustomSdkName() {
        return this.nr;
    }

    public String getEcpm() {
        return this.pn;
    }

    public String getErrorMsg() {
        return this.x;
    }

    public String getLevelTag() {
        return this.b;
    }

    public int getReqBiddingType() {
        return this.iz;
    }

    public String getRequestId() {
        return this.n;
    }

    public String getRitType() {
        return this.f5429a;
    }

    public String getScenarioId() {
        return this.k;
    }

    public String getSdkName() {
        return this.u;
    }

    public String getSegmentId() {
        return this.t;
    }

    public String getSlotId() {
        return this.fx;
    }

    public String getSubChannel() {
        return this.mv;
    }

    public String getSubRitType() {
        return this.jk;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.my = map2;
        this.u = str;
        this.nr = str2;
        this.fx = str3;
        this.b = str4;
        this.pn = str5;
        this.iz = i;
        this.x = str6;
        this.n = str7;
        this.f5429a = str8;
        this.jk = str9;
        this.t = str10;
        this.l = str11;
        this.mv = str12;
        this.s = str13;
        this.k = str14;
        if (map != null) {
            this.my = map;
        } else {
            map2.clear();
        }
    }
}
