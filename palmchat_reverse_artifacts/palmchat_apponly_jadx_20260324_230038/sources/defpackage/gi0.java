package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.media.roomchatdemo.videocallgroup.userInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class gi0 {
    public static gi0 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Long, Long> f17728a = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17729a = 0;
        public long b = 0;
        public long c = 0;
        public long d = 0;
        public int e = 0;
        public int f = 0;
        public long g = 0;
        public int h = 1;
        public List<userInfo> i;

        public a() {
        }
    }

    public static gi0 a() {
        if (b == null) {
            b = new gi0();
        }
        return b;
    }

    public void b(String str) {
        a aVarC = c(str);
        if (aVarC != null && aVarC.f == 4) {
            this.f17728a.put(Long.valueOf(aVarC.b), Long.valueOf(aVarC.c));
        }
        if (this.f17728a.size() > 100) {
            this.f17728a.remove(0);
        }
    }

    public final a c(String str) {
        if (str == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.i = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            try {
                aVar.f17729a = jSONObject.getInt("cmd");
            } catch (Exception unused) {
            }
            try {
                aVar.b = jSONObject.getLong("roomid");
            } catch (Exception unused2) {
            }
            try {
                aVar.c = jSONObject.getLong("groupid");
            } catch (Exception unused3) {
            }
            try {
                aVar.d = jSONObject.getLong("roomtoken");
            } catch (Exception unused4) {
            }
            try {
                aVar.e = jSONObject.getInt("msgtype");
            } catch (Exception unused5) {
            }
            try {
                aVar.f = jSONObject.getInt("retcode");
            } catch (Exception unused6) {
            }
            try {
                aVar.h = jSONObject.getInt("expire");
            } catch (Exception unused7) {
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("roominfo").getJSONArray("userlist");
                for (int i = 0; i < jSONArray.length(); i++) {
                    long j = jSONArray.getJSONObject(i).getLong(DeviceInfoUtil.UID_TAG);
                    userInfo userinfo = new userInfo();
                    userinfo.id = j;
                    aVar.i.add(userinfo);
                }
            } catch (Exception unused8) {
            }
            return aVar;
        } catch (Exception unused9) {
            return null;
        }
    }

    public boolean d(long j) {
        Iterator<Long> it = this.f17728a.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().longValue() == j) {
                return true;
            }
        }
        return false;
    }
}
