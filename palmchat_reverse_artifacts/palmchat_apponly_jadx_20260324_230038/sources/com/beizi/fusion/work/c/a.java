package com.beizi.fusion.work.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import com.beizi.fusion.tool.ap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.fusion.work.a {
    protected Context n;
    protected long o;
    protected float p;
    protected float q;
    protected NativeUnifiedAdResponse r;
    protected FrameLayout s;
    protected boolean t = false;
    protected boolean u = false;

    public a(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i) {
        this.n = context;
        this.o = j;
        this.e = buyerBean;
        this.d = dVar;
        this.k = i;
        this.f = forwardBean;
        this.p = ap.k(context);
        this.q = ap.l(context);
        r();
    }

    private void aN() {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        Log.d("BeiZis", f() + " NativeUnifiedWorker:" + dVar.q().toString());
        Z();
        e eVar = this.g;
        if (eVar == e.SUCCESS) {
            aO();
            this.d.a(f(), (View) null);
        } else if (eVar == e.FAIL) {
            Log.d("BeiZis", "other worker shown," + f() + " remove");
        }
    }

    private void aO() {
        this.r = new NativeUnifiedAdResponse() { // from class: com.beizi.fusion.work.c.a.1
            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getActionText() {
                return a.this.aF();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getAdLogoUrl() {
                return a.this.aK();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getDescription() {
                return a.this.aA();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public UnifiedAdDownloadAppInfo getDownloadAppInfo() {
                return a.this.aL();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getECPM() {
                String strI = a.this.i();
                if (strI == null) {
                    return -1;
                }
                try {
                    return Integer.parseInt(strI);
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1;
                }
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getIconUrl() {
                return a.this.aB();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getImageUrl() {
                return a.this.aC();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public List<String> getImgList() {
                return a.this.aD();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getMaterialType() {
                return a.this.aE();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getTitle() {
                return a.this.az();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public View getVideoView() {
                return a.this.aI();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public ViewGroup getViewContainer() {
                return a.this.aH();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public boolean isVideo() {
                return a.this.aG();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerDownloadAppInfoClickEvent(View view) {
                a.this.a(view);
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerViewForInteraction(List<View> list) {
                a.this.a(list);
            }
        };
    }

    public void a(View view) {
    }

    public String aA() {
        return null;
    }

    public String aB() {
        return null;
    }

    public String aC() {
        return null;
    }

    public List<String> aD() {
        return null;
    }

    public int aE() {
        return 0;
    }

    public String aF() {
        return null;
    }

    public boolean aG() {
        return false;
    }

    public ViewGroup aH() {
        return null;
    }

    public View aI() {
        return null;
    }

    public String aK() {
        return null;
    }

    public UnifiedAdDownloadAppInfo aL() {
        return null;
    }

    public void aM() {
        try {
            if (Y()) {
                aN();
            } else {
                P();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public NativeUnifiedAdResponse as() {
        return this.r;
    }

    public String az() {
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        com.beizi.fusion.events.b bVar = this.f4818a;
        if (bVar != null) {
            EventBean eventBeanA = bVar.a().a(this.c);
            this.b = eventBeanA;
            if (eventBeanA != null) {
                s();
                b();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.e;
    }

    @Override // com.beizi.fusion.work.a
    public void k() {
        v();
        ab();
        ay();
    }

    public void a(List<View> list) {
    }

    public void aJ() {
    }

    public void ay() {
    }

    public void b() {
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }
}
