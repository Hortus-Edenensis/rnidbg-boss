package com.beizi.ad.v2.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.ad.internal.e.s;
import com.beizi.ad.internal.f;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.beizi.ad.v2.a.b {
    public static b G;
    private com.beizi.ad.a H;

    public b(Context context) {
        super(context, f.INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        String strW;
        String strX;
        boolean zY;
        try {
            com.beizi.ad.internal.d.a aVar = this.c;
            if (aVar != null) {
                zY = aVar.y();
                strW = this.c.w();
                strX = this.c.x();
            } else {
                strW = null;
                strX = null;
                zY = false;
            }
            if (zY) {
                if (!TextUtils.isEmpty(strX)) {
                    s.a().a(this.f4518a, strX, false, new s.a() { // from class: com.beizi.ad.v2.c.b.1
                        @Override // com.beizi.ad.internal.e.s.a
                        public void a(String str) {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            if (b.this.H != null) {
                                ((com.beizi.ad.v2.a.b) b.this).g = true;
                                Log.e("BeiZisAd", "enter BeiZi ad load");
                                b.this.H.a();
                            }
                        }

                        @Override // com.beizi.ad.internal.e.s.a
                        public void a() {
                            if (b.this.H != null) {
                                b.this.H.a(6);
                            }
                        }
                    });
                    return;
                }
                com.beizi.ad.a aVar2 = this.H;
                if (aVar2 != null) {
                    aVar2.a(3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(strW)) {
                com.beizi.ad.a aVar3 = this.H;
                if (aVar3 != null) {
                    aVar3.a(3);
                    return;
                }
                return;
            }
            if (this.H != null) {
                this.g = true;
                Log.e("BeiZisAd", "enter BeiZi ad load");
                this.H.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f(String str) {
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void q() {
        super.q();
        G = null;
    }

    public void u() {
        if (this.t) {
            this.u = true;
            com.beizi.ad.internal.a.a.a().a(this.r);
        }
        if (this.H != null) {
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.H.b();
        }
    }

    public void v() {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar != null) {
            aVar.d(false);
        }
        com.beizi.ad.a aVar2 = this.H;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void w() {
        com.beizi.ad.a aVar = this.H;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i) {
        if (this.H == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.c.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.H.a(i);
                }
            });
        }
    }

    public void a(com.beizi.ad.a aVar) {
        this.H = aVar;
    }

    public void a(Context context) {
        m.c("BeiZisAd", "showInterstitial");
        G = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewInterstitialActivity.class));
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(com.beizi.ad.internal.d.a aVar) {
        b(aVar.b());
        c(aVar.c());
        a(aVar.A());
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.c.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.x();
                }
            });
        }
    }
}
