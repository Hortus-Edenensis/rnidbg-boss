package com.zenmen.palmchat.expression;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.k86;
import defpackage.mt2;
import defpackage.ot1;
import defpackage.pu1;
import defpackage.rb3;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExpressionPreviewActivity extends BaseActionBarActivity {
    public TextView q;
    public ImageView r;
    public String s = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpressionPreviewActivity expressionPreviewActivity = ExpressionPreviewActivity.this;
            expressionPreviewActivity.C1(expressionPreviewActivity.s);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, Intent> {
        public final /* synthetic */ String m;

        public b(String str) {
            this.m = str;
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            ExpressionPreviewActivity expressionPreviewActivity = ExpressionPreviewActivity.this;
            expressionPreviewActivity.showBaseProgressBar(expressionPreviewActivity.getResources().getString(R.string.string_add_expressions_doing), false, false);
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Intent g(Void... voidArr) throws Throwable {
            File file = new File(this.m);
            Intent intent = new Intent();
            intent.putExtra("result", -1);
            File fileC = null;
            boolean z = false;
            if (file.exists()) {
                try {
                    if (ExpressionPreviewActivity.this.F1(file.getAbsolutePath(), 1010, 1010)) {
                        intent.putExtra("result", 1);
                    } else {
                        pu1.t();
                        File file2 = new File(pu1.k);
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                        String str = pu1.k + File.separator + System.currentTimeMillis();
                        fileC = pu1.c(str);
                        pu1.f(file, fileC);
                        String strB = rb3.b(file);
                        String strB2 = rb3.b(fileC);
                        if (TextUtils.isEmpty(strB) || !strB.equals(strB2)) {
                            intent.putExtra("result", -1);
                        } else {
                            ExpressionObject expressionObject = new ExpressionObject();
                            expressionObject.path = str;
                            expressionObject.coverPath = str;
                            expressionObject.md5 = strB2;
                            ot1.b(expressionObject);
                            intent.putExtra("result", 0);
                            z = true;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    intent.putExtra("result", -1);
                }
            }
            if (!z && fileC != null) {
                try {
                    if (fileC.exists()) {
                        fileC.delete();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return intent;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Intent intent) {
            ExpressionPreviewActivity.this.hideBaseProgressBar();
            ExpressionPreviewActivity.this.setResult(-1, intent);
            ExpressionPreviewActivity.this.finish();
        }
    }

    public void C1(String str) {
        if (TextUtils.isEmpty(str)) {
            finish();
        } else {
            new b(str).h(new Void[0]);
        }
    }

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("");
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.q = textView;
        textView.setText(R.string.string_use);
        this.q.setOnClickListener(new a());
    }

    public final void E1() {
        this.r = (ImageView) findViewById(R.id.image);
        gr2.j().h(k86.p(this.s), this.r, bq6.j());
    }

    public final boolean F1(String str, int i, int i2) {
        if (!str.endsWith(".gif")) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth > i || options.outHeight > i2;
    }

    public final void G1() {
        this.s = getIntent().getStringExtra("file_path");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_expression_preview);
        G1();
        D1();
        E1();
        mt2.a(this, null);
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
