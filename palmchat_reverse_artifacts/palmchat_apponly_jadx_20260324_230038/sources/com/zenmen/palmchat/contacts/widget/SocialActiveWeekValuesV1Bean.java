package com.zenmen.palmchat.contacts.widget;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class SocialActiveWeekValuesV1Bean {
    public boolean showStatus;
    public int valueMax;
    public int valueRemaining;
    public int valueToday;
    public int valueWeek;

    public int getProgressPercentage() {
        int i = this.valueMax;
        if (i <= 0) {
            return 0;
        }
        return Math.min(100, (int) ((this.valueWeek * 100.0f) / i));
    }

    public String toString() {
        return "SocialActiveWeekValuesV1Bean{showStatus=" + this.showStatus + ", valueMax=" + this.valueMax + ", valueToday=" + this.valueToday + ", valueWeek=" + this.valueWeek + ", valueRemaining=" + this.valueRemaining + ", progressPercentage=" + getProgressPercentage() + '}';
    }
}
