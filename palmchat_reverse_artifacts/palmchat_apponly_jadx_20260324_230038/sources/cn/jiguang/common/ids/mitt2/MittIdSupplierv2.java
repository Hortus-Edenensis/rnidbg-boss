package cn.jiguang.common.ids.mitt2;

import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import defpackage.up3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MittIdSupplierv2 implements IIdentifierListener {
    private up3 mittCall;

    public MittIdSupplierv2(up3 up3Var) {
        this.mittCall = up3Var;
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void onSupport(IdSupplier idSupplier) {
        try {
            try {
                this.mittCall.b(idSupplier);
            } catch (Throwable unused) {
                this.mittCall.b.put("");
            }
        } catch (Throwable unused2) {
        }
    }
}
