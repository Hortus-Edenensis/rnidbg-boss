package com.zenmen.palmchat.peoplematch.bean;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PeopleMatchGoodsBean {
    public int freeSecond;
    public List<PeopleMatchGoodItem> goodsPackageList;
    public List<PeopleMatchUserGoodsItem> infos;
    public int selectIndex;

    /* JADX INFO: compiled from: SearchBox */
    public class PeopleMatchGoodItem {
        public String body;
        public String goodsPackageId;
        public String goodsPackageName;
        public String price;
        public String promPrice;
        public int quantity;

        public PeopleMatchGoodItem() {
        }

        public int getTotalPrice() {
            try {
                return ((int) Float.parseFloat(this.promPrice)) * this.quantity;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class PeopleMatchUserGoodsItem {
        public String goodsId;
        public String name;
        public int quantity;

        public PeopleMatchUserGoodsItem() {
        }
    }

    public int getSuperLikeCount() {
        List<PeopleMatchUserGoodsItem> list = this.infos;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.infos.get(0).quantity;
    }
}
