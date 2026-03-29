package com.zenmen.palmchat.media.file;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.toolbox.Volley;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.dt0;
import defpackage.ed5;
import defpackage.ho3;
import defpackage.hx3;
import defpackage.il2;
import defpackage.o86;
import defpackage.of1;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.uk5;
import defpackage.zs0;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FileDetailActivity extends BaseActionBarActivity implements il2 {
    public static final String P = "FileDetailActivity";
    public View A;
    public int B;
    public String C;
    public String E;
    public String F;
    public File G;
    public int H = 0;
    public boolean I = false;
    public ed5 J = null;
    public int K = 0;
    public final int L = 1;
    public final int M = 2;
    public boolean N = false;
    public String O;
    public MessageVo q;
    public TextView r;
    public TextView s;
    public ProgressBar t;
    public TextView u;
    public View v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f14648a;

        public a(File file) {
            this.f14648a = file;
            put("action", "msg_file_download");
            put("status", "success");
            put("type", String.valueOf(6));
            put("mid", FileDetailActivity.this.O);
            put("md5", FileDetailActivity.this.q.data5);
            put("fileSize", Long.valueOf(file.length()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FileDetailActivity.this.T1();
            AppContext context = AppContext.getContext();
            FileDetailActivity fileDetailActivity = FileDetailActivity.this;
            sy5.f(context, fileDetailActivity.getString(R.string.file_detail_downloaded, fileDetailActivity.C), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14650a;
        public final /* synthetic */ File b;

        public c(String str, File file) {
            this.f14650a = str;
            this.b = file;
            put("action", "msg_file_download");
            put("status", "fail");
            put("type", String.valueOf(6));
            put("mid", FileDetailActivity.this.O);
            put("md5", str);
            put("fileSize", Long.valueOf(file != null ? file.length() : 0L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FileDetailActivity.this.a2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "msg_file_download");
            put("status", "fail");
            put("type", String.valueOf(6));
            put("mid", FileDetailActivity.this.O);
            put("md5", FileDetailActivity.this.q.data5);
            put("fileSize", Integer.valueOf(FileDetailActivity.this.B));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14653a;

        public f(int i) {
            this.f14653a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zs0.a(this.f14653a)) {
                sy5.e(AppContext.getContext(), R.string.network_exception_title, 0).g();
            } else {
                FileDetailActivity.this.findViewById(R.id.no_file).setVisibility(0);
                FileDetailActivity.this.findViewById(R.id.file_detail).setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FileDetailActivity.this.K != 2) {
                FileDetailActivity.this.K = 2;
            } else {
                sy5.e(FileDetailActivity.this, R.string.click_stop, 0).g();
            }
            FileDetailActivity.this.c2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FileDetailActivity.this.K != 1) {
                FileDetailActivity.this.K = 1;
            } else {
                sy5.e(FileDetailActivity.this, R.string.click_start, 0).g();
            }
            FileDetailActivity.this.b2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FileDetailActivity fileDetailActivity = FileDetailActivity.this;
            if (o86.l(fileDetailActivity, fileDetailActivity.C)) {
                return;
            }
            new sd3(FileDetailActivity.this).T(R.string.open_file_title).j(R.string.open_file_failed).O(R.string.dialog_confirm).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends MaterialDialog.e {
        public j() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            com.zenmen.palmchat.database.b.R(FileDetailActivity.this.q, "");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            FileDetailActivity.this.H = 0;
            FileDetailActivity.this.t.setProgress(0);
            FileDetailActivity.this.T1();
            File file = new File(FileDetailActivity.this.V1() + File.separator + FileDetailActivity.this.F);
            if (file.exists()) {
                file.delete();
            }
            FileDetailActivity.this.b2();
            FileDetailActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f14659a;

        public k(uk5 uk5Var) {
            this.f14659a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14659a.f21235a != 2) {
                return;
            }
            int iY = ch.s().y();
            LogUtil.d(FileDetailActivity.P, "network status changed:" + iY);
            if (iY == 1 && !FileDetailActivity.this.I && FileDetailActivity.this.H == 0) {
                FileDetailActivity.this.b2();
                LogUtil.d(FileDetailActivity.P, "network status changed: start download");
            } else if (iY == 0 && !FileDetailActivity.this.I && FileDetailActivity.this.H == 0) {
                FileDetailActivity.this.c2();
                LogUtil.d(FileDetailActivity.P, "network status changed: stop download");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14660a;

        public l(int i) {
            this.f14660a = i;
            put("action", "msg_file_download");
            put("status", "start");
            put("type", String.valueOf(6));
            put("mid", FileDetailActivity.this.O);
            put("md5", FileDetailActivity.this.q.data5);
            put("fileSize", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FileDetailActivity.this.I = false;
            FileDetailActivity.this.T1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14662a;

        public n(int i) {
            this.f14662a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileDetailActivity.this.e2(this.f14662a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FileDetailActivity.this.I = true;
            FileDetailActivity.this.T1();
            sy5.e(AppContext.getContext(), R.string.file_detail_download_pause, 0).g();
        }
    }

    public final void T1() {
        int i2 = this.H;
        if (i2 == -1) {
            findViewById(R.id.no_file).setVisibility(0);
            findViewById(R.id.file_detail).setVisibility(8);
            return;
        }
        if (i2 != 0) {
            this.y.setVisibility(8);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            return;
        }
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        if (this.I) {
            this.t.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(0);
            this.K = 2;
            return;
        }
        this.t.setVisibility(0);
        this.v.setVisibility(0);
        this.u.setVisibility(0);
        this.w.setVisibility(8);
        this.K = 1;
    }

    public final void U1(MessageVo messageVo) {
        Intent intent = new Intent();
        intent.setClass(this, SendMessageActivity.class);
        intent.putExtra("message_vo", messageVo);
        startActivity(intent);
    }

    public final String V1() {
        if (this.N) {
            return pu1.h;
        }
        String str = pu1.h + File.separator + rb3.c(this.E);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
        return str;
    }

    public final void W1() {
        this.J = new of1(new WeakReference(this), this.q, this.B);
    }

    public final void X1() {
        this.r = (TextView) findViewById(R.id.file_name);
        this.s = (TextView) findViewById(R.id.thumb_text);
        int iH = o86.h(this.F);
        this.s.setBackgroundResource(iH);
        if (iH == R.drawable.file_blue_rectangle) {
            String upperCase = o86.e(this.F).toUpperCase();
            this.s.setText(upperCase);
            if (upperCase.length() > 3) {
                this.s.setText(upperCase.substring(0, 3) + "...");
                this.s.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.ext_deatil_smail_text_size));
            } else {
                this.s.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ext_deatil_big_text_size));
            }
        } else {
            this.s.setText("");
        }
        this.t = (ProgressBar) findViewById(R.id.progress_bar);
        this.u = (TextView) findViewById(R.id.download_progress_message);
        this.v = findViewById(R.id.btn_stop);
        this.w = (TextView) findViewById(R.id.btn_continue);
        this.x = (TextView) findViewById(R.id.btn_open_file);
        this.y = findViewById(R.id.download_file_area);
        this.z = findViewById(R.id.open_file_area);
        this.A = findViewById(R.id.not_open_tips);
        this.r.setText(this.F);
        Z1();
        if (this.H == 0) {
            if (o86.k(V1() + File.separator + this.F)) {
                e2(this.q.sendingProgress);
            } else {
                e2(0);
            }
        }
        this.v.setOnClickListener(new g());
        this.w.setOnClickListener(new h());
        this.x.setOnClickListener(new i());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Y1() {
        boolean z = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, this.q.contactRelate), null, "packet_id=?", new String[]{this.q.mid}, null);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("msg_sending_progress"));
                if (this.q.isSend) {
                    z = true;
                } else if (i2 >= cursorQuery.getInt(cursorQuery.getColumnIndex("data4"))) {
                }
                return z;
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final void Z1() {
        String str = this.E;
        if (str == null || str.equals("")) {
            return;
        }
        int iLastIndexOf = this.E.lastIndexOf("mid=") + 4;
        int i2 = iLastIndexOf + 64;
        String strA = this.E.length() < i2 ? o86.a(this.E) : o86.a(this.E.substring(iLastIndexOf, i2));
        if (!o86.e(this.F).equals(Constants.STRING_VALUE_UNSET)) {
            strA = strA + "." + o86.e(this.F);
        }
        if (new File(pu1.h + File.separator + strA).exists()) {
            this.F = strA;
            this.N = true;
        } else if (o86.e(this.F).equals(Constants.STRING_VALUE_UNSET)) {
            this.F = this.F.replace(Constants.STRING_VALUE_UNSET, "_");
        }
    }

    public final void a2() {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.file_detail_downloaded_md5_error).O(R.string.dialog_confirm).K(R.string.ignore_add_contact_request).h(false).f(new j()).e().show();
    }

    public final void b2() {
        String strV1 = V1();
        File file = new File(strV1);
        if (!file.exists()) {
            file.mkdir();
        }
        if (!dt0.l(AppContext.getContext(), Volley.getUserAgent()).m(this.E)) {
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).f(this.E, strV1, this.F, this.J, true);
        } else {
            onStart(this.F, this.E, this.B);
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).o(this.E, this.J);
        }
    }

    public final void c2() {
        dt0.l(AppContext.getContext(), Volley.getUserAgent()).h(this.E);
    }

    public final void d2(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", Integer.valueOf(i2));
        getContentResolver().update(DBUriManager.c(ho3.class, this.q.contactRelate), contentValues, "data2=?", new String[]{this.q.data2});
    }

    public final void e2(int i2) {
        this.t.setProgress((int) ((i2 * 100.0f) / this.B));
        this.u.setText(String.format(getString(R.string.file_detail_download_progress_message), o86.c(i2) + "/" + o86.c(this.B)));
    }

    public final void initActionBar() {
        initToolbar(R.string.file_detail_activity_title);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        File file;
        super.onCreate(bundle);
        this.O = UUID.randomUUID().toString();
        MessageVo messageVo = (MessageVo) getIntent().getParcelableExtra("message_key");
        this.q = messageVo;
        if (messageVo == null) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(messageVo.data4)) {
            this.B = 0;
        } else {
            this.B = Integer.parseInt(this.q.data4);
        }
        String str = this.q.data1;
        this.C = str;
        if (!TextUtils.isEmpty(str)) {
            this.G = new File(this.C);
        }
        File file2 = this.G;
        if (file2 == null || !file2.exists()) {
            this.H = 0;
        } else {
            if (!TextUtils.isEmpty(this.q.data5) && !this.q.data5.equals(rb3.b(this.G)) && !this.q.data5.equals(com.igexin.push.core.b.m) && this.q.attachStatus != 2) {
                d2(0);
                a2();
            }
            this.H = 1;
        }
        if (!o86.i(this.q) || this.q.attachStatus == 5) {
            this.H = -1;
        }
        MessageVo messageVo2 = this.q;
        if (messageVo2.attachStatus == 3) {
            this.I = true;
        }
        this.E = messageVo2.data2;
        if (!TextUtils.isEmpty(messageVo2.data3) || (file = this.G) == null) {
            this.F = this.q.data3;
        } else {
            this.F = file.getName();
        }
        setContentView(R.layout.layout_activity_file_detail);
        initActionBar();
        X1();
        T1();
        W1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file_detail, menu);
        return true;
    }

    @Override // defpackage.il2
    public void onError(int i2, String str) {
        LogUtil.i(P, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(), (Throwable) null);
        runOnUiThread(new f(i2));
    }

    @Override // defpackage.il2
    public void onFinish(File file) throws Throwable {
        if (file != null && file.exists()) {
            LogUtil.i(P, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(file), (Throwable) null);
            this.H = 1;
            this.C = file.getAbsolutePath();
            runOnUiThread(new b());
        }
        String strB = rb3.b(file);
        if (TextUtils.isEmpty(this.q.data5) || this.q.data5.equals(strB) || this.q.data5.equals(com.igexin.push.core.b.m)) {
            return;
        }
        LogUtil.i(P, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(strB, file), (Throwable) null);
        this.t.setProgress(0);
        runOnUiThread(new d());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_forward) {
            U1(this.q);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (Y1()) {
            menu.findItem(R.id.menu_forward).setVisible(true);
        } else {
            menu.findItem(R.id.menu_forward).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // defpackage.il2
    public void onProgress(int i2) {
        runOnUiThread(new n(i2));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.H == 0) {
            if (!this.I) {
                if (hx3.n()) {
                    this.I = false;
                } else {
                    this.I = true;
                }
            }
            T1();
            if (this.I) {
                return;
            }
            b2();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ch.s().r().j(this);
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        runOnUiThread(new k(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ch.s().r().l(this);
    }

    @Override // defpackage.il2
    public void onStart(String str, String str2, int i2) {
        LogUtil.i(P, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new l(i2), (Throwable) null);
        runOnUiThread(new m());
    }

    @Override // defpackage.il2
    public void onStop(int i2) {
        runOnUiThread(new o());
    }

    @Override // defpackage.il2
    public void onPrepare() {
    }
}
