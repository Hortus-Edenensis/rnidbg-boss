package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements d {
    protected View EY;
    protected ImageView EZ;
    private com.kwad.components.ad.widget.tailframe.appbar.a Fa;
    private TailFrameBarH5View Fb;
    private b Fc;
    private TextProgressBar Fd;
    private View Fe;
    private int Ff;
    private TextView gD;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g tq;

    public a(int i) {
        this.Ff = i;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.aF(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.cp(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.aF(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.ad(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.dY(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Fa.D(a.this.mAdInfo);
                a.this.Fd.e(com.kwad.sdk.core.response.b.a.dX(i), i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(View view, final boolean z) {
        if (e.O(this.mAdTemplate)) {
            this.tq.a(1, this.EY.getContext(), z ? 1 : 153, view == this.Fe ? 1 : 2);
        } else {
            if (com.kwad.sdk.core.response.b.a.aG(this.mAdInfo)) {
            }
            com.kwad.components.core.e.d.a.a(new a.C0539a(view.getContext()).aE(this.mAdTemplate).b(this.mApkDownloadHelper).aC(i == 1 ? 1 : 0).aB(1).as(view == this.Fd).aD(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (a.this.Fc != null) {
                        a.this.Fc.P(z);
                    }
                }
            }));
        }
    }

    private void lC() {
        this.EY.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void lE() {
        if (!com.kwad.sdk.core.response.b.a.aG(this.mAdInfo) && !e.O(this.mAdTemplate)) {
            this.Fb.j(this.mAdTemplate);
            TextView h5OpenBtn = this.Fb.getH5OpenBtn();
            this.gD = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.Fb.setVisibility(0);
            new h(this.gD, this);
            return;
        }
        this.Fa.j(this.mAdTemplate);
        this.Fa.setVisibility(0);
        this.Fd = this.Fa.getTextProgressBar();
        if (!e.O(this.mAdTemplate)) {
            this.Fd.setClickable(true);
            new h(this.Fd, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.Fa.getBtnInstallContainer();
            this.Fe = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new h(this.Fe, this);
        }
    }

    public void B(Context context) {
        View viewA = m.a(context, this.Ff, null, false);
        this.EY = viewA;
        this.EZ = (ImageView) viewA.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.EY.findViewById(R.id.ksad_video_tf_logo);
        this.Fa = (com.kwad.components.ad.widget.tailframe.appbar.a) this.EY.findViewById(R.id.ksad_video_app_tail_frame);
        this.Fb = (TailFrameBarH5View) this.EY.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Fa;
        if (aVar != null) {
            aVar.lG();
            this.Fa.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.Fb;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lG();
            this.Fb.setVisibility(8);
        }
        lC();
    }

    public final void f(boolean z, boolean z2) {
        this.Fb.g(z, z2);
    }

    public final View lD() {
        return this.EY;
    }

    public final void ll() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Fa;
        if (aVar != null) {
            aVar.lG();
        }
        TailFrameBarH5View tailFrameBarH5View = this.Fb;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lG();
        }
    }

    public final void setCallerContext(g gVar) {
        this.tq = gVar;
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.er(adTemplate);
        this.mReportExtData = jSONObject;
        this.Fc = bVar;
        this.mLogoView.aS(this.mAdTemplate);
        lE();
        this.EY.setClickable(true);
        new h(this.EY, this);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eg(this.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }
}
