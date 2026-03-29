package com.tide.protocol.context.base;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MotionEvent;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface TideHostActivityDelegator {
    void superOnAttachFragment(Fragment fragment);

    void superOnBackPressed();

    void superOnConfigurationChanged(Configuration configuration);

    void superOnCreate(Bundle bundle);

    void superOnDestroy();

    void superOnGenericMotionEvent(MotionEvent motionEvent);

    boolean superOnKeyLongPress(int i, KeyEvent keyEvent);

    boolean superOnKeyMultiple(int i, int i2, KeyEvent keyEvent);

    boolean superOnKeyShortcut(int i, KeyEvent keyEvent);

    void superOnLowMemory();

    void superOnMultiWindowModeChanged(boolean z, Configuration configuration);

    void superOnPause();

    void superOnPostCreate(Bundle bundle);

    void superOnProvideAssistContent(Object obj);

    void superOnProvideAssistData(Bundle bundle);

    void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i);

    void superOnRestart();

    void superOnRestoreInstanceState(Bundle bundle);

    void superOnResume();

    void superOnStart();

    void superOnStateNotSaved();

    void superOnStop();

    boolean superOnTouchEvent(MotionEvent motionEvent);

    void superOnTrackballEvent(MotionEvent motionEvent);

    void superOnTrimMemory(int i);

    void superOnUserInteraction();

    void superRecreate();
}
