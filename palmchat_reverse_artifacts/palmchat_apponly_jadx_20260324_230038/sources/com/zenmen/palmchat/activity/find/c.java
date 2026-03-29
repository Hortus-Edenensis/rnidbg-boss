package com.zenmen.palmchat.activity.find;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.Marker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.b;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.ad3;
import defpackage.bv4;
import defpackage.cn;
import defpackage.ed3;
import defpackage.ew1;
import defpackage.hc2;
import defpackage.hd0;
import defpackage.id0;
import defpackage.jd0;
import defpackage.kd0;
import defpackage.md0;
import defpackage.rn;
import defpackage.sc3;
import defpackage.v4;
import defpackage.vc3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c implements com.zenmen.palmchat.activity.find.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12243a;
    public ad3 c;
    public kd0 d;
    public kd0 e;
    public Bitmap f;
    public Bitmap g;
    public Bitmap h;
    public b.a i;
    public kd0 l;
    public Map<String, ed3> b = new HashMap();
    public Set<Target> j = new HashSet();
    public int k = v4.f().getGender();
    public Set<Target> m = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements md0 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bv4 f12246a;
            public final /* synthetic */ md0.a b;
            public final /* synthetic */ hd0 c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.c$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0955a implements rn {
                public C0955a() {
                }

                @Override // defpackage.rn
                public void run(int i, String str, Object obj) {
                    if (obj instanceof Bitmap) {
                        ((LoadCountBean.MarkerBean) a.this.f12246a.a()).avatarBitmap = (Bitmap) obj;
                        a aVar = a.this;
                        aVar.b.a(aVar.c);
                    }
                }
            }

            public a(bv4 bv4Var, md0.a aVar, hd0 hd0Var) {
                this.f12246a = bv4Var;
                this.b = aVar;
                this.c = hd0Var;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                LogUtil.d("MarkerHelper", "onLoadFailed ");
                if (target != null) {
                    c.this.j.remove(target);
                }
                ((LoadCountBean.MarkerBean) this.f12246a.a()).avatarBitmap = ((BitmapDrawable) drawable).getBitmap();
                if (c.this.h == null) {
                    c cVar = c.this;
                    cVar.h = BitmapFactory.decodeResource(cVar.f12243a.getResources(), R.drawable.ic_near_avatar_bg);
                }
                c.this.r((LoadCountBean.MarkerBean) this.f12246a.a(), new C0955a());
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                LogUtil.d("MarkerHelper", "onLoadFailed ");
                if (target == null) {
                    return false;
                }
                c.this.j.remove(target);
                return false;
            }
        }

        public b() {
        }

        @Override // defpackage.md0
        public String a(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            return bv4VarQ != null ? ((LoadCountBean.MarkerBean) bv4VarQ.a()).getKey() : "empty";
        }

        @Override // defpackage.md0
        public void b(hd0 hd0Var, md0.a aVar) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            if (bv4VarQ == null) {
                return;
            }
            c.this.w((LoadCountBean.MarkerBean) bv4VarQ.a(), new a(bv4VarQ, aVar, hd0Var));
        }

        @Override // defpackage.md0
        public Bitmap c(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            return (bv4VarQ == null || ((LoadCountBean.MarkerBean) bv4VarQ.a()).avatarBitmap == null) ? c.this.f : ((LoadCountBean.MarkerBean) bv4VarQ.a()).avatarBitmap;
        }

        @Override // defpackage.md0
        public boolean drawAsync() {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0956c implements id0 {
        public C0956c() {
        }

        @Override // defpackage.id0
        public void a(Marker marker, Object obj) {
            if (c.this.i != null) {
                if (!(obj instanceof hd0)) {
                    if (obj instanceof sc3) {
                        c.this.i.a(obj);
                    }
                } else {
                    hd0 hd0Var = (hd0) obj;
                    bv4 bv4VarQ = c.this.q(hd0Var);
                    if (bv4VarQ == null || bv4VarQ.a() == null) {
                        return;
                    }
                    c.this.i.a(c.this.q(hd0Var).a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements md0 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bv4 f12250a;
            public final /* synthetic */ md0.a b;
            public final /* synthetic */ hd0 c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.c$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0957a implements rn {
                public C0957a() {
                }

                @Override // defpackage.rn
                public void run(int i, String str, Object obj) {
                    if (obj instanceof Bitmap) {
                        ((LoadCountBean.MarkerBean) a.this.f12250a.a()).avatarBitmap = (Bitmap) obj;
                        a aVar = a.this;
                        aVar.b.a(aVar.c);
                    }
                }
            }

            public a(bv4 bv4Var, md0.a aVar, hd0 hd0Var) {
                this.f12250a = bv4Var;
                this.b = aVar;
                this.c = hd0Var;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                if (target != null) {
                    c.this.m.remove(target);
                }
                LogUtil.d("FindMapTripManager", "loadBitmapAsync onResourceReady " + ((LoadCountBean.MarkerBean) this.f12250a.a()).avatar);
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                ((LoadCountBean.MarkerBean) this.f12250a.a()).avatarBitmap = bitmapDrawable.getBitmap();
                ((LoadCountBean.MarkerBean) this.f12250a.a()).avatarOldBitmap = bitmapDrawable.getBitmap();
                ew1.i0("view", ((LoadCountBean.MarkerBean) this.f12250a.a()).uid + "", ((LoadCountBean.MarkerBean) this.f12250a.a()).scheduleOrderId);
                c.this.s((LoadCountBean.MarkerBean) this.f12250a.a(), new C0957a());
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                if (target != null) {
                    c.this.m.remove(target);
                }
                LogUtil.d("FindMapTripManager", "onLoadFailed " + ((LoadCountBean.MarkerBean) this.f12250a.a()).avatar);
                return false;
            }
        }

        public d() {
        }

        @Override // defpackage.md0
        public String a(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            if (bv4VarQ == null) {
                return "empty";
            }
            return ((LoadCountBean.MarkerBean) bv4VarQ.a()).getKey() + "_trip";
        }

        @Override // defpackage.md0
        public void b(hd0 hd0Var, md0.a aVar) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            if (bv4VarQ == null) {
                return;
            }
            LogUtil.d("FindMapTripManager", "loadBitmapAsync start " + ((LoadCountBean.MarkerBean) bv4VarQ.a()).avatar);
            c.this.x((LoadCountBean.MarkerBean) bv4VarQ.a(), new a(bv4VarQ, aVar, hd0Var));
        }

        @Override // defpackage.md0
        public Bitmap c(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            return (bv4VarQ == null || ((LoadCountBean.MarkerBean) bv4VarQ.a()).avatarBitmap == null) ? c.this.f : ((LoadCountBean.MarkerBean) bv4VarQ.a()).avatarBitmap;
        }

        @Override // defpackage.md0
        public boolean drawAsync() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements id0 {
        public e() {
        }

        @Override // defpackage.id0
        public void a(Marker marker, Object obj) {
            if (c.this.i != null) {
                if (!(obj instanceof hd0)) {
                    if (obj instanceof sc3) {
                        c.this.i.a(obj);
                    }
                } else {
                    hd0 hd0Var = (hd0) obj;
                    bv4 bv4VarQ = c.this.q(hd0Var);
                    if (bv4VarQ == null || bv4VarQ.a() == null) {
                        return;
                    }
                    c.this.i.a(c.this.q(hd0Var).a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadCountBean.MarkerBean f12253a;
        public final /* synthetic */ rn b;

        public f(LoadCountBean.MarkerBean markerBean, rn rnVar) {
            this.f12253a = markerBean;
            this.b = rnVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            LogUtil.d("MapPendantManager", "genMarkerBitmap onResourceReady resource " + bitmap);
            cn.v(this.f12253a, c.this.h, this.b, bitmap, false);
        }

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            LogUtil.d("MapPendantManager", "genMarkerBitmap onLoadFailed errorDrawable " + drawable);
            cn.v(this.f12253a, c.this.h, this.b, null, false);
        }
    }

    public c(Context context, ad3 ad3Var) {
        this.f12243a = context;
        this.c = ad3Var;
        this.f = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_map_male);
        this.g = BitmapFactory.decodeResource(this.f12243a.getResources(), R.drawable.ic_map_female);
        kd0 kd0Var = new kd0(((MapView) ad3Var.p()).getMap(), a46.b(context, 20.0f), this.f12243a);
        this.d = kd0Var;
        kd0Var.y(new a());
        this.d.A(0.1f);
        kd0 kd0Var2 = new kd0(((MapView) ad3Var.p()).getMap(), a46.b(context, 40.0f), this.f12243a);
        this.e = kd0Var2;
        kd0Var2.y(new b());
        this.e.z(new C0956c());
        this.e.A(0.2f);
        t(context);
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void K0(List<LoadCountBean.MarkerBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (LoadCountBean.MarkerBean markerBean : list) {
            arrayList.add(new bv4(markerBean.getLatLng(), markerBean));
        }
        this.d.w(arrayList);
    }

    @Override // defpackage.d74
    public void M(LocationEx locationEx) {
        kd0 kd0Var = this.d;
        if (kd0Var != null) {
            kd0Var.v(locationEx);
        }
        kd0 kd0Var2 = this.e;
        if (kd0Var2 != null) {
            kd0Var2.v(locationEx);
        }
        kd0 kd0Var3 = this.l;
        if (kd0Var3 != null) {
            kd0Var3.v(locationEx);
        }
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void O(b.a aVar) {
        this.i = aVar;
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void i(String str) {
        List<hd0> listQ;
        kd0 kd0Var = this.l;
        if (kd0Var == null || str == null || (listQ = kd0Var.q()) == null) {
            return;
        }
        for (int i = 0; i < listQ.size(); i++) {
            hd0 hd0Var = listQ.get(i);
            jd0 jd0VarE = hd0Var.e();
            if (jd0VarE instanceof bv4) {
                if (str.equals(((LoadCountBean.MarkerBean) ((bv4) jd0VarE).a()).uid + "") && hd0Var.d() != null) {
                    hd0Var.d().remove();
                    hd0Var.d().destroy();
                    return;
                }
            }
        }
    }

    public final void o() {
        LogUtil.d("MarkerHelper", "clearGlideRequest " + this.j.size());
        try {
            Iterator<Target> it = this.j.iterator();
            while (it.hasNext()) {
                hc2.a(this.f12243a).clear(it.next());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.j.clear();
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void onDestroy() {
        o();
        p();
        kd0 kd0Var = this.d;
        if (kd0Var != null) {
            kd0Var.u();
        }
        kd0 kd0Var2 = this.e;
        if (kd0Var2 != null) {
            kd0Var2.u();
        }
        kd0 kd0Var3 = this.l;
        if (kd0Var3 != null) {
            kd0Var3.u();
        }
    }

    public final void p() {
        try {
            Iterator<Target> it = this.m.iterator();
            while (it.hasNext()) {
                hc2.a(this.f12243a).clear(it.next());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.m.clear();
    }

    public final bv4<LoadCountBean.MarkerBean> q(hd0 hd0Var) {
        bv4<LoadCountBean.MarkerBean> bv4Var = (bv4) hd0Var.e();
        if (bv4Var == null) {
            List<bv4<LoadCountBean.MarkerBean>> listC = hd0Var.c();
            bv4<LoadCountBean.MarkerBean> bv4Var2 = (bv4) listC.get(0);
            for (bv4<LoadCountBean.MarkerBean> bv4Var3 : listC) {
                if ((vc3.c() && !TextUtils.isEmpty(bv4Var3.a().ornamentUrl)) || bv4Var3.a().gender != this.k) {
                    bv4Var = bv4Var3;
                    break;
                }
            }
            bv4Var = bv4Var2;
        }
        hd0Var.g(bv4Var);
        return bv4Var;
    }

    public final void r(LoadCountBean.MarkerBean markerBean, rn rnVar) {
        if (markerBean.avatarBitmap == null) {
            return;
        }
        try {
            LogUtil.d("MapPendantManager", "genMarkerBitmap bean.ornamentUrl " + markerBean.ornamentUrl);
            if (TextUtils.isEmpty(markerBean.ornamentUrl)) {
                cn.v(markerBean, this.h, rnVar, null, false);
            } else {
                Glide.with(AppContext.getContext()).asBitmap().load2(markerBean.ornamentUrl).into(new f(markerBean, rnVar));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void s(LoadCountBean.MarkerBean markerBean, rn rnVar) {
        if (markerBean.avatarBitmap == null) {
            return;
        }
        try {
            cn.v(markerBean, null, rnVar, null, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void t(Context context) {
        if (ew1.K()) {
            LogUtil.d("FindMapTripManager", "initTripOverlay");
            kd0 kd0Var = new kd0(((MapView) this.c.p()).getMap(), a46.b(context, 50.0f), this.f12243a);
            this.l = kd0Var;
            kd0Var.y(new d());
            this.l.z(new e());
            this.l.A(0.2f);
        }
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void u(List<LoadCountBean.MarkerBean> list) {
        LogUtil.d("FindMapTripManager", "refreshTripMarker start");
        if (this.l == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (LoadCountBean.MarkerBean markerBean : list) {
            arrayList.add(new bv4(markerBean.getLatLng(), markerBean));
        }
        p();
        this.l.w(arrayList);
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void u0(String str) {
        List<hd0> listQ;
        kd0 kd0Var = this.l;
        if (kd0Var == null || str == null || (listQ = kd0Var.q()) == null) {
            return;
        }
        for (int i = 0; i < listQ.size(); i++) {
            hd0 hd0Var = listQ.get(i);
            jd0 jd0VarE = hd0Var.e();
            if (jd0VarE instanceof bv4) {
                LoadCountBean.MarkerBean markerBean = (LoadCountBean.MarkerBean) ((bv4) jd0VarE).a();
                String str2 = markerBean.uid + "";
                LogUtil.d("FindMapTripManager", "changeTripBitmap uid " + str + " beanUid " + str2 + " markerBean.avatarOldBitmap " + markerBean.avatarOldBitmap);
                if (str.equals(str2)) {
                    if (markerBean.avatarOldBitmap == null) {
                        markerBean.avatarOldBitmap = ew1.w(str2);
                    }
                    Bitmap bitmap = markerBean.avatarOldBitmap;
                    if (bitmap != null) {
                        this.l.D(hd0Var, ew1.v(bitmap, markerBean, -1));
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void v(List<LoadCountBean.MarkerBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (LoadCountBean.MarkerBean markerBean : list) {
            String str = markerBean.ornamentUrl;
            if (!TextUtils.isEmpty(str) && str.endsWith(".svga")) {
                markerBean.ornamentUrl = str.replace(".svga", ".png");
            }
            arrayList.add(new bv4(markerBean.getLatLng(), markerBean));
        }
        o();
        this.e.w(arrayList);
    }

    public final void w(LoadCountBean.MarkerBean markerBean, RequestListener<Drawable> requestListener) {
        try {
            LogUtil.d("MarkerHelper", "startLoadAvatar " + markerBean.avatar);
            Target<Drawable> targetPreload = hc2.a(this.f12243a).load(markerBean.avatar).diskCacheStrategy(DiskCacheStrategy.DATA).listener(requestListener).preload();
            if (targetPreload != null) {
                this.j.add(targetPreload);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x(LoadCountBean.MarkerBean markerBean, RequestListener<Drawable> requestListener) {
        try {
            LogUtil.d("MarkerHelper", "startLoadAvatar " + markerBean.avatar);
            Target<Drawable> targetPreload = hc2.a(this.f12243a).load(markerBean.avatar).diskCacheStrategy(DiskCacheStrategy.DATA).listener(requestListener).preload();
            if (targetPreload != null) {
                this.m.add(targetPreload);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.d74
    public void y(LocationEx locationEx) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements md0 {
        public a() {
        }

        @Override // defpackage.md0
        public String a(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            return bv4VarQ != null ? ((LoadCountBean.MarkerBean) bv4VarQ.a()).getKey() : "empty";
        }

        @Override // defpackage.md0
        public Bitmap c(hd0 hd0Var) {
            bv4 bv4VarQ = c.this.q(hd0Var);
            return (bv4VarQ != null ? ((LoadCountBean.MarkerBean) bv4VarQ.a()).gender : 0) == 1 ? c.this.g : c.this.f;
        }

        @Override // defpackage.md0
        public boolean drawAsync() {
            return false;
        }

        @Override // defpackage.md0
        public void b(hd0 hd0Var, md0.a aVar) {
        }
    }
}
