package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.wifi.ad.core.p001const.WifiNestConst;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f5337a;
    protected Dialog b;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.nr fx;
    protected int iz;
    protected boolean jk;
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u l;
    private NativeVideoTsView mv;
    protected int n;
    protected bc nr;
    protected String pn;
    protected String t;
    protected Context u;
    protected int x;

    public BackupView(Context context) {
        super(context);
        this.pn = "embeded_ad";
        this.f5337a = true;
        this.jk = true;
        this.l = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
        u();
    }

    private boolean b() {
        return TextUtils.equals(this.pn, WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || TextUtils.equals(this.pn, "cache_splash_ad");
    }

    private boolean fx() {
        com.bykv.vk.openvk.component.video.api.fx.b bVarK;
        bc bcVar = this.nr;
        return (bcVar == null || bcVar.ju() == 1 || (bVarK = zx.k(this.nr)) == null || TextUtils.isEmpty(bVarK.l())) ? false : true;
    }

    private boolean nr() {
        if (b()) {
            return fx();
        }
        bc bcVar = this.nr;
        return bcVar != null && bc.nr(bcVar);
    }

    private void u() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public String getDescription() {
        return !TextUtils.isEmpty(this.nr.wf()) ? this.nr.wf() : !TextUtils.isEmpty(this.nr.ym()) ? this.nr.ym() : "";
    }

    public bc getMeta() {
        return this.nr;
    }

    public String getNameOrSource() {
        bc bcVar = this.nr;
        return bcVar == null ? "" : (bcVar.pu() == null || TextUtils.isEmpty(this.nr.pu().fx())) ? !TextUtils.isEmpty(this.nr.j()) ? this.nr.j() : "" : this.nr.pu().fx();
    }

    public float getRealHeight() {
        return y.b(this.u, this.x);
    }

    public float getRealWidth() {
        return y.b(this.u, this.iz);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        return (this.nr.pu() == null || TextUtils.isEmpty(this.nr.pu().fx())) ? !TextUtils.isEmpty(this.nr.j()) ? this.nr.j() : !TextUtils.isEmpty(this.nr.wf()) ? this.nr.wf() : "" : this.nr.pu().fx();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.nr.u getVideoModel() {
        return this.l;
    }

    public void pn() {
        Dialog dialog = this.b;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.fx;
        if (nrVar != null) {
            nrVar.u();
        } else {
            TTDelegateActivity.u(getContext(), this.nr);
        }
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.my.fx.nr.x xVar) {
        if (xVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.nr) {
            this.fx = (com.bytedance.sdk.openadsdk.core.dislike.ui.nr) xVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.b = dialog;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.u(this);
    }

    public abstract void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar);

    public void u(View view, boolean z) {
        final com.bytedance.sdk.openadsdk.core.nr.nr nrVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.u;
            bc bcVar = this.nr;
            String str = this.pn;
            nrVar = new com.bytedance.sdk.openadsdk.core.nr.u(context, bcVar, str, jp.nr(str));
        } else {
            Context context2 = this.u;
            bc bcVar2 = this.nr;
            String str2 = this.pn;
            nrVar = new com.bytedance.sdk.openadsdk.core.nr.nr(context2, bcVar2, str2, jp.nr(str2));
        }
        view.setOnTouchListener(nrVar);
        view.setOnClickListener(nrVar);
        fx fxVar = new fx() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.fx
            public void u(View view2, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
                try {
                    qVar.u().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).pn());
                } catch (JSONException unused) {
                }
                BackupView.this.u(view2, i, qVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.nr.u.nr.u uVar = (com.bytedance.sdk.openadsdk.core.nr.u.nr.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.nr.u.class);
        if (uVar != null) {
            uVar.u(fxVar);
            uVar.u(z ? 2 : 1);
        }
    }

    public void nr(int i) {
        this.jk = this.nr.jn() == 1;
        int iIz = com.bytedance.sdk.openadsdk.core.dw.nr().iz(i);
        if (3 == iIz) {
            this.f5337a = false;
            return;
        }
        if (1 != iIz || !com.bytedance.sdk.component.utils.o.b(this.u)) {
            if (2 == iIz) {
                if (com.bytedance.sdk.component.utils.o.pn(this.u) || com.bytedance.sdk.component.utils.o.b(this.u) || com.bytedance.sdk.component.utils.o.iz(this.u)) {
                    this.f5337a = true;
                    return;
                }
                return;
            }
            if (5 != iIz) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.o.b(this.u) && !com.bytedance.sdk.component.utils.o.iz(this.u)) {
                return;
            }
        }
        this.f5337a = true;
    }

    public View u(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.mv;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.nr != null && this.u != null) {
            if (nr()) {
                try {
                    NativeVideoTsView nativeVideoTsViewU = u(this.u, this.nr, this.pn, true, false);
                    this.mv = nativeVideoTsViewU;
                    nativeVideoTsViewU.setAdCreativeClickListener(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
                        public void u(View view, int i) {
                            u expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.u(view, i);
                        }
                    });
                    this.mv.setVideoCacheUrl(this.t);
                    this.mv.setControllerStatusCallBack(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                        public void u(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = BackupView.this.l;
                            uVar.u = z;
                            uVar.pn = j;
                            uVar.iz = j2;
                            uVar.x = j3;
                            uVar.b = z2;
                            uVar.n = z3;
                        }
                    });
                    this.mv.setIsAutoPlay(this.f5337a);
                    this.mv.setIsQuiet(this.jk);
                } catch (Throwable unused) {
                    this.mv = null;
                }
            }
            if (nr() && (nativeVideoTsView = this.mv) != null && nativeVideoTsView.u(0L, true, false)) {
                return this.mv;
            }
        }
        return null;
    }

    public NativeVideoTsView u(Context context, bc bcVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, bcVar, str, z, z2);
    }

    public void u(View view) {
        if (zx.k(this.nr) == null || view == null) {
            return;
        }
        u(view, this.nr.mk() == 1 && this.f5337a);
    }

    public void b_(int i) {
    }
}
