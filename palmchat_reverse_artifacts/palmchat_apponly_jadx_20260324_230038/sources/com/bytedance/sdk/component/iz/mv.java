package com.bytedance.sdk.component.iz;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class mv implements l, Function {
    l nr;
    Function u;

    public mv(l lVar) {
        this.nr = lVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.nr.cancelRequest());
            case 2:
                return this.nr.getUrl();
            case 3:
                return Integer.valueOf(this.nr.getWidth());
            case 4:
                return Integer.valueOf(this.nr.getHeight());
            case 5:
                return this.nr.getScaleType();
            case 6:
                return this.nr.getRawCacheKey();
            case 7:
                return this.nr.getMemoryCacheKey();
            case 8:
                return this.nr.getBitmapConfig();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.iz.l
    public boolean cancelRequest() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public Bitmap.Config getBitmapConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Bitmap.Config) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getMemoryCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getRawCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public ImageView.ScaleType getScaleType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (ImageView.ScaleType) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.l
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    public mv(Function function) {
        this.u = function;
    }
}
