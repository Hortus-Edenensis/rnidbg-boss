package com.opos.mobad.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.d.a;
import com.opos.mobad.downloader.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.ui.a.d;
import com.opos.mobad.ui.a.h;
import com.opos.mobad.ui.a.k;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdItemData f8473a;
    protected a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Bitmap bitmap, String str);
    }

    public c(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, true);
        this.b = new a() { // from class: com.opos.mobad.activity.c.1
            @Override // com.opos.mobad.activity.c.a
            public void a(final Bitmap bitmap, final String str) {
                if (((com.opos.mobad.ui.a.a) c.this).m == null || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                ((com.opos.mobad.ui.a.a) c.this).H.post(new Runnable() { // from class: com.opos.mobad.activity.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((com.opos.mobad.ui.a.a) c.this).m == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(((com.opos.mobad.ui.a.a) c.this).m.getTag())) {
                            return;
                        }
                        ((com.opos.mobad.ui.a.a) c.this).m.setImageBitmap(bitmap);
                    }
                });
            }
        };
    }

    public void b() {
        this.v = null;
    }

    @Override // com.opos.mobad.ui.a.a
    public void a() {
        l();
    }

    @Override // com.opos.mobad.ui.a.e
    public void b(View view, int[] iArr) {
        if (k.a() != null) {
            aa();
            k kVarA = k.a();
            Context context = this.c;
            String str = this.B;
            AdItemData adItemData = this.f8473a;
            kVarA.a(context, str, adItemData != null ? adItemData.W() : com.opos.mobad.mediaplayer.b.d.c(), this.o, this, this.F);
        }
    }

    @Override // com.opos.mobad.ui.a.e
    public void a(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onErrorRetryClick " + k.a().c(this.B));
        if (com.opos.cmn.an.h.c.a.d(this.c)) {
            aa();
            if (k.a().c(this.B) == -1) {
                k kVarA = k.a();
                Context context = this.c;
                String str = this.B;
                AdItemData adItemData = this.f8473a;
                kVarA.c(context, str, adItemData != null ? adItemData.W() : com.opos.mobad.mediaplayer.b.d.c(), this.o, this, this.F);
                return;
            }
            k kVarA2 = k.a();
            Context context2 = this.c;
            String str2 = this.B;
            AdItemData adItemData2 = this.f8473a;
            kVarA2.a(context2, str2, adItemData2 != null ? adItemData2.W() : com.opos.mobad.mediaplayer.b.d.c(), this.o, this, this.F);
        }
    }

    @Override // com.opos.mobad.ui.a.a
    public void a(View view, int[] iArr, int i) {
        if (i != 1 && i != 2) {
            if (i == 3 && k.a().c(this.B) == 2) {
                U();
                k.a().b(this.B);
                return;
            }
            return;
        }
        if (k.a().c(this.B) == -1 || k.a().c(this.B) == 0 || k.a().c(this.B) == 5) {
            N();
            k kVarA = k.a();
            Context context = this.c;
            String str = this.B;
            AdItemData adItemData = this.f8473a;
            kVarA.a(context, str, adItemData != null ? adItemData.W() : com.opos.mobad.mediaplayer.b.d.c(), this.o, this, this.F);
        } else {
            k.a().a(this.B, this.o);
        }
        V();
    }

    public void a(AdItemData adItemData, String str) {
        if (adItemData != null) {
            this.f8473a = adItemData;
            this.B = str;
            if (this.E != null) {
                b(!adItemData.J());
            }
            com.opos.cmn.an.f.a.b("MediaCreative", "mAdItemData:" + this.f8473a);
            MaterialData materialData = adItemData.i().get(0);
            if (materialData != null) {
                List<MaterialFileData> listE = materialData.e();
                if (listE != null && listE.size() > 0 && listE.get(0) != null) {
                    String strA = listE.get(0).a();
                    if (!TextUtils.isEmpty(strA) && (!strA.equals(this.m.getTag()) || this.n == null)) {
                        a(strA);
                    }
                }
                a(this.o, 4);
                if (!com.opos.cmn.an.h.c.a.d(this.c)) {
                    ah();
                    if (this.v != null) {
                        HashMap map = new HashMap();
                        map.put("errCode", String.valueOf(10403));
                        map.put(WifiNestConst.OtherConst.KEY_MSG, "no net,can't play video.");
                        this.v.a(map);
                        return;
                    }
                    return;
                }
                if (!com.opos.cmn.an.h.c.a.e(this.c) && !materialData.U()) {
                    Z();
                    return;
                }
                Y();
                k kVarA = k.a();
                Context context = this.c;
                AdItemData adItemData2 = this.f8473a;
                kVarA.b(context, str, adItemData2 != null ? adItemData2.W() : com.opos.mobad.mediaplayer.b.d.c(), this.o, this, this.F);
            }
        }
    }

    @Override // com.opos.mobad.ui.a.h
    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.m.setTag(str);
        f.a().a(str, (String) null, com.opos.cmn.an.h.f.a.b(this.c), (com.opos.cmn.an.h.f.a.b(this.c) * 9) / 16, new a.InterfaceC0732a() { // from class: com.opos.mobad.activity.c.2
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, Bitmap bitmap) {
                ((com.opos.mobad.ui.a.a) c.this).n = bitmap;
                if (((com.opos.mobad.ui.a.a) c.this).n != null) {
                    c cVar = c.this;
                    cVar.b.a(((com.opos.mobad.ui.a.a) cVar).n, str);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000f A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0002, B:5:0x000a, B:6:0x000f), top: B:12:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        if (z) {
            try {
                if (com.opos.cmn.an.h.b.a.b(this.c) == 0) {
                    c(false);
                } else {
                    c(true);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MediaCreative", "", (Throwable) e);
            }
        }
    }
}
