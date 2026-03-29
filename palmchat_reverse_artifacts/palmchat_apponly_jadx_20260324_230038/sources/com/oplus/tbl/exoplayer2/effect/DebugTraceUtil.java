package com.oplus.tbl.exoplayer2.effect;

import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.ol5;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class DebugTraceUtil {
    private static final int MAX_FIRST_LAST_LOGS = 10;
    public static boolean enableTracing = false;
    public static final String EVENT_VIDEO_INPUT_FORMAT = "VideoInputFormat";
    public static final String EVENT_DECODER_DECODED_FRAME = "Decoder-DecodedFrame";
    public static final String EVENT_VFP_REGISTER_NEW_INPUT_STREAM = "VFP-RegisterNewInputStream";
    public static final String EVENT_VFP_SURFACE_TEXTURE_INPUT = "VFP-SurfaceTextureInput";
    public static final String EVENT_VFP_QUEUE_FRAME = "VFP-QueueFrame";
    public static final String EVENT_VFP_QUEUE_BITMAP = "VFP-QueueBitmap";
    public static final String EVENT_VFP_QUEUE_TEXTURE = "VFP-QueueTexture";
    public static final String EVENT_VFP_RENDERED_TO_OUTPUT_SURFACE = "VFP-RenderedToOutputSurface";
    public static final String EVENT_VFP_OUTPUT_TEXTURE_RENDERED = "VFP-OutputTextureRendered";
    public static final String EVENT_VFP_FINISH_PROCESSING_INPUT_STREAM = "VFP-FinishOneInputStream";
    public static final String EVENT_COMPOSITOR_OUTPUT_TEXTURE_RENDERED = "COMP-OutputTextureRendered";
    public static final String EVENT_ENCODER_ENCODED_FRAME = "Encoder-EncodedFrame";
    public static final String EVENT_MUXER_CAN_WRITE_SAMPLE_VIDEO = "Muxer-CanWriteSample_Video";
    public static final String EVENT_MUXER_WRITE_SAMPLE_VIDEO = "Muxer-WriteSample_Video";
    public static final String EVENT_MUXER_CAN_WRITE_SAMPLE_AUDIO = "Muxer-CanWriteSample_Audio";
    public static final String EVENT_MUXER_WRITE_SAMPLE_AUDIO = "Muxer-WriteSample_Audio";
    public static final String EVENT_DECODER_RECEIVE_EOS = "Decoder-ReceiveEOS";
    public static final String EVENT_DECODER_SIGNAL_EOS = "Decoder-SignalEOS";
    public static final String EVENT_VFP_RECEIVE_END_OF_INPUT = "VFP-ReceiveEndOfAllInput";
    public static final String EVENT_EXTERNAL_TEXTURE_MANAGER_SIGNAL_EOS = "ExternalTextureManager-SignalEOS";
    public static final String EVENT_BITMAP_TEXTURE_MANAGER_SIGNAL_EOS = "BitmapTextureManager-SignalEOS";
    public static final String EVENT_TEX_ID_TEXTURE_MANAGER_SIGNAL_EOS = "TexIdTextureManager-SignalEOS";
    public static final String EVENT_VFP_SIGNAL_ENDED = "VFP-SignalEnded";
    public static final String EVENT_ENCODER_RECEIVE_EOS = "Encoder-ReceiveEOS";
    public static final String EVENT_MUXER_TRACK_ENDED_AUDIO = "Muxer-TrackEnded_Audio";
    public static final String EVENT_MUXER_TRACK_ENDED_VIDEO = "Muxer-TrackEnded_Video";
    private static final ImmutableList<String> EVENT_TYPES = ImmutableList.of(EVENT_VIDEO_INPUT_FORMAT, EVENT_DECODER_DECODED_FRAME, EVENT_VFP_REGISTER_NEW_INPUT_STREAM, EVENT_VFP_SURFACE_TEXTURE_INPUT, EVENT_VFP_QUEUE_FRAME, EVENT_VFP_QUEUE_BITMAP, EVENT_VFP_QUEUE_TEXTURE, EVENT_VFP_RENDERED_TO_OUTPUT_SURFACE, EVENT_VFP_OUTPUT_TEXTURE_RENDERED, EVENT_VFP_FINISH_PROCESSING_INPUT_STREAM, EVENT_COMPOSITOR_OUTPUT_TEXTURE_RENDERED, EVENT_ENCODER_ENCODED_FRAME, EVENT_MUXER_CAN_WRITE_SAMPLE_VIDEO, EVENT_MUXER_WRITE_SAMPLE_VIDEO, EVENT_MUXER_CAN_WRITE_SAMPLE_AUDIO, EVENT_MUXER_WRITE_SAMPLE_AUDIO, EVENT_DECODER_RECEIVE_EOS, EVENT_DECODER_SIGNAL_EOS, EVENT_VFP_RECEIVE_END_OF_INPUT, EVENT_EXTERNAL_TEXTURE_MANAGER_SIGNAL_EOS, EVENT_BITMAP_TEXTURE_MANAGER_SIGNAL_EOS, EVENT_TEX_ID_TEXTURE_MANAGER_SIGNAL_EOS, EVENT_VFP_SIGNAL_ENDED, EVENT_ENCODER_RECEIVE_EOS, EVENT_MUXER_TRACK_ENDED_AUDIO, EVENT_MUXER_TRACK_ENDED_VIDEO);

    @GuardedBy("DebugTraceUtil.class")
    private static final Map<String, EventLogger> events = new LinkedHashMap();

    @GuardedBy("DebugTraceUtil.class")
    private static long startTimeMs = Clock.DEFAULT.elapsedRealtime();

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DebugTraceEvent {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EventLog {
        public final long eventTimeMs;

        @Nullable
        public final String extra;
        public final long presentationTimeUs;

        private EventLog(long j, long j2, @Nullable String str) {
            this.presentationTimeUs = j;
            this.eventTimeMs = j2;
            this.extra = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Util.formatInvariant("%s@%d", DebugTraceUtil.presentationTimeToString(this.presentationTimeUs), Long.valueOf(this.eventTimeMs)));
            String str = this.extra;
            sb.append(str != null ? Util.formatInvariant("(%s)", str) : "");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EventLogger {
        private final List<EventLog> firstLogs = new ArrayList(10);
        private final Queue<EventLog> lastLogs = new ArrayDeque(10);
        private int totalCount = 0;

        public void addLog(EventLog eventLog) {
            if (this.firstLogs.size() < 10) {
                this.firstLogs.add(eventLog);
            } else {
                this.lastLogs.add(eventLog);
                if (this.lastLogs.size() > 10) {
                    this.lastLogs.remove();
                }
            }
            this.totalCount++;
        }

        public ImmutableList<EventLog> getLogs() {
            return new ImmutableList.a().l(this.firstLogs).l(this.lastLogs).e();
        }

        public void toJson(JsonWriter jsonWriter) throws IOException {
            jsonWriter.beginObject().name("count").value(this.totalCount).name("first").beginArray();
            Iterator<EventLog> it = this.firstLogs.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next().toString());
            }
            jsonWriter.endArray().name("last").beginArray();
            Iterator<EventLog> it2 = this.lastLogs.iterator();
            while (it2.hasNext()) {
                jsonWriter.value(it2.next().toString());
            }
            jsonWriter.endArray().endObject();
        }
    }

    public static synchronized void dumpTsv(Writer writer) throws IOException {
        if (!enableTracing) {
            writer.write("Tracing disabled");
            return;
        }
        writer.write("event\ttimestamp\tpresentation\textra\n");
        for (Map.Entry<String, EventLogger> entry : events.entrySet()) {
            ImmutableList<EventLog> logs = entry.getValue().getLogs();
            for (int i = 0; i < logs.size(); i++) {
                EventLog eventLog = logs.get(i);
                writer.write(Util.formatInvariant("%s\t%d\t%s\t%s\n", entry.getKey(), Long.valueOf(eventLog.eventTimeMs), presentationTimeToString(eventLog.presentationTimeUs), ol5.e(eventLog.extra)));
            }
        }
    }

    public static synchronized String generateTraceSummary() {
        if (!enableTracing) {
            return "\"Tracing disabled\"";
        }
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            int i = 0;
            while (true) {
                ImmutableList<String> immutableList = EVENT_TYPES;
                if (i >= immutableList.size()) {
                    jsonWriter.endObject();
                    return stringWriter.toString();
                }
                String str = immutableList.get(i);
                jsonWriter.name(str);
                Map<String, EventLogger> map = events;
                if (map.containsKey(str)) {
                    ((EventLogger) Assertions.checkNotNull(map.get(str))).toJson(jsonWriter);
                } else {
                    jsonWriter.value("No events");
                }
                i++;
            }
        } catch (IOException unused) {
            return "\"Error generating trace summary\"";
        } finally {
            Util.closeQuietly(jsonWriter);
        }
    }

    public static synchronized void logEvent(String str, long j) {
        logEvent(str, j, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String presentationTimeToString(long j) {
        return j == -9223372036854775807L ? "UNSET" : j == Long.MIN_VALUE ? "EOS" : String.valueOf(j);
    }

    public static synchronized void reset() {
        events.clear();
        startTimeMs = Clock.DEFAULT.elapsedRealtime();
    }

    public static synchronized void logEvent(String str, long j, @Nullable String str2, Object... objArr) {
        if (enableTracing) {
            long jElapsedRealtime = Clock.DEFAULT.elapsedRealtime() - startTimeMs;
            Map<String, EventLogger> map = events;
            if (!map.containsKey(str)) {
                map.put(str, new EventLogger());
            }
            map.get(str).addLog(new EventLog(j, jElapsedRealtime, str2 != null ? Util.formatInvariant(str2, objArr) : null));
        }
    }
}
