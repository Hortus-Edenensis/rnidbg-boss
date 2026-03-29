package com.zenmen.palmchat.sync;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MyTabOfNewVipCenterConfig {
    public String jump_page;
    public NewVipConf new_vip_conf;
    public List<RedDotConf> reddot_period;
    public int visiable = 1;
    public int autorun = 1;
    public String viptext_nonvip = "开通连信会员";
    public String viptext_vip = "会员权益生效中";
    public String[] campaign_nonvip = {"尊贵特权等你来开启"};
    public String[] campaign_vip = {"查看你的尊贵特权"};

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public class NewVipConf {
        public NewVipDetailConf expire_conf;
        public NewVipDetailConf normal_conf;
        public NewVipDetailConf svip_conf;
        public NewVipDetailConf vip_conf;

        public NewVipConf() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public class NewVipDetailConf {
        public String btn_text;
        public String[] campaign_text;
        public String title_text;

        public NewVipDetailConf() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public class RedDotConf {
        public String end;
        public int num;
        public String start;

        public RedDotConf() {
        }
    }
}
