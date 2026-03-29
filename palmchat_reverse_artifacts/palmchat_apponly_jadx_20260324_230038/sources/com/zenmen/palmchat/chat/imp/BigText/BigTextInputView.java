package com.zenmen.palmchat.chat.imp.BigText;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cdo.oaps.ad.OapsKey;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.imp.BigText.b;
import com.zenmen.palmchat.chat.imp.BigText.e;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g03;
import defpackage.gd5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k36;
import defpackage.mo;
import defpackage.mt2;
import defpackage.sy5;
import defpackage.v02;
import defpackage.vl1;
import defpackage.xt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BigTextInputView extends FrameLayout implements mt2.c, View.OnClickListener {
    private static final int MAX_INPUT_LENGTH = 6000;
    private static final String TAG = "BigTextInputView";
    private b.InterfaceC0998b backgroundListener;
    private e.b fontListener;
    private LinearLayout mAddArea;
    private ImageView mBackgroundImageView;
    private LinearLayout mBackgroundView;
    private com.zenmen.palmchat.chat.imp.BigText.b mBackgroundViewHelper;
    private Context mContext;
    private ImageView mFontImageView;
    private LinearLayout mFontView;
    private e mFontViewHelper;
    private EditText mInputBox;
    private INPUT_MODE mInputMode;
    private INPUT_MODE mLastInputMode;
    private mo mSelectedBackgroundConfig;
    private v02 mSelectedFontConfig;
    private ImageView mSwitchImageView;
    private ImageView mTextImageView;

    /* JADX INFO: compiled from: SearchBox */
    public enum INPUT_MODE {
        NONE,
        TEXT,
        FONT,
        BACKGROUND
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b.InterfaceC0998b {

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.imp.BigText.BigTextInputView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0995a extends gd5 {
            public C0995a() {
            }

            @Override // defpackage.gd5, defpackage.jr2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                super.onLoadingComplete(str, view, bitmap);
                if (bitmap != null) {
                    BigTextInputView.this.mInputBox.setBackgroundDrawable(new BitmapDrawable(ThumbnailUtils.extractThumbnail(bitmap, BigTextInputView.this.mInputBox.getWidth(), BigTextInputView.this.mInputBox.getHeight())));
                }
            }
        }

        public a() {
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.b.InterfaceC0998b
        public void a(mo moVar) {
            if (moVar == null) {
                return;
            }
            LogUtil.i(BigTextInputView.TAG, "onBackgroundChange id = " + moVar.f19278a);
            BigTextInputView.this.mSelectedBackgroundConfig = moVar;
            BigTextInputView.this.mBackgroundViewHelper.d(moVar.f19278a);
            BigTextInputView.this.mInputBox.setTextColor(Color.parseColor(moVar.c));
            BigTextInputView.this.mInputBox.setBackgroundColor(Color.parseColor(moVar.b));
            gr2.j().k(moVar.e, new je1.a().s(true).t(true).q(Bitmap.Config.RGB_565).r(), new C0995a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements e.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v02 f12874a;
            public final /* synthetic */ String b;

            public a(v02 v02Var, String str) {
                this.f12874a = v02Var;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                v02 v02Var = this.f12874a;
                if (v02Var == null) {
                    return;
                }
                BigTextInputView.this.mSelectedFontConfig = v02Var;
                if (this.f12874a.f21335a == 0) {
                    BigTextInputView.this.mInputBox.setTypeface(Typeface.DEFAULT);
                    return;
                }
                try {
                    if (this.b != null) {
                        LogUtil.i(BigTextInputView.TAG, "onFontChange path = " + this.b);
                        BigTextInputView.this.mInputBox.setTypeface(Typeface.createFromFile(this.b));
                    }
                } catch (RuntimeException e) {
                    LogUtil.e(BigTextInputView.TAG, e.toString());
                    sy5.f(BigTextInputView.this.mContext, BigTextInputView.this.getResources().getString(R.string.font_change_fail), 0).g();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("font", this.f12874a.f21335a);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate("3802", "1", null, jSONObject.toString());
                }
                BigTextInputView bigTextInputView = BigTextInputView.this;
                bigTextInputView.updateBackground(bigTextInputView.mInputBox.getWidth(), BigTextInputView.this.mInputBox.getHeight());
            }
        }

        public b() {
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.e.b
        public void a(v02 v02Var, String str) {
            if (v02Var == null) {
                return;
            }
            LogUtil.i(BigTextInputView.TAG, "onFontChange id = " + v02Var.f21335a);
            BigTextInputView.this.mFontViewHelper.d(v02Var.f21335a);
            if (BigTextInputView.this.mContext instanceof Activity) {
                ((Activity) BigTextInputView.this.mContext).runOnUiThread(new a(v02Var, str));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends gd5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12875a;
        public final /* synthetic */ int b;

        public c(int i, int i2) {
            this.f12875a = i;
            this.b = i2;
        }

        @Override // defpackage.gd5, defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            super.onLoadingComplete(str, view, bitmap);
            if (bitmap != null) {
                BigTextInputView.this.mInputBox.setBackgroundDrawable(new BitmapDrawable(xt.b(bitmap, this.f12875a, this.b)));
            }
        }
    }

    public BigTextInputView(@NonNull Context context) {
        this(context, null);
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.view_bigtext, this);
        this.mAddArea = (LinearLayout) findViewById(R.id.add_area);
        this.mBackgroundView = (LinearLayout) findViewById(R.id.backgroundLayout);
        this.mFontView = (LinearLayout) findViewById(R.id.fontLayout);
        this.mBackgroundImageView = (ImageView) findViewById(R.id.background);
        this.mFontImageView = (ImageView) findViewById(R.id.font);
        this.mTextImageView = (ImageView) findViewById(R.id.input);
        ImageView imageView = (ImageView) findViewById(R.id.switchView);
        this.mSwitchImageView = imageView;
        imageView.setOnClickListener(this);
        this.mBackgroundImageView.setOnClickListener(this);
        this.mFontImageView.setOnClickListener(this);
        this.mTextImageView.setOnClickListener(this);
        g03.a(this.mAddArea, g03.e(getContext()) - k36.b(2.0f));
        e eVar = new e(this.mContext, this.mAddArea, this.fontListener);
        this.mFontViewHelper = eVar;
        eVar.f();
        com.zenmen.palmchat.chat.imp.BigText.b bVar = new com.zenmen.palmchat.chat.imp.BigText.b(this.mContext, this.mAddArea, this.backgroundListener);
        this.mBackgroundViewHelper = bVar;
        bVar.f();
        this.mAddArea.setVisibility(8);
    }

    private void onBackgroundMode() {
        this.mInputMode = INPUT_MODE.BACKGROUND;
        this.mAddArea.setVisibility(0);
        this.mBackgroundView.setVisibility(0);
        this.mFontView.setVisibility(8);
        k36.f(this.mInputBox);
        g03.a(this.mAddArea, g03.d() - k36.b(2.0f));
        this.mBackgroundViewHelper.f();
        this.mTextImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_normal));
        this.mFontImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_font_normal));
        this.mBackgroundImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_background_selected));
        this.mSwitchImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_down));
    }

    private void onFontMode() {
        this.mInputMode = INPUT_MODE.FONT;
        this.mAddArea.setVisibility(0);
        this.mBackgroundView.setVisibility(8);
        this.mFontView.setVisibility(0);
        k36.f(this.mInputBox);
        g03.a(this.mAddArea, g03.d() - k36.b(2.0f));
        this.mFontViewHelper.f();
        this.mFontImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_font_selected));
        this.mTextImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_normal));
        this.mBackgroundImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_background_normal));
        this.mSwitchImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_down));
    }

    private void onNoneMode() {
        this.mInputMode = INPUT_MODE.NONE;
        k36.f(this.mInputBox);
        this.mFontImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_font_normal));
        this.mTextImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_normal));
        this.mBackgroundImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_background_normal));
        this.mSwitchImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_up));
        this.mAddArea.setVisibility(8);
    }

    private void onSwitchClick() {
        if (this.mInputMode != INPUT_MODE.NONE) {
            k36.f(this.mInputBox);
            this.mAddArea.setVisibility(8);
            this.mLastInputMode = this.mInputMode;
            onNoneMode();
            return;
        }
        INPUT_MODE input_mode = this.mLastInputMode;
        if (input_mode == INPUT_MODE.TEXT) {
            onTextMode();
        } else if (input_mode == INPUT_MODE.FONT) {
            onFontMode();
        } else if (input_mode == INPUT_MODE.BACKGROUND) {
            onBackgroundMode();
        }
    }

    public void appendInput(String str, boolean z) {
        Editable editableText = this.mInputBox.getEditableText();
        EditText editText = this.mInputBox;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart < 0 || selectionEnd < 0) {
            selectionStart = editText.getText().length();
            selectionEnd = selectionStart;
        }
        int length = this.mInputBox.getText().length();
        editableText.replace(selectionStart, selectionEnd, str);
        editText.setText(vl1.c(editableText.toString(), getContext(), vl1.f));
        int length2 = str.length();
        if (length + length2 > 6000) {
            length2 = 6000 - length;
        }
        editText.setSelection(selectionStart + length2);
        this.mInputBox.requestFocus();
        if (z) {
            k36.h(this.mInputBox);
        }
    }

    public INPUT_MODE getInputMode() {
        return this.mInputMode;
    }

    public void onBackPressed() {
        onNoneMode();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mTextImageView) {
            onTextMode();
            return;
        }
        if (view == this.mFontImageView) {
            onFontMode();
        } else if (view == this.mBackgroundImageView) {
            onBackgroundMode();
        } else if (view == this.mSwitchImageView) {
            onSwitchClick();
        }
    }

    @Override // mt2.c
    public void onSoftKeyboardStatusChanged(int i, int i2) {
        LogUtil.i(TAG, "onSoftKeyboardStatusChanged height:" + i2 + ", state = " + i);
        if (i != 1) {
            if (i != 0 || this.mInputMode == INPUT_MODE.TEXT) {
                return;
            }
            onTextMode();
            return;
        }
        INPUT_MODE input_mode = this.mInputMode;
        if (input_mode == INPUT_MODE.FONT) {
            onFontMode();
        } else if (input_mode == INPUT_MODE.BACKGROUND) {
            onBackgroundMode();
        } else {
            onNoneMode();
        }
    }

    public void onTextMode() {
        this.mInputMode = INPUT_MODE.TEXT;
        this.mAddArea.setVisibility(0);
        this.mBackgroundView.setVisibility(8);
        this.mFontView.setVisibility(8);
        g03.a(this.mAddArea, g03.d() - k36.b(2.0f));
        this.mInputBox.setFocusable(true);
        this.mInputBox.requestFocus();
        this.mInputBox.requestFocusFromTouch();
        k36.h(this.mInputBox);
        this.mTextImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_selected));
        this.mFontImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_font_normal));
        this.mBackgroundImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_background_normal));
        this.mSwitchImageView.setImageDrawable(getResources().getDrawable(R.drawable.big_input_down));
    }

    public void setInputBox(EditText editText) {
        this.mInputBox = editText;
    }

    public void updateBackground(int i, int i2) {
        je1 je1VarR = new je1.a().s(true).t(true).q(Bitmap.Config.RGB_565).r();
        mo moVar = this.mSelectedBackgroundConfig;
        if (moVar == null || moVar.e == null) {
            return;
        }
        gr2.j().k(this.mSelectedBackgroundConfig.e, je1VarR, new c(i, i2));
    }

    public void uploadInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            v02 v02Var = this.mSelectedFontConfig;
            if (v02Var != null) {
                jSONObject.put("font", v02Var.f21335a);
            } else {
                jSONObject.put("font", 0);
            }
            mo moVar = this.mSelectedBackgroundConfig;
            if (moVar != null) {
                jSONObject.put(OapsKey.KEY_BG, moVar.f19278a);
            } else {
                jSONObject.put(OapsKey.KEY_BG, 0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("3801", "1", null, jSONObject.toString());
    }

    public BigTextInputView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BigTextInputView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mInputMode = INPUT_MODE.NONE;
        this.mLastInputMode = INPUT_MODE.TEXT;
        this.backgroundListener = new a();
        this.fontListener = new b();
        this.mContext = context;
        mt2.a((FrameworkBaseActivity) context, this);
        initViews();
    }
}
