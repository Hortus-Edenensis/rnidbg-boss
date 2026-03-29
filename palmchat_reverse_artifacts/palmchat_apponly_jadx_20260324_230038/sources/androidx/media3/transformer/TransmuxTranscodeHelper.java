package androidx.media3.transformer;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.EditedMediaItemSequence;
import com.google.common.collect.ImmutableList;
import defpackage.o65;
import defpackage.r33;
import defpackage.uv;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class TransmuxTranscodeHelper {

    /* JADX INFO: compiled from: SearchBox */
    public static final class ResumeMetadata {
        public final ImmutableList<Pair<Integer, Long>> firstMediaItemIndexAndOffsetInfo;
        public final long lastSyncSampleTimestampUs;

        @Nullable
        public final Format videoFormat;

        public ResumeMetadata(long j, ImmutableList<Pair<Integer, Long>> immutableList, @Nullable Format format) {
            this.lastSyncSampleTimestampUs = j;
            this.firstMediaItemIndexAndOffsetInfo = immutableList;
            this.videoFormat = format;
        }
    }

    private TransmuxTranscodeHelper() {
    }

    public static Composition buildUponComposition(Composition composition, boolean z, boolean z2, @Nullable ResumeMetadata resumeMetadata) {
        long jLongValue;
        int iIntValue;
        ImmutableList<Pair<Integer, Long>> immutableList;
        Composition.Builder builder;
        Composition.Builder builderBuildUpon = composition.buildUpon();
        ImmutableList<EditedMediaItemSequence> immutableList2 = composition.sequences;
        ArrayList arrayList = new ArrayList();
        ImmutableList<Pair<Integer, Long>> immutableList3 = resumeMetadata != null ? resumeMetadata.firstMediaItemIndexAndOffsetInfo : null;
        int i = 0;
        while (i < immutableList2.size()) {
            EditedMediaItemSequence editedMediaItemSequence = immutableList2.get(i);
            ImmutableList<EditedMediaItem> immutableList4 = editedMediaItemSequence.editedMediaItems;
            ArrayList arrayList2 = new ArrayList();
            if (immutableList3 != null) {
                iIntValue = ((Integer) immutableList3.get(i).first).intValue();
                jLongValue = ((Long) immutableList3.get(i).second).longValue();
            } else {
                jLongValue = 0;
                iIntValue = 0;
            }
            int i2 = iIntValue;
            while (i2 < immutableList4.size()) {
                EditedMediaItem editedMediaItem = immutableList4.get(i2);
                EditedMediaItem.Builder builderBuildUpon2 = editedMediaItem.buildUpon();
                if (i2 == iIntValue) {
                    immutableList = immutableList3;
                    builder = builderBuildUpon;
                    builderBuildUpon2.setMediaItem(editedMediaItem.mediaItem.buildUpon().setClippingConfiguration(editedMediaItem.mediaItem.clippingConfiguration.buildUpon().setStartPositionMs(editedMediaItem.mediaItem.clippingConfiguration.startPositionMs + Util.usToMs(jLongValue)).build()).build());
                } else {
                    immutableList = immutableList3;
                    builder = builderBuildUpon;
                }
                if (z) {
                    builderBuildUpon2.setRemoveAudio(true);
                }
                if (z2) {
                    builderBuildUpon2.setRemoveVideo(true);
                }
                arrayList2.add(builderBuildUpon2.build());
                i2++;
                immutableList3 = immutableList;
                builderBuildUpon = builder;
            }
            arrayList.add(new EditedMediaItemSequence.Builder(arrayList2).setIsLooping(editedMediaItemSequence.isLooping).build());
            i++;
            immutableList3 = immutableList3;
            builderBuildUpon = builderBuildUpon;
        }
        Composition.Builder builder2 = builderBuildUpon;
        builder2.setSequences(arrayList);
        return builder2.build();
    }

    public static Composition buildUponCompositionForTrimOptimization(Composition composition, long j, long j2, long j3, boolean z, boolean z2) {
        EditedMediaItem editedMediaItem = composition.sequences.get(0).editedMediaItems.get(0);
        return composition.buildUpon().setSequences(ImmutableList.of(new EditedMediaItemSequence.Builder(editedMediaItem.buildUpon().setMediaItem(editedMediaItem.mediaItem.buildUpon().setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder().setStartPositionUs(j).setEndPositionUs(j2).setStartsAtKeyFrame(z).build()).build()).setDurationUs(j3).setEffects(z2 ? new Effects(editedMediaItem.effects.audioProcessors, ImmutableList.of()) : editedMediaItem.effects).build()).build())).build();
    }

    public static r33<Void> copyFileAsync(final File file, final File file2) {
        final o65 o65VarE = o65.E();
        new Thread("TransmuxTranscodeHelper:CopyFile") { // from class: androidx.media3.transformer.TransmuxTranscodeHelper.3
            /* JADX WARN: Removed duplicated region for block: B:32:0x0052 A[Catch: IOException -> 0x0055, TRY_LEAVE, TryCatch #3 {IOException -> 0x0055, blocks: (B:30:0x004d, B:32:0x0052), top: B:38:0x004d }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                FileOutputStream fileOutputStream;
                Throwable th;
                FileInputStream fileInputStream;
                Exception e;
                if (o65VarE.isCancelled()) {
                    return;
                }
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                try {
                                    uv.b(fileInputStream, fileOutputStream);
                                    o65VarE.A(null);
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    e = e2;
                                    o65VarE.B(e);
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (fileOutputStream == null) {
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused) {
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            fileOutputStream = null;
                            e = e3;
                        } catch (Throwable th3) {
                            fileOutputStream = null;
                            th = th3;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (Exception e4) {
                    fileOutputStream = null;
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th4) {
                    fileOutputStream = null;
                    th = th4;
                    fileInputStream = null;
                }
                fileOutputStream.close();
            }
        }.start();
        return o65VarE;
    }

    public static Composition createAudioTranscodeAndVideoTransmuxComposition(Composition composition, String str) {
        Composition compositionBuildUponComposition = buildUponComposition((Composition) Assertions.checkNotNull(composition), false, true, null);
        Composition.Builder builderBuildUpon = compositionBuildUponComposition.buildUpon();
        ArrayList arrayList = new ArrayList(compositionBuildUponComposition.sequences);
        arrayList.add(new EditedMediaItemSequence.Builder(new EditedMediaItem.Builder(new MediaItem.Builder().setUri(str).build()).build()).build());
        builderBuildUpon.setSequences(arrayList);
        builderBuildUpon.setTransmuxVideo(true);
        return builderBuildUpon.build();
    }

    public static Composition createVideoOnlyComposition(String str, long j) {
        return new Composition.Builder(new EditedMediaItemSequence.Builder(new EditedMediaItem.Builder(new MediaItem.Builder().setUri(str).setClippingConfiguration(new MediaItem.ClippingConfiguration.Builder().setEndPositionMs(Util.usToMs(j)).build()).build()).setRemoveAudio(true).build()).build(), new EditedMediaItemSequence[0]).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getMediaItemDurationUs(Context context, MediaItem mediaItem) throws IOException {
        String string = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem.localConfiguration)).uri.toString();
        long jMsToUs = Util.msToUs(mediaItem.clippingConfiguration.startPositionMs);
        long j = mediaItem.clippingConfiguration.endPositionMs;
        return (j != Long.MIN_VALUE ? Util.msToUs(j) : Mp4Info.create(context, string).durationUs) - jMsToUs;
    }

    public static r33<Mp4Info> getMp4Info(final Context context, final String str, final long j) {
        final o65 o65VarE = o65.E();
        new Thread("TransmuxTranscodeHelper:Mp4Info") { // from class: androidx.media3.transformer.TransmuxTranscodeHelper.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    o65VarE.A(Mp4Info.create(context, str, j));
                } catch (Exception e) {
                    o65VarE.B(e);
                }
            }
        }.start();
        return o65VarE;
    }

    public static r33<ResumeMetadata> getResumeMetadataAsync(final Context context, final String str, final Composition composition) {
        final o65 o65VarE = o65.E();
        new Thread("TransmuxTranscodeHelper:ResumeMetadata") { // from class: androidx.media3.transformer.TransmuxTranscodeHelper.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (o65VarE.isCancelled()) {
                        return;
                    }
                    Mp4Info mp4InfoCreate = Mp4Info.create(context, str);
                    long j = mp4InfoCreate.lastSyncSampleTimestampUs;
                    ImmutableList.a aVar = new ImmutableList.a();
                    if (j != -9223372036854775807L) {
                        for (int i = 0; i < composition.sequences.size(); i++) {
                            ImmutableList<EditedMediaItem> immutableList = composition.sequences.get(i).editedMediaItems;
                            long j2 = j;
                            int i2 = 0;
                            while (i2 < immutableList.size() && j2 > 0) {
                                long mediaItemDurationUs = TransmuxTranscodeHelper.getMediaItemDurationUs(context, immutableList.get(i2).mediaItem);
                                if (mediaItemDurationUs > j2) {
                                    break;
                                }
                                j2 -= mediaItemDurationUs;
                                i2++;
                            }
                            j2 = 0;
                            aVar.a(new Pair(Integer.valueOf(i2), Long.valueOf(j2)));
                        }
                    }
                    o65VarE.A(new ResumeMetadata(j, aVar.e(), mp4InfoCreate.videoFormat));
                } catch (Exception e) {
                    o65VarE.B(e);
                }
            }
        }.start();
        return o65VarE;
    }
}
