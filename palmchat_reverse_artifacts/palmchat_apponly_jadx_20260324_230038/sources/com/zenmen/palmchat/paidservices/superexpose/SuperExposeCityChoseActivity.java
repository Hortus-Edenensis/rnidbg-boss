package com.zenmen.palmchat.paidservices.superexpose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.ActivitySuperExposeCityChoseBinding;
import com.zenmen.palmchat.databinding.ActivitySuperExposeCityChoseLabelItemBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.paidservices.superexpose.bean.BoostNo16Config;
import com.zenmen.palmchat.paidservices.superexpose.bean.LbsSquareSuperCityListResult;
import com.zenmen.palmchat.utils.SAppUtil;
import defpackage.az2;
import defpackage.ds0;
import defpackage.go2;
import defpackage.me1;
import defpackage.q05;
import defpackage.sw4;
import defpackage.uc0;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeCityChoseActivity extends BaseActionBarActivity {
    public ActivitySuperExposeCityChoseBinding q;
    public CityAdapter r;
    public BoostNo16Config t;
    public int s = 0;
    public List<LbsSquareSuperCityListResult> u = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class CityAdapter extends RecyclerView.Adapter<b> {
        public List<LbsSquareSuperCityListResult> e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f14774a;

            public a(int i) {
                this.f14774a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CityAdapter.this.d(this.f14774a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class b extends RecyclerView.ViewHolder {
            public ActivitySuperExposeCityChoseLabelItemBinding d;

            public b(@NonNull ActivitySuperExposeCityChoseLabelItemBinding activitySuperExposeCityChoseLabelItemBinding) {
                super(activitySuperExposeCityChoseLabelItemBinding.getRoot());
                this.d = activitySuperExposeCityChoseLabelItemBinding;
            }
        }

        public CityAdapter(List<LbsSquareSuperCityListResult> list) {
            this.e = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull b bVar, @SuppressLint({"RecyclerView"}) int i) {
            LbsSquareSuperCityListResult lbsSquareSuperCityListResult = this.e.get(i);
            bVar.d.b.setText(lbsSquareSuperCityListResult.cityName);
            bVar.d.b.setMinWidth((me1.g() - me1.a(bVar.d.b.getContext(), 56.0f)) / 4);
            if (TextUtils.isEmpty(lbsSquareSuperCityListResult.tag)) {
                bVar.d.f13890a.setVisibility(8);
            } else {
                bVar.d.f13890a.setText(lbsSquareSuperCityListResult.tag);
                bVar.d.f13890a.setVisibility(0);
            }
            f(bVar, lbsSquareSuperCityListResult);
            bVar.itemView.setOnClickListener(new a(i));
        }

        public final void d(int i) {
            LbsSquareSuperCityListResult lbsSquareSuperCityListResult = this.e.get(i);
            if (lbsSquareSuperCityListResult.isSelected) {
                lbsSquareSuperCityListResult.isSelected = false;
                SuperExposeCityChoseActivity.this.s--;
            } else if (SuperExposeCityChoseActivity.this.s >= SuperExposeCityChoseActivity.this.t.city_choose_limit) {
                Toast.makeText(SuperExposeCityChoseActivity.this, "不能选择更多了", 0).show();
                return;
            } else {
                lbsSquareSuperCityListResult.isSelected = true;
                SuperExposeCityChoseActivity.this.s++;
            }
            notifyItemChanged(i);
            SuperExposeCityChoseActivity.this.L1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new b(ActivitySuperExposeCityChoseLabelItemBinding.b(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        }

        public final void f(b bVar, LbsSquareSuperCityListResult lbsSquareSuperCityListResult) {
            bVar.d.b.setSelected(lbsSquareSuperCityListResult.isSelected);
            if (lbsSquareSuperCityListResult.isSelected) {
                bVar.d.b.setTextColor(bVar.itemView.getContext().getResources().getColor(R.color.white));
            } else {
                bVar.d.b.setTextColor(bVar.itemView.getContext().getResources().getColor(R.color.black));
            }
        }

        public void g(List<LbsSquareSuperCityListResult> list) {
            this.e = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.e.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SuperExposeCityChoseActivity.this.sInstance.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            List<LbsSquareSuperCityListResult> listH1 = SuperExposeCityChoseActivity.this.H1();
            if (listH1.isEmpty()) {
                Toast.makeText(SuperExposeCityChoseActivity.this, "请至少选择一个城市", 0).show();
                return;
            }
            if (listH1.size() > SuperExposeCityChoseActivity.this.t.city_choose_limit) {
                Toast.makeText(SuperExposeCityChoseActivity.this, "选择的城市过多，请重新选择", 0).show();
                return;
            }
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            CityAdapter cityAdapter = SuperExposeCityChoseActivity.this.r;
            if (cityAdapter != null && cityAdapter.e != null) {
                Iterator it = SuperExposeCityChoseActivity.this.r.e.iterator();
                while (it.hasNext()) {
                    String str = ((LbsSquareSuperCityListResult) it.next()).cityName;
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
            }
            map.put("city_list", arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<LbsSquareSuperCityListResult> it2 = listH1.iterator();
            while (it2.hasNext()) {
                String str2 = it2.next().cityName;
                if (str2 != null) {
                    arrayList2.add(str2);
                }
            }
            map.put("choose_city", arrayList2);
            q05.a("boost_chooseCity_confirmbutton", 2, map);
            ds0.a().b(new uc0(new ArrayList(listH1)));
            SuperExposeCityChoseActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<ArrayList<LbsSquareSuperCityListResult>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14777a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public c(String str, HashMap map, boolean z) {
            this.f14777a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f14777a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ArrayList<LbsSquareSuperCityListResult>> lXBaseNetBean, Exception exc) {
            ArrayList<LbsSquareSuperCityListResult> arrayList;
            ArrayList<LbsSquareSuperCityListResult> arrayList2;
            if (q05.o(SuperExposeCityChoseActivity.this) || !z || lXBaseNetBean == null || (arrayList = lXBaseNetBean.data) == null || (arrayList2 = arrayList) == null) {
                return;
            }
            SuperExposeCityChoseActivity.this.r.g(arrayList2);
            SuperExposeCityChoseActivity.this.J1(arrayList2);
            SuperExposeCityChoseActivity.this.L1();
            HashMap map = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            Iterator<LbsSquareSuperCityListResult> it = arrayList2.iterator();
            while (it.hasNext()) {
                String str = it.next().cityName;
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            map.put("city_list", arrayList3);
            q05.a("boost_chooseCity", 1, map);
        }
    }

    public static void I1(Context context, List<LbsSquareSuperCityListResult> list) {
        Intent intent = new Intent(context, (Class<?>) SuperExposeCityChoseActivity.class);
        intent.addFlags(268435456);
        if (list != null && !list.isEmpty()) {
            intent.putParcelableArrayListExtra("previouslySelectedCities", new ArrayList<>(list));
        }
        context.startActivity(intent);
    }

    public void F1() {
        String str = q05.c() + "/lbs.square.super.city.list";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
        }
        zw4.e(new c(str, map, true));
    }

    public BoostNo16Config G1() {
        BoostNo16Config boostNo16Config;
        String strF = SAppUtil.F("boost_No16_config");
        if (TextUtils.isEmpty(strF)) {
            boostNo16Config = null;
        } else {
            try {
                boostNo16Config = (BoostNo16Config) az2.a(strF, BoostNo16Config.class);
            } catch (Exception unused) {
                boostNo16Config = null;
            }
        }
        return boostNo16Config == null ? new BoostNo16Config() : boostNo16Config;
    }

    public List<LbsSquareSuperCityListResult> H1() {
        ArrayList arrayList = new ArrayList();
        CityAdapter cityAdapter = this.r;
        if (cityAdapter != null && cityAdapter.e != null) {
            for (LbsSquareSuperCityListResult lbsSquareSuperCityListResult : this.r.e) {
                if (lbsSquareSuperCityListResult.isSelected) {
                    arrayList.add(lbsSquareSuperCityListResult);
                }
            }
        }
        return arrayList;
    }

    public final void J1(ArrayList<LbsSquareSuperCityListResult> arrayList) {
        this.s = 0;
        if (!this.u.isEmpty()) {
            for (LbsSquareSuperCityListResult lbsSquareSuperCityListResult : arrayList) {
                Iterator<LbsSquareSuperCityListResult> it = this.u.iterator();
                while (true) {
                    if (it.hasNext()) {
                        LbsSquareSuperCityListResult next = it.next();
                        String str = lbsSquareSuperCityListResult.cityCode;
                        if (str != null && str.equals(next.cityCode)) {
                            lbsSquareSuperCityListResult.isSelected = true;
                            this.s++;
                            break;
                        }
                    }
                }
            }
        } else if (!arrayList.isEmpty()) {
            arrayList.get(0).isSelected = true;
            this.s = 1;
        }
        this.r.notifyDataSetChanged();
    }

    public final void K1() {
        if (this.s > 0) {
            this.q.c.setSelected(true);
            this.q.c.setEnabled(true);
        } else {
            this.q.c.setSelected(false);
            this.q.c.setEnabled(false);
        }
    }

    public final void L1() {
        if (this.t != null) {
            this.q.e.setText(String.format("我想曝光的异性所在地 %d/%d", Integer.valueOf(this.s), Integer.valueOf(this.t.city_choose_limit)));
            this.q.d.setText(String.format("最多可以选择%d个城市，多选几个更易找到心仪的Ta", Integer.valueOf(this.t.city_choose_limit)));
        }
        K1();
        M1();
    }

    public final void M1() {
        CityAdapter cityAdapter;
        if (this.t == null || (cityAdapter = this.r) == null || cityAdapter.e == null) {
            this.q.i.setVisibility(4);
            return;
        }
        int i = 0;
        for (LbsSquareSuperCityListResult lbsSquareSuperCityListResult : this.r.e) {
            if (lbsSquareSuperCityListResult.isSelected) {
                i += lbsSquareSuperCityListResult.activeNum;
            }
        }
        if (i >= this.t.city_user_number) {
            this.q.i.setVisibility(4);
        } else if (H1().size() > 0) {
            this.q.i.setVisibility(0);
        } else {
            this.q.i.setVisibility(4);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList parcelableArrayListExtra;
        super.onCreate(bundle);
        ActivitySuperExposeCityChoseBinding activitySuperExposeCityChoseBindingB = ActivitySuperExposeCityChoseBinding.b(getLayoutInflater());
        this.q = activitySuperExposeCityChoseBindingB;
        setContentView(activitySuperExposeCityChoseBindingB.getRoot());
        q05.D(this.q.k);
        if (getIntent() != null && getIntent().hasExtra("previouslySelectedCities") && (parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("previouslySelectedCities")) != null) {
            this.u.addAll(parcelableArrayListExtra);
        }
        this.q.f13889a.setOnClickListener(new a());
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.M(1);
        flexboxLayoutManager.N(0);
        flexboxLayoutManager.K(0);
        this.q.f.setLayoutManager(flexboxLayoutManager);
        CityAdapter cityAdapter = new CityAdapter(new ArrayList());
        this.r = cityAdapter;
        this.q.f.setAdapter(cityAdapter);
        this.t = G1();
        this.q.i.setVisibility(4);
        L1();
        this.q.c.setOnClickListener(new b());
        F1();
    }
}
