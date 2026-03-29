package com.zenmen.square.dynamiclife.bean;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SquareFeedSuperShowSkuListResult {
    public CityBean city;
    public CityBean country;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class CityBean {
        public String defaultProductId;
        public List<SkuListBean> skuList;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SkuListBean {
        public int price;
        public String productId;
        public boolean selected = false;
        public int showCount;
        public int showTime;
    }
}
