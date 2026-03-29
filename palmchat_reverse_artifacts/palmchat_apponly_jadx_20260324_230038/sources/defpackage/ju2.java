package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyState;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyStateItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ju2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18500a;

        public a(String str) {
            this.f18500a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ju2.f()) {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_intimacy_init_state" + this.f18500a, Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<IntimacyState>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f18501a;

        public b(List list) {
            this.f18501a = list;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            JSONObject jSONObjectE = ju2.e(this.f18501a);
            LogUtil.i("IntimacyStatusManager", "params = " + jSONObjectE);
            return sw4.c(1, nl0.z + "/intimate.batch.query.v1", jSONObjectE);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<IntimacyState> lXBaseNetBean, Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("onResult = ");
            Object objC = exc;
            if (z) {
                objC = az2.c(lXBaseNetBean);
            }
            sb.append(objC);
            LogUtil.i("IntimacyStatusManager", sb.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<IntimacyState>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18502a;

        public c(String str) {
            this.f18502a = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f18502a);
            return sw4.c(1, nl0.z + "/intimate.batch.query.v1", ju2.e(arrayList));
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<IntimacyState> lXBaseNetBean, Exception exc) {
            IntimacyState intimacyState;
            List<IntimacyStateItem> list;
            StringBuilder sb = new StringBuilder();
            sb.append("onResult = ");
            Object objC = exc;
            if (z) {
                objC = az2.c(lXBaseNetBean);
            }
            sb.append(objC);
            LogUtil.i("IntimacyStatusManager", sb.toString());
            if (lXBaseNetBean == null || lXBaseNetBean.data == null || !lXBaseNetBean.isSuccess() || (intimacyState = lXBaseNetBean.data) == null || (list = intimacyState.intimates) == null || list.size() <= 0) {
                return;
            }
            ju2.g(intimacyState.intimates.get(0).fuid, intimacyState.intimates.get(0).value, false);
        }
    }

    public static void c() {
        String strE = v4.e(AppContext.getContext());
        if (strE == null || !gu2.f()) {
            return;
        }
        if (SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_intimacy_init_state" + strE, false)) {
            return;
        }
        u93.d(1000, new a(strE));
    }

    public static List<String> d() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayListP = bo0.r().p();
        if (copyOnWriteArrayListP != null && copyOnWriteArrayListP.size() > 0) {
            for (ContactInfoItem contactInfoItem : copyOnWriteArrayListP) {
                if (!a65.e(contactInfoItem)) {
                    arrayList.add(contactInfoItem.getUid());
                }
            }
        }
        return arrayList;
    }

    public static JSONObject e(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fuids", new JSONArray((Collection) arrayList));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean f() {
        LogUtil.i("IntimacyStatusManager", "start");
        boolean z = true;
        try {
            List<String> listD = d();
            if (listD.size() > 0) {
                int size = listD.size();
                int i = ((size + 50) - 1) / 50;
                int i2 = 0;
                while (i > 0) {
                    int iMin = Math.min(size - i2, 50) + i2;
                    LXBaseNetBean<IntimacyState> lXBaseNetBeanI = i(listD.subList(i2, iMin));
                    LogUtil.i("IntimacyStatusManager", "updateStatus =" + az2.c(lXBaseNetBeanI));
                    if (lXBaseNetBeanI == null || lXBaseNetBeanI.data == null || !lXBaseNetBeanI.isSuccess()) {
                        z = false;
                        break;
                    }
                    ln0.c(lXBaseNetBeanI.data);
                    i--;
                    i2 = iMin;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.i("IntimacyStatusManager", "end result=" + z);
        return z;
    }

    public static void g(String str, float f, boolean z) {
        ln0.e(str, f, z);
    }

    public static void h(String str) {
        zw4.e(new c(str));
    }

    public static LXBaseNetBean<IntimacyState> i(List<String> list) {
        try {
            return zw4.k(new b(list));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
