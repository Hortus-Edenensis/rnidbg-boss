package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.contacts.bean.Vip;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f17527a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17528a;

        public a(b bVar) {
            this.f17528a = bVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            b bVar = this.f17528a;
            if (bVar != null) {
                bVar.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            try {
                if (jSONObject == null) {
                    b bVar = this.f17528a;
                    if (bVar != null) {
                        bVar.onFail(new Exception());
                        return;
                    }
                    return;
                }
                int iOptInt = jSONObject.optInt("resultCode", -1);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
                    b bVar2 = this.f17528a;
                    if (bVar2 != null) {
                        bVar2.onFail(new Exception());
                        return;
                    }
                    return;
                }
                if (!jSONObjectOptJSONObject.has("vipType")) {
                    b bVar3 = this.f17528a;
                    if (bVar3 != null) {
                        bVar3.onFail(new Exception());
                        return;
                    }
                    return;
                }
                int i = jSONObjectOptJSONObject.getInt("vipType");
                b bVar4 = this.f17528a;
                if (bVar4 != null) {
                    bVar4.onSuccess(i);
                }
                int iL = fg6.l(c.b());
                if (iL != i) {
                    SharedPreferences sharedPreferences = c.b().getSharedPreferences("sp_vip_type", 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("key_vip_type", i).apply();
                    }
                    fg6.f17527a = Integer.valueOf(i);
                }
                boolean z = iL != 1 && i == 1;
                LogUtil.i("VipUtil", "getVipStatusFromServer lastType=" + iL + " vipType=" + i + " becomeSvip=" + z);
                ap3.a().X(new uk5(53, z ? 1 : 0));
            } catch (Exception e) {
                e.printStackTrace();
                b bVar5 = this.f17528a;
                if (bVar5 != null) {
                    bVar5.onFail(new Exception());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFail(Exception exc);

        void onSuccess(int i);
    }

    public static void b(String str, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", str);
            jSONObject.put("vip_status", i);
            jSONObject.put("svip_status", i2);
            jSONObject.put("from", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("svip_videoChat_guide", null, jSONObject.toString());
    }

    public static int c(int i) {
        return i == 2 ? R$drawable.svip_icon_small : i == 1 ? R$drawable.vip_icon_normal_small : R$drawable.vip_icon_dark_small;
    }

    public static boolean d(Context context) {
        return l(context) == 1;
    }

    public static int e(int i) {
        return i == 2 ? R$drawable.svip_icon_normal : i == 1 ? R$drawable.vip_icon_normal : R$drawable.vip_icon_dark;
    }

    public static boolean f(Context context) {
        return j(context) || d(context);
    }

    public static int g(ContactExtBean contactExtBean) {
        Vip vip;
        if (contactExtBean == null) {
            return 0;
        }
        try {
            if (contactExtBean.getVip() == null || (vip = contactExtBean.getVip()) == null) {
                return 0;
            }
            int i = vip.status;
            if (i == 1 && vip.type == 1) {
                return 2;
            }
            if (i == 1) {
                return vip.type == 0 ? 1 : 0;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int h(String str) {
        ContactExtBean contactExtBean;
        Vip vip;
        try {
            if (TextUtils.isEmpty(str) || (contactExtBean = (ContactExtBean) az2.a(str, ContactExtBean.class)) == null || contactExtBean.getVip() == null || (vip = contactExtBean.getVip()) == null) {
                return 0;
            }
            int i = vip.status;
            if (i == 1 && vip.type == 1) {
                return 2;
            }
            if (i == 1) {
                return vip.type == 0 ? 1 : 0;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void i(Context context, b bVar) {
        if (bVar != null) {
            bVar.onSuccess(l(context));
        }
    }

    public static boolean j(Context context) {
        return l(context) == 0;
    }

    public static void k(Context context, b bVar) {
        zw4.f(ap3.e(), 1, null, new a(bVar));
    }

    public static int l(Context context) {
        if (f17527a == null) {
            f17527a = Integer.valueOf(m(context));
        }
        return f17527a.intValue();
    }

    public static int m(Context context) {
        int i = -1;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_vip_type", 0);
            if (sharedPreferences != null) {
                i = sharedPreferences.getInt("key_vip_type", -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.i("VipUtil", "getVipStatusFromSpImp " + i);
        return i;
    }

    public static int n(Context context, int i) {
        return context.getResources().getColor((i == 2 || i == 1) ? R$color.Gg : R$color.Gb);
    }

    public static int o(Context context, int i) {
        if (i != 2 && i != 1) {
            return Color.parseColor("#8c191c1c");
        }
        return context.getResources().getColor(R$color.Gg);
    }

    public static int p(ContactExtBean contactExtBean) {
        Vip vip;
        if (contactExtBean == null) {
            return 0;
        }
        try {
            if (contactExtBean.getVip() == null || (vip = contactExtBean.getVip()) == null) {
                return 0;
            }
            return vip.type;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean q(int i) {
        return i == 2 || i == 1;
    }
}
