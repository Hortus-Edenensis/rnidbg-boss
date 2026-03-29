package org.apache.cordova;

import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import com.igexin.push.core.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.cordova.PluginResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class NativeToJsMessageQueue {
    static final boolean DISABLE_EXEC_CHAINING = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private static int MAX_PAYLOAD_SIZE = 524288000;
    private BridgeMode activeBridgeMode;
    private final CordovaInterface cordova;
    private boolean paused;
    private final LinkedList<JsMessage> queue = new LinkedList<>();
    private final BridgeMode[] registeredListeners = {new PollingBridgeMode(), new LoadUrlBridgeMode(), new OnlineEventsBridgeMode(), new PrivateApiBridgeMode()};
    private final CordovaWebView webView;

    /* JADX INFO: compiled from: SearchBox */
    public abstract class BridgeMode {
        public abstract void onNativeToJsMessageAvailable();

        private BridgeMode() {
        }

        public void reset() {
        }

        public void notifyOfFlush(boolean z) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class LoadUrlBridgeMode extends BridgeMode {
        final Runnable runnable;

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
        }

        private LoadUrlBridgeMode() {
            super();
            this.runnable = new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.LoadUrlBridgeMode.1
                @Override // java.lang.Runnable
                public void run() {
                    String strPopAndEncodeAsJs = NativeToJsMessageQueue.this.popAndEncodeAsJs();
                    if (strPopAndEncodeAsJs != null) {
                        NativeToJsMessageQueue.this.webView.loadUrlNow("javascript:" + strPopAndEncodeAsJs);
                    }
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class OnlineEventsBridgeMode extends BridgeMode {
        private boolean ignoreNextFlush;
        private boolean online;
        final Runnable resetNetworkRunnable;
        final Runnable toggleNetworkRunnable;

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void notifyOfFlush(boolean z) {
            if (!z || this.ignoreNextFlush) {
                return;
            }
            this.online = !this.online;
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable() {
            if (NativeToJsMessageQueue.this.cordova.getActivity() != null) {
                NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.toggleNetworkRunnable);
            }
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void reset() {
            if (NativeToJsMessageQueue.this.cordova.getActivity() != null) {
                NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.resetNetworkRunnable);
            }
        }

        private OnlineEventsBridgeMode() {
            super();
            this.toggleNetworkRunnable = new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.OnlineEventsBridgeMode.1
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeToJsMessageQueue.this.queue.isEmpty()) {
                        return;
                    }
                    OnlineEventsBridgeMode.this.ignoreNextFlush = false;
                    NativeToJsMessageQueue.this.webView.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                }
            };
            this.resetNetworkRunnable = new Runnable() { // from class: org.apache.cordova.NativeToJsMessageQueue.OnlineEventsBridgeMode.2
                @Override // java.lang.Runnable
                public void run() {
                    OnlineEventsBridgeMode.this.online = false;
                    OnlineEventsBridgeMode.this.ignoreNextFlush = true;
                    NativeToJsMessageQueue.this.webView.setNetworkAvailable(true);
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class PollingBridgeMode extends BridgeMode {
        private PollingBridgeMode() {
            super();
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class PrivateApiBridgeMode extends BridgeMode {
        private static final int EXECUTE_JS = 194;
        boolean initFailed;
        Method sendMessageMethod;
        Object webViewCore;

        private void initReflection() {
            Object obj = NativeToJsMessageQueue.this.webView;
            Class<?> cls = WebView.class;
            try {
                Field declaredField = cls.getDeclaredField("mProvider");
                declaredField.setAccessible(true);
                obj = declaredField.get(NativeToJsMessageQueue.this.webView);
                cls = obj.getClass();
            } catch (Throwable unused) {
            }
            try {
                Field declaredField2 = cls.getDeclaredField("mWebViewCore");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                this.webViewCore = obj2;
                if (obj2 != null) {
                    Method declaredMethod = obj2.getClass().getDeclaredMethod("sendMessage", Message.class);
                    this.sendMessageMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
            } catch (Throwable th) {
                this.initFailed = true;
                Log.e(NativeToJsMessageQueue.LOG_TAG, "PrivateApiBridgeMode failed to find the expected APIs.", th);
            }
        }

        @Override // org.apache.cordova.NativeToJsMessageQueue.BridgeMode
        public void onNativeToJsMessageAvailable() {
            if (this.sendMessageMethod == null && !this.initFailed) {
                initReflection();
            }
            if (this.sendMessageMethod != null) {
                try {
                    this.sendMessageMethod.invoke(this.webViewCore, Message.obtain(null, 194, NativeToJsMessageQueue.this.popAndEncodeAsJs()));
                } catch (Throwable th) {
                    Log.e(NativeToJsMessageQueue.LOG_TAG, "Reflection message bridge failed.", th);
                }
            }
        }

        private PrivateApiBridgeMode() {
            super();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeToJsMessageQueue(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface) {
        this.cordova = cordovaInterface;
        this.webView = cordovaWebView;
        reset();
    }

    private int calculatePackedMessageLength(JsMessage jsMessage) {
        int iCalculateEncodedLength = jsMessage.calculateEncodedLength();
        return String.valueOf(iCalculateEncodedLength).length() + iCalculateEncodedLength + 1;
    }

    private void enqueueMessage(JsMessage jsMessage) {
        synchronized (this) {
            if (this.activeBridgeMode == null) {
                Log.d(LOG_TAG, "Dropping Native->JS message due to disabled bridge");
                return;
            }
            this.queue.add(jsMessage);
            if (!this.paused) {
                this.activeBridgeMode.onNativeToJsMessageAvailable();
            }
        }
    }

    private void packMessage(JsMessage jsMessage, StringBuilder sb) {
        sb.append(jsMessage.calculateEncodedLength());
        sb.append(' ');
        jsMessage.encodeAsMessage(sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String popAndEncodeAsJs() {
        synchronized (this) {
            if (this.queue.size() == 0) {
                return null;
            }
            Iterator<JsMessage> it = this.queue.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                int iCalculateEncodedLength = it.next().calculateEncodedLength() + 50;
                if (i > 0) {
                    int i3 = i2 + iCalculateEncodedLength;
                    int i4 = MAX_PAYLOAD_SIZE;
                    if (i3 > i4 && i4 > 0) {
                        break;
                    }
                }
                i2 += iCalculateEncodedLength;
                i++;
            }
            int i5 = i == this.queue.size() ? 1 : 0;
            StringBuilder sb = new StringBuilder(i2 + (i5 != 0 ? 0 : 100));
            for (int i6 = 0; i6 < i; i6++) {
                JsMessage jsMessageRemoveFirst = this.queue.removeFirst();
                if (i5 == 0 || i6 + 1 != i) {
                    sb.append("try{");
                    jsMessageRemoveFirst.encodeAsJsMessage(sb);
                    sb.append("}finally{");
                } else {
                    jsMessageRemoveFirst.encodeAsJsMessage(sb);
                }
            }
            if (i5 == 0) {
                sb.append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
            }
            while (i5 < i) {
                sb.append('}');
                i5++;
            }
            return sb.toString();
        }
    }

    public void addJavaScript(String str) {
        enqueueMessage(new JsMessage(str));
    }

    public void addPluginResult(PluginResult pluginResult, String str) {
        if (str == null) {
            Log.e(LOG_TAG, "Got plugin result with no callbackId", new Throwable());
            return;
        }
        boolean z = pluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal();
        boolean keepCallback = pluginResult.getKeepCallback();
        if (z && keepCallback) {
            return;
        }
        enqueueMessage(new JsMessage(pluginResult, str));
    }

    public boolean isBridgeEnabled() {
        return this.activeBridgeMode != null;
    }

    public String popAndEncode(boolean z) {
        synchronized (this) {
            BridgeMode bridgeMode = this.activeBridgeMode;
            if (bridgeMode == null) {
                return null;
            }
            bridgeMode.notifyOfFlush(z);
            if (this.queue.isEmpty()) {
                return null;
            }
            Iterator<JsMessage> it = this.queue.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                int iCalculatePackedMessageLength = calculatePackedMessageLength(it.next());
                if (i > 0) {
                    int i3 = i2 + iCalculatePackedMessageLength;
                    int i4 = MAX_PAYLOAD_SIZE;
                    if (i3 > i4 && i4 > 0) {
                        break;
                    }
                }
                i2 += iCalculatePackedMessageLength;
                i++;
            }
            StringBuilder sb = new StringBuilder(i2);
            for (int i5 = 0; i5 < i; i5++) {
                packMessage(this.queue.removeFirst(), sb);
            }
            if (!this.queue.isEmpty()) {
                sb.append('*');
            }
            return sb.toString();
        }
    }

    public void reset() {
        synchronized (this) {
            this.queue.clear();
            setBridgeMode(-1);
        }
    }

    public void setBridgeMode(int i) {
        if (i >= -1) {
            BridgeMode[] bridgeModeArr = this.registeredListeners;
            if (i < bridgeModeArr.length) {
                BridgeMode bridgeMode = i < 0 ? null : bridgeModeArr[i];
                if (bridgeMode != this.activeBridgeMode) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Set native->JS mode to ");
                    sb.append(bridgeMode == null ? b.m : bridgeMode.getClass().getSimpleName());
                    Log.d(LOG_TAG, sb.toString());
                    synchronized (this) {
                        this.activeBridgeMode = bridgeMode;
                        if (bridgeMode != null) {
                            bridgeMode.reset();
                            if (!this.paused && !this.queue.isEmpty()) {
                                bridgeMode.onNativeToJsMessageAvailable();
                            }
                        }
                    }
                    return;
                }
                return;
            }
        }
        Log.d(LOG_TAG, "Invalid NativeToJsBridgeMode: " + i);
    }

    public void setPaused(boolean z) {
        BridgeMode bridgeMode;
        if (this.paused && z) {
            Log.e(LOG_TAG, "nested call to setPaused detected.", new Throwable());
        }
        this.paused = z;
        if (z) {
            return;
        }
        synchronized (this) {
            if (!this.queue.isEmpty() && (bridgeMode = this.activeBridgeMode) != null) {
                bridgeMode.onNativeToJsMessageAvailable();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class JsMessage {
        final String jsPayloadOrCallbackId;
        final PluginResult pluginResult;

        public JsMessage(String str) {
            str.getClass();
            this.jsPayloadOrCallbackId = str;
            this.pluginResult = null;
        }

        public static int calculateEncodedLengthHelper(PluginResult pluginResult) {
            switch (pluginResult.getMessageType()) {
                case 1:
                    return pluginResult.getStrMessage().length() + 1;
                case 2:
                default:
                    return pluginResult.getMessage().length();
                case 3:
                    return pluginResult.getMessage().length() + 1;
                case 4:
                case 5:
                    return 1;
                case 6:
                    return pluginResult.getMessage().length() + 1;
                case 7:
                    return pluginResult.getMessage().length() + 1;
                case 8:
                    int length = 1;
                    for (int i = 0; i < pluginResult.getMultipartMessagesSize(); i++) {
                        int iCalculateEncodedLengthHelper = calculateEncodedLengthHelper(pluginResult.getMultipartMessage(i));
                        length += String.valueOf(iCalculateEncodedLengthHelper).length() + 1 + iCalculateEncodedLengthHelper;
                    }
                    return length;
            }
        }

        public static void encodeAsMessageHelper(StringBuilder sb, PluginResult pluginResult) {
            switch (pluginResult.getMessageType()) {
                case 1:
                    sb.append('s');
                    sb.append(pluginResult.getStrMessage());
                    break;
                case 2:
                default:
                    sb.append(pluginResult.getMessage());
                    break;
                case 3:
                    sb.append('n');
                    sb.append(pluginResult.getMessage());
                    break;
                case 4:
                    sb.append(pluginResult.getMessage().charAt(0));
                    break;
                case 5:
                    sb.append('N');
                    break;
                case 6:
                    sb.append('A');
                    sb.append(pluginResult.getMessage());
                    break;
                case 7:
                    sb.append('S');
                    sb.append(pluginResult.getMessage());
                    break;
                case 8:
                    sb.append('M');
                    for (int i = 0; i < pluginResult.getMultipartMessagesSize(); i++) {
                        PluginResult multipartMessage = pluginResult.getMultipartMessage(i);
                        sb.append(String.valueOf(calculateEncodedLengthHelper(multipartMessage)));
                        sb.append(' ');
                        encodeAsMessageHelper(sb, multipartMessage);
                    }
                    break;
            }
        }

        public int calculateEncodedLength() {
            PluginResult pluginResult = this.pluginResult;
            return pluginResult == null ? this.jsPayloadOrCallbackId.length() + 1 : String.valueOf(pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1 + calculateEncodedLengthHelper(this.pluginResult);
        }

        public void encodeAsJsMessage(StringBuilder sb) {
            PluginResult pluginResult = this.pluginResult;
            if (pluginResult == null) {
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = pluginResult.getStatus();
            boolean z = status == PluginResult.Status.OK.ordinal() || status == PluginResult.Status.NO_RESULT.ordinal();
            sb.append("cordova.callbackFromNative('");
            sb.append(this.jsPayloadOrCallbackId);
            sb.append("',");
            sb.append(z);
            sb.append(",");
            sb.append(status);
            sb.append(",[");
            int messageType = this.pluginResult.getMessageType();
            if (messageType == 6) {
                sb.append("cordova.require('cordova/base64').toArrayBuffer('");
                sb.append(this.pluginResult.getMessage());
                sb.append("')");
            } else if (messageType != 7) {
                sb.append(this.pluginResult.getMessage());
            } else {
                sb.append("atob('");
                sb.append(this.pluginResult.getMessage());
                sb.append("')");
            }
            sb.append("],");
            sb.append(this.pluginResult.getKeepCallback());
            sb.append(");");
        }

        public void encodeAsMessage(StringBuilder sb) {
            PluginResult pluginResult = this.pluginResult;
            if (pluginResult == null) {
                sb.append('J');
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = pluginResult.getStatus();
            boolean z = status == PluginResult.Status.NO_RESULT.ordinal();
            boolean z2 = status == PluginResult.Status.OK.ordinal();
            boolean keepCallback = this.pluginResult.getKeepCallback();
            sb.append((z || z2) ? 'S' : 'F');
            sb.append(keepCallback ? '1' : '0');
            sb.append(status);
            sb.append(' ');
            sb.append(this.jsPayloadOrCallbackId);
            sb.append(' ');
            encodeAsMessageHelper(sb, this.pluginResult);
        }

        public JsMessage(PluginResult pluginResult, String str) {
            if (str != null && pluginResult != null) {
                this.jsPayloadOrCallbackId = str;
                this.pluginResult = pluginResult;
                return;
            }
            throw null;
        }
    }
}
