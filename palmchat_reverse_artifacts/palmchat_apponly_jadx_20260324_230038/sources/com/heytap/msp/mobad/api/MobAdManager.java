package com.heytap.msp.mobad.api;

import android.content.Context;
import com.heytap.msp.mobad.api.MobCustomController;
import com.heytap.msp.mobad.api.listener.IInitListener;
import com.opos.mobad.ad.d;
import com.opos.mobad.ad.e;
import com.opos.mobad.ad.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class MobAdManager {
    public static final int POS_TYPE_BANNER = 2;
    public static final int POS_TYPE_INTERSTITIAL = 3;
    public static final int POS_TYPE_NATIVE = 4;
    public static final int POS_TYPE_NATIVE_TEMPLATE = 5;
    public static final int POS_TYPE_REWARD_VIDEO = 6;
    public static final int POS_TYPE_SPLASH = 1;
    private static volatile MobAdManager sMobAdManager;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CustomProviderWrapper implements e {
        private MobCustomController mController;

        public CustomProviderWrapper(MobCustomController mobCustomController) {
            this.mController = mobCustomController;
        }

        @Override // com.opos.mobad.ad.e
        public boolean alist() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.getMAlist();
        }

        @Override // com.opos.mobad.ad.e
        public String getAndroidId() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return null;
            }
            return mobCustomController.getAndroidId();
        }

        @Override // com.opos.mobad.ad.e
        public String getDevImei() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return null;
            }
            return mobCustomController.getDevImei();
        }

        @Override // com.opos.mobad.ad.e
        public e.a getLocation() {
            final MobCustomController.LocationProvider location;
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null || (location = mobCustomController.getLocation()) == null) {
                return null;
            }
            return new e.a() { // from class: com.heytap.msp.mobad.api.MobAdManager.CustomProviderWrapper.1
                @Override // com.opos.mobad.ad.e.a
                public double getLatitude() {
                    return location.getMLatitude();
                }

                @Override // com.opos.mobad.ad.e.a
                public double getLongitude() {
                    return location.getMLongitude();
                }
            };
        }

        @Override // com.opos.mobad.ad.e
        public String getMacAddress() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return null;
            }
            return mobCustomController.getMacAddress();
        }

        @Override // com.opos.mobad.ad.e
        public int getMinorsMode() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return 0;
            }
            return mobCustomController.getMinorsMode();
        }

        @Override // com.opos.mobad.ad.e
        public int getMinorsModeAgeRange() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return 0;
            }
            return mobCustomController.getMinorsModeAgeRange();
        }

        @Override // com.opos.mobad.ad.e
        public int getMinorsModeEnable() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return 0;
            }
            return mobCustomController.getMinorsModeEnable();
        }

        @Override // com.opos.mobad.ad.e
        public boolean isCanUseAndroidId() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.isCanUseAndroidId();
        }

        @Override // com.opos.mobad.ad.e
        public boolean isCanUseLocation() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.isCanUseLocation();
        }

        @Override // com.opos.mobad.ad.e
        public boolean isCanUsePhoneState() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.isCanUsePhoneState();
        }

        @Override // com.opos.mobad.ad.e
        public boolean isCanUseWifiState() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.isCanUseWifiState();
        }

        @Override // com.opos.mobad.ad.e
        public boolean isCanUseWriteExternal() {
            MobCustomController mobCustomController = this.mController;
            if (mobCustomController == null) {
                return false;
            }
            return mobCustomController.isCanUseWriteExternal();
        }
    }

    private MobAdManager() {
    }

    private int getCVer() {
        return -1;
    }

    public static MobAdManager getInstance() {
        MobAdManager mobAdManager = sMobAdManager;
        if (mobAdManager == null) {
            synchronized (MobAdManager.class) {
                mobAdManager = sMobAdManager;
                if (mobAdManager == null) {
                    mobAdManager = new MobAdManager();
                    sMobAdManager = mobAdManager;
                }
            }
        }
        return mobAdManager;
    }

    private e transform(InitParams initParams) {
        MobCustomController mobCustomController;
        if (initParams == null || (mobCustomController = initParams.mobCustomController) == null) {
            return null;
        }
        return new CustomProviderWrapper(mobCustomController);
    }

    public void exit(Context context) {
        ProxyManager.getInstance().a(context);
    }

    public int getSdkVerCode() {
        return 910004;
    }

    public String getSdkVerName() {
        return "9.1.0";
    }

    public String getToken(String str, int i) {
        return ProxyManager.getInstance().a(str, i);
    }

    public void init(Context context, String str) throws NullPointerException {
        ProxyManager.getInstance().a(context, str, getCVer());
    }

    public boolean isSupportedMobile() {
        return ProxyManager.getInstance().a();
    }

    public void init(Context context, String str, InitParams initParams) throws NullPointerException {
        init(context, str, initParams, null);
    }

    public void init(Context context, String str, final InitParams initParams, final IInitListener iInitListener) throws NullPointerException {
        ProxyManager.getInstance().a(context, str, initParams != null ? initParams.debug : false, initParams != null ? initParams.appOUIDStatus : true, getCVer(), new h() { // from class: com.heytap.msp.mobad.api.MobAdManager.3
            @Override // com.opos.mobad.ad.h
            public void onFailed(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }

            @Override // com.opos.mobad.ad.h
            public void onSuccess() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }
        }, initParams != null && initParams.touristMode, initParams != null ? initParams.advanceMode : 0, (initParams == null || initParams.classifyByAgeProvider == null) ? null : new d() { // from class: com.heytap.msp.mobad.api.MobAdManager.2
            @Override // com.opos.mobad.ad.d
            public String getClassifyByAge() {
                return initParams.classifyByAgeProvider.getClassifyByAge();
            }
        }, transform(initParams));
    }

    public void init(Context context, String str, final IInitListener iInitListener) throws NullPointerException {
        ProxyManager.getInstance().a(context, str, getCVer(), new h() { // from class: com.heytap.msp.mobad.api.MobAdManager.1
            @Override // com.opos.mobad.ad.h
            public void onFailed(String str2) {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onFailed(str2);
                }
            }

            @Override // com.opos.mobad.ad.h
            public void onSuccess() {
                IInitListener iInitListener2 = iInitListener;
                if (iInitListener2 != null) {
                    iInitListener2.onSuccess();
                }
            }
        });
    }
}
