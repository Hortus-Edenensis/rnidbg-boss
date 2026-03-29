package com.tide.protocol.context;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideActivityActions {
    boolean dispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean dispatchTrackballEvent(MotionEvent motionEvent);

    <T extends View> T findViewById(int i);

    void finish();

    void finishAffinity();

    ComponentName getCallingActivity();

    String getCallingPackage();

    ClassLoader getClassLoader();

    FragmentManager getFragmentManager();

    Intent getIntent();

    LayoutInflater getLayoutInflater();

    Uri getReferrer();

    Resources getResources();

    Window getWindow();

    boolean isChangingConfigurations();

    boolean isFinishing();

    void overridePendingTransition(int i, int i2);

    void recreate();

    void requestPermissions(String[] strArr, int i);

    boolean requestWindowFeature(int i);
}
