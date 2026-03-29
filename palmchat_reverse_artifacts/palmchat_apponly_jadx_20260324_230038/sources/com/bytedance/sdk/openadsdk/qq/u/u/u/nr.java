package com.bytedance.sdk.openadsdk.qq.u.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.EasyPlayWidgetListener u;

    public nr(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.u = easyPlayWidgetListener;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        switch (valueSetA.intValue(-99999987)) {
            case 144101:
                this.u.onInfo((JSONObject) valueSetA.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.u.getEstimatedInteractionArea();
            case 144103:
                this.u.onCanRenderSuccess((JSONObject) valueSetA.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.u.onCanRenderFail((JSONObject) valueSetA.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.u.onClose();
                return null;
            default:
                return null;
        }
    }
}
