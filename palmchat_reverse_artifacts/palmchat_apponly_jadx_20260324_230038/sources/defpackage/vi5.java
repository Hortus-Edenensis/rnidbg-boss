package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.fragment.guide.SquareSelectTagDialog;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.tag.bean.CommonResponse;
import defpackage.ro2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vi5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile vi5 f21451a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends tw4<CommonResponse<String>> {
        public a() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<String> commonResponse) {
            if (commonResponse.getResultCode() == 0) {
                String data = commonResponse.getData();
                if (String.valueOf(1).equals(data)) {
                    vi5.this.j();
                }
                LogUtil.i("SquareGuideManager", "data=" + data);
                SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_get_guide_status"), Boolean.TRUE);
            }
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            LogUtil.i("SquareGuideManager", "onError=" + str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21453a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ro2.a c;

        public b(Context context, boolean z, ro2.a aVar) {
            this.f21453a = context;
            this.b = z;
            this.c = aVar;
        }

        @Override // ro2.a
        public void onCancel() {
            this.c.onCancel();
        }

        @Override // ro2.a
        public void onSuccess() {
            Context context = this.f21453a;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            vi5.this.d(this.f21453a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.a f21454a;

        public c(ro2.a aVar) {
            this.f21454a = aVar;
        }

        @Override // ro2.a
        public void onCancel() {
            this.f21454a.onCancel();
        }

        @Override // ro2.a
        public void onSuccess() {
            vi5.b().j();
            this.f21454a.onSuccess();
        }
    }

    public static vi5 b() {
        if (f21451a == null) {
            synchronized (vi5.class) {
                if (f21451a == null) {
                    f21451a = new vi5();
                }
            }
        }
        return f21451a;
    }

    public void c(Context context, int i, ro2.a aVar) {
        if (e()) {
            aVar.onSuccess();
        } else {
            bj5.b().a().d(context, i, aVar);
        }
    }

    public final void d(Context context, boolean z, ro2.a aVar) {
        if (b().f()) {
            aVar.onSuccess();
        } else {
            SquareSelectTagDialog.K(context, z, new c(aVar));
        }
    }

    public boolean e() {
        return SquareSingleton.getInstance().isGenderBirthdayCompleted();
    }

    public boolean f() {
        return SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, k86.a("key_square_guide_tag_complete"), false);
    }

    public boolean g() {
        return !(e() && f());
    }

    public void h() {
        if (TextUtils.isEmpty(v4.e(com.zenmen.palmchat.c.b())) || f()) {
            return;
        }
        i();
    }

    public final void i() {
        if (SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, k86.a("key_square_get_guide_status"), false)) {
            return;
        }
        bj5.b().c().g(new a());
    }

    public void j() {
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_guide_tag_complete"), Boolean.TRUE);
    }

    public void k(Context context, ro2.a aVar) {
        l(context, false, aVar);
    }

    public void l(Context context, boolean z, ro2.a aVar) {
        if (!b().g()) {
            aVar.onSuccess();
        } else if (b().e()) {
            d(context, z, aVar);
        } else {
            bj5.b().a().d(context, z ? 2 : 1, new b(context, z, aVar));
        }
    }
}
