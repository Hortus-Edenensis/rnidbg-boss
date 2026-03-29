package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.ac1;
import defpackage.ad1;
import defpackage.bg2;
import defpackage.bo0;
import defpackage.ch;
import defpackage.cn0;
import defpackage.cy5;
import defpackage.fk2;
import defpackage.fn0;
import defpackage.gu4;
import defpackage.io0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.n5;
import defpackage.on0;
import defpackage.pm2;
import defpackage.qm5;
import defpackage.rn0;
import defpackage.sd3;
import defpackage.td3;
import defpackage.uk5;
import defpackage.vn0;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.webplatform.jssdk.ContactPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewContactActivity extends BaseActionBarActivity implements pm2<Cursor>, View.OnClickListener {
    public static final String F = "NewContactActivity";
    public boolean A;
    public ArrayList<ContactRequestsVO> B;
    public boolean C;
    public ListView r;
    public com.zenmen.palmchat.contacts.b s;
    public View t;
    public View u;
    public TextView v;
    public ViewGroup w;
    public ViewGroup x;
    public HashMap<Integer, Integer> q = new HashMap<>();
    public int y = 6;
    public int z = 3;
    public String E = "7";

    /* JADX INFO: compiled from: SearchBox */
    public class NoUnderlineSpan extends UnderlineSpan {
        public NoUnderlineSpan() {
        }

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
            NewContactActivity.this.s.notifyDataSetChanged();
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
                    UserDetailActivity.W2(NewContactActivity.this, i2, str, str2, contactRequestsVOD.convert2ContactInfoItem(), 21, j2, j3, contactRequestsVOD.realName, 0, 4);
                } else {
                    UserDetailActivity.U2(NewContactActivity.this, i2, str, str2, contactRequestsVOD.convert2ContactInfoItem(), 21, j2, j3, contactRequestsVOD.realName, 0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13367a;
            public final /* synthetic */ int b;

            /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.NewContactActivity$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1018a extends HashMap<String, Object> {
                public C1018a() {
                    put("fuid", a.this.f13367a);
                }
            }

            public a(String str, int i) {
                this.f13367a = str;
                this.b = i;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                NewContactActivity.this.C = true;
                rn0.f(this.f13367a);
                if (this.b < 100) {
                    zn6.j("new_apply_delete", "click", new C1018a());
                }
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
            new td3.c(NewContactActivity.this).c(new String[]{NewContactActivity.this.getString(R.string.string_delete)}).d(new a(contactRequestsVOD.fromUid, contactRequestsVOD.type)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13371a;

        public e(uk5 uk5Var) {
            this.f13371a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f13371a;
            if (uk5Var.f21235a != 22) {
                return;
            }
            String str = uk5Var.d;
            if (ad1.j(ad1.i, str)) {
                LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "onStatusChanged pageIndex = " + str);
                ad1.h().m(ad1.i, NewContactActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends ClickableSpan implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f13372a;

        public f(View.OnClickListener onClickListener) {
            this.f13372a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13372a.onClick(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Comparator<ContactRequestsVO> {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ContactRequestsVO contactRequestsVO, ContactRequestsVO contactRequestsVO2) {
            if (contactRequestsVO.getSortId() != contactRequestsVO2.getSortId()) {
                if (contactRequestsVO.getSortId() == 0) {
                    return -1;
                }
                if (contactRequestsVO2.getSortId() == 0) {
                    return 1;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements fk2 {
        public static Intent b(Context context) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_msg");
            bundle.putString("thread_sub_tab", "tab_new_friend");
            aVar.b(bundle);
            return n5.b(context, aVar);
        }

        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            return b(context);
        }
    }

    public final void D1() {
        if (jo6.l()) {
            F1();
        } else {
            E1();
        }
    }

    public final void F1() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
        int iF = sPUtil.f(scene, k86.a("key_contact_request_recommend_switch"), 0);
        if (iF != 0) {
            if (iF == 1) {
                L1(this.v, H1());
                return;
            }
            return;
        }
        long jI = sPUtil.i(scene, k86.a("key_inited_time"), -1L);
        long jL = io0.l();
        if (jI <= 0 || jL == 0 || cy5.d(jI, System.currentTimeMillis()) >= jL) {
            this.A = true;
        }
    }

    public final void G1(ArrayList<ContactRequestsVO> arrayList) {
        int i = 0;
        this.A = false;
        List<String> listM = io0.m();
        if (listM == null || listM.size() <= 0) {
            return;
        }
        Iterator<ContactRequestsVO> it = arrayList.iterator();
        while (it.hasNext()) {
            if (listM.contains(String.valueOf(it.next().sourceType))) {
                i++;
            }
        }
        if (i >= io0.k()) {
            L1(this.v, H1());
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_request_recommend_switch"), 1);
        }
    }

    public final SpannableString H1() {
        d dVar = new d();
        String strJ = io0.j();
        if (TextUtils.isEmpty(strJ)) {
            strJ = AppContext.getContext().getString(R.string.close_recommend_rec_notice);
        }
        String strConcat = strJ.concat(AppContext.getContext().getString(R.string.close_recommend_rec_click));
        SpannableString spannableString = new SpannableString(strConcat);
        int length = strJ.length();
        int length2 = strConcat.length();
        NoUnderlineSpan noUnderlineSpan = new NoUnderlineSpan();
        spannableString.setSpan(new f(dVar), length, length2, 17);
        spannableString.setSpan(noUnderlineSpan, length, length2, 17);
        return spannableString;
    }

    public final void I1() {
        this.w = (ViewGroup) findViewById(R.id.empty_layout);
        this.x = (ViewGroup) findViewById(R.id.content_layout);
        this.r = (ListView) findViewById(R.id.contact_request_list);
        b.k kVar = new b.k();
        kVar.f13564a = this.y;
        kVar.b = this.z;
        kVar.c = 21;
        kVar.e = true;
        this.s = new com.zenmen.palmchat.contacts.b(this, com.zenmen.palmchat.contacts.d.j().m(), kVar);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_add_new_friend_header, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.search_account);
        if (textView != null) {
            textView.setText(com.zenmen.palmchat.activity.search.c.f());
        }
        this.r.addHeaderView(viewInflate);
        viewInflate.findViewById(R.id.search_area).setOnClickListener(this);
        this.t = findViewById(R.id.add_contact_from_phone1);
        this.u = viewInflate.findViewById(R.id.add_contact_from_phone2);
        this.v = (TextView) viewInflate.findViewById(R.id.close_recommend_notice_tv);
        D1();
        if (ac1.C()) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
        this.u.setOnClickListener(this);
        this.r.setAdapter((ListAdapter) this.s);
        this.r.setOnItemClickListener(new b());
        this.r.setOnItemLongClickListener(new c());
        findViewById(R.id.add_contact_from_phone1).setOnClickListener(this);
        UI.c(this, 3, null, this);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        ArrayList<ContactRequestsVO> arrayList;
        if (cursor != null) {
            LogUtil.d(F, "onLoadFinished count:" + cursor.getCount());
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForLX16234 = ContactRequestsVO.buildFromCursorForLX16234(cursor, true);
            if (arrayListBuildFromCursorForLX16234.size() != 0 || (arrayList = this.B) == null || arrayList.size() <= 0 || this.C) {
                K1(arrayListBuildFromCursorForLX16234);
                if (bg2.d()) {
                    M1(arrayListBuildFromCursorForLX16234);
                }
                if (this.A) {
                    G1(arrayListBuildFromCursorForLX16234);
                }
                this.s.t(arrayListBuildFromCursorForLX16234);
                this.B = arrayListBuildFromCursorForLX16234;
                N1(arrayListBuildFromCursorForLX16234.size() > 0);
                this.C = false;
            }
        }
    }

    public final void K1(ArrayList<ContactRequestsVO> arrayList) {
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

    public final void L1(TextView textView, SpannableString spannableString) {
        if (jo6.l()) {
            LogUtil.uploadInfoImmediate("yj1", "1", null, null);
        } else {
            LogUtil.uploadInfoImmediate("291", "1", null, null);
        }
        textView.setVisibility(0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
    }

    public final void M1(ArrayList<ContactRequestsVO> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (ContactRequestsVO contactRequestsVO : arrayList) {
            if (this.q.containsKey(Integer.valueOf(contactRequestsVO.id))) {
                contactRequestsVO.setSortId(this.q.get(Integer.valueOf(contactRequestsVO.id)).intValue());
            } else {
                this.q.put(Integer.valueOf(contactRequestsVO.id), Integer.valueOf(contactRequestsVO.genSortId()));
            }
        }
        Collections.sort(arrayList, new g());
    }

    public final void N1(boolean z) {
        if (z) {
            this.w.setVisibility(8);
            this.x.setVisibility(0);
        } else {
            if (ac1.C()) {
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
            }
            this.x.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 202;
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.new_friend_title);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        textView.setText(R.string.add_contact);
        textView.setOnClickListener(this);
        toolbarInitToolbar.setBackgroundResource(R.color.color_FFFFFF);
        toolbarInitToolbar.setNavigationIcon(R.drawable.selector_arrow_back);
        setSupportActionBar(toolbarInitToolbar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.action_button) {
            Intent intent = new Intent(this, (Class<?>) AddContactActivity.class);
            intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_newcontact_menu");
            startActivity(intent);
        } else {
            if (view.getId() == R.id.search_area) {
                startActivity(new Intent(AppContext.getContext(), (Class<?>) (jo6.A() ? SearchUserActivityV2.class : SearchUserActivity.class)));
                return;
            }
            if (view.getId() == R.id.add_contact_from_phone2 || view.getId() == R.id.add_contact_from_phone1) {
                if (AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                    startActivity(on0.a("upload_contact_from_newcontact"));
                    return;
                }
                Intent intent2 = new Intent(this, (Class<?>) LinkMobileActivity.class);
                intent2.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_newcontact");
                startActivity(intent2);
            }
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        this.r.post(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_new_friend);
        initActionBar();
        I1();
        bo0.r().i().j(this);
        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "2131n", "1", null, null);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, vn0.f21483a, null, "source_type!=? and source_type!=? and source_type!=? and source_type!=? and request_type!=? and request_type!=? and request_type!=? ", new String[]{Integer.toString(14), Integer.toString(34), Integer.toString(4), Integer.toString(28), Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR), Integer.toString(301), Integer.toString(302)}, "send_time DESC");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        rn0.n();
        rn0.l();
        rn0.m();
        gu4.c(0, false);
        com.zenmen.palmchat.contacts.b bVar = this.s;
        if (bVar != null) {
            bVar.p();
        }
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

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.zenmen.palmchat.utils.a.E().t(0);
        cn0.b().a();
        this.s.v(com.zenmen.palmchat.contacts.d.j().m());
        ad1.h().m(ad1.i, this);
        try {
            ch.s().r().j(this);
        } catch (Exception unused) {
        }
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(F, "onStatusChanged type =" + uk5Var.f21235a);
        runOnUiThread(new e(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strI = io0.i();
            if (TextUtils.isEmpty(strI)) {
                strI = AppContext.getContext().getString(R.string.close_recommend_rec_dialog_notice);
            }
            new sd3(NewContactActivity.this).k(strI).O(R.string.alert_dialog_i_knoW).f(new a()).e().show();
            NewContactActivity.this.v.setVisibility(8);
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_request_recommend_switch"), 2);
            LogUtil.uploadInfoImmediate("yj11", "1", null, null);
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
            }
        }
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public final void E1() {
    }
}
