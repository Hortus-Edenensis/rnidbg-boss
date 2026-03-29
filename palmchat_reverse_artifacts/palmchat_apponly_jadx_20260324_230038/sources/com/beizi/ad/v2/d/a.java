package com.beizi.ad.v2.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.beizi.ad.d;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.a.g;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.p;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.beizi.ad.v2.a.a {
    private int b;
    private List<Pair<String, Integer>> c;
    private View d;

    public a(Context context, String str, int i, d dVar) {
        b bVar = new b(context, str, i);
        this.f4517a = bVar;
        if (bVar instanceof b) {
            bVar.a(dVar);
        }
    }

    public void a(int i, View view, View view2, String str) {
        int iN = n();
        boolean zA = p.a(iN);
        m.c("BeiZisAd", "percent = " + iN + ",isPass = " + zA);
        if (zA) {
            this.d = g.a(i, view, view2, str);
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public int n() {
        int iIntValue;
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar == null || !(bVar instanceof b)) {
            return -1;
        }
        String strU = ((b) bVar).u();
        if (TextUtils.isEmpty(strU)) {
            return -1;
        }
        List<Pair<String, Integer>> list = this.c;
        if (list != null) {
            iIntValue = -1;
            for (Pair<String, Integer> pair : list) {
                if (strU.contains((CharSequence) pair.first)) {
                    iIntValue = ((Integer) pair.second).intValue();
                }
            }
        } else {
            iIntValue = -1;
        }
        return iIntValue == -1 ? this.b : iIntValue;
    }

    public void o() {
        View view = this.d;
        if (view != null) {
            t.a(view);
        }
    }

    public void a(List<Pair<String, Integer>> list) {
        this.c = list;
    }

    public void a(View view, com.beizi.ad.internal.c.c cVar) {
        com.beizi.ad.v2.a.b bVar = this.f4517a;
        if (bVar == null || view == null || cVar == null || !(bVar instanceof b)) {
            return;
        }
        ((b) bVar).a(view, cVar);
    }
}
