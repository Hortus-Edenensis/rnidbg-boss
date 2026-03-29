package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class o implements my, Function {
    my nr;
    Function u;

    public o(my myVar) {
        this.nr = myVar;
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
                return this.nr.getCacheKey();
            case 2:
                return this.nr.getUrl();
            case 3:
                return this.nr.getResult();
            case 4:
                return this.nr.getOriginResult();
            case 5:
                this.nr.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.nr.getWidth());
            case 7:
                return Integer.valueOf(this.nr.getHeight());
            case 8:
                return this.nr.getHeaders();
            case 9:
                return Boolean.valueOf(this.nr.isGif());
            case 10:
                return Boolean.valueOf(this.nr.isLocal());
            case 11:
                n httpTime = this.nr.getHttpTime();
                return httpTime != null ? new a(httpTime) : httpTime;
            case 12:
                return Integer.valueOf(this.nr.getFileSize());
            default:
                return null;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public String getCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getFileSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.iz.my
    public Map getHeaders() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Map) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.bytedance.sdk.component.iz.my
    public n getHttpTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.u.apply(sparseArray);
        ?? aVar = Apply;
        if (Apply != 0) {
            aVar = new a((Function) Apply);
        }
        return (n) aVar;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public Object getOriginResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public Object getResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.iz.my
    public boolean isGif() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.iz.my
    public boolean isLocal() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.iz.my
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.u.apply(sparseArray);
    }

    public o(Function function) {
        this.u = function;
    }
}
