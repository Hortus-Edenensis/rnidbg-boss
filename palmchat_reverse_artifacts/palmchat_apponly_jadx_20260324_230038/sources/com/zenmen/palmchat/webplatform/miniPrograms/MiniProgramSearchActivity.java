package com.zenmen.palmchat.webplatform.miniPrograms;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.R$id;
import com.zenmen.palmchat.webplatform.R$layout;
import com.zenmen.palmchat.webplatform.R$string;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.miniPrograms.a;
import defpackage.hq3;
import defpackage.pp3;
import defpackage.sd3;
import defpackage.v4;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MiniProgramSearchActivity extends FrameworkBaseActivity {
    public static String A = "extra_search_packages";
    public Toolbar q;
    public EditText r;
    public ListView s;
    public com.zenmen.palmchat.webplatform.miniPrograms.a t;
    public ArrayList<Package> u;
    public ArrayList<Package> v;
    public Cursor w;
    public String x;
    public LoaderManager.LoaderCallbacks<Cursor> y = new c();
    public View.OnClickListener z = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((i != 3 && i != 0) || keyEvent == null) {
                return false;
            }
            MiniProgramSearchActivity.this.onSearchClick(null);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements LoaderManager.LoaderCallbacks<Cursor> {
        public c() {
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            LogUtil.i("MiniProgramSearchActivity", "onLoadFinished");
            if (loader.getId() != 2 || cursor == null) {
                return;
            }
            MiniProgramSearchActivity.this.F1(cursor);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            if (i != 2) {
                return null;
            }
            return new CursorLoader(MiniProgramSearchActivity.this, hq3.f18029a, null, "uid=?", new String[]{v4.e(MiniProgramSearchActivity.this)}, null);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> loader) {
            LogUtil.i("MiniProgramSearchActivity", "onLoaderReset");
            if (MiniProgramSearchActivity.this.w != null) {
                MiniProgramSearchActivity.this.w.close();
                MiniProgramSearchActivity.this.w = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.b bVar = (a.b) view.getTag();
            if (bVar != null) {
                Package r6 = (Package) MiniProgramSearchActivity.this.v.get(bVar.e);
                Intent intent = new Intent();
                intent.setClass(MiniProgramSearchActivity.this, WebModuleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("extra_type", 1);
                bundle.putInt("extra_from", 3);
                bundle.putBoolean("web_show_share", true);
                bundle.putSerializable("extra_package", r6);
                intent.putExtras(bundle);
                MiniProgramSearchActivity.this.startActivityForResult(intent, 0);
            }
        }
    }

    public final void F1(Cursor cursor) {
        Cursor cursor2 = this.w;
        if (cursor2 != null) {
            cursor2.close();
        }
        this.w = cursor;
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("web_name");
            int columnIndex2 = cursor.getColumnIndex("web_id");
            int columnIndex3 = cursor.getColumnIndex("version");
            int columnIndex4 = cursor.getColumnIndex("icon");
            int columnIndex5 = cursor.getColumnIndex("description");
            this.u.clear();
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
                this.u.add(r10);
            }
            ArrayList<Package> arrayList = this.u;
            if (arrayList == null || arrayList.size() == 0) {
                J1();
            } else {
                for (Package r0 : this.u) {
                    if (r0.name.contains(this.x)) {
                        this.v.add(r0);
                    }
                }
                if (this.v.size() != 0) {
                    this.t.b(this.v);
                } else {
                    J1();
                }
            }
        }
        LogUtil.i("MiniProgramSearchActivity", "initPackageList mPackages size = " + this.u.size());
    }

    public final void G1() {
        Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, (String) null, true);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        EditText editText = (EditText) findViewById(R$id.search_miniprogram);
        this.r = editText;
        editText.addTextChangedListener(new a());
        this.r.setEnabled(true);
        this.r.requestFocus();
        this.r.setHint(getResources().getString(R$string.string_search_miniprogram));
        this.r.setOnEditorActionListener(new b());
    }

    public final void H1() {
        this.v = new ArrayList<>();
        this.s = (ListView) findViewById(R$id.mini_program_search_listview);
        com.zenmen.palmchat.webplatform.miniPrograms.a aVar = new com.zenmen.palmchat.webplatform.miniPrograms.a(this, this.z);
        this.t = aVar;
        this.s.setAdapter((ListAdapter) aVar);
    }

    public final void I1() {
        this.v.clear();
        ArrayList<Package> arrayList = this.u;
        if (arrayList == null || arrayList.size() == 0) {
            J1();
            return;
        }
        for (Package r1 : this.u) {
            if (r1.name.contains(this.x)) {
                this.v.add(r1);
            }
        }
        if (this.v.size() != 0) {
            this.t.b(this.v);
        } else {
            J1();
        }
    }

    public final void J1() {
        new sd3(this).T(R$string.update_install_dialog_title).j(R$string.dialog_content_search_mini).O(R$string.dialog_confirm).f(new d()).e().show();
    }

    public final void K1() {
        LogUtil.i("MiniProgramSearchActivity", "updateMiniProgram");
        if (TextUtils.isEmpty(this.r.getText().toString())) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
            this.t.b(new ArrayList());
        }
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
        setContentView(R$layout.layout_activity_search);
        this.u = new ArrayList<>();
        this.u = (ArrayList) getIntent().getSerializableExtra(A);
        G1();
        H1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(2);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onSearchClick(View view) {
        String string = this.r.getText().toString();
        this.x = string;
        if (TextUtils.isEmpty(string.trim())) {
            J1();
        } else {
            I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MiniProgramSearchActivity.this.K1();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
