package com.ss.bytertc.audio.device.router;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.location.LocationConst;
import com.bytedance.realx.base.RXLogging;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.huawei.openalliance.ad.constant.x;
import defpackage.wl;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioRouteDeviceManager extends BroadcastReceiver {
    private static final String ACTION_BT_A2DP_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    private static final String ACTION_BT_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    private static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    private static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    private static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_MAX_RETRY_TIMES = 3;
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_TIME_GAP = 3000;
    private static final int BLUETOOTH_SCO_DISCONNECT_CHECK_TIME_GAP = 6000;
    private static final int BLUETOOTH_SCO_RESTART_MAX_TIMES = 3;
    private static final int BLUETOOTH_SCO_RESTART_TIME_GAP = 3000;
    private static final String TAG = "AudioRouteDeviceManager";
    private BluetoothAdapter mBluetoothAdapter;
    private MyBluetoothDevice mBluetoothDevice;
    private AudioDeviceCallback mBluetoothDeviceCallback;
    private IAudioRouteCallback mCallback;
    private Handler mHandler;
    private IntentFilter mIntentFilter;
    private UsbDevice mUsbHeadsetDevice;
    private String mWiredHeadsetDevice;
    private volatile boolean registered = false;
    private int mInitDeviceState = 0;
    private int mBluetoothScoConnectCheckTimes = -1;
    private int mBluetoothScoRestartTimes = 0;
    private boolean mScoHasStarted = false;
    private String mBluetoothPermissionDesp = "NULL";

    @RoutingDeviceType
    private int currentRouting = -1;
    private boolean mEnableSkipBluetoothConnectPermission = false;
    private boolean mSkipBluetoothConnectPermission = false;

    /* JADX INFO: compiled from: SearchBox */
    public class BluetoothConnectCallback extends AudioDeviceCallback {
        private BluetoothConnectCallback() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                if (!audioDeviceInfo.isSource()) {
                    int type = audioDeviceInfo.getType();
                    if (type == 7 && AudioRouteDeviceManager.this.mCallback != null) {
                        RXLogging.i(AudioRouteDeviceManager.TAG, "addedDevices: " + type + ", name: " + audioDeviceInfo.getProductName().toString());
                        if (AudioRouteDeviceManager.this.mBluetoothDevice == null) {
                            AudioRouteDeviceManager audioRouteDeviceManager = AudioRouteDeviceManager.this;
                            audioRouteDeviceManager.mBluetoothDevice = audioRouteDeviceManager.new MyBluetoothDevice("bluetooth-headset");
                        }
                        AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(1, true);
                        AudioRouteDeviceManager audioRouteDeviceManager2 = AudioRouteDeviceManager.this;
                        audioRouteDeviceManager2.mBluetoothDevice = audioRouteDeviceManager2.new MyBluetoothDevice("bluetooth-headset");
                        AudioRouteDeviceManager.this.mBluetoothScoRestartTimes = 0;
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(8, true);
                    } else if (type == 8 && AudioRouteDeviceManager.this.mCallback != null) {
                        RXLogging.i(AudioRouteDeviceManager.TAG, "addedDevices: " + type + ", name: " + audioDeviceInfo.getProductName().toString());
                        if (AudioRouteDeviceManager.this.mBluetoothDevice == null) {
                            AudioRouteDeviceManager audioRouteDeviceManager3 = AudioRouteDeviceManager.this;
                            audioRouteDeviceManager3.mBluetoothDevice = audioRouteDeviceManager3.new MyBluetoothDevice("bluetooth-headset");
                        }
                        AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(2, true);
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(16, true);
                    }
                }
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                if (!audioDeviceInfo.isSource()) {
                    int type = audioDeviceInfo.getType();
                    if (type == 7 && AudioRouteDeviceManager.this.mCallback != null) {
                        RXLogging.i(AudioRouteDeviceManager.TAG, "removedDevices: " + type + ", name: " + ((Object) audioDeviceInfo.getProductName()));
                        if (AudioRouteDeviceManager.this.mBluetoothDevice != null) {
                            AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(1, false);
                            if (!AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(1) && !AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(2)) {
                                RXLogging.i(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");
                                AudioRouteDeviceManager.this.mBluetoothDevice = null;
                            }
                        }
                        AudioRouteDeviceManager.this.mBluetoothDevice = null;
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(8, false);
                        return;
                    }
                    if (type == 8 && AudioRouteDeviceManager.this.mCallback != null) {
                        RXLogging.i(AudioRouteDeviceManager.TAG, "removedDevices: " + type + ", name: " + ((Object) audioDeviceInfo.getProductName()));
                        if (AudioRouteDeviceManager.this.mBluetoothDevice != null) {
                            AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(2, false);
                            if (!AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(1) && !AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(2)) {
                                RXLogging.i(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");
                                AudioRouteDeviceManager.this.mBluetoothDevice = null;
                            }
                        }
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(16, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public @interface RoutingDeviceType {
        public static final int BLUETOOTH_A2DP = 16;
        public static final int BLUETOOTH_HEADSET = 8;
        public static final int BLUETOOTH_SCO = 64;
        public static final int BUILT_IN_EARPIECE = 1;
        public static final int BUILT_IN_SPEAKER = 2;
        public static final int UNKNOWN = -1;
        public static final int USB_HEADSET = 32;
        public static final int WIRED_HEADSET = 4;
    }

    public AudioRouteDeviceManager(IAudioRouteCallback iAudioRouteCallback) {
        this.mCallback = iAudioRouteCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bluetoothScoConnectionCheck() {
        if (this.mCallback == null) {
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. AudioManager is null.");
            return;
        }
        if (this.mBluetoothScoConnectCheckTimes >= 3) {
            if (this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            RXLogging.e(TAG, "bluetoothScoConnectionCheck timeout, time: " + this.mBluetoothScoConnectCheckTimes);
            this.mBluetoothScoConnectCheckTimes = -1;
            this.mHandler.removeCallbacks(new wl(this));
            this.mCallback.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco started timeout");
            return;
        }
        if (audioManager.isBluetoothScoOn()) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck success.");
            this.mBluetoothScoConnectCheckTimes = -1;
            this.mHandler.removeCallbacks(new wl(this));
            return;
        }
        this.mBluetoothScoConnectCheckTimes++;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. retry again, time: " + this.mBluetoothScoConnectCheckTimes);
        startSystemBluetoothSco(audioManager);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new wl(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bluetoothScoDisconnectionForNormalMode() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. AudioManager is null.");
            return;
        }
        int mode = audioManager.getMode();
        boolean zIsBluetoothScoOn = audioManager.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode mode(" + mode + "), bluetoothScoOn(" + zIsBluetoothScoOn + ")");
        if (mode == 0) {
            if (zIsBluetoothScoOn || this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
        }
    }

    private boolean bluetoothScoIsStarting() {
        return this.mHandler != null && this.mBluetoothScoConnectCheckTimes >= 0;
    }

    @SuppressLint({"WrongConstant"})
    private boolean checkPermission() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (i < 31 || i2 < 31) {
            if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") != 0) {
                String str = "[permission android.permission.BLUETOOTH not be granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
                this.mBluetoothPermissionDesp = str;
                RXLogging.e(TAG, str);
                return false;
            }
            String str2 = "[permission android.permission.BLUETOOTH granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
            this.mBluetoothPermissionDesp = str2;
            RXLogging.i(TAG, str2);
            return true;
        }
        if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
            String str3 = "[permission android.permission.BLUETOOTH_CONNECT granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
            this.mBluetoothPermissionDesp = str3;
            RXLogging.i(TAG, str3);
            return true;
        }
        this.mSkipBluetoothConnectPermission = this.mEnableSkipBluetoothConnectPermission;
        String str4 = "[permission android.permission.BLUETOOTH_CONNECT not be granted. osVersion:" + i + ", targetVersion:" + i2 + ", EnableSkipBluetoothConnectBroadcast:" + this.mEnableSkipBluetoothConnectPermission + " ]";
        this.mBluetoothPermissionDesp = str4;
        RXLogging.e(TAG, str4);
        return false;
    }

    private boolean hasAudioForUsbDevice(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        for (int i = 0; i < usbDevice.getConfigurationCount(); i++) {
            UsbConfiguration configuration = usbDevice.getConfiguration(i);
            if (configuration != null) {
                for (int i2 = 0; i2 < configuration.getInterfaceCount(); i2++) {
                    UsbInterface usbInterface = configuration.getInterface(i2);
                    if (usbInterface != null && usbInterface.getInterfaceClass() == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean headsetPlugActionIsFromUsbHeadset(Intent intent) {
        String stringExtra = intent.getStringExtra("address");
        String stringExtra2 = intent.getStringExtra("portName");
        RXLogging.i(TAG, "ACTION_HEADSET_PLUG info, address: " + stringExtra + ", portName: " + stringExtra2 + ", connected: " + intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, -99) + ", hasMic: " + intent.getIntExtra("microphone", -99));
        if ("".equals(stringExtra) || "".equals(stringExtra2) || stringExtra2 == null) {
            return false;
        }
        if (!stringExtra2.startsWith("USB") && !stringExtra2.startsWith("usb")) {
            return false;
        }
        RXLogging.e(TAG, "AudioRouteDeviceManager: received ACTION_HEADSET_PLUG, may be is a usb device");
        return true;
    }

    private void initBluetooth() {
        boolean z;
        this.mBluetoothDevice = null;
        boolean z2 = false;
        if (checkPermission()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.mBluetoothAdapter = defaultAdapter;
            if (defaultAdapter == null) {
                Log.e(TAG, "AudioRouteDeviceManager: initBluetooth with permission failed. GetDefaultAdapter is null");
                return;
            }
            boolean z3 = 2 == defaultAdapter.getProfileConnectionState(1);
            boolean z4 = 2 == this.mBluetoothAdapter.getProfileConnectionState(2);
            Log.i(TAG, "initBluetooth() with bluetooth-connect broadcast. headset_connected:" + z3 + " a2dp_connected:" + z4);
            this.mIntentFilter.addAction(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED);
            this.mIntentFilter.addAction(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED);
            this.mIntentFilter.addAction(ACTION_BT_SCO_AUDIO_STATE_UPDATED);
            z = z4;
            z2 = z3;
        } else if (this.mSkipBluetoothConnectPermission) {
            Context context = AudioRouteUtil.getContext();
            if (context == null) {
                Log.e(TAG, "AudioRouteDeviceManager: initBluetooth without permission failed. Context is null.");
                return;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                Log.e(TAG, "AudioRouteDeviceManager: initBluetooth without permission failed. AudioManager is null.");
                return;
            }
            Log.i(TAG, "initBluetooth() with no bluetooth-connect permision.");
            boolean z5 = false;
            z = false;
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                if (!audioDeviceInfo.isSource()) {
                    if (7 == audioDeviceInfo.getType()) {
                        z5 = true;
                    } else if (8 == audioDeviceInfo.getType()) {
                        z = true;
                    }
                }
            }
            z2 = z5;
        } else {
            z = false;
        }
        if (z2 || z) {
            MyBluetoothDevice myBluetoothDevice = new MyBluetoothDevice("bluetooth-headset[init]");
            this.mBluetoothDevice = myBluetoothDevice;
            myBluetoothDevice.setBluetoothConnected(1, z2);
            this.mBluetoothDevice.setBluetoothConnected(2, z);
        }
    }

    private void initHandler() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null && (looperMyLooper = Looper.getMainLooper()) == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler failed");
            return;
        }
        Handler handler = new Handler(looperMyLooper);
        this.mHandler = handler;
        handler.removeCallbacks(new wl(this));
        RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler success");
    }

    private boolean initHeadset() {
        Intent intentRegisterReceiver;
        Context context = AudioRouteUtil.getContext();
        return (context == null || (intentRegisterReceiver = context.registerReceiver(this, new IntentFilter(ACTION_HEADSET_PLUG))) == null || headsetPlugActionIsFromUsbHeadset(intentRegisterReceiver) || 1 != intentRegisterReceiver.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, -99)) ? false : true;
    }

    private boolean initUsbHeadset() {
        try {
            Context context = AudioRouteUtil.getContext();
            if (context == null) {
                return false;
            }
            HashMap<String, UsbDevice> deviceList = ((UsbManager) context.getSystemService("usb")).getDeviceList();
            Iterator<String> it = deviceList.keySet().iterator();
            while (it.hasNext()) {
                UsbDevice usbDevice = deviceList.get(it.next());
                if (hasAudioForUsbDevice(usbDevice)) {
                    this.mUsbHeadsetDevice = usbDevice;
                    RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset finished.");
                    return true;
                }
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset failed.", th);
        }
        return false;
    }

    private int registerReceiver() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return -1;
        }
        if (this.registered) {
            return 0;
        }
        this.registered = true;
        context.registerReceiver(this, this.mIntentFilter);
        if (this.mSkipBluetoothConnectPermission) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return -2;
            }
            BluetoothConnectCallback bluetoothConnectCallback = new BluetoothConnectCallback();
            this.mBluetoothDeviceCallback = bluetoothConnectCallback;
            audioManager.registerAudioDeviceCallback(bluetoothConnectCallback, null);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartBluetoothScoAsynTask() {
        RXLogging.w(TAG, "restartBluetoothScoAsynTask enter.");
        if (!(this.mBluetoothDevice != null)) {
            RXLogging.w(TAG, "restartBluetoothScoAsynTask skip, no bluetooth device now.");
            return;
        }
        if (bluetoothScoIsStarting()) {
            RXLogging.w(TAG, "restartBluetoothScoAsynTask skip. sco is starting.");
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "restartBluetoothScoAsynTask failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            RXLogging.e(TAG, "restartBluetoothScoAsynTask failed. AudioManager is null.");
        } else {
            startSystemBluetoothSco(audioManager);
            RXLogging.w(TAG, "restartBluetoothScoAsynTask has start bluetooth.");
        }
    }

    private void startSystemBluetoothSco(AudioManager audioManager) {
        if (audioManager == null) {
            RXLogging.e(TAG, "startSystemBluetoothSco skipped, audioManager is null");
            return;
        }
        try {
            audioManager.startBluetoothSco();
            this.mScoHasStarted = true;
        } catch (Exception e) {
            RXLogging.e(TAG, "startSystemBluetoothSco failed, Exception: " + e.toString());
        }
    }

    private void stopSystemBluetoothSco(AudioManager audioManager) {
        if (audioManager == null) {
            RXLogging.e(TAG, "stopSystemBluetoothSco skipped, audioManager is null");
            return;
        }
        try {
            audioManager.stopBluetoothSco();
            audioManager.setBluetoothScoOn(false);
            this.mScoHasStarted = false;
        } catch (Exception e) {
            RXLogging.e(TAG, "stopSystemBluetoothSco failed, Exception: " + e.toString());
        }
    }

    private int unregisterReceiver() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return -1;
        }
        if (!this.registered) {
            return 0;
        }
        this.registered = false;
        context.unregisterReceiver(this);
        clearAbortBroadcast();
        if (this.mSkipBluetoothConnectPermission) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return -2;
            }
            audioManager.unregisterAudioDeviceCallback(this.mBluetoothDeviceCallback);
            this.mBluetoothDeviceCallback = null;
        }
        return 0;
    }

    public String getCaptureDeviceName() {
        return getRenderDeviceName();
    }

    public int getDeviceState() {
        return this.mInitDeviceState;
    }

    public String getRenderDeviceName() {
        int i = this.currentRouting;
        if (i == 1) {
            return "earpiece";
        }
        if (i == 2) {
            return "built-in speaker";
        }
        if (i == 4) {
            String str = this.mWiredHeadsetDevice;
            return str != null ? str : "failed_wired-headset";
        }
        if (i == 8) {
            MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
            return myBluetoothDevice != null ? myBluetoothDevice.getName() : "failed_bluetooth-headset";
        }
        if (i == 16) {
            MyBluetoothDevice myBluetoothDevice2 = this.mBluetoothDevice;
            return myBluetoothDevice2 != null ? myBluetoothDevice2.getName() : "failed_bluetooth-a2dp";
        }
        if (i != 32) {
            return "failed_device_name";
        }
        UsbDevice usbDevice = this.mUsbHeadsetDevice;
        return usbDevice != null ? usbDevice.getDeviceName() : "failed_usb-headset";
    }

    public String getSessionInfo() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return "Context is null";
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return "AudioManager is null";
        }
        if (this.mCallback == null) {
            return "mCallback is null";
        }
        try {
            return "{ Audio State: audio_mode:" + AudioRouteUtil.modeString(audioManager.getMode()) + ", has_mic:" + context.getPackageManager().hasSystemFeature("android.hardware.microphone") + ", mic_muted:" + audioManager.isMicrophoneMute() + ", speakerphone:" + audioManager.isSpeakerphoneOn() + ", headset:" + audioManager.isWiredHeadsetOn() + ", bt_sco:" + audioManager.isBluetoothScoOn() + ", permission:" + (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) + ", bluetoothPermission:" + this.mBluetoothPermissionDesp + " }";
        } catch (Exception e) {
            String str = "getSessionInfo failed, exception: " + e.toString();
            RXLogging.e(TAG, str);
            return str;
        }
    }

    public int init() {
        IntentFilter intentFilter = new IntentFilter();
        this.mIntentFilter = intentFilter;
        intentFilter.addAction(ACTION_BT_STATE_CHANGED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_ATTACHED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_DETACHED);
        initHandler();
        if (initHeadset()) {
            this.mInitDeviceState += 4;
        }
        if (initUsbHeadset()) {
            this.mInitDeviceState += 32;
        }
        initBluetooth();
        MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
        if (myBluetoothDevice != null) {
            if (myBluetoothDevice.getBluetoothConnected(1)) {
                this.mInitDeviceState += 8;
            }
            if (this.mBluetoothDevice.getBluetoothConnected(2)) {
                this.mInitDeviceState += 16;
            }
        }
        if (registerReceiver() == 0) {
            return 0;
        }
        Log.e(TAG, "AudioRouteDeviceManager: registerReceiver failed.");
        release();
        return -2;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02d4  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z;
        int intExtra;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        IAudioRouteCallback iAudioRouteCallback;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: action is null");
            return;
        }
        int i = 8;
        if (!action.equals(ACTION_BT_STATE_CHANGED)) {
            if (action.equals(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED)) {
                intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (intExtra == 0) {
                    RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + bluetoothDevice);
                    MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
                    if (myBluetoothDevice != null) {
                        myBluetoothDevice.setBluetoothConnected(1, false);
                        if (!this.mBluetoothDevice.getBluetoothConnected(1) && !this.mBluetoothDevice.getBluetoothConnected(2)) {
                            RXLogging.i(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + bluetoothDevice);
                            this.mBluetoothDevice = null;
                        }
                    }
                    z = false;
                } else if (intExtra != 1) {
                    if (intExtra == 2) {
                        RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + bluetoothDevice);
                        if (bluetoothDevice != null) {
                            if (this.mBluetoothDevice == null) {
                                this.mBluetoothDevice = new MyBluetoothDevice(bluetoothDevice);
                            }
                            this.mBluetoothDevice.setBluetoothConnected(1, true);
                            this.mBluetoothScoRestartTimes = 0;
                            z = true;
                        }
                    } else if (intExtra != 3) {
                        RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED, unknown state: " + intExtra);
                    }
                }
                z2 = true;
            } else if (action.equals(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED)) {
                intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (intExtra != 0) {
                    if (intExtra != 1) {
                        if (intExtra == 2) {
                            RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + bluetoothDevice2);
                            if (bluetoothDevice2 != null) {
                                if (this.mBluetoothDevice == null) {
                                    this.mBluetoothDevice = new MyBluetoothDevice(bluetoothDevice2);
                                }
                                this.mBluetoothDevice.setBluetoothConnected(2, true);
                                this.mBluetoothScoRestartTimes = 0;
                                z = true;
                            }
                        } else if (intExtra != 3) {
                            RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED, unknown state: " + intExtra);
                        }
                    }
                    z = false;
                    z5 = false;
                    z2 = z5;
                    i = 16;
                } else {
                    RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + bluetoothDevice2);
                    MyBluetoothDevice myBluetoothDevice2 = this.mBluetoothDevice;
                    if (myBluetoothDevice2 != null) {
                        myBluetoothDevice2.setBluetoothConnected(2, false);
                        if (!this.mBluetoothDevice.getBluetoothConnected(1) && !this.mBluetoothDevice.getBluetoothConnected(2)) {
                            RXLogging.i(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + bluetoothDevice2);
                            this.mBluetoothDevice = null;
                        }
                    }
                    z = false;
                }
                z5 = true;
                z2 = z5;
                i = 16;
            } else if (action.equals(ACTION_BT_SCO_AUDIO_STATE_UPDATED)) {
                intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                if (intExtra == 0) {
                    RXLogging.i(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_DISCONNECTED");
                    z = false;
                } else if (intExtra != 1) {
                    z = false;
                    z2 = false;
                    i = 64;
                } else {
                    RXLogging.i(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_CONNECTED");
                    z = true;
                }
                z2 = true;
                i = 64;
            } else {
                if (action.equals(ACTION_USB_DEVICE_ATTACHED)) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_ATTACHED:" + usbDevice);
                    if (hasAudioForUsbDevice(usbDevice)) {
                        this.mUsbHeadsetDevice = usbDevice;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z2 = z4;
                    z = true;
                } else if (action.equals(ACTION_USB_DEVICE_DETACHED)) {
                    UsbDevice usbDevice2 = (UsbDevice) intent.getParcelableExtra("device");
                    RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_DETACHED:" + usbDevice2);
                    if (hasAudioForUsbDevice(usbDevice2)) {
                        this.mUsbHeadsetDevice = null;
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = z3;
                    z = false;
                } else if (!action.equals(ACTION_HEADSET_PLUG)) {
                    z = false;
                    intExtra = -1234;
                    z2 = false;
                    i = -1;
                } else {
                    if (headsetPlugActionIsFromUsbHeadset(intent)) {
                        return;
                    }
                    z = intent.getIntExtra(LocationConst.HDYawConst.KEY_HD_YAW_STATE, -99) == 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("AudioRouteDeviceManager: ACTION_HEADSET_PLUG:");
                    sb.append(z ? x.bq : NetworkUtil.NETWORK_CLASS_DISCONNECTED);
                    RXLogging.i(TAG, sb.toString());
                    if (z) {
                        this.mWiredHeadsetDevice = "wired-headset";
                    } else {
                        this.mWiredHeadsetDevice = null;
                    }
                    intExtra = -1234;
                    z2 = true;
                    i = 4;
                }
                intExtra = -1234;
                i = 32;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AudioRouteDeviceManager:received action:");
            sb2.append(action);
            sb2.append(" state:");
            sb2.append(intExtra);
            sb2.append(" needReport:");
            sb2.append(z2);
            sb2.append(", mCallback:");
            sb2.append(this.mCallback != null);
            sb2.append(", deviceType:");
            sb2.append(i);
            sb2.append(", connectedStatus:");
            sb2.append(z);
            RXLogging.i(TAG, sb2.toString());
            if (z2 || (iAudioRouteCallback = this.mCallback) == null) {
            }
            iAudioRouteCallback.onDeviceEvent(i, z);
            return;
        }
        intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -99);
        BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (intExtra == 10) {
            RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_OFF:" + this.mBluetoothDevice);
            IAudioRouteCallback iAudioRouteCallback2 = this.mCallback;
            if (iAudioRouteCallback2 != null) {
                iAudioRouteCallback2.onDeviceEvent(8, false);
                this.mCallback.onDeviceEvent(16, false);
            }
            if (this.mBluetoothDevice != null) {
                RXLogging.i(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to bluetooth adapter is closed: " + bluetoothDevice3);
                this.mBluetoothDevice = null;
                return;
            }
            return;
        }
        if (intExtra == 12) {
            RXLogging.i(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_ON:" + bluetoothDevice3);
        }
        z = false;
        z2 = false;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("AudioRouteDeviceManager:received action:");
        sb22.append(action);
        sb22.append(" state:");
        sb22.append(intExtra);
        sb22.append(" needReport:");
        sb22.append(z2);
        sb22.append(", mCallback:");
        sb22.append(this.mCallback != null);
        sb22.append(", deviceType:");
        sb22.append(i);
        sb22.append(", connectedStatus:");
        sb22.append(z);
        RXLogging.i(TAG, sb22.toString());
        if (z2) {
        }
    }

    public int release() {
        int i;
        AudioManager audioManager;
        this.mCallback = null;
        Context context = AudioRouteUtil.getContext();
        if (context != null && (audioManager = (AudioManager) context.getSystemService("audio")) != null && (audioManager.isBluetoothScoOn() || this.mScoHasStarted)) {
            stopSystemBluetoothSco(audioManager);
        }
        if (unregisterReceiver() != 0) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: unregisterReceiver failed.");
            i = -1;
        } else {
            i = 0;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        this.mBluetoothAdapter = null;
        this.mIntentFilter = null;
        this.mInitDeviceState = 0;
        this.mBluetoothDevice = null;
        this.mUsbHeadsetDevice = null;
        this.mWiredHeadsetDevice = null;
        this.currentRouting = -1;
        this.mEnableSkipBluetoothConnectPermission = false;
        this.mSkipBluetoothConnectPermission = false;
        return i;
    }

    public void restartBluetoothSco() {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 32) {
            RXLogging.w(TAG, "restartBluetoothSco ignored, since android 13 will start bluetooth sco itself after sco disconnected.");
            return;
        }
        RXLogging.w(TAG, "restartBluetoothSco enter.");
        if (!(this.mBluetoothDevice != null)) {
            RXLogging.w(TAG, "restartBluetoothSco skip, no bluetooth device now.");
            this.mHandler.removeCallbacks(new Runnable() { // from class: xl
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21995a.restartBluetoothScoAsynTask();
                }
            });
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "restartBluetoothSco failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            RXLogging.e(TAG, "restartBluetoothSco failed. AudioManager is null.");
            return;
        }
        if (3 != audioManager.getMode()) {
            RXLogging.e(TAG, "restartBluetoothSco failed. Not in communication mode.");
            return;
        }
        if (bluetoothScoIsStarting()) {
            RXLogging.w(TAG, "restartBluetoothSco skip. sco is starting.");
            return;
        }
        int i = this.mBluetoothScoRestartTimes + 1;
        this.mBluetoothScoRestartTimes = i;
        if (i <= 3) {
            RXLogging.w(TAG, "restartBluetoothScoAsynTask, restart time: " + this.mBluetoothScoRestartTimes);
            if (!audioManager.isBluetoothScoOn() && (handler = this.mHandler) != null) {
                handler.postDelayed(new Runnable() { // from class: xl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21995a.restartBluetoothScoAsynTask();
                    }
                }, 3000L);
            }
        } else {
            if (this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            IAudioRouteCallback iAudioRouteCallback = this.mCallback;
            if (iAudioRouteCallback != null) {
                iAudioRouteCallback.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco restart timeout");
            }
        }
        RXLogging.w(TAG, "restartBluetoothSco leave.");
    }

    public int setAudioRoute(@RoutingDeviceType int i, boolean z) {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. Context is null.");
            return -1;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. AudioManager is null.");
            return -2;
        }
        if (this.mCallback == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. mCallback is null.");
            return -6;
        }
        int mode = audioManager.getMode();
        int i2 = z ? 0 : 3;
        if (i2 != mode) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: isMediaMode:" + z + ", cacheMode:" + i2 + ", systemMode: " + mode + " not matched with system!!!");
            audioManager.setMode(i2);
            mode = audioManager.getMode();
        }
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        boolean zIsBluetoothScoOn = audioManager.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute, deviceType: " + i + ", cacheMode:" + i2 + ", systemMode: " + mode + ", speakerPhoneOn: " + zIsSpeakerphoneOn + ", bluetoothScoOn: " + zIsBluetoothScoOn);
        if (mode != 3) {
            if (mode != 0) {
                RXLogging.e(TAG, "AudioRouteDeviceManager: mode(" + mode + ") is not support to setAudioRoute");
                return -4;
            }
            if (zIsBluetoothScoOn || this.mScoHasStarted) {
                RXLogging.w(TAG, "AudioRouteDeviceManager: MODE_NORMAL,but BluetoothScoOn is true, force to close sco.");
                stopSystemBluetoothSco(audioManager);
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(new wl(this));
                this.mHandler.postDelayed(new Runnable() { // from class: vl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21471a.bluetoothScoDisconnectionForNormalMode();
                    }
                }, 6000L);
            }
            if (i == 2) {
                if (!zIsSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(true);
                }
            } else if (i == 1 && zIsSpeakerphoneOn) {
                audioManager.setSpeakerphoneOn(false);
            }
            return 0;
        }
        if (i == 8) {
            boolean zBluetoothScoIsStarting = bluetoothScoIsStarting();
            StringBuilder sb = new StringBuilder();
            sb.append("need to start bluetooth sco in communication mode, sco is starting: ");
            sb.append(zBluetoothScoIsStarting);
            sb.append(zBluetoothScoIsStarting ? ", skip start sco" : ", continue start sco");
            RXLogging.w(TAG, sb.toString());
            if (!zIsBluetoothScoOn && !zBluetoothScoIsStarting) {
                RXLogging.w(TAG, "ready to start sco");
                this.mBluetoothScoConnectCheckTimes = 0;
                startSystemBluetoothSco(audioManager);
                Handler handler2 = this.mHandler;
                if (handler2 != null) {
                    handler2.removeCallbacks(new Runnable() { // from class: vl
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21471a.bluetoothScoDisconnectionForNormalMode();
                        }
                    });
                    this.mHandler.postDelayed(new wl(this), 3000L);
                }
            }
        } else {
            if (zIsBluetoothScoOn || this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            if (i == 2) {
                if (!zIsSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(true);
                }
            } else {
                if (i != 1 && i != 4 && i != 32) {
                    if (i == 16) {
                        RXLogging.e(TAG, "AudioRouteDeviceManager: Error: setAudioRoute to a2dp in communication mode");
                        return -7;
                    }
                    RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. deviceType(" + i + ") invalid.");
                    return -3;
                }
                if (zIsSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(false);
                }
            }
        }
        this.currentRouting = i;
        return 0;
    }

    public void setSkipBluetoothConnectPermissionAbility(boolean z, IAudioRouteCallback iAudioRouteCallback) {
        this.mEnableSkipBluetoothConnectPermission = z;
        this.mCallback = iAudioRouteCallback;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MyBluetoothDevice {
        private BluetoothDevice bluetoothDevice;
        private String name;
        private boolean headsetConnected = false;
        private boolean a2dpConnected = false;

        public MyBluetoothDevice(String str) {
            this.name = str;
        }

        public boolean getBluetoothConnected(int i) {
            if (i == 1) {
                return this.headsetConnected;
            }
            if (i == 2) {
                return this.a2dpConnected;
            }
            return false;
        }

        public String getName() {
            return this.bluetoothDevice == null ? this.name : "bluetooth-headset";
        }

        public void setBluetoothConnected(int i, boolean z) {
            if (i == 1) {
                this.headsetConnected = z;
            } else if (i == 2) {
                this.a2dpConnected = z;
            }
        }

        public String toString() {
            return getName();
        }

        public MyBluetoothDevice(BluetoothDevice bluetoothDevice) {
            this.bluetoothDevice = bluetoothDevice;
        }
    }
}
