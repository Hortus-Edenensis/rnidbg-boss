package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.find.separation.MapBuySuccessModel;
import com.zenmen.palmchat.activity.find.separation.MapSeparationModel;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.je1;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static je1 f21922a = null;
    public static MapSeparationModel b = null;
    public static int c = 30;
    public static long d;
    public static TextView e;
    public static TextView f;
    public static TextView g;
    public static Activity h;
    public static SimpleDateFormat i = new SimpleDateFormat("mm:ss");
    public static SimpleDateFormat j = new SimpleDateFormat("HH:mm:ss");
    public static String k = "";
    public static LocationEx l = null;
    public static Timer m = null;
    public static MaterialDialog n = null;
    public static MaterialDialog o = null;
    public static vm2 p = null;
    public static Handler q = new d(Looper.getMainLooper());
    public static HashMap<Integer, Boolean> r;
    public static boolean s;
    public static boolean t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements yo3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc3 f21923a;
        public final /* synthetic */ FindNearByMapActivity b;
        public final /* synthetic */ LocationEx c;

        public a(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
            this.f21923a = wc3Var;
            this.b = findNearByMapActivity;
            this.c = locationEx;
        }

        @Override // defpackage.yo3
        public void a(Object obj) {
            LogUtil.d("", "startCharge buySeparation onFinish o " + obj);
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() && dw1.m()) {
                dw1.G(this.f21923a, this.b, this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f21924a;
        public final /* synthetic */ String b;

        public c(LocationEx locationEx, String str) {
            this.f21924a = locationEx;
            this.b = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
            LocationEx locationEx = this.f21924a;
            if (locationEx != null) {
                map.put("latitude", Double.valueOf(locationEx.getLatitude()));
                map.put("longitude", Double.valueOf(this.f21924a.getLongitude()));
            }
            map.put("address", this.b);
            return sw4.b(1, nl0.z + "/lbs.square.map.find.move.doppelganger.v1", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            xc3.t = false;
            if (xc3.b != null) {
                xc3.P();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            xc3.d--;
            if (xc3.d < 0) {
                if (xc3.m != null) {
                    xc3.m.cancel();
                    xc3.m = null;
                }
                if (xc3.n != null && xc3.n.isShowing()) {
                    xc3.n.dismiss();
                    xc3.n = null;
                }
                if (xc3.o != null && xc3.o.isShowing()) {
                    xc3.o.dismiss();
                    xc3.o = null;
                }
                Activity activity = xc3.h;
                if (activity != null) {
                    xc3.M(null, activity, 3);
                    return;
                }
                return;
            }
            String str = xc3.j.format(Long.valueOf(xc3.d * 1000));
            if (xc3.d > 86400) {
                int i = (int) (xc3.d / 86400);
                str = i + "天" + xc3.j.format(Long.valueOf((xc3.d - ((long) (86400 * i))) * 1000));
            } else if (xc3.d <= 3600) {
                str = xc3.i.format(Long.valueOf(xc3.d * 1000));
            }
            TextView textView = xc3.e;
            if (textView != null && textView.getVisibility() == 0) {
                xc3.e.setText(str);
            }
            if (xc3.f != null && xc3.f.getVisibility() == 0) {
                xc3.f.setText(str);
            }
            if (xc3.g == null || xc3.g.getVisibility() != 0) {
                return;
            }
            xc3.g.setText(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || xc3.n == null) {
                return;
            }
            xc3.n.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || xc3.o == null) {
                return;
            }
            xc3.o.dismiss();
            xc3.o = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            xc3.q.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f21925a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public h(MaterialDialog materialDialog, Activity activity, int i) {
            this.f21925a = materialDialog;
            this.b = activity;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f21925a.dismiss();
            Activity activity = this.b;
            if (!(activity instanceof FindNearByMapActivity)) {
                xc3.y(activity, this.c);
                return;
            }
            FindNearByMapActivity findNearByMapActivity = (FindNearByMapActivity) activity;
            findNearByMapActivity.A3(xc3.C());
            findNearByMapActivity.F3(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f21926a;

        public i(MaterialDialog materialDialog) {
            this.f21926a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f21926a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends go2<LXBaseNetBean<MapSeparationModel>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21927a;
        public final /* synthetic */ wc3 b;
        public final /* synthetic */ Activity c;

        public j(int i, wc3 wc3Var, Activity activity) {
            this.f21927a = i;
            this.b = wc3Var;
            this.c = activity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return xc3.F();
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<MapSeparationModel> lXBaseNetBean, Exception exc) {
            MapSeparationModel mapSeparationModel;
            xc3.r.put(Integer.valueOf(this.f21927a), Boolean.FALSE);
            LogUtil.i("MapSeparationManager", "requestSeparationStatus info onResult=" + az2.c(lXBaseNetBean) + " from " + this.f21927a + " callBack " + this.b);
            if (lXBaseNetBean != null) {
                try {
                    if (lXBaseNetBean.resultCode != 0 || (mapSeparationModel = lXBaseNetBean.data) == null) {
                        return;
                    }
                    vc3.d(mapSeparationModel);
                    MapSeparationModel mapSeparationModel2 = lXBaseNetBean.data;
                    dw1.j = mapSeparationModel2.tipStatus;
                    xc3.b = mapSeparationModel2;
                    if (xc3.p != null) {
                        xc3.p.separationState(lXBaseNetBean.data.status);
                    }
                    xc3.d = xc3.b.remainSeconds;
                    int i = this.f21927a;
                    if (i != 1 && i != 3) {
                        xc3.z(xc3.b.status);
                        wc3 wc3Var = this.b;
                        if (wc3Var != null) {
                            wc3Var.b(xc3.b);
                            return;
                        }
                        return;
                    }
                    if (xc3.b.status == -100) {
                        xc3.R(this.c, 0);
                    }
                    if (xc3.b.status != 1) {
                        Activity activity = this.c;
                        if (activity instanceof FindNearByMapActivity) {
                            ((FindNearByMapActivity) activity).M2(false);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends go2<LXBaseNetBean<MapBuySuccessModel>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f21928a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wc3 c;
        public final /* synthetic */ FindNearByMapActivity d;

        public k(LocationEx locationEx, String str, wc3 wc3Var, FindNearByMapActivity findNearByMapActivity) {
            this.f21928a = locationEx;
            this.b = str;
            this.c = wc3Var;
            this.d = findNearByMapActivity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return xc3.E(this.f21928a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<MapBuySuccessModel> lXBaseNetBean, Exception exc) {
            LogUtil.i("MapSeparationManager", "buySeparation info onResult=" + az2.c(lXBaseNetBean));
            boolean z2 = false;
            xc3.s = false;
            if (z && lXBaseNetBean != null) {
                int i = lXBaseNetBean.resultCode;
                if (i == -1004) {
                    xc3.T(this.c, this.d, this.f21928a);
                } else if (i == 0) {
                    xc3.O(this.c, lXBaseNetBean);
                    z2 = true;
                }
            }
            if (dw1.m() && z2) {
                this.d.D3();
            }
        }
    }

    static {
        HashMap<Integer, Boolean> map = new HashMap<>();
        r = map;
        Boolean bool = Boolean.FALSE;
        map.put(2, bool);
        r.put(3, bool);
        r.put(1, bool);
        s = false;
        t = false;
    }

    public static Bitmap A(Bitmap bitmap, Activity activity, Bitmap bitmap2) {
        if (activity == null || bitmap == null) {
            return bitmap;
        }
        Context applicationContext = activity.getApplicationContext();
        int iB = a46.b(applicationContext, 68.0f);
        int iB2 = a46.b(applicationContext, 72.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, Bitmap.Config.ARGB_8888);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(applicationContext.getResources(), R.drawable.map_separation_icon_location_bg);
        int iB3 = iB2 - a46.b(applicationContext, 8.0f);
        int iMin = Math.min(bitmap.getHeight(), bitmap.getWidth());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * iB3) / iMin, (iB3 * bitmap.getHeight()) / iMin, false);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmapDecodeResource, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateScaledBitmap, tileMode, tileMode));
        canvas.drawCircle(a46.b(applicationContext, 34.0f), a46.b(applicationContext, 32.0f), a46.b(applicationContext, 26.0f), paint);
        int iB4 = a46.b(applicationContext, 23.0f);
        int iB5 = a46.b(applicationContext, 23.0f);
        int iB6 = a46.b(applicationContext, 40.0f);
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(applicationContext.getResources(), R.drawable.location_separation_icon_bottom);
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeResource2, iB4, iB5, false);
        float f2 = iB6;
        canvas.drawBitmap(bitmapCreateScaledBitmap2, f2, f2, (Paint) null);
        if (vc3.c()) {
            LogUtil.d("MapPendantManager", "genSeparationAvatarMark pendantBitmap " + bitmap2);
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap3 = Bitmap.createScaledBitmap(bitmap2, iB, iB2, false);
                canvas.drawBitmap(bitmapCreateScaledBitmap3, 0.0f, 0.0f, (Paint) null);
                bitmapCreateScaledBitmap3.recycle();
            }
        }
        bitmapDecodeResource2.recycle();
        bitmapCreateScaledBitmap2.recycle();
        bitmapCreateScaledBitmap.recycle();
        bitmapDecodeResource.recycle();
        return bitmapCreateBitmap;
    }

    public static MapSeparationModel B() {
        return b;
    }

    public static LocationEx C() {
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_last_separation_location_sp", 0);
        String string = sharedPreferences.getString("map_last_separation_location_la", "");
        String string2 = sharedPreferences.getString("map_last_separation_location_lg", "");
        try {
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            double d2 = Double.parseDouble(string);
            double d3 = Double.parseDouble(string2);
            LogUtil.d("MapSeparationManager", "getLastSeparationEx latitude " + d2 + " longitude " + d3);
            LocationEx locationEx = new LocationEx();
            locationEx.setLongitude(d3);
            locationEx.setLatitude(d2);
            return locationEx;
        } catch (Exception unused) {
            return null;
        }
    }

    public static je1 D() {
        if (f21922a == null) {
            f21922a = new je1.a().s(false).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.default_portrait).r();
        }
        return f21922a;
    }

    public static sw4 E(LocationEx locationEx, String str) {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
        map.put("taichiGroup", G());
        if (locationEx != null) {
            map.put("latitude", Double.valueOf(locationEx.getLatitude()));
            map.put("longitude", Double.valueOf(locationEx.getLongitude()));
        }
        map.put("address", str);
        map.put("taichiGroup2", "A");
        map.put("taichiGroupLx66032", t66.h().e("LX-66344", "A"));
        map.put("productId", Integer.valueOf(dw1.C()));
        return sw4.b(1, nl0.z + "/lbs.square.map.find.set.doppelganger.v3", map).f(true);
    }

    public static sw4 F() {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
        map.put("taichiGroup", G());
        return sw4.b(1, nl0.z + "/lbs.square.map.find.get.doppelganger.v1", map).f(false);
    }

    public static String G() {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU;
    }

    public static void H() {
        LogUtil.d("MapSeparationManager", "initTimer mAllTimer " + m);
        if (m == null) {
            m = new Timer();
            i.setTimeZone(DesugarTimeZone.getTimeZone("GMT+00:00"));
            j.setTimeZone(DesugarTimeZone.getTimeZone("GMT+00:00"));
            m.schedule(new g(), 1000L, 1000L);
        }
    }

    public static boolean I() {
        return !"A".equalsIgnoreCase(G());
    }

    public static void J(LocationEx locationEx, String str) {
        if (locationEx == null) {
            ry5.a("位置获取失败，请求稍后重试");
        } else {
            if (t) {
                return;
            }
            t = true;
            zw4.e(new c(locationEx, str));
        }
    }

    public static void K() {
        Timer timer = m;
        if (timer != null) {
            timer.cancel();
            m = null;
        }
        n = null;
        e = null;
        o = null;
        g = null;
        h = null;
        LogUtil.d("MapSeparationManager", "onDestroy mAllTimer " + m);
    }

    public static void L(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx, String str) {
        zw4.e(new k(locationEx, str, wc3Var, findNearByMapActivity));
    }

    public static synchronized void M(wc3 wc3Var, Activity activity, int i2) {
        if (r.get(Integer.valueOf(i2)).booleanValue()) {
            return;
        }
        r.put(Integer.valueOf(i2), Boolean.TRUE);
        zw4.e(new j(i2, wc3Var, activity));
    }

    public static void N(LocationEx locationEx) {
        if (locationEx != null) {
            SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("map_last_separation_location_sp", 0);
            sharedPreferences.edit().putString("map_last_separation_location_la", locationEx.getLatitude() + "").apply();
            sharedPreferences.edit().putString("map_last_separation_location_lg", locationEx.getLongitude() + "").apply();
            LogUtil.d("MapSeparationManager", "saveLastSeparationEx locationEx " + locationEx);
        }
    }

    public static void O(wc3 wc3Var, LXBaseNetBean<MapBuySuccessModel> lXBaseNetBean) {
        MapBuySuccessModel mapBuySuccessModel;
        if (wc3Var == null || lXBaseNetBean == null || (mapBuySuccessModel = lXBaseNetBean.data) == null) {
            return;
        }
        int i2 = mapBuySuccessModel.remainSeconds;
        MapSeparationModel mapSeparationModel = b;
        if (mapSeparationModel != null) {
            mapSeparationModel.status = 1;
            if (i2 > 0) {
                mapSeparationModel.remainSeconds = i2;
                d = i2;
            }
            P();
        }
        H();
        wc3Var.a(b);
    }

    public static void P() {
        if (b != null) {
            if (TextUtils.isEmpty(k)) {
                dw1.F("SepManager setSeparationCurAddress", com.zenmen.palmchat.c.b(), new b(), l);
            } else {
                b.address = k;
            }
        }
    }

    public static void Q(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            zn6.b("page_mapfinder_setanotherme_activepopup");
            n = null;
            View viewInflate = View.inflate(activity.getApplicationContext(), R.layout.layout_map_sepation_ing_dialog, null);
            MaterialDialog materialDialogE = new sd3(activity).p(viewInflate, false).h(true).e();
            n = materialDialogE;
            materialDialogE.show();
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.map_separation_dialog_icon);
            if (!TextUtils.isEmpty(v4.f().getIconURL())) {
                gr2.j().h(v4.f().getIconURL(), effectiveShapeView, D());
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.map_separation_bug_success_marquee);
            textView.setSelected(true);
            MapSeparationModel mapSeparationModel = b;
            if (mapSeparationModel != null && !TextUtils.isEmpty(mapSeparationModel.address)) {
                textView.setText("当前分身位置：" + b.address);
            }
            g = (TextView) viewInflate.findViewById(R.id.separation_success_time);
            H();
            ((ImageView) viewInflate.findViewById(R.id.location_separation_success_layout_close)).setOnClickListener(new e());
        } catch (Exception unused) {
        }
    }

    public static void R(Activity activity, int i2) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            if (activity instanceof FindNearByMapActivity) {
                ((FindNearByMapActivity) activity).e3();
            }
            zn6.b("page_mapfinder_setanotherme_overpopup");
            View viewInflate = View.inflate(activity.getApplicationContext(), R.layout.layout_map_sepation_end_dialog, null);
            MaterialDialog materialDialogE = new sd3(activity).p(viewInflate, false).h(true).e();
            materialDialogE.show();
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.map_separation_dialog_icon);
            if (!TextUtils.isEmpty(v4.f().getIconURL())) {
                gr2.j().h(v4.f().getIconURL(), effectiveShapeView, D());
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.map_separation_bug_success_marquee);
            textView.setSelected(true);
            MapSeparationModel mapSeparationModel = b;
            if (mapSeparationModel != null && !TextUtils.isEmpty(mapSeparationModel.address)) {
                textView.setText("当前分身位置：" + b.address);
            }
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.map_separation_bug_end_desc);
            MapSeparationModel mapSeparationModel2 = b;
            if (mapSeparationModel2 != null && !TextUtils.isEmpty(mapSeparationModel2.expiredText)) {
                textView2.setText(b.expiredText);
            }
            ((TextView) viewInflate.findViewById(R.id.map_separation_bug_end)).setOnClickListener(new h(materialDialogE, activity, i2));
            ((ImageView) viewInflate.findViewById(R.id.location_separation_success_layout_close)).setOnClickListener(new i(materialDialogE));
        } catch (Exception unused) {
        }
    }

    public static void S(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        LogUtil.d("MapSeparationManager", "MapSeparationManager showSeparationSuccessDialog delayTime " + d);
        try {
            View viewInflate = View.inflate(activity.getApplicationContext(), R.layout.layout_map_sepation_buy_success_dialog, null);
            o = null;
            MaterialDialog materialDialogE = new sd3(activity).p(viewInflate, false).h(true).e();
            o = materialDialogE;
            materialDialogE.show();
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.map_separation_dialog_icon);
            if (!TextUtils.isEmpty(v4.f().getIconURL())) {
                gr2.j().h(v4.f().getIconURL(), effectiveShapeView, D());
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.map_separation_bug_success_marquee);
            textView.setSelected(true);
            MapSeparationModel mapSeparationModel = b;
            if (mapSeparationModel != null && !TextUtils.isEmpty(mapSeparationModel.address)) {
                textView.setText("当前分身位置：" + b.address);
            }
            f = (TextView) viewInflate.findViewById(R.id.separation_success_time);
            H();
            ((ImageView) viewInflate.findViewById(R.id.location_separation_success_layout_close)).setOnClickListener(new f());
        } catch (Exception unused) {
        }
    }

    public static void T(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
        int i2 = ew1.h + 8100;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", 1001);
            jSONObject.put("from", i2);
            zn6.d("zzyw_lxd_002half", null, jSONObject.toString());
        } catch (Exception unused) {
        }
        ap3.a().z(findNearByMapActivity, i2, 1001, "0", 1, 0, new a(wc3Var, findNearByMapActivity, locationEx));
    }

    public static void x(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
        if (locationEx == null) {
            ry5.a("位置获取失败，请求稍后重试");
            return;
        }
        if (s) {
            return;
        }
        s = true;
        String str = k;
        if (TextUtils.isEmpty(str)) {
            dw1.F("SepManager buySeparation", com.zenmen.palmchat.c.b(), new l(wc3Var, findNearByMapActivity, locationEx), locationEx);
        } else {
            L(wc3Var, findNearByMapActivity, locationEx, str);
        }
    }

    public static void y(Activity activity, int i2) {
        if (a46.o()) {
            if (a46.q()) {
                bj5.b().a().g0(activity, ConditionHelper.getInstance().getDriftInfo().location, false, true, i2);
                return;
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) activity, BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_MAP_SEPARATION_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
                return;
            }
        }
        ry5.a("请打开位置服务");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void z(int i2) {
        LogUtil.d("MapSeparationManager", "checkStatusTimer status " + i2);
        if (i2 == 1) {
            H();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements i53 {
        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            xc3.b.address = str;
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc3 f21929a;
        public final /* synthetic */ FindNearByMapActivity b;
        public final /* synthetic */ LocationEx c;

        public l(wc3 wc3Var, FindNearByMapActivity findNearByMapActivity, LocationEx locationEx) {
            this.f21929a = wc3Var;
            this.b = findNearByMapActivity;
            this.c = locationEx;
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            xc3.L(this.f21929a, this.b, this.c, str);
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
