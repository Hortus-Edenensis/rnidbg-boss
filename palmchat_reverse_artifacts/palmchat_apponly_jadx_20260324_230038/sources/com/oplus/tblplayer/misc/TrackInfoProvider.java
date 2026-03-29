package com.oplus.tblplayer.misc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.source.TrackGroup;
import com.oplus.tbl.exoplayer2.source.TrackGroupArray;
import com.oplus.tbl.exoplayer2.trackselection.DefaultTrackSelector;
import com.oplus.tbl.exoplayer2.trackselection.MappingTrackSelector;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TrackInfoProvider {
    private static final String TAG = "TrackInfoProvider";

    @NonNull
    public static IMediaFormat createMediaFormat(@NonNull Format format) {
        TBLMediaFormat tBLMediaFormat = new TBLMediaFormat();
        tBLMediaFormat.setString("track-id", format.id);
        tBLMediaFormat.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
        int i = format.bitrate;
        if (i != -1) {
            tBLMediaFormat.setInteger("bitrate", i);
        }
        String str = format.codecs;
        if (str != null) {
            tBLMediaFormat.setString(IMediaFormat.KEY_CODECS, str);
        }
        int i2 = format.width;
        if (i2 != -1 && format.height != -1) {
            tBLMediaFormat.setInteger("width", i2);
            tBLMediaFormat.setInteger("height", format.height);
        }
        float f = format.frameRate;
        if (f != -1.0f) {
            tBLMediaFormat.setFloat(IMediaFormat.KEY_FRAME_RATE, f);
        }
        int i3 = format.channelCount;
        if (i3 != -1) {
            tBLMediaFormat.setInteger("channel-count", i3);
        }
        int i4 = format.sampleRate;
        if (i4 != -1) {
            tBLMediaFormat.setInteger("sample-rate", i4);
        }
        String str2 = format.language;
        if (str2 != null) {
            tBLMediaFormat.setString("language", str2);
        }
        String str3 = format.label;
        if (str3 != null && !str3.equals(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL)) {
            tBLMediaFormat.setString(IMediaFormat.KEY_LABLE, format.label);
        }
        return tBLMediaFormat;
    }

    public static ITrackInfo.SelectionOverride createStreamOverride(DefaultTrackSelector.SelectionOverride selectionOverride) {
        if (selectionOverride != null) {
            return new ITrackInfo.SelectionOverride(selectionOverride.groupIndex, selectionOverride.tracks);
        }
        return null;
    }

    public static TBLTrackInfo createTrackInfo(int i, boolean z, @NonNull MappingTrackSelector.MappedTrackInfo mappedTrackInfo, @Nullable DefaultTrackSelector.SelectionOverride selectionOverride) {
        TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
        int rendererType = mappedTrackInfo.getRendererType(i);
        ArrayList arrayList = new ArrayList(trackGroups.length);
        if (trackGroups.length <= 0 || !isValidRendererType(rendererType)) {
            return null;
        }
        for (int i2 = 0; i2 < trackGroups.length; i2++) {
            TrackGroup trackGroup = trackGroups.get(i2);
            boolean z2 = (rendererType == 2 || (rendererType == 1 && mappedTrackInfo.getTypeSupport(2) == 0)) && trackGroups.get(i2).length > 1 && mappedTrackInfo.getAdaptiveSupport(i, i2, false) != 0;
            ArrayList arrayList2 = new ArrayList(trackGroup.length);
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                int i4 = mappedTrackInfo.getTrackSupport(i, i2, i3) == 4 ? 1 : 0;
                IMediaFormat iMediaFormatCreateMediaFormat = createMediaFormat(trackGroup.getFormat(i3));
                iMediaFormatCreateMediaFormat.setInteger(IMediaFormat.KEY_IS_FORMAT_SUPPORT, i4);
                arrayList2.add(iMediaFormatCreateMediaFormat);
            }
            arrayList.add(createTrackInfoGroup(arrayList2, z2));
        }
        return new TBLTrackInfo(fromRendererType(rendererType), arrayList, z, createStreamOverride(selectionOverride));
    }

    public static ITrackInfo.TrackInfoGroup createTrackInfoGroup(@NonNull List<IMediaFormat> list, boolean z) {
        return new ITrackInfo.TrackInfoGroup(z, (IMediaFormat[]) list.toArray(new IMediaFormat[list.size()]));
    }

    public static int fromRendererType(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 4;
        }
        return 1;
    }

    public static int getRendererIndexByType(int i, @NonNull MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
        for (int i2 = 0; i2 < mappedTrackInfo.getRendererCount(); i2++) {
            int rendererType = mappedTrackInfo.getRendererType(i2);
            if (mappedTrackInfo.getTrackGroups(i2).length > 0 && i == fromRendererType(rendererType)) {
                return i2;
            }
        }
        return -1;
    }

    public static String getTrackTypeString(int i) {
        return i != 1 ? i != 2 ? (i == 3 || i == 4) ? "Text" : Constants.STRING_VALUE_UNSET : "Audio" : "Video";
    }

    public static boolean isValidRendererType(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    public static boolean isValidTrackType(int i) {
        return isValidRendererType(toRendererType(i));
    }

    public static void printStreamInfoList(@NonNull List<ITrackInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            ITrackInfo iTrackInfo = list.get(i);
            for (int i2 = 0; i2 < iTrackInfo.size(); i2++) {
                ITrackInfo.TrackInfoGroup trackInfoGroup = iTrackInfo.getTrackInfoGroup(i2);
                for (int i3 = 0; i3 < trackInfoGroup.length; i3++) {
                    LogUtil.d(TAG, "printStreamInfoArray: " + getTrackTypeString(iTrackInfo.getTrackType()) + "[" + trackInfoGroup.getFormat(i3) + "]");
                }
            }
        }
    }

    public static int toRendererType(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4) ? 3 : -1;
        }
        return 1;
    }

    public static DefaultTrackSelector.SelectionOverride toSelectorOverride(ITrackInfo.SelectionOverride selectionOverride) {
        if (selectionOverride != null) {
            return new DefaultTrackSelector.SelectionOverride(selectionOverride.groupIndex, selectionOverride.tracks);
        }
        return null;
    }
}
