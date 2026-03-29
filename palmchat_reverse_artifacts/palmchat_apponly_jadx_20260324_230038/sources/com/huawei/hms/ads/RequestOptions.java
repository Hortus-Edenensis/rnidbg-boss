package com.huawei.hms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.ImpEXs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
@AllApi
public class RequestOptions {
    private static final String TAG = "RequestOptions";

    @com.huawei.openalliance.ad.annotations.c(Code = "gACString")
    private String acString;
    private String adContentClassification;
    private App app;
    private String appCountry;
    private String appLang;
    private Map<String, BiddingParam> biddingParamMap;
    private String consent;
    private List<String> cur;

    @d
    private Map<String, Bundle> extras;
    private String hwACString;
    private Integer hwNonPersonalizedAd;
    private Map<String, ImpEXs> impEXs;
    private Integer isQueryUseEnabled;
    private Integer nonPersonalizedAd;
    private Boolean requestLocation;
    private SearchInfo searchInfo;
    private String searchTerm;
    private Boolean supportFa;
    private Integer tMax;
    private Integer tagForChildProtection;
    private Integer tagForUnderAgeOfPromise;
    private Integer thirdNonPersonalizedAd;

    /* JADX INFO: compiled from: SearchBox */
    @AllApi
    public static class Builder {
        private Integer Code;
        private String D;
        private String F;
        private String I;
        private App L;
        private Integer V;
        private int c;
        private Integer d;
        private List<String> e;
        private Boolean f;
        private String g;
        private Map<String, Bundle> h;
        private String i;
        private SearchInfo j;
        private String k;
        private String l;
        private Boolean m;
        private int n;
        private Integer Z = null;
        private Integer B = null;
        private Integer C = null;
        private Integer S = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, BiddingParam> f6526a = new HashMap();
        private List<String> b = new ArrayList();

        @AllApi
        public Builder() {
        }

        public Builder Code(String str) {
            this.k = str;
            return this;
        }

        public Builder V(String str) {
            this.l = str;
            return this;
        }

        @AllApi
        public Builder addBiddingParamMap(String str, BiddingParam biddingParam) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f6526a.put(str, biddingParam);
            return this;
        }

        @AllApi
        public RequestOptions build() {
            return new RequestOptions(this);
        }

