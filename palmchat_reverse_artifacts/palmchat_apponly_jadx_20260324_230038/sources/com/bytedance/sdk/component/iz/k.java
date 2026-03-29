package com.bytedance.sdk.component.iz;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class k implements s, Function {
    s nr;
    Function u;

    public k(s sVar) {
        this.nr = sVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object kjVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (kjVar != null) {
                    kjVar = new kj((Function) kjVar);
                }
                l lVar = this.nr.to((qq) kjVar, ((Integer) obj2).intValue());
                return lVar != null ? new mv(lVar) : lVar;
            case 2:
                Object kjVar2 = sparseArray.get(1);
                if (kjVar2 != null) {
                    kjVar2 = new kj((Function) kjVar2);
                }
                l lVar2 = this.nr.to((qq) kjVar2);
                return lVar2 != null ? new mv(lVar2) : lVar2;
            case 3:
                l lVar3 = this.nr.to((ImageView) sparseArray.get(1));
                return lVar3 != null ? new mv(lVar3) : lVar3;
            case 4:
                return this.nr.from((String) sparseArray.get(1));
            case 5:
                return this.nr.key((String) sparseArray.get(1));
            case 6:
                Object fxVar = sparseArray.get(1);
                if (fxVar != null) {
                    fxVar = new fx((Function) fxVar);
                }
                return this.nr.cache((nr) fxVar);
            case 7:
                return this.nr.cacheDir((String) sparseArray.get(1));
            case 8:
                return this.nr.scaleType((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.nr.config((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.nr.width(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.nr.height(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.nr.type(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object rhVar = sparseArray.get(1);
                if (rhVar != null) {
                    rhVar = new rh((Function) rhVar);
                }
                return this.nr.track((h) rhVar);
            case 14:
                return this.nr.headers(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.nr.requestTime(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.nr.runIn((ExecutorService) sparseArray.get(1));
            case 17:
                Object tVar = sparseArray.get(1);
                if (tVar != null) {
                    tVar = new t((Function) tVar);
                }
                return this.nr.converter((jk) tVar);
            case 18:
                return this.nr.maxWidth(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.nr.maxHeight(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.nr.sync(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object dwVar = sparseArray.get(1);
                if (dwVar != null) {
                    dwVar = new dw((Function) dwVar);
                }
                return this.nr.loadSetp((bq) dwVar);
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s cache(nr nrVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (nrVar != null) {
            nrVar = new fx(nrVar);
        }
        sparseArray.put(1, nrVar);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s cacheDir(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.u.apply(sparseArray);
        return this;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s config(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s converter(jk jkVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (jkVar != null) {
            jkVar = new t(jkVar);
        }
        sparseArray.put(1, jkVar);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s from(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s headers(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s height(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s key(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s loadSetp(bq bqVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (bqVar != null) {
            bqVar = new dw(bqVar);
        }
        sparseArray.put(1, bqVar);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s maxHeight(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s maxWidth(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s requestTime(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s runIn(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s scaleType(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s sync(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.u.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.bytedance.sdk.component.iz.s
    public l to(ImageView imageView) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        ?? Apply = this.u.apply(sparseArray);
        ?? mvVar = Apply;
        if (Apply != 0) {
            mvVar = new mv((Function) Apply);
        }
        return (l) mvVar;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s track(h hVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (hVar != null) {
            hVar = new rh(hVar);
        }
        sparseArray.put(1, hVar);
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s type(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.iz.s
    public s width(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.u.apply(sparseArray);
        return this;
    }

    public k(Function function) {
        this.u = function;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.bytedance.sdk.component.iz.s
    public l to(qq qqVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (qqVar != null) {
            qqVar = new kj(qqVar);
        }
        sparseArray.put(1, qqVar);
        ?? Apply = this.u.apply(sparseArray);
        ?? mvVar = Apply;
        if (Apply != 0) {
            mvVar = new mv((Function) Apply);
        }
        return (l) mvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.bytedance.sdk.component.iz.s
    public l to(qq qqVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (qqVar != null) {
            qqVar = new kj(qqVar);
        }
        sparseArray.put(1, qqVar);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.u.apply(sparseArray);
        ?? mvVar = Apply;
        if (Apply != 0) {
            mvVar = new mv((Function) Apply);
        }
        return (l) mvVar;
    }
}
