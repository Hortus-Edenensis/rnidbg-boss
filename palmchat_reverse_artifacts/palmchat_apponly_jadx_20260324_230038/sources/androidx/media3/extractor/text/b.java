package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static void a(SubtitleParser subtitleParser, byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        subtitleParser.parse(bArr, 0, bArr.length, outputOptions, consumer);
    }

    public static Subtitle b(SubtitleParser subtitleParser, byte[] bArr, int i, int i2) {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        SubtitleParser.OutputOptions outputOptions = SubtitleParser.OutputOptions.ALL;
        Objects.requireNonNull(aVarBuilder);
        subtitleParser.parse(bArr, i, i2, outputOptions, new Consumer() { // from class: ln5
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                aVarBuilder.a((CuesWithTiming) obj);
            }
        });
        return new CuesWithTimingSubtitle(aVarBuilder.e());
    }

    public static void c(SubtitleParser subtitleParser) {
    }
}
