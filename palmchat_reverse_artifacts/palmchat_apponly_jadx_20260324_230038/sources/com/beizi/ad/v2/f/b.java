package com.beizi.ad.v2.f;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.ad.f;
import com.beizi.ad.internal.e.s;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.beizi.ad.v2.a.b {
    public static b G;
    private f H;
    private boolean I;
    private String J;

    public b(Context context) {
        super(context, com.beizi.ad.internal.f.REWARDEDVIDEO);
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String strI;
        String strX;
        boolean zY;
        try {
            com.beizi.ad.internal.d.a aVar = this.c;
            if (aVar != null) {
                zY = aVar.y();
                strI = this.c.I();
                strX = this.c.x();
            } else {
                strI = null;
                strX = null;
                zY = false;
            }
            if (zY) {
                if (TextUtils.isEmpty(strX)) {
                    f fVar = this.H;
                    if (fVar != null) {
                        fVar.a(3);
                        return;
                    }
                    return;
                }
                if (this.H != null) {
                    Log.e("BeiZisAd", "enter BeiZi ad load");
                    this.g = true;
                    this.H.a();
                }
                s.a().a(this.f4518a, strX, false, new s.a() { // from class: com.beizi.ad.v2.f.b.1
                    @Override // com.beizi.ad.internal.e.s.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.e.s.a
                    public void a(String str) {
                        m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                        b.this.J = str;
                        if (b.this.H != null) {
                            b.this.I = true;
                            b.this.H.b();
                        }
                    }
                });
                return;
            }
            if (TextUtils.isEmpty(strI)) {
                f fVar2 = this.H;
                if (fVar2 != null) {
                    fVar2.a(3);
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

    public void A() {
        f fVar = this.H;
        if (fVar != null) {
            fVar.g();
        }
    }

    public void f(String str) {
        f fVar = this.H;
        if (fVar != null) {
            fVar.a(str);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void q() {
        super.q();
        G = null;
    }

    public boolean u() {
        return this.I;
    }

    public String v() {
        return this.J;
    }

    public void w() {
        if (this.t) {
            this.u = true;
            com.beizi.ad.internal.a.a.a().a(this.r);
        }
        if (this.H != null) {
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.H.c();
        }
    }

    public void x() {
        com.beizi.ad.internal.d.a aVar = this.c;
        if (aVar != null) {
            aVar.d(false);
        }
        f fVar = this.H;
        if (fVar != null) {
            fVar.d();
        }
    }

    public void y() {
        f fVar = this.H;
        if (fVar != null) {
            fVar.e();
        }
    }

    public void z() {
        f fVar = this.H;
        if (fVar != null) {
            fVar.f();
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
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.H.a(i);
                }
            });
        }
    }

    public void a(f fVar) {
        this.H = fVar;
    }

    public void a(Context context) {
        m.c("BeiZisAd", "showRewardVideo");
        G = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewRewardVideoActivity.class));
    }

    public void a(String str, int i) {
        f fVar = this.H;
        if (fVar != null) {
            fVar.a((Map<String, Object>) null);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(com.beizi.ad.internal.d.a aVar) {
        if (aVar == null) {
            f fVar = this.H;
            if (fVar != null) {
                fVar.a(3);
                return;
            }
            return;
        }
        b(aVar.b());
        c(aVar.c());
        a(aVar.A());
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.f.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.B();
                }
            });
        }
    }
}
