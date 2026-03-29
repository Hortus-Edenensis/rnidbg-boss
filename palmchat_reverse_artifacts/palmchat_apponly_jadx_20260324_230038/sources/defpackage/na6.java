package defpackage;

import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.media.roomchat.ZMRtcParseRoomInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.groupvideochat.vo.UserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class na6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19474a;

    public static void a(long j, long j2) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).toString();
            r(string, "80D20");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D20", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(long j, long j2, long j3, long j4) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).put("duration", j4).toString();
            r(string, "80D23");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D23", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void c(long j, long j2, long[] jArr) {
        if (jArr == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (long j3 : jArr) {
                jSONArray.put(j3);
            }
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("userlist", jSONArray).toString();
            r(string, "80D22");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D22", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void d(long j, long j2, long j3) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D33");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D33", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void e(long j, long j2, long j3) {
        if (f19474a == j3) {
            return;
        }
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D31");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D31", "1", null, string);
            f19474a = j3;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void f(long j, long j2, long j3) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D34");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D34", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void g(long j, ZMRtcParseRoomInfo zMRtcParseRoomInfo) {
        if (zMRtcParseRoomInfo == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            long j2 = 0;
            for (int i = 0; i < zMRtcParseRoomInfo.mUserList.size(); i++) {
                ZMRtcParseRoomInfo.UserItem userItem = zMRtcParseRoomInfo.mUserList.get(i);
                long j3 = userItem.mUserID;
                if (j3 == j) {
                    j2 = userItem.mInviterID;
                } else {
                    jSONArray.put(j3);
                }
            }
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, zMRtcParseRoomInfo.mGroupId).put("roomid", zMRtcParseRoomInfo.mRoomid).put("inviter", j2).put("userlist", jSONArray).toString();
            r(string, "80D30");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D30", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void h(long j, long j2, long j3) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D32");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D32", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void i(long j, long j2, String str, List<UserInfo> list) {
        if (list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<UserInfo> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(Long.parseLong(it.next().uid));
            }
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", str).put("userlist", jSONArray).toString();
            r(string, "80D40");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D40", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void j(long j, long j2, long j3) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D41");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D41", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void k(long j, long j2, long j3, boolean z) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            String str = z ? "5" : "6";
            r(string, "80D01");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D01", str, null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void l(long j, ZMRtcParseRoomInfo zMRtcParseRoomInfo, int i) {
        if (zMRtcParseRoomInfo == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            long j2 = 0;
            for (int i2 = 0; i2 < zMRtcParseRoomInfo.mUserList.size(); i2++) {
                ZMRtcParseRoomInfo.UserItem userItem = zMRtcParseRoomInfo.mUserList.get(i2);
                long j3 = userItem.mUserID;
                if (j3 == j) {
                    j2 = userItem.mInviterID;
                } else {
                    jSONArray.put(j3);
                }
            }
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, zMRtcParseRoomInfo.mGroupId).put("roomid", zMRtcParseRoomInfo.mRoomid).put("inviter", j2).put("reason", i).toString();
            r(string, "80D04");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D04", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void m(long j, long j2, long j3) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            r(string, "80D06");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D06", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void n(long j, long j2, long j3, long[] jArr) {
        if (jArr == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (long j4 : jArr) {
                jSONArray.put(j4);
            }
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).put("userlist", jSONArray).toString();
            r(string, "80D05");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D05", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void o(long j, long j2, long j3, long j4) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).put("duration", j4).toString();
            r(string, "80D02");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D02", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void p(long j, long j2, long j3, long j4) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).put("duration", j4).toString();
            r(string, "80D03");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D03", "1", null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void q(long j, long j2, long j3, boolean z) {
        try {
            String string = new JSONObject().put(bd.m, j).put(EventParams.KEY_GROUP, j2).put("roomid", j3).toString();
            String str = z ? "5" : "6";
            r(string, "80D00");
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "80D00", str, null, string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void r(String str, String str2) {
        LogUtil.i("VideoCallGroupLoggingPoint", "action:" + str2 + ", " + str);
    }
}
