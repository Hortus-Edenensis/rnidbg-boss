package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bykv.vk.openvk.component.video.api.fx.b;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends fx<NativeVideoView> {
    private u fn;
    private bc gb;
    private boolean gl;
    private String hs;
    private String ki;
    private String te;
    private b ti;
    private boolean u;

    public nr(Context context) {
        super(context);
        this.gl = false;
    }

    private void p() {
        if (!this.u) {
            this.gb = new bc();
            this.ti = new b();
            return;
        }
        if (!TextUtils.isEmpty(this.te)) {
            try {
                this.gb = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(this.te));
                this.te = null;
            } catch (JSONException unused) {
            }
        }
        bc bcVar = this.gb;
        if (bcVar == null) {
            this.gb = new bc();
            this.ti = new b();
            return;
        }
        b bVarK = zx.k(bcVar);
        this.ti = bVarK;
        if (bVarK == null) {
            this.ti = new b();
        }
    }

    public void ay() {
        u((com.bytedance.sdk.openadsdk.core.multipro.nr.u) null);
    }

    public void eh() {
        T t = this.pn;
        if (t != 0) {
            ((NativeVideoView) t).n();
            if (this.u) {
                ((NativeVideoView) this.pn).u(true, false);
            } else {
                ((NativeVideoView) this.pn).u(this.hs);
            }
        }
    }

    public boolean gc() {
        com.bykv.vk.openvk.component.video.api.u uVarO;
        T t = this.pn;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (uVarO = ((NativeVideoView) this.pn).getNativeVideoController().o()) == null) {
            return false;
        }
        return uVarO.a();
    }

    public void lf() {
        T t = this.pn;
        if (t != 0) {
            ((NativeVideoView) t).pn();
            ((NativeVideoView) this.pn).u(this.hs);
        }
    }

    public void mk() {
        if (gc()) {
            T t = this.pn;
            if (t != 0) {
                ((NativeVideoView) t).bg();
                return;
            }
            return;
        }
        if (nb()) {
            eh();
        } else {
            v();
        }
    }

    public boolean n() {
        T t = this.pn;
        return (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) ? this.gl : ((NativeVideoView) this.pn).getNativeVideoController().bg();
    }

    public boolean nb() {
        com.bykv.vk.openvk.component.video.api.u uVarO;
        T t = this.pn;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (uVarO = ((NativeVideoView) this.pn).getNativeVideoController().o()) == null) {
            return false;
        }
        return uVarO.mv();
    }

    public void v() {
        T t = this.pn;
        if (t != 0) {
            ((NativeVideoView) t).O_();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public NativeVideoView u() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.nr);
        nativeVideoView.u(this);
        return nativeVideoView;
    }

    public void b(boolean z) {
        this.gl = z;
        T t = this.pn;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.pn).getNativeVideoController().nr(z);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        p();
        this.ti.fx(this.ki);
        this.ti.u(this.mv + "x" + this.s);
        this.ti.nr(this.hs);
        this.gb.u(this.ti);
        ((NativeVideoView) this.pn).setMaterialMeta(this.gb);
        ((NativeVideoView) this.pn).setIsAutoPlay(true);
        ((NativeVideoView) this.pn).setIsQuiet(this.gl);
        ((NativeVideoView) this.pn).setVisibility(0);
        ((NativeVideoView) this.pn).setEnableAutoCheck(false);
        ((NativeVideoView) this.pn).u(this.nr, 25, this.hs);
        ((NativeVideoView) this.pn).u(0L, true, false);
        ((NativeVideoView) this.pn).u(this.hs);
        com.bykv.vk.openvk.component.video.api.b.fx nativeVideoController = ((NativeVideoView) this.pn).getNativeVideoController();
        if (nativeVideoController != null) {
            u uVar = new u();
            this.fn = uVar;
            nativeVideoController.u(uVar);
        }
    }

    public void pn(boolean z) {
        T t = this.pn;
        if (t != 0) {
            ((NativeVideoView) t).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar) {
        bc bcVar;
        if (jk() != null && (bcVar = this.gb) != null) {
            if (bcVar.ol() == 0) {
                int iOptInt = jk().optInt("image_mode");
                this.gb.y(iOptInt);
                this.gb.u(new m(jk()));
                if (iOptInt == 166) {
                    this.gb.v(-2);
                    ((NativeVideoView) this.pn).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.pn).setPlayerType(0);
        }
        if (uVar != null) {
            com.bykv.vk.openvk.component.video.api.b.fx nativeVideoController = ((NativeVideoView) this.pn).getNativeVideoController();
            nativeVideoController.b(uVar.b);
            nativeVideoController.nr(uVar.n);
            if (uVar.u) {
                nativeVideoController.nr(0L);
            } else {
                nativeVideoController.nr(uVar.x);
            }
        }
        ((NativeVideoView) this.pn).b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements fx.u {
        fx.u u;

        private u() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
        public void nr(long j, int i) {
            fx.u uVar = this.u;
            if (uVar != null) {
                uVar.nr(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
        public void u(long j, int i) {
            if (nr.this.u) {
                if (((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn).setComplete(true);
                }
                if (((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn).u(true, true);
                }
            }
            fx.u uVar = this.u;
            if (uVar != null) {
                uVar.u(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
        public void u() {
            fx.u uVar = this.u;
            if (uVar != null) {
                uVar.u();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.b.fx.u
        public void u(long j, long j2) {
            fx.u uVar = this.u;
            if (uVar != null) {
                uVar.u(j, j2);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(JSONObject jSONObject) {
        super.u(jSONObject);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "coverSrc":
                this.hs = str2;
                break;
            case "src":
                this.ki = str2;
                break;
            case "isLp":
                try {
                    boolean zBooleanValue = Boolean.valueOf(str2).booleanValue();
                    this.u = zBooleanValue;
                    T t = this.pn;
                    if (t != 0) {
                        ((NativeVideoView) t).setLp(zBooleanValue);
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.te = str2;
                break;
        }
    }

    public void u(Map<String, Object> map) {
        T t = this.pn;
        if (t != 0) {
            ((NativeVideoView) t).setExtraMap(map);
        }
    }
}
