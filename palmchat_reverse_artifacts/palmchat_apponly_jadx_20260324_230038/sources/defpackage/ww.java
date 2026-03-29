package defpackage;

import android.text.TextUtils;
import com.opos.mobad.activity.VideoActivity;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.rtc.bean.RoomInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ww {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<RoomInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21813a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ rx e;

        public a(String str, String str2, int i, String str3, rx rxVar) {
            this.f21813a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = rxVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("groupId", this.f21813a);
            map.put("domain", this.b);
            map.put("biz", Integer.valueOf(this.c));
            map.put("roomId", this.d);
            return sw4.b(1, nl0.z + "/rtc.join.room.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
            rx rxVar = this.e;
            if (rxVar != null) {
                rxVar.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21814a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;
        public final /* synthetic */ rx e;

        public b(String str, int i, String str2, List list, rx rxVar) {
            this.f21814a = str;
            this.b = i;
            this.c = str2;
            this.d = list;
            this.e = rxVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("roomId", this.f21814a);
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, Integer.valueOf(this.b));
            if (!TextUtils.isEmpty(this.c)) {
                map.put("groupId", this.c);
            }
            List list = this.d;
            if (list != null) {
                map.put("members", list);
            }
            return sw4.b(1, nl0.z + "/rtc.action.room.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            rx rxVar = this.e;
            if (rxVar != null) {
                rxVar.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<RoomInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21815a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List e;
        public final /* synthetic */ rx f;

        public c(String str, String str2, int i, int i2, List list, rx rxVar) {
            this.f21815a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = list;
            this.f = rxVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(this.f21815a)) {
                map.put("groupId", this.f21815a);
            }
            map.put("domain", this.b);
            map.put("bizType", Integer.valueOf(this.c));
            map.put("mediaType", Integer.valueOf(this.d));
            map.put("members", this.e);
            return sw4.b(1, nl0.z + "/rtc.create.room.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
            RoomInfo roomInfo;
            LogUtil.i("CallDao", "createRoom " + z + az2.c(lXBaseNetBean), exc);
            HashMap map = new HashMap();
            map.put("fuid", er4.d(this.e));
            map.put("type", String.valueOf(this.d));
            map.put("BusinessId", TextUtils.isEmpty(this.f21815a) ? "1v1Chat" : "groupChat");
            String str = "0";
            map.put("result", (z && lXBaseNetBean.isSuccess()) ? "1" : "0");
            if (!z || !lXBaseNetBean.isSuccess()) {
                if (z) {
                    str = lXBaseNetBean.resultCode + "";
                } else {
                    str = "-1";
                }
            }
            map.put("code", str);
            zn6.i("ByteRTC_request", map);
            if (this.f != null) {
                if (z && lXBaseNetBean.isSuccess() && (roomInfo = lXBaseNetBean.data) != null && roomInfo.sdkType == 1) {
                    er4.j(this.f21815a, this.d, roomInfo.sdkResult.roomId, this.e);
                }
                this.f.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<RoomInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21816a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ rx d;

        public d(String str, String str2, int i, rx rxVar) {
            this.f21816a = str;
            this.b = str2;
            this.c = i;
            this.d = rxVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("groupId", this.f21816a);
            map.put("domain", this.b);
            map.put("bizType", Integer.valueOf(this.c));
            return sw4.b(1, nl0.z + "/rtc.get.room.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
            rx rxVar = this.d;
            if (rxVar != null) {
                rxVar.onResult(z, lXBaseNetBean, exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements m96 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements rx {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ jo2 f21817a;

            public a(jo2 jo2Var) {
                this.f21817a = jo2Var;
            }

            @Override // defpackage.rx
            public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
                if (!z) {
                    this.f21817a.onError(-1, "fail");
                } else if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess()) {
                    this.f21817a.onError(lXBaseNetBean.resultCode, lXBaseNetBean.errorMsg);
                } else {
                    this.f21817a.onSuccess(lXBaseNetBean);
                }
            }
        }

        @Override // defpackage.m96
        public void a(CallCmd callCmd) {
            cx.d(callCmd);
        }

        @Override // defpackage.m96
        public void b(ry4 ry4Var, int i, jo2 jo2Var) {
            ww.d(ry4Var.f20624a, i, ry4Var.b, null, new a(jo2Var));
        }
    }

    public static void a(String str, String str2, int i, int i2, List<String> list, rx<LXBaseNetBean<RoomInfo>> rxVar) {
        zw4.e(new c(str, str2, i, i2, list, rxVar));
    }

    public static void b(String str, String str2, int i, String str3, rx<LXBaseNetBean<RoomInfo>> rxVar) {
        zw4.e(new a(str, str2, i, str3, rxVar));
    }

    public static void c(String str, String str2, int i, rx<LXBaseNetBean<RoomInfo>> rxVar) {
        zw4.e(new d(str, str2, i, rxVar));
    }

    public static void d(String str, int i, String str2, List<String> list, rx rxVar) {
        zw4.e(new b(str, i, str2, list, rxVar));
    }
}
