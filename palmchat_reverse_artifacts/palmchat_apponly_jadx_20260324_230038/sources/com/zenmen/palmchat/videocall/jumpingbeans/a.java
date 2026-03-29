package com.zenmen.palmchat.videocall.jumpingbeans;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JumpingBeansSpan[] f15865a;
    public final WeakReference<TextView> b;

    /* JADX INFO: renamed from: com.zenmen.palmchat.videocall.jumpingbeans.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1131a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f15866a;
        public int b;
        public int c;
        public float d = 0.3f;
        public int e = 1300;
        public int f = -1;
        public CharSequence g;
        public boolean h;

        public C1131a(TextView textView) {
            this.f15866a = textView;
        }

        public static CharSequence b(TextView textView) {
            CharSequence charSequenceH = h(textView);
            if (charSequenceH.length() > 0 && f(charSequenceH)) {
                charSequenceH = charSequenceH.subSequence(0, charSequenceH.length() - 1);
            }
            return !g(charSequenceH) ? new SpannableStringBuilder(charSequenceH).append((CharSequence) "...") : charSequenceH;
        }

        public static boolean f(CharSequence charSequence) {
            return "…".equals(charSequence.subSequence(charSequence.length() - 1, charSequence.length()));
        }

        public static boolean g(CharSequence charSequence) {
            if (charSequence.length() < 3) {
                return false;
            }
            return "...".equals(charSequence.subSequence(charSequence.length() - 3, charSequence.length()));
        }

        public static CharSequence h(TextView textView) {
            return !TextUtils.isEmpty(textView.getText()) ? textView.getText() : "";
        }

        @NonNull
        public C1131a a() {
            CharSequence charSequenceB = b(this.f15866a);
            this.g = charSequenceB;
            this.h = true;
            this.b = charSequenceB.length() - 3;
            this.c = charSequenceB.length();
            return this;
        }

        @NonNull
        public a c() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.g);
            JumpingBeansSpan[] jumpingBeansSpanArrE = this.h ? e(spannableStringBuilder) : d(spannableStringBuilder);
            this.f15866a.setText(spannableStringBuilder);
            return new a(jumpingBeansSpanArrE, this.f15866a);
        }

        public final JumpingBeansSpan[] d(SpannableStringBuilder spannableStringBuilder) {
            JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.f15866a, this.e, 0, 0, this.d);
            JumpingBeansSpan[] jumpingBeansSpanArr = {jumpingBeansSpan};
            spannableStringBuilder.setSpan(jumpingBeansSpan, this.b, this.c, 33);
            return jumpingBeansSpanArr;
        }

        public final JumpingBeansSpan[] e(SpannableStringBuilder spannableStringBuilder) {
            if (this.f == -1) {
                try {
                    this.f = this.e / ((this.c - this.b) * 2);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f = 100;
                }
            }
            int i = this.c;
            int i2 = this.b;
            JumpingBeansSpan[] jumpingBeansSpanArr = new JumpingBeansSpan[i - i2];
            while (i2 < this.c) {
                JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.f15866a, this.e, i2 - this.b, this.f, this.d);
                int i3 = i2 + 1;
                spannableStringBuilder.setSpan(jumpingBeansSpan, i2, i3, 33);
                jumpingBeansSpanArr[i2 - this.b] = jumpingBeansSpan;
                i2 = i3;
            }
            return jumpingBeansSpanArr;
        }
    }

    public static C1131a a(@NonNull TextView textView) {
        return new C1131a(textView);
    }

    public a(JumpingBeansSpan[] jumpingBeansSpanArr, TextView textView) {
        this.f15865a = jumpingBeansSpanArr;
        this.b = new WeakReference<>(textView);
    }
}
