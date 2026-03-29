package com.ss.android.ttvecamera.cameracapabilitycollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraCapabilityCollector {
    public static final Map<Integer, Capability> sCapabilityMetadataMap;
    private List<CapabilityDescription> mCapabilityList;
    private boolean mIsInited = false;
    private ITECameraCapabilityUploadStrategy mStrategy;

    /* JADX INFO: compiled from: SearchBox */
    public enum Capability {
        DEPTH_OUTPUT,
        PREVIEW_SIZE,
        FPS_RANGE,
        MANUAL_3A,
        HIGH_SPEED_VIDEO_FPS_RANGE,
        SUPPORT_APERTURES,
        LOGICAL_MULTI_CAMERA,
        SUPPORT_EXTENSIONS,
        FRONT_BACK_MULTICAM_COMBOS
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CapabilityDescription {
        public DataType dataType;
        public Capability identity;
        public Object value;

        public CapabilityDescription(Capability capability, DataType dataType, Object obj) {
            this.identity = capability;
            this.dataType = dataType;
            this.value = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum DataType {
        UNKNOWN,
        BOOLEAN,
        INTEGER,
        LONG,
        FLOAT,
        STRING
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ITECameraCapabilityUploadStrategy {
        DataType getDataType(Capability capability);

        void upload(List<CapabilityDescription> list);
    }

    static {
        HashMap map = new HashMap();
        sCapabilityMetadataMap = map;
        map.put(8, Capability.DEPTH_OUTPUT);
        map.put(1, Capability.MANUAL_3A);
        map.put(11, Capability.LOGICAL_MULTI_CAMERA);
    }

    public void addCapability(CapabilityDescription capabilityDescription) {
        List<CapabilityDescription> list = this.mCapabilityList;
        if (list != null) {
            list.add(capabilityDescription);
        }
    }

    public DataType getDataType(Capability capability) {
        return this.mStrategy.getDataType(capability);
    }

    public void init(ITECameraCapabilityUploadStrategy iTECameraCapabilityUploadStrategy) {
        if (this.mIsInited) {
            return;
        }
        if (this.mCapabilityList == null) {
            this.mCapabilityList = new ArrayList();
        }
        if (this.mStrategy == null) {
            this.mStrategy = iTECameraCapabilityUploadStrategy;
        }
        this.mIsInited = true;
    }

    public void upload() {
        this.mStrategy.upload(this.mCapabilityList);
        this.mCapabilityList.clear();
    }
}
