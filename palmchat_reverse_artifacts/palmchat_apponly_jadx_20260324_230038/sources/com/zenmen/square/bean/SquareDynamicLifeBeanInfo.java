package com.zenmen.square.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareDynamicLifeBeanInfo {
    public String city;
    public String content;
    public long createTime;
    public String exid;
    public int feedType;
    public long id;
    public boolean isPublish = false;
    public int mediaSize;
    public String month;
    public Integer picSource;
    public int superShowType;
    public String thumbUrl;
    public String uid;
    public String url;
    public long version;
    public int views;
    public String year;

    public int getPicSource() {
        Integer num = this.picSource;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public void getYearAndMonthByCreateTime() {
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM").format(new Date(this.createTime)).split("-");
        this.year = strArrSplit[0];
        String str = strArrSplit[1];
        this.month = str;
        if (str.startsWith("0")) {
            this.month = this.month.replaceFirst("0", "");
        }
    }

    public boolean isCurrentYear() {
        return new SimpleDateFormat("yyyy").format(new Date()).equals(this.year);
    }
}
