package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class f extends b implements com.kwad.sdk.widget.d {

    @NonNull
    private KsAdVideoPlayConfig bU;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0618a cz;
    private KSFrameLayout fC;
    private ImageView hM;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    @NonNull
    protected Context mContext;
    private c mi;
    private KSFrameLayout nh;
    private com.kwad.components.core.video.f ni;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final a.InterfaceC0561a hQ = new a.InterfaceC0561a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC0561a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(int i, aj.a aVar) {
            final int i2;
            int i3;
            boolean z = false;
            if (i == 1) {
                i2 = 13;
            } else if (i == 2) {
                i2 = 82;
            } else {
                if (i == 3) {
                    i2 = 83;
                    z = true;
                    i3 = 1;
                    f.this.getContext();
                    int i4 = aq.SM() ? 2 : 1;
                    com.kwad.components.ad.interstitial.report.a.eP().a(f.this.mAdTemplate, 1L, i2);
                    com.kwad.components.core.e.d.a.a(new a.C0539a(f.this.getContext()).aE(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aD(i3).as(z).au(true).aC(i2).d(aVar).aE(i4).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            f.this.l(i2);
                        }
                    }));
                }
                i2 = 108;
            }
            i3 = 2;
            f.this.getContext();
            if (aq.SM()) {
            }
            com.kwad.components.ad.interstitial.report.a.eP().a(f.this.mAdTemplate, 1L, i2);
            com.kwad.components.core.e.d.a.a(new a.C0539a(f.this.getContext()).aE(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aD(i3).as(z).au(true).aC(i2).d(aVar).aE(i4).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    f.this.l(i2);
                }
            }));
        }
    };

    private void ey() {
        String strEZ;
        this.mIsAudioEnable = this.bU.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.hM.setVisibility(8);
        } else {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        }
        int iDz = com.kwad.sdk.core.config.e.Dz();
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        if (iDz < 0) {
            File fileCr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(strL);
            if (fileCr == null || !fileCr.exists()) {
                strL = null;
            } else {
                strEZ = fileCr.getAbsolutePath();
                strL = strEZ;
            }
        } else if (iDz != 0) {
            com.kwad.sdk.core.videocache.f fVarCa = com.kwad.sdk.core.videocache.c.a.ca(this.mContext);
            if (com.kwad.sdk.core.config.e.GJ()) {
                int iDz2 = com.kwad.sdk.core.config.e.Dz();
                if (fVarCa.fb(strL)) {
                    strEZ = fVarCa.eZ(strL);
                } else {
                    if (fVarCa.a(strL, iDz2 * 1024, new a.C0614a(), null)) {
                        strEZ = fVarCa.eZ(strL);
                    }
                }
                strL = strEZ;
            } else {
                strL = fVarCa.eZ(strL);
            }
        }
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.cq.a(new b.a(this.mAdTemplate).dt(strL).du(h.b(com.kwad.sdk.core.response.b.e.es(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ga(), null);
        a.InterfaceC0618a interfaceC0618a = new a.InterfaceC0618a() { // from class: com.kwad.components.ad.interstitial.f.f.1
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0618a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aGw)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aGx)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, f.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cz = interfaceC0618a;
        this.cq.setExternalPlayerListener(interfaceC0618a);
        this.cq.setVideoSoundEnable(this.mIsAudioEnable);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.components.ad.interstitial.report.d.eV().E(this.mAdTemplate);
        this.ni.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.f.f.2
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                if (!this.eE) {
                    this.eE = true;
                    com.kwad.components.core.o.a.tz().a(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<a.c> it = f.this.mi.f7524ms.iterator();
                while (it.hasNext()) {
                    it.next().ap();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.cb(f.this.mAdTemplate);
                if (!f.this.mi.mm && f.this.mi.kP != null) {
                    f.this.mi.kP.onVideoPlayEnd();
                }
                Iterator<a.c> it = f.this.mi.f7524ms.iterator();
                while (it.hasNext()) {
                    it.next().aq();
                }
                f.this.mi.mu = true;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                f.this.c(j);
                Iterator<a.c> it = f.this.mi.f7524ms.iterator();
                while (it.hasNext()) {
                    it.next().d(j);
                }
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.interstitial.report.d.eV().b(f.this.mAdTemplate, i, String.valueOf(i2));
                if (f.this.mi.kP != null) {
                    f.this.mi.kP.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.ca(f.this.mAdTemplate);
                com.kwad.components.ad.interstitial.report.d.eV().b(f.this.mAdTemplate, System.currentTimeMillis() - jCurrentTimeMillis);
                com.kwad.components.ad.interstitial.report.b.eR().x(f.this.mAdTemplate);
                if (!f.this.mi.mm && f.this.mi.kP != null) {
                    f.this.mi.kP.onVideoPlayStart();
                }
                Iterator<a.c> it = f.this.mi.f7524ms.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                f.this.mi.mu = false;
            }
        });
        this.cq.setController(this.ni);
        this.fC.setClickable(true);
        new com.kwad.sdk.widget.h(this.fC.getContext(), this.fC, this);
        this.fC.addView(this.cq);
        this.mi.mq = new c.e() { // from class: com.kwad.components.ad.interstitial.f.f.3
            @Override // com.kwad.components.ad.interstitial.f.c.e
            public final void ed() {
                if (f.this.cq != null) {
                    f.this.cq.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        c cVar = this.mi;
        cVar.mk = true;
        cVar.c(1L, j);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) PC();
        this.mi = cVar;
        this.bU = cVar.bU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        this.mAdInfo = adInfoEr;
        List<Integer> listBq = com.kwad.sdk.core.response.b.a.bq(adInfoEr);
        this.ck = listBq;
        com.kwad.sdk.core.video.videoview.a aVar = this.mi.cq;
        this.cq = aVar;
        aVar.setTag(listBq);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cq);
        this.ni = fVar;
        fVar.setDataFlowAutoStart(this.bU.isDataFlowAutoStart());
        this.ni.setAdClickListener(this.hQ);
        this.ni.uZ();
        this.mApkDownloadHelper = this.mi.mApkDownloadHelper;
        ey();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fC.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nh = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fC = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fC.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mi.mq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mi.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.mi.a(c(view, false));
    }

    private c.C0488c c(View view, boolean z) {
        return new c.C0488c(view.getContext()).l(z).a(this.nh.getTouchCoords()).L(3).M(85);
    }
}
