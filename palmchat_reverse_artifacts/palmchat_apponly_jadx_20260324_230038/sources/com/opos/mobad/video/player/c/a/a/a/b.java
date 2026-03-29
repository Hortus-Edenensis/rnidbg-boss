package com.opos.mobad.video.player.c.a.a.a;

import androidx.core.app.NotificationCompat;
import com.baidu.location.LocationConst;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static String e = "TTNativeMessage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10283a;
    public String b;
    public String c;
    public a d;
    private JSONObject f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10284a = 1;
        public JSONObject b;
        private JSONObject c;

        public JSONObject a() {
            if (this.c == null) {
                this.c = new JSONObject();
            }
            try {
                this.c.put("code", this.f10284a);
                JSONObject jSONObject = this.c;
                JSONObject jSONObject2 = this.b;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject.put("__data", jSONObject2);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.c;
        }

        public String toString() {
            return "TTNativeMessageParam{mCode=" + this.f10284a + ", mData=" + this.b + '}';
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0812b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10285a;
        public long b;
        private JSONObject c;

        public C0812b(int i, long j) {
            this.f10285a = i;
            this.b = j;
        }

        public JSONObject a() {
            if (this.c == null) {
                this.c = new JSONObject();
            }
            try {
                this.c.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f10285a);
                this.c.put("time", this.b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.c;
        }

        public String toString() {
            return "VideoStateParam{mState=" + this.f10285a + ", mTime=" + this.b + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10286a;
        private JSONObject b;

        public c(int i) {
            this.f10286a = i;
        }

        public JSONObject a() {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            try {
                this.b.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f10286a);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d(b.e, "toJson error", th);
            }
            return this.b;
        }

        public String toString() {
            return "VisibilityStateParams{mVisibleState=" + this.f10286a + '}';
        }
    }

    public b(com.opos.mobad.video.player.c.a.a.a.a aVar) {
        this.f10283a = NotificationCompat.CATEGORY_CALL;
        this.f10283a = aVar != null ? aVar.d : "event";
        this.b = aVar != null ? aVar.e : "";
    }

    public JSONObject a() {
        if (this.f == null) {
            this.f = new JSONObject();
        }
        try {
            this.f.put("__msg_type", this.f10283a);
            JSONObject jSONObject = this.f;
            a aVar = this.d;
            jSONObject.put("__params", aVar != null ? aVar.a() : new JSONObject());
            this.f.put("__callback_id", this.b);
            this.f.put("__event_id", this.c);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d(e, "toJson error", th);
        }
        return this.f;
    }

    public String toString() {
        return "TTNativeMessage{mMsgType='" + this.f10283a + "', mCallbackId='" + this.b + "', mEventId='" + this.c + "', mParam=" + this.d + '}';
    }
}