        @AllApi
        public Builder setAdContentClassification(String str) {
            if (str != null && !"".equals(str)) {
                if (!"W".equals(str) && !ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str) && !ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str) && !"A".equals(str)) {
                    fh.Code(RequestOptions.TAG, "Invalid value for setAdContentClassification: %s", str);
                }
                return this;
            }
            str = null;
            this.I = str;
            return this;
        }

        @AllApi
        public Builder setApp(App app) {
            if (app == null) {
                fh.V(RequestOptions.TAG, "Invalid appInfo");
            } else {
                this.L = app;
            }
            return this;
        }

        @AllApi
        public Builder setAppCountry(String str) {
            if (TextUtils.isEmpty(str)) {
                fh.V(RequestOptions.TAG, "Invalid value passed to setAppCountry");
            } else {
                this.D = str;
            }
            return this;
        }

        @AllApi
        public Builder setAppLang(String str) {
            if (TextUtils.isEmpty(str)) {
                fh.V(RequestOptions.TAG, "Invalid value passed to setAppLang");
            } else {
                this.F = str;
            }
            return this;
        }

        @AllApi
        public Builder setBiddingParamMap(Map<String, BiddingParam> map) {
            if (map == null) {
                return null;
            }
            this.f6526a = map;
            return this;
        }

        @AllApi
        public Builder setConsent(String str) {
            this.i = str;
            return this;
        }

        @AllApi
        public Builder setCur(List<String> list) {
            if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.huawei.openalliance.ad.utils.bc.S(it.next()));
                }
                this.e = arrayList;
            }
            return this;
        }

        @AllApi
        public Builder setExtras(Map<String, Bundle> map) {
            this.h = map;
            return this;
        }

        @AllApi
        public Builder setHwNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.C = num;
            } else {
                fh.Z(RequestOptions.TAG, "Invalid value passed to setHwNonPersonalizedAd: " + num);
            }
            return this;
        }

        @AllApi
        public Builder setIsQueryUseEnabled(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.Z = num;
            } else {
                fh.Z(RequestOptions.TAG, "Invalid value passed to setIsQueryUseEnabled: " + num);
            }
            return this;
        }

        @AllApi
        public Builder setNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.B = num;
            } else {
                fh.Z(RequestOptions.TAG, "Invalid value passed to setNonPersonalizedAd: " + num);
            }
            return this;
        }

        @AllApi
        public Builder setRequestLocation(Boolean bool) {
            this.f = bool;
            return this;
        }

        @AllApi
        public Builder setSearchInfo(SearchInfo searchInfo) {
            this.j = searchInfo;
            return this;
        }

        @AllApi
        public Builder setSearchTerm(String str) {
            if (TextUtils.isEmpty(str)) {
                fh.V(RequestOptions.TAG, "Invalid value setSearchTerm");
            } else {
                this.g = str;
            }
            return this;
        }

        @AllApi
        public Builder setSupportFa(Boolean bool) {
            this.m = bool;
            return this;
        }

        @AllApi
        public Builder setTMax(Integer num) {
            this.d = num;
            return this;
        }

        @AllApi
        public Builder setTagForChildProtection(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.Code = num;
            } else {
                fh.Code(RequestOptions.TAG, "Invalid value passed to setTagForChildProtection: %s", num);
            }
            return this;
        }

        @AllApi
        public Builder setTagForUnderAgeOfPromise(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.V = num;
            } else {
                fh.Code(RequestOptions.TAG, "Invalid value passed to setTagForUnderAgeOfPromise: %s", num);
            }
            return this;
        }

        @AllApi
        public Builder setThirdNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.S = num;
            } else {
                fh.Z(RequestOptions.TAG, "Invalid value passed to setThirdNonPersonalizedAd: " + num);
            }
            return this;
        }

        public void Code(int i) {
            this.c = i;
        }

        public void V(int i) {
            this.n = i;
        }

        public void Code(List<String> list) {
            this.b = list;
        }
    }

    public RequestOptions() {
        this.nonPersonalizedAd = null;
        this.isQueryUseEnabled = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.biddingParamMap = new HashMap();
    }

    public Boolean B() {
        return this.requestLocation;
    }

    public String C() {
        return this.adContentClassification;
    }

    public BiddingParam Code(String str) {
        if (this.biddingParamMap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.biddingParamMap.get(str);
    }

    public String D() {
        return this.acString;
    }

    public SearchInfo F() {
        return this.searchInfo;
    }

    public Integer I() {
        return this.tMax;
    }

    public String L() {
        return this.hwACString;
    }

    public String S() {
        return this.searchTerm;
    }

    public Integer V() {
        return this.thirdNonPersonalizedAd;
    }

    public List<String> Z() {
        return this.cur;
    }

    public Boolean a() {
        return this.supportFa;
    }

    @AllApi
    public String getAdContentClassification() {
        String str = this.adContentClassification;
        return str == null ? "" : str;
    }

    @AllApi
    public App getApp() {
        return this.app;
    }

    @AllApi
    public String getAppCountry() {
        return this.appCountry;
    }

    @AllApi
    public String getAppLang() {
        return this.appLang;
    }

    @AllApi
    public String getConsent() {
        return this.consent;
    }

    @AllApi
    public Map<String, Bundle> getExtras() {
        return this.extras;
    }

    @AllApi
    public Integer getIsQueryUseEnabled() {
        return this.isQueryUseEnabled;
    }

    @AllApi
    public Integer getNonPersonalizedAd() {
        return this.nonPersonalizedAd;
    }

    @AllApi
    public Integer getTagForChildProtection() {
        return this.tagForChildProtection;
    }

    @AllApi
    public Integer getTagForUnderAgeOfPromise() {
        return this.tagForUnderAgeOfPromise;
    }

    @AllApi
    public boolean isRequestLocation() {
        Boolean bool = this.requestLocation;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @AllApi
    public Builder toBuilder() {
        return new Builder().setTagForChildProtection(this.tagForChildProtection).setTagForUnderAgeOfPromise(this.tagForUnderAgeOfPromise).setAdContentClassification(this.adContentClassification).setNonPersonalizedAd(this.nonPersonalizedAd).setIsQueryUseEnabled(this.isQueryUseEnabled).setHwNonPersonalizedAd(this.hwNonPersonalizedAd).setThirdNonPersonalizedAd(this.thirdNonPersonalizedAd).setAppLang(this.appLang).setApp(this.app).setBiddingParamMap(this.biddingParamMap).setTMax(this.tMax).setAppCountry(this.appCountry).setRequestLocation(this.requestLocation).setSearchTerm(this.searchTerm).setExtras(this.extras).setConsent(this.consent).setSearchInfo(this.searchInfo).Code(this.acString).V(this.hwACString).setSupportFa(this.supportFa).setCur(this.cur);
    }

    private RequestOptions(Builder builder) {
        this.nonPersonalizedAd = null;
        this.isQueryUseEnabled = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.biddingParamMap = new HashMap();
        this.tagForChildProtection = builder.Code;
        this.tagForUnderAgeOfPromise = builder.V;
        this.adContentClassification = builder.I;
        this.nonPersonalizedAd = builder.B;
        this.isQueryUseEnabled = builder.Z;
        this.hwNonPersonalizedAd = builder.C;
        this.thirdNonPersonalizedAd = builder.S;
        this.appLang = builder.F;
        this.appCountry = builder.D;
        this.app = builder.L;
        this.biddingParamMap = builder.f6526a;
        this.tMax = builder.d;
        this.cur = builder.e;
        this.requestLocation = builder.f;
        this.searchTerm = builder.g;
        Map<String, Bundle> map = builder.h;
        this.extras = map;
        this.impEXs = Code(map);
        this.consent = builder.i;
        this.searchInfo = builder.j;
        this.acString = builder.k;
        this.hwACString = builder.l;
        this.supportFa = builder.m;
    }

    public Integer Code() {
        return this.hwNonPersonalizedAd;
    }

    public void I(String str) {
        this.acString = str;
    }

    public void V(String str) {
        this.consent = str;
    }

    public void Z(String str) {
        this.hwACString = str;
    }

    private Map<String, ImpEXs> Code(Map<String, Bundle> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap map2 = new HashMap();
        try {
            for (Map.Entry<String, Bundle> entry : map.entrySet()) {
                String key = entry.getKey();
                Bundle value = entry.getValue();
                if (value != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : value.keySet()) {
                        arrayList.add(new ImpEX(str, com.huawei.openalliance.ad.utils.bc.S(value.getString(str))));
                    }
                    map2.put(key, new ImpEXs(arrayList));
                }
            }
            return map2;
        } catch (Throwable th) {
            fh.I(TAG, "toImpEXs err: %s", th.getClass().getSimpleName());
            return map2;
        }
    }

    public void Code(Boolean bool) {
        this.supportFa = bool;
    }
}
