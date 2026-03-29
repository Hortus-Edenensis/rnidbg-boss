package com.zenmen.media.roomchatdemo.videocallgroup;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11999a;
    public d b;
    public EditText c;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            a aVar = a.this;
            aVar.a((Activity) aVar.f11999a);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            a.this.c.setFocusable(true);
            a.this.c.setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void d(String str);
    }

    public a(Context context, d dVar, EditText editText) {
        this.f11999a = context;
        this.b = dVar;
        this.c = editText;
        editText.setFocusableInTouchMode(true);
        this.c.setCursorVisible(true);
        this.c.addTextChangedListener(new C0937a());
        this.c.setOnEditorActionListener(new b());
        this.c.setOnFocusChangeListener(new c());
    }

    public void a(Activity activity) {
        if (activity != null) {
            try {
                b(activity, this.c);
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context, View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.media.roomchatdemo.videocallgroup.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0937a implements TextWatcher {
        public C0937a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.b.d(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
