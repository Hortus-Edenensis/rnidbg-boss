package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.qq.gdt.action.ActionType;
import com.qq.gdt.action.ChannelType;
import com.qq.gdt.action.GDTAction;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.loginnew.GuiyinConfigVo;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gf2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            gf2.f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<GuiyinConfigVo>> {
        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            String str;
            boolean z;
            HashMap map = new HashMap();
            map.put("deviceId", ac1.h);
            map.put("channels", new String[]{"toutiao", "gdt"});
            String oaid = MdidSdkConfigHelper.getInstance().getOAID();
            if (oaid == null) {
                oaid = "";
            }
            map.put("oaid", oaid);
            map.put("platform", "android");
            if (!nl0.k() || nl0.h()) {
                str = "https://118.184.189.138/outerchannel/clientSDK";
                z = true;
            } else {
                str = "https://openapi.lianxinapp.com/outerchannel/clientSDK";
                z = false;
            }
            sw4 sw4VarB = sw4.b(1, str, map);
            sw4VarB.h = false;
            if (z) {
                HashMap<String, String> map2 = new HashMap<>();
                sw4VarB.b = map2;
                map2.put("Host", "openapi-pre.lianxinapp.com");
            }
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<GuiyinConfigVo> lXBaseNetBean, Exception exc) {
            if (!z || lXBaseNetBean == null) {
                return;
            }
            if (lXBaseNetBean.isSuccess() && (lXBaseNetBean.data != null)) {
                LogUtil.i("GuiyinConvertHelper", "requestConfig result =" + az2.c(lXBaseNetBean));
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_guiyin_need_init_third_sdk", az2.c(lXBaseNetBean.data));
            }
        }
    }

    public static void b(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            String strN = sPUtil.n(scene, "key_guiyin_need_init_third_sdk", "");
            LogUtil.i("GuiyinConvertHelper", "checkNeedInitSDK config=" + strN);
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            GuiyinConfigVo guiyinConfigVo = (GuiyinConfigVo) az2.a(strN, GuiyinConfigVo.class);
            if (guiyinConfigVo != null) {
                ArrayList arrayList = new ArrayList();
                if (guiyinConfigVo.toutiao) {
                    d(activity);
                    arrayList.add("toutiao");
                }
                if (guiyinConfigVo.gdt) {
                    c();
                    arrayList.add("gdt");
                }
                if (arrayList.size() > 0) {
                    HashMap<String, Object> mapD = x63.d();
                    mapD.put(com.umeng.ccg.a.x, arrayList);
                    zn6.j("guiyin_sdk_init", null, mapD);
                }
            }
            sPUtil.t(scene, "key_guiyin_need_init_third_sdk", "");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("GuiyinConvertHelper", "checkNeedInitSDK error", e);
        }
    }

    public static void c() {
        LogUtil.i("GuiyinConvertHelper", "initGDTAction");
        try {
            GDTAction.setAnidEnable(false);
            GDTAction.init(AppContext.getContext(), "1218534927", "f626f38921e9b89025224fc507bcc843", ChannelType.CHANNEL_UNKNOWN, ac1.m);
            GDTAction.start();
            GDTAction.logAction(ActionType.START_APP);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("GuiyinConvertHelper", "initGDTAction", e);
        }
    }

    public static void d(Activity activity) {
        LogUtil.i("GuiyinConvertHelper", "initToutiao");
        try {
            pn.d.e(AppContext.getContext(), activity);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("GuiyinConvertHelper", "initToutiao", e);
        }
    }

    public static boolean e() {
        String str = ac1.m;
        return str != null && (str.toLowerCase().startsWith("oppo_") || ac1.m.toLowerCase().startsWith("vivo_") || ac1.m.toLowerCase().startsWith("xm_") || ac1.m.toLowerCase().startsWith("honor_") || ac1.m.toLowerCase().startsWith("hwex2_"));
    }

    public static void f() {
        zw4.e(new b());
    }

    public static void g() {
        boolean zE = e();
        LogUtil.i("GuiyinConvertHelper", "requestConfigOnAgreePrivacy isMainChannel=" + zE);
        if (zE) {
            u93.b(3000, new a());
            return;
        }
        GuiyinConfigVo guiyinConfigVo = new GuiyinConfigVo();
        guiyinConfigVo.gdt = true;
        guiyinConfigVo.toutiao = true;
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_guiyin_need_init_third_sdk", az2.c(guiyinConfigVo));
    }
}
