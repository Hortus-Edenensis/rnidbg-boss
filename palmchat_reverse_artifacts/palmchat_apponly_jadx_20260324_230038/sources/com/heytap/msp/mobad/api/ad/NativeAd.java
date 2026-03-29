package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.INativeAdListener;
import com.heytap.msp.mobad.api.listener.INativeRewardAdListener;
import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeComplianceInfo;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.d;
import com.opos.mobad.ad.e.e;
import com.opos.mobad.ad.e.f;
import com.opos.mobad.ad.e.m;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.ad.e.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class NativeAd {
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 1;
    public static final int REWARD_SCENE_LAUNCH_APP = 2;
    public static final int REWARD_SCENE_NO = 0;
    public static final String TAG = "NativeAd";
    private boolean isCloseNative;
    private Context mContext;
    private NativeListenerWrapper mListener;
    private volatile c mNativeAdImpl;
    private String mPosId;
    private NativeRewardListener mRewardListener;
    private int mRewardScene;

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeAdDataWrapper implements INativeAdData {
        private final INativeComplianceInfo mComplianceInfo;
        private final d mNativeAdData;

        public NativeAdDataWrapper(d dVar) {
            this.mNativeAdData = dVar;
            this.mComplianceInfo = dVar.l() != null ? new INativeComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAd.NativeAdDataWrapper.1
                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppDescUrl() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().f();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppName() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().c();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppVersion() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().a();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getDeveloperName() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().b();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPermissionUrl() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().e();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPrivacyUrl() {
                    return NativeAdDataWrapper.this.mNativeAdData.l().d();
                }
            } : null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getClickBnText() {
            return this.mNativeAdData.j();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeComplianceInfo getComplianceInfo() {
            return this.mComplianceInfo;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getCreativeType() {
            return this.mNativeAdData.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getDesc() {
            return this.mNativeAdData.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getExtra() {
            return this.mNativeAdData.i();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getIconFiles() {
            List<e> listC = this.mNativeAdData.c();
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listC) {
                if (eVar != null) {
                    arrayList.add(new NativeFileWrapper(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getImgFiles() {
            List<e> listD = this.mNativeAdData.d();
            if (listD == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listD) {
                if (eVar != null) {
                    arrayList.add(new NativeFileWrapper(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getInteractionType() {
            return this.mNativeAdData.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeAdFile getLogoFile() {
            e eVarG = this.mNativeAdData.g();
            if (eVarG != null) {
                return new NativeFileWrapper(eVarG);
            }
            return null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getTitle() {
            return this.mNativeAdData.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isAdValid() {
            return this.mNativeAdData.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isCurrentApp(String str) {
            return this.mNativeAdData.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean launchApp() {
            return this.mNativeAdData.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdClick(View view) {
            this.mNativeAdData.b(view);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdShow(View view) {
            this.mNativeAdData.a(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeFileWrapper implements INativeAdFile {
        private final e mNativeFile;

        public NativeFileWrapper(e eVar) {
            this.mNativeFile = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getHeight() {
            return this.mNativeFile.c();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.mNativeFile.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.mNativeFile.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getWidth() {
            return this.mNativeFile.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeListenerWrapper implements f {
        private final INativeAdListener mListener;

        public NativeListenerWrapper(INativeAdListener iNativeAdListener) {
            this.mListener = iNativeAdListener;
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdError(q qVar, d dVar) {
            if (this.mListener == null) {
                return;
            }
            NativeAdDataWrapper nativeAdDataWrapper = dVar != null ? new NativeAdDataWrapper(dVar) : null;
            INativeAdListener iNativeAdListener = this.mListener;
            if (iNativeAdListener != null) {
                iNativeAdListener.onAdError(new NativeAdError(qVar.f8527a, qVar.b), nativeAdDataWrapper);
            }
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdFailed(q qVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onAdFailed(qVar != null ? new NativeAdError(qVar.f8527a, qVar.b) : null);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdSuccess(List<d> list) {
            ArrayList arrayList;
            if (this.mListener == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new NativeAdDataWrapper(dVar));
                    }
                }
            } else {
                arrayList = null;
            }
            this.mListener.onAdSuccess(arrayList);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeRewardListener implements m {
        public INativeRewardAdListener mListener;

        public NativeRewardListener(INativeRewardAdListener iNativeRewardAdListener) {
            this.mListener = iNativeRewardAdListener;
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdError(q qVar, d dVar) {
            if (this.mListener == null) {
                return;
            }
            NativeAdDataWrapper nativeAdDataWrapper = dVar != null ? new NativeAdDataWrapper(dVar) : null;
            INativeRewardAdListener iNativeRewardAdListener = this.mListener;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onAdError(new NativeAdError(qVar.f8527a, qVar.b), nativeAdDataWrapper);
            }
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdFailed(q qVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onAdFailed(qVar != null ? new NativeAdError(qVar.f8527a, qVar.b) : null);
        }

        @Override // com.opos.mobad.ad.e.f
        public void onAdSuccess(List<d> list) {
            ArrayList arrayList;
            if (this.mListener == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new NativeAdDataWrapper(dVar));
                    }
                }
            } else {
                arrayList = null;
            }
            this.mListener.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.i
        public void onInstallCompleted(String str) {
            INativeRewardAdListener iNativeRewardAdListener = this.mListener;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onInstallCompleted(str);
            }
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.mListener;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onReward(objArr);
            }
        }

        @Override // com.opos.mobad.ad.e.m
        public void onRewardFail(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.mListener;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onRewardFail(objArr);
            }
        }
    }

    @Deprecated
    public NativeAd(Context context, String str, int i, INativeRewardAdListener iNativeRewardAdListener) {
        this.isCloseNative = true;
        if (context == null || TextUtils.isEmpty(str) || iNativeRewardAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeRewardAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mRewardListener = new NativeRewardListener(iNativeRewardAdListener);
        this.mRewardScene = i;
        this.isCloseNative = ProxyManager.getInstance().a(this.mPosId);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.isCloseNative) {
            return false;
        }
        if (this.mNativeAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeAdImpl != null) {
                return true;
            }
            this.mNativeAdImpl = this.mRewardScene > 0 ? ProxyManager.getInstance().a(this.mContext.getApplicationContext(), this.mPosId, this.mRewardScene, this.mRewardListener) : ProxyManager.getInstance().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
            return this.mNativeAdImpl != null;
        }
    }

    @Deprecated
    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.a();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    @Deprecated
    public void loadAd() {
        loadAd(null);
    }

    @Deprecated
    public NativeAd(Context context, String str, INativeAdListener iNativeAdListener) {
        this.isCloseNative = true;
        if (context == null || TextUtils.isEmpty(str) || iNativeAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new NativeListenerWrapper(iNativeAdListener);
        this.isCloseNative = ProxyManager.getInstance().a(this.mPosId);
        initImplIfNeed();
    }

    @Deprecated
    public void loadAd(NativeAdParams nativeAdParams) {
        r rVarA;
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                r.a aVar = new r.a();
                aVar.a(nativeAdParams.fetchTimeout);
                rVarA = aVar.a();
            } else {
                rVarA = null;
            }
            this.mNativeAdImpl.a(rVarA);
            return;
        }
        int i = this.isCloseNative ? 10012 : -1;
        NativeListenerWrapper nativeListenerWrapper = this.mListener;
        if (nativeListenerWrapper != null) {
            nativeListenerWrapper.onAdFailed(new q(i, "inter ad create fail"));
            return;
        }
        NativeRewardListener nativeRewardListener = this.mRewardListener;
        if (nativeRewardListener != null) {
            nativeRewardListener.onAdFailed(new q(i, "inter ad create fail"));
        }
    }
}
