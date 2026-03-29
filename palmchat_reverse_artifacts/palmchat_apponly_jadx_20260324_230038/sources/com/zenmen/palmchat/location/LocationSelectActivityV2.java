package com.zenmen.palmchat.location;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.common.C;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.widget.ZXBottomSheetBehavior;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.ad3;
import defpackage.d74;
import defpackage.dw1;
import defpackage.ed3;
import defpackage.i53;
import defpackage.me1;
import defpackage.n53;
import defpackage.nc3;
import defpackage.q05;
import defpackage.sd3;
import defpackage.xi0;
import defpackage.xn3;
import defpackage.zn6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationSelectActivityV2 extends BaseActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, i53, d74, xi0 {
    public static final String m0 = "LocationSelectActivityV2";
    public FrameLayout A;
    public View B;
    public View C;
    public View E;
    public View F;
    public ListView G;
    public g H;
    public ProgressBar I;
    public View J;
    public View K;
    public ZXBottomSheetBehavior<View> L;
    public View M;
    public ClearEditText N;
    public View O;
    public View P;
    public View Q;
    public ChatItem R;
    public int S;
    public com.zenmen.palmchat.location.b T;
    public LocationEx U;
    public LocationEx V;
    public LocationEx W;
    public int X;
    public ed3 f0;
    public ed3 g0;
    public boolean h0;
    public int i0;
    public Toolbar u;
    public TextView v;
    public TextView w;
    public ImageView x;
    public ad3 y;
    public View z;
    public boolean q = false;
    public MaterialDialog r = null;
    public Runnable s = new e();
    public h t = new h(this);
    public int Y = 0;
    public String Z = "";
    public boolean e0 = false;
    public int j0 = 4;
    public int k0 = 1;
    public boolean l0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                LocationSelectActivityV2.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements nc3 {
        public b() {
        }

        @Override // defpackage.nc3
        public void a(Object obj) {
            LogUtil.d("", "mapFindX 允许展示 mSendBtn onCountFind result " + obj);
            if (obj instanceof String) {
                LocationSelectActivityV2.this.l2((String) obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends ZXBottomSheetBehavior.c {
        public c() {
        }

        @Override // com.zenmen.palmchat.widget.ZXBottomSheetBehavior.c
        public void a(@NonNull View view, float f) {
            LocationSelectActivityV2.this.s2(f);
            LocationSelectActivityV2.this.z.setTranslationY(((-f) * LocationSelectActivityV2.this.A.getHeight()) / 5.0f);
        }

        @Override // com.zenmen.palmchat.widget.ZXBottomSheetBehavior.c
        public void b(@NonNull View view, int i) {
            LocationSelectActivityV2.this.j0 = i;
            if (LocationSelectActivityV2.this.j0 == 4) {
                LocationSelectActivityV2.this.e2();
                if (LocationSelectActivityV2.this.k0 == 2 && TextUtils.isEmpty(LocationSelectActivityV2.this.d2())) {
                    LocationSelectActivityV2.this.n2(1);
                }
            }
        }

        @Override // com.zenmen.palmchat.widget.ZXBottomSheetBehavior.c
        public boolean c(View view, MotionEvent motionEvent) {
            int y = (int) motionEvent.getY();
            int[] iArr = new int[2];
            LocationSelectActivityV2.this.P.getLocationOnScreen(iArr);
            return y > iArr[1];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationSelectActivityV2.this.k0 != 2) {
                return;
            }
            LocationSelectActivityV2.this.I.setVisibility(8);
            LocationSelectActivityV2.this.E.setVisibility(8);
            if (TextUtils.isEmpty(LocationSelectActivityV2.this.d2())) {
                LocationSelectActivityV2.this.G.setAdapter((ListAdapter) null);
                LocationSelectActivityV2.this.H = null;
                LocationSelectActivityV2.this.V = null;
                LocationSelectActivityV2.this.b2();
                return;
            }
            if (LocationSelectActivityV2.this.G != null && LocationSelectActivityV2.this.G.getCount() < 1) {
                LocationSelectActivityV2.this.I.setVisibility(0);
            }
            LocationSelectActivityV2.this.H = null;
            LocationEx locationExI = q05.i();
            if (locationExI != null) {
                com.zenmen.palmchat.location.b bVar = LocationSelectActivityV2.this.T;
                String strD2 = LocationSelectActivityV2.this.d2();
                LocationSelectActivityV2.this.Y = 0;
                bVar.n(strD2, 0, locationExI.getRealCityName());
                return;
            }
            com.zenmen.palmchat.location.b bVar2 = LocationSelectActivityV2.this.T;
            String strD22 = LocationSelectActivityV2.this.d2();
            LocationSelectActivityV2.this.Y = 0;
            LocationSelectActivityV2.this.Z = "";
            bVar2.n(strD22, 0, "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("action", "send_message");
            put("status", "sendLocation");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationSelectActivityV2 f14336a;
        public List<LocationEx> b;
        public int c = 0;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f14337a;
            public TextView b;
            public ImageView c;

            public a() {
            }
        }

        public g(LocationSelectActivityV2 locationSelectActivityV2, List<LocationEx> list) {
            this.f14336a = locationSelectActivityV2;
            this.b = list;
        }

        public void b(List<LocationEx> list) {
            this.b.addAll(list);
            notifyDataSetChanged();
        }

        public void c(int i) {
            this.c = i;
            notifyDataSetChanged();
        }

        public final CharSequence e(String str) {
            if (this.f14336a.k0 == 1 || TextUtils.isEmpty(this.f14336a.d2())) {
                return str;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(Pattern.quote(this.f14336a.d2())).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(this.f14336a.getResources().getColor(R.color.Ga)), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f14336a).inflate(R.layout.list_item_poi, (ViewGroup) null);
                aVar = new a();
                aVar.f14337a = (TextView) view.findViewById(R.id.name);
                aVar.b = (TextView) view.findViewById(R.id.address);
                aVar.c = (ImageView) view.findViewById(R.id.check_image);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            LocationEx locationEx = this.b.get(i);
            if (locationEx == null) {
                aVar.f14337a.setText("");
                aVar.b.setText("");
            } else if (TextUtils.isEmpty(locationEx.getName())) {
                aVar.f14337a.setText(e(locationEx.getAddress()));
                aVar.b.setText("");
            } else {
                aVar.f14337a.setText(e(locationEx.getName()));
                aVar.b.setText(e(locationEx.getAddress()));
            }
            if (i == this.c) {
                aVar.c.setImageResource(R.drawable.icon_location_item_select);
            } else {
                aVar.c.setImageResource(0);
            }
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<LocationSelectActivityV2> f14338a;

        public h(LocationSelectActivityV2 locationSelectActivityV2) {
            this.f14338a = new WeakReference<>(locationSelectActivityV2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f14338a.get() != null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1 || this.f14338a.get().isPaused() || this.f14338a.get().W != null || com.zenmen.palmchat.location.b.f(this.f14338a.get())) {
                        return;
                    }
                    this.f14338a.get().q2();
                    return;
                }
                LocationEx locationEx = (LocationEx) message.obj;
                this.f14338a.get().x.setSelected(false);
                if (this.f14338a.get().k0 == 1) {
                    this.f14338a.get().G.setAdapter((ListAdapter) null);
                    this.f14338a.get().H = null;
                    this.f14338a.get().V = null;
                    this.f14338a.get().I.setVisibility(0);
                    this.f14338a.get().E.setVisibility(8);
                    com.zenmen.palmchat.location.b bVar = this.f14338a.get().T;
                    this.f14338a.get().Y = 0;
                    bVar.l(locationEx, 0, this.f14338a.get().i0);
                    this.f14338a.get().b2();
                }
            }
        }
    }

    @Override // defpackage.d74
    public void M(LocationEx locationEx) {
        LogUtil.i(m0, "[onMapDrag] location = " + locationEx.getLatitude() + "," + locationEx.getLongitude());
        if (com.zenmen.palmchat.location.c.b().pageSendLocation) {
            this.W = locationEx;
            this.T.h(locationEx);
        } else if (this.q) {
            this.q = false;
        } else {
            this.W = locationEx;
            this.T.h(locationEx);
        }
    }

    public final void b2() {
        this.w.setEnabled(this.V != null);
    }

    public final String c2(String str) {
        int iIndexOf = str.indexOf("市");
        return iIndexOf > 0 ? str.substring(iIndexOf + 1, str.length()) : str;
    }

    public final String d2() {
        Editable text = this.N.getText();
        return text == null ? "" : text.toString();
    }

    public final void e2() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public final void f2() {
        MaterialDialog materialDialog = this.r;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.r.hide();
        this.r = null;
    }

    public final void g2(Bundle bundle) {
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(this, null, LocationScene.CHAT_SEND_LOCATION);
        this.T = bVarA;
        bVarA.i(this);
        ad3 ad3VarD = this.T.d();
        this.y = ad3VarD;
        this.B = ad3VarD.f(this);
        this.y.n(false);
        this.z = findViewById(R.id.map_layout);
        this.C = findViewById(R.id.center_marker);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.map_view_container);
        this.A = frameLayout;
        frameLayout.addView(this.B, new FrameLayout.LayoutParams(-1, -1));
        this.y.onCreate(bundle);
        this.y.g(this.h0);
        this.y.j(this);
        this.y.m(this);
    }

    @Override // defpackage.xi0
    public void h(LocationEx locationEx) {
        this.L.setState(4);
        e2();
    }

    public final void h2() {
        Toolbar toolbarInitToolbar = initToolbar(-1, false);
        this.u = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        this.v = (TextView) this.u.findViewById(R.id.title);
        TextView textView = (TextView) this.u.findViewById(R.id.action_button);
        this.w = textView;
        if (this.R != null) {
            textView.setText(R.string.send);
        } else {
            textView.setText(R.string.alert_dialog_ok);
        }
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.w.setEnabled(false);
        this.u.setBackgroundResource(R.drawable.drawable_location_select_toolbar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i2() {
        int i;
        ImageView imageView = (ImageView) findViewById(R.id.navigation_btn);
        this.x = imageView;
        if (this.h0) {
            imageView.setOnClickListener(this);
        } else {
            imageView.setVisibility(8);
        }
        ListView listView = (ListView) findViewById(R.id.location_list);
        this.G = listView;
        listView.setOnItemClickListener(this);
        this.G.setOnScrollListener(this);
        this.E = findViewById(R.id.empty);
        this.I = (ProgressBar) findViewById(R.id.progress_loading);
        this.J = LayoutInflater.from(this).inflate(R.layout.list_loading_footer, (ViewGroup) null);
        View viewFindViewById = findViewById(R.id.space);
        this.F = viewFindViewById;
        viewFindViewById.getLayoutParams().height = (int) (me1.f() * 0.15f);
        View viewFindViewById2 = findViewById(R.id.bottom_sheet);
        this.K = viewFindViewById2;
        ZXBottomSheetBehavior<View> zXBottomSheetBehaviorA = ZXBottomSheetBehavior.a(viewFindViewById2);
        this.L = zXBottomSheetBehaviorA;
        zXBottomSheetBehaviorA.setPeekHeight((int) (me1.f() * 0.7f));
        this.L.b(new c());
        this.Q = findViewById(R.id.arrow);
        View viewFindViewById3 = findViewById(R.id.arrowIcon);
        this.P = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        this.Q.setTranslationY(me1.b(this, 20));
        this.M = findViewById(R.id.search_place);
        this.N = (ClearEditText) findViewById(R.id.search);
        this.O = findViewById(R.id.cancel_search);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.N.setClearDrawable(R.drawable.location_search_clear, R.drawable.location_search_clear);
        this.N.addTextChangedListener(new d());
        s2(0.0f);
        JSONObject jSONObject = new JSONObject();
        try {
            ChatItem chatItem = this.R;
            if (chatItem == null) {
                i = 2;
                jSONObject.put("sourceType", i);
            } else {
                if (chatItem.getChatType() == 0) {
                    i = 0;
                } else if (this.R.getChatType() == 1) {
                    i = 1;
                }
                jSONObject.put("sourceType", i);
            }
        } catch (Exception unused) {
        }
        zn6.d("cpgl_msg_map_p_a_search", null, jSONObject.toString());
    }

    public final boolean j2(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    public final void k2(Intent intent) {
        this.R = (ChatItem) intent.getParcelableExtra("chat_item");
        this.S = intent.getIntExtra("thread_biz_type", 0);
        this.h0 = intent.getBooleanExtra("enable_map_drag", true);
        this.i0 = intent.getIntExtra("poi_search_radius", 500);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l2(String str) {
        int i;
        if (this.R != null) {
            m2(str);
            setResult(-1);
        } else {
            Intent intent = new Intent();
            intent.putExtra("location", this.V);
            setResult(-1, intent);
        }
        finish();
        JSONObject jSONObject = new JSONObject();
        try {
            ChatItem chatItem = this.R;
            int i2 = 0;
            if (chatItem == null) {
                i = 2;
                jSONObject.put("sourceType", i);
                if (this.k0 == 1) {
                    i2 = 1;
                }
                jSONObject.put("postype", i2);
            } else {
                if (chatItem.getChatType() == 0) {
                    i = 0;
                } else if (this.R.getChatType() == 1) {
                    i = 1;
                }
                jSONObject.put("sourceType", i);
                if (this.k0 == 1) {
                }
                jSONObject.put("postype", i2);
            }
        } catch (Exception unused) {
        }
        zn6.d("cpgl_msg_map_p_b_send", null, jSONObject.toString());
    }

    public final void m2(String str) {
        ChatItem chatItem = this.R;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(this.R);
        try {
            this.V.setStaticMapImageUrl(this.T.e(this.V));
            getMessagingServiceInterface().r(MessageVo.buildLocationMessage(strA, strE, this.V, 0, str).setThreadBizType(this, this.S));
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(m0, 3, new f(), e2);
        }
    }

    public final void n2(int i) {
        if (this.k0 == i) {
            return;
        }
        this.k0 = i;
        if (i == 1) {
            this.C.setVisibility(0);
            this.M.setVisibility(0);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
            this.G.setAdapter((ListAdapter) null);
            this.H = null;
            this.V = null;
            if (this.W != null) {
                this.I.setVisibility(0);
                this.E.setVisibility(8);
                if (com.zenmen.palmchat.location.c.b().pageSendLocation) {
                    com.zenmen.palmchat.location.b bVar = this.T;
                    LocationEx locationEx = this.W;
                    this.Y = 0;
                    bVar.l(locationEx, 0, this.i0);
                } else {
                    o2();
                }
            }
            b2();
            return;
        }
        if (i != 2) {
            return;
        }
        this.C.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(0);
        this.O.setVisibility(0);
        this.G.setAdapter((ListAdapter) null);
        this.H = null;
        this.V = null;
        if (!TextUtils.isEmpty(d2())) {
            this.I.setVisibility(0);
            this.E.setVisibility(8);
            LocationEx locationExI = q05.i();
            if (locationExI != null) {
                com.zenmen.palmchat.location.b bVar2 = this.T;
                String strD2 = d2();
                this.Y = 0;
                bVar2.n(strD2, 0, locationExI.getRealCityName());
            } else {
                com.zenmen.palmchat.location.b bVar3 = this.T;
                String strD22 = d2();
                this.Y = 0;
                bVar3.n(strD22, 0, "");
            }
        }
        b2();
    }

    public final void o2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, this.W);
        g gVar = new g(this, arrayList);
        this.H = gVar;
        gVar.c = 0;
        LocationEx locationEx = (LocationEx) arrayList.get(0);
        this.V = locationEx;
        this.y.b(locationEx, 150L);
        this.G.setAdapter((ListAdapter) this.H);
        this.I.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.w) {
            if (this.V == null) {
                return;
            }
            view.setEnabled(false);
            LogUtil.d("", "mapFindX mSendBtn click start");
            if (dw1.l() && dw1.k) {
                dw1.B(new b(), this.V);
                return;
            } else {
                LogUtil.d("", "mapFindX mSendBtn 不允许展示 onCountFind locationMsgSwitch false");
                l2("");
                return;
            }
        }
        ImageView imageView = this.x;
        if (view != imageView) {
            if (view == this.M) {
                this.l0 = true;
                n2(2);
                this.L.setState(3);
                p2();
                return;
            }
            if (view == this.N) {
                this.l0 = true;
                this.L.setState(3);
                return;
            }
            if (view == this.O) {
                n2(1);
                this.L.setState(4);
                e2();
                this.N.setText("");
                return;
            }
            if (view == this.v) {
                finish();
                return;
            } else {
                if (view == this.P) {
                    this.L.setState(4);
                    return;
                }
                return;
            }
        }
        imageView.setSelected(true);
        ed3 ed3Var = this.g0;
        if (ed3Var != null) {
            this.y.o(ed3Var);
            this.g0 = null;
        }
        this.y.b(this.U, 150L);
        LocationEx locationEx = this.U;
        if (locationEx != this.W) {
            this.W = locationEx;
            if (this.k0 == 1) {
                if (com.zenmen.palmchat.location.c.b().pageSendLocation) {
                    this.V = null;
                    this.G.setAdapter((ListAdapter) null);
                    this.H = null;
                    this.I.setVisibility(0);
                    this.E.setVisibility(8);
                    com.zenmen.palmchat.location.b bVar = this.T;
                    LocationEx locationEx2 = this.W;
                    this.Y = 0;
                    bVar.l(locationEx2, 0, this.i0);
                } else {
                    o2();
                }
                b2();
            }
        }
        this.L.setState(4);
        e2();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_select_v2);
        k2(getIntent());
        h2();
        i2();
        g2(bundle);
        r2();
        JSONObject jSONObject = new JSONObject();
        try {
            ChatItem chatItem = this.R;
            if (chatItem == null) {
                i = 2;
                jSONObject.put("sourceType", i);
            } else {
                if (chatItem.getChatType() == 0) {
                    i = 0;
                } else if (this.R.getChatType() == 1) {
                    i = 1;
                }
                jSONObject.put("sourceType", i);
            }
        } catch (Exception unused) {
        }
        zn6.d("cpgl_msg_map_p", null, jSONObject.toString());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.y.onDestroy();
        this.T.r(this);
        this.t.removeMessages(1);
        this.t.removeMessages(0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar = this.H;
        if (gVar != null && i >= 0 && i < gVar.getCount()) {
            this.H.c(i);
            this.V = (LocationEx) this.H.getItem(i);
            if (this.k0 == 1 && i == 0) {
                ed3 ed3Var = this.g0;
                if (ed3Var != null) {
                    this.y.o(ed3Var);
                    this.g0 = null;
                }
            } else {
                this.x.setSelected(false);
                ed3 ed3Var2 = this.g0;
                if (ed3Var2 == null) {
                    this.g0 = this.y.a(R.drawable.target_location_marker, this.V);
                } else {
                    this.y.i(ed3Var2, this.V);
                }
            }
            this.y.b(this.V, 150L);
            b2();
        }
        if (this.l0) {
            this.l0 = false;
            this.L.setState(4);
            e2();
        }
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        if (this.U == null && j2(locationEx)) {
            LocationEx locationEx2 = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), locationEx.getName(), locationEx.getAddress());
            this.U = locationEx2;
            this.W = locationEx2;
            this.q = true;
            this.y.l(locationEx2);
            ed3 ed3Var = this.f0;
            if (ed3Var == null) {
                this.f0 = this.y.a(R.drawable.current_location_marker, this.U);
            } else {
                this.y.i(ed3Var, this.U);
            }
            if (this.k0 == 1) {
                if (com.zenmen.palmchat.location.c.b().pageSendLocation) {
                    this.V = null;
                    this.T.l(this.W, this.Y, this.i0);
                } else {
                    o2();
                }
            }
            b2();
            f2();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105 A[Catch: Exception -> 0x0111, TryCatch #0 {Exception -> 0x0111, blocks: (B:54:0x00e3, B:56:0x00e7, B:63:0x00fa, B:65:0x0105, B:69:0x010c, B:59:0x00ef), top: B:87:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    @Override // defpackage.i53
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        ChatItem chatItem;
        int i2;
        LocationEx locationEx;
        int i3 = 1;
        if (n53Var != null && n53Var.b() == 1 && this.Y == 0 && TextUtils.isEmpty(n53Var.a()) && !TextUtils.isEmpty(n53Var.c()) && list != null && list.isEmpty()) {
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(864000000L);
            String city = locationExI != null ? locationExI.getCity() : null;
            if (TextUtils.isEmpty(city)) {
                city = n53Var.d();
            }
            if (!TextUtils.isEmpty(city)) {
                com.zenmen.palmchat.location.b bVar = this.T;
                String strC = n53Var.c();
                int i4 = this.Y;
                this.Z = city;
                bVar.n(strC, i4, city);
                return;
            }
        }
        if (list != null) {
            if (this.k0 == 2 && n53Var != null && n53Var.c() != null && !n53Var.c().equals(d2())) {
                return;
            }
            this.X = i;
            g gVar = this.H;
            if (gVar == null) {
                if (this.k0 == 1 && (locationEx = this.W) != null && !TextUtils.isEmpty(locationEx.getName())) {
                    list.add(0, this.W);
                }
                this.H = new g(this, list);
                if (this.k0 != 1 || list.size() <= 0) {
                    this.H.c = -1;
                    this.V = null;
                } else {
                    this.H.c = 0;
                    LocationEx locationEx2 = list.get(0);
                    this.V = locationEx2;
                    this.y.b(locationEx2, 150L);
                }
                this.G.setAdapter((ListAdapter) this.H);
                this.I.setVisibility(8);
            } else {
                gVar.b(list);
                this.G.removeFooterView(this.J);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                chatItem = this.R;
            } catch (Exception unused) {
            }
            if (chatItem == null) {
                i2 = 2;
                jSONObject.put("sourceType", i2);
                if (list.size() > 0) {
                    i3 = 2;
                } else if (this.k0 == 1) {
                    i3 = 0;
                }
                jSONObject.put("postype", i3);
                zn6.d("cpgl_msg_map_p_a_pos", null, jSONObject.toString());
            } else {
                if (chatItem.getChatType() == 0) {
                    i2 = 0;
                } else if (this.R.getChatType() == 1) {
                    i2 = 1;
                }
                jSONObject.put("sourceType", i2);
                if (list.size() > 0) {
                }
                jSONObject.put("postype", i3);
                zn6.d("cpgl_msg_map_p_a_pos", null, jSONObject.toString());
            }
        }
        if (this.k0 != 2) {
            this.E.setVisibility(8);
        } else if (list == null) {
            this.E.setVisibility(0);
        } else if (list.size() == 0 && !TextUtils.isEmpty(d2())) {
            this.E.setVisibility(0);
        }
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
        }
        this.e0 = false;
        b2();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.y.onPause();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.W.setAddress(str);
        this.W.setName(c2(str));
        this.x.setSelected(false);
        if (!com.zenmen.palmchat.location.c.b().pageSendLocation) {
            o2();
            return;
        }
        Message message = new Message();
        message.what = 0;
        message.obj = this.W;
        this.t.sendMessage(message);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.y.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.y.onSaveInstanceState(bundle);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            e2();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.zenmen.palmchat.location.d.g().k(LocationScene.CHAT_SEND_LOCATION, this);
        bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        unBindMessagingService();
    }

    public final void p2() {
        KeyboardKt.a(this.N, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    public final void q2() {
        sd3 sd3Var = new sd3(this);
        sd3Var.T(R.string.string_share_tip);
        sd3Var.j(R.string.string_location_service_disable);
        sd3Var.O(R.string.settings_item_goto_setting);
        sd3Var.h(false);
        sd3Var.K(R.string.alert_dialog_cancel);
        sd3Var.f(new a());
        MaterialDialog materialDialogE = sd3Var.e();
        this.r = materialDialogE;
        materialDialogE.show();
    }

    public final void r2() {
        this.t.sendEmptyMessageDelayed(1, Build.VERSION.SDK_INT >= 28 ? 1000L : C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    public final void s2(float f2) {
        this.Q.setTranslationY((1.0f - f2) * me1.b(this, 32));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            JSONObject jSONObject = new JSONObject();
            try {
                if (LocationSelectActivityV2.this.R == null) {
                    i4 = 2;
                    jSONObject.put("sourceType", i4);
                } else {
                    if (LocationSelectActivityV2.this.R.getChatType() == 0) {
                        i4 = 0;
                    } else if (LocationSelectActivityV2.this.R.getChatType() == 1) {
                        i4 = 1;
                    }
                    jSONObject.put("sourceType", i4);
                }
            } catch (Exception unused) {
            }
            zn6.d("cpgl_msg_map_p_b_search_in", null, jSONObject.toString());
            LocationSelectActivityV2.this.N.removeCallbacks(LocationSelectActivityV2.this.s);
            LocationSelectActivityV2.this.N.postDelayed(LocationSelectActivityV2.this.s, 500L);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // defpackage.d74
    public void y(LocationEx locationEx) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
