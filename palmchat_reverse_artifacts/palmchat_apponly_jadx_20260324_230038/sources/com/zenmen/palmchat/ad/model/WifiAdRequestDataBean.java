package com.zenmen.palmchat.ad.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WifiAdRequestDataBean {
    private String act;
    private AppInfo appInfo;
    private int bTabId;
    private BizInfo bizInfo;
    private int channelId;
    private String clientReqId;
    private int dynamicAdSwitch;
    private ExtInfo extInfo;
    private long feedTs;
    private boolean isPush;
    private int loadType;
    private int pageNo;
    private int preld;
    private String scene;
    private String serialId;
    private Story story;
    private long ts;

    /* JADX INFO: compiled from: SearchBox */
    public static class AppInfo {
        private String androidId;
        private String appId;
        private int btabId;
        private String chanId;
        private String dhid;
        private String feedVer;
        private String imei;
        private String imei1;
        private String imei2;
        private String lang;
        private String mac;
        private String meid;
        private String netModel;
        private String oaid;
        private String origChanId;
        private String verCode;
        private String verName;

        public String getAndroidId() {
            String str = this.androidId;
            return str == null ? "" : str;
        }

        public String getAppId() {
            String str = this.appId;
            return str == null ? "" : str;
        }

        public int getBtabId() {
            return this.btabId;
        }

        public String getChanId() {
            String str = this.chanId;
            return str == null ? "" : str;
        }

        public String getDhid() {
            String str = this.dhid;
            return str == null ? "" : str;
        }

        public String getFeedVer() {
            String str = this.feedVer;
            return str == null ? "" : str;
        }

        public String getImei() {
            String str = this.imei;
            return str == null ? "" : str;
        }

        public String getImei1() {
            String str = this.imei1;
            return str == null ? "" : str;
        }

        public String getImei2() {
            String str = this.imei2;
            return str == null ? "" : str;
        }

        public String getLang() {
            String str = this.lang;
            return str == null ? "" : str;
        }

        public String getMac() {
            String str = this.mac;
            return str == null ? "" : str;
        }

        public String getMeid() {
            String str = this.meid;
            return str == null ? "" : str;
        }

        public String getNetModel() {
            String str = this.netModel;
            return str == null ? "" : str;
        }

        public String getOaid() {
            String str = this.oaid;
            return str == null ? "" : str;
        }

        public String getOrigChanId() {
            String str = this.origChanId;
            return str == null ? "" : str;
        }

        public String getVerCode() {
            String str = this.verCode;
            return str == null ? "" : str;
        }

        public String getVerName() {
            String str = this.verName;
            return str == null ? "" : str;
        }

        public AppInfo setAndroidId(String str) {
            this.androidId = str;
            return this;
        }

        public AppInfo setAppId(String str) {
            this.appId = str;
            return this;
        }

        public AppInfo setBtabId(int i) {
            this.btabId = i;
            return this;
        }

        public AppInfo setChanId(String str) {
            this.chanId = str;
            return this;
        }

        public AppInfo setDhid(String str) {
            this.dhid = str;
            return this;
        }

        public AppInfo setFeedVer(String str) {
            this.feedVer = str;
            return this;
        }

        public AppInfo setImei(String str) {
            this.imei = str;
            return this;
        }

        public AppInfo setImei1(String str) {
            this.imei1 = str;
            return this;
        }

        public AppInfo setImei2(String str) {
            this.imei2 = str;
            return this;
        }

        public AppInfo setLang(String str) {
            this.lang = str;
            return this;
        }

        public AppInfo setMac(String str) {
            this.mac = str;
            return this;
        }

        public AppInfo setMeid(String str) {
            this.meid = str;
            return this;
        }

        public AppInfo setNetModel(String str) {
            this.netModel = str;
            return this;
        }

        public AppInfo setOaid(String str) {
            this.oaid = str;
            return this;
        }

        public AppInfo setOrigChanId(String str) {
            this.origChanId = str;
            return this;
        }

        public AppInfo setVerCode(String str) {
            this.verCode = str;
            return this;
        }

        public AppInfo setVerName(String str) {
            this.verName = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BizInfo {
        private int cache;
        private int detect;
        private int preSex;
        private int sex;

        public int getCache() {
            return this.cache;
        }

        public int getDetect() {
            return this.detect;
        }

        public int getPreSex() {
            return this.preSex;
        }

        public int getSex() {
            return this.sex;
        }

        public BizInfo setCache(int i) {
            this.cache = i;
            return this;
        }

        public BizInfo setDetect(int i) {
            this.detect = i;
            return this;
        }

        public BizInfo setPreSex(int i) {
            this.preSex = i;
            return this;
        }

        public BizInfo setSex(int i) {
            this.sex = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ExtInfo {
        private String androidAdId;
        private String androidId;
        private String appPkgName;
        private int deviceType;
        private String deviceVendor;
        private String deviceVersion;
        private String isp;
        private String oppoMargetVersion;
        private String os;
        private int osApiLevel;
        private String osVersion;
        private float screenDensity;
        private int screenHeight;
        private int screenOrientation;
        private int screenWidth;
        private String sdAvailable;

        public String getAndroidAdId() {
            String str = this.androidAdId;
            return str == null ? "" : str;
        }

        public String getAndroidId() {
            String str = this.androidId;
            return str == null ? "" : str;
        }

        public String getAppPkgName() {
            String str = this.appPkgName;
            return str == null ? "" : str;
        }

        public int getDeviceType() {
            return this.deviceType;
        }

        public String getDeviceVendor() {
            String str = this.deviceVendor;
            return str == null ? "" : str;
        }

        public String getDeviceVersion() {
            String str = this.deviceVersion;
            return str == null ? "" : str;
        }

        public String getIsp() {
            String str = this.isp;
            return str == null ? "" : str;
        }

        public String getOppoMargetVersion() {
            String str = this.oppoMargetVersion;
            return str == null ? "" : str;
        }

        public String getOs() {
            String str = this.os;
            return str == null ? "" : str;
        }

        public int getOsApiLevel() {
            return this.osApiLevel;
        }

        public String getOsVersion() {
            String str = this.osVersion;
            return str == null ? "" : str;
        }

        public float getScreenDensity() {
            return this.screenDensity;
        }

        public int getScreenHeight() {
            return this.screenHeight;
        }

        public int getScreenOrientation() {
            return this.screenOrientation;
        }

        public int getScreenWidth() {
            return this.screenWidth;
        }

        public String getSdAvailable() {
            String str = this.sdAvailable;
            return str == null ? "" : str;
        }

        public ExtInfo setAndroidAdId(String str) {
            this.androidAdId = str;
            return this;
        }

        public ExtInfo setAndroidId(String str) {
            this.androidId = str;
            return this;
        }

        public ExtInfo setAppPkgName(String str) {
            this.appPkgName = str;
            return this;
        }

        public ExtInfo setDeviceType(int i) {
            this.deviceType = i;
            return this;
        }

        public ExtInfo setDeviceVendor(String str) {
            this.deviceVendor = str;
            return this;
        }

        public ExtInfo setDeviceVersion(String str) {
            this.deviceVersion = str;
            return this;
        }

        public ExtInfo setIsp(String str) {
            this.isp = str;
            return this;
        }

        public ExtInfo setOppoMargetVersion(String str) {
            this.oppoMargetVersion = str;
            return this;
        }

        public ExtInfo setOs(String str) {
            this.os = str;
            return this;
        }

        public ExtInfo setOsApiLevel(int i) {
            this.osApiLevel = i;
            return this;
        }

        public ExtInfo setOsVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public ExtInfo setScreenDensity(float f) {
            this.screenDensity = f;
            return this;
        }

        public ExtInfo setScreenHeight(int i) {
            this.screenHeight = i;
            return this;
        }

        public ExtInfo setScreenOrientation(int i) {
            this.screenOrientation = i;
            return this;
        }

        public ExtInfo setScreenWidth(int i) {
            this.screenWidth = i;
            return this;
        }

        public ExtInfo setSdAvailable(String str) {
            this.sdAvailable = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Story {
        private String adPos;
        private String chapter;
        private String id;
        private String offset;
        private String sspId;

        public String getAdPos() {
            String str = this.adPos;
            return str == null ? "" : str;
        }

        public String getChapter() {
            String str = this.chapter;
            return str == null ? "" : str;
        }

        public String getId() {
            String str = this.id;
            return str == null ? "" : str;
        }

        public String getOffset() {
            String str = this.offset;
            return str == null ? "" : str;
        }

        public String getSspId() {
            String str = this.sspId;
            return str == null ? "" : str;
        }

        public Story setAdPos(String str) {
            this.adPos = str;
            return this;
        }

        public Story setChapter(String str) {
            this.chapter = str;
            return this;
        }

        public Story setId(String str) {
            this.id = str;
            return this;
        }

        public Story setOffset(String str) {
            this.offset = str;
            return this;
        }

        public Story setSspId(String str) {
            this.sspId = str;
            return this;
        }
    }

    public String getAct() {
        String str = this.act;
        return str == null ? "" : str;
    }

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public BizInfo getBizInfo() {
        return this.bizInfo;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getClientReqId() {
        String str = this.clientReqId;
        return str == null ? "" : str;
    }

    public int getDynamicAdSwitch() {
        return this.dynamicAdSwitch;
    }

    public ExtInfo getExtInfo() {
        return this.extInfo;
    }

    public long getFeedTs() {
        return this.feedTs;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPreld() {
        return this.preld;
    }

    public String getScene() {
        String str = this.scene;
        return str == null ? "" : str;
    }

    public String getSerialId() {
        String str = this.serialId;
        return str == null ? "" : str;
    }

    public Story getStory() {
        return this.story;
    }

    public long getTs() {
        return this.ts;
    }

    public int getbTabId() {
        return this.bTabId;
    }

    public boolean isPush() {
        return this.isPush;
    }

    public WifiAdRequestDataBean setAct(String str) {
        this.act = str;
        return this;
    }

    public WifiAdRequestDataBean setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
        return this;
    }

    public WifiAdRequestDataBean setBizInfo(BizInfo bizInfo) {
        this.bizInfo = bizInfo;
        return this;
    }

    public WifiAdRequestDataBean setChannelId(int i) {
        this.channelId = i;
        return this;
    }

    public WifiAdRequestDataBean setClientReqId(String str) {
        this.clientReqId = str;
        return this;
    }

    public WifiAdRequestDataBean setDynamicAdSwitch(int i) {
        this.dynamicAdSwitch = i;
        return this;
    }

    public WifiAdRequestDataBean setExtInfo(ExtInfo extInfo) {
        this.extInfo = extInfo;
        return this;
    }

    public WifiAdRequestDataBean setFeedTs(long j) {
        this.feedTs = j;
        return this;
    }

    public WifiAdRequestDataBean setLoadType(int i) {
        this.loadType = i;
        return this;
    }

    public WifiAdRequestDataBean setPageNo(int i) {
        this.pageNo = i;
        return this;
    }

    public WifiAdRequestDataBean setPreld(int i) {
        this.preld = i;
        return this;
    }

    public WifiAdRequestDataBean setPush(boolean z) {
        this.isPush = z;
        return this;
    }

    public WifiAdRequestDataBean setScene(String str) {
        this.scene = str;
        return this;
    }

    public WifiAdRequestDataBean setSerialId(String str) {
        this.serialId = str;
        return this;
    }

    public WifiAdRequestDataBean setStory(Story story) {
        this.story = story;
        return this;
    }

    public WifiAdRequestDataBean setTs(long j) {
        this.ts = j;
        return this;
    }

    public WifiAdRequestDataBean setbTabId(int i) {
        this.bTabId = i;
        return this;
    }
}
