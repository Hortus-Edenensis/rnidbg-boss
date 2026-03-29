package com.zenmen.palmchat.peoplematch.bean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PeopleMatchRewindBean {
    public static boolean hasRewardVideo = false;
    public boolean flag;
    public String goodsId;
    public String name;
    public int quantity;

    public void consumer() {
        if (hasRewardVideo) {
            hasRewardVideo = false;
            return;
        }
        int i = this.quantity;
        if (i > 0) {
            this.quantity = i - 1;
        }
    }

    public int getQuantity() {
        if (hasRewardVideo) {
            return 1;
        }
        return this.quantity;
    }

    public String toString() {
        return "PeopleMatchRewindBean{goodsId='" + this.goodsId + "', name='" + this.name + "', quantity=" + this.quantity + '}';
    }
}
