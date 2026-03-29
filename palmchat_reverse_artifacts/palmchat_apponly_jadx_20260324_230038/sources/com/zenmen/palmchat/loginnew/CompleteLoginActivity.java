package com.zenmen.palmchat.loginnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.loginnew.BaseLoginActivity;
import com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment;
import com.zenmen.palmchat.loginnew.fragment.GenderBirthDayFragment;
import com.zenmen.palmchat.loginnew.fragment.IncomeFragment;
import com.zenmen.palmchat.loginnew.fragment.IntentionFragment;
import com.zenmen.palmchat.loginnew.fragment.OccupationFragment;
import com.zenmen.palmchat.loginnew.fragment.PortraitNickFragment;
import com.zenmen.palmchat.loginnew.fragment.SmsFragment;
import com.zenmen.palmchat.loginnew.fragment.VerifyFragment;
import com.zenmen.palmchat.widget.NonSwipeableViewPager;
import defpackage.dm0;
import defpackage.ds0;
import defpackage.me1;
import defpackage.qm5;
import defpackage.x4;
import defpackage.x63;
import defpackage.y63;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CompleteLoginActivity extends BaseLoginActivity implements com.zenmen.palmchat.loginnew.a {
    public PortraitNickFragment A;
    public OccupationFragment B;
    public IncomeFragment C;
    public IntentionFragment E;
    public int F;
    public boolean G;
    public boolean H;
    public View t;
    public NonSwipeableViewPager u;
    public FragmentStatePagerAdapter v;
    public int w;
    public SmsFragment x;
    public VerifyFragment y;
    public GenderBirthDayFragment z;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x4 f14481a;

        public b(x4 x4Var) {
            this.f14481a = x4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            LXBaseNetBean<JSONObject> lXBaseNetBean;
            x4 x4Var = this.f14481a;
            if (x4Var == null || x4Var.f21873a != x4.f || (lXBaseNetBean = x4Var.d) == null) {
                return;
            }
            CompleteLoginActivity.this.D1(lXBaseNetBean, 0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends FragmentStatePagerAdapter {
        public c(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 7;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return CompleteLoginActivity.this.k2();
                case 1:
                    return CompleteLoginActivity.this.l2();
                case 2:
                    return CompleteLoginActivity.this.f2();
                case 3:
                    return CompleteLoginActivity.this.j2();
                case 4:
                    return CompleteLoginActivity.this.i2();
                case 5:
                    return CompleteLoginActivity.this.g2();
                case 6:
                    return CompleteLoginActivity.this.h2();
                default:
                    return CompleteLoginActivity.this.k2();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return -2;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Log.d("CompleteLoginActivity", "instantiateItem:" + i);
            Object objInstantiateItem = super.instantiateItem(viewGroup, i);
            if (objInstantiateItem instanceof SmsFragment) {
                CompleteLoginActivity.this.x = (SmsFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof VerifyFragment) {
                CompleteLoginActivity.this.y = (VerifyFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof GenderBirthDayFragment) {
                CompleteLoginActivity.this.z = (GenderBirthDayFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof PortraitNickFragment) {
                CompleteLoginActivity.this.A = (PortraitNickFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof OccupationFragment) {
                CompleteLoginActivity.this.B = (OccupationFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof IncomeFragment) {
                CompleteLoginActivity.this.C = (IncomeFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof IntentionFragment) {
                CompleteLoginActivity.this.E = (IntentionFragment) objInstantiateItem;
            }
            return objInstantiateItem;
        }
    }

    public static void d2(Activity activity, int i, boolean z, boolean z2) {
        Intent intent = new Intent(activity, (Class<?>) CompleteLoginActivity.class);
        Intent intent2 = activity.getIntent();
        if (intent2 != null) {
            if (intent2.getExtras() != null) {
                intent.putExtras(intent2.getExtras());
            }
            if (intent2.getAction() != null) {
                intent.setAction(intent2.getAction());
            }
            if (intent2.getType() != null) {
                intent.setType(intent2.getType());
            }
        }
        intent.putExtra("key_has_share", z);
        intent.putExtra("key_page_from", i);
        intent.putExtra("key_from_open_sdk", z2);
        intent.putExtra("key_complete_profile", true);
        activity.startActivity(intent);
    }

    public static void e2(Activity activity, int i, boolean z, boolean z2) {
        Intent intent = new Intent(activity, (Class<?>) CompleteLoginActivity.class);
        Intent intent2 = activity.getIntent();
        if (intent2 != null) {
            if (intent2.getExtras() != null) {
                intent.putExtras(intent2.getExtras());
            }
            if (intent2.getAction() != null) {
                intent.setAction(intent2.getAction());
            }
            if (intent2.getType() != null) {
                intent.setType(intent2.getType());
            }
        }
        intent.putExtra("key_has_share", z);
        intent.putExtra("key_page_from", i);
        intent.putExtra("key_from_open_sdk", z2);
        intent.putExtra("key_complete_profile", false);
        activity.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void A(boolean z, String str, int i, boolean z2, BaseLoginActivity.h hVar) {
        C1(z, str, i, z2, hVar);
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void D(int i, int i2, String str) {
        IntentionFragment intentionFragment = this.E;
        if (intentionFragment != null) {
            intentionFragment.V(i);
            this.E.n0(i2, str);
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(6);
        }
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity
    public void F1(int i) {
        try {
            if (this.s != null) {
                m2(this.u.getCurrentItem(), i, this.s.optJSONObject("data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity
    public void K1(boolean z) {
        if (z) {
            this.H = true;
        } else {
            n(0);
        }
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity
    public void L1(Bundle bundle) {
        super.L1(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.F = intent.getIntExtra("key_page_from", 0);
            boolean booleanExtra = intent.getBooleanExtra("key_complete_profile", false);
            this.G = booleanExtra;
            if (booleanExtra) {
                this.s = y63.k(this);
            }
        }
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void M0(boolean z, String str, String str2, int i, int i2, int i3) {
        y63.g(this);
        if (z && J1()) {
            JSONObject jSONObjectB = x63.b(str, i);
            try {
                jSONObjectB.put("from", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("regphotonick_complete", null, jSONObjectB);
            n2(this.u.getCurrentItem(), i, str2);
            return;
        }
        JSONObject jSONObjectB2 = x63.b(str, i);
        try {
            jSONObjectB2.put("type", i3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("regphotonick_cancel", null, jSONObjectB2);
        Z1();
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void N0(int i, int i2, JSONObject jSONObject) {
        PortraitNickFragment portraitNickFragment = this.A;
        if (portraitNickFragment != null) {
            portraitNickFragment.V(i);
            this.A.j1(i2, jSONObject);
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(3);
        }
    }

    public void Z1() {
        int i = this.F;
        if (i == 4 || i == 1 || i == 2 || i == 3 || i == 7) {
            finish();
        } else {
            n(0);
        }
    }

    public final BaseFragment a2() {
        BaseFragment baseFragment;
        Fragment fragmentB2;
        int i = this.w;
        switch (i) {
            case 0:
                baseFragment = this.x;
                break;
            case 1:
                baseFragment = this.y;
                break;
            case 2:
                baseFragment = this.z;
                break;
            case 3:
                baseFragment = this.A;
                break;
            case 4:
                baseFragment = this.B;
                break;
            case 5:
                baseFragment = this.C;
                break;
            case 6:
                baseFragment = this.E;
                break;
            default:
                baseFragment = null;
                break;
        }
        return (baseFragment == null && (fragmentB2 = b2(i)) != null && (fragmentB2 instanceof BaseFragment)) ? (BaseFragment) fragmentB2 : baseFragment;
    }

    public final Fragment b2(int i) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if ((fragment instanceof BaseLoginFragment) && ((BaseLoginFragment) fragment).R() == i) {
                return fragment;
            }
        }
        return null;
    }

    public final void c2() {
        setContentView(R.layout.layout_activity_init_new_iterative);
        View viewFindViewById = findViewById(R.id.root_view);
        this.t = viewFindViewById;
        viewFindViewById.setPadding(0, me1.h(this), 0, 0);
        View view = this.t;
        if (view != null) {
            view.setVisibility(0);
            NonSwipeableViewPager nonSwipeableViewPager = (NonSwipeableViewPager) findViewById(R.id.view_pager);
            this.u = nonSwipeableViewPager;
            nonSwipeableViewPager.setVisibility(0);
            if (this.u.getAdapter() == null) {
                this.v = new c(getSupportFragmentManager());
                try {
                    this.u.setOffscreenPageLimit(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    this.u.setAdapter(this.v);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.u.setOnPageChangeListener(new a());
            this.w = 0;
            if (this.G) {
                this.u.setCurrentItem(2);
            }
        }
    }

    public GenderBirthDayFragment f2() {
        this.z = new GenderBirthDayFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 2);
        JSONObject jSONObject = this.s;
        if (jSONObject != null) {
            bundle.putString("authResponseData", jSONObject.optString("data"));
        }
        this.z.setArguments(bundle);
        this.z.w0(this.F);
        return this.z;
    }

    public IncomeFragment g2() {
        this.C = new IncomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 5);
        this.C.setArguments(bundle);
        return this.C;
    }

    public IntentionFragment h2() {
        this.E = new IntentionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 6);
        this.E.setArguments(bundle);
        return this.E;
    }

    public OccupationFragment i2() {
        this.B = new OccupationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 4);
        this.B.setArguments(bundle);
        return this.B;
    }

    public PortraitNickFragment j2() {
        this.A = new PortraitNickFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 3);
        this.A.setArguments(bundle);
        return this.A;
    }

    public SmsFragment k2() {
        this.x = new SmsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 0);
        this.x.setArguments(bundle);
        this.x.M0(this.F);
        return this.x;
    }

    public VerifyFragment l2() {
        this.y = new VerifyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page_index", 1);
        this.y.setArguments(bundle);
        return this.y;
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void m1() {
        G1();
    }

    public void m2(int i, int i2, JSONObject jSONObject) {
        GenderBirthDayFragment genderBirthDayFragment = this.z;
        if (genderBirthDayFragment != null) {
            genderBirthDayFragment.V(i);
            this.z.B0(i2, jSONObject);
        }
        dm0.l = true;
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(2);
        }
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void n(int i) {
        if (i > 6) {
            i = 0;
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(i);
        }
    }

    public void n2(int i, int i2, String str) {
        OccupationFragment occupationFragment = this.B;
        if (occupationFragment != null) {
            occupationFragment.V(i);
            this.B.r0(i2, str);
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(4);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BaseFragment baseFragmentA2;
        try {
            if (this.u == null || this.v == null || (baseFragmentA2 = a2()) == null || !baseFragmentA2.J()) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setNeedShowKickOutDialog(false);
        ds0.a().c(this);
        L1(bundle);
        c2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.H) {
            n(0);
            this.H = false;
        }
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void p0(int i, int i2, String str) {
        IncomeFragment incomeFragment = this.C;
        if (incomeFragment != null) {
            incomeFragment.V(i);
            this.C.s0(i2, str);
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(5);
        }
    }

    @qm5
    public void prDialogEvent(x4 x4Var) {
        runOnUiThread(new b(x4Var));
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void x(int i, int i2, String str, String str2, boolean z, JSONObject jSONObject) {
        if (this.y != null) {
            if (jSONObject != null) {
                this.y.W0(true, jSONObject.optString("bizSeq"), jSONObject.optString("certPwData"), jSONObject.optString("idCardAuthData"));
            }
            this.y.V(i);
            this.y.T0(i2, str, str2);
            this.y.V0(z);
        }
        NonSwipeableViewPager nonSwipeableViewPager = this.u;
        if (nonSwipeableViewPager != null) {
            nonSwipeableViewPager.setCurrentItem(1);
        }
    }

    @Override // com.zenmen.palmchat.loginnew.a
    public void x0(LXBaseNetBean<JSONObject> lXBaseNetBean, int i) {
        D1(lXBaseNetBean, i, false);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            CompleteLoginActivity.this.w = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
