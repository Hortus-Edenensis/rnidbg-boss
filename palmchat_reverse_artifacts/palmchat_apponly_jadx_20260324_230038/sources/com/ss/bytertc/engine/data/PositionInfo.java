package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PositionInfo {
    public HumanOrientation orientation;
    public Position position;

    public PositionInfo(Position position, HumanOrientation humanOrientation) {
        this.position = position;
        this.orientation = humanOrientation;
    }

    @CalledByNative
    public float getFieldOrientationForwardX() {
        return this.orientation.forward.x;
    }

    @CalledByNative
    public float getFieldOrientationForwardY() {
        return this.orientation.forward.y;
    }

    @CalledByNative
    public float getFieldOrientationForwardZ() {
        return this.orientation.forward.z;
    }

    @CalledByNative
    public float getFieldOrientationRightX() {
        return this.orientation.right.x;
    }

    @CalledByNative
    public float getFieldOrientationRightY() {
        return this.orientation.right.y;
    }

    @CalledByNative
    public float getFieldOrientationRightZ() {
        return this.orientation.right.z;
    }

    @CalledByNative
    public float getFieldOrientationUpX() {
        return this.orientation.up.x;
    }

    @CalledByNative
    public float getFieldOrientationUpY() {
        return this.orientation.up.y;
    }

    @CalledByNative
    public float getFieldOrientationUpZ() {
        return this.orientation.up.z;
    }

    @CalledByNative
    public float getFieldPositionX() {
        return this.position.x;
    }

    @CalledByNative
    public float getFieldPositionY() {
        return this.position.y;
    }

    @CalledByNative
    public float getFieldPositionZ() {
        return this.position.z;
    }
}
