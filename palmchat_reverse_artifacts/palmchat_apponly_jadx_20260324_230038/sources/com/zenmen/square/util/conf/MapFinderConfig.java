package com.zenmen.square.util.conf;

import androidx.annotation.Keep;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class MapFinderConfig {
    public static final boolean isTest = false;
    public Scaling android_defaultscaling;
    public int column;
    public MainEntry main_circleentry;
    public FinderButton mapFinder_button;
    public NotmoveOperationText notmove_operation_text;
    public RecommendEntry pagelffriend_recommend_cardentry;
    public OldNearbyEntry pageoldnearby_topentry;
    public int row;
    public FinderButton setanotherme_button;
    public SetanothermeNearbyentry setanotherme_nearbyentry;
    public SetPopUp setanotherme_setpopup;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class FinderButton {
        public String intro;
        public String newfreeintro;
        public String newintro;
        public String title;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class MainEntry {
        public ArrayList<String> bubble_text;
        public String entry_pic;
        public int standingtime = 6;
        public int fre = 86400;
        public boolean pagelffriend_nearby_showstate = true;
        public boolean oldnearby_showstate = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class NotmoveOperationText {
        public ArrayList<String> text;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class OldNearbyEntry {
        public int fre;
        public boolean showstate;
        public ArrayList<String> text;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class RecommendEntry {
        public String button_text;
        public int order = -1;
        public String pic;
        public String text1;
        public String text2;
        public String text3;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Scaling {
        public int ratio;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SetPopUp {
        public String pic1;
        public String pic2;
        public String pic3;
        public String set_button;
        public String title;
        public String vice_intro;
        public String vice_intro_v2;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SetanothermeNearbyentry {
        public String title;
    }

    public static MapFinderConfig getDefaultConfig() {
        MapFinderConfig mapFinderConfig = new MapFinderConfig();
        RecommendEntry recommendEntry = new RecommendEntry();
        mapFinderConfig.pagelffriend_recommend_cardentry = recommendEntry;
        recommendEntry.order = -1;
        MainEntry mainEntry = new MainEntry();
        mapFinderConfig.main_circleentry = mainEntry;
        mainEntry.pagelffriend_nearby_showstate = true;
        mainEntry.oldnearby_showstate = false;
        OldNearbyEntry oldNearbyEntry = new OldNearbyEntry();
        mapFinderConfig.pageoldnearby_topentry = oldNearbyEntry;
        oldNearbyEntry.showstate = false;
        return mapFinderConfig;
    }

    public static MapFinderConfig getTestConfig() {
        MapFinderConfig mapFinderConfig = new MapFinderConfig();
        RecommendEntry recommendEntry = new RecommendEntry();
        mapFinderConfig.pagelffriend_recommend_cardentry = recommendEntry;
        recommendEntry.order = 3;
        recommendEntry.text1 = "的发送到发达时";
        recommendEntry.text2 = "i哦加阿松地方骄傲地方";
        recommendEntry.text3 = "阿斯顿发送到发";
        recommendEntry.button_text = "发送到发顺丰";
        recommendEntry.pic = "https://img.soogif.com/t3Mr0ZWOqnt7paPdPDyBKlLYPQJjkGSX.gif";
        MainEntry mainEntry = new MainEntry();
        mapFinderConfig.main_circleentry = mainEntry;
        mainEntry.bubble_text = new ArrayList<>();
        mapFinderConfig.main_circleentry.bubble_text.add("发送到发达的发送到发送房东");
        mapFinderConfig.main_circleentry.bubble_text.add("就哦加啤酒啤酒啤酒破i");
        MainEntry mainEntry2 = mapFinderConfig.main_circleentry;
        mainEntry2.fre = 10;
        mainEntry2.standingtime = 6;
        mainEntry2.entry_pic = "https://img.soogif.com/t3Mr0ZWOqnt7paPdPDyBKlLYPQJjkGSX.gif";
        mainEntry2.pagelffriend_nearby_showstate = true;
        mainEntry2.oldnearby_showstate = true;
        OldNearbyEntry oldNearbyEntry = new OldNearbyEntry();
        mapFinderConfig.pageoldnearby_topentry = oldNearbyEntry;
        oldNearbyEntry.showstate = true;
        oldNearbyEntry.fre = 10;
        oldNearbyEntry.text = new ArrayList<>();
        mapFinderConfig.pageoldnearby_topentry.text.add("发送到发达的发送到发送房东");
        mapFinderConfig.pageoldnearby_topentry.text.add("就哦加啤酒啤酒啤酒破i");
        return mapFinderConfig;
    }
}
