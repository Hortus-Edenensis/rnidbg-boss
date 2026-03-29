package defpackage;

import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.mine.track.DynamicTrackBean;
import com.zenmen.palmchat.mine.track.UserTrackBean;
import defpackage.q05;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wz5 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<UserTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21838a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public a(String str, HashMap map, q05.d dVar) {
            this.f21838a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21838a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<UserTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<UserTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21839a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public b(String str, HashMap map, q05.d dVar) {
            this.f21839a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21839a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<UserTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<UserTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21840a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public c(String str, HashMap map, q05.d dVar) {
            this.f21840a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21840a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<UserTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<DynamicTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21841a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public d(String str, HashMap map, q05.d dVar) {
            this.f21841a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21841a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<DynamicTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends go2<LXBaseNetBean<DynamicTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21842a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public e(String str, HashMap map, q05.d dVar) {
            this.f21842a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21842a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<DynamicTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<DynamicTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21843a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.d c;

        public f(String str, HashMap map, q05.d dVar) {
            this.f21843a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f21843a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<DynamicTrackBean> lXBaseNetBean, Exception exc) {
            if (z) {
                this.c.b(lXBaseNetBean);
            } else {
                this.c.a(exc);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static wz5 f21844a = new wz5();
    }

    public static wz5 i() {
        return g.f21844a;
    }

    public void a(int i, Long l, q05.d<LXBaseNetBean<DynamicTrackBean>> dVar) {
        if (i == 0) {
            d(l, dVar);
        } else if (i == 1) {
            b(l, dVar);
        } else if (i == 2) {
            c(l, dVar);
        }
    }

    public void b(Long l, q05.d<LXBaseNetBean<DynamicTrackBean>> dVar) {
        String str = nl0.z + "/track.query.square.comment.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        map.put("version", l);
        zw4.e(new e(str, map, dVar));
    }

    public void c(Long l, q05.d<LXBaseNetBean<DynamicTrackBean>> dVar) {
        String str = nl0.z + "/track.query.square.like.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        map.put("version", l);
        zw4.e(new f(str, map, dVar));
    }

    public void d(Long l, q05.d<LXBaseNetBean<DynamicTrackBean>> dVar) {
        String str = nl0.z + "/track.query.square.visit.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        map.put("version", l);
        zw4.e(new d(str, map, dVar));
    }

    public void e(q05.d<LXBaseNetBean<UserTrackBean>> dVar) {
        String str = nl0.z + "/track.query.user.brush.past.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        zw4.e(new a(str, map, dVar));
    }

    public void f(Long l, q05.d<LXBaseNetBean<UserTrackBean>> dVar) {
        String str = nl0.z + "/track.query.user.like.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        map.put("version", l);
        zw4.e(new c(str, map, dVar));
    }

    public void g(int i, Long l, q05.d<LXBaseNetBean<UserTrackBean>> dVar) {
        if (i == 0) {
            e(dVar);
        } else if (i == 1) {
            h(l, dVar);
        } else if (i == 2) {
            f(l, dVar);
        }
    }

    public void h(Long l, q05.d<LXBaseNetBean<UserTrackBean>> dVar) {
        String str = nl0.z + "/track.query.user.visit.list.v1";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
            map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            map.put("longitude", Double.valueOf(locationExI.getLongitude()));
        }
        map.put("version", l);
        zw4.e(new b(str, map, dVar));
    }

    public wz5() {
    }
}
