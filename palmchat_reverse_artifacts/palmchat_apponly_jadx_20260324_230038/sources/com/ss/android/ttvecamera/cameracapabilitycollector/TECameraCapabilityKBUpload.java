package com.ss.android.ttvecamera.cameracapabilitycollector;

import com.huawei.hms.ads.ex;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraCapabilityKBUpload implements TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy {
    private static final String TAG = "TECameraCapabilityKBUpload";
    public static final Map<TECameraCapabilityCollector.Capability, TECameraCapabilityCollector.DataType> sNeedCollectCapabilityType;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityKBUpload$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability;
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType;

        static {
            int[] iArr = new int[TECameraCapabilityCollector.Capability.values().length];
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability = iArr;
            try {
                iArr[TECameraCapabilityCollector.Capability.DEPTH_OUTPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.PREVIEW_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.FPS_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.MANUAL_3A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.HIGH_SPEED_VIDEO_FPS_RANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.SUPPORT_APERTURES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.LOGICAL_MULTI_CAMERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.SUPPORT_EXTENSIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.FRONT_BACK_MULTICAM_COMBOS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[TECameraCapabilityCollector.DataType.values().length];
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType = iArr2;
            try {
                iArr2[TECameraCapabilityCollector.DataType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        sNeedCollectCapabilityType = map;
        TECameraCapabilityCollector.Capability capability = TECameraCapabilityCollector.Capability.DEPTH_OUTPUT;
        TECameraCapabilityCollector.DataType dataType = TECameraCapabilityCollector.DataType.STRING;
        map.put(capability, dataType);
        map.put(TECameraCapabilityCollector.Capability.PREVIEW_SIZE, dataType);
        map.put(TECameraCapabilityCollector.Capability.FPS_RANGE, dataType);
        map.put(TECameraCapabilityCollector.Capability.MANUAL_3A, dataType);
        map.put(TECameraCapabilityCollector.Capability.HIGH_SPEED_VIDEO_FPS_RANGE, dataType);
        map.put(TECameraCapabilityCollector.Capability.SUPPORT_APERTURES, dataType);
        map.put(TECameraCapabilityCollector.Capability.LOGICAL_MULTI_CAMERA, dataType);
        map.put(TECameraCapabilityCollector.Capability.SUPPORT_EXTENSIONS, dataType);
        map.put(TECameraCapabilityCollector.Capability.FRONT_BACK_MULTICAM_COMBOS, dataType);
    }

    private String convertCapabilityToString(TECameraCapabilityCollector.Capability capability) {
        switch (AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[capability.ordinal()]) {
            case 1:
                return TECameraMonitor.TE_RECORD_CAMERA_DEPTH_CAPACITY;
            case 2:
                return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_PREVIEW_SIZE;
            case 3:
                return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_FPS_RANGE;
            case 4:
                return TECameraMonitor.TE_RECORD_CAMERA_MANUAL_3A_CAPACITY;
            case 5:
                return TECameraMonitor.TE_RECORD_CAMERA_HIGH_SPEED_VIDEO_FPS_RANGE;
            case 6:
                return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_APERTURES;
            case 7:
                return TECameraMonitor.TE_RECORD_CAMERA_LOGICAL_MULTI_CAMERA_CAPACITY;
            case 8:
                return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_EXTENSIONS;
            case 9:
                return TECameraMonitor.TE_RECORD_CAMERA_FRONT_BACK_MULTICAM_COMBOS;
            default:
                TELogUtils.w(TAG, "key is null, capability is incorrect!");
                return null;
        }
    }

    @Override // com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy
    public TECameraCapabilityCollector.DataType getDataType(TECameraCapabilityCollector.Capability capability) {
        Map<TECameraCapabilityCollector.Capability, TECameraCapabilityCollector.DataType> map = sNeedCollectCapabilityType;
        return map.get(capability) == null ? TECameraCapabilityCollector.DataType.UNKNOWN : map.get(capability);
    }

    @Override // com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy
    public void upload(List<TECameraCapabilityCollector.CapabilityDescription> list) {
        for (TECameraCapabilityCollector.CapabilityDescription capabilityDescription : list) {
            String strConvertCapabilityToString = convertCapabilityToString(capabilityDescription.identity);
            if (strConvertCapabilityToString != null) {
                int i = AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[capabilityDescription.dataType.ordinal()];
                if (i == 1 || i == 2) {
                    TECameraMonitor.perfLong(strConvertCapabilityToString, ((Long) capabilityDescription.value).longValue());
                } else if (i == 3) {
                    TECameraMonitor.perfDouble(strConvertCapabilityToString, ((Double) capabilityDescription.value).doubleValue());
                } else if (i == 4) {
                    TECameraMonitor.perfString(strConvertCapabilityToString, ((Boolean) capabilityDescription.value).booleanValue() ? ex.Code : ex.V);
                } else if (i == 5) {
                    TECameraMonitor.perfString(strConvertCapabilityToString, (String) capabilityDescription.value);
                }
            }
        }
    }
}
