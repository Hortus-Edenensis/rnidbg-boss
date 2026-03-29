package com.zenmen.palmchat.location;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.LocationmsgMapfinderguideConfig;
import defpackage.a46;
import defpackage.ad3;
import defpackage.dw1;
import defpackage.ed3;
import defpackage.g53;
import defpackage.i53;
import defpackage.is0;
import defpackage.l50;
import defpackage.me1;
import defpackage.n53;
import defpackage.nc3;
import defpackage.u93;
import defpackage.ve;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationViewActivityV2 extends BaseActionBarActivity implements i53 {
    public TextView A;
    public TextView B;
    public TextView F;
    public TextView G;
    public MessageVo H;
    public Toolbar I;
    public com.zenmen.palmchat.location.b J;
    public ad3 K;
    public ed3 L;
    public LocationEx M;
    public LocationEx s;
    public k t;
    public ImageView u;
    public View v;
    public View w;
    public TextView x;
    public View y;
    public TextView z;
    public String q = "附近xx人最近活跃，解锁查看详情";
    public boolean r = true;
    public int C = 0;
    public is0.f E = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements nc3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f14341a;
        public final /* synthetic */ ChatItem b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.location.LocationViewActivityV2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1062a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f14342a;

            public RunnableC1062a(Object obj) {
                this.f14342a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f14341a.put("nearbyCount", this.f14342a);
                    LogUtil.d("", "mSendBtn 更新数据 location " + a.this.f14341a);
                    a aVar = a.this;
                    com.zenmen.palmchat.database.b.K(aVar.b, LocationViewActivityV2.this.H.mid, a.this.f14341a.toString());
                } catch (Exception unused) {
                }
            }
        }

        public a(JSONObject jSONObject, ChatItem chatItem) {
            this.f14341a = jSONObject;
            this.b = chatItem;
        }

        @Override // defpackage.nc3
        public void a(Object obj) {
            if (obj instanceof String) {
                LocationViewActivityV2.this.P1((String) obj);
                if (TextUtils.isEmpty((CharSequence) obj)) {
                    return;
                }
                u93.e(new RunnableC1062a(obj));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationViewActivityV2.this.s == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("navapp", "百度地图");
            } catch (Exception unused) {
            }
            zn6.d("cpgl_msg_mapinfo_p_a_navapp", null, jSONObject.toString());
            try {
                Intent intent = Intent.getIntent("intent://map/direction?destination=latlng:" + LocationViewActivityV2.this.s.getLatitude() + "," + LocationViewActivityV2.this.s.getLongitude() + "|name:" + LocationViewActivityV2.this.s.getName() + "&mode=driving#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
                intent.addFlags(268435456);
                LocationViewActivityV2.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocationViewActivityV2.this.t.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements is0.f {
        public c() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                LocationViewActivityV2.this.J1();
            } else {
                if (i != 1) {
                    return;
                }
                LocationViewActivityV2.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationViewActivityV2.this.K.h(LocationViewActivityV2.this.M);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.d("cpgl_msg_mapinfo_p_b_nav", null, null);
            LocationViewActivityV2.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.d("cpgl_msg_mapinfo_p_b_nav", null, null);
            LocationViewActivityV2.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            dw1.t("click");
            LocationViewActivityV2 locationViewActivityV2 = LocationViewActivityV2.this;
            locationViewActivityV2.Q1(locationViewActivityV2.s);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.d("", "mapFindX mapFindTopInterImg onClick");
            if (TextUtils.isEmpty(dw1.n)) {
                return;
            }
            dw1.s("click");
            ve.o(LocationViewActivityV2.this, dw1.n, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationViewActivityV2.this.s == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("navapp", "腾讯地图");
            } catch (Exception unused) {
            }
            zn6.d("cpgl_msg_mapinfo_p_a_navapp", null, jSONObject.toString());
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("qqmap://map/routeplan?type=drive&to=" + LocationViewActivityV2.this.s.getName() + "&tocoord=" + LocationViewActivityV2.this.s.getLatitude() + "," + LocationViewActivityV2.this.s.getLongitude()));
                intent.addFlags(268435456);
                LocationViewActivityV2.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocationViewActivityV2.this.t.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocationViewActivityV2.this.s == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("navapp", "高德地图");
            } catch (Exception unused) {
            }
            zn6.d("cpgl_msg_mapinfo_p_a_navapp", null, jSONObject.toString());
            try {
                Intent intent = Intent.getIntent("androidamap://navi?sourceApplication=连信&poiname=" + LocationViewActivityV2.this.s.getName() + "&lat=" + LocationViewActivityV2.this.s.getLatitude() + "&lon=" + LocationViewActivityV2.this.s.getLongitude() + "&dev=0");
                intent.addFlags(268435456);
                LocationViewActivityV2.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocationViewActivityV2.this.t.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends Dialog {

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f14352a;
            public int b;
            public View.OnClickListener c;

            public a(String str, int i, View.OnClickListener onClickListener) {
                this.f14352a = str;
                this.b = i;
                this.c = onClickListener;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14353a = true;
            public final c b;

            /* JADX INFO: compiled from: SearchBox */
            public class a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k f14354a;

                public a(k kVar) {
                    this.f14354a = kVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14354a.dismiss();
                }
            }

            public b(Context context) {
                c cVar = new c();
                this.b = cVar;
                cVar.d = context;
            }

            public b a(String str, int i, View.OnClickListener onClickListener) {
                this.b.f14355a.add(new a(str, i, onClickListener));
                return this;
            }

            public b b(String str, View.OnClickListener onClickListener) {
                this.b.f14355a.add(new a(str, Color.parseColor("#FF1e1e1e"), onClickListener));
                return this;
            }

            public k c() {
                k kVar = new k(this.b.d, R.style.LocationBottomDialog);
                Window window = kVar.getWindow();
                window.setWindowAnimations(R.style.LocationDialogAnimation);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                View viewInflate = LayoutInflater.from(this.b.d).inflate(R.layout.dialog_location_navi, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.cancel);
                ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.menu_container);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
                marginLayoutParams.setMargins(me1.b(this.b.d, 20), 0, me1.b(this.b.d, 20), 0);
                int iB = me1.b(this.b.d, 14);
                for (int i = 0; i < this.b.f14355a.size(); i++) {
                    a aVar = (a) this.b.f14355a.get(i);
                    TextView textView2 = new TextView(this.b.d);
                    textView2.setLayoutParams(layoutParams);
                    textView2.setPadding(0, iB, 0, iB);
                    textView2.setGravity(17);
                    textView2.setText(aVar.f14352a);
                    textView2.setTextColor(aVar.b);
                    textView2.setTextSize(16.0f);
                    textView2.setOnClickListener(aVar.c);
                    viewGroup.addView(textView2, viewGroup.getChildCount() - 1);
                    if (i != this.b.f14355a.size() - 1) {
                        View view = new View(this.b.d);
                        view.setLayoutParams(marginLayoutParams);
                        view.setBackgroundColor(-1710619);
                        viewGroup.addView(view, viewGroup.getChildCount() - 1);
                    }
                }
                if (this.b.f14355a.size() < 1) {
                    viewGroup.setVisibility(8);
                } else {
                    viewGroup.setVisibility(0);
                }
                if (!TextUtils.isEmpty(this.b.c)) {
                    textView.setText(this.b.c);
                }
                if (this.b.b != null) {
                    textView.setOnClickListener(this.b.b);
                } else {
                    textView.setOnClickListener(new a(kVar));
                }
                kVar.setContentView(viewInflate);
                kVar.setCanceledOnTouchOutside(this.f14353a);
                kVar.setCancelable(this.f14353a);
                return kVar;
            }

            public b d(String str) {
                this.b.c = str;
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<a> f14355a = new ArrayList();
            public View.OnClickListener b;
            public String c;
            public Context d;
        }

        public k(Context context, int i) {
            super(context, i);
        }
    }

    public static boolean M1(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    public final void J1() {
        Intent intent = new Intent();
        intent.setClass(this, SendMessageActivity.class);
        intent.putExtra("message_vo", this.H);
        startActivity(intent);
    }

    public final void K1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.location_info);
        this.I = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void L1() {
        this.u = (ImageView) findViewById(R.id.mapFind_top_inter_layout);
        this.v = findViewById(R.id.map_find_bottom_new_layout);
        this.w = findViewById(R.id.map_bottom_old_layout);
        this.x = (TextView) findViewById(R.id.mapFind_nearby_count);
        this.y = findViewById(R.id.mapFind_navi);
        this.z = (TextView) findViewById(R.id.mapFind_drif);
        this.A = (TextView) findViewById(R.id.mapFind_name);
        this.B = (TextView) findViewById(R.id.mapFind_address);
        dw1.t("view");
        ((ImageView) findViewById(R.id.navigation_btn)).setOnClickListener(new d());
        ImageView imageView = (ImageView) findViewById(R.id.navi);
        imageView.setOnClickListener(new e());
        if (N1(this.s)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        LocationmsgMapfinderguideConfig locationmsgMapfinderguideConfig = LocationmsgMapfinderguideConfig.getLocationmsgMapfinderguideConfig();
        if (!dw1.l()) {
            this.w.setVisibility(0);
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            return;
        }
        if (locationmsgMapfinderguideConfig.location_detail.down_button_switch) {
            this.w.setVisibility(8);
            this.v.setVisibility(0);
            this.y.setOnClickListener(new f());
            if (N1(this.s)) {
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dw1.p)) {
                this.z.setText(dw1.p);
            }
            this.z.setOnClickListener(new g());
        } else {
            this.w.setVisibility(0);
            this.v.setVisibility(8);
        }
        if (TextUtils.isEmpty(dw1.m)) {
            this.u.setVisibility(8);
            return;
        }
        this.u.setVisibility(0);
        a46.u(dw1.m, this.u, R.drawable.map_location_find_inter_right_btn_bg);
        this.u.setOnClickListener(new h());
        dw1.s("view");
    }

    public final boolean N1(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    public final boolean O1() {
        if (this.s == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("qqmap://map/routeplan?type=drive&tocoord=" + this.s.getLatitude() + "," + this.s.getLongitude()));
        return intent.resolveActivity(getPackageManager()) != null;
    }

    public final void P1(String str) {
        String strReplace;
        if (!TextUtils.isEmpty(dw1.o)) {
            this.q = dw1.o;
        }
        if (TextUtils.isEmpty(str)) {
            strReplace = this.q.replace("xx", "0");
            this.C = 0;
        } else {
            String strReplace2 = this.q.replace("xx", str);
            this.C = Integer.parseInt(str);
            strReplace = strReplace2;
        }
        this.x.setText(strReplace);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q1(LocationEx locationEx) {
        boolean z;
        if (ConditionHelper.getInstance().getDriftInfo() == null || ConditionHelper.getInstance().getDriftInfo().location == null || locationEx == null) {
            z = false;
        } else {
            LocationEx locationEx2 = ConditionHelper.getInstance().getDriftInfo().location;
            if (AMapUtils.calculateLineDistance(new LatLng(locationEx.getLatitude(), locationEx.getLongitude()), new LatLng(locationEx2.getLatitude(), locationEx2.getLongitude())) < 1000.0f) {
                z = true;
            }
        }
        LogUtil.d("", "mapFindX showMapFindBuyDialog showDriftPromptDialog " + z);
        if (z) {
            dw1.h0(this, locationEx, this.C);
        } else {
            dw1.i0(this, locationEx, this.C);
        }
    }

    public final void R1() {
        k.b bVar = new k.b(this);
        if (O1()) {
            bVar.b("腾讯地图", new i());
        }
        if (M1(this, "com.autonavi.minimap")) {
            bVar.b("高德地图", new j());
        }
        if (M1(this, "com.baidu.BaiduMap")) {
            bVar.b("百度地图", new b());
        }
        bVar.d("取消");
        k kVarC = bVar.c();
        this.t = kVarC;
        kVarC.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc  */
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        MessageVo messageVo;
        super.onCreate(bundle);
        this.s = (LocationEx) getIntent().getParcelableExtra("location");
        setContentView(R.layout.activity_location_view_v2);
        K1();
        L1();
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(this, null, LocationScene.CHAT_SEND_LOCATION);
        this.J = bVarA;
        bVarA.i(this);
        ad3 ad3VarD = this.J.d();
        this.K = ad3VarD;
        View viewF = ad3VarD.f(this);
        this.K.n(false);
        ((FrameLayout) findViewById(R.id.map_view_container)).addView(viewF, new FrameLayout.LayoutParams(-1, -1));
        this.K.onCreate(bundle);
        int i2 = 1;
        this.r = getIntent().getBooleanExtra("showPopupMenu", true);
        this.K.l(this.s);
        this.K.d(R.drawable.center_marker, this.s, 0.5f, 1.0f, 1.0f);
        this.F = (TextView) findViewById(R.id.name);
        this.G = (TextView) findViewById(R.id.address);
        LocationEx locationEx = this.s;
        if (locationEx != null && locationEx.getName() != null) {
            this.F.setText(this.s.getName());
            this.A.setText(this.s.getName());
        }
        LocationEx locationEx2 = this.s;
        if (locationEx2 != null && locationEx2.getAddress() != null) {
            this.G.setText(this.s.getAddress());
            this.B.setText(this.s.getAddress());
        }
        this.H = (MessageVo) getIntent().getParcelableExtra("message_vo");
        ChatItem chatItem = (ChatItem) getIntent().getParcelableExtra("chat_item");
        JSONObject jSONObject = new JSONObject();
        if (chatItem != null) {
            try {
                if (chatItem.getChatType() == 0) {
                    i2 = 0;
                } else if (chatItem.getChatType() != 1) {
                    i2 = 2;
                }
                jSONObject.put("sourceType", i2);
                if (dw1.l() && (messageVo = this.H) != null && messageVo.data1 != null) {
                    if (dw1.i) {
                        dw1.H(null, false);
                    }
                    JSONObject jSONObject2 = new JSONObject(this.H.data1);
                    P1(jSONObject2.optString("nearbyCount"));
                    LocationEx locationExA = g53.a(this.H.data1);
                    dw1.B(new a(jSONObject2, chatItem), locationExA);
                    if ("nearbyItem".equals(getIntent().getStringExtra("clickFrom"))) {
                        Q1(locationExA);
                    }
                }
            } catch (Exception unused) {
            }
        }
        zn6.d("cpgl_msg_mapinfo_p", null, jSONObject.toString());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (!this.r) {
            return true;
        }
        menuInflater.inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.J.r(this);
        this.K.onDestroy();
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        if (locationEx == null) {
            return;
        }
        this.M = locationEx;
        ed3 ed3Var = this.L;
        if (ed3Var == null) {
            this.L = this.K.a(R.drawable.current_location_marker, locationEx);
        } else {
            this.K.i(ed3Var, locationEx);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.r) {
            showPopupMenu(this, this.I, new String[]{AppContext.getContext().getResources().getString(R.string.string_forward), AppContext.getContext().getResources().getString(R.string.alert_dialog_cancel)}, new int[]{R.drawable.icon_menu_forward, R.drawable.icon_menu_close}, this.E, null);
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.K.onPause();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.K.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.K.onSaveInstanceState(bundle);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.zenmen.palmchat.location.d.g().k(LocationScene.CHAT_SEND_LOCATION, this);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i2, List<LocationEx> list, n53 n53Var) {
    }
}
