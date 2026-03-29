package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b35;
import defpackage.b5;
import defpackage.bo0;
import defpackage.c5;
import defpackage.fn0;
import defpackage.io0;
import defpackage.jo6;
import defpackage.l50;
import defpackage.n54;
import defpackage.qm5;
import defpackage.rn0;
import defpackage.s42;
import defpackage.st2;
import defpackage.td3;
import defpackage.u13;
import defpackage.vn0;
import defpackage.wc;
import defpackage.zm5;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewContactTotalActivity extends BaseActionBarActivity {
    public ListView q;
    public com.zenmen.palmchat.contacts.b r;
    public ViewGroup t;
    public ViewGroup u;
    public TextView v;
    public zm5 y;
    public List<ContactRequestsVO> s = new ArrayList();
    public int w = 6;
    public int x = 3;
    public ContentObserver z = new e(null);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewContactTotalActivity.this.r.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVOD = adapterView.getItemAtPosition(i) instanceof b.j ? ((b.j) adapterView.getItemAtPosition(i)).d() : null;
            if (contactRequestsVOD != null) {
                int i2 = contactRequestsVOD.type;
                String str = contactRequestsVOD.identifyCode;
                String str2 = contactRequestsVOD.requestRid;
                long j2 = contactRequestsVOD.applyTime;
                long j3 = contactRequestsVOD.applyExpireSec;
                if (jo6.r()) {
                    UserDetailActivity.W2(NewContactTotalActivity.this, i2, str, str2, contactRequestsVOD.convert2ContactInfoItem(), 21, j2, j3, contactRequestsVOD.realName, NewContactTotalActivity.this.w, 4);
                } else {
                    UserDetailActivity.U2(NewContactTotalActivity.this, i2, str, str2, contactRequestsVOD.convert2ContactInfoItem(), 21, j2, j3, contactRequestsVOD.realName, NewContactTotalActivity.this.w);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13394a;

            public a(String str) {
                this.f13394a = str;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                rn0.f(this.f13394a);
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVOD = adapterView.getItemAtPosition(i) instanceof b.j ? ((b.j) adapterView.getItemAtPosition(i)).d() : null;
            if (contactRequestsVOD == null) {
                return true;
            }
            new td3.c(NewContactTotalActivity.this).c(new String[]{NewContactTotalActivity.this.getString(R.string.string_delete)}).d(new a(contactRequestsVOD.fromUid)).a().b();
            return true;
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
            if (TeenagersModeManager.a().d()) {
                zt5.c();
            } else {
                if (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
                    return;
                }
                u13.b().a();
                Intent intentC = st2.c();
                intentC.putExtra("fromType", 17);
                NewContactTotalActivity.this.startActivity(intentC);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends ContentObserver {
        public e(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            LogUtil.d("logcontacts", "total: onChange");
            NewContactTotalActivity.this.G1(100L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements b5 {
        public h() {
        }

        @Override // defpackage.b5
        public void call() {
            NewContactTotalActivity.this.J1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements s42<Long, Boolean> {
        public i() {
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Long l) {
            NewContactTotalActivity.this.H1();
            return Boolean.TRUE;
        }
    }

    public final void F1() {
        this.t = (ViewGroup) findViewById(R.id.empty_layout);
        this.u = (ViewGroup) findViewById(R.id.content_layout);
        this.q = (ListView) findViewById(R.id.contact_request_list);
        this.v = (TextView) findViewById(R.id.empty_tips);
        b.k kVar = new b.k();
        kVar.f13564a = this.w;
        kVar.b = this.x;
        kVar.c = 21;
        kVar.e = true;
        kVar.f = true;
        com.zenmen.palmchat.contacts.b bVar = new com.zenmen.palmchat.contacts.b(this, com.zenmen.palmchat.contacts.d.j().m(), kVar);
        this.r = bVar;
        this.q.setAdapter((ListAdapter) bVar);
        this.q.setDividerHeight(0);
        this.q.setOnItemClickListener(new b());
        this.q.setOnItemLongClickListener(new c());
        this.v.setText(Html.fromHtml(getResources().getString(R.string.new_friend_empty_tips)));
        this.v.setOnClickListener(new d());
    }

    public final void G1(long j) {
        LogUtil.d("logcontacts", "total: loadData");
        zm5 zm5Var = this.y;
        if (zm5Var != null) {
            zm5Var.unsubscribe();
        }
        this.y = n54.v(j, TimeUnit.MILLISECONDS).h(new i()).u(b35.c()).i(wc.a()).d(new h()).q(new f(), new g());
    }

    public final synchronized void H1() {
        this.s.clear();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "source_type!=? and source_type!=? and source_type!=? and request_type<? ", new String[]{Integer.toString(14), Integer.toString(34), Integer.toString(28), Integer.toString(100)}, "send_time DESC");
                ArrayList<ContactRequestsVO> arrayListBuildFromCursorForLX16234 = ContactRequestsVO.buildFromCursorForLX16234(cursorQuery, true);
                I1(arrayListBuildFromCursorForLX16234);
                for (ContactRequestsVO contactRequestsVO : arrayListBuildFromCursorForLX16234) {
                    contactRequestsVO.readStatus = 1L;
                    this.s.add(contactRequestsVO);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            LogUtil.d("logcontacts", "total: loadRequests, requests=" + this.s.size());
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final void I1(ArrayList<ContactRequestsVO> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<ContactRequestsVO> it = arrayList.iterator();
        while (it.hasNext()) {
            ContactRequestsVO next = it.next();
            if (io0.u(next.sourceType) && !bo0.r().w(next.fromUid) && !ContactRequestsVO.isSenderParseFromRid(next.requestRid)) {
                long j = next.applyTime;
                if (j > 0 && jCurrentTimeMillis > j + (next.applyExpireSec * 1000)) {
                    it.remove();
                }
            }
        }
    }

    public final void J1() {
        LogUtil.d("logcontacts", "total: updateData");
        if (this.s.isEmpty()) {
            this.t.setVisibility(0);
            this.u.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        ArrayList<b.j> arrayList = new ArrayList<>();
        arrayList.addAll(K1(this.s));
        this.r.s(arrayList);
    }

    public final List<b.j> K1(List<ContactRequestsVO> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ContactRequestsVO> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new b.j(it.next()));
        }
        return arrayList;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 202;
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.new_friend_total_title);
        ((TextView) toolbarInitToolbar.findViewById(R.id.action_button)).setVisibility(8);
        setSupportActionBar(toolbarInitToolbar);
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        this.q.post(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_new_friend_total);
        initActionBar();
        F1();
        bo0.r().i().j(this);
        getContentResolver().registerContentObserver(vn0.f21483a, true, this.z);
        G1(0L);
        LogUtil.onImmediateClickEvent("2c12", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.zenmen.palmchat.contacts.b bVar = this.r;
        if (bVar != null) {
            bVar.p();
        }
        getContentResolver().unregisterContentObserver(this.z);
        bo0.r().i().l(this);
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

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.r.v(com.zenmen.palmchat.contacts.d.j().m());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements c5<Boolean> {
        public f() {
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements c5<Throwable> {
        public g() {
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
        }
    }
}
