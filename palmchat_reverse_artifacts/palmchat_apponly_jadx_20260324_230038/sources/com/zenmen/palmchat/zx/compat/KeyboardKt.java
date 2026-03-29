package com.zenmen.palmchat.zx.compat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import defpackage.f03;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\r\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a9\u0010\u0010\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0012\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a;\u0010\u0016\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "widget", "Landroid/app/Activity;", "activity", "Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;", "flag", "", "delayed", "", "a", "(Landroid/view/View;Landroid/app/Activity;Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;J)V", "parent", "c", "(Landroid/view/View;Landroid/view/View;Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;J)V", "Landroid/app/Dialog;", t.l, "(Landroid/view/View;Landroid/app/Dialog;Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;J)V", "e", "(Landroid/view/View;Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;J)V", "Landroid/view/inputmethod/InputMethodManager;", "imm", "d", "(Landroid/view/View;Landroid/view/inputmethod/InputMethodManager;Lcom/zenmen/palmchat/zx/compat/Keyboard$SHOW_FLAG;J)V", "zx-compat_release"}, k = 2, mv = {1, 4, 0})
public final class KeyboardKt {
    public static final <T extends View> void a(T t, Activity activity, Keyboard$SHOW_FLAG keyboard$SHOW_FLAG, long j) {
        if (activity.isFinishing()) {
            return;
        }
        d(t, (InputMethodManager) activity.getSystemService("input_method"), keyboard$SHOW_FLAG, j);
    }

    public static final <T extends View> void b(T t, Dialog dialog, Keyboard$SHOW_FLAG keyboard$SHOW_FLAG, long j) {
        d(t, (InputMethodManager) dialog.getContext().getSystemService("input_method"), keyboard$SHOW_FLAG, j);
    }

    public static final <T extends View> void c(T t, View view, Keyboard$SHOW_FLAG keyboard$SHOW_FLAG, long j) {
        d(t, (InputMethodManager) view.getContext().getSystemService("input_method"), keyboard$SHOW_FLAG, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, android.view.inputmethod.InputMethodManager] */
    public static final <T extends View> void d(final T t, InputMethodManager inputMethodManager, final Keyboard$SHOW_FLAG keyboard$SHOW_FLAG, long j) {
        if (t == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = inputMethodManager;
        if (inputMethodManager == 0) {
            objectRef.element = (InputMethodManager) t.getContext().getSystemService("input_method");
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.zenmen.palmchat.zx.compat.KeyboardKt$Show$proc$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                t.setEnabled(true);
                t.setFocusable(true);
                t.setFocusableInTouchMode(true);
                t.requestFocus();
                InputMethodManager inputMethodManager2 = (InputMethodManager) objectRef.element;
                if (inputMethodManager2 != null) {
                    inputMethodManager2.showSoftInput(t, keyboard$SHOW_FLAG.getFlag(), new ResultReceiver(null) { // from class: com.zenmen.palmchat.zx.compat.KeyboardKt$Show$proc$1.1
                        @Override // android.os.ResultReceiver
                        public void onReceiveResult(int resultCode, Bundle resultData) {
                            super.onReceiveResult(resultCode, resultData);
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str = String.format("code: " + resultCode, Arrays.copyOf(new Object[0], 0));
                            Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
                            Log.i("showSoftKeyboard", str);
                        }
                    });
                }
            }
        };
        if (j > 0) {
            t.postDelayed(new f03(function0), j);
        } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            t.post(new f03(function0));
        }
    }

    public static final <T extends View> void e(T t, Keyboard$SHOW_FLAG keyboard$SHOW_FLAG, long j) {
        Context context;
        d(t, (InputMethodManager) ((t == null || (context = t.getContext()) == null) ? null : context.getSystemService("input_method")), keyboard$SHOW_FLAG, j);
    }
}
