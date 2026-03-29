package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.zenmen.palmchat.extinfo.model.ExtInfoData;
import com.zenmen.palmchat.extinfo.model.OccupationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ExtInfoData> f21016a;
    public List<ExtInfoData> b;
    public List<OccupationData> c;
    public Map<Integer, String> d = new HashMap();
    public Map<Integer, String> e = new HashMap();
    public Map<Integer, String> f = new HashMap();

    public tl0() {
        g();
        h();
        i();
    }

    public String a(int i) {
        if (i != 0 && this.d.containsKey(Integer.valueOf(i))) {
            return this.d.get(Integer.valueOf(i));
        }
        return null;
    }

    public List<ExtInfoData> b() {
        if (j()) {
            return this.f21016a;
        }
        ArrayList arrayList = new ArrayList();
        for (ExtInfoData extInfoData : this.f21016a) {
            if (extInfoData.id != 999) {
                arrayList.add(extInfoData);
            }
        }
        return arrayList;
    }

    public String c(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            return this.e.get(Integer.valueOf(i));
        }
        return null;
    }

    public List<ExtInfoData> d() {
        return this.b;
    }

    public String e(int i) {
        if (i < 100) {
            return null;
        }
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        int i2 = (i / 100) * 100;
        if (this.f.containsKey(Integer.valueOf(i2))) {
            return this.f.get(Integer.valueOf(i2));
        }
        return null;
    }

    public List<OccupationData> f() {
        return this.c;
    }

    public final void g() {
        this.f21016a = new ArrayList();
        ExtInfoData extInfoData = new ExtInfoData();
        extInfoData.id = 0;
        extInfoData.name = "请选择月收入";
        this.f21016a.add(extInfoData);
        ExtInfoData extInfoData2 = new ExtInfoData();
        extInfoData2.id = 100;
        extInfoData2.name = "2000元以下";
        this.f21016a.add(extInfoData2);
        ExtInfoData extInfoData3 = new ExtInfoData();
        extInfoData3.id = 200;
        extInfoData3.name = "2001～5000元";
        this.f21016a.add(extInfoData3);
        ExtInfoData extInfoData4 = new ExtInfoData();
        extInfoData4.id = 300;
        extInfoData4.name = "5001～8000元";
        this.f21016a.add(extInfoData4);
        ExtInfoData extInfoData5 = new ExtInfoData();
        extInfoData5.id = 400;
        extInfoData5.name = "8001～12000元";
        this.f21016a.add(extInfoData5);
        ExtInfoData extInfoData6 = new ExtInfoData();
        extInfoData6.id = 500;
        extInfoData6.name = "12001～20000元";
        this.f21016a.add(extInfoData6);
        ExtInfoData extInfoData7 = new ExtInfoData();
        extInfoData7.id = 600;
        extInfoData7.name = "20001～50000元";
        this.f21016a.add(extInfoData7);
        ExtInfoData extInfoData8 = new ExtInfoData();
        extInfoData8.id = 700;
        extInfoData8.name = "50000以上";
        this.f21016a.add(extInfoData8);
        ExtInfoData extInfoData9 = new ExtInfoData();
        extInfoData9.id = 999;
        extInfoData9.name = "保密";
        this.f21016a.add(extInfoData9);
        for (ExtInfoData extInfoData10 : this.f21016a) {
            this.d.put(Integer.valueOf(extInfoData10.id), extInfoData10.name);
        }
    }

    public final void h() {
        this.b = new ArrayList();
        ExtInfoData extInfoData = new ExtInfoData();
        extInfoData.id = 100;
        extInfoData.name = "接受约会";
        this.b.add(extInfoData);
        ExtInfoData extInfoData2 = new ExtInfoData();
        extInfoData2.id = 200;
        extInfoData2.name = "交个朋友";
        this.b.add(extInfoData2);
        ExtInfoData extInfoData3 = new ExtInfoData();
        extInfoData3.id = 300;
        extInfoData3.name = "拓展人脉";
        this.b.add(extInfoData3);
        ExtInfoData extInfoData4 = new ExtInfoData();
        extInfoData4.id = 400;
        extInfoData4.name = "互诉谈心";
        this.b.add(extInfoData4);
        ExtInfoData extInfoData5 = new ExtInfoData();
        extInfoData5.id = 500;
        extInfoData5.name = "共同兴趣";
        this.b.add(extInfoData5);
        ExtInfoData extInfoData6 = new ExtInfoData();
        extInfoData6.id = 600;
        extInfoData6.name = "脱单";
        this.b.add(extInfoData6);
        for (ExtInfoData extInfoData7 : this.b) {
            this.e.put(Integer.valueOf(extInfoData7.id), extInfoData7.name);
        }
    }

    public final void i() {
        this.c = new ArrayList();
        OccupationData occupationData = new OccupationData();
        occupationData.id = 0;
        occupationData.name = "请选择职业";
        OccupationData occupationData2 = new OccupationData();
        occupationData2.id = 100;
        occupationData2.name = "IT互联网/通讯";
        occupationData2.jobs = new ArrayList();
        ExtInfoData extInfoData = new ExtInfoData();
        extInfoData.id = 101;
        extInfoData.name = "研发";
        occupationData2.jobs.add(extInfoData);
        ExtInfoData extInfoData2 = new ExtInfoData();
        extInfoData2.id = 102;
        extInfoData2.name = "项目管理";
        occupationData2.jobs.add(extInfoData2);
        ExtInfoData extInfoData3 = new ExtInfoData();
        extInfoData3.id = 103;
        extInfoData3.name = "产品经理";
        occupationData2.jobs.add(extInfoData3);
        ExtInfoData extInfoData4 = new ExtInfoData();
        extInfoData4.id = 104;
        extInfoData4.name = "测试/运维";
        occupationData2.jobs.add(extInfoData4);
        ExtInfoData extInfoData5 = new ExtInfoData();
        extInfoData5.id = 105;
        extInfoData5.name = "设计";
        occupationData2.jobs.add(extInfoData5);
        ExtInfoData extInfoData6 = new ExtInfoData();
        extInfoData6.id = 106;
        extInfoData6.name = "运营/编辑";
        occupationData2.jobs.add(extInfoData6);
        ExtInfoData extInfoData7 = new ExtInfoData();
        extInfoData7.id = 107;
        extInfoData7.name = "市场商务";
        occupationData2.jobs.add(extInfoData7);
        ExtInfoData extInfoData8 = new ExtInfoData();
        extInfoData8.id = 108;
        extInfoData8.name = "客户服务";
        occupationData2.jobs.add(extInfoData8);
        ExtInfoData extInfoData9 = new ExtInfoData();
        extInfoData9.id = 109;
        extInfoData9.name = "技术支持";
        occupationData2.jobs.add(extInfoData9);
        ExtInfoData extInfoData10 = new ExtInfoData();
        extInfoData10.id = 110;
        extInfoData10.name = "HR";
        occupationData2.jobs.add(extInfoData10);
        ExtInfoData extInfoData11 = new ExtInfoData();
        extInfoData11.id = 111;
        extInfoData11.name = "行政";
        occupationData2.jobs.add(extInfoData11);
        ExtInfoData extInfoData12 = new ExtInfoData();
        extInfoData12.id = 112;
        extInfoData12.name = "企业管理者";
        occupationData2.jobs.add(extInfoData12);
        OccupationData occupationData3 = new OccupationData();
        occupationData3.id = 200;
        occupationData3.name = "公共事业";
        occupationData3.jobs = new ArrayList();
        ExtInfoData extInfoData13 = new ExtInfoData();
        extInfoData13.id = 201;
        extInfoData13.name = "教育培训";
        occupationData3.jobs.add(extInfoData13);
        ExtInfoData extInfoData14 = new ExtInfoData();
        extInfoData14.id = 202;
        extInfoData14.name = "医疗/健康";
        occupationData3.jobs.add(extInfoData14);
        ExtInfoData extInfoData15 = new ExtInfoData();
        extInfoData15.id = 203;
        extInfoData15.name = "能源环保";
        occupationData3.jobs.add(extInfoData15);
        ExtInfoData extInfoData16 = new ExtInfoData();
        extInfoData16.id = 204;
        extInfoData16.name = "交通运输";
        occupationData3.jobs.add(extInfoData16);
        ExtInfoData extInfoData17 = new ExtInfoData();
        extInfoData17.id = 205;
        extInfoData17.name = "物流仓储";
        occupationData3.jobs.add(extInfoData17);
        ExtInfoData extInfoData18 = new ExtInfoData();
        extInfoData18.id = 206;
        extInfoData18.name = "养殖业";
        occupationData3.jobs.add(extInfoData18);
        ExtInfoData extInfoData19 = new ExtInfoData();
        extInfoData19.id = 207;
        extInfoData19.name = "农业种植";
        occupationData3.jobs.add(extInfoData19);
        ExtInfoData extInfoData20 = new ExtInfoData();
        extInfoData20.id = 208;
        extInfoData20.name = "律师/法务";
        occupationData3.jobs.add(extInfoData20);
        ExtInfoData extInfoData21 = new ExtInfoData();
        extInfoData21.id = 209;
        extInfoData21.name = "翻译";
        occupationData3.jobs.add(extInfoData21);
        ExtInfoData extInfoData22 = new ExtInfoData();
        extInfoData22.id = 210;
        extInfoData22.name = "手艺人";
        occupationData3.jobs.add(extInfoData22);
        ExtInfoData extInfoData23 = new ExtInfoData();
        extInfoData23.id = 211;
        extInfoData23.name = "社会工作者";
        occupationData3.jobs.add(extInfoData23);
        OccupationData occupationData4 = new OccupationData();
        occupationData4.id = 300;
        occupationData4.name = "其他";
        occupationData4.jobs = new ArrayList();
        ExtInfoData extInfoData24 = new ExtInfoData();
        extInfoData24.id = 301;
        extInfoData24.name = "自由职业";
        occupationData4.jobs.add(extInfoData24);
        ExtInfoData extInfoData25 = new ExtInfoData();
        extInfoData25.id = 302;
        extInfoData25.name = "学生";
        occupationData4.jobs.add(extInfoData25);
        OccupationData occupationData5 = new OccupationData();
        occupationData5.id = 400;
        occupationData5.name = "商业服务";
        occupationData5.jobs = new ArrayList();
        ExtInfoData extInfoData26 = new ExtInfoData();
        extInfoData26.id = 401;
        extInfoData26.name = "市场销售";
        occupationData5.jobs.add(extInfoData26);
        ExtInfoData extInfoData27 = new ExtInfoData();
        extInfoData27.id = 402;
        extInfoData27.name = "个体经营";
        occupationData5.jobs.add(extInfoData27);
        ExtInfoData extInfoData28 = new ExtInfoData();
        extInfoData28.id = 403;
        extInfoData28.name = "餐饮";
        occupationData5.jobs.add(extInfoData28);
        ExtInfoData extInfoData29 = new ExtInfoData();
        extInfoData29.id = 404;
        extInfoData29.name = "美容美发";
        occupationData5.jobs.add(extInfoData29);
        ExtInfoData extInfoData30 = new ExtInfoData();
        extInfoData30.id = 405;
        extInfoData30.name = "服装";
        occupationData5.jobs.add(extInfoData30);
        ExtInfoData extInfoData31 = new ExtInfoData();
        extInfoData31.id = 406;
        extInfoData31.name = "机电维修";
        occupationData5.jobs.add(extInfoData31);
        ExtInfoData extInfoData32 = new ExtInfoData();
        extInfoData32.id = 407;
        extInfoData32.name = "零售/百货";
        occupationData5.jobs.add(extInfoData32);
        ExtInfoData extInfoData33 = new ExtInfoData();
        extInfoData33.id = 408;
        extInfoData33.name = "贸易";
        occupationData5.jobs.add(extInfoData33);
        ExtInfoData extInfoData34 = new ExtInfoData();
        extInfoData34.id = 409;
        extInfoData34.name = "经营管理";
        occupationData5.jobs.add(extInfoData34);
        ExtInfoData extInfoData35 = new ExtInfoData();
        extInfoData35.id = 410;
        extInfoData35.name = "行政人事";
        occupationData5.jobs.add(extInfoData35);
        ExtInfoData extInfoData36 = new ExtInfoData();
        extInfoData36.id = 411;
        extInfoData36.name = "酒店/旅游";
        occupationData5.jobs.add(extInfoData36);
        ExtInfoData extInfoData37 = new ExtInfoData();
        extInfoData37.id = 412;
        extInfoData37.name = "娱乐休闲";
        occupationData5.jobs.add(extInfoData37);
        ExtInfoData extInfoData38 = new ExtInfoData();
        extInfoData38.id = 413;
        extInfoData38.name = "安保";
        occupationData5.jobs.add(extInfoData38);
        ExtInfoData extInfoData39 = new ExtInfoData();
        extInfoData39.id = 414;
        extInfoData39.name = "家政保洁";
        occupationData5.jobs.add(extInfoData39);
        ExtInfoData extInfoData40 = new ExtInfoData();
        extInfoData40.id = 415;
        extInfoData40.name = "客服";
        occupationData5.jobs.add(extInfoData40);
        ExtInfoData extInfoData41 = new ExtInfoData();
        extInfoData41.id = 416;
        extInfoData41.name = "运动健身";
        occupationData5.jobs.add(extInfoData41);
        ExtInfoData extInfoData42 = new ExtInfoData();
        extInfoData42.id = 417;
        extInfoData42.name = "婚庆";
        occupationData5.jobs.add(extInfoData42);
        ExtInfoData extInfoData43 = new ExtInfoData();
        extInfoData43.id = TTAdConstant.DEEPLINK_FALL_BACK_CODE;
        extInfoData43.name = "宠物服务";
        occupationData5.jobs.add(extInfoData43);
        OccupationData occupationData6 = new OccupationData();
        occupationData6.id = 500;
        occupationData6.name = "房产建筑";
        occupationData6.jobs = new ArrayList();
        ExtInfoData extInfoData44 = new ExtInfoData();
        extInfoData44.id = 501;
        extInfoData44.name = "技术工人";
        occupationData6.jobs.add(extInfoData44);
        ExtInfoData extInfoData45 = new ExtInfoData();
        extInfoData45.id = 502;
        extInfoData45.name = "装修/建材";
        occupationData6.jobs.add(extInfoData45);
        ExtInfoData extInfoData46 = new ExtInfoData();
        extInfoData46.id = 503;
        extInfoData46.name = "工程师";
        occupationData6.jobs.add(extInfoData46);
        ExtInfoData extInfoData47 = new ExtInfoData();
        extInfoData47.id = 504;
        extInfoData47.name = "建筑师";
        occupationData6.jobs.add(extInfoData47);
        ExtInfoData extInfoData48 = new ExtInfoData();
        extInfoData48.id = 505;
        extInfoData48.name = "房产经纪";
        occupationData6.jobs.add(extInfoData48);
        ExtInfoData extInfoData49 = new ExtInfoData();
        extInfoData49.id = 506;
        extInfoData49.name = "物业管理";
        occupationData6.jobs.add(extInfoData49);
        ExtInfoData extInfoData50 = new ExtInfoData();
        extInfoData50.id = 507;
        extInfoData50.name = "质控/安防";
        occupationData6.jobs.add(extInfoData50);
        ExtInfoData extInfoData51 = new ExtInfoData();
        extInfoData51.id = 508;
        extInfoData51.name = "工程管理";
        occupationData6.jobs.add(extInfoData51);
        ExtInfoData extInfoData52 = new ExtInfoData();
        extInfoData52.id = 509;
        extInfoData52.name = "工程承包商";
        occupationData6.jobs.add(extInfoData52);
        ExtInfoData extInfoData53 = new ExtInfoData();
        extInfoData53.id = 510;
        extInfoData53.name = "企业管理者";
        occupationData6.jobs.add(extInfoData53);
        OccupationData occupationData7 = new OccupationData();
        occupationData7.id = 600;
        occupationData7.name = "文化传媒";
        occupationData7.jobs = new ArrayList();
        ExtInfoData extInfoData54 = new ExtInfoData();
        extInfoData54.id = 601;
        extInfoData54.name = "广告/创意";
        occupationData7.jobs.add(extInfoData54);
        ExtInfoData extInfoData55 = new ExtInfoData();
        extInfoData55.id = 602;
        extInfoData55.name = "设计";
        occupationData7.jobs.add(extInfoData55);
        ExtInfoData extInfoData56 = new ExtInfoData();
        extInfoData56.id = 603;
        extInfoData56.name = "文化传播";
        occupationData7.jobs.add(extInfoData56);
        ExtInfoData extInfoData57 = new ExtInfoData();
        extInfoData57.id = MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN;
        extInfoData57.name = "媒体出版";
        occupationData7.jobs.add(extInfoData57);
        ExtInfoData extInfoData58 = new ExtInfoData();
        extInfoData58.id = MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN;
        extInfoData58.name = "演出/会展";
        occupationData7.jobs.add(extInfoData58);
        ExtInfoData extInfoData59 = new ExtInfoData();
        extInfoData59.id = MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP;
        extInfoData59.name = "市场/公关";
        occupationData7.jobs.add(extInfoData59);
        ExtInfoData extInfoData60 = new ExtInfoData();
        extInfoData60.id = MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS;
        extInfoData60.name = "摄影/编导/制作人";
        occupationData7.jobs.add(extInfoData60);
        ExtInfoData extInfoData61 = new ExtInfoData();
        extInfoData61.id = MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS;
        extInfoData61.name = "经纪人";
        occupationData7.jobs.add(extInfoData61);
        ExtInfoData extInfoData62 = new ExtInfoData();
        extInfoData62.id = MediaPlayer.MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START;
        extInfoData62.name = "行政人事";
        occupationData7.jobs.add(extInfoData62);
        ExtInfoData extInfoData63 = new ExtInfoData();
        extInfoData63.id = 610;
        extInfoData63.name = "企业管理者";
        occupationData7.jobs.add(extInfoData63);
        OccupationData occupationData8 = new OccupationData();
        occupationData8.id = 700;
        occupationData8.name = "机关/事业单位/国企";
        occupationData8.jobs = new ArrayList();
        ExtInfoData extInfoData64 = new ExtInfoData();
        extInfoData64.id = 701;
        extInfoData64.name = "国家机关";
        occupationData8.jobs.add(extInfoData64);
        ExtInfoData extInfoData65 = new ExtInfoData();
        extInfoData65.id = 702;
        extInfoData65.name = "事业单位";
        occupationData8.jobs.add(extInfoData65);
        ExtInfoData extInfoData66 = new ExtInfoData();
        extInfoData66.id = 703;
        extInfoData66.name = "科研";
        occupationData8.jobs.add(extInfoData66);
        ExtInfoData extInfoData67 = new ExtInfoData();
        extInfoData67.id = 704;
        extInfoData67.name = "教师";
        occupationData8.jobs.add(extInfoData67);
        ExtInfoData extInfoData68 = new ExtInfoData();
        extInfoData68.id = 705;
        extInfoData68.name = "国企";
        occupationData8.jobs.add(extInfoData68);
        ExtInfoData extInfoData69 = new ExtInfoData();
        extInfoData69.id = 706;
        extInfoData69.name = "央企";
        occupationData8.jobs.add(extInfoData69);
        ExtInfoData extInfoData70 = new ExtInfoData();
        extInfoData70.id = 707;
        extInfoData70.name = "医生";
        occupationData8.jobs.add(extInfoData70);
        ExtInfoData extInfoData71 = new ExtInfoData();
        extInfoData71.id = 708;
        extInfoData71.name = "护士";
        occupationData8.jobs.add(extInfoData71);
        ExtInfoData extInfoData72 = new ExtInfoData();
        extInfoData72.id = 709;
        extInfoData72.name = "社团协会";
        occupationData8.jobs.add(extInfoData72);
        OccupationData occupationData9 = new OccupationData();
        occupationData9.id = 800;
        occupationData9.name = "生产制造";
        occupationData9.jobs = new ArrayList();
        ExtInfoData extInfoData73 = new ExtInfoData();
        extInfoData73.id = 801;
        extInfoData73.name = "技术工人";
        occupationData9.jobs.add(extInfoData73);
        ExtInfoData extInfoData74 = new ExtInfoData();
        extInfoData74.id = 802;
        extInfoData74.name = "生产管理";
        occupationData9.jobs.add(extInfoData74);
        ExtInfoData extInfoData75 = new ExtInfoData();
        extInfoData75.id = 803;
        extInfoData75.name = "电子/电器";
        occupationData9.jobs.add(extInfoData75);
        ExtInfoData extInfoData76 = new ExtInfoData();
        extInfoData76.id = 804;
        extInfoData76.name = "化工";
        occupationData9.jobs.add(extInfoData76);
        ExtInfoData extInfoData77 = new ExtInfoData();
        extInfoData77.id = 805;
        extInfoData77.name = "机械制造";
        occupationData9.jobs.add(extInfoData77);
        ExtInfoData extInfoData78 = new ExtInfoData();
        extInfoData78.id = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME;
        extInfoData78.name = "生物制药";
        occupationData9.jobs.add(extInfoData78);
        ExtInfoData extInfoData79 = new ExtInfoData();
        extInfoData79.id = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME;
        extInfoData79.name = "医疗器械";
        occupationData9.jobs.add(extInfoData79);
        ExtInfoData extInfoData80 = new ExtInfoData();
        extInfoData80.id = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME;
        extInfoData80.name = "汽车";
        occupationData9.jobs.add(extInfoData80);
        ExtInfoData extInfoData81 = new ExtInfoData();
        extInfoData81.id = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME;
        extInfoData81.name = "轻工业";
        occupationData9.jobs.add(extInfoData81);
        ExtInfoData extInfoData82 = new ExtInfoData();
        extInfoData82.id = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO;
        extInfoData82.name = "企业管理者";
        occupationData9.jobs.add(extInfoData82);
        OccupationData occupationData10 = new OccupationData();
        occupationData10.id = 900;
        occupationData10.name = "金融";
        occupationData10.jobs = new ArrayList();
        ExtInfoData extInfoData83 = new ExtInfoData();
        extInfoData83.id = 901;
        extInfoData83.name = "咨询/顾问";
        occupationData10.jobs.add(extInfoData83);
        ExtInfoData extInfoData84 = new ExtInfoData();
        extInfoData84.id = 902;
        extInfoData84.name = "证券";
        occupationData10.jobs.add(extInfoData84);
        ExtInfoData extInfoData85 = new ExtInfoData();
        extInfoData85.id = DetailedCreativeType.VIDEO;
        extInfoData85.name = "银行";
        occupationData10.jobs.add(extInfoData85);
        ExtInfoData extInfoData86 = new ExtInfoData();
        extInfoData86.id = DetailedCreativeType.THREE_IMG;
        extInfoData86.name = "保险/理财";
        occupationData10.jobs.add(extInfoData86);
        ExtInfoData extInfoData87 = new ExtInfoData();
        extInfoData87.id = DetailedCreativeType.SMALL_IMG;
        extInfoData87.name = "财税/审计";
        occupationData10.jobs.add(extInfoData87);
        ExtInfoData extInfoData88 = new ExtInfoData();
        extInfoData88.id = 906;
        extInfoData88.name = "行政人事";
        occupationData10.jobs.add(extInfoData88);
        ExtInfoData extInfoData89 = new ExtInfoData();
        extInfoData89.id = 907;
        extInfoData89.name = "风投/投行";
        occupationData10.jobs.add(extInfoData89);
        ExtInfoData extInfoData90 = new ExtInfoData();
        extInfoData90.id = 908;
        extInfoData90.name = "信托/担保";
        occupationData10.jobs.add(extInfoData90);
        ExtInfoData extInfoData91 = new ExtInfoData();
        extInfoData91.id = DetailedCreativeType.SINGLE_IMG;
        extInfoData91.name = "市场商务";
        occupationData10.jobs.add(extInfoData91);
        ExtInfoData extInfoData92 = new ExtInfoData();
        extInfoData92.id = MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_SPACE;
        extInfoData92.name = "企业管理者";
        occupationData10.jobs.add(extInfoData92);
        this.c.add(occupationData);
        this.c.add(occupationData5);
        this.c.add(occupationData9);
        this.c.add(occupationData6);
        this.c.add(occupationData3);
        this.c.add(occupationData8);
        this.c.add(occupationData2);
        this.c.add(occupationData7);
        this.c.add(occupationData10);
        this.c.add(occupationData4);
        for (OccupationData occupationData11 : this.c) {
            this.f.put(Integer.valueOf(occupationData11.id), occupationData11.name);
            List<ExtInfoData> list = occupationData11.jobs;
            if (list != null) {
                for (ExtInfoData extInfoData93 : list) {
                    this.f.put(Integer.valueOf(extInfoData93.id), extInfoData93.name);
                }
            }
        }
    }

    public final boolean j() {
        JSONObject config = vs0.a().getConfig("regProfile");
        if (config != null) {
            return config.optBoolean("regincomesecret", true);
        }
        return true;
    }
}
