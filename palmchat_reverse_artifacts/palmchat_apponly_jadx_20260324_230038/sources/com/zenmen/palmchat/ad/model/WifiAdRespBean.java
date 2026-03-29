package com.zenmen.palmchat.ad.model;

import android.text.TextUtils;
import defpackage.az4;
import defpackage.cj;
import defpackage.gs1;
import defpackage.qd3;
import defpackage.s7;
import defpackage.w5;
import defpackage.x5;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WifiAdRespBean implements Serializable {
    private String pvid;
    private List<ResultBean> result;
    private int retCd;
    private String retMsg;
    private String showMsg;
    private int templateId;

    /* JADX INFO: compiled from: SearchBox */
    public static class AppBean {
        private int allInPrivacy;
        private String developer;
        private String icon;
        private String name;
        private List<PermissionBean> permissions;
        private String pkg;
        private String privacy;
        private String size;
        private String v;

        public int getAllInPrivacy() {
            return this.allInPrivacy;
        }

        public String getDeveloper() {
            return this.developer;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public List<PermissionBean> getPermissions() {
            return this.permissions;
        }

        public String getPkg() {
            return this.pkg;
        }

        public String getPrivacy() {
            return this.privacy;
        }

        public String getSize() {
            return this.size;
        }

        public String getV() {
            return this.v;
        }

        public void setAllInPrivacy(int i) {
            this.allInPrivacy = i;
        }

        public void setDeveloper(String str) {
            this.developer = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPermissions(List<PermissionBean> list) {
            this.permissions = list;
        }

        public void setPkg(String str) {
            this.pkg = str;
        }

        public void setPrivacy(String str) {
            this.privacy = str;
        }

        public void setSize(String str) {
            this.size = str;
        }

        public void setV(String str) {
            this.v = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AttachBean {
        private String btnTxt;
        private String btnType;
        private String title;
        private String url;

        public String getBtnTxt() {
            return this.btnTxt;
        }

        public String getBtnType() {
            return this.btnType;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setBtnTxt(String str) {
            this.btnTxt = str;
        }

        public void setBtnType(String str) {
            this.btnType = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AuthorBean {
        private String head;
        private String name;

        public String getHead() {
            return this.head;
        }

        public String getName() {
            return this.name;
        }

        public void setHead(String str) {
            this.head = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BaiduAd {
        String baidu_ad_clickUrl;
        String baidu_ad_logo;
        String baidu_ad_text;

        public String getBaidu_ad_clickUrl() {
            return this.baidu_ad_clickUrl;
        }

        public String getBaidu_ad_logo() {
            return this.baidu_ad_logo;
        }

        public String getBaidu_ad_text() {
            return this.baidu_ad_text;
        }

        public void setBaidu_ad_clickUrl(String str) {
            this.baidu_ad_clickUrl = str;
        }

        public void setBaidu_ad_logo(String str) {
            this.baidu_ad_logo = str;
        }

        public void setBaidu_ad_text(String str) {
            this.baidu_ad_text = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DcBean {
        private List<ReportBean> attachClick;
        private List<ReportBean> bsClick;
        private List<ReportBean> click;
        private List<ReportBean> deep;
        private List<ReportBean> deeplink5s;
        private List<ReportBean> deeplinkError;
        private List<ReportBean> deeplinkInstall;
        private List<ReportBean> deeplinkUnstall;
        private List<ReportBean> downloadP;
        private List<ReportBean> downloadS;
        private List<ReportBean> downloaded;
        private List<ReportBean> downloading;
        private List<ReportBean> installPS;
        private List<ReportBean> installed;
        private List<ReportBean> inview;
        private List<ReportBean> inviewPercent;
        private List<ReportBean> show;
        private List<ReportBean> videoAutoS;
        private List<ReportBean> videoB;
        private List<ReportBean> videoE;
        private List<ReportBean> videoHandS;
        private List<ReportBean> videoPause;
        private List<ReportBean> videoS;

        public List<ReportBean> getAttachClick() {
            List<ReportBean> list = this.attachClick;
            return list == null ? new ArrayList() : list;
        }

        public List<ReportBean> getBsClick() {
            return this.bsClick;
        }

        public List<ReportBean> getClick() {
            return this.click;
        }

        public List<ReportBean> getDeep() {
            List<ReportBean> list = this.deep;
            return list == null ? new ArrayList() : list;
        }

        public List<ReportBean> getDeeplink5s() {
            return this.deeplink5s;
        }

        public List<ReportBean> getDeeplinkError() {
            return this.deeplinkError;
        }

        public List<ReportBean> getDeeplinkInstall() {
            return this.deeplinkInstall;
        }

        public List<ReportBean> getDownloadP() {
            return this.downloadP;
        }

        public List<ReportBean> getDownloadS() {
            return this.downloadS;
        }

        public List<ReportBean> getDownloaded() {
            return this.downloaded;
        }

        public List<ReportBean> getDownloading() {
            return this.downloading;
        }

        public List<ReportBean> getInstallPS() {
            return this.installPS;
        }

        public List<ReportBean> getInstalled() {
            return this.installed;
        }

        public List<ReportBean> getInview() {
            return this.inview;
        }

        public List<ReportBean> getInviewPercent() {
            return this.inviewPercent;
        }

        public List<ReportBean> getShow() {
            return this.show;
        }

        public List<ReportBean> getVideoAutoS() {
            return this.videoAutoS;
        }

        public List<ReportBean> getVideoB() {
            return this.videoB;
        }

        public List<ReportBean> getVideoE() {
            return this.videoE;
        }

        public List<ReportBean> getVideoHandS() {
            return this.videoHandS;
        }

        public List<ReportBean> getVideoPause() {
            return this.videoPause;
        }

        public List<ReportBean> getVideoS() {
            return this.videoS;
        }

        public DcBean setAttachClick(List<ReportBean> list) {
            this.attachClick = list;
            return this;
        }

        public void setBsClick(List<ReportBean> list) {
            this.bsClick = list;
        }

        public void setClick(List<ReportBean> list) {
            this.click = list;
        }

        public DcBean setDeep(List<ReportBean> list) {
            this.deep = list;
            return this;
        }

        public void setDownloadP(List<ReportBean> list) {
            this.downloadP = list;
        }

        public void setDownloadS(List<ReportBean> list) {
            this.downloadS = list;
        }

        public void setDownloaded(List<ReportBean> list) {
            this.downloaded = list;
        }

        public void setDownloading(List<ReportBean> list) {
            this.downloading = list;
        }

        public void setInstallPS(List<ReportBean> list) {
            this.installPS = list;
        }

        public void setInstalled(List<ReportBean> list) {
            this.installed = list;
        }

        public void setInview(List<ReportBean> list) {
            this.inview = list;
        }

        public void setInviewPercent(List<ReportBean> list) {
            this.inviewPercent = list;
        }

        public void setShow(List<ReportBean> list) {
            this.show = list;
        }

        public void setVideoB(List<ReportBean> list) {
            this.videoB = list;
        }

        public void setVideoE(List<ReportBean> list) {
            this.videoE = list;
        }

        public void setVideoS(List<ReportBean> list) {
            this.videoS = list;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DislikeBean {
        private String id;
        private String text;

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ExtBean {
        public String adxsid;
        public BaiduAd baidu_ad;
        public int dp_fallback_type;
        public String jumpMarket;
        public LXExtra lx;

        public BaiduAd getBaidu_ad() {
            return this.baidu_ad;
        }

        public int getDp_fallback_type() {
            return this.dp_fallback_type;
        }

        public String getJumpMarket() {
            return this.jumpMarket;
        }

        public void setBaidu_ad(BaiduAd baiduAd) {
            this.baidu_ad = baiduAd;
        }

        public void setDp_fallback_type(int i) {
            this.dp_fallback_type = i;
        }

        public void setJumpMarket(String str) {
            this.jumpMarket = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ImgsBean {
        private int h;
        private String url;
        private int w;

        public int getH() {
            return this.h;
        }

        public String getUrl() {
            return this.url;
        }

        public int getW() {
            return this.w;
        }

        public void setH(int i) {
            this.h = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setW(int i) {
            this.w = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ItemBean {
        private int action;
        private AppBean app;
        private AttachBean attach;
        private AuthorBean author;
        private String btnTxt;
        private String deeplinkUrl;
        private String dlText;
        private String dlUrl;
        private String downloadMd5;
        private int feedType;
        private List<ImgsBean> imgs;
        private int inviewPercent;
        private int isSupportMotion;
        private int likeCnt;
        private int macrosType;
        private int mdaType;
        private int motionDirection;
        private int motionStartTiming;
        private DcBean subDc;
        private int subTemp;
        private List<TagsBean> tags;
        private String title;
        private String uiTrackUrl;
        private String url;
        private VideoBean video;

        public int getAction() {
            return this.action;
        }

        public AppBean getApp() {
            return this.app;
        }

        public AttachBean getAttach() {
            return this.attach;
        }

        public AuthorBean getAuthor() {
            return this.author;
        }

        public String getBtnTxt() {
            return this.btnTxt;
        }

        public String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        public String getDlText() {
            return this.dlText;
        }

        public String getDlUrl() {
            return this.dlUrl;
        }

        public String getDownloadMd5() {
            return this.downloadMd5;
        }

        public int getFeedType() {
            return this.feedType;
        }

        public List<ImgsBean> getImgs() {
            return this.imgs;
        }

        public int getInviewPercent() {
            return this.inviewPercent;
        }

        public int getIsSupportMotion() {
            return this.isSupportMotion;
        }

        public int getLikeCnt() {
            return this.likeCnt;
        }

        public int getMacrosType() {
            return this.macrosType;
        }

        public int getMdaType() {
            return this.mdaType;
        }

        public int getMotionDirection() {
            return this.motionDirection;
        }

        public int getMotionStartTiming() {
            return this.motionStartTiming;
        }

        public DcBean getSubDc() {
            return this.subDc;
        }

        public int getSubTemp() {
            return this.subTemp;
        }

        public List<TagsBean> getTags() {
            return this.tags;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUiTrackUrl() {
            return this.uiTrackUrl;
        }

        public String getUrl() {
            return this.url;
        }

        public VideoBean getVideo() {
            return this.video;
        }

        public void setAction(int i) {
            this.action = i;
        }

        public void setApp(AppBean appBean) {
            this.app = appBean;
        }

        public void setAttach(AttachBean attachBean) {
            this.attach = attachBean;
        }

        public void setAuthor(AuthorBean authorBean) {
            this.author = authorBean;
        }

        public void setBtnTxt(String str) {
            this.btnTxt = str;
        }

        public void setDeeplinkUrl(String str) {
            this.deeplinkUrl = str;
        }

        public void setDlText(String str) {
            this.dlText = str;
        }

        public void setDlUrl(String str) {
            this.dlUrl = str;
        }

        public void setDownloadMd5(String str) {
            this.downloadMd5 = str;
        }

        public void setFeedType(int i) {
            this.feedType = i;
        }

        public void setImgs(List<ImgsBean> list) {
            this.imgs = list;
        }

        public void setInviewPercent(int i) {
            this.inviewPercent = i;
        }

        public void setIsSupportMotion(int i) {
            this.isSupportMotion = i;
        }

        public void setLikeCnt(int i) {
            this.likeCnt = i;
        }

        public void setMacrosType(int i) {
            this.macrosType = i;
        }

        public void setMdaType(int i) {
            this.mdaType = i;
        }

        public void setMotionDirection(int i) {
            this.motionDirection = i;
        }

        public void setMotionStartTiming(int i) {
            this.motionStartTiming = i;
        }

        public void setSubDc(DcBean dcBean) {
            this.subDc = dcBean;
        }

        public void setSubTemp(int i) {
            this.subTemp = i;
        }

        public void setTags(List<TagsBean> list) {
            this.tags = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUiTrackUrl(String str) {
            this.uiTrackUrl = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVideo(VideoBean videoBean) {
            this.video = videoBean;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class LXExtra {
        int id;
        int lr;
        int rr;
        int t;

        public int getId() {
            return this.id;
        }

        public int getLr() {
            return this.lr;
        }

        public int getRr() {
            return this.rr;
        }

        public int getT() {
            return this.t;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setLr(int i) {
            this.lr = i;
        }

        public void setRr(int i) {
            this.rr = i;
        }

        public void setT(int i) {
            this.t = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PermissionBean {
        private String desc;
        private String name;

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ReportBean {
        private String first;
        private String other;
        private boolean pos;
        protected String url;

        public String getFirst() {
            return this.first;
        }

        public String getOther() {
            return this.other;
        }

        public boolean getPos() {
            return this.pos;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isPos() {
            return this.pos;
        }

        public void setFirst(String str) {
            this.first = str;
        }

        public void setOther(String str) {
            this.other = str;
        }

        public void setPos(boolean z) {
            this.pos = z;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ResultBean {
        private int category;
        private DcBean dc;
        private List<DislikeBean> dislike;
        private String dsp;
        private ExtBean ext;
        private String id;
        private int isNative;
        private List<ItemBean> item;
        private String matFeaMd5;
        private int mdaType;
        private int preload;
        private boolean repeat;
        private int template;
        private int type;
        private int validPeriod;
        private int vdetailType;

        public int getCategory() {
            return this.category;
        }

        public DcBean getDc() {
            return this.dc;
        }

        public List<DislikeBean> getDislike() {
            return this.dislike;
        }

        public String getDsp() {
            return this.dsp;
        }

        public ExtBean getExt() {
            return this.ext;
        }

        public String getId() {
            return this.id;
        }

        public int getIsNative() {
            return this.isNative;
        }

        public List<ItemBean> getItem() {
            return this.item;
        }

        public String getMatFeaMd5() {
            return this.matFeaMd5;
        }

        public int getMdaType() {
            return this.mdaType;
        }

        public int getPreload() {
            return this.preload;
        }

        public boolean getRepeat() {
            return this.repeat;
        }

        public int getTemplate() {
            return this.template;
        }

        public int getType() {
            return this.type;
        }

        public int getValidPeriod() {
            return this.validPeriod;
        }

        public int getVdetailType() {
            return this.vdetailType;
        }

        public void setCategory(int i) {
            this.category = i;
        }

        public void setDc(DcBean dcBean) {
            this.dc = dcBean;
        }

        public void setDislike(List<DislikeBean> list) {
            this.dislike = list;
        }

        public void setDsp(String str) {
            this.dsp = str;
        }

        public void setExt(ExtBean extBean) {
            this.ext = extBean;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsNative(int i) {
            this.isNative = i;
        }

        public void setItem(List<ItemBean> list) {
            this.item = list;
        }

        public void setMatFeaMd5(String str) {
            this.matFeaMd5 = str;
        }

        public void setMdaType(int i) {
            this.mdaType = i;
        }

        public void setPreload(int i) {
            this.preload = i;
        }

        public void setRepeat(boolean z) {
            this.repeat = z;
        }

        public void setTemplate(int i) {
            this.template = i;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setValidPeriod(int i) {
            this.validPeriod = i;
        }

        public void setVdetailType(int i) {
            this.vdetailType = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TagsBean {
        private int id;
        private String text;

        public int getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class VideoBean {
        private int dura;
        private String playCnt;
        private double size;
        private String src;
        private String type;
        private String vid;

        public int getDura() {
            return this.dura;
        }

        public String getPlayCnt() {
            return this.playCnt;
        }

        public double getSize() {
            return this.size;
        }

        public String getSrc() {
            return this.src;
        }

        public String getType() {
            return this.type;
        }

        public String getVid() {
            return this.vid;
        }

        public void setDura(int i) {
            this.dura = i;
        }

        public void setPlayCnt(String str) {
            this.playCnt = str;
        }

        public void setSize(double d) {
            this.size = d;
        }

        public void setSrc(String str) {
            this.src = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVid(String str) {
            this.vid = str;
        }
    }

    private void addStatUrl(List<String> list, List<ReportBean> list2) {
        if (list == null || list2 == null) {
            return;
        }
        for (ReportBean reportBean : list2) {
            if (!TextUtils.isEmpty(reportBean.getUrl())) {
                list.add(reportBean.getUrl());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0460  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<s7> covertToAdxBean() {
        String text;
        List<ImgsBean> imgs;
        VideoBean video;
        AppBean app;
        AuthorBean author;
        ExtBean ext;
        az4 az4Var;
        DcBean dc;
        DcBean subDc;
        Iterator<ResultBean> it;
        ArrayList arrayList;
        ItemBean itemBean;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        s7 s7Var;
        AttachBean attach;
        ArrayList arrayList6 = new ArrayList();
        List<ResultBean> list = this.result;
        if (list != null && list.size() > 0) {
            Iterator<ResultBean> it2 = this.result.iterator();
            while (it2.hasNext()) {
                ResultBean next = it2.next();
                if (next != null && next.getItem() != null && next.getItem().size() > 0) {
                    s7 s7Var2 = new s7();
                    ItemBean itemBean2 = next.getItem().get(0);
                    s7Var2.W(itemBean2.action);
                    List<TagsBean> tags = itemBean2.getTags();
                    if (tags == null || tags.size() <= 0) {
                        text = "";
                        s7Var2.o0(text);
                        s7Var2.k0(itemBean2.getDownloadMd5());
                        s7Var2.e0(System.currentTimeMillis());
                        s7Var2.q0(next.validPeriod);
                        s7Var2.l0(getPvid());
                        s7Var2.n0(next.getId());
                        s7Var2.p0(next.template);
                        s7Var2.i0(next.matFeaMd5);
                        s7Var2.f0(next.getDsp());
                        qd3 qd3Var = new qd3();
                        qd3Var.t(itemBean2.getTitle());
                        qd3Var.s(itemBean2.getMacrosType());
                        qd3Var.q(itemBean2.getInviewPercent());
                        qd3Var.l("");
                        qd3Var.r(itemBean2.getUrl());
                        qd3Var.m(itemBean2.getDeeplinkUrl());
                        qd3Var.n(itemBean2.getDlUrl());
                        imgs = itemBean2.getImgs();
                        if (imgs != null) {
                            ArrayList arrayList7 = new ArrayList();
                            if (imgs.size() > 0) {
                                for (ImgsBean imgsBean : imgs) {
                                    if (imgsBean != null && !TextUtils.isEmpty(imgsBean.getUrl())) {
                                        arrayList7.add(imgsBean.getUrl());
                                    }
                                }
                            }
                            qd3Var.p(arrayList7);
                        }
                        video = itemBean2.getVideo();
                        if (video != null) {
                            qd3.a aVar = new qd3.a();
                            aVar.i(video.getSrc());
                            aVar.h((int) (video.getSize() * 1024.0d * 1024.0d));
                            aVar.g(video.getDura());
                            if (imgs != null && imgs.size() > 0) {
                                aVar.e(imgs.get(0).getUrl());
                                aVar.f(imgs.get(0).getW());
                                aVar.d(imgs.get(0).getH());
                            }
                            qd3Var.u(aVar);
                        }
                        s7Var2.j0(qd3Var);
                        app = itemBean2.getApp();
                        if (app != null) {
                            w5 w5Var = new w5();
                            w5Var.c(app.getIcon());
                            w5Var.d(app.getName());
                            w5Var.g(app.getSize());
                            w5Var.i(app.getPkg());
                            w5Var.h(app.getV());
                            w5Var.a(app.getAllInPrivacy());
                            w5Var.b(app.getDeveloper());
                            w5Var.f(app.getPrivacy());
                            w5Var.e(app.getPermissions());
                            s7Var2.b0(w5Var);
                        }
                        author = itemBean2.getAuthor();
                        if (author != null) {
                            x5 x5Var = new x5();
                            x5Var.a(author.getHead());
                            x5Var.b(author.getName());
                            s7Var2.X(x5Var);
                        }
                        ext = next.getExt();
                        if (ext != null) {
                            gs1 gs1Var = new gs1();
                            gs1Var.e(ext.dp_fallback_type);
                            gs1Var.f(ext.jumpMarket);
                            gs1Var.c(ext.adxsid);
                            gs1.a aVar2 = new gs1.a();
                            BaiduAd baiduAd = ext.baidu_ad;
                            if (baiduAd != null) {
                                aVar2.e(baiduAd.baidu_ad_logo);
                                aVar2.f(ext.baidu_ad.baidu_ad_text);
                                aVar2.d(ext.baidu_ad.baidu_ad_clickUrl);
                                gs1Var.d(aVar2);
                            }
                            gs1Var.g(ext.lx);
                            s7Var2.g0(gs1Var);
                        }
                        az4Var = new az4();
                        dc = next.getDc();
                        subDc = itemBean2.getSubDc();
                        if (dc == null || subDc != null) {
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = new ArrayList();
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = new ArrayList();
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = new ArrayList();
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = new ArrayList();
                            it = it2;
                            ArrayList arrayList16 = new ArrayList();
                            arrayList = arrayList6;
                            ArrayList arrayList17 = new ArrayList();
                            itemBean = itemBean2;
                            ArrayList arrayList18 = new ArrayList();
                            ArrayList arrayList19 = new ArrayList();
                            ArrayList arrayList20 = new ArrayList();
                            ArrayList arrayList21 = new ArrayList();
                            ArrayList arrayList22 = new ArrayList();
                            ArrayList arrayList23 = new ArrayList();
                            ArrayList arrayList24 = new ArrayList();
                            ArrayList arrayList25 = new ArrayList();
                            ArrayList arrayList26 = new ArrayList();
                            if (dc == null) {
                                addStatUrl(arrayList8, dc.getClick());
                                addStatUrl(arrayList9, dc.getInview());
                                addStatUrl(arrayList10, dc.getShow());
                                addStatUrl(arrayList11, dc.getDownloaded());
                                addStatUrl(arrayList12, dc.getInstalled());
                                addStatUrl(arrayList13, dc.getDownloading());
                                addStatUrl(arrayList14, dc.getVideoS());
                                addStatUrl(arrayList15, dc.getVideoB());
                                addStatUrl(arrayList16, dc.getVideoE());
                                addStatUrl(arrayList17, dc.getDeep());
                                addStatUrl(arrayList18, dc.getAttachClick());
                                addStatUrl(arrayList19, dc.getDownloadP());
                                addStatUrl(arrayList20, dc.getBsClick());
                                arrayList2 = arrayList20;
                                addStatUrl(arrayList21, dc.getVideoAutoS());
                                addStatUrl(arrayList22, dc.getVideoHandS());
                                addStatUrl(arrayList15, dc.getVideoPause());
                                addStatUrl(arrayList23, dc.getDeeplinkInstall());
                                addStatUrl(arrayList24, dc.getDeeplink5s());
                                arrayList3 = arrayList25;
                                addStatUrl(arrayList3, dc.getDeeplinkError());
                                arrayList26 = arrayList26;
                                addStatUrl(arrayList26, dc.getInviewPercent());
                            } else {
                                arrayList2 = arrayList20;
                                arrayList3 = arrayList25;
                            }
                            if (subDc == null) {
                                addStatUrl(arrayList8, subDc.getClick());
                                addStatUrl(arrayList9, subDc.getInview());
                                addStatUrl(arrayList10, subDc.getShow());
                                addStatUrl(arrayList11, subDc.getDownloaded());
                                addStatUrl(arrayList12, subDc.getInstalled());
                                addStatUrl(arrayList13, subDc.getDownloading());
                                addStatUrl(arrayList14, subDc.getVideoS());
                                addStatUrl(arrayList15, subDc.getVideoB());
                                addStatUrl(arrayList16, subDc.getVideoE());
                                addStatUrl(arrayList17, subDc.getDeep());
                                addStatUrl(arrayList18, subDc.getAttachClick());
                                addStatUrl(arrayList19, subDc.getDownloadP());
                                arrayList4 = arrayList17;
                                addStatUrl(arrayList2, subDc.getBsClick());
                                addStatUrl(arrayList21, subDc.getVideoAutoS());
                                addStatUrl(arrayList22, subDc.getVideoHandS());
                                addStatUrl(arrayList15, subDc.getVideoPause());
                                addStatUrl(arrayList23, subDc.getDeeplinkInstall());
                                arrayList5 = arrayList24;
                                addStatUrl(arrayList5, subDc.getDeeplink5s());
                                addStatUrl(arrayList3, subDc.getDeeplinkError());
                                addStatUrl(arrayList26, subDc.getInviewPercent());
                            } else {
                                arrayList4 = arrayList17;
                                arrayList5 = arrayList24;
                            }
                            az4Var.f(arrayList8);
                            az4Var.a(arrayList18);
                            az4Var.n(arrayList9);
                            az4Var.s(arrayList10);
                            az4Var.k(arrayList11);
                            az4Var.b(arrayList11);
                            az4Var.l(arrayList12);
                            az4Var.c(arrayList12);
                            az4Var.t(arrayList13);
                            az4Var.d(arrayList13);
                            az4Var.o(arrayList19);
                            az4Var.p(arrayList14);
                            az4Var.r(arrayList15);
                            az4Var.q(arrayList16);
                            az4Var.j(arrayList4);
                            az4Var.e(arrayList2);
                            az4Var.u(arrayList21);
                            az4Var.v(arrayList22);
                            az4Var.g(arrayList23);
                            az4Var.i(arrayList5);
                            az4Var.h(arrayList3);
                            az4Var.m(arrayList26);
                            s7Var = s7Var2;
                            s7Var.m0(az4Var);
                        } else {
                            arrayList = arrayList6;
                            it = it2;
                            s7Var = s7Var2;
                            itemBean = itemBean2;
                        }
                        attach = itemBean.getAttach();
                        if (attach != null) {
                            cj cjVar = new cj();
                            cjVar.l(attach.getTitle());
                            if (!TextUtils.isEmpty(attach.getBtnType())) {
                                if ("1".equals(attach.getBtnType())) {
                                    cjVar.j(1);
                                } else if ("3".equals(attach.getBtnType())) {
                                    cjVar.j(2);
                                }
                            }
                            cjVar.i(attach.getBtnTxt());
                            cjVar.h(attach.getUrl());
                            cjVar.g(itemBean.getDeeplinkUrl());
                            s7Var.c0(cjVar);
                        }
                        s7Var.e0(System.currentTimeMillis());
                        ArrayList arrayList27 = arrayList;
                        arrayList27.add(s7Var);
                        arrayList6 = arrayList27;
                        it2 = it;
                    } else {
                        for (TagsBean tagsBean : tags) {
                            if (tagsBean != null && !TextUtils.isEmpty(tagsBean.getText()) && !"广告".equals(tagsBean.getText())) {
                                text = tagsBean.getText();
                                break;
                            }
                        }
                        text = "";
                        s7Var2.o0(text);
                        s7Var2.k0(itemBean2.getDownloadMd5());
                        s7Var2.e0(System.currentTimeMillis());
                        s7Var2.q0(next.validPeriod);
                        s7Var2.l0(getPvid());
                        s7Var2.n0(next.getId());
                        s7Var2.p0(next.template);
                        s7Var2.i0(next.matFeaMd5);
                        s7Var2.f0(next.getDsp());
                        qd3 qd3Var2 = new qd3();
                        qd3Var2.t(itemBean2.getTitle());
                        qd3Var2.s(itemBean2.getMacrosType());
                        qd3Var2.q(itemBean2.getInviewPercent());
                        qd3Var2.l("");
                        qd3Var2.r(itemBean2.getUrl());
                        qd3Var2.m(itemBean2.getDeeplinkUrl());
                        qd3Var2.n(itemBean2.getDlUrl());
                        imgs = itemBean2.getImgs();
                        if (imgs != null) {
                        }
                        video = itemBean2.getVideo();
                        if (video != null) {
                        }
                        s7Var2.j0(qd3Var2);
                        app = itemBean2.getApp();
                        if (app != null) {
                        }
                        author = itemBean2.getAuthor();
                        if (author != null) {
                        }
                        ext = next.getExt();
                        if (ext != null) {
                        }
                        az4Var = new az4();
                        dc = next.getDc();
                        subDc = itemBean2.getSubDc();
                        if (dc == null) {
                            ArrayList arrayList82 = new ArrayList();
                            ArrayList arrayList92 = new ArrayList();
                            ArrayList arrayList102 = new ArrayList();
                            ArrayList arrayList112 = new ArrayList();
                            ArrayList arrayList122 = new ArrayList();
                            ArrayList arrayList132 = new ArrayList();
                            ArrayList arrayList142 = new ArrayList();
                            ArrayList arrayList152 = new ArrayList();
                            it = it2;
                            ArrayList arrayList162 = new ArrayList();
                            arrayList = arrayList6;
                            ArrayList arrayList172 = new ArrayList();
                            itemBean = itemBean2;
                            ArrayList arrayList182 = new ArrayList();
                            ArrayList arrayList192 = new ArrayList();
                            ArrayList arrayList202 = new ArrayList();
                            ArrayList arrayList212 = new ArrayList();
                            ArrayList arrayList222 = new ArrayList();
                            ArrayList arrayList232 = new ArrayList();
                            ArrayList arrayList242 = new ArrayList();
                            ArrayList arrayList252 = new ArrayList();
                            ArrayList arrayList262 = new ArrayList();
                            if (dc == null) {
                            }
                            if (subDc == null) {
                            }
                            az4Var.f(arrayList82);
                            az4Var.a(arrayList182);
                            az4Var.n(arrayList92);
                            az4Var.s(arrayList102);
                            az4Var.k(arrayList112);
                            az4Var.b(arrayList112);
                            az4Var.l(arrayList122);
                            az4Var.c(arrayList122);
                            az4Var.t(arrayList132);
                            az4Var.d(arrayList132);
                            az4Var.o(arrayList192);
                            az4Var.p(arrayList142);
                            az4Var.r(arrayList152);
                            az4Var.q(arrayList162);
                            az4Var.j(arrayList4);
                            az4Var.e(arrayList2);
                            az4Var.u(arrayList212);
                            az4Var.v(arrayList222);
                            az4Var.g(arrayList232);
                            az4Var.i(arrayList5);
                            az4Var.h(arrayList3);
                            az4Var.m(arrayList262);
                            s7Var = s7Var2;
                            s7Var.m0(az4Var);
                            attach = itemBean.getAttach();
                            if (attach != null) {
                            }
                            s7Var.e0(System.currentTimeMillis());
                            ArrayList arrayList272 = arrayList;
                            arrayList272.add(s7Var);
                            arrayList6 = arrayList272;
                            it2 = it;
                        }
                    }
                }
            }
        }
        return arrayList6;
    }

    public String getPvid() {
        return this.pvid;
    }

    public List<ResultBean> getResult() {
        return this.result;
    }

    public int getRetCd() {
        return this.retCd;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public void setPvid(String str) {
        this.pvid = str;
    }

    public void setResult(List<ResultBean> list) {
        this.result = list;
    }

    public void setRetCd(int i) {
        this.retCd = i;
    }

    public void setTemplateId(int i) {
        this.templateId = i;
    }
}
