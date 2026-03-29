package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.opos.mobad.ad.e.n;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.p;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.ad.e.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NativeTempletAd {
    private static final String TAG = "NativeTempletAd";
    private Context mContext;
    private NativeTempleteListenerWrapper mListener;
    private NativeAdSize mNativeAdSize;
    private volatile n mNativeTempletAdImpl;
    private String mPosId;

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeTempleteListenerWrapper implements o {
        private final INativeTempletAdListener mListener;

        /* JADX INFO: compiled from: SearchBox */
        public static class TemplateViewWrapper implements INativeTempletAdView {
            private final p mAdView;

            public TemplateViewWrapper(p pVar) {
                this.mAdView = pVar;
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void destroy() {
                this.mAdView.c();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public View getAdView() {
                return this.mAdView.a();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public String getBidId() {
                return this.mAdView.g();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public int getECPM() {
                return this.mAdView.f();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankLoss(int i, String str, int i2) {
                this.mAdView.a(i, str, i2);
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankWin(int i) {
                this.mAdView.b(i);
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void render() {
                this.mAdView.b();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void setBidECPM(int i) {
                this.mAdView.c(i);
            }
        }

        public NativeTempleteListenerWrapper(INativeTempletAdListener iNativeTempletAdListener) {
            this.mListener = iNativeTempletAdListener;
        }

        public TemplateViewWrapper getTemplateView(p pVar) {
            return new TemplateViewWrapper(pVar);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClick(p pVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onAdClick(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClose(p pVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onAdClose(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdFailed(int i, String str) {
            INativeTempletAdListener iNativeTempletAdListener = this.mListener;
            if (iNativeTempletAdListener == null) {
                return;
            }
            iNativeTempletAdListener.onAdFailed(new NativeAdError(i, str));
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdShow(p pVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onAdShow(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdSuccess(List<p> list) {
            ArrayList arrayList;
            if (this.mListener == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (p pVar : list) {
                    if (pVar != null) {
                        TemplateViewWrapper templateView = getTemplateView(pVar);
                        pVar.a(templateView);
                        arrayList.add(templateView);
                    }
                }
            } else {
                arrayList = null;
            }
            this.mListener.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderFailed(q qVar, p pVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onRenderFailed(qVar != null ? new NativeAdError(qVar.f8527a, qVar.b) : null, pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderSuccess(p pVar) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onRenderSuccess(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }
    }

    public NativeTempletAd(Context context, String str, NativeAdSize nativeAdSize, INativeTempletAdListener iNativeTempletAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeTempletAdListener == null) {
            Log.e(TAG, "NativeTempletAd Constructor param context and posId and iNativeTempletAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mNativeAdSize = nativeAdSize;
        this.mListener = getListenerWrapper(iNativeTempletAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        int i;
        int i2;
        if (this.mNativeTempletAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeTempletAdImpl != null) {
                return true;
            }
            NativeAdSize nativeAdSize = this.mNativeAdSize;
            if (nativeAdSize != null) {
                i2 = nativeAdSize.widthInDp;
                i = nativeAdSize.heightInDp;
            } else {
                i = 0;
                i2 = 0;
            }
            this.mNativeTempletAdImpl = ProxyManager.getInstance().a(this.mContext, this.mPosId, new s.a().a(i2).b(i).a(), this.mListener);
            return this.mNativeTempletAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mNativeTempletAdImpl != null) {
            this.mNativeTempletAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public NativeTempleteListenerWrapper getListenerWrapper(INativeTempletAdListener iNativeTempletAdListener) {
        return new NativeTempleteListenerWrapper(iNativeTempletAdListener);
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAdWithData(NativeAdParams nativeAdParams, String str) {
        loadInter(nativeAdParams, str);
    }

    public void loadInter(NativeAdParams nativeAdParams, String str) {
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout, str);
                return;
            } else {
                this.mNativeTempletAdImpl.a(str);
                return;
            }
        }
        NativeTempleteListenerWrapper nativeTempleteListenerWrapper = this.mListener;
        if (nativeTempleteListenerWrapper != null) {
            nativeTempleteListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    private void loadInter(NativeAdParams nativeAdParams, List<String> list) {
        if (!initImplIfNeed()) {
            NativeTempleteListenerWrapper nativeTempleteListenerWrapper = this.mListener;
            if (nativeTempleteListenerWrapper != null) {
                nativeTempleteListenerWrapper.onAdFailed(-1, "inter ad create fail");
                return;
            }
            return;
        }
        if (nativeAdParams != null) {
            if (list == null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout);
                return;
            } else {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout, list);
                return;
            }
        }
        n nVar = this.mNativeTempletAdImpl;
        if (list == null) {
            nVar.a();
        } else {
            nVar.a(list);
        }
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        loadInter(nativeAdParams, (List<String>) null);
    }

    public void loadAd(NativeAdParams nativeAdParams, List<String> list) {
        if (list != null && list.size() > 0) {
            loadInter(nativeAdParams, new ArrayList(list));
            return;
        }
        NativeTempleteListenerWrapper nativeTempleteListenerWrapper = this.mListener;
        if (nativeTempleteListenerWrapper != null) {
            nativeTempleteListenerWrapper.onAdFailed(10701, "load error, please check you bidIds");
        }
    }
}
