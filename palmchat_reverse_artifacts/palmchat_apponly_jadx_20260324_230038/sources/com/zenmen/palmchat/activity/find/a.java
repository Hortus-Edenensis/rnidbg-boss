package com.zenmen.palmchat.activity.find;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.apis.cluster.BaiduCluster;
import com.baidu.apis.cluster.BaiduClusterClickListener;
import com.baidu.apis.cluster.BaiduClusterItem;
import com.baidu.apis.cluster.BaiduClusterOverlay;
import com.baidu.apis.cluster.BaiduClusterRender;
import com.baidu.apis.cluster.demo.BaiduRegionItem;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
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
import defpackage.cn;
import defpackage.ed3;
import defpackage.ew1;
import defpackage.hc2;
import defpackage.rn;
import defpackage.sc3;
import defpackage.v4;
import defpackage.vc3;
import defpackage.yo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a implements com.zenmen.palmchat.activity.find.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12231a;
    public ad3 c;
    public BaiduClusterOverlay d;
    public BaiduClusterOverlay e;
    public Bitmap f;
    public Bitmap g;
    public Bitmap h;
    public b.a i;
    public BaiduClusterOverlay l;
    public Map<String, ed3> b = new HashMap();
    public Set<Target> j = new HashSet();
    public int k = v4.f().getGender();
    public Set<Target> m = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BaiduClusterRender {

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0951a implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaiduRegionItem f12234a;
            public final /* synthetic */ BaiduClusterRender.LoadCallback b;
            public final /* synthetic */ BaiduCluster c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0952a implements rn {
                public C0952a() {
                }

                @Override // defpackage.rn
                public void run(int i, String str, Object obj) {
                    if (obj instanceof Bitmap) {
                        ((LoadCountBean.MarkerBean) C0951a.this.f12234a.getExtObject()).avatarBitmap = (Bitmap) obj;
                        C0951a c0951a = C0951a.this;
                        c0951a.b.onBitmapCallback(c0951a.c);
                    }
                }
            }

            public C0951a(BaiduRegionItem baiduRegionItem, BaiduClusterRender.LoadCallback loadCallback, BaiduCluster baiduCluster) {
                this.f12234a = baiduRegionItem;
                this.b = loadCallback;
                this.c = baiduCluster;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                LogUtil.d("BaiduMarkerHelper", "onResourceReady ");
                if (target != null) {
                    a.this.j.remove(target);
                }
                ((LoadCountBean.MarkerBean) this.f12234a.getExtObject()).avatarBitmap = ((BitmapDrawable) drawable).getBitmap();
                if (a.this.h == null) {
                    a aVar = a.this;
                    aVar.h = BitmapFactory.decodeResource(aVar.f12231a.getResources(), R.drawable.ic_near_avatar_bg);
                }
                a.this.r((LoadCountBean.MarkerBean) this.f12234a.getExtObject(), new C0952a());
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                LogUtil.d("BaiduMarkerHelper", "onLoadFailed ");
                if (target == null) {
                    return false;
                }
                a.this.j.remove(target);
                return false;
            }
        }

        public b() {
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public boolean drawAsync() {
            return true;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public Bitmap getDrawAble(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            return (baiduRegionItemQ == null || ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).avatarBitmap == null) ? a.this.f : ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).avatarBitmap;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public String getKey(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            return baiduRegionItemQ != null ? ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).getKey() : "empty";
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public void loadBitmapAsync(BaiduCluster baiduCluster, BaiduClusterRender.LoadCallback loadCallback) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            if (baiduRegionItemQ == null) {
                return;
            }
            a.this.w((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject(), new C0951a(baiduRegionItemQ, loadCallback, baiduCluster));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements BaiduClusterClickListener {
        public c() {
        }

        @Override // com.baidu.apis.cluster.BaiduClusterClickListener
        public void onClick(Marker marker, Object obj) {
            BaiduCluster baiduCluster;
            BaiduRegionItem baiduRegionItemQ;
            if (a.this.i == null || !(obj instanceof BaiduCluster) || (baiduRegionItemQ = a.this.q((baiduCluster = (BaiduCluster) obj))) == null || baiduRegionItemQ.getExtObject() == null) {
                return;
            }
            a.this.i.a(a.this.q(baiduCluster).getExtObject());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements BaiduMap.OnMarkerClickListener {
        public d() {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            int i;
            if (marker.getExtraInfo() == null || (i = marker.getExtraInfo().getInt("mapClickTypeKey")) <= 0) {
                return false;
            }
            sc3 sc3VarA = sc3.a(i);
            if (marker.getPosition() != null) {
                LocationEx locationEx = new LocationEx();
                locationEx.setLongitude(marker.getPosition().longitude);
                locationEx.setLatitude(marker.getPosition().latitude);
                sc3VarA.f20713a = locationEx;
            }
            a.this.i.a(sc3VarA);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements BaiduClusterRender {

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0953a implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaiduRegionItem f12239a;
            public final /* synthetic */ BaiduClusterRender.LoadCallback b;
            public final /* synthetic */ BaiduCluster c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.a$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0954a implements rn {
                public C0954a() {
                }

                @Override // defpackage.rn
                public void run(int i, String str, Object obj) {
                    if (obj instanceof Bitmap) {
                        ((LoadCountBean.MarkerBean) C0953a.this.f12239a.getExtObject()).avatarBitmap = (Bitmap) obj;
                        C0953a c0953a = C0953a.this;
                        c0953a.b.onBitmapCallback(c0953a.c);
                    }
                }
            }

            public C0953a(BaiduRegionItem baiduRegionItem, BaiduClusterRender.LoadCallback loadCallback, BaiduCluster baiduCluster) {
                this.f12239a = baiduRegionItem;
                this.b = loadCallback;
                this.c = baiduCluster;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                if (target != null) {
                    a.this.m.remove(target);
                }
                LogUtil.d("FindMapTripManager", "loadBitmapAsync onResourceReady " + ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).avatar);
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).avatarBitmap = bitmapDrawable.getBitmap();
                ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).avatarOldBitmap = bitmapDrawable.getBitmap();
                ew1.i0("view", ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).uid + "", ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).scheduleOrderId);
                a.this.s((LoadCountBean.MarkerBean) this.f12239a.getExtObject(), new C0954a());
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                if (target != null) {
                    a.this.m.remove(target);
                }
                LogUtil.d("FindMapTripManager", "onLoadFailed " + ((LoadCountBean.MarkerBean) this.f12239a.getExtObject()).avatar);
                return false;
            }
        }

        public e() {
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public boolean drawAsync() {
            return true;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public Bitmap getDrawAble(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            return (baiduRegionItemQ == null || ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).avatarBitmap == null) ? a.this.f : ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).avatarBitmap;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public String getKey(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            if (baiduRegionItemQ == null) {
                return "empty";
            }
            return ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).getKey() + "_trip";
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public void loadBitmapAsync(BaiduCluster baiduCluster, BaiduClusterRender.LoadCallback loadCallback) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            if (baiduRegionItemQ == null) {
                return;
            }
            LogUtil.d("FindMapTripManager", "loadBitmapAsync start " + ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).avatar);
            a.this.x((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject(), new C0953a(baiduRegionItemQ, loadCallback, baiduCluster));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements BaiduClusterClickListener {
        public f() {
        }

        @Override // com.baidu.apis.cluster.BaiduClusterClickListener
        public void onClick(Marker marker, Object obj) {
            BaiduCluster baiduCluster;
            BaiduRegionItem baiduRegionItemQ;
            if (a.this.i == null || !(obj instanceof BaiduCluster) || (baiduRegionItemQ = a.this.q((baiduCluster = (BaiduCluster) obj))) == null || baiduRegionItemQ.getExtObject() == null) {
                return;
            }
            a.this.i.a(a.this.q(baiduCluster).getExtObject());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadCountBean.MarkerBean f12242a;
        public final /* synthetic */ rn b;

        public g(LoadCountBean.MarkerBean markerBean, rn rnVar) {
            this.f12242a = markerBean;
            this.b = rnVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            LogUtil.d("MapPendantManager", "genMarkerBitmap onResourceReady resource " + bitmap);
            cn.v(this.f12242a, a.this.h, this.b, bitmap, false);
        }

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            LogUtil.d("MapPendantManager", "genMarkerBitmap onLoadFailed errorDrawable " + drawable);
            cn.v(this.f12242a, a.this.h, this.b, null, false);
        }
    }

    public a(Context context, ad3 ad3Var) {
        this.f12231a = context;
        this.c = ad3Var;
        this.f = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_map_male);
        this.g = BitmapFactory.decodeResource(this.f12231a.getResources(), R.drawable.ic_map_female);
        yo yoVar = (yo) ad3Var;
        BaiduClusterOverlay baiduClusterOverlay = new BaiduClusterOverlay(yoVar.x(), a46.b(context, 20.0f), this.f12231a);
        this.d = baiduClusterOverlay;
        baiduClusterOverlay.setClusterRenderer(new C0950a());
        this.d.setzIndex(1.0f);
        BaiduClusterOverlay baiduClusterOverlay2 = new BaiduClusterOverlay(yoVar.x(), a46.b(context, 40.0f), this.f12231a);
        this.e = baiduClusterOverlay2;
        baiduClusterOverlay2.setClusterRenderer(new b());
        this.e.setOnClusterClickListener(new c());
        this.e.setzIndex(3.0f);
        t(context);
        yoVar.x().setOnMarkerClickListener(new d());
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void K0(List<LoadCountBean.MarkerBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (LoadCountBean.MarkerBean markerBean : list) {
            arrayList.add(new BaiduRegionItem(new LatLng(markerBean.getLatLng().latitude, markerBean.getLatLng().longitude), markerBean));
        }
        this.d.refreshClusters(arrayList);
    }

    @Override // defpackage.d74
    public void M(LocationEx locationEx) {
        BaiduClusterOverlay baiduClusterOverlay = this.d;
        if (baiduClusterOverlay != null) {
            baiduClusterOverlay.onMapDrag(locationEx);
        }
        BaiduClusterOverlay baiduClusterOverlay2 = this.e;
        if (baiduClusterOverlay2 != null) {
            baiduClusterOverlay2.onMapDrag(locationEx);
        }
        BaiduClusterOverlay baiduClusterOverlay3 = this.l;
        if (baiduClusterOverlay3 != null) {
            baiduClusterOverlay3.onMapDrag(locationEx);
        }
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void O(b.a aVar) {
        this.i = aVar;
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void i(String str) {
        List<BaiduCluster> allCluster;
        BaiduClusterOverlay baiduClusterOverlay = this.l;
        if (baiduClusterOverlay == null || str == null || (allCluster = baiduClusterOverlay.getAllCluster()) == null) {
            return;
        }
        for (int i = 0; i < allCluster.size(); i++) {
            BaiduCluster baiduCluster = allCluster.get(i);
            BaiduClusterItem targetItem = baiduCluster.getTargetItem();
            if (targetItem instanceof BaiduRegionItem) {
                if (str.equals(((LoadCountBean.MarkerBean) ((BaiduRegionItem) targetItem).getExtObject()).uid + "") && baiduCluster.getMarker() != null) {
                    baiduCluster.getMarker().remove();
                    return;
                }
            }
        }
    }

    public final void o() {
        LogUtil.d("BaiduMarkerHelper", "clearGlideRequest " + this.j.size());
        try {
            Iterator<Target> it = this.j.iterator();
            while (it.hasNext()) {
                hc2.a(this.f12231a).clear(it.next());
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
        BaiduClusterOverlay baiduClusterOverlay = this.d;
        if (baiduClusterOverlay != null) {
            baiduClusterOverlay.onDestroy();
        }
        BaiduClusterOverlay baiduClusterOverlay2 = this.e;
        if (baiduClusterOverlay2 != null) {
            baiduClusterOverlay2.onDestroy();
        }
        BaiduClusterOverlay baiduClusterOverlay3 = this.l;
        if (baiduClusterOverlay3 != null) {
            baiduClusterOverlay3.onDestroy();
        }
    }

    public final void p() {
        try {
            Iterator<Target> it = this.m.iterator();
            while (it.hasNext()) {
                hc2.a(this.f12231a).clear(it.next());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.m.clear();
    }

    public final BaiduRegionItem<LoadCountBean.MarkerBean> q(BaiduCluster baiduCluster) {
        BaiduRegionItem<LoadCountBean.MarkerBean> baiduRegionItem = (BaiduRegionItem) baiduCluster.getTargetItem();
        if (baiduRegionItem == null) {
            List<BaiduRegionItem<LoadCountBean.MarkerBean>> clusterItems = baiduCluster.getClusterItems();
            BaiduRegionItem<LoadCountBean.MarkerBean> baiduRegionItem2 = (BaiduRegionItem) clusterItems.get(0);
            for (BaiduRegionItem<LoadCountBean.MarkerBean> baiduRegionItem3 : clusterItems) {
                if ((vc3.c() && !TextUtils.isEmpty(baiduRegionItem3.getExtObject().ornamentUrl)) || baiduRegionItem3.getExtObject().gender != this.k) {
                    baiduRegionItem = baiduRegionItem3;
                    break;
                }
            }
            baiduRegionItem = baiduRegionItem2;
        }
        baiduCluster.setTargetItem(baiduRegionItem);
        return baiduRegionItem;
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
                Glide.with(AppContext.getContext()).asBitmap().load2(markerBean.ornamentUrl).into(new g(markerBean, rnVar));
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
            BaiduClusterOverlay baiduClusterOverlay = new BaiduClusterOverlay(((yo) this.c).x(), a46.b(context, 50.0f), this.f12231a);
            this.l = baiduClusterOverlay;
            baiduClusterOverlay.setClusterRenderer(new e());
            this.l.setOnClusterClickListener(new f());
            this.l.setzIndex(2.0f);
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
            arrayList.add(new BaiduRegionItem(new LatLng(markerBean.getLatLng().latitude, markerBean.getLatLng().longitude), markerBean));
        }
        p();
        this.l.refreshClusters(arrayList);
    }

    @Override // com.zenmen.palmchat.activity.find.b
    public void u0(String str) {
        List<BaiduCluster> allCluster;
        BaiduClusterOverlay baiduClusterOverlay = this.l;
        if (baiduClusterOverlay == null || str == null || (allCluster = baiduClusterOverlay.getAllCluster()) == null) {
            return;
        }
        for (int i = 0; i < allCluster.size(); i++) {
            BaiduCluster baiduCluster = allCluster.get(i);
            BaiduClusterItem targetItem = baiduCluster.getTargetItem();
            if (targetItem instanceof BaiduRegionItem) {
                LoadCountBean.MarkerBean markerBean = (LoadCountBean.MarkerBean) ((BaiduRegionItem) targetItem).getExtObject();
                String str2 = markerBean.uid + "";
                LogUtil.d("FindMapTripManager", "changeTripBitmap uid " + str + " beanUid " + str2 + " markerBean.avatarOldBitmap " + markerBean.avatarOldBitmap);
                if (str.equals(str2)) {
                    if (markerBean.avatarOldBitmap == null) {
                        markerBean.avatarOldBitmap = ew1.w(str2);
                    }
                    Bitmap bitmap = markerBean.avatarOldBitmap;
                    if (bitmap != null) {
                        this.l.updateClusterBitmap(baiduCluster, ew1.v(bitmap, markerBean, -1));
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
            arrayList.add(new BaiduRegionItem(new LatLng(markerBean.getLatLng().latitude, markerBean.getLatLng().longitude), markerBean));
        }
        o();
        this.e.refreshClusters(arrayList);
    }

    public final void w(LoadCountBean.MarkerBean markerBean, RequestListener<Drawable> requestListener) {
        try {
            LogUtil.d("BaiduMarkerHelper", "startLoadAvatar " + markerBean.avatar);
            Target<Drawable> targetPreload = hc2.a(this.f12231a).load(markerBean.avatar).diskCacheStrategy(DiskCacheStrategy.DATA).listener(requestListener).preload();
            if (targetPreload != null) {
                this.j.add(targetPreload);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x(LoadCountBean.MarkerBean markerBean, RequestListener<Drawable> requestListener) {
        try {
            LogUtil.d("BaiduMarkerHelper", "startLoadAvatar " + markerBean.avatar);
            Target<Drawable> targetPreload = hc2.a(this.f12231a).load(markerBean.avatar).diskCacheStrategy(DiskCacheStrategy.DATA).listener(requestListener).preload();
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

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.find.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0950a implements BaiduClusterRender {
        public C0950a() {
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public boolean drawAsync() {
            return false;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public Bitmap getDrawAble(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            return (baiduRegionItemQ != null ? ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).gender : 0) == 1 ? a.this.g : a.this.f;
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public String getKey(BaiduCluster baiduCluster) {
            BaiduRegionItem baiduRegionItemQ = a.this.q(baiduCluster);
            return baiduRegionItemQ != null ? ((LoadCountBean.MarkerBean) baiduRegionItemQ.getExtObject()).getKey() : "empty";
        }

        @Override // com.baidu.apis.cluster.BaiduClusterRender
        public void loadBitmapAsync(BaiduCluster baiduCluster, BaiduClusterRender.LoadCallback loadCallback) {
        }
    }
}
