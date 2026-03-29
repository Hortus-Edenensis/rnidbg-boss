package com.zenmen.palmchat.route.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.huawei.openalliance.ad.constant.bi;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.publish.PublishActivity;
import com.zenmen.palmchat.route.share.a;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import defpackage.bq6;
import defpackage.ds0;
import defpackage.fi0;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.vt0;
import defpackage.w56;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExternalShareActivity extends BaseActionBarActivity {
    public static String G = "from";
    public static String H = "image_path";
    public static int I = 104857600;
    public NineGridView A;
    public byte B;
    public AsyncTask C;
    public int E = 0;
    public ShareLinkBean F;
    public Toolbar q;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public View v;
    public ImageView w;
    public TextView x;
    public TextView y;
    public View z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15085a;

        public a(ArrayList arrayList) {
            this.f15085a = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = ExternalShareActivity.this.getIntent();
            intent.putExtra("key_from", 4);
            intent.putExtra("key_publish_type", 2);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f15085a.size() && i <= 8; i++) {
                MediaItem mediaItem = new MediaItem();
                mediaItem.fileFullPath = w56.d(ExternalShareActivity.this, (Uri) this.f15085a.get(i));
                arrayList.add(mediaItem);
            }
            intent.putExtra("key_publish_pictures", arrayList);
            intent.setClass(ExternalShareActivity.this, PublishActivity.class);
            ExternalShareActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fi0 f15086a;

        public b(fi0 fi0Var) {
            this.f15086a = fi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15086a.a() == 1) {
                ExternalShareActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<Intent, Void, Void> {
        public c() {
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            super.o();
            ExternalShareActivity.this.showBaseProgressBar();
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Void g(Intent... intentArr) {
            Intent intent = intentArr[0];
            ExternalShareActivity.this.B = com.zenmen.palmchat.route.share.a.j(intent);
            ExternalShareActivity.this.J1();
            return null;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Void r1) {
            ExternalShareActivity.this.hideBaseProgressBar();
            ExternalShareActivity.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15087a;

        public d(String str) {
            this.f15087a = str;
            put("action", "share");
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = ExternalShareActivity.this.getIntent();
            intent.setClass(ExternalShareActivity.this, SendMessageActivity.class);
            intent.putExtra("extra_from", 2);
            ExternalShareActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements a.e {
        public f() {
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void a(ShareLinkBean shareLinkBean) {
            ExternalShareActivity.this.hideBaseProgressBar();
            gr2.j().h(shareLinkBean.getIcon(), ExternalShareActivity.this.w, bq6.l());
            ExternalShareActivity.this.x.setText(shareLinkBean.getTitle());
            ExternalShareActivity.this.y.setText(shareLinkBean.getUrl());
            ExternalShareActivity.this.F = shareLinkBean;
        }

        @Override // com.zenmen.palmchat.route.share.a.e
        public void onStart() {
            ExternalShareActivity.this.showBaseProgressBar(R.string.loading, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(ExternalShareActivity.this.getIntent());
                intent.setClass(ExternalShareActivity.this, SendMessageActivity.class);
                intent.putExtra("extra_from", 2);
                ExternalShareActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExternalShareActivity.this.F == null) {
                return;
            }
            Intent intent = ExternalShareActivity.this.getIntent();
            intent.putExtra("key_from", 4);
            intent.putExtra("key_publish_type", 4);
            intent.putExtra("key_publish_subject", ExternalShareActivity.this.x.getText().toString());
            intent.putExtra("key_publish_url", ExternalShareActivity.this.y.getText().toString());
            intent.putExtra("key_publish_shortcut_icon", ExternalShareActivity.this.F.getIcon());
            intent.setClass(ExternalShareActivity.this, PublishActivity.class);
            ExternalShareActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = ExternalShareActivity.this.getIntent();
            intent.setClass(ExternalShareActivity.this, SendMessageActivity.class);
            intent.putExtra("extra_from", 2);
            ExternalShareActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            Intent intent = new Intent();
            intent.setClass(context, ExternalShareActivity.class);
            if (aVar != null) {
                Bundle bundleA = aVar.a();
                String string = bundleA.getString(ExternalShareActivity.G);
                String string2 = bundleA.getString(ExternalShareActivity.H);
                intent.putExtra(ExternalShareActivity.G, string);
                intent.putExtra(ExternalShareActivity.H, string2);
            }
            return intent;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    public static File I1(Uri uri) {
        FileOutputStream fileOutputStream;
        try {
            ?? C = rb3.c(uri.toString());
            String str = pu1.u;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                File file2 = new File(str, (String) C);
                try {
                    uri = AppContext.getContext().getContentResolver().openInputStream(uri);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (uri.read(bArr) != -1) {
                                fileOutputStream.write(bArr);
                            }
                            fileOutputStream.flush();
                            try {
                                uri.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return file2;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            if (uri != 0) {
                                try {
                                    uri.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            return null;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        C = 0;
                        th = th;
                        if (uri != 0) {
                            try {
                                uri.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (C == 0) {
                            throw th;
                        }
                        try {
                            C.close();
                            throw th;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    uri = 0;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    C = 0;
                    th = th2;
                    uri = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void J1() {
        byte b2 = this.B;
        if (b2 == 5 || b2 == 3) {
            File fileI1 = I1((Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM"));
            if (fileI1 != null) {
                getIntent().putExtra("android.intent.extra.STREAM", Uri.fromFile(fileI1));
                return;
            }
            return;
        }
        if (b2 == 6 || b2 == 4) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                File fileI12 = I1((Uri) it.next());
                if (fileI12 != null) {
                    arrayList.add(Uri.fromFile(fileI12));
                }
            }
            if (arrayList.size() > 0) {
                getIntent().putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            }
        }
    }

    public final void K1() {
        this.z.setVisibility(0);
        Uri uri = (Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            String strD = w56.d(this, uri);
            if (pu1.g(strD) == 1) {
                I = rl0.h().e().f();
                if (new File(strD).length() > I) {
                    this.E = 2;
                } else {
                    this.E = 0;
                }
            } else {
                this.E = 0;
            }
        } else {
            this.E = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
        }
        if (this.E != 3) {
            this.A.display(uri);
            L1(uri);
        }
    }

    public final void L1(Uri uri) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        arrayList.add(uri);
        N1(arrayList);
    }

    public final void M1() {
        this.z.setVisibility(0);
        ArrayList<Uri> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (parcelableArrayListExtra != null) {
            for (Uri uri : parcelableArrayListExtra) {
                if (uri != null) {
                    String strD = w56.d(this, uri);
                    if (pu1.g(strD) == 1) {
                        I = rl0.h().e().f();
                        if (new File(strD).length() > I) {
                            this.E = 2;
                        } else {
                            this.E = 0;
                        }
                    } else {
                        this.E = 3;
                        sy5.e(this, R.string.share_failed_resource, 1).g();
                        finish();
                    }
                } else {
                    this.E = 3;
                    sy5.e(this, R.string.share_failed_resource, 1).g();
                    finish();
                }
            }
        } else {
            this.E = 3;
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
        }
        if (this.E != 3) {
            this.A.display(parcelableArrayListExtra);
            N1(parcelableArrayListExtra);
        }
    }

    public final void N1(ArrayList<Uri> arrayList) {
        this.r.setOnClickListener(new i());
        this.s.setOnClickListener(new a(arrayList));
    }

    public final void O1() {
        this.F = null;
        this.v.setVisibility(0);
        this.C = com.zenmen.palmchat.route.share.a.d(com.zenmen.palmchat.route.share.a.h(getIntent()), new f());
        this.r.setOnClickListener(new g());
        this.s.setOnClickListener(new h());
    }

    public final void P1(String str) {
        if (TextUtils.isEmpty(str)) {
            sy5.e(this, R.string.share_failed_resource, 1).g();
            finish();
        }
        this.u.setVisibility(0);
        this.u.setText(str);
        this.t.setVisibility(8);
        this.s.setVisibility(8);
        this.r.setOnClickListener(new e());
    }

    public final void Q1() {
        new c().h(getIntent());
    }

    public final void R1() {
        try {
            Intent intent = getIntent();
            byte b2 = this.B;
            if (b2 == 1) {
                P1(com.zenmen.palmchat.route.share.a.i(intent));
            } else if (b2 == 2) {
                O1();
            } else if (b2 == 3) {
                K1();
            } else if (b2 == 4) {
                M1();
            } else {
                if (!WebModuleActivity.G.equals(intent.getStringExtra(G))) {
                    intent.setClass(this, SendMessageActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                getIntent().putExtra("android.intent.extra.STREAM", Uri.parse("file://" + intent.getStringExtra(H)));
                getIntent().setAction("android.intent.action.SEND");
                getIntent().setType(bi.I);
                K1();
            }
            this.t.setVisibility(8);
            this.s.setVisibility(8);
            LogUtil.i(BaseActionBarActivity.TAG, 3, new d("{action:" + intent.getAction() + ", type:" + intent.getType() + ", shareType:" + ((int) this.B) + ", fileUri:" + ((Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) + "}"), (Throwable) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    public final void S1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.app_name);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void T1() {
        this.r = findViewById(R.id.item_send_friends);
        this.s = findViewById(R.id.item_send_moments);
        this.t = findViewById(R.id.view_divider);
        this.u = (TextView) findViewById(R.id.container_text);
        this.v = findViewById(R.id.container_link);
        this.w = (ImageView) findViewById(R.id.img_link_icon);
        this.x = (TextView) findViewById(R.id.tv_link_title);
        this.y = (TextView) findViewById(R.id.tv_link_url);
        this.z = findViewById(R.id.container_image);
        this.A = (NineGridView) findViewById(R.id.view_nine_grid);
    }

    @qm5
    public void onCommandEvent(fi0 fi0Var) {
        runOnUiThread(new b(fi0Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_external_share);
        S1();
        T1();
        Q1();
        ds0.a().c(this);
        vt0.d().h(6);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.C;
        if (asyncTask != null) {
            asyncTask.f(true);
        }
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Q1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
