package defpackage;

import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishEntranceVo;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishStateVo;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishSuccessVo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fk4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<PolishEntranceVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17541a;

        public a(Runnable runnable) {
            this.f17541a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/light.index.my.tab.text.v1", new HashMap());
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<PolishEntranceVo> lXBaseNetBean, Exception exc) {
            LogUtil.i("PolishDao", "requestEntrance " + az2.c(lXBaseNetBean));
            if (z && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                gk4.c().f17741a = lXBaseNetBean.data;
                Runnable runnable = this.f17541a;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<PolishSuccessVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17542a;

        public b(Runnable runnable) {
            this.f17542a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            ContactInfoItem contactInfoItemF = v4.f();
            if (contactInfoItemF != null) {
                map.put("gender", Integer.valueOf(contactInfoItemF.getGender()));
            }
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("cityCode", locationExI.getCityCode());
            }
            return sw4.b(1, nl0.z + "/light.index.light.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<PolishSuccessVo> lXBaseNetBean, Exception exc) {
            LogUtil.i("PolishDao", "polish " + az2.c(lXBaseNetBean));
            if (z && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                gk4.c().b = lXBaseNetBean.data;
                this.f17542a.run();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<PolishStateVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17543a;

        public c(Runnable runnable) {
            this.f17543a = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/light.index.get.report.v1", new HashMap());
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<PolishStateVo> lXBaseNetBean, Exception exc) {
            LogUtil.i("PolishDao", "requestPolishState " + az2.c(lXBaseNetBean));
            if (z && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                gk4.c().c = lXBaseNetBean.data;
            } else {
                gk4.c().c = null;
            }
            this.f17543a.run();
        }
    }

    public static void a(Runnable runnable) {
        zw4.e(new b(runnable));
    }

    public static void b(Runnable runnable) {
        zw4.e(new a(runnable));
    }

    public static void c(Runnable runnable) {
        zw4.e(new c(runnable));
    }
}
