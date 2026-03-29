package com.oplus.tbl.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.text.Cue;
import com.oplus.tbl.exoplayer2.text.SimpleSubtitleDecoder;
import com.oplus.tbl.exoplayer2.text.Subtitle;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.LongArray;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    private static final float END_FRACTION = 0.92f;
    private static final float MID_FRACTION = 0.5f;
    private static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";
    private static final String TAG = "SubripDecoder";
    private final ArrayList<String> tags;
    private final StringBuilder textBuilder;
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");

    public SubripDecoder() {
        super(TAG);
        this.textBuilder = new StringBuilder();
        this.tags = new ArrayList<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Cue buildCue(Spanned spanned, @Nullable String str) {
        byte b;
        byte b2;
        Cue.Builder text = new Cue.Builder().setText(spanned);
        if (str == null) {
            return text.build();
        }
        switch (str.hashCode()) {
            case -685620710:
                b = !str.equals(ALIGN_BOTTOM_LEFT) ? (byte) -1 : (byte) 0;
                break;
            case -685620679:
                if (str.equals(ALIGN_BOTTOM_MID)) {
                    b = 6;
                    break;
                }
                break;
            case -685620648:
                if (str.equals(ALIGN_BOTTOM_RIGHT)) {
                    b = 3;
                    break;
                }
                break;
            case -685620617:
                if (str.equals(ALIGN_MID_LEFT)) {
                    b = 1;
                    break;
                }
                break;
            case -685620586:
                if (str.equals(ALIGN_MID_MID)) {
                    b = 7;
                    break;
                }
                break;
            case -685620555:
                if (str.equals(ALIGN_MID_RIGHT)) {
                    b = 4;
                    break;
                }
                break;
            case -685620524:
                if (str.equals(ALIGN_TOP_LEFT)) {
                    b = 2;
                    break;
                }
                break;
            case -685620493:
                if (str.equals(ALIGN_TOP_MID)) {
                    b = 8;
                    break;
                }
                break;
            case -685620462:
                if (str.equals(ALIGN_TOP_RIGHT)) {
                    b = 5;
                    break;
                }
                break;
        }
        if (b == 0 || b == 1 || b == 2) {
            text.setPositionAnchor(0);
        } else if (b == 3 || b == 4 || b == 5) {
            text.setPositionAnchor(2);
        } else {
            text.setPositionAnchor(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                b2 = !str.equals(ALIGN_BOTTOM_LEFT) ? (byte) -1 : (byte) 0;
                break;
            case -685620679:
                if (str.equals(ALIGN_BOTTOM_MID)) {
                    b2 = 1;
                    break;
                }
                break;
            case -685620648:
                if (str.equals(ALIGN_BOTTOM_RIGHT)) {
                    b2 = 2;
                    break;
                }
                break;
            case -685620617:
                if (str.equals(ALIGN_MID_LEFT)) {
                    b2 = 6;
                    break;
                }
                break;
            case -685620586:
                if (str.equals(ALIGN_MID_MID)) {
                    b2 = 7;
                    break;
                }
                break;
            case -685620555:
                if (str.equals(ALIGN_MID_RIGHT)) {
                    b2 = 8;
                    break;
                }
                break;
            case -685620524:
                if (str.equals(ALIGN_TOP_LEFT)) {
                    b2 = 3;
                    break;
                }
                break;
            case -685620493:
                if (str.equals(ALIGN_TOP_MID)) {
                    b2 = 4;
                    break;
                }
                break;
            case -685620462:
                if (str.equals(ALIGN_TOP_RIGHT)) {
                    b2 = 5;
                    break;
                }
                break;
        }
        if (b2 == 0 || b2 == 1 || b2 == 2) {
            text.setLineAnchor(2);
        } else if (b2 == 3 || b2 == 4 || b2 == 5) {
            text.setLineAnchor(0);
        } else {
            text.setLineAnchor(1);
        }
        return text.setPosition(getFractionalPositionForAnchorType(text.getPositionAnchor())).setLine(getFractionalPositionForAnchorType(text.getLineAnchor()), 0).build();
    }

    public static float getFractionalPositionForAnchorType(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return END_FRACTION;
        }
        throw new IllegalArgumentException();
    }

    private static long parseTimecode(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 2))) * 60 * 1000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    private String processLine(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    @Override // com.oplus.tbl.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        StringBuilder sb;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        while (true) {
            String line = parsableByteArray.readLine();
            int i2 = 0;
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                try {
                    Integer.parseInt(line);
                    line = parsableByteArray.readLine();
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                    str = "Skipping invalid index: ";
                }
                if (line == null) {
                    Log.w(TAG, "Unexpected end");
                    break;
                }
                Matcher matcher = SUBRIP_TIMING_LINE.matcher(line);
                if (matcher.matches()) {
                    longArray.add(parseTimecode(matcher, 1));
                    longArray.add(parseTimecode(matcher, 6));
                    this.textBuilder.setLength(0);
                    this.tags.clear();
                    while (true) {
                        String line2 = parsableByteArray.readLine();
                        if (TextUtils.isEmpty(line2)) {
                            break;
                        }
                        if (this.textBuilder.length() > 0) {
                            this.textBuilder.append("<br>");
                        }
                        this.textBuilder.append(processLine(line2, this.tags));
                    }
                    Spanned spannedFromHtml = Html.fromHtml(this.textBuilder.toString());
                    while (true) {
                        if (i2 >= this.tags.size()) {
                            str2 = null;
                            break;
                        }
                        str2 = this.tags.get(i2);
                        if (str2.matches(SUBRIP_ALIGNMENT_TAG)) {
                            break;
                        }
                        i2++;
                    }
                    arrayList.add(buildCue(spannedFromHtml, str2));
                    arrayList.add(Cue.EMPTY);
                } else {
                    sb = new StringBuilder();
                    str = "Skipping invalid timing: ";
                    sb.append(str);
                    sb.append(line);
                    Log.w(TAG, sb.toString());
                }
            }
        }
        return new SubripSubtitle((Cue[]) arrayList.toArray(new Cue[0]), longArray.toArray());
    }
}
