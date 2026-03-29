package com.beizi.ad.v2.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.ad.model.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.ad.v2.a.a {
    public a(Context context, ViewGroup viewGroup, View view, String str) {
        viewGroup.setPadding(0, 0, 0, 0);
        this.f4517a = new b(context, viewGroup, view, str);
    }

    public void a(int i, int i2, int i3, int i4) {
    }

    public void b(View.OnTouchListener onTouchListener) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).b(onTouchListener);
        }
    }

    public void n() {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).v();
        }
    }

    public void a(com.beizi.ad.a aVar) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(aVar);
        }
    }

    public void a(com.beizi.ad.v2.b.a aVar) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(aVar);
        }
    }

    public void a(View view) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(view);
        }
    }

    public void a(int i, int i2) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(i, i2);
        }
    }

    public void a(View.OnTouchListener onTouchListener) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            ((b) bVar).a(onTouchListener);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar != null && (bVar instanceof b)) {
            d dVar = new d();
            if (!TextUtils.isEmpty(str)) {
                dVar.a(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                dVar.b(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                dVar.c(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                dVar.d(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                dVar.e(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                dVar.f(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                dVar.g(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                dVar.h(str8);
            }
            ((b) this.f4517a).a(dVar, i);
        }
    }
}
