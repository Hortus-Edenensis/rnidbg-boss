package com.zenmen.palmchat.chat;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.imp.BigText.BigTextInputView;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.g13;
import defpackage.mt2;
import defpackage.pu1;
import defpackage.r75;
import defpackage.rl1;
import defpackage.sy5;
import defpackage.xn3;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BigTextActivity extends BaseActionBarActivity implements mt2.c {
    public TextView C;
    public ImageView E;
    public View F;
    public ScrollView J;
    public View K;
    public View L;
    public View M;
    public TextView N;
    public GifImageView O;
    public BigTextInputView P;
    public EditText q;
    public String[] r;
    public TextView t;
    public ChatItem u;
    public int v;
    public View w;
    public View x;
    public InputMethodManager y;
    public final int s = 750;
    public String z = "";
    public boolean A = false;
    public int B = 0;
    public boolean G = false;
    public String H = "bigtext_gif_show";
    public String I = "bigtext_tips_count";
    public int Q = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BigTextActivity.this.P.onTextMode();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int measuredHeight = BigTextActivity.this.q.getMeasuredHeight();
            BigTextActivity.this.P.updateBackground(BigTextActivity.this.q.getMeasuredWidth(), measuredHeight);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BigTextActivity.this.y.hideSoftInputFromWindow(BigTextActivity.this.q.getWindowToken(), 0);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new Instrumentation().sendKeyDownUpSync(66);
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BigTextActivity.this.q.setFocusable(true);
            BigTextActivity.this.q.requestFocus();
            BigTextActivity.this.q.requestFocusFromTouch();
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r75.o(AppContext.getContext(), BigTextActivity.this.H, true);
            BigTextActivity.this.K.setVisibility(0);
            BigTextActivity.this.L.setVisibility(8);
            BigTextActivity bigTextActivity = BigTextActivity.this;
            KeyboardKt.d(bigTextActivity.q, bigTextActivity.y, Keyboard$SHOW_FLAG.DEFAULT, 0L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BigTextActivity.this.t.setEnabled(false);
            BigTextActivity.this.w.setVisibility(0);
            BigTextActivity.this.K1();
            BigTextActivity.this.P.uploadInfo();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BigTextActivity.this.q.buildDrawingCache();
            BigTextActivity.this.q.setCursorVisible(false);
            Bitmap drawingCache = BigTextActivity.this.q.getDrawingCache();
            try {
                pu1.t();
                StringBuilder sb = new StringBuilder();
                sb.append(pu1.e);
                String str = File.separator;
                sb.append(str);
                sb.append("bigtext");
                String string = sb.toString();
                File file = new File(string);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(string + str + BigTextActivity.L1());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                if (drawingCache != null) {
                    drawingCache.compress(Bitmap.CompressFormat.JPEG, 60, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    BigTextActivity.this.O1(file2.getAbsolutePath(), false);
                    BigTextActivity.this.setResult(-1);
                    BigTextActivity.this.finish();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("action", "send_message");
            put("status", "sendImageInMediaPick");
        }
    }

    public static String L1() {
        return xn3.a() + ".jpg";
    }

    public final void K1() {
        this.q.setIncludeFontPadding(false);
        String strP1 = P1(this.q.getText().toString());
        if (strP1.substring(strP1.length() - 1, strP1.length()).equals("\n")) {
            strP1 = strP1 + " ";
        }
        this.r = strP1.split("\n");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bigtext_pd_bp);
        this.q.setWidth(750);
        int width = this.q.getWidth() - (dimensionPixelSize * 2);
        if (this.r.length <= 0) {
            return;
        }
        Paint paint = new Paint();
        paint.setFakeBoldText(true);
        paint.setColor(-16777216);
        paint.setTextAlign(Paint.Align.LEFT);
        SpannableString spannableString = new SpannableString(strP1);
        int length = 0;
        for (String str : this.r) {
            if (str.length() > 0) {
                int length2 = width / str.length();
                if (length2 >= getResources().getDimensionPixelSize(R.dimen.bigtext_one_font_max) && strP1.length() == 1) {
                    length2 = getResources().getDimensionPixelSize(R.dimen.bigtext_one_font_max);
                } else if (length2 > getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max)) {
                    length2 = getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max);
                }
                spannableString.setSpan(new AbsoluteSizeSpan(length2), length, str.length() + length, 18);
                spannableString.setSpan(new StyleSpan(1), length, str.length() + length, 18);
                length += str.length() + 1;
                paint.setTextSize(length2);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            } else if (str.length() == 0) {
                paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max));
                Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
                Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                length++;
            }
        }
        this.q.setText(spannableString);
        if (strP1.length() == 1) {
            this.q.setPadding(0, 0, 0, 0);
            this.q.setIncludeFontPadding(false);
            this.q.setGravity(17);
        }
        InputMethodManager inputMethodManager = this.y;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.q.getWindowToken(), 0);
        }
        this.q.postDelayed(new h(), 200L);
    }

    public final void M1() {
        this.K = findViewById(R.id.bigtext_content);
        this.L = findViewById(R.id.gif_layer);
        this.M = findViewById(R.id.bigtext_startmake_layer);
        this.N = (TextView) findViewById(R.id.strart_make_btn);
        this.O = (GifImageView) findViewById(R.id.start_gif_image);
        EditText editText = (EditText) findViewById(R.id.input_text);
        this.q = editText;
        editText.setSelection(editText.getText().length());
        this.q.setDrawingCacheEnabled(true);
        this.q.setIncludeFontPadding(false);
        this.q.setFilters(new rl1[]{new rl1()});
        this.F = findViewById(R.id.tips_layer);
        this.w = findViewById(R.id.mask_gone_view);
        this.C = (TextView) findViewById(R.id.bigtext_enter);
        this.E = (ImageView) findViewById(R.id.image_tips);
        this.q.setFocusable(true);
        this.q.setFocusableInTouchMode(true);
        this.q.requestFocus();
        this.q.setOnClickListener(new a());
        this.q.addTextChangedListener(new b());
        this.q.getViewTreeObserver().addOnPreDrawListener(new c());
        this.x = findViewById(R.id.bigtext_root_view);
        BigTextInputView bigTextInputView = (BigTextInputView) findViewById(R.id.inputView);
        this.P = bigTextInputView;
        bigTextInputView.setInputBox(this.q);
        this.P.onTextMode();
        ScrollView scrollView = (ScrollView) findViewById(R.id.bigtext_scrollview);
        this.J = scrollView;
        scrollView.fullScroll(130);
        this.J.setOnTouchListener(new d());
        this.C.setOnClickListener(new e());
        this.N.setOnClickListener(new f());
    }

    public final void N1() {
        int iG;
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.q.getText();
        int selectionStart = this.q.getSelectionStart();
        String string = this.q.getText().toString();
        if (string.trim().length() <= 0) {
            this.t.setEnabled(false);
        } else if (string.replace("\n", "").length() > 0) {
            this.t.setEnabled(true);
            this.C.setEnabled(true);
            if (!this.G && r75.g(AppContext.getContext(), this.I, 0) < 5) {
                this.E.setVisibility(0);
            }
        }
        if (string.contains("\n")) {
            if (!this.G && (iG = r75.g(AppContext.getContext(), this.I, 0)) < 10) {
                r75.p(AppContext.getContext(), this.I, iG + 1);
            }
            this.E.setVisibility(8);
            this.G = true;
        }
        if (string.substring(string.length() - 1 < 0 ? 0 : string.length() - 1, string.length()).equals("\n")) {
            String[] strArrSplit = (string + " ").split("\n");
            this.r = strArrSplit;
            strArrSplit[strArrSplit.length - 1] = "";
        } else {
            this.r = string.split("\n");
        }
        if ((string + " ").split("\n").length > 5) {
            sy5.e(this, R.string.bigtext_length5, 0).g();
            this.A = true;
            this.q.setText(this.z);
            if (selectionStart > this.z.length()) {
                selectionStart = this.z.length();
            }
            this.q.setSelection(selectionStart);
            return;
        }
        this.B = this.q.getSelectionStart();
        this.z = string;
        int width = this.q.getWidth() - (getResources().getDimensionPixelSize(R.dimen.bigtext_pd_bp) * 2);
        if (this.r.length <= 0) {
            return;
        }
        Paint paint = new Paint();
        paint.setFakeBoldText(true);
        paint.setColor(-16777216);
        paint.setTextAlign(Paint.Align.LEFT);
        AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, string.length(), AbsoluteSizeSpan.class);
        StyleSpan[] styleSpanArr = (StyleSpan[]) spannableStringBuilder.getSpans(0, string.length(), StyleSpan.class);
        for (AbsoluteSizeSpan absoluteSizeSpan : absoluteSizeSpanArr) {
            spannableStringBuilder.removeSpan(absoluteSizeSpan);
        }
        for (StyleSpan styleSpan : styleSpanArr) {
            spannableStringBuilder.removeSpan(styleSpan);
        }
        int length = 0;
        for (String str : this.r) {
            if (str.length() > 0) {
                int length2 = width / str.length();
                if (length2 >= getResources().getDimensionPixelSize(R.dimen.bigtext_one_font_max) && string.length() == 1) {
                    length2 = getResources().getDimensionPixelSize(R.dimen.bigtext_one_font_max);
                } else if (length2 > getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max)) {
                    length2 = getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max);
                }
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(length2), length, str.length() + length, 18);
                spannableStringBuilder.setSpan(new StyleSpan(1), length, str.length() + length, 18);
                length += str.length() + 1;
            } else if (str.length() == 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.bigtext_two_font_max)), length, length, 18);
                spannableStringBuilder.setSpan(new StyleSpan(1), length, length, 18);
                length++;
            }
        }
        this.A = false;
        this.q.setSelection(selectionStart);
    }

    public final void O1(String str, boolean z) {
        String strA = xn3.a();
        ChatItem chatItem = this.u;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strE = DomainHelper.e(this.u);
        try {
            if (new File(str).exists()) {
                getMessagingServiceInterface().r(MessageVo.buildImageMessage(strA, strE, str, z, 0, true, getString(R.string.message_type_bigtext, this.q.getText().toString().replace("\n", " "))).setThreadBizType(this, this.v));
            } else {
                sy5.e(AppContext.getContext(), R.string.send_image_file_delete, 0).g();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(BaseActionBarActivity.TAG, 3, new i(), e2);
        }
    }

    public String P1(String str) {
        if (str.lastIndexOf("\n") < 0) {
            return str;
        }
        String strTrim = str.substring(str.lastIndexOf("\n"), str.length()).trim();
        return (TextUtils.isEmpty(strTrim) || strTrim.equals("\n")) ? P1(str.substring(0, str.lastIndexOf("\n"))) : str;
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(-1));
        ((TextView) getToolbar().findViewById(R.id.title)).setText(R.string.bittext_title);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.t = textView;
        textView.setText(R.string.media_pick_activity_send);
        this.t.setEnabled(false);
        this.t.setOnClickListener(new g());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.P.getInputMode() != BigTextInputView.INPUT_MODE.NONE) {
            this.P.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mt2.a(this, this);
        Intent intent = getIntent();
        this.u = (ChatItem) intent.getParcelableExtra("chat_item");
        this.v = intent.getIntExtra("thread_biz_type", 0);
        setContentView(R.layout.bigtext_activity_layout);
        this.y = (InputMethodManager) getSystemService("input_method");
        initActionBar();
        M1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        InputMethodManager inputMethodManager = this.y;
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.hideSoftInputFromWindow(this.q.getWindowToken(), 0);
        return true;
    }

    @Override // mt2.c
    public void onSoftKeyboardStatusChanged(int i2, int i3) {
        LogUtil.i(BaseActionBarActivity.TAG, "onSoftKeyboardStatusChanged height:" + i3 + ", state = " + i2);
        if (i3 == 0) {
            this.F.setVisibility(8);
        }
        if (i2 == 0) {
            this.F.setVisibility(0);
            String string = this.q.getText().toString();
            int selectionStart = this.q.getSelectionStart();
            this.q.setText(string);
            this.q.setSelection(selectionStart);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            BigTextActivity.this.N1();
            BigTextActivity.this.q.setEnabled(true);
            BigTextActivity.this.q.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
