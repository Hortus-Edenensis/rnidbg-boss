package com.effectsar.labcv.effectsdk;

import androidx.exifinterface.media.ExifInterface;
import com.effectsar.labcv.effectsdk.BefPublicDefine;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefCarDetectInfo {
    private double blurScore;
    private BefBrandInfo[] brandInfos;
    private BefCarRect[] carRects;
    private double grayScore;
    private int carCount = 0;
    private int brandCount = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class BefBrandInfo {
        int brandId;
        int[] brandOcr;
        private String[] ocrTable = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "D", ExifInterface.LONGITUDE_EAST, "F", WkAdxAdConfigMg.DSP_NAME_GDT, "H", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "云", "京", "冀", "吉", "宁", "川", "新", "晋", "桂", "沪", "津", "浙", "渝", "湘", "琼", "甘", "皖", "粤", "苏", "蒙", "藏", "豫", "贵", "赣", "辽", "鄂", "闽", "陕", "青", "鲁", "黑"};
        BefPublicDefine.BefPointF[] points;

        public int getBrandId() {
            return this.brandId;
        }

        public int[] getBrandOcr() {
            return this.brandOcr;
        }

        public String getBrandOcrString() {
            StringBuilder sb = new StringBuilder();
            for (int i : this.brandOcr) {
                sb.append(this.ocrTable[i]);
            }
            return sb.toString();
        }

        public BefPublicDefine.BefPointF[] getPoints() {
            return this.points;
        }

        public void setBrandId(int i) {
            this.brandId = i;
        }

        public void setPoints(BefPublicDefine.BefPointF[] befPointFArr) {
            this.points = befPointFArr;
        }
    }

    public double getBlurScore() {
        return this.blurScore;
    }

    public int getBrandCount() {
        return this.brandCount;
    }

    public BefBrandInfo[] getBrandInfos() {
        return this.brandInfos;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public BefCarRect[] getCarRects() {
        return this.carRects;
    }

    public double getGrayScore() {
        return this.grayScore;
    }

    public void setBrandCount(int i) {
        this.brandCount = i;
    }

    public void setBrandInfos(BefBrandInfo[] befBrandInfoArr) {
        this.brandInfos = befBrandInfoArr;
    }

    public void setCarCount(int i) {
        this.carCount = i;
    }

    public void setCarRects(BefCarRect[] befCarRectArr) {
        this.carRects = befCarRectArr;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BefCarRect extends BefPublicDefine.BefRect {
        private int orientation;

        public BefCarRect(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
            this.orientation = 0;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public void setOrientation(int i) {
            this.orientation = i;
        }

        public BefCarRect(int i, int i2, int i3, int i4, int i5) {
            super(i, i2, i3, i4);
            this.orientation = i5;
        }
    }
}
