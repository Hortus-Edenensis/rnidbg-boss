package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SkuItem2 {
    public String btnText;
    public String description;
    public boolean displayStatus;
    public String name;
    public int price;
    public int queueSize;
    public int remainingBuyQuantity;
    public int remainingQuantity;
    public int skuId;

    public SkuItem convert2SkuItem() {
        SkuItem skuItem = new SkuItem();
        skuItem.displayStatus = this.displayStatus;
        skuItem.price = this.price;
        skuItem.remainingQuantity = this.remainingQuantity;
        skuItem.id = this.skuId;
        return skuItem;
    }
}
