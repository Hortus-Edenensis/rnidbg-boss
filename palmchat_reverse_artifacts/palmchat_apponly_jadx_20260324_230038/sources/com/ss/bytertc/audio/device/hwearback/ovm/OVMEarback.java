package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.BaseEarback;
import com.ss.bytertc.audio.device.hwearback.SlientPlayer;
import com.ss.bytertc.audio.device.hwearback.ovm.HardwareEarbackParams;
import com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class OVMEarback extends BaseEarback {
    private static final int EVENT_KEY_RECORDING_START = 1100;
    private static final int EVENT_KEY_RECORDING_STOP = 1103;
    private static final String TAG = "OVMEarback";
    private final OVMClient client;
    private boolean isAudioParamsSupported;
    private boolean isRecordingStarted;
    private final SlientPlayer slientPlayer;

    public OVMEarback(Context context, WebRtcAudioEarBack webRtcAudioEarBack) {
        super(context, webRtcAudioEarBack);
        this.isRecordingStarted = true;
        this.isAudioParamsSupported = false;
        this.client = OVMClient.initialize(context);
        this.slientPlayer = new SlientPlayer();
    }

    private boolean checkAudioParams() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        String karaokeSupportParameters = this.client.getKaraokeSupportParameters();
        stringBuffer.append("parse params: ");
        stringBuffer.append(this.client.getKaraokeSupportParameters());
        HardwareEarbackParams hardwareEarbackParams = new DefaultHardwareParamsParser().parse(karaokeSupportParameters);
        if (hardwareEarbackParams != null) {
            List<HardwareEarbackParams.Play> list = hardwareEarbackParams.playParamsList;
            int i3 = 48000;
            int i4 = 2;
            if (list == null || list.size() <= 0) {
                stringBuffer.append(", playout params parsed null.");
                z2 = false;
            } else {
                stringBuffer.append(", playout params size: ");
                stringBuffer.append(hardwareEarbackParams.playParamsList.size());
                Iterator<HardwareEarbackParams.Play> it = hardwareEarbackParams.playParamsList.iterator();
                boolean z3 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HardwareEarbackParams.Play next = it.next();
                    stringBuffer.append("{");
                    stringBuffer.append("streamType: ");
                    stringBuffer.append(next.streamType);
                    stringBuffer.append(", sampleRate: ");
                    stringBuffer.append(next.sampleRate);
                    stringBuffer.append(", format: ");
                    stringBuffer.append(next.format);
                    stringBuffer.append(", flags: ");
                    stringBuffer.append(next.flags);
                    stringBuffer.append("}");
                    boolean z4 = next.streamType == 3 && next.format == 2 && ((i2 = next.sampleRate) == 44100 || i2 == i3);
                    if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM || ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) {
                        z4 &= next.version > 0;
                    }
                    z3 |= z4;
                    if (z3) {
                        RXLogging.i(TAG, "updating slientPlayer params: " + next.sampleRate + ", " + next.flags);
                        this.slientPlayer.setSampleRate(next.sampleRate);
                        this.slientPlayer.setRequireDeepBuffer((next.flags & 8) == 8);
                    } else {
                        i3 = 48000;
                    }
                }
                z2 = true & z3;
            }
            List<HardwareEarbackParams.Record> list2 = hardwareEarbackParams.recordParamsList;
            if (list2 == null || list2.size() <= 0) {
                stringBuffer.append(", record params parsed null.");
                z = false;
            } else {
                stringBuffer.append(", record params size: ");
                stringBuffer.append(hardwareEarbackParams.recordParamsList.size());
                boolean z5 = false;
                for (HardwareEarbackParams.Record record : hardwareEarbackParams.recordParamsList) {
                    stringBuffer.append("{");
                    stringBuffer.append("sampleRate: ");
                    stringBuffer.append(record.sampleRate);
                    stringBuffer.append(", format: ");
                    stringBuffer.append(record.format);
                    stringBuffer.append(", audioSource: ");
                    stringBuffer.append(record.source);
                    stringBuffer.append(", flags: ");
                    stringBuffer.append(record.flags);
                    stringBuffer.append("}");
                    boolean z6 = record.format == i4 && record.sampleRate == 48000 && ((i = record.source) == 1 || i == 0) && (record.flags & 1) == 1;
                    if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM || ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) {
                        z6 &= record.version > 0;
                    }
                    z5 |= z6;
                    i4 = 2;
                }
                z = z2 & z5;
            }
        } else {
            z = false;
        }
        stringBuffer.append(", canOpenEarback: ");
        stringBuffer.append(z);
        RXLogging.i(TAG, stringBuffer.toString());
        return z;
    }

    private String getReportParameters() {
        String karaokeSupportParameters = this.client.getKaraokeSupportParameters();
        try {
            JSONObject jSONObject = new JSONObject(karaokeSupportParameters);
            jSONObject.put("version", this.client.getVersion());
            return jSONObject.toString();
        } catch (Throwable unused) {
            RXLogging.e(TAG, "parse report params error, not json format");
            return karaokeSupportParameters;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInit$0(int i) {
        RXLogging.i(TAG, "connection result: " + i);
        if (i != 1001) {
            onInitResult(false);
            return;
        }
        this.client.openKTVDevice();
        this.client.resetKTVParamsAndUpdate();
        this.webRtcAudioEarBack.onHardwareEarbackSupportParamsGet(getReportParameters());
        this.isAudioParamsSupported = checkAudioParams();
        onInitResult(true);
    }

    private synchronized void updatePlayerState() {
        SlientPlayer slientPlayer = this.slientPlayer;
        if (slientPlayer == null) {
            return;
        }
        if ((slientPlayer.isPlaying() && this.isRecordingStarted) || getState() == BaseEarback.EarbackState.RUNNING) {
            this.slientPlayer.play();
        } else {
            this.slientPlayer.stop();
        }
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onClose() {
        this.client.setPlayFeedbackParam(0);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void onEvent(int i, int i2) {
        if (i == 1100) {
            this.isRecordingStarted = true;
            updatePlayerState();
        } else if (i == 1103) {
            this.isRecordingStarted = false;
            updatePlayerState();
        }
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public void onInit() {
        this.client.setAuthCallback(new OVMAuthManager.AuthCallback() { // from class: i54
            @Override // com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager.AuthCallback
            public final void onResult(int i) {
                this.f18103a.lambda$onInit$0(i);
            }
        });
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onIsSupportCall() {
        return this.client.isSupportedAndAuth() && this.isAudioParamsSupported;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public boolean onOpen() {
        this.client.setPlayFeedbackParam(1);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public void onRelease() {
        this.client.setPlayFeedbackParam(0);
        this.client.setMixerSoundType(0);
        this.client.setEqualizerType(0);
        this.client.closeKTVDevice();
        this.client.release();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    public synchronized void onStateChanged(BaseEarback.EarbackState earbackState, BaseEarback.EarbackState earbackState2) {
        super.onStateChanged(earbackState, earbackState2);
        updatePlayerState();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int i) {
        this.client.setMixerSoundType(i);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int i) {
        this.client.setEqualizerType(i);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int i) {
        int i2 = ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP ? 12 : 15;
        this.client.setMicVolParam(Math.max(Math.min((int) ((i / 100.0f) * i2), i2), 0));
        return 0;
    }
}
