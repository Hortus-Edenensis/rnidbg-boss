package com.zenmen.palmchat.webplatform.miniPrograms;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.R$id;
import com.zenmen.palmchat.webplatform.R$layout;
import com.zenmen.palmchat.webplatform.R$menu;
import com.zenmen.palmchat.webplatform.R$string;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.a;
import com.zenmen.palmchat.webplatform.miniPrograms.MiniProgramsListActivity;
import com.zenmen.palmchat.webplatform.miniPrograms.b;
import defpackage.hq3;
import defpackage.k86;
import defpackage.pp3;
import defpackage.td3;
import defpackage.v4;
import defpackage.yy2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MiniProgramsMainActivity extends FrameworkBaseActivity {
    public MiniProgramListView q;
    public com.zenmen.palmchat.webplatform.miniPrograms.b r;
    public List<Package> s;
    public Cursor t;
    public List<Package> w;
    public int u = 1;
    public int v = 20;
    public View.OnClickListener x = new a();
    public View.OnLongClickListener y = new b();
    public LoaderManager.LoaderCallbacks<Cursor> z = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.c cVar = (b.c) view.getTag();
            if (cVar == null) {
                return;
            }
            int i = cVar.e;
            if (i == 0) {
                Intent intent = new Intent();
                intent.setClass(MiniProgramsMainActivity.this, MiniProgramsListActivity.class);
                MiniProgramsMainActivity.this.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClass(MiniProgramsMainActivity.this, WebModuleActivity.class);
            Bundle bundle = new Bundle();
            Package r6 = (Package) MiniProgramsMainActivity.this.s.get(i - 1);
            bundle.putInt("extra_type", 2);
            bundle.putInt("extra_from", 1);
            bundle.putSerializable("extra_package", r6);
            bundle.putBoolean("web_show_share", true);
            intent2.putExtras(bundle);
            MiniProgramsMainActivity.this.startActivityForResult(intent2, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.c f15951a;

            public a(b.c cVar) {
                this.f15951a = cVar;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                Package r1 = (Package) MiniProgramsMainActivity.this.s.get(this.f15951a.e - 1);
                if (i != 0) {
                    return;
                }
                MiniProgramsMainActivity.this.I1(r1.pkgId);
            }
        }

        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.c cVar = (b.c) view.getTag();
            if (cVar == null) {
                return true;
            }
            new td3.c(MiniProgramsMainActivity.this).c(new String[]{MiniProgramsMainActivity.this.getString(R$string.delete)}).d(new a(cVar)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements LoaderManager.LoaderCallbacks<Cursor> {
        public c() {
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            LogUtil.i("MiniProgramsMainActivity", "onLoadFinished");
            if (loader.getId() != 1 || cursor == null) {
                return;
            }
            MiniProgramsMainActivity.this.K1(cursor);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            if (i != 1) {
                return null;
            }
            return new CursorLoader(MiniProgramsMainActivity.this, hq3.f18029a, null, "uid=?", new String[]{v4.e(MiniProgramsMainActivity.this)}, "timestamp DESC");
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> loader) {
            LogUtil.i("MiniProgramsMainActivity", "onLoaderReset");
            if (MiniProgramsMainActivity.this.t != null) {
                MiniProgramsMainActivity.this.t.close();
                MiniProgramsMainActivity.this.t = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements a.InterfaceC1135a {
        public d() {
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void a(JSONObject jSONObject, yy2 yy2Var) {
            List<Package> list;
            LogUtil.i("MiniProgramsMainActivity", "getPkgListFromServer onSuccess oriData = " + jSONObject.toString());
            MiniProgramsListActivity.d dVar = new MiniProgramsListActivity.d();
            dVar.f15947a = jSONObject.optInt("resultCode");
            dVar.b = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            if (dVar.f15947a == 0) {
                dVar.c = new MiniProgramsListActivity.e();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                dVar.c.f15948a = jSONObjectOptJSONObject.optInt("totalCount");
                dVar.c.c = jSONObjectOptJSONObject.optInt("pageNum");
                dVar.c.b = jSONObjectOptJSONObject.optInt("pageSize");
                dVar.c.d = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("page");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        Package r4 = new Package();
                        r4.pkgId = jSONObjectOptJSONObject2.optString("appId");
                        r4.name = jSONObjectOptJSONObject2.optString("name");
                        r4.md5 = jSONObjectOptJSONObject2.optString("md5");
                        r4.version = jSONObjectOptJSONObject2.optInt("version");
                        r4.icon = jSONObjectOptJSONObject2.optString("icon");
                        r4.description = jSONObjectOptJSONObject2.optString("description");
                        dVar.c.d.add(r4);
                    }
                }
                MiniProgramsMainActivity.this.q.setVisibility(0);
                MiniProgramsListActivity.e eVar = dVar.c;
                if (eVar == null || (list = eVar.d) == null || list.size() == 0) {
                    return;
                }
                MiniProgramsMainActivity.this.w = eVar.d;
                LogUtil.i("MiniProgramsMainActivity", "getPkgListFromServer size = " + MiniProgramsMainActivity.this.w.size());
            }
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void onFail(Exception exc) {
            LogUtil.i("MiniProgramsMainActivity", "getPkgListFromServer onFail error = " + exc.toString());
        }
    }

    public final void I1(String str) {
        com.zenmen.palmchat.webplatform.a.a(str, null);
    }

    public final void J1() {
        LogUtil.i("MiniProgramsMainActivity", "getPkgListFromServer, pageNum = " + this.u + ", pageSize = " + this.v);
        com.zenmen.palmchat.webplatform.a.d(this.u, this.v, new d());
    }

    public final void K1(Cursor cursor) {
        Cursor cursor2 = this.t;
        if (cursor2 != null) {
            cursor2.close();
        }
        this.t = cursor;
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("web_name");
            int columnIndex2 = cursor.getColumnIndex("web_id");
            int columnIndex3 = cursor.getColumnIndex("version");
            int columnIndex4 = cursor.getColumnIndex("icon");
            int columnIndex5 = cursor.getColumnIndex("description");
            this.s.clear();
            while (cursor.moveToNext()) {
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex2);
                int i = cursor.getInt(columnIndex3);
                String string3 = cursor.getString(columnIndex4);
                String string4 = cursor.getString(columnIndex5);
                Package r10 = new Package();
                r10.name = string;
                r10.pkgId = string2;
                r10.version = i;
                r10.icon = string3;
                r10.description = string4;
                this.s.add(r10);
            }
        }
        LogUtil.i("MiniProgramsMainActivity", "initPackageList mPackages size = " + this.s.size());
        this.r.c(this.s);
    }

    public final void L1() {
        setSupportActionBar(initToolbar(R$id.toolbar, getResources().getString(R$string.mini_program_title), true));
    }

    public final void M1() {
        this.q = (MiniProgramListView) findViewById(R$id.mini_program_listview);
        com.zenmen.palmchat.webplatform.miniPrograms.b bVar = new com.zenmen.palmchat.webplatform.miniPrograms.b(this, this.x, this.y);
        this.r = bVar;
        this.q.setAdapter((ListAdapter) bVar);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == 1000) {
            pp3.e(this);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_activity_miniprograms);
        L1();
        M1();
        this.s = new ArrayList();
        getLoaderManager().initLoader(1, null, this.z);
        LogUtil.uploadInfoImmediate("61", HiAnalyticsConstant.KeyAndValue.NUMBER_01, null, null);
        J1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.menu_mini_program, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(1);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else if (menuItem.getItemId() == R$id.menu_search) {
            Intent intent = new Intent(this, (Class<?>) MiniProgramSearchActivity.class);
            intent.putExtra(MiniProgramSearchActivity.A, (Serializable) this.w);
            k86.X(intent);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
