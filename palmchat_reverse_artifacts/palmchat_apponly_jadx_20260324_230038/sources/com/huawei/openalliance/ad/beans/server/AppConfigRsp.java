package com.huawei.openalliance.ad.beans.server;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class AppConfigRsp {
    private Integer adsCoreSel;
    private Integer allowAdSkipTime;
    private Integer bdinterval;
    private String configMap;
    private Integer configRefreshInterval;
    private List<String> defBrowerPkgList;
    private String globalSwitch;
    private double limitOfContainerAspectRatio;
    private Long maxBannerInterval;
    private Long minBannerInterval;
    private Integer oaidReportOnNpa;
    private String sha256;
    private List<String> singleInstanceLSModelList;
    private Integer sloganShowTime;
    private Integer splashInteractCloseEffectiveTime;
    private Integer splashmode;
    private String testCountryCode;
    private String trustAppList;
    private int splashshow = 3000;
    private int splashVideoCountdownTime = 5000;
    private int splashSkipArea = 0;
    private long sloganShowMinTimeRealMode = 300;
    private int splashUserAppDayImpFc = 0;
    private Long locationExpireTime = 1800000L;
    private Long locationRefreshInterval = 1800000L;
    private int locationSwitch = 0;
    private long preloadSplashReqTimeInterval = 600000;
    private int retcode = -1;

    private int s() {
        Integer num = this.sloganShowTime;
        if (num != null && num.intValue() >= 500 && this.sloganShowTime.intValue() <= 5000) {
            return this.sloganShowTime.intValue();
        }
        return 2000;
    }

    private int t() {
        Integer num = this.sloganShowTime;
        if (num == null) {
            return 2000;
        }
        if (num.intValue() < 0 || this.sloganShowTime.intValue() > 5000) {
            return 0;
        }
        return this.sloganShowTime.intValue();
    }

    public Integer B() {
        if (this.sloganShowTime == null) {
            return null;
        }
        Integer num = this.splashmode;
        return Integer.valueOf((num == null || 1 == num.intValue()) ? t() : (2 == this.splashmode.intValue() || 3 == this.splashmode.intValue()) ? s() : 0);
    }

    public int C() {
        int i = this.splashshow;
        if (i >= 2000) {
            return i;
        }
        return 3000;
    }

    public int Code() {
        return this.retcode;
    }

    public int D() {
        int i = this.splashSkipArea;
        if (i < 0 || i > 200) {
            return 0;
        }
        return i;
    }

    public Integer F() {
        Integer num = this.splashmode;
        if (num == null) {
            return null;
        }
        return Integer.valueOf((1 == num.intValue() || 2 == this.splashmode.intValue() || 3 == this.splashmode.intValue()) ? this.splashmode.intValue() : 1);
    }

    public int I() {
        int i = this.splashUserAppDayImpFc;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public Integer L() {
        return this.configRefreshInterval;
    }

    public int S() {
        int i = this.splashVideoCountdownTime;
        if (i >= 0) {
            return i;
        }
        return 5000;
    }

    public String V() {
        return this.trustAppList;
    }

    public long Z() {
        long j = this.sloganShowMinTimeRealMode;
        if (j < 0 || j > 5000) {
            return 300L;
        }
        return j;
    }

    public String a() {
        return this.globalSwitch;
    }

    public List<String> b() {
        return this.defBrowerPkgList;
    }

    public long c() {
        return this.preloadSplashReqTimeInterval;
    }

    public Long d() {
        return this.minBannerInterval;
    }

    public Long e() {
        return this.maxBannerInterval;
    }

    public Long f() {
        return Long.valueOf(this.locationExpireTime.longValue() > 0 ? this.locationExpireTime.longValue() : 1800000L);
    }

    public int g() {
        return this.locationSwitch;
    }

    public Long h() {
        return Long.valueOf(this.locationRefreshInterval.longValue() > 0 ? this.locationRefreshInterval.longValue() : 1800000L);
    }

    public double i() {
        double d = this.limitOfContainerAspectRatio;
        if (d <= 0.0d) {
            return 0.05000000074505806d;
        }
        return d;
    }

    public Integer j() {
        return this.adsCoreSel;
    }

    public String k() {
        return this.testCountryCode;
    }

    public String l() {
        return this.configMap;
    }

    public Integer m() {
        return this.bdinterval;
    }

    public Integer n() {
        return this.oaidReportOnNpa;
    }

    public Integer o() {
        return this.allowAdSkipTime;
    }

    public Integer p() {
        return this.splashInteractCloseEffectiveTime;
    }

    public List<String> q() {
        return this.singleInstanceLSModelList;
    }

    public String r() {
        return this.sha256;
    }

    public void B(Integer num) {
        this.splashInteractCloseEffectiveTime = num;
    }

    public void Code(double d) {
        this.limitOfContainerAspectRatio = d;
    }

    public void I(Integer num) {
        this.oaidReportOnNpa = num;
    }

    public void V(Integer num) {
        this.bdinterval = num;
    }

    public void Z(Integer num) {
        this.allowAdSkipTime = num;
    }

    public void Code(int i) {
        this.locationSwitch = i;
    }

    public void I(Long l) {
        this.locationExpireTime = l;
    }

    public void V(Long l) {
        this.maxBannerInterval = l;
    }

    public void Z(Long l) {
        this.locationRefreshInterval = l;
    }

    public void Code(Integer num) {
        this.adsCoreSel = num;
    }

    public void Code(Long l) {
        this.minBannerInterval = l;
    }

    public void Code(String str) {
        this.trustAppList = str;
    }

    public void Code(List<String> list) {
        this.singleInstanceLSModelList = list;
    }
}
