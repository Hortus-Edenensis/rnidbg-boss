package com.bytedance.sdk.openadsdk.core.component.fx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.bq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.openadsdk.my.fx.u implements LazeLayout.u<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.u<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LazeLayout f5218a;
    private com.bytedance.sdk.openadsdk.dw.u.nr.u.u b;
    private int fx;
    private final Context iz;
    private volatile WeakReference<NativeVideoTsView> jk;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u l;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr n;
    private Bitmap nr;
    private b pn;
    private UpieImageView t;
    private boolean u;
    private final bc x;

    public fx(Context context, bc bcVar, int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(new b(context, bcVar, i, nrVar));
        this.f5218a = null;
        this.jk = null;
        this.l = new com.bytedance.sdk.openadsdk.qq.u.nr.u.u(null) { // from class: com.bytedance.sdk.openadsdk.core.component.fx.fx.3
            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void nr(View view, mv mvVar) {
                NativeVideoTsView nativeVideoTsViewIz = fx.this.pn.iz();
                if (nativeVideoTsViewIz != null) {
                    nativeVideoTsViewIz.t();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void u(View view, mv mvVar) {
                NativeVideoTsView nativeVideoTsViewIz = fx.this.pn.iz();
                if (nativeVideoTsViewIz != null) {
                    nativeVideoTsViewIz.t();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.qq.u.nr.u.u
            public void u(mv mvVar) {
                NativeVideoTsView nativeVideoTsViewIz = fx.this.pn.iz();
                if (nativeVideoTsViewIz != null) {
                    nativeVideoTsViewIz.bq();
                }
            }
        };
        this.n = nrVar;
        b bVar = (b) b();
        this.pn = bVar;
        this.x = bcVar;
        this.iz = context;
        ((com.bytedance.sdk.openadsdk.core.z.fx) bVar.dw()).u(this.l);
        if (context == null || this.pn.n_() || !com.bytedance.sdk.openadsdk.pn.u.n(bcVar)) {
            return;
        }
        this.t = new UpieImageView(context, com.bytedance.sdk.openadsdk.pn.u.a(bcVar), null);
    }

    private void dw() {
        int i = this.fx;
        if (i >= 200) {
            this.fx = 200;
        } else if (i <= 20) {
            this.fx = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.u, com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void fx() {
        NativeVideoTsView nativeVideoTsView;
        super.fx();
        if (this.jk != null && (nativeVideoTsView = this.jk.get()) != null) {
            nativeVideoTsView.bq();
        }
        LazeLayout lazeLayout = this.f5218a;
        if (lazeLayout != null) {
            lazeLayout.u();
        }
        UpieImageView upieImageView = this.t;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b nr() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.u, com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public View u() {
        NativeVideoTsView nativeVideoTsViewNr = null;
        if (this.x == null || this.iz == null) {
            return null;
        }
        if (this.pn.n_()) {
            if (x.u()) {
                this.f5218a = new LazeLayout(this.iz, this, this);
            } else {
                try {
                    nativeVideoTsViewNr = nr(this.iz);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewNr != null) {
                    u(nativeVideoTsViewNr);
                }
                return nativeVideoTsViewNr;
            }
        } else if (this.t != null) {
            com.bytedance.sdk.openadsdk.core.z.fx fxVar = (com.bytedance.sdk.openadsdk.core.z.fx) this.pn.dw();
            if (fxVar != null && fxVar.qq() != null) {
                fxVar.qq().u(this.t);
            }
            return this.t;
        }
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.x).u(this.pn.l_()).nr(this.pn.n());
        return this.f5218a;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.u
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView nr(Context context) {
        NativeVideoTsView nativeVideoTsViewU = this.pn.u(true);
        nativeVideoTsViewU.setControllerStatusCallBack(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.fx.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
            public void u(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                fx.this.pn.u.u = z;
                fx.this.pn.u.pn = j;
                fx.this.pn.u.iz = j2;
                fx.this.pn.u.x = j3;
                fx.this.pn.u.b = z2;
                fx.this.pn.u.n = z3;
            }
        });
        nativeVideoTsViewU.setAdCreativeClickListener(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.fx.fx.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
            public void u(View view, int i) {
                bq bqVarQq = ((com.bytedance.sdk.openadsdk.core.z.fx) fx.this.pn.dw()).qq();
                if (bqVarQq != null) {
                    bqVarQq.u(view, i);
                }
            }
        });
        nativeVideoTsViewU.setVideoAdLoadListener(this.pn);
        nativeVideoTsViewU.setVideoAdInteractionListener(this.pn);
        nativeVideoTsViewU.setIsAutoPlay(u(jp.t(this.x)));
        nativeVideoTsViewU.setIsQuiet(this.x.jn() == 1);
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewU;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.u);
        Bitmap bitmap = this.nr;
        if (bitmap != null) {
            nativeDrawVideoTsView.u(bitmap, this.fx);
        }
        nativeVideoTsViewU.setDrawVideoListener(this.b);
        this.jk = new WeakReference<>(nativeVideoTsViewU);
        return nativeVideoTsViewU;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.u
    public void u(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.u(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.u uVar2) {
        View viewU;
        try {
            u(viewGroup, (List<View>) null, list, list2, list3, (View) null, uVar);
            if (uVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(uVar2.nr());
                if (viewFindViewById != null && x() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(x());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = y.fx(viewGroup.getContext(), 38.0f);
                        layoutParams.height = y.fx(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(x());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uVar2.u());
                if (frameLayout == null || (viewU = u()) == null) {
                    return;
                }
                y.n(viewU);
                frameLayout.removeAllViews();
                frameLayout.addView(viewU, -1, -1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        b bVar = this.pn;
        if (bVar != null) {
            bVar.u(nrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.a
    public void u(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.a
    public void u(Bitmap bitmap, int i) {
        this.nr = bitmap;
        this.fx = i;
        dw();
    }

    private boolean u(int i) {
        int iIz = dw.nr().iz(i);
        if (3 == iIz) {
            return false;
        }
        if (1 != iIz || !o.b(this.iz)) {
            if (2 == iIz) {
                if (!o.pn(this.iz) && !o.b(this.iz)) {
                    o.iz(this.iz);
                }
            } else if (5 == iIz && !o.b(this.iz)) {
                o.iz(this.iz);
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.a
    public void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        this.b = uVar;
    }
}
