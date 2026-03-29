package com.bytedance.sdk.component.iz.fx;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.iz.bg;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.d;
import com.bytedance.sdk.component.iz.fx.fx;
import com.bytedance.sdk.component.iz.k;
import com.bytedance.sdk.component.iz.s;
import j$.util.function.Function$CC;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements c, Function {
    private volatile iz u;

    private nr() {
    }

    private void nr(Context context, bg bgVar) {
        if (bgVar == null) {
            bgVar = pn.u(context);
        }
        this.u = new iz(context, bgVar);
    }

    public static c u(Context context, bg bgVar) {
        nr nrVar = new nr();
        nrVar.nr(context, bgVar);
        return nrVar;
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
                s sVarFrom = from((String) sparseArray.get(1));
                return sVarFrom != null ? new k(sVarFrom) : sVarFrom;
            case 2:
                u(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                clearMemoryCache(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                nr(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                u();
                return null;
            case 6:
                return getCacheStream((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return u((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(nr((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.iz.c
    public void clearMemoryCache(double d) {
        if (this.u != null) {
            u(this.u.u(), d);
            u(this.u.nr(), d);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.c
    public s from(String str) {
        return new fx.nr(this.u).from(str);
    }

    @Override // com.bytedance.sdk.component.iz.c
    public InputStream getCacheStream(String str, String str2) {
        if (this.u != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.iz.fx.fx.fx.u(str);
            }
            Collection<d> collectionNr = this.u.nr();
            if (collectionNr != null) {
                Iterator<d> it = collectionNr.iterator();
                while (it.hasNext()) {
                    byte[] bArrU = it.next().u(str2);
                    if (bArrU != null) {
                        return new ByteArrayInputStream(bArrU);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.iz.b> collectionFx = this.u.fx();
            if (collectionFx != null) {
                Iterator<com.bytedance.sdk.component.iz.b> it2 = collectionFx.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamU = it2.next().u(str2);
                    if (inputStreamU != null) {
                        return inputStreamU;
                    }
                }
            }
        }
        return null;
    }

    public void nr(double d) {
        if (this.u != null) {
            u(this.u.fx(), d);
        }
    }

    public void u(double d) {
        clearMemoryCache(d);
        nr(d);
    }

    private void u(Collection<? extends com.bytedance.sdk.component.iz.u> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.iz.u> it = collection.iterator();
        while (it.hasNext()) {
            it.next().u(d);
        }
    }

    public boolean nr(String str, String str2, String str3) {
        if (this.u == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.iz.fx.fx.fx.u(str);
        }
        com.bytedance.sdk.component.iz.b bVarU = this.u.u(str3);
        if (bVarU != null) {
            return bVarU.nr(str2);
        }
        return false;
    }

    public void u() {
        nr(0.0d);
        clearMemoryCache(0.0d);
    }

    public InputStream u(String str, String str2, String str3) {
        if (this.u == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.iz.fx.fx.fx.u(str);
        }
        com.bytedance.sdk.component.iz.b bVarU = this.u.u(str3);
        if (bVarU != null) {
            return bVarU.u(str2);
        }
        return null;
    }
}
