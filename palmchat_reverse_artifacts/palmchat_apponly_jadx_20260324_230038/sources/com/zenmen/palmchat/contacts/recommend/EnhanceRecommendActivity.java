package com.zenmen.palmchat.contacts.recommend;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.bo0;
import defpackage.ch;
import defpackage.fn0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.n56;
import defpackage.pm2;
import defpackage.qm5;
import defpackage.rn0;
import defpackage.sm1;
import defpackage.st2;
import defpackage.tm1;
import defpackage.uk5;
import defpackage.um1;
import defpackage.vn0;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class EnhanceRecommendActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public static final String B = "EnhanceRecommendActivity";
    public n56 A;
    public ListView s;
    public sm1 t;
    public String u;
    public TextView v;
    public ViewGroup w;
    public ViewGroup x;
    public ArrayList<ContactRequestsVO> y;
    public ArrayList<String> q = new ArrayList<>();
    public boolean r = false;
    public int z = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class NoUnderlineSpan extends UnderlineSpan {
        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#999999"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EnhanceRecommendActivity.this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TeenagersModeManager.a().d()) {
                zt5.c();
                return;
            }
            Intent intentC = st2.c();
            intentC.putExtra("fromType", 16);
            EnhanceRecommendActivity.this.startActivity(intentC);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVO = (ContactRequestsVO) adapterView.getItemAtPosition(i);
            if (contactRequestsVO != null) {
                int i2 = contactRequestsVO.type;
                String str = contactRequestsVO.identifyCode;
                String str2 = contactRequestsVO.requestRid;
                long j2 = contactRequestsVO.applyTime;
                long j3 = contactRequestsVO.applyExpireSec;
                if (jo6.r()) {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3c4", "1", contactRequestsVO.fromUid, null);
                    UserDetailActivity.W2(EnhanceRecommendActivity.this, i2, str, str2, contactRequestsVO.convert2ContactInfoItem(), 30, j2, j3, contactRequestsVO.realName, 95, 12);
                } else {
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3c4", "1", contactRequestsVO.fromUid, null);
                    UserDetailActivity.U2(EnhanceRecommendActivity.this, i2, str, str2, contactRequestsVO.convert2ContactInfoItem(), 21, j2, j3, contactRequestsVO.realName, 95);
                }
            }
        }
    }

    public static void H1(Activity activity) {
        if (tm1.a().b() && tm1.a().c(activity, false, false)) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) EnhanceRecommendActivity.class));
    }

    public static void I1(Activity activity) {
        if (tm1.a().c(activity, true, false)) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) EnhanceRecommendActivity.class));
    }

    public static void J1(Activity activity) {
        if (tm1.a().c(activity, true, true)) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) EnhanceRecommendActivity.class);
        intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
        activity.startActivity(intent);
    }

    public final ArrayList<ContactRequestsVO> D1(ArrayList<ContactRequestsVO> arrayList) {
        ArrayList<ContactRequestsVO> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (ContactRequestsVO contactRequestsVO : arrayList) {
                if (!bo0.r().w(contactRequestsVO.fromUid)) {
                    arrayList2.add(contactRequestsVO);
                }
            }
        }
        return arrayList2;
    }

    public final void E1() {
        this.w = (ViewGroup) findViewById(R.id.empty_layout);
        this.x = (ViewGroup) findViewById(R.id.content_layout);
        this.s = (ListView) findViewById(R.id.contact_request_list);
        this.v = (TextView) findViewById(R.id.click_button_text_view);
        SpannableString spannableString = new SpannableString(getString(R.string.no_recommend_hint_to_nearby_button));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        this.v.setText(spannableString);
        this.v.setOnClickListener(new b());
        sm1 sm1Var = new sm1(this);
        this.t = sm1Var;
        this.s.setAdapter((ListAdapter) sm1Var);
        this.s.setOnScrollListener(new c());
        this.s.setOnItemClickListener(new d());
        UI.c(this, 5, null, this);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        ArrayList<ContactRequestsVO> arrayListG1;
        boolean z;
        if (cursor == null) {
            L1(false);
            return;
        }
        LogUtil.d(B, "onLoadFinished count:" + cursor.getCount());
        ArrayList<ContactRequestsVO> arrayListBuildFromCursorForEnhancedContact = ContactRequestsVO.buildFromCursorForEnhancedContact(cursor, false, true);
        if (arrayListBuildFromCursorForEnhancedContact == null) {
            L1(false);
            return;
        }
        ArrayList<ContactRequestsVO> arrayListD1 = D1(arrayListBuildFromCursorForEnhancedContact);
        if (this.q.size() > 0) {
            arrayListG1 = new ArrayList<>();
            for (String str : this.q) {
                for (ContactRequestsVO contactRequestsVO : arrayListD1) {
                    if (contactRequestsVO.fromUid.equals(str)) {
                        arrayListG1.add(contactRequestsVO);
                    }
                }
            }
            for (ContactRequestsVO contactRequestsVO2 : arrayListD1) {
                Iterator<String> it = this.q.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (contactRequestsVO2.fromUid.equals(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    arrayListG1.add(0, contactRequestsVO2);
                }
            }
        } else {
            arrayListG1 = G1(arrayListD1);
            this.q.clear();
            Iterator<ContactRequestsVO> it2 = arrayListG1.iterator();
            while (it2.hasNext()) {
                this.q.add(it2.next().fromUid);
            }
        }
        this.y = arrayListG1;
        this.t.l(arrayListG1);
        L1(arrayListG1.size() > 0);
    }

    public final ArrayList<ContactRequestsVO> G1(ArrayList<ContactRequestsVO> arrayList) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        long jI = sPUtil.i(scene, k86.a("key_accept_limit_daily_date"), 0L);
        Date date = new Date();
        date.setTime(jI);
        Date date2 = new Date();
        if (jI <= 0) {
            sPUtil.t(scene, k86.a("key_accept_limit_daily_date"), Long.valueOf(System.currentTimeMillis()));
            return arrayList;
        }
        if (date2.getDate() != date.getDate()) {
            sPUtil.t(scene, k86.a("key_accept_limit_daily_date"), Long.valueOf(System.currentTimeMillis()));
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<ContactRequestsVO> arrayList3 = new ArrayList<>();
        ArrayList<ContactRequestsVO> arrayList4 = new ArrayList<>();
        ArrayList<ContactRequestsVO> arrayList5 = new ArrayList<>();
        for (ContactRequestsVO contactRequestsVO : arrayList) {
            int i = contactRequestsVO.enhancedTag;
            if (i == 1) {
                arrayList2.add(contactRequestsVO);
            } else if (i == 2) {
                arrayList3.add(contactRequestsVO);
            } else {
                arrayList4.add(contactRequestsVO);
            }
        }
        K1(arrayList3);
        K1(arrayList4);
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        return arrayList5;
    }

    public final void K1(ArrayList<ContactRequestsVO> arrayList) {
        int i = 1;
        int size = arrayList.size() - 1;
        if (arrayList.size() == 0 || arrayList.size() == 1) {
            return;
        }
        int i2 = size / 2;
        if (i2 > 10) {
            i2 = 10;
        }
        if (i2 >= 3 && size >= 10) {
            i = 3;
        }
        Random random = new Random();
        for (int i3 = 0; i3 < i && i2 > 0; i3++) {
            int iNextInt = random.nextInt(i2);
            int iNextInt2 = random.nextInt(size - i2) + i2;
            ContactRequestsVO contactRequestsVO = arrayList.get(iNextInt);
            arrayList.set(iNextInt, arrayList.get(iNextInt2));
            arrayList.set(iNextInt2, contactRequestsVO);
        }
    }

    public final void L1(boolean z) {
        if (z) {
            this.w.setVisibility(8);
            this.x.setVisibility(0);
        } else {
            this.w.setVisibility(0);
            this.x.setVisibility(8);
        }
    }

    public final void M1() {
        if (um1.b().d()) {
            n56 n56Var = new n56();
            this.A = n56Var;
            try {
                n56Var.n();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    public final void N1() {
        if (um1.b().d()) {
            if (this.A == null) {
                this.A = new n56();
            }
            try {
                this.A.o();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        N1();
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_contact_new_tag"), 0);
        super.finish();
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(R.string.source_type_people_you_may_know, true));
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        this.s.post(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_enhance_recommend);
        Intent intent = getIntent();
        if (intent != null) {
            this.r = intent.getBooleanExtra("need_keep_sort", false);
        }
        initActionBar();
        E1();
        bo0.r().i().j(this);
        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3c2", "1", null, null);
        M1();
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        this.u = um1.b().a();
        return new CursorLoader(this, vn0.f21483a, null, "request_type=?  AND insert_date=? ", new String[]{Integer.toString(302), this.u}, "_id");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        sm1 sm1Var = this.t;
        if (sm1Var != null) {
            sm1Var.i();
        }
        n56 n56Var = this.A;
        if (n56Var != null) {
            n56Var.onCancel();
        }
        bo0.r().i().l(this);
        rn0.o();
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
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            ch.s().r().j(this);
        } catch (Exception unused) {
        }
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(B, "onStatusChanged type =" + uk5Var.f21235a);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ArrayList<ContactRequestsVO> arrayList = this.y;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (this.z == -1 && this.y.size() > 8) {
            this.z = 8;
        }
        if (this.y.size() > 0 && this.z >= this.y.size()) {
            this.z = this.y.size() - 1;
        }
        ContactRequestsVO contactRequestsVO = this.y.get(this.z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("row", this.z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3c3", "3", contactRequestsVO.fromUid, jSONObject.toString());
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int i4 = i + i2;
            if (i4 > EnhanceRecommendActivity.this.z) {
                EnhanceRecommendActivity.this.z = i4;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }
}
