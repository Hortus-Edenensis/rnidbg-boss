package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends View.AccessibilityDelegate {
    public static Field nr;
    public View.AccessibilityDelegate iz;
    public View x;
    public static u u = new u(null, null);
    public static int fx = 0;
    public static String b = "";
    public static Set<Integer> pn = new HashSet();

    static {
        nr = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                nr = declaredField;
            } catch (Throwable unused) {
            }
        }
    }

    public u(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.iz = accessibilityDelegate;
        this.x = view;
        SoftDecTool.h = true;
    }

    public static void u(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        Field field;
        if (pn.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                field = nr;
            } catch (Throwable unused) {
            }
            if (field != null) {
                accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
            } else {
                accessibilityDelegate = null;
                z = false;
            }
        }
        if (!(accessibilityDelegate instanceof u) && z) {
            view.setAccessibilityDelegate(new u(accessibilityDelegate, view));
            pn.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.iz;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable unused) {
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        view.setAccessibilityDelegate(this.iz);
        View.AccessibilityDelegate accessibilityDelegate = this.iz;
        boolean zDispatchPopulateAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.iz;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.iz;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        if (u()) {
            return;
        }
        view.setAccessibilityDelegate(this.iz);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.iz;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        viewGroup.setAccessibilityDelegate(this.iz);
        View.AccessibilityDelegate accessibilityDelegate = this.iz;
        boolean zOnRequestSendAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        SoftDecTool.f5164a = true;
        view.setAccessibilityDelegate(this.iz);
        View.AccessibilityDelegate accessibilityDelegate = this.iz;
        boolean zPerformAccessibilityAction = accessibilityDelegate != null ? accessibilityDelegate.performAccessibilityAction(view, i, bundle) : super.performAccessibilityAction(view, i, bundle);
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.iz;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        fx = hashCode();
        b = String.valueOf(this.iz);
        view.setAccessibilityDelegate(this.iz);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.iz;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable unused) {
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean u() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
