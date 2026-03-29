package org.apache.cordova;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.zenmen.openapi.auth.widget.a;
import com.zenmen.openapi.jssdk.widget.PermissionDialogView;
import defpackage.w43;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaChromeClient extends WebChromeClient {
    public static final int AUDIO_PERMISSION_REQUEST_CODE = 567835;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 567834;
    public static final int FILECHOOSER_RESULTCODE = 5173;
    protected CordovaWebView appView;
    protected CordovaInterface cordova;
    private AlertDialog lastHandledDialog;
    private Intent mCameraIntent;
    private ValueCallback<Uri[]> mFilePathsCallback;
    private PermissionRequest mRequest;
    private View mVideoProgressView;
    private String TAG = "CordovaLog";
    private long MAX_QUOTA = 104857600;

    @Deprecated
    public CordovaChromeClient(CordovaInterface cordovaInterface) {
        this.cordova = cordovaInterface;
    }

    public void cancelShowingCamera() {
        ValueCallback<Uri[]> valueCallback = this.mFilePathsCallback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mFilePathsCallback = null;
        }
    }

    public void destroyLastDialog() {
        AlertDialog alertDialog = this.lastHandledDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            LinearLayout linearLayout = new LinearLayout(this.appView.getContext());
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            View progressBar = new ProgressBar(this.appView.getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            progressBar.setLayoutParams(layoutParams2);
            linearLayout.addView(progressBar);
            this.mVideoProgressView = linearLayout;
        }
        return this.mVideoProgressView;
    }

    public void grantRecordAudio() {
        PermissionRequest permissionRequest = this.mRequest;
        if (permissionRequest != null) {
            permissionRequest.grant(new String[]{"android.webkit.resource.AUDIO_CAPTURE"});
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        LOG.d(this.TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
        quotaUpdater.updateQuota(this.MAX_QUOTA);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        this.appView.hideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.cordova.getActivity());
        builder.setMessage(str2);
        builder.setTitle("Alert");
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaChromeClient.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.confirm();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.CordovaChromeClient.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: org.apache.cordova.CordovaChromeClient.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                jsResult.confirm();
                return false;
            }
        });
        this.lastHandledDialog = builder.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.cordova.getActivity());
        builder.setMessage(str2);
        builder.setTitle("Confirm");
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaChromeClient.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.confirm();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaChromeClient.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.cancel();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.CordovaChromeClient.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: org.apache.cordova.CordovaChromeClient.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                jsResult.cancel();
                return false;
            }
        });
        this.lastHandledDialog = builder.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        String strPromptOnJsPrompt = this.appView.bridge.promptOnJsPrompt(str, str2, str3);
        if (strPromptOnJsPrompt != null) {
            jsPromptResult.confirm(strPromptOnJsPrompt);
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.cordova.getActivity());
        builder.setMessage(str2);
        final EditText editText = new EditText(this.cordova.getActivity());
        if (str3 != null) {
            editText.setText(str3);
        }
        builder.setView(editText);
        builder.setCancelable(false);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaChromeClient.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsPromptResult.confirm(editText.getText().toString());
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaChromeClient.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsPromptResult.cancel();
            }
        });
        this.lastHandledDialog = builder.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        this.mRequest = permissionRequest;
        if (Build.VERSION.SDK_INT < 23) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        String[] resources = permissionRequest.getResources();
        if (resources == null || resources.length != 1 || resources[0] != "android.webkit.resource.AUDIO_CAPTURE") {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        PermissionDialogView.a aVar = new PermissionDialogView.a();
        CordovaWebView cordovaWebView = this.appView;
        aVar.f12022a = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        aVar.b = "android.permission.RECORD_AUDIO";
        aVar.c = "获取该权限，以确保您功能正常使用";
        w43.e(this.cordova.getActivity(), aVar, new a.b() { // from class: org.apache.cordova.CordovaChromeClient.15
            @Override // com.zenmen.openapi.auth.widget.a.b
            @RequiresApi(api = 23)
            public void onConfirmback(int i) {
                if (i != 0) {
                    CordovaChromeClient.super.onPermissionRequest(permissionRequest);
                } else if (CordovaChromeClient.this.cordova.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") == 0 && CordovaChromeClient.this.cordova.getActivity().checkSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") == 0) {
                    permissionRequest.grant(new String[]{"android.webkit.resource.AUDIO_CAPTURE"});
                } else {
                    CordovaChromeClient.this.cordova.getActivity().requestPermissions(new String[]{"android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS"}, CordovaChromeClient.AUDIO_PERMISSION_REQUEST_CODE);
                }
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.appView.showCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String str;
        String str2;
        final ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: org.apache.cordova.CordovaChromeClient.11
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Uri[] uriArr) {
                FileSelectHelper.onFileSelected(uriArr);
                valueCallback.onReceiveValue(uriArr);
            }
        };
        try {
            if (fileChooserParams.isCaptureEnabled()) {
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                String lowerCase = "";
                if (acceptTypes != null && acceptTypes.length > 0 && (str2 = acceptTypes[0]) != null) {
                    lowerCase = str2.toLowerCase();
                }
                Intent intent = new Intent();
                if (lowerCase.startsWith("image/")) {
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    str = System.currentTimeMillis() + ".jpg";
                } else {
                    if (!lowerCase.startsWith("video/")) {
                        valueCallback2.onReceiveValue(null);
                        return true;
                    }
                    intent.setAction("android.media.action.VIDEO_CAPTURE");
                    str = System.currentTimeMillis() + ".mp4";
                }
                final Uri uriForFile = FileProvider.getUriForFile(this.cordova.getActivity(), "com.zenmen.palmchat.cordovalib.file.provider", new File(webView.getContext().getExternalCacheDir(), str));
                intent.putExtra("output", uriForFile);
                if (Build.VERSION.SDK_INT < 23 || this.cordova.getActivity().checkSelfPermission("android.permission.CAMERA") == 0) {
                    this.cordova.startActivityForResult(new CordovaPlugin() { // from class: org.apache.cordova.CordovaChromeClient.12
                        @Override // org.apache.cordova.CordovaPlugin
                        public void onActivityResult(int i, int i2, Intent intent2) {
                            if (i2 != -1) {
                                valueCallback2.onReceiveValue(null);
                                return;
                            }
                            LOG.d(CordovaChromeClient.this.TAG, "Receive file chooser URL: " + uriForFile);
                            valueCallback2.onReceiveValue(new Uri[]{uriForFile});
                        }
                    }, intent, FILECHOOSER_RESULTCODE);
                } else {
                    this.mCameraIntent = intent;
                    this.mFilePathsCallback = valueCallback2;
                    this.cordova.getActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, CAMERA_PERMISSION_REQUEST_CODE);
                }
            } else {
                this.cordova.startActivityForResult(new CordovaPlugin() { // from class: org.apache.cordova.CordovaChromeClient.13
                    @Override // org.apache.cordova.CordovaPlugin
                    public void onActivityResult(int i, int i2, Intent intent2) {
                        Uri[] result = WebChromeClient.FileChooserParams.parseResult(i2, intent2);
                        Log.d(CordovaChromeClient.this.TAG, "Receive file chooser URL: " + result);
                        valueCallback2.onReceiveValue(result);
                    }
                }, fileChooserParams.createIntent(), FILECHOOSER_RESULTCODE);
            }
        } catch (ActivityNotFoundException e) {
            Log.w(this.TAG, "No activity found to handle file chooser intent.", e);
            valueCallback2.onReceiveValue(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            valueCallback2.onReceiveValue(null);
        }
        return true;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, "*/*");
    }

    @Deprecated
    public void setWebView(CordovaWebView cordovaWebView) {
        this.appView = cordovaWebView;
    }

    public void showCamera() {
        Intent intent = this.mCameraIntent;
        if (intent == null || this.mFilePathsCallback == null) {
            return;
        }
        final Uri uri = (Uri) intent.getParcelableExtra("output");
        this.cordova.startActivityForResult(new CordovaPlugin() { // from class: org.apache.cordova.CordovaChromeClient.14
            @Override // org.apache.cordova.CordovaPlugin
            public void onActivityResult(int i, int i2, Intent intent2) {
                if (i2 == -1) {
                    LOG.d(CordovaChromeClient.this.TAG, "Receive file chooser URL: " + uri);
                    CordovaChromeClient.this.mFilePathsCallback.onReceiveValue(new Uri[]{uri});
                } else {
                    CordovaChromeClient.this.mFilePathsCallback.onReceiveValue(null);
                }
                CordovaChromeClient.this.mFilePathsCallback = null;
                CordovaChromeClient.this.mCameraIntent = null;
            }
        }, this.mCameraIntent, FILECHOOSER_RESULTCODE);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(8)
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.message() != null) {
            LOG.d(this.TAG, "%s: Line %d : %s", consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback, String str, String str2) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.cordova.startActivityForResult(new CordovaPlugin() { // from class: org.apache.cordova.CordovaChromeClient.10
            @Override // org.apache.cordova.CordovaPlugin
            public void onActivityResult(int i, int i2, Intent intent2) {
                Uri data = (intent2 == null || i2 != -1) ? null : intent2.getData();
                Log.d(CordovaChromeClient.this.TAG, "Receive file chooser URL: " + data);
                valueCallback.onReceiveValue(data);
            }
        }, intent, FILECHOOSER_RESULTCODE);
    }

    public CordovaChromeClient(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        this.cordova = cordovaInterface;
        this.appView = cordovaWebView;
    }
}
