package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huawei.openalliance.ad.inter.HiAd;
import com.igexin.sdk.PushConsts;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class fy implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final String Code = "ViewMonitor";
    private static final Map<View, fy> V = new ConcurrentHashMap();
    private long C;
    private int S;
    private View Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f6565a;
    private String I = Code;
    private boolean B = false;
    private Rect F = new Rect();
    private boolean D = true;
    private BroadcastReceiver L = new BroadcastReceiver() { // from class: com.huawei.hms.ads.fy.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            fh.V(fy.this.I, "receive screen state: %s", action);
            if (TextUtils.equals("android.intent.action.SCREEN_ON", action) || TextUtils.equals("android.intent.action.SCREEN_OFF", action) || TextUtils.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT, action)) {
                fy.this.Z();
                fy.this.C();
            }
        }
    };

    public fy(View view) {
        this.Z = view;
        V();
    }

    private void B() {
        fh.V(this.I, "unregisterObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        this.Z.setOnSystemUiVisibilityChangeListener(null);
        if (this.f6565a != null) {
            HiAd.Code(this.Z.getContext()).Code(this.f6565a);
            this.f6565a = null;
        }
        V.remove(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C() {
        boolean z = false;
        boolean z2 = this.D && this.Z.isShown() && this.Z.getLocalVisibleRect(this.F);
        int width = this.Z.getWidth() * this.Z.getHeight();
        if (!z2 || width <= 0) {
            z = z2;
        } else {
            int iWidth = ((this.F.width() * this.F.height()) * 100) / width;
            if (iWidth > this.S) {
                this.S = iWidth;
            }
            Code(iWidth);
            if (iWidth > 0) {
            }
        }
        if (z) {
            b();
        } else {
            c();
        }
    }

    private void I() {
        fh.V(this.I, "registerObservers");
        View view = this.Z;
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Map<View, fy> map = V;
        fy fyVar = map.get(this.Z);
        if (fyVar != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(fyVar);
            viewTreeObserver.removeOnGlobalLayoutListener(fyVar);
        }
        map.put(this.Z, this);
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        this.f6565a = this.L;
        HiAd.Code(this.Z.getContext()).Code(this.f6565a, intentFilter);
        this.D = true;
    }

    private void V() {
        if (this.Z != null) {
            this.I = this.Z.getClass().getSimpleName() + Code;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Context context = this.Z.getContext();
        this.D = com.huawei.openalliance.ad.utils.bg.Code(context) && !com.huawei.openalliance.ad.utils.bg.V(context);
        if (fh.Code()) {
            fh.Code(this.I, "checkScreenState screen available: %s ", Boolean.valueOf(this.D));
        }
    }

    public void D() {
        fh.V(this.I, "onViewAttachedToWindow");
        I();
        C();
    }

    public void L() {
        if (fh.Code()) {
            fh.Code(this.I, "onViewDetachedFromWindow");
        }
        B();
        c();
    }

    public void a() {
        fh.V(this.I, "onViewVisibilityChanged");
        C();
    }

    public void b() {
        if (this.B) {
            return;
        }
        fh.V(this.I, "onViewShown");
        this.B = true;
        this.C = System.currentTimeMillis();
        Code();
    }

    public void c() {
        if (this.B) {
            fh.V(this.I, "onViewHidden");
            this.B = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.C;
            if (fh.Code()) {
                fh.Code(this.I, "max physical visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(jCurrentTimeMillis));
            }
            Code(jCurrentTimeMillis, this.S);
            this.S = 0;
        }
    }

    public boolean d() {
        return this.B && this.Z.isShown();
    }

    public int e() {
        boolean z = this.D && this.Z.isShown() && this.Z.getLocalVisibleRect(this.F);
        int width = this.Z.getWidth() * this.Z.getHeight();
        if (!z || width <= 0) {
            return 0;
        }
        return ((this.F.width() * this.F.height()) * 100) / width;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (fh.Code()) {
            fh.Code(this.I, "onGlobalLayout");
        }
        C();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        if (fh.Code()) {
            fh.Code(this.I, "onScrollChanged");
        }
        C();
    }

    public void Code() {
    }

    public void Code(int i) {
    }

    public void Code(long j, int i) {
    }
}
