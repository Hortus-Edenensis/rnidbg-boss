package com.qq.e.ads;

import com.qq.e.comm.pi.IBiddingLoss;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class NativeAbstractAD<T extends IBiddingLoss> extends AbstractAD<T> implements IBiddingLoss {

    /* JADX INFO: compiled from: SearchBox */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f10390a.sendLossNotification(map);
    }
}
