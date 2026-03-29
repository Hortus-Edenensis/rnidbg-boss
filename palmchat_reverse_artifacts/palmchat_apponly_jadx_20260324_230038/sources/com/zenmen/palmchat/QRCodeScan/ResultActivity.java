package com.zenmen.palmchat.QRCodeScan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bpea.entry.common.DataType;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.urlspan.MyUrlSpan;
import defpackage.h13;
import defpackage.mu4;
import defpackage.sy5;
import defpackage.td3;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ResultActivity extends BaseActionBarActivity implements MyUrlSpan.a {
    public ImageView q;
    public TextView r;
    public TextView s;
    public int t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f12116a;
        public final /* synthetic */ String b;

        public a(Uri uri, String str) {
            this.f12116a = uri;
            this.b = str;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                Intent intent = new Intent("android.intent.action.VIEW", this.f12116a);
                intent.putExtra("com.android.browser.application_id", ResultActivity.this.getPackageName());
                ResultActivity.this.startActivity(intent);
            } else if (i == 1) {
                ResultActivity.this.B1(this.b);
            } else if (i == 2) {
                ((ClipboardManager) ResultActivity.this.getSystemService(DataType.CLIPBOARD)).setText(this.b);
                sy5.e(ResultActivity.this, R.string.copy_success, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12117a;

        public b(String str) {
            this.f12117a = str;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i != 0) {
                Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
                intent.setType("vnd.android.cursor.item/person");
                intent.putExtra("phone", this.f12117a);
                intent.putExtra("phone_type", 2);
                ResultActivity.this.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.INSERT");
            intent2.setType("vnd.android.cursor.dir/person");
            intent2.setType("vnd.android.cursor.dir/contact");
            intent2.setType("vnd.android.cursor.dir/raw_contact");
            intent2.putExtra("phone", this.f12117a);
            ResultActivity.this.startActivity(intent2);
        }
    }

    public final void B1(String str) {
        new td3.c(this).c(new String[]{getString(R.string.chat_item_menu_create_contact), getString(R.string.chat_item_menu_edit_contact)}).d(new b(str)).a().b();
    }

    @Override // com.zenmen.palmchat.utils.urlspan.MyUrlSpan.a
    public void F(int i, String str, Uri uri, View view) {
        LogUtil.i(BaseActionBarActivity.TAG, "onUrlClicked type =" + i + " text =" + str + " uri =" + uri);
        if (i == 4) {
            new td3.c(this).c(new String[]{getString(R.string.chat_item_menu_dial), getString(R.string.chat_item_menu_save), getString(R.string.chat_item_menu_copy)}).d(new a(uri, str.replace("tel:", ""))).a().b();
            return;
        }
        if (i != 1) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                intent.setFlags(268435456);
                intent.putExtra("com.android.browser.application_id", getPackageName());
                startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Intent intent2 = new Intent();
        intent2.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", mu4.b(str, new Map[0]));
        bundle.putString("web_url_origin", str);
        bundle.putInt("from_source", h13.o);
        bundle.putInt("BackgroundColor", -1);
        intent2.putExtras(bundle);
        startActivity(intent2);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_scan_result);
        initToolbar(" ");
        Bundle extras = getIntent().getExtras();
        this.q = (ImageView) findViewById(R.id.result_image);
        this.r = (TextView) findViewById(R.id.result_text);
        this.s = (TextView) findViewById(R.id.result_tip);
        if (extras != null) {
            int i = extras.getInt("mode", 0);
            this.t = i;
            if (i == 1) {
                this.r.setText(R.string.no_qrcode_in_image);
                this.s.setVisibility(8);
            } else if (i == 2) {
                this.r.setText("连信暂不支持展示二维码中的文本内容");
                this.s.setVisibility(8);
            } else {
                this.r.setText(extras.getString("result"));
                com.zenmen.palmchat.utils.urlspan.a.c(this.r, 15, this, false);
                byte[] byteArray = extras.getByteArray("barcode_bitmap");
                this.q.setImageBitmap(byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.RGB_565, true) : null);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent();
        intent.setClass(this, MainTabsActivity.class);
        intent.putExtra("new_intent_position", "tab_msg");
        startActivity(intent);
        finish();
        return true;
    }
}
