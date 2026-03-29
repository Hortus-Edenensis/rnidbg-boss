package com.volcengine.lxvertc.videocall.call;

import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import defpackage.jy;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum CallCmd {
    DIAL("dial"),
    JOIN("join"),
    CANCEL("cancel"),
    ACCEPT("accept"),
    ONRTCROOMSTATECHANGED("ONRTCROOMSTATECHANGED"),
    REFUSE("refuse"),
    TIME_OUT("time_out"),
    HANGUP("hangup");

    public final String name;

    CallCmd(String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CallType f11317a;
        public String b;
        public ArrayList<RoomUserInfo> c;
        public jy d;
        public RoomSDKInfo e;
        public boolean f = true;

        public a() {
        }

        public a(jy jyVar) {
            this.d = jyVar;
        }
    }
}
