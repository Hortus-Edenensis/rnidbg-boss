package com.zenmen.palmchat.activity.find.trip;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.find.trip.LocationSelectTripDialog;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ew1;
import defpackage.ir5;
import defpackage.l50;
import defpackage.r16;
import defpackage.sw1;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FindMapTripInfoActivity extends FrameworkBaseActivity {
    public LocationSelectTripDialog q = null;
    public GridLayout r = null;
    public View s = null;
    public TextView t = null;
    public TextView u = null;
    public TextView v = null;
    public View w = null;
    public View x = null;
    public String y = null;
    public String z = null;
    public String A = null;
    public View B = null;
    public View C = null;
    public LocationSelectTripDialog.l E = null;
    public ArrayList<TripTagInfoLxView> F = new ArrayList<>();
    public String G = "";
    public long H = 0;
    public int I = 0;
    public String J = "";
    public TextView K = null;
    public int L = 0;
    public int M = 0;
    public int N = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LocationSelectTripDialog.m {
        public a() {
        }

        @Override // com.zenmen.palmchat.activity.find.trip.LocationSelectTripDialog.m
        public void a(LocationSelectTripDialog.l lVar) {
            FindMapTripInfoActivity.this.E = lVar;
            if (lVar != null) {
                FindMapTripInfoActivity.this.Q1(lVar);
            }
        }

        @Override // com.zenmen.palmchat.activity.find.trip.LocationSelectTripDialog.m
        public void b() {
            if (FindMapTripInfoActivity.this.E == null) {
                FindMapTripInfoActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripInfoActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripInfoActivity.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripInfoActivity.this.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripInfoActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements r16 {
        public f() {
        }

        @Override // defpackage.r16
        public void a(String str, String str2, int i, int i2, long j) {
            String str3 = str + " " + str2;
            LogUtil.d("FindMapTripManager", "showSelectTimeDialog result " + str3);
            FindMapTripInfoActivity.this.P1(str3, j, i2, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < FindMapTripInfoActivity.this.F.size(); i++) {
                TripTagInfoLxView tripTagInfoLxView = (TripTagInfoLxView) FindMapTripInfoActivity.this.F.get(i);
                if (view == tripTagInfoLxView) {
                    tripTagInfoLxView.setClickBg();
                    FindMapTripInfoActivity.this.I = tripTagInfoLxView.tagKey;
                    FindMapTripInfoActivity.this.J = tripTagInfoLxView.tagName;
                    FindMapTripInfoActivity.this.L = i;
                } else {
                    tripTagInfoLxView.clearBg();
                }
            }
        }
    }

    public final void L1() {
        HashMap<Integer, String> map = ew1.f;
        if (map == null || map.size() == 0) {
            return;
        }
        this.F.clear();
        this.r.removeAllViews();
        int size = map.size();
        if (size > 0) {
            int i = size / 4;
            if (size % 4 > 0) {
                i++;
            }
            this.r.setRowCount(i);
            this.r.setColumnCount(4);
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                String value = entry.getValue();
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                TripTagInfoLxView tripTagInfoLxView = new TripTagInfoLxView(this, value, iIntValue);
                this.F.add(tripTagInfoLxView);
                tripTagInfoLxView.setOnClickListener(new g());
                this.r.addView(tripTagInfoLxView, layoutParams);
            }
            this.F.get(this.L).setClickBg();
            this.I = this.F.get(this.L).tagKey;
            this.J = this.F.get(this.L).tagName;
        }
    }

    public final void M1(boolean z) {
        String str;
        String str2;
        String str3;
        int i;
        LogUtil.d("TripNearByTag", "FindMapTripActivity isInit " + z);
        if (ew1.h0() && z) {
            this.v.setText("选择时间");
            this.v.setTextColor(Color.parseColor("#14CD64"));
            this.v.setTypeface(Typeface.defaultFromStyle(1));
            return;
        }
        HashMap<String, ArrayList<String>> mapA = ew1.A();
        if (mapA != null) {
            boolean z2 = false;
            if (mapA.get("timeToday").size() > 0) {
                str = mapA.get("timeToday").get(0);
                str2 = "今天 " + str;
            } else {
                if (mapA.get("timeTomorrow").size() > 0) {
                    str = mapA.get("timeTomorrow").get(0);
                    str3 = "明天 " + str;
                    z2 = true;
                    i = 1;
                    P1(str3, ew1.p(z2, str), 0, i);
                }
                str = "00:00";
                str2 = "";
            }
            str3 = str2;
            i = 0;
            P1(str3, ew1.p(z2, str), 0, i);
        }
    }

    public final void N1() {
        this.r = (GridLayout) findViewById(R.id.trip_release_info_tag_layout);
        this.w = findViewById(R.id.release_all_info_layout);
        View viewFindViewById = findViewById(R.id.trip_map_release_location_info_layout);
        this.s = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        this.t = (TextView) findViewById(R.id.trip_release_location_name);
        this.u = (TextView) findViewById(R.id.trip_release_location_address);
        View viewFindViewById2 = findViewById(R.id.trip_map_release_time_info_layout);
        this.x = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new c());
        this.K = (TextView) findViewById(R.id.trip_info_desc_title);
        if (!TextUtils.isEmpty(ew1.d)) {
            this.K.setText(ew1.d);
        }
        this.v = (TextView) findViewById(R.id.trip_release_time_info_desc);
        View viewFindViewById3 = findViewById(R.id.trip_map_release_info_button);
        this.B = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new d());
        View viewFindViewById4 = findViewById(R.id.trip_release_info_all_close);
        this.C = viewFindViewById4;
        viewFindViewById4.setOnClickListener(new e());
        S1();
    }

    public final void O1() {
        double d2;
        double latitude;
        LocationEx locationEx;
        long jC = ir5.c(true);
        long j = this.H;
        if (j > 0 && jC > j) {
            Toast.makeText(this, "行程到达时间已过期，请重新选择", 0).show();
            M1(false);
            return;
        }
        LocationSelectTripDialog.l lVar = this.E;
        if (lVar == null || (locationEx = lVar.f12286a) == null) {
            d2 = 0.0d;
            latitude = 0.0d;
        } else {
            double longitude = locationEx.getLongitude();
            latitude = this.E.f12286a.getLatitude();
            d2 = longitude;
        }
        int i = !TextUtils.isEmpty(this.G) ? 2 : 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", this.A);
            jSONObject.put("tag", this.J);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("page_mapfinder_postitinerary_edit_post", null, jSONObject.toString());
        ew1.W(d2, latitude, this.z, this.I, this.H, i, this.G, this);
    }

    public final void P1(String str, long j, int i, int i2) {
        this.A = str;
        this.H = j;
        this.N = i;
        this.M = i2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.v.setTextColor(Color.parseColor("#222222"));
        this.v.setTypeface(Typeface.defaultFromStyle(0));
        this.v.setText(this.A);
    }

    public final void Q1(LocationSelectTripDialog.l lVar) {
        LocationEx locationEx;
        this.w.setVisibility(0);
        if (lVar != null && (locationEx = lVar.f12286a) != null) {
            this.y = locationEx.getName();
            this.z = lVar.f12286a.getAddress();
            if (!TextUtils.isEmpty(this.y)) {
                this.t.setText(this.y);
            }
            if (TextUtils.isEmpty(this.z)) {
                this.u.setVisibility(8);
                if (!TextUtils.isEmpty(this.y)) {
                    this.z = this.y;
                }
            } else {
                this.u.setVisibility(0);
                this.u.setText(this.z);
            }
            if (TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(this.z)) {
                this.t.setText(this.z);
                if (com.zenmen.palmchat.location.c.b().tripSurroundingSearch) {
                    this.u.setText("");
                }
            }
        }
        M1(true);
        L1();
        zn6.b("page_mapfinder_postitinerary_edit");
    }

    public final void R1() {
        this.A = null;
        new sw1(this, new f(), this.M, this.N).show();
    }

    public final void S1() {
        LocationSelectTripDialog locationSelectTripDialog = this.q;
        if (locationSelectTripDialog != null) {
            locationSelectTripDialog.dismiss();
            this.q = null;
        }
        this.y = null;
        this.z = null;
        this.E = null;
        this.w.setVisibility(8);
        LocationSelectTripDialog locationSelectTripDialog2 = new LocationSelectTripDialog(this, false, ew1.q, new a());
        this.q = locationSelectTripDialog2;
        locationSelectTripDialog2.L(com.zenmen.palmchat.location.c.b().tripSurroundingSearch);
        this.q.show();
        zn6.b("page_mapfinder_postitinerary_location");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_map_trip_release_info);
        if (getIntent() != null) {
            this.G = getIntent().getStringExtra("trip_scheduleOrderId_tag");
        }
        N1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
