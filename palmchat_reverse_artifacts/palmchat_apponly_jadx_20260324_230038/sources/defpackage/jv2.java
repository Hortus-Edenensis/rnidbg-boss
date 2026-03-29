package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.lantern.auth.stub.WkSDKFeature;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f18515a;

    static {
        rv2.A("JCommon");
    }

    public static void a(Context context, int i) {
        long jA = ov2.a();
        String strN = hw2.n(context, i);
        byte[] bArrB = ov2.b(f18515a, strN);
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 25);
        bundle.putInt("ver", 1);
        bundle.putLong("rid", jA);
        bundle.putLong(WkAdConfigModel.TAG_TIMEOUT, 0L);
        bundle.putByteArray("body", bArrB);
        if (!TextUtils.isEmpty(strN)) {
            p63.a("JCommonActionHelper", "tcp report deviceInfo:" + strN);
        }
        rv2.H(context, bundle);
    }

    public static void b(Context context, Object obj) {
        sw2.d(context, d(obj));
        gw2.v().f(context);
        iw2.t().f(context);
        eq0.j().l(context);
        gx2.d(context, "heartbeat");
        hx2.b(context, null);
        px2.s().f(context);
    }

    public static void c(Context context, Bundle bundle) {
        JSONObject jSONObjectF = f(bundle);
        if (jSONObjectF == null) {
            return;
        }
        int iOptInt = jSONObjectF.optInt("cmd");
        a(context, iOptInt);
        if (iOptInt == 9) {
            ev2.s().h(context);
            return;
        }
        if (iOptInt == 50) {
            hx2.b(context, jSONObjectF);
            return;
        }
        if (iOptInt == 55) {
            rv2.a(context, jSONObjectF);
        } else if (iOptInt == 58) {
            eq0.j().g(context, jSONObjectF);
        } else {
            if (iOptInt != 70) {
                return;
            }
            gx2.i(context);
        }
    }

    public static int d(Object obj) {
        return ((obj instanceof Bundle) && ((Bundle) obj).getBoolean(WkSDKFeature.WHAT_LOGIN)) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object e(Context context, String str, Object obj) {
        try {
        } catch (Throwable th) {
            p63.f("JCommonActionHelper", "onEvent throwable:" + th.getMessage());
        }
        if (context == null) {
            p63.f("JCommonActionHelper", "context is null,give up continue");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            p63.f("JCommonActionHelper", "action is null,give up continue");
            return null;
        }
        if (TextUtils.isEmpty(lv2.b)) {
            lv2.b = Build.MANUFACTURER;
        }
        switch (str) {
            case "periodtask":
                b(context, obj);
                break;
            case "getwakeenable":
                return gx2.k(context);
            case "filter_pkg_list":
                return gx2.l(context, obj);
            case "deviceinfo":
                return gw2.v().w(context);
            case "on_register":
                gw2.v().s(context);
                gx2.d(context, "register");
                break;
            case "get_all_ids":
                return gq2.a(context);
            case "service_create":
                eq0.j().k(context);
                gx2.d(context, "start");
                nt5.b().g(3000, 3000L, new a());
                break;
            case "get_imei":
                return "";
            case "user_present":
                gx2.d(context, "screen");
                break;
        }
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        if (bundle != null) {
            switch (str) {
                case "set_ctrl_url":
                    jx2.f18529a = bundle.getString("test_wake_controll_url");
                    break;
                case "cmd":
                    c(context, bundle);
                    break;
                case "waked":
                    int i = bundle.getInt("type", -1);
                    if (TextUtils.isEmpty(bundle.getString("from_package"))) {
                        p63.f("JCommonActionHelper", "[waked]empty packageName waked from ");
                        break;
                    } else {
                        if (i != -1) {
                            vx2.b(context, bundle, i);
                        } else {
                            p63.f("JCommonActionHelper", "[waked]wrong waked type");
                        }
                        break;
                    }
                    break;
                case "set_sdktype_info":
                    dx2.s().g(context, bundle);
                    break;
                case "notification_state":
                    sw2.d(context, bundle.getInt("scence"));
                    break;
                case "set_wake_enable":
                    kv2.L(context, bundle.getBoolean("enable"));
                    break;
                case "foreground_state_change":
                    sx2.d().c(context, bundle.getBoolean("foreground"));
                    break;
            }
        }
        return null;
    }

    public static JSONObject f(Bundle bundle) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f18515a = byteBufferWrap.getLong();
            byte[] bArr = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            p63.a("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e) {
            p63.f("JCommonActionHelper", "parseBundle2Json exception:" + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gt5 {
        @Override // defpackage.gt5
        public void a(Message message) {
        }
    }
}
