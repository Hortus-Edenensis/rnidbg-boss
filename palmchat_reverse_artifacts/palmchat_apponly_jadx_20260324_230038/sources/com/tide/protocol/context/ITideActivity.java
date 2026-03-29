package com.tide.protocol.context;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideActivity {
    void attachProxy(Activity activity);

    void onActionModeFinished(ActionMode actionMode);

    void onActionModeStarted(ActionMode actionMode);

    void onActivityReenter(int i, Intent intent);

    void onActivityResult(int i, int i2, Intent intent);

    void onApplyThemeResource(Resources.Theme theme, int i, boolean z);

    void onAttachFragment(Fragment fragment);

    void onAttachedToWindow();

    void onBackPressed();

    void onChildTitleChanged(Activity activity, CharSequence charSequence);

    void onConfigurationChanged(Configuration configuration);

    void onContentChanged();

    void onContextItemSelected(MenuItem menuItem);

    void onContextMenuClosed(Menu menu);

    void onCreate(Bundle bundle);

    void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onCreateDescription();

    Dialog onCreateDialog(int i);

    Dialog onCreateDialog(int i, Bundle bundle);

    boolean onCreateOptionsMenu(Menu menu);

    boolean onCreatePanelMenu(int i, Menu menu);

    void onCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View onCreateView(View view, String str, Context context, AttributeSet attributeSet);

    View onCreateView(String str, Context context, AttributeSet attributeSet);

    void onDestroy();

    void onDetachedFromWindow();

    void onEnterAnimationComplete();

    void onGenericMotionEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    boolean onKeyLongPress(int i, KeyEvent keyEvent);

    boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent);

    boolean onKeyShortcut(int i, KeyEvent keyEvent);

    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onLocalVoiceInteractionStarted();

    void onLocalVoiceInteractionStopped();

    void onLowMemory();

    void onMultiWindowModeChanged(boolean z, Configuration configuration);

    void onNavigateUp();

    void onNavigateUpFromChild(Activity activity);

    void onNewIntent(Intent intent);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onOptionsMenuClosed(Menu menu);

    void onPanelClosed(int i, Menu menu);

    void onPause();

    void onPerformDirectAction(String str, Bundle bundle, Object obj, Object obj2);

    void onPictureInPictureModeChanged(boolean z, Configuration configuration);

    void onPictureInPictureUiStateChanged(Object obj);

    void onPointerCaptureChanged(boolean z);

    void onPostResume();

    void onPrepareDialog(int i, Dialog dialog, Bundle bundle);

    boolean onPrepareOptionsMenu(Menu menu);

    void onProvideAssistContent(Object obj);

    void onProvideAssistData(Bundle bundle);

    void onProvideKeyboardShortcuts(Object obj, Menu menu, int i);

    void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStateNotSaved();

    void onStop();

    void onTitleChanged(CharSequence charSequence, int i);

    void onTopResumedActivityChanged(boolean z);

    boolean onTouchEvent(MotionEvent motionEvent);

    void onTrackballEvent(MotionEvent motionEvent);

    void onTrimMemory(int i);

    void onUserInteraction();

    void onUserLeaveHint();

    void onVisibleBehindCanceled();

    void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z);
}
