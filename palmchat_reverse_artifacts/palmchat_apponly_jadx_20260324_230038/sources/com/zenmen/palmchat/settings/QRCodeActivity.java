package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.gr2;
import defpackage.il5;
import defpackage.is0;
import defpackage.je1;
import defpackage.me1;
import defpackage.n43;
import defpackage.pu1;
import defpackage.sy5;
import defpackage.wm3;
import defpackage.xt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class QRCodeActivity extends BaseActionBarActivity {
    public static final String z = "QRCodeActivity";
    public String q;
    public String r;
    public Toolbar s;
    public ImageView t;
    public EffectiveShapeView u;
    public RelativeLayout v;
    public String[] w = {AppContext.getContext().getResources().getString(R.string.save_to_phone), AppContext.getContext().getResources().getString(R.string.menu_scan_qrcode)};
    public int[] x = null;
    public is0.f y = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements is0.f {
        public a() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                if (i == 1 && !com.zenmen.palmchat.videocall.c.f()) {
                    QRCodeActivity.this.startActivity(new Intent(AppContext.getContext(), (Class<?>) ScannerActivity.class));
                    return;
                }
                return;
            }
            QRCodeActivity.this.v.setDrawingCacheEnabled(true);
            Bitmap drawingCache = QRCodeActivity.this.v.getDrawingCache();
            if (drawingCache != null) {
                QRCodeActivity.this.B1(drawingCache);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Bitmap, Void, String> {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Bitmap... bitmapArr) {
            return xt.x(bitmapArr[0], System.currentTimeMillis() + "");
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            wm3.a(str);
            QRCodeActivity qRCodeActivity = QRCodeActivity.this;
            sy5.f(qRCodeActivity, qRCodeActivity.getResources().getString(R.string.save_to_dir, pu1.m()), 1).g();
        }
    }

    public void B1(Bitmap bitmap) {
        if (bitmap != null) {
            new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bitmap);
        }
    }

    public final void C1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.title_qrcode_activity);
        this.s = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void D1() {
        ContactInfoItem contactInfoItemL;
        this.q = getIntent().getStringExtra("from");
        this.r = getIntent().getStringExtra("code");
        this.t = (ImageView) findViewById(R.id.qrcode_image);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.qrcode_logo);
        this.u = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.u.setDegreeForRoundRectangle(13, 13);
        this.u.setBorderWidth(me1.a(this, 3.0f));
        this.u.setBorderColor(-1);
        this.v = (RelativeLayout) findViewById(R.id.qrcode_combine);
        new n43(this.t, this.u, z, this.r).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        TextView textView = (TextView) findViewById(R.id.nickname_textview);
        TextView textView2 = (TextView) findViewById(R.id.uid_textview);
        SocialPortraitView socialPortraitView = (SocialPortraitView) findViewById(R.id.portrait);
        socialPortraitView.changeShapeType(1);
        ImageView imageView = (ImageView) findViewById(R.id.img_gender);
        String strP = AccountUtils.p(AppContext.getContext());
        je1 je1VarR = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        if (TextUtils.isEmpty(strP) || (contactInfoItemL = bo0.r().l(strP)) == null) {
            return;
        }
        textView.setText(contactInfoItemL.getNickName());
        if (contactInfoItemL.getGender() == 0) {
            imageView.setImageResource(R.drawable.nearby_gender_male);
        } else if (contactInfoItemL.getGender() == 1) {
            imageView.setImageResource(R.drawable.nearby_gender_female);
        } else {
            imageView.setVisibility(8);
        }
        textView2.setText(il5.i(AppContext.getContext(), contactInfoItemL.getCountry(), contactInfoItemL.getProvince(), contactInfoItemL.getCity()));
        if (TextUtils.isEmpty(contactInfoItemL.getIconURL())) {
            return;
        }
        gr2.j().h(contactInfoItemL.getIconURL(), socialPortraitView, je1VarR);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_qrcode);
        C1();
        D1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        String str = this.q;
        if (str == null || !str.equals("scanner")) {
            showPopupMenu(this, this.s, this.w, this.x, this.y, null);
            return true;
        }
        showPopupMenu(this, this.s, new String[]{AppContext.getContext().getResources().getString(R.string.save_to_phone)}, null, this.y, null);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_more) {
            String str = this.q;
            if (str == null || !str.equals("scanner")) {
                showPopupMenu(this, this.s, this.w, this.x, this.y, null);
            } else {
                showPopupMenu(this, this.s, new String[]{AppContext.getContext().getResources().getString(R.string.save_to_phone)}, null, this.y, null);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
