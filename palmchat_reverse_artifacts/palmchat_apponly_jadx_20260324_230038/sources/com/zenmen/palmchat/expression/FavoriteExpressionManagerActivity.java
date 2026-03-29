package com.zenmen.palmchat.expression;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.UI;
import defpackage.nt1;
import defpackage.ot1;
import defpackage.pm2;
import defpackage.pt1;
import defpackage.qt1;
import defpackage.sd3;
import defpackage.sy5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FavoriteExpressionManagerActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public TextView q;
    public GridView r;
    public nt1 s;
    public View t;
    public TextView u;
    public TextView v;
    public ArrayList<ExpressionObject> w = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FavoriteExpressionManagerActivity.this.s.e()) {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME109", "1", null, null);
            } else {
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME108", "1", null, null);
            }
            FavoriteExpressionManagerActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExpressionObject expressionObject = (ExpressionObject) adapterView.getItemAtPosition(i);
            if (FavoriteExpressionManagerActivity.this.s.e()) {
                expressionObject.isSelect = !expressionObject.isSelect;
                FavoriteExpressionManagerActivity.this.s.notifyDataSetChanged();
                FavoriteExpressionManagerActivity.this.H1();
            } else if ("add".equals(expressionObject.tag)) {
                Intent intent = new Intent(FavoriteExpressionManagerActivity.this, (Class<?>) MediaPickActivity.class);
                intent.putExtra("select_mode_key", 2);
                FavoriteExpressionManagerActivity.this.startActivityForResult(intent, 1);
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME107", "1", null, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ArrayList<ExpressionObject> arrayListC = FavoriteExpressionManagerActivity.this.s.c();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < arrayListC.size(); i++) {
                    arrayList.add(String.valueOf(arrayListC.get(i)._id));
                }
                ot1.a(arrayList);
                FavoriteExpressionManagerActivity.this.G1();
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sd3 sd3Var = new sd3(FavoriteExpressionManagerActivity.this);
            sd3Var.j(R.string.string_confirm_delete_expression).O(R.string.string_delete).K(R.string.dialog_cancel).f(new a());
            sd3Var.e().show();
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

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.title_favorite_expression);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.q = textView;
        textView.setText(R.string.string_edit);
        this.q.setOnClickListener(new a());
    }

    public final void E1() {
        this.r = (GridView) findViewById(R.id.media_grid_view);
        nt1 nt1Var = new nt1(this);
        this.s = nt1Var;
        this.r.setAdapter((ListAdapter) nt1Var);
        this.r.setOnItemClickListener(new b());
        this.t = findViewById(R.id.bottom_layout);
        this.u = (TextView) findViewById(R.id.count_tv);
        TextView textView = (TextView) findViewById(R.id.delete_btn);
        this.v = textView;
        textView.setOnClickListener(new c());
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            ArrayList<ExpressionObject> arrayListB = pt1.b(cursor);
            this.w = arrayListB;
            this.s.f(arrayListB);
        }
    }

    public final void G1() {
        this.s.g(!r0.e());
        if (!this.s.e()) {
            this.q.setText(R.string.string_edit);
            this.t.setVisibility(8);
        } else {
            this.q.setText(R.string.action_sheet_cancel);
            this.u.setText(getString(R.string.total_count, Integer.valueOf(this.s.getCount())));
            this.t.setVisibility(0);
            H1();
        }
    }

    public final void H1() {
        int iB = this.s.b();
        this.v.setText(iB == 0 ? getString(R.string.string_delete) : getString(R.string.string_delete_count, Integer.valueOf(iB)));
        this.v.setEnabled(iB > 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            int intExtra = intent.getIntExtra("result", -1);
            if (intExtra == 1) {
                sd3 sd3Var = new sd3(this);
                sd3Var.T(R.string.update_install_dialog_title).j(R.string.string_gif_too_large).O(R.string.alert_dialog_ok).f(new d());
                sd3Var.e().show();
            } else if (intExtra == 0) {
                sy5.e(this, R.string.string_save_complete, 0).g();
                UI.a(this);
            } else {
                sy5.e(this, R.string.string_add_expression_fail, 0).g();
                UI.a(this);
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_favorite_expression_manager);
        D1();
        E1();
        UI.c(this, 1, null, this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, qt1.f20317a, null, null, null, "_id ASC");
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        this.s.notifyDataSetChanged();
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
        pt1.d(this.w);
        this.s.f(this.w);
    }
}
