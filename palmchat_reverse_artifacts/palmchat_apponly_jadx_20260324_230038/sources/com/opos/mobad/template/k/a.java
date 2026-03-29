package com.opos.mobad.template.k;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static boolean a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        try {
            b(motionEvent);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("isPhysicalClick", e);
        }
        int source = motionEvent.getSource();
        return (source & 257) == 257 || (source & 513) == 513 || (source & 1025) == 1025 || (source & 4098) == 4098 || (source & 8194) == 8194 || (source & InputDeviceCompat.SOURCE_STYLUS) == 16386 || (source & 49154) == 49154 || (source & InputDeviceCompat.SOURCE_TRACKBALL) == 65540 || (source & 131076) == 131076 || (source & InputDeviceCompat.SOURCE_TOUCHPAD) == 1048584 || (source & 2097152) == 2097152 || (source & 4194304) == 4194304 || (source & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232 || (source & InputDeviceCompat.SOURCE_HDMI) == 33554433;
    }

    private static void b(MotionEvent motionEvent) {
        int source = motionEvent.getSource();
        StringBuilder sb = new StringBuilder();
        sb.append("Motion event is from sources: ");
        sb.append((source & 257) != 0 ? "keyboard " : "");
        sb.append((source & 513) != 0 ? "dpad " : "");
        sb.append((source & 1025) != 0 ? "gamepad " : "");
        sb.append((source & 4098) != 0 ? "touchscreen " : "");
        sb.append((source & 8194) != 0 ? "mouse " : "");
        sb.append((source & InputDeviceCompat.SOURCE_STYLUS) != 0 ? "stylus " : "");
        sb.append((49154 & source) != 0 ? "bt_stylus " : "");
        sb.append((65540 & source) != 0 ? "trackball " : "");
        sb.append((131076 & source) != 0 ? "mouse_relative " : "");
        sb.append((1048584 & source) != 0 ? "touchpad " : "");
        sb.append((2097152 & source) != 0 ? "touch_navigation " : "");
        sb.append((4194304 & source) != 0 ? "rotary_encoder " : "");
        sb.append((16777232 & source) != 0 ? "joystick " : "");
        sb.append((source & InputDeviceCompat.SOURCE_HDMI) != 0 ? "hdmi" : "");
        com.opos.cmn.an.f.a.a("DeviceUtils", sb.toString());
    }
}
