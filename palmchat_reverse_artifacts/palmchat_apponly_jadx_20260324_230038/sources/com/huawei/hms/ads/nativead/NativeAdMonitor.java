package com.huawei.hms.ads.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.ce;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fu;
import com.huawei.hms.ads.fv;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.ln;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public final class NativeAdMonitor implements View.OnAttachStateChangeListener, fu {
    private static final String Code = "NativeAdMonitor";
    private static WeakHashMap<View, NativeAdMonitor> V = new WeakHashMap<>();
    private View B;
    private cd C;
    private ln D;
    private lm F;
    private List<View> I;
    private l L;
    private fv S;
    private List<View> Z;
    private PPSNativeView.b f;
    private PPSNativeView.e g;
    private DislikeAdListener h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6601a = true;
    private boolean b = false;
    private final String c = x.ao + hashCode();
    private final String d = x.ap + hashCode();
    private boolean e = false;
    private View.OnClickListener i = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NativeAdMonitor.this.f6601a) {
                NativeAdMonitor.this.f6601a = false;
                fh.V(NativeAdMonitor.Code, "onClick");
                NativeAdMonitor.this.e = true;
                if (NativeAdMonitor.this.f != null) {
                    NativeAdMonitor.this.f.Code(view);
                }
                NativeAdMonitor.this.C.V();
                NativeAdMonitor.this.Code((Integer) 1, true);
                bj.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeAdMonitor.this.f6601a = true;
                    }
                }, 500L);
            }
        }
    };
    private View.OnClickListener j = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @GlobalApi
    public NativeAdMonitor(View view, Map<String, View> map, Map<String, View> map2) {
        String str;
        String str2;
        this.I = new ArrayList();
        this.Z = new ArrayList();
        if (view instanceof NativeView) {
            str = Code;
            str2 = "containerView can't be an instance of NativeView class or NativeView subclass";
        } else if (view == null) {
            str = Code;
            str2 = "containerView can't be null";
        } else {
            if (V.get(view) == null) {
                V.put(view, this);
                this.B = view;
                this.C = new ce(this.B.getContext(), this.B);
                this.S = new fv(view, this);
                this.B.addOnAttachStateChangeListener(this);
                if (map != null) {
                    this.I = new ArrayList(map.values());
                }
                if (map2 != null) {
                    this.Z = new ArrayList(map2.values());
                    return;
                }
                return;
            }
            str = Code;
            str2 = "containerView has been existed in other NativeAdMonitor object.";
        }
        fh.I(str, str2);
    }

    private MediaView Code(View view) {
        LinkedList linkedList = new LinkedList();
        if (view instanceof ViewGroup) {
            linkedList.add(view);
        }
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof MediaView) {
                return (MediaView) view2;
            }
            if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i < viewGroup.getChildCount()) {
                        linkedList.offer(viewGroup.getChildAt(i));
                        i++;
                    }
                }
            }
        }
        return null;
    }

    private void D() {
        if (ag.Code(this.Z)) {
            return;
        }
        for (View view : this.Z) {
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    private void F() {
        if (ag.Code(this.I)) {
            return;
        }
        for (View view : this.I) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
    }

    private void S() {
        l lVar;
        if (!Code() || (lVar = this.L) == null || lVar.al()) {
            return;
        }
        fh.V(Code, " maybe report show start.");
        I();
    }

    public void Z() {
        fh.V(Code, "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.fu
    public void a_() {
        l lVar = this.L;
        if (lVar != null) {
            bj.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    l lVar2 = NativeAdMonitor.this.L;
                    if (lVar2 != null) {
                        NativeAdMonitor.this.Code(Long.valueOf(lVar2.x()), Integer.valueOf(NativeAdMonitor.this.S.I()), null, false);
                    }
                }
            }, this.c, lVar.x());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        fv fvVar = this.S;
        if (fvVar != null) {
            fvVar.D();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        fh.V(Code, "onDetachedFromWindow");
        fv fvVar = this.S;
        if (fvVar != null) {
            fvVar.L();
        }
    }

    @GlobalApi
    public void setNativeAd(NativeAd nativeAd) {
        bj.Code(this.d);
        bj.Code(this.c);
        if (nativeAd == null) {
            fh.V(Code, "nativeAd is null, can't set the nativeAd now.");
            return;
        }
        if (nativeAd instanceof cb) {
            ((cb) nativeAd).Code(this);
        }
        Code(nativeAd);
    }

    @GlobalApi
    public void unregister() {
        bj.Code(this.d);
        bj.Code(this.c);
        l lVar = this.L;
        if (lVar != null) {
            lVar.Z(false);
        }
        View view = this.B;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.L = null;
        this.S.V();
        this.C.Code((l) null);
        this.h = null;
        F();
        D();
        lm lmVar = this.F;
        if (lmVar != null) {
            lmVar.setNativeAd(null);
        }
        this.F = null;
    }

    private void C() {
        l lVar = this.L;
        if (this.B == null || lVar == null) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar2 = NativeAdMonitor.this.L;
                if (NativeAdMonitor.this.B == null || lVar2 == null) {
                    return;
                }
                NativeAdMonitor.this.S.a();
            }
        }, this.d, lVar.x() / 2);
    }

    @Override // com.huawei.hms.ads.fu
    public void I() {
        PPSNativeView.e eVar;
        this.b = false;
        String strValueOf = String.valueOf(z.Code());
        l lVar = this.L;
        if (lVar == null) {
            fh.V(Code, "nativeAd is null, please register first");
            return;
        }
        lVar.I(false);
        this.L.C(false);
        this.L.Z(true);
        if (this.e && (eVar = this.g) != null) {
            this.e = false;
            eVar.Z();
        }
        if (!this.L.aj()) {
            this.L.V(true);
        }
        this.C.Code(strValueOf);
        lm lmVar = this.F;
        if (lmVar != null) {
            lmVar.Code(strValueOf);
        }
        this.C.Code();
    }

    @Override // com.huawei.hms.ads.fu
    public void V(long j, int i) {
        bj.Code(this.c);
        l lVar = this.L;
        if (lVar != null) {
            lVar.Z(false);
        }
        this.C.Code(j, i);
    }

    private void I(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View previewImageView : list) {
            if (previewImageView instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) previewImageView).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.j);
                    previewImageView = videoView.getPreviewImageView();
                    previewImageView.setOnClickListener(null);
                }
            } else if (previewImageView != null) {
                previewImageView.setClickable(false);
                previewImageView.setOnClickListener(null);
            }
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View previewImageView : list) {
            if (previewImageView instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) previewImageView).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.i);
                    previewImageView = videoView.getPreviewImageView();
                    previewImageView.setOnClickListener(this.i);
                }
            } else if (previewImageView != null) {
                previewImageView.setOnClickListener(this.i);
            }
        }
    }

    @Override // com.huawei.hms.ads.fu
    public void Code(long j, int i) {
        bj.Code(this.c);
        if (!this.S.Code(j) || this.b) {
            return;
        }
        this.b = true;
        Code(Long.valueOf(j), Integer.valueOf(i), null, false);
    }

    public void Code(DislikeAdListener dislikeAdListener) {
        this.h = dislikeAdListener;
    }

    private void Code(NativeAd nativeAd) {
        View view = this.B;
        if (view == null || V.get(view) == null) {
            fh.V(Code, "container view is null, please add a container view first.");
            return;
        }
        if (nativeAd instanceof cb) {
            l lVarCode = ((cb) nativeAd).Code();
            if (lVarCode instanceof l) {
                this.L = lVarCode;
                this.S.V(lVarCode.x(), this.L.y());
                this.C.Code(this.L);
                this.B.setOnClickListener(this.i);
                MediaView mediaViewCode = Code(this.B);
                if (mediaViewCode != null) {
                    b mediaViewAdapter = mediaViewCode.getMediaViewAdapter();
                    mediaViewAdapter.Code(nativeAd);
                    VideoOperator videoOperator = nativeAd.getVideoOperator();
                    if (videoOperator instanceof c) {
                        ((c) videoOperator).Code(mediaViewCode);
                    }
                    View viewB = mediaViewAdapter.B();
                    if (viewB instanceof NativeVideoView) {
                        NativeVideoView nativeVideoView = (NativeVideoView) viewB;
                        this.F = nativeVideoView;
                        nativeVideoView.setCoverClickListener(this.j);
                        this.F.setNativeAd(lVarCode);
                    }
                    if (viewB instanceof NativeWindowImageView) {
                        NativeWindowImageView nativeWindowImageView = (NativeWindowImageView) viewB;
                        this.D = nativeWindowImageView;
                        nativeWindowImageView.setNativeAd(lVarCode);
                        this.D.setDisplayView(this.B);
                    }
                }
                V(this.I);
                I(this.Z);
            }
        }
        S();
        C();
    }

    public void Code(PPSNativeView.b bVar) {
        this.f = bVar;
    }

    public void Code(PPSNativeView.e eVar) {
        this.g = eVar;
        this.C.Code(eVar);
    }

    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.S.Z()), Integer.valueOf(this.S.I()), num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        l lVar = this.L;
        if (lVar == null) {
            return;
        }
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(lVar.h_(), num2);
        if (!this.L.ak() || (zCode && !this.L.ab())) {
            this.C.Code(l, num, num2, z);
            if (zCode) {
                this.L.C(true);
            }
            if (this.L.ak()) {
                return;
            }
            this.L.I(true);
            PPSNativeView.e eVar = this.g;
            if (eVar != null) {
                eVar.B();
            }
        }
    }

    public void Code(List<String> list) {
        fh.V(Code, "onClose keyWords");
        this.C.Code(list);
        Code((Integer) 3, false);
        lm lmVar = this.F;
        if (lmVar != null) {
            lmVar.S();
        }
        DislikeAdListener dislikeAdListener = this.h;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        unregister();
    }

    public boolean Code() {
        fv fvVar = this.S;
        if (fvVar != null) {
            return fvVar.d();
        }
        return false;
    }
}
