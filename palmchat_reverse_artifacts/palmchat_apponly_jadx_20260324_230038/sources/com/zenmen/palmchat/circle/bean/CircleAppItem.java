package com.zenmen.palmchat.circle.bean;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleAppItem {
    public static int APP_TYPE_NATIVE = 0;
    public static int APP_TYPE_SMARTAPP = 2;
    public static int APP_TYPE_URL = 1;
    public Bitmap icon;
    public int iconResource = -1;
    public String name;
    public String startPath;
    public int type;
}
