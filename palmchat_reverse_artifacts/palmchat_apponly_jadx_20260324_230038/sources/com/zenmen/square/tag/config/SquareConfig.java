package com.zenmen.square.tag.config;

import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.Keep;
import com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$array;
import com.zenmen.square.tag.bean.SquareTagBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SquareConfig {
    private GuideInfo guideInfo;
    private int leadpersonnum;
    private int tagnum;
    private List<SquareTagBean> tags = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static final class GuideInfo {
        private String discoverleadpagepic;
        private String pagegenderageintro;
        private String pagegenderagetitle;
        private String pageleadintro;
        private String pageleadtitle;
        private String pagetagintro;
        private String pagetagtitle;
        private String pageuploadbutton;
        private String pageuploadintro;
        private String pageuploadintro2;
        private String pageuploadpic;
        private String pageuploadtitle;

        public String getDiscoverleadpagepic() {
            return this.discoverleadpagepic;
        }

        public String getPagegenderageintro() {
            return this.pagegenderageintro;
        }

        public String getPagegenderagetitle() {
            return this.pagegenderagetitle;
        }

        public String getPageleadintro() {
            return this.pageleadintro;
        }

        public String getPageleadtitle() {
            return this.pageleadtitle;
        }

        public String getPagetagintro() {
            return this.pagetagintro;
        }

        public String getPagetagtitle() {
            return this.pagetagtitle;
        }

        public String getPageuploadbutton() {
            return this.pageuploadbutton;
        }

        public String getPageuploadintro() {
            return this.pageuploadintro;
        }

        public String getPageuploadintro2() {
            return this.pageuploadintro2;
        }

        public String getPageuploadpic() {
            return this.pageuploadpic;
        }

        public String getPageuploadtitle() {
            return this.pageuploadtitle;
        }

        public void setDiscoverleadpagepic(String str) {
            this.discoverleadpagepic = str;
        }

        public void setPagegenderageintro(String str) {
            this.pagegenderageintro = str;
        }

        public void setPagegenderagetitle(String str) {
            this.pagegenderagetitle = str;
        }

        public void setPageleadintro(String str) {
            this.pageleadintro = str;
        }

        public void setPageleadtitle(String str) {
            this.pageleadtitle = str;
        }

        public void setPagetagintro(String str) {
            this.pagetagintro = str;
        }

        public void setPagetagtitle(String str) {
            this.pagetagtitle = str;
        }

        public void setPageuploadbutton(String str) {
            this.pageuploadbutton = str;
        }

        public void setPageuploadintro(String str) {
            this.pageuploadintro = str;
        }

        public void setPageuploadintro2(String str) {
            this.pageuploadintro2 = str;
        }

        public void setPageuploadpic(String str) {
            this.pageuploadpic = str;
        }

        public void setPageuploadtitle(String str) {
            this.pageuploadtitle = str;
        }
    }

    public SquareConfig() {
        initData();
    }

    private void initData() {
        if (c.b() == null) {
            return;
        }
        try {
            int[] intArray = c.b().getResources().getIntArray(R$array.square_tag_id);
            String[] stringArray = c.b().getResources().getStringArray(R$array.square_tag_name);
            Resources resources = c.b().getResources();
            int i = R$array.square_tag_pic;
            int[] intArray2 = resources.getIntArray(i);
            if (intArray.length == stringArray.length && intArray.length == intArray2.length) {
                TypedArray typedArrayObtainTypedArray = c.b().getResources().obtainTypedArray(i);
                for (int i2 = 0; i2 < intArray.length; i2++) {
                    SquareTagBean squareTagBean = new SquareTagBean();
                    squareTagBean.setId(intArray[i2]);
                    squareTagBean.setName(stringArray[i2]);
                    squareTagBean.setPicUrl(obtainUri(typedArrayObtainTypedArray.getResourceId(i2, 0)));
                    this.tags.add(squareTagBean);
                }
                typedArrayObtainTypedArray.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String obtainUri(int i) {
        return ImageDownloader$Scheme.DRAWABLE.wrap(String.valueOf(i));
    }

    public GuideInfo getGuideInfo() {
        if (this.guideInfo == null) {
            this.guideInfo = new GuideInfo();
        }
        return this.guideInfo;
    }

    public int getLeadpersonnum() {
        return this.leadpersonnum;
    }

    public int getMinSelectTagCount() {
        int i = this.tagnum;
        if (i <= 0) {
            return 3;
        }
        return i;
    }

    public List<SquareTagBean> getTags() {
        return this.tags;
    }

    public void setLeadpersonnum(int i) {
        this.leadpersonnum = i;
    }

    public void setTags(List<SquareTagBean> list) {
        this.tags = list;
    }
}
