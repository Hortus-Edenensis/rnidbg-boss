package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.greendao.greendaogen.UnreadMessageDao;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.mvp.model.bean.LookMeCountBean;
import com.zenmen.square.mvp.model.bean.PraiseCountBean;
import com.zenmen.square.support.SquareSingleton;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vn3 {
    public int e;
    public int f;
    public boolean j;
    public Boolean k;
    public Boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<d46> f21485a = new HashSet();
    public boolean b = false;
    public boolean c = false;
    public long d = 0;
    public int g = 0;
    public String h = null;
    public String i = null;
    public long l = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean<PraiseCountBean>> {

        /* JADX INFO: renamed from: vn3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1280a extends TypeToken<BaseNetBean<PraiseCountBean>> {
            public C1280a() {
            }
        }

        public a() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return new JSONObject();
        }

        @Override // defpackage.ei5
        public BaseNetBean<PraiseCountBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C1280a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<PraiseCountBean> baseNetBean) {
            PraiseCountBean praiseCountBean;
            ma3.d("get praiseCount result " + baseNetBean.isSuccess() + " " + baseNetBean.errorMsg);
            vn3.this.b = false;
            if (!baseNetBean.isSuccess() || (praiseCountBean = baseNetBean.data) == null) {
                return;
            }
            int i = praiseCountBean.likeCount;
            ma3.d("get praiseCount suc " + i);
            vn3 vn3Var = vn3.this;
            PraiseCountBean praiseCountBean2 = baseNetBean.data;
            vn3Var.z(praiseCountBean2.headImgUrl == null ? "" : praiseCountBean2.headImgUrl);
            vn3.this.D(i);
            vn3.this.C(baseNetBean.data.discussionCount);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements r46 {
        public b() {
        }

        @Override // defpackage.r46
        public void a(q46 q46Var) {
            if (q46Var != null) {
                vn3.this.B(q46Var);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ei5<BaseNetBean<LookMeCountBean>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<LookMeCountBean>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return new JSONObject();
        }

        @Override // defpackage.ei5
        public BaseNetBean<LookMeCountBean> handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<LookMeCountBean> baseNetBean) {
            Log.i("MessageCountManager", "get reloadLookMeCount result " + baseNetBean.isSuccess() + " " + baseNetBean.errorMsg);
            if (baseNetBean.isSuccess()) {
                LookMeCountBean lookMeCountBean = baseNetBean.data;
                if (lookMeCountBean != null) {
                    String str = lookMeCountBean.total;
                    String str2 = lookMeCountBean.unreadCount;
                    Log.i("MessageCountManager", "get reloadLookMeCount suc " + str + " " + str2);
                    vn3.this.s(str, str2);
                }
                vn3.this.c = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21491a;

        public d(int i) {
            this.f21491a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = vn3.this.f21485a.iterator();
                while (it.hasNext()) {
                    ((d46) it.next()).f(this.f21491a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21492a;

        public e(int i) {
            this.f21492a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = vn3.this.f21485a.iterator();
                while (it.hasNext()) {
                    ((d46) it.next()).e(this.f21492a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21493a;
        public final /* synthetic */ String b;

        public f(String str, String str2) {
            this.f21493a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = vn3.this.f21485a.iterator();
            while (it.hasNext()) {
                ((d46) it.next()).b(this.f21493a, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21494a;

        public g(int i) {
            this.f21494a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = vn3.this.f21485a.iterator();
                while (it.hasNext()) {
                    ((d46) it.next()).c(this.f21494a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21495a;

        public h(boolean z) {
            this.f21495a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = vn3.this.f21485a.iterator();
                while (it.hasNext()) {
                    ((d46) it.next()).d(this.f21495a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = vn3.this.f21485a.iterator();
                while (it.hasNext()) {
                    ((d46) it.next()).a(vn3.this.o());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public vn3() {
        this.e = -1;
        this.f = -1;
        this.j = true;
        this.e = k();
        this.f = j();
        this.j = SPUtil.f14322a.a(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_red_text_show", true);
    }

    public void A(boolean z) {
        Boolean bool = this.k;
        if (bool == null || (bool.booleanValue() ^ z)) {
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_friend_feed_dot" + v4.e(com.zenmen.palmchat.c.b()), Boolean.valueOf(z));
            this.k = Boolean.valueOf(z);
            v();
        }
    }

    public void B(q46 q46Var) {
        if (this.g == q46Var.a()) {
            return;
        }
        this.g = q46Var.a();
        this.h = q46Var.b();
        r(this.g);
    }

    public void C(int i2) {
        if (i2 == this.f) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_comment_unread_count" + v4.e(com.zenmen.palmchat.c.b()), Integer.valueOf(i2));
        this.f = i2;
        q(i2);
    }

    public void D(int i2) {
        if (i2 == this.e) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_praise_unread_count" + v4.e(com.zenmen.palmchat.c.b()), Integer.valueOf(i2));
        this.e = i2;
        u(i2);
    }

    public void E(boolean z) {
        Boolean bool = this.m;
        if (bool == null || (bool.booleanValue() ^ z)) {
            Boolean boolValueOf = Boolean.valueOf(z);
            this.m = boolValueOf;
            if (!boolValueOf.booleanValue()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.l = jCurrentTimeMillis;
                SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_feed_time", Long.valueOf(jCurrentTimeMillis));
                qj5.j0("pagediscover_top_nearbyhintclear", null);
            }
            v();
        }
    }

    public void F(boolean z) {
        if (z == this.j) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_red_text_show", Boolean.valueOf(z));
        this.j = z;
        t(z);
    }

    public void G(d46 d46Var) {
        this.f21485a.remove(d46Var);
    }

    public boolean e() {
        return !m() && l();
    }

    public String f() {
        if (this.i == null) {
            this.i = SPUtil.f14322a.n(SPUtil.SCENE.SQUARE_CONFIG, "key_square_unread_icon" + v4.e(com.zenmen.palmchat.c.b()), "");
        }
        return this.i;
    }

    public Boolean g() {
        if (this.k == null) {
            this.k = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.SQUARE_CONFIG, "key_square_friend_feed_dot" + v4.e(com.zenmen.palmchat.c.b()), true));
        }
        return this.k;
    }

    public int h() {
        return this.g;
    }

    public String i() {
        String str = h() > 0 ? this.h : null;
        return (!TextUtils.isEmpty(str) || j() + k() <= 0) ? str : f();
    }

    public int j() {
        if (this.f < 0) {
            this.f = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_CONFIG, "key_square_comment_unread_count" + v4.e(com.zenmen.palmchat.c.b()), 0);
        }
        return this.f;
    }

    public int k() {
        if (this.e < 0) {
            this.e = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_CONFIG, "key_square_praise_unread_count" + v4.e(com.zenmen.palmchat.c.b()), 0);
        }
        return this.e;
    }

    public boolean l() {
        qs5 qs5VarA = gi5.a("nearbyFeedTitle");
        boolean z = false;
        if (qs5VarA == null || qs5VarA.h != 1) {
            return false;
        }
        if (this.l == -1) {
            this.l = SPUtil.f14322a.i(SPUtil.SCENE.SQUARE_CONFIG, "key_square_nearby_feed_time", 0L);
        }
        if (System.currentTimeMillis() - this.l > qs5VarA.b() && qs5VarA.h == 1) {
            z = true;
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        this.m = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public boolean m() {
        return this.j;
    }

    public boolean n() {
        return ((Boolean) q05.k("KEY_NEED_SHOW_SQUARE_INTERACT_DOT", Boolean.FALSE)).booleanValue();
    }

    public boolean o() {
        return g().booleanValue() || l() || n();
    }

    public int p() {
        return j() + k();
    }

    public final void q(int i2) {
        SquareSingleton.getInstance().getMainHandler().post(new e(i2));
    }

    public final void r(int i2) {
        SquareSingleton.getInstance().getMainHandler().post(new g(i2));
    }

    public final void s(String str, String str2) {
        SquareSingleton.getInstance().getMainHandler().post(new f(str, str2));
    }

    public final void t(boolean z) {
        SquareSingleton.getInstance().getMainHandler().post(new h(z));
    }

    public final void u(int i2) {
        SquareSingleton.getInstance().getMainHandler().post(new d(i2));
    }

    public final void v() {
        SquareSingleton.getInstance().getMainHandler().post(new i());
    }

    public void w(d46 d46Var) {
        if (d46Var != null) {
            this.f21485a.add(d46Var);
        }
    }

    public void x() {
        Log.i("MessageCountManager", "reloadLookMeCount: ");
        if (this.c) {
            Log.i("MessageCountManager", "reloadLookMeCount isLookMeReloading or lastReloadTime < 5s");
        } else {
            this.c = true;
            bi5.h(new c());
        }
    }

    public void y() {
        ma3.d("reloadPraiseCount ");
        if (this.b) {
            ma3.d("isReloading or lastReloadTime < 5s");
            return;
        }
        this.b = true;
        bi5.j(new a());
        sq3.o().t(new b(), UnreadMessageDao.Properties.g.eq(0), UnreadMessageDao.Properties.d.notEq(10));
    }

    public void z(String str) {
        if (str == null) {
            return;
        }
        String str2 = this.i;
        if (str2 == null || !str2.equals(str)) {
            this.i = str;
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_unread_icon" + v4.e(com.zenmen.palmchat.c.b()), this.i);
        }
    }
}
