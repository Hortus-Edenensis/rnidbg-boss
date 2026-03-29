package com.zenmen.palmchat.location;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.common.C;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ad3;
import defpackage.d74;
import defpackage.ed3;
import defpackage.i53;
import defpackage.n53;
import defpackage.sd3;
import defpackage.xn3;
import defpackage.zn6;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationSelectActivity extends BaseActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, i53, d74 {
    public static final String O = "LocationSelectActivity";
    public ChatItem A;
    public int B;
    public com.zenmen.palmchat.location.b C;
    public LocationEx E;
    public LocationEx F;
    public LocationEx G;
    public int H;
    public ed3 K;
    public ed3 L;
    public boolean M;
    public int N;
    public Toolbar s;
    public TextView t;
    public ImageView u;
    public ad3 v;
    public ListView w;
    public c x;
    public ProgressBar y;
    public View z;
    public MaterialDialog q = null;
    public d r = new d(this);
    public int I = 0;
    public boolean J = false;

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
                LocationSelectActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "send_message");
            put("status", "sendLocation");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f14327a;
        public List<LocationEx> b;
        public int c = 0;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f14328a;
            public TextView b;
            public ImageView c;

            public a() {
            }
        }

        public c(Context context, List<LocationEx> list) {
            this.f14327a = context;
            this.b = list;
        }

        public void a(List<LocationEx> list) {
            this.b.addAll(list);
            notifyDataSetChanged();
        }

        public void b(int i) {
            this.c = i;
            notifyDataSetChanged();
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
                view = LayoutInflater.from(this.f14327a).inflate(R.layout.list_item_poi, (ViewGroup) null);
                aVar = new a();
                aVar.f14328a = (TextView) view.findViewById(R.id.name);
                aVar.b = (TextView) view.findViewById(R.id.address);
                aVar.c = (ImageView) view.findViewById(R.id.check_image);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            LocationEx locationEx = this.b.get(i);
            if (locationEx == null) {
                aVar.f14328a.setText("");
                aVar.b.setText("");
            } else if (TextUtils.isEmpty(locationEx.getName())) {
                aVar.f14328a.setText(locationEx.getAddress());
                aVar.b.setText("");
            } else {
                aVar.f14328a.setText(locationEx.getName());
                aVar.b.setText(locationEx.getAddress());
            }
            if (i == this.c) {
                aVar.c.setImageResource(R.drawable.icon_gender_item_select);
            } else {
                aVar.c.setImageResource(0);
            }
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<LocationSelectActivity> f14329a;

        public d(LocationSelectActivity locationSelectActivity) {
            this.f14329a = new WeakReference<>(locationSelectActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f14329a.get() != null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1 || this.f14329a.get().isPaused() || this.f14329a.get().F != null || com.zenmen.palmchat.location.b.f(this.f14329a.get())) {
                        return;
                    }
                    this.f14329a.get().R1();
                    return;
                }
                LocationEx locationEx = (LocationEx) message.obj;
                this.f14329a.get().w.setAdapter((ListAdapter) null);
                this.f14329a.get().x = null;
                this.f14329a.get().y.setVisibility(0);
                this.f14329a.get().F = locationEx;
                com.zenmen.palmchat.location.b bVar = this.f14329a.get().C;
                this.f14329a.get().I = 0;
                bVar.l(locationEx, 0, this.f14329a.get().N);
                this.f14329a.get().u.setSelected(false);
            }
        }
    }

    public final void K1() {
        MaterialDialog materialDialog = this.q;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.q.hide();
        this.q = null;
    }

    public final void L1(Bundle bundle) {
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(this, null, LocationScene.CHAT_SEND_LOCATION);
        this.C = bVarA;
        bVarA.i(this);
        ad3 ad3VarD = this.C.d();
        this.v = ad3VarD;
        View viewF = ad3VarD.f(this);
        this.v.n(false);
        ((FrameLayout) findViewById(R.id.map_view_container)).addView(viewF, new FrameLayout.LayoutParams(-1, -1));
        this.v.onCreate(bundle);
        this.v.g(this.M);
        this.v.j(this);
    }

    @Override // defpackage.d74
    public void M(LocationEx locationEx) {
        LogUtil.i(O, "[onMapDrag] location = " + locationEx.getLatitude() + "," + locationEx.getLongitude());
        this.G = locationEx;
        this.C.h(locationEx);
    }

    public final void M1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.s = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        TextView textView = (TextView) this.s.findViewById(R.id.title);
        this.t = (TextView) this.s.findViewById(R.id.action_button);
        if (this.A != null) {
            textView.setText(R.string.input_fragment_grid_item_weizhi);
            this.t.setText(R.string.send);
        } else {
            textView.setText(R.string.selection_location);
            this.t.setText(R.string.alert_dialog_ok);
        }
        this.t.setOnClickListener(this);
        this.t.setEnabled(false);
    }

    public final void N1() {
        ImageView imageView = (ImageView) findViewById(R.id.navigation_btn);
        this.u = imageView;
        if (this.M) {
            imageView.setOnClickListener(this);
        } else {
            imageView.setVisibility(8);
        }
        ListView listView = (ListView) findViewById(R.id.location_list);
        this.w = listView;
        listView.setOnItemClickListener(this);
        this.w.setOnScrollListener(this);
        this.y = (ProgressBar) findViewById(R.id.progress_loading);
        this.z = LayoutInflater.from(this).inflate(R.layout.list_loading_footer, (ViewGroup) null);
    }

    public final boolean O1(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    public final void P1(Intent intent) {
        this.A = (ChatItem) intent.getParcelableExtra("chat_item");
        this.B = intent.getIntExtra("thread_biz_type", 0);
        this.M = intent.getBooleanExtra("enable_map_drag", true);
        this.N = intent.getIntExtra("poi_search_radius", 500);
    }

    public final void Q1() {
        ChatItem chatItem = this.A;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strA = xn3.a();
        String strE = DomainHelper.e(this.A);
        try {
            this.F.setStaticMapImageUrl(this.C.e(this.F));
            getMessagingServiceInterface().r(MessageVo.buildLocationMessage(strA, strE, this.F, 0, "").setThreadBizType(this, this.B));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i(O, 3, new b(), e);
        }
    }

    public final void R1() {
        sd3 sd3Var = new sd3(this);
        sd3Var.T(R.string.string_share_tip);
        sd3Var.j(R.string.string_location_service_disable);
        sd3Var.O(R.string.settings_item_goto_setting);
        sd3Var.h(false);
        sd3Var.K(R.string.alert_dialog_cancel);
        sd3Var.f(new a());
        MaterialDialog materialDialogE = sd3Var.e();
        this.q = materialDialogE;
        materialDialogE.show();
    }

    public final void S1() {
        this.r.sendEmptyMessageDelayed(1, Build.VERSION.SDK_INT >= 28 ? 1000L : C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int i = 1;
        if (view == this.t) {
            view.setEnabled(false);
            if (this.A != null) {
                Q1();
                setResult(-1);
            } else {
                Intent intent = new Intent();
                intent.putExtra("location", this.F);
                setResult(-1, intent);
            }
            finish();
            JSONObject jSONObject = new JSONObject();
            try {
                ChatItem chatItem = this.A;
                if (chatItem == null) {
                    i = 2;
                    jSONObject.put("sourceType", i);
                    jSONObject.put("postype", 0);
                } else {
                    if (chatItem.getChatType() == 0) {
                        i = 0;
                    } else if (this.A.getChatType() == 1) {
                    }
                    jSONObject.put("sourceType", i);
                    jSONObject.put("postype", 0);
                }
            } catch (Exception unused) {
            }
            zn6.d("cpgl_msg_map_p_b_send", null, jSONObject.toString());
            return;
        }
        ImageView imageView = this.u;
        if (view == imageView) {
            imageView.setSelected(true);
            ed3 ed3Var = this.L;
            if (ed3Var != null) {
                this.v.o(ed3Var);
                this.L = null;
            }
            this.v.h(this.E);
            LocationEx locationEx = this.E;
            if (locationEx != this.G) {
                this.G = locationEx;
                this.F = locationEx;
                this.w.setAdapter((ListAdapter) null);
                this.x = null;
                this.y.setVisibility(0);
                com.zenmen.palmchat.location.b bVar = this.C;
                LocationEx locationEx2 = this.E;
                this.I = 0;
                bVar.l(locationEx2, 0, this.N);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_select);
        P1(getIntent());
        M1();
        N1();
        L1(bundle);
        S1();
        JSONObject jSONObject = new JSONObject();
        try {
            ChatItem chatItem = this.A;
            if (chatItem == null) {
                i = 2;
                jSONObject.put("sourceType", i);
            } else {
                if (chatItem.getChatType() == 0) {
                    i = 0;
                } else if (this.A.getChatType() == 1) {
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
        this.v.onDestroy();
        this.C.r(this);
        this.r.removeMessages(1);
        this.r.removeMessages(0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar = this.x;
        if (cVar == null || i >= cVar.getCount()) {
            return;
        }
        this.x.b(i);
        this.F = (LocationEx) this.x.getItem(i);
        if (i == 0) {
            ed3 ed3Var = this.L;
            if (ed3Var != null) {
                this.v.o(ed3Var);
                this.L = null;
            }
        } else {
            this.u.setSelected(false);
            ed3 ed3Var2 = this.L;
            if (ed3Var2 == null) {
                this.L = this.v.a(R.drawable.target_location_marker, this.F);
            } else {
                this.v.i(ed3Var2, this.F);
            }
        }
        this.v.h(this.F);
        this.t.setEnabled(true);
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        if (this.E == null && O1(locationEx)) {
            LocationEx locationEx2 = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), "", locationEx.getAddress());
            this.E = locationEx2;
            this.F = locationEx2;
            this.G = locationEx2;
            this.v.h(locationEx2);
            ed3 ed3Var = this.K;
            if (ed3Var == null) {
                this.K = this.v.a(R.drawable.current_location_marker, this.E);
            } else {
                this.v.i(ed3Var, this.E);
            }
            this.C.l(this.E, this.I, this.N);
            this.t.setEnabled(true);
            K1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    @Override // defpackage.i53
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        ChatItem chatItem;
        int i2;
        if (list != null) {
            this.H = i;
            c cVar = this.x;
            if (cVar == null) {
                list.add(0, this.G);
                c cVar2 = new c(this, list);
                this.x = cVar2;
                this.w.setAdapter((ListAdapter) cVar2);
                this.y.setVisibility(8);
            } else {
                cVar.a(list);
                this.w.removeFooterView(this.z);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                chatItem = this.A;
            } catch (Exception unused) {
            }
            if (chatItem == null) {
                i2 = 2;
                jSONObject.put("sourceType", i2);
                jSONObject.put("postype", list.size() > 0 ? 0 : 2);
                zn6.d("cpgl_msg_map_p_a_pos", null, jSONObject.toString());
            } else {
                if (chatItem.getChatType() == 0) {
                    i2 = 0;
                } else {
                    i2 = 1;
                    if (this.A.getChatType() == 1) {
                    }
                }
                jSONObject.put("sourceType", i2);
                jSONObject.put("postype", list.size() > 0 ? 0 : 2);
                zn6.d("cpgl_msg_map_p_a_pos", null, jSONObject.toString());
            }
        }
        this.J = false;
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
        this.v.onPause();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G.setAddress(str);
        Message message = new Message();
        message.what = 0;
        message.obj = this.G;
        this.r.sendMessage(message);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.v.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.v.onSaveInstanceState(bundle);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.I < this.H - 1 && !this.J) {
            this.J = true;
            this.w.addFooterView(this.z);
            this.w.smoothScrollToPosition(absListView.getLastVisiblePosition() + 1);
            com.zenmen.palmchat.location.b bVar = this.C;
            LocationEx locationEx = this.E;
            int i2 = this.I + 1;
            this.I = i2;
            bVar.l(locationEx, i2, this.N);
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

    @Override // defpackage.d74
    public void y(LocationEx locationEx) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
