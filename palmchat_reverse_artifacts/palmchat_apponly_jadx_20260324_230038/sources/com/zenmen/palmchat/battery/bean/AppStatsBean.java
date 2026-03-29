package com.zenmen.palmchat.battery.bean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppStatsBean {
    public RunTime runTime;
    public StatTime statTime;

    /* JADX INFO: compiled from: SearchBox */
    public static class RunTime {
        public long bg;
        public long fg;
        public long fgSrv;
        public String time;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class StatTime {
        public int bg;
        public int devCharging;
        public int devScreenOff;
        public int fg;
        public int fgSrv;
        public String sceneTop1;
        public String sceneTop2;
        public String time;
    }
}
