package com.tide.protocol.context.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MotionEvent;
import com.tide.protocol.context.ITideActivity;
import defpackage.qo4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ProxyBaseActivity extends Activity implements TideHostActivityDelegator {
    protected ITideActivity pluginActivity;

    public ITideActivity getPluginActivity() {
        return this.pluginActivity;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onCreate(bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        ITideActivity iTideActivity = this.pluginActivity;
        return iTideActivity != null ? iTideActivity.onKeyLongPress(i, keyEvent) : super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onPointerCaptureChanged(z);
        } else {
            super.onPointerCaptureChanged(z);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ITideActivity iTideActivity = this.pluginActivity;
        return iTideActivity != null ? iTideActivity.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onTrimMemory(i);
        } else {
            super.onTrimMemory(i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ITideActivity iTideActivity = this.pluginActivity;
        if (iTideActivity != null) {
            iTideActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnDestroy() {
        super.onDestroy();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnGenericMotionEvent(MotionEvent motionEvent) {
        super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public boolean superOnKeyLongPress(int i, KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public boolean superOnKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public boolean superOnKeyShortcut(int i, KeyEvent keyEvent) {
        return super.onKeyShortcut(i, keyEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnMultiWindowModeChanged(boolean z, Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 26) {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnPause() {
        super.onPause();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    @SuppressLint({"NewApi"})
    public void superOnProvideAssistContent(Object obj) {
        super.onProvideAssistContent(qo4.a(obj));
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    @SuppressLint({"NewApi"})
    public void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        super.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnRestart() {
        super.onRestart();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnResume() {
        super.onResume();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnStart() {
        super.onStart();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    @SuppressLint({"NewApi"})
    public void superOnStateNotSaved() {
        super.onStateNotSaved();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnStop() {
        super.onStop();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnTrackballEvent(MotionEvent motionEvent) {
        super.onTrackballEvent(motionEvent);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.tide.protocol.context.base.TideHostActivityDelegator
    public void superRecreate() {
        super.recreate();
    }
}
