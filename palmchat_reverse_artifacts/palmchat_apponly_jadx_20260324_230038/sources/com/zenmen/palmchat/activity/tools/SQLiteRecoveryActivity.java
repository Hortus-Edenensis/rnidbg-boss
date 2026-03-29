package com.zenmen.palmchat.activity.tools;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g13;
import defpackage.sd3;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SQLiteRecoveryActivity extends BaseActionBarActivity implements View.OnClickListener {
    public boolean q;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12392a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.tools.SQLiteRecoveryActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0963a implements Runnable {
            public RunnableC0963a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }

        public a(boolean z) {
            this.f12392a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f12392a) {
                new g13(new RunnableC0963a()).start();
                AppContext.getContext().exitApp();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SQLiteRecoveryActivity> f12394a;

        public b(SQLiteRecoveryActivity sQLiteRecoveryActivity) {
            this.f12394a = new WeakReference<>(sQLiteRecoveryActivity);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(!SqliteRecover.hasCorruptedDatabaseFile());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            SQLiteRecoveryActivity sQLiteRecoveryActivity = this.f12394a.get();
            if (sQLiteRecoveryActivity != null) {
                sQLiteRecoveryActivity.hideBaseProgressBar();
                if (!bool.booleanValue()) {
                    sQLiteRecoveryActivity.E1();
                    return;
                }
                HashMap map = new HashMap();
                map.put("type", 100);
                map.put("action", 0);
                map.put("from", 0);
                LogUtil.uploadInfoImmediate("chatpage-cli", map);
                sQLiteRecoveryActivity.F1(R.string.no_need_to_fix_database, false);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            SQLiteRecoveryActivity sQLiteRecoveryActivity = this.f12394a.get();
            if (sQLiteRecoveryActivity != null) {
                sQLiteRecoveryActivity.showBaseProgressBar(sQLiteRecoveryActivity.getString(R.string.checking_database), false, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SQLiteRecoveryActivity> f12395a;

        public c(SQLiteRecoveryActivity sQLiteRecoveryActivity) {
            this.f12395a = new WeakReference<>(sQLiteRecoveryActivity);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(SqliteRecover.recoverSocialDB());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            SQLiteRecoveryActivity sQLiteRecoveryActivity = this.f12395a.get();
            if (sQLiteRecoveryActivity != null) {
                sQLiteRecoveryActivity.hideBaseProgressBar();
                if (bool.booleanValue()) {
                    sQLiteRecoveryActivity.F1(R.string.fix_database_succeeded, true);
                    SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(sQLiteRecoveryActivity).edit();
                    editorEdit.putBoolean(SqliteRecover.CHECK_DATABASE, true);
                    editorEdit.apply();
                } else {
                    sQLiteRecoveryActivity.F1(R.string.fix_database_failed, true);
                }
                HashMap map = new HashMap();
                map.put("type", Integer.valueOf(!bool.booleanValue() ? 1 : 0));
                map.put("action", 0);
                map.put("from", Integer.valueOf(sQLiteRecoveryActivity.q ? 1 : 0));
                LogUtil.uploadInfoImmediate("chatpage-cli", map);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            SQLiteRecoveryActivity sQLiteRecoveryActivity = this.f12395a.get();
            if (sQLiteRecoveryActivity != null) {
                sQLiteRecoveryActivity.showBaseProgressBar(sQLiteRecoveryActivity.getString(R.string.fixing_database), false, false);
            }
        }
    }

    public final void D1() {
        new b(this).execute(new Void[0]);
    }

    public final void E1() {
        new c(this).execute(new Void[0]);
    }

    public final void F1(int i, boolean z) {
        new sd3(this).j(i).O(R.string.alert_dialog_ok).f(new a(z)).h(false).e().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        D1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_database_recovery);
        setSupportActionBar(initToolbar(-1));
        boolean booleanExtra = getIntent().getBooleanExtra("check_database_now", false);
        this.q = booleanExtra;
        if (booleanExtra) {
            findViewById(R.id.btn_fix).setVisibility(8);
            D1();
        } else {
            findViewById(R.id.btn_fix).setOnClickListener(this);
        }
        LogUtil.uploadInfoImmediate("chatpage-show", null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
