package com.zenmen.palmchat.peoplenearby;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.bo0;
import defpackage.ch;
import defpackage.f46;
import defpackage.fn0;
import defpackage.jo6;
import defpackage.pm2;
import defpackage.qm5;
import defpackage.rn0;
import defpackage.sd3;
import defpackage.td3;
import defpackage.vn0;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NearbyHistoryActivity extends BaseActionBarActivity implements pm2<Cursor>, View.OnClickListener {
    public static final String w = "NearbyHistoryActivity";
    public ListView q;
    public LinearLayout r;
    public TextView s;
    public com.zenmen.palmchat.contacts.b t;
    public ArrayList<ContactRequestsVO> u;
    public boolean v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVOD = adapterView.getItemAtPosition(i) instanceof b.j ? ((b.j) adapterView.getItemAtPosition(i)).d() : null;
            if (contactRequestsVOD != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(x.cw, TextUtils.isEmpty(contactRequestsVOD.carImageUrl) ? 2 : 1);
                    LogUtil.uploadInfoImmediate("fjdrzj009", null, null, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UserDetailActivity.V2(NearbyHistoryActivity.this, contactRequestsVOD.type, contactRequestsVOD.identifyCode, contactRequestsVOD.requestRid, contactRequestsVOD.convert2ContactInfoItem(), 0, "", false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14940a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.peoplenearby.NearbyHistoryActivity$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1091a extends HashMap<String, Object> {
                public C1091a() {
                    put("fuid", a.this.f14940a);
                }
            }

            public a(String str) {
                this.f14940a = str;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                rn0.e(this.f14940a);
                zn6.j("nearby_sayhai_delete", "click", new C1091a());
            }
        }

        public b() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVOD = adapterView.getItemAtPosition(i) instanceof b.j ? ((b.j) adapterView.getItemAtPosition(i)).d() : null;
            if (contactRequestsVOD == null) {
                return true;
            }
            new td3.c(NearbyHistoryActivity.this).c(new String[]{NearbyHistoryActivity.this.getString(R.string.string_delete)}).d(new a(contactRequestsVOD.fromUid)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {

            /* JADX INFO: renamed from: com.zenmen.palmchat.peoplenearby.NearbyHistoryActivity$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1092a extends HashMap<String, Object> {
                public C1092a() {
                    put("fuids", NearbyHistoryActivity.this.E1());
                }
            }

            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                zn6.j("nearby_sayhai_clear", "click", new C1092a());
                rn0.d();
                NearbyHistoryActivity.this.s.setEnabled(false);
                NearbyHistoryActivity.this.v = true;
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(NearbyHistoryActivity.this).b(true).j(R.string.shake_confirm_clear).K(R.string.alert_dialog_cancel).O(R.string.string_clear).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NearbyHistoryActivity.this.t.notifyDataSetChanged();
        }
    }

    public final String E1() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ContactRequestsVO> arrayList = this.u;
        if (arrayList != null) {
            for (ContactRequestsVO contactRequestsVO : arrayList) {
                if (sb.length() == 0) {
                    sb.append(contactRequestsVO.fromUid);
                } else {
                    sb.append(",");
                    sb.append(contactRequestsVO.fromUid);
                }
            }
        }
        return sb.toString();
    }

    public final void F1() {
        this.q = (ListView) findViewById(R.id.history_list);
        this.r = (LinearLayout) findViewById(R.id.no_history_area);
        b.k kVar = new b.k();
        kVar.f13564a = 14;
        kVar.g = jo6.u();
        com.zenmen.palmchat.contacts.b bVar = new com.zenmen.palmchat.contacts.b(this, com.zenmen.palmchat.contacts.d.j().m(), kVar);
        this.t = bVar;
        this.q.setAdapter((ListAdapter) bVar);
        this.q.setEmptyView(this.r);
        this.q.setOnItemClickListener(new a());
        this.q.setOnItemLongClickListener(new b());
        UI.c(this, 3, null, this);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        ArrayList<ContactRequestsVO> arrayList;
        if (cursor != null) {
            LogUtil.d(w, "onLoadFinished count:" + cursor.getCount());
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForShow = ContactRequestsVO.buildFromCursorForShow(cursor);
            if (arrayListBuildFromCursorForShow.size() != 0 || (arrayList = this.u) == null || arrayList.size() <= 0 || this.v) {
                this.t.t(arrayListBuildFromCursorForShow);
                this.u = arrayListBuildFromCursorForShow;
                if (cursor.getCount() > 0) {
                    this.s.setEnabled(true);
                } else {
                    this.s.setEnabled(false);
                }
                this.v = false;
            }
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID;
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.nearby_more_greet);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.s = textView;
        textView.setText(R.string.string_clear);
        this.s.setOnClickListener(new c());
        setSupportActionBar(toolbarInitToolbar);
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        this.q.post(new d());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_nearby_history);
        initActionBar();
        F1();
        bo0.r().i().j(this);
        LogUtil.uploadInfoImmediate("3302", null, null, null);
        f46.k(ch.s().u(), 7, null);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, vn0.f21483a, null, "source_type=? or source_type=? or source_type=?", new String[]{Integer.toString(4), Integer.toString(34), Integer.toString(14)}, "_id DESC");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.zenmen.palmchat.contacts.b bVar = this.t;
        if (bVar != null) {
            bVar.p();
        }
        bo0.r().i().l(this);
        rn0.p();
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

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
