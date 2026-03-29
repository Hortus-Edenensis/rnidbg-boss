package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.huawei.hms.ads.dw;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.listeners.e;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.views.PPSBannerView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ib extends ga<lo> implements ir<lo> {
    private int B;
    private com.huawei.openalliance.ad.inter.i C;
    private RequestOptions D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Location L;
    private Context S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.r f6570a;
    private Integer b;
    private Integer c;
    private Integer d;
    private boolean e = false;
    private String f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements e {
        private final WeakReference<ib> Code;

        public a(ib ibVar) {
            this.Code = new WeakReference<>(ibVar);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.e
        public void Code(final List<String> list) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ib ibVar = (ib) a.this.Code.get();
                    if (ibVar == null) {
                        fh.I("BannerPresenter", "onInValidContentIdsGot presenter is null");
                    } else {
                        fh.V("BannerPresenter", "loadAd onInValidContentIdsGot");
                        ibVar.I().Code(list);
                    }
                }
            });
        }
    }

    public ib(Context context, lo loVar) {
        Code(loVar);
        this.S = context != null ? context.getApplicationContext() : context;
    }

    private SourceParam Code(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        eh ehVarCode = eh.Code(this.S);
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        sourceParam.Code(ehVarCode == null ? com.huawei.openalliance.ad.constant.x.e : ehVarCode.s());
        return sourceParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.F;
        if (gVar == null) {
            fh.I("BannerPresenter", "downLoadBitmap nativeAd is null");
            Code(com.huawei.openalliance.ad.constant.ai.y);
            return;
        }
        List<ImageInfo> listB = gVar.B();
        if (com.huawei.openalliance.ad.utils.ag.Code(listB)) {
            fh.I("BannerPresenter", "downLoadBitmap imageInfo is null");
            Code(com.huawei.openalliance.ad.constant.ai.y);
            return;
        }
        final ImageInfo imageInfo = listB.get(0);
        Code(this.F);
        SourceParam sourceParamCode = Code(imageInfo);
        sourceParamCode.Code(this.Code);
        ac.Code(this.S, sourceParamCode, this.F.d(), this.F.r(), new com.huawei.openalliance.ad.utils.aq() { // from class: com.huawei.hms.ads.ib.4
            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code() {
                fh.I("BannerPresenter", "loadImage onFail");
                ib.this.Code(com.huawei.openalliance.ad.constant.ai.y);
            }

            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code(String str, final Drawable drawable) {
                if (TextUtils.equals(str, imageInfo.Z())) {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ib.this.I().Code(drawable, ib.this.F);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.huawei.openalliance.ad.inter.data.g gVar;
        final long jQ;
        if (this.B == 1 || (gVar = this.F) == null) {
            return;
        }
        String strAA = gVar instanceof com.huawei.openalliance.ad.inter.data.l ? ((com.huawei.openalliance.ad.inter.data.l) gVar).aA() : null;
        fh.V("BannerPresenter", "setBannerRefresh: %s", strAA);
        if (TextUtils.isEmpty(strAA)) {
            return;
        }
        if ("N".equalsIgnoreCase(strAA)) {
            jQ = 0;
        } else if ("Y".equalsIgnoreCase(strAA)) {
            jQ = eh.Code(this.S).q();
        } else {
            try {
                jQ = Long.parseLong(strAA);
            } catch (NumberFormatException e) {
                fh.I("BannerPresenter", "parseIntOrDefault exception: " + e.getClass().getSimpleName());
                return;
            }
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.3
            @Override // java.lang.Runnable
            public void run() {
                ib.this.I().Code(jQ);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Context context, final ImageView imageView, final Drawable drawable) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.ib.7
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableCode = com.huawei.openalliance.ad.utils.aa.Code(context, drawable, 5.0f, 8.0f);
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setBackground(drawableCode);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.ir
    public boolean S() {
        return com.huawei.openalliance.ad.utils.z.Code(this.S);
    }

    @Override // com.huawei.hms.ads.ir
    public void I(Integer num) {
        this.d = num;
    }

    @Override // com.huawei.hms.ads.ir
    public void V(Integer num) {
        this.c = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.openalliance.ad.inter.data.g Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<com.huawei.openalliance.ad.inter.data.g> it2 = it.next().getValue().iterator();
            if (it2.hasNext()) {
                return it2.next();
            }
        }
        return null;
    }

    @Override // com.huawei.hms.ads.ir
    public void V(String str) {
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.5
            @Override // java.lang.Runnable
            public void run() {
                ib.this.I().Code(i);
                if (i == 499) {
                    ib.this.I().B();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(final Context context, final ImageView imageView, Drawable drawable) {
        if (this.e) {
            try {
                if (drawable instanceof BitmapDrawable) {
                    imageView.setBackground(com.huawei.openalliance.ad.utils.aa.Code(context, drawable, 5.0f, 8.0f));
                } else if (drawable instanceof dw) {
                    ((dw) drawable).Code(new dw.a() { // from class: com.huawei.hms.ads.ib.6
                        @Override // com.huawei.hms.ads.dw.a
                        public void Code(Bitmap bitmap) {
                            ib.this.V(context, imageView, new BitmapDrawable(context.getResources(), bitmap));
                        }
                    });
                }
            } catch (Throwable th) {
                fh.I("BannerPresenter", "set banner background encounter exception: " + th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(Location location) {
        this.L = location;
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(RequestOptions requestOptions) {
        this.D = requestOptions;
    }

    private void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.e = gVar.b_();
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.F = lVar;
        this.Code = lVar != null ? lVar.q() : null;
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(com.huawei.openalliance.ad.inter.data.r rVar) {
        this.f6570a = rVar;
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(Integer num) {
        this.b = num;
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(String str, int i, List<String> list, int i2) {
        if (str == null || str.isEmpty()) {
            fh.I("BannerPresenter", "adId is null or empty when load ad");
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.1
                @Override // java.lang.Runnable
                public void run() {
                    ib.this.I().Code(702);
                }
            });
            return;
        }
        fh.Code("BannerPresenter", "loadAd ,adId:%s", str);
        this.B = i2;
        com.huawei.openalliance.ad.inter.n nVar = new com.huawei.openalliance.ad.inter.n(this.S, new String[]{str}, i, list);
        this.C = nVar;
        if (nVar instanceof com.huawei.openalliance.ad.inter.n) {
            nVar.Code(this.L);
            ((com.huawei.openalliance.ad.inter.n) this.C).Z(Integer.valueOf(this.B));
        }
        this.C.Code(com.huawei.hms.ads.utils.c.Code(this.D));
        this.C.Code(this.b);
        com.huawei.openalliance.ad.inter.data.b bannerSize = (I() == null || !(I() instanceof PPSBannerView)) ? null : ((PPSBannerView) I()).getBannerSize();
        if (bannerSize != null) {
            this.C.V(Integer.valueOf(bannerSize.I()));
            this.C.I(Integer.valueOf(bannerSize.Z()));
        } else {
            this.C.V(this.c);
            this.C.I(this.d);
        }
        String str2 = this.f;
        if (str2 != null) {
            this.C.Z(str2);
        }
        com.huawei.openalliance.ad.inter.data.r rVar = this.f6570a;
        if (rVar != null) {
            this.C.Code(rVar.Code());
            this.C.Code(this.f6570a.V());
            this.C.V(this.f6570a.I());
            this.C.I(this.f6570a.Z());
        }
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.n() { // from class: com.huawei.hms.ads.ib.2
            @Override // com.huawei.openalliance.ad.inter.listeners.n
            public void Code(final int i3) {
                fh.Code("BannerPresenter", "loadAd onAdFailed");
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ib.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ib.this.I().Code(i3);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.n
            public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
                fh.Code("BannerPresenter", "loadAd onAdsLoaded");
                ib ibVar = ib.this;
                ibVar.F = ibVar.Code(map);
                com.huawei.openalliance.ad.utils.i.V(new Runnable() { // from class: com.huawei.hms.ads.ib.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ib.this.D();
                    }
                });
                ib.this.F();
            }
        });
        this.C.Code(new a(this));
        this.C.Code(com.huawei.openalliance.ad.utils.q.I(this.S), null, false);
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j) {
        if (gVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            AdContentData adContentDataQ = ((com.huawei.openalliance.ad.inter.data.l) gVar).q();
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(str);
            analysisEventReport.Code(adContentDataQ);
            analysisEventReport.Code(j);
            if (adContentDataQ != null) {
                analysisEventReport.d(adContentDataQ.aE());
                analysisEventReport.e(adContentDataQ.L());
                analysisEventReport.c(adContentDataQ.a());
                analysisEventReport.I(adContentDataQ.aF());
            }
            com.huawei.openalliance.ad.ipc.g.V(this.S).Code("rptAdInvalidEvt", com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
        }
    }

    @Override // com.huawei.hms.ads.ir
    public boolean Code(com.huawei.openalliance.ad.inter.data.b bVar, float f) {
        if (!(I() instanceof PPSBannerView)) {
            return false;
        }
        PPSBannerView pPSBannerView = (PPSBannerView) I();
        Context applicationContext = pPSBannerView.getContext().getApplicationContext();
        int width = pPSBannerView.getWidth();
        int height = pPSBannerView.getHeight();
        if (fh.Code()) {
            fh.Code("BannerPresenter", "banner view width: %s, height: %s", Integer.valueOf(width), Integer.valueOf(height));
        }
        DisplayMetrics displayMetricsC = d.C(this.S);
        if (width > displayMetricsC.widthPixels || height > displayMetricsC.heightPixels) {
            fh.I("BannerPresenter", "Ad view is off screen");
            return false;
        }
        int iCode = bVar.Code();
        int iV = bVar.V();
        float f2 = iCode - width;
        float f3 = iCode;
        float f4 = iV - height;
        float f5 = iV;
        boolean z = f2 / f3 < f && f4 / f5 < f;
        if (!z) {
            float fA = d.a(applicationContext);
            if (fA > 0.0f) {
                fh.I("BannerPresenter", "Not enough space to show ad. Needs %s×%s dp, but only has %s×%s dp", Integer.valueOf(Math.round(f3 / fA)), Integer.valueOf(Math.round(f5 / fA)), Integer.valueOf(Math.round(width / fA)), Integer.valueOf(Math.round(height / fA)));
            }
        }
        return z;
    }
}
