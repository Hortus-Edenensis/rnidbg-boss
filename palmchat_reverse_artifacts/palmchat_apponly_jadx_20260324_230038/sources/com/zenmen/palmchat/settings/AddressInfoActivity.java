package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.settings.a;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.cq3;
import defpackage.i53;
import defpackage.il5;
import defpackage.iq5;
import defpackage.n53;
import defpackage.r7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AddressInfoActivity extends BaseActionBarActivity implements a.b {
    public TextView A;
    public ListView r;
    public int s;
    public String t;
    public String u;
    public ContactInfoItem w;
    public LocationEx x;
    public cq3 y;
    public View z;
    public ArrayList<AddressInfo> q = new ArrayList<>();
    public boolean v = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddressInfoActivity.this.I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15113a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(String str, String str2, String str3) {
            this.f15113a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i("Save", "response=" + jSONObject.toString());
            AddressInfoActivity.this.hideBaseProgressBar();
            try {
                if (jSONObject.getInt("resultCode") == 0) {
                    iq5.j(false, new String[0]);
                    AddressInfoActivity.this.L1(this.f15113a, this.b, this.c);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i("Save", "error=" + volleyError.toString());
            AddressInfoActivity.this.hideBaseProgressBar();
        }
    }

    public final void E1() {
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(this));
        this.w = contactInfoItemL;
        if (contactInfoItemL == null) {
            return;
        }
        this.s = getIntent().getIntExtra("type", 0);
        this.v = getIntent().getBooleanExtra("showLocationDetail", false);
        this.t = getIntent().getStringExtra("country");
        this.u = getIntent().getStringExtra(DistrictSearchQuery.KEYWORDS_PROVINCE);
        int i = this.s;
        AddressInfo addressInfo = null;
        if (i == 0) {
            for (AddressInfo addressInfo2 : r7.j(this).g(this)) {
                if (addressInfo2.key.equals(this.w.getCountry())) {
                    addressInfo = addressInfo2;
                } else {
                    this.q.add(addressInfo2);
                }
            }
            if (addressInfo != null) {
                this.q.add(0, addressInfo);
                return;
            }
            return;
        }
        if (i == 1) {
            for (AddressInfo addressInfo3 : r7.j(this).l(this, this.t)) {
                if (addressInfo3.key.equals(this.w.getProvince())) {
                    addressInfo = addressInfo3;
                } else {
                    this.q.add(addressInfo3);
                }
            }
            if (addressInfo != null) {
                this.q.add(0, addressInfo);
                return;
            }
            return;
        }
        if (i == 2) {
            for (AddressInfo addressInfo4 : r7.j(this).d(this, this.t, this.u)) {
                if (addressInfo4.key.equals(this.w.getCity())) {
                    addressInfo = addressInfo4;
                } else {
                    this.q.add(addressInfo4);
                }
            }
            if (addressInfo != null) {
                this.q.add(0, addressInfo);
            }
        }
    }

    public final View F1() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_item_address, (ViewGroup) null);
        viewInflate.findViewById(R.id.top_margin).setVisibility(8);
        ((TextView) viewInflate.findViewById(R.id.cate)).setText(R.string.string_current_location);
        TextView textView = (TextView) viewInflate.findViewById(R.id.address);
        this.A = textView;
        textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_setting_location), (Drawable) null, (Drawable) null, (Drawable) null);
        this.A.setText(R.string.string_locating);
        this.A.setTextColor(getResources().getColor(R.color.text_color_999));
        viewInflate.findViewById(R.id.space).setVisibility(8);
        viewInflate.findViewById(R.id.layout).setOnClickListener(new a());
        return viewInflate;
    }

    public final void G1() {
        com.zenmen.palmchat.location.d.g().k(LocationScene.SELECT_LOCATION, new b());
    }

    public final void H1() {
        this.r = (ListView) findViewById(R.id.list);
        if (this.s == 0) {
            View viewF1 = F1();
            this.z = viewF1;
            this.r.addHeaderView(viewF1);
        }
        this.r.setAdapter((ListAdapter) new com.zenmen.palmchat.settings.a(this, this.q, this.s, this.w, this));
    }

    public final void I1() {
        if (this.x != null) {
            String str = null;
            if (!this.v) {
                M1(r7.j(this).f(this.x.getCountry()), null, null);
                return;
            }
            ArrayList<AddressInfo> arrayListA = r7.j(this).a(this.x.getCountry(), this.x.getProvince(), this.x.getCity());
            String str2 = (arrayListA.size() <= 0 || arrayListA.get(0) == null) ? null : arrayListA.get(0).key;
            String str3 = (arrayListA.size() <= 1 || arrayListA.get(1) == null) ? null : arrayListA.get(1).key;
            if (arrayListA.size() > 2 && arrayListA.get(2) != null) {
                str = arrayListA.get(2).key;
            }
            M1(str2, str3, str);
        }
    }

    public final void J1() {
        TextView textView = this.A;
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_location_info_fail), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setText(R.string.string_locating_fail);
            this.A.setTextColor(getResources().getColor(R.color.text_color_999));
        }
    }

    public final void K1(LocationEx locationEx) {
        String strH;
        if (this.A != null) {
            this.x = locationEx;
            if (TextUtils.isEmpty(locationEx.getCountry())) {
                this.A.setText(R.string.string_china);
            } else {
                if (this.v) {
                    ArrayList<AddressInfo> arrayListA = r7.j(this).a(locationEx.getCountry(), locationEx.getProvince(), locationEx.getCity());
                    String str = null;
                    String str2 = (arrayListA.size() <= 0 || arrayListA.get(0) == null) ? null : arrayListA.get(0).key;
                    String str3 = (arrayListA.size() <= 1 || arrayListA.get(1) == null) ? null : arrayListA.get(1).key;
                    if (arrayListA.size() > 2 && arrayListA.get(2) != null) {
                        str = arrayListA.get(2).key;
                    }
                    strH = il5.j(this, str2, str3, str, false);
                } else {
                    strH = r7.j(this).h(this, r7.j(this).f(this.x.getCountry()));
                }
                this.A.setText(strH);
            }
            this.A.setTextColor(getResources().getColor(R.color.text_color_black));
        }
    }

    public final void L1(String str, String str2, String str3) {
        Intent intent = new Intent("AddressInfoActivity.ACTION_SET_ADDRESS");
        intent.putExtra("country", str);
        intent.putExtra(DistrictSearchQuery.KEYWORDS_PROVINCE, str2);
        intent.putExtra(DistrictSearchQuery.KEYWORDS_CITY, str3);
        setResult(-1, intent);
        finish();
    }

    public final void M1(String str, String str2, String str3) {
        c cVar = new c(str, str2, str3);
        d dVar = new d();
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        map.put("country", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        map.put(DistrictSearchQuery.KEYWORDS_PROVINCE, str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        map.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        this.y = new cq3(cVar, dVar);
        try {
            showBaseProgressBar(R.string.progress_sending, false);
            this.y.n(map);
        } catch (DaoException e) {
            e.printStackTrace();
            hideBaseProgressBar();
        } catch (JSONException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    @Override // com.zenmen.palmchat.settings.a.b
    public void S0(AddressInfo addressInfo) {
        int i = this.s;
        if (i == 0) {
            ArrayList<AddressInfo> arrayList = addressInfo.childList;
            if (arrayList == null || arrayList.size() <= 0) {
                M1(addressInfo.key, null, null);
                return;
            }
            Intent intent = new Intent(this, (Class<?>) AddressInfoActivity.class);
            intent.putExtra("type", 1);
            intent.putExtra("country", addressInfo.key);
            startActivityForResult(intent, 100);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                M1(this.t, this.u, addressInfo.key);
                return;
            }
            return;
        }
        ArrayList<AddressInfo> arrayList2 = addressInfo.childList;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            M1(this.t, addressInfo.key, null);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) AddressInfoActivity.class);
        intent2.putExtra("type", 2);
        intent2.putExtra("country", this.t);
        intent2.putExtra(DistrictSearchQuery.KEYWORDS_PROVINCE, addressInfo.key);
        startActivityForResult(intent2, 100);
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_personal_address_title);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_address_select);
        E1();
        H1();
        initActionBar();
        if (this.s == 0) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.PERSONAL_LOCATION_INFO);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cq3 cq3Var = this.y;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
        super.onDestroy();
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
        hideBaseProgressBar();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        J1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        G1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements i53 {
        public b() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            if (locationEx != null) {
                AddressInfoActivity.this.K1(locationEx);
            } else {
                AddressInfoActivity.this.J1();
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
