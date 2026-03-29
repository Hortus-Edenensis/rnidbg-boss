package androidx.media3.effect;

import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.o46;
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
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DebugTraceUtil {
    private static final boolean ENABLE_TRACES_IN_LOGCAT = false;
    public static final String EVENT_RECEIVE_EOS = "ReceiveEOS";
    private static final int MAX_FIRST_LAST_LOGS = 10;
    public static boolean enableTracing = false;
    public static final String COMPONENT_TRANSFORMER_INTERNAL = "TransformerInternal";
    public static final String EVENT_START = "Start";
    public static final String COMPONENT_ASSET_LOADER = "AssetLoader";
    public static final String EVENT_INPUT_FORMAT = "InputFormat";
    public static final String EVENT_OUTPUT_FORMAT = "OutputFormat";
    public static final String COMPONENT_AUDIO_DECODER = "AudioDecoder";
    public static final String EVENT_ACCEPTED_INPUT = "AcceptedInput";
    public static final String EVENT_PRODUCED_OUTPUT = "ProducedOutput";
    public static final String EVENT_INPUT_ENDED = "InputEnded";
    public static final String EVENT_OUTPUT_ENDED = "OutputEnded";
    public static final String COMPONENT_AUDIO_GRAPH = "AudioGraph";
    public static final String EVENT_REGISTER_NEW_INPUT_STREAM = "RegisterNewInputStream";
    public static final String COMPONENT_AUDIO_MIXER = "AudioMixer";
    public static final String COMPONENT_AUDIO_ENCODER = "AudioEncoder";
    public static final String COMPONENT_VIDEO_DECODER = "VideoDecoder";
    public static final String COMPONENT_VFP = "VideoFrameProcessor";
    public static final String EVENT_SURFACE_TEXTURE_INPUT = "SurfaceTextureInput";
    public static final String EVENT_QUEUE_FRAME = "QueueFrame";
    public static final String EVENT_QUEUE_BITMAP = "QueueBitmap";
    public static final String EVENT_QUEUE_TEXTURE = "QueueTexture";
    public static final String EVENT_RENDERED_TO_OUTPUT_SURFACE = "RenderedToOutputSurface";
    public static final String EVENT_OUTPUT_TEXTURE_RENDERED = "OutputTextureRendered";
    public static final String EVENT_RECEIVE_END_OF_ALL_INPUT = "ReceiveEndOfAllInput";
    public static final String EVENT_SIGNAL_ENDED = "SignalEnded";
    public static final String COMPONENT_EXTERNAL_TEXTURE_MANAGER = "ExternalTextureManager";
    public static final String EVENT_SIGNAL_EOS = "SignalEOS";
    public static final String EVENT_SURFACE_TEXTURE_TRANSFORM_FIX = "SurfaceTextureTransformFix";
    public static final String COMPONENT_BITMAP_TEXTURE_MANAGER = "BitmapTextureManager";
    public static final String COMPONENT_TEX_ID_TEXTURE_MANAGER = "TexIdTextureManager";
    public static final String COMPONENT_COMPOSITOR = "Compositor";
    public static final String COMPONENT_VIDEO_ENCODER = "VideoEncoder";
    public static final String COMPONENT_MUXER = "Muxer";
    public static final String EVENT_CAN_WRITE_SAMPLE = "CanWriteSample";
    private static final ImmutableMap<String, List<String>> COMPONENTS_TO_EVENTS = ImmutableMap.builder().h(COMPONENT_TRANSFORMER_INTERNAL, ImmutableList.of(EVENT_START)).h(COMPONENT_ASSET_LOADER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT)).h(COMPONENT_AUDIO_DECODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).h(COMPONENT_AUDIO_GRAPH, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_OUTPUT_ENDED)).h(COMPONENT_AUDIO_MIXER, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_OUTPUT_FORMAT, EVENT_PRODUCED_OUTPUT)).h(COMPONENT_AUDIO_ENCODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).h(COMPONENT_VIDEO_DECODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).h(COMPONENT_VFP, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_SURFACE_TEXTURE_INPUT, EVENT_QUEUE_FRAME, EVENT_QUEUE_BITMAP, EVENT_QUEUE_TEXTURE, EVENT_RENDERED_TO_OUTPUT_SURFACE, EVENT_OUTPUT_TEXTURE_RENDERED, EVENT_RECEIVE_END_OF_ALL_INPUT, EVENT_SIGNAL_ENDED)).h(COMPONENT_EXTERNAL_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS, EVENT_SURFACE_TEXTURE_TRANSFORM_FIX)).h(COMPONENT_BITMAP_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS)).h(COMPONENT_TEX_ID_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS)).h(COMPONENT_COMPOSITOR, ImmutableList.of(EVENT_OUTPUT_TEXTURE_RENDERED)).h(COMPONENT_VIDEO_ENCODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).h(COMPONENT_MUXER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_CAN_WRITE_SAMPLE, EVENT_ACCEPTED_INPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).d();

    @GuardedBy("DebugTraceUtil.class")
    private static final Map<String, Map<String, EventLogger>> componentsToEventsToLogs = new LinkedHashMap();

    @GuardedBy("DebugTraceUtil.class")
    private static long startTimeMs = Clock.DEFAULT.elapsedRealtime();

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Component {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EventLog {
        public final long eventTimeMs;
        public final String extra;
        public final long presentationTimeUs;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Util.formatInvariant("%s@%dms", DebugTraceUtil.presentationTimeToString(this.presentationTimeUs), Long.valueOf(this.eventTimeMs)));
            sb.append(this.extra.isEmpty() ? "" : Util.formatInvariant("(%s)", this.extra));
            return sb.toString();
        }

        private EventLog(long j, long j2, String str) {
            this.presentationTimeUs = j;
            this.eventTimeMs = j2;
            this.extra = str;
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
            jsonWriter.endArray();
            if (!this.lastLogs.isEmpty()) {
                jsonWriter.name("last").beginArray();
                Iterator<EventLog> it2 = this.lastLogs.iterator();
                while (it2.hasNext()) {
                    jsonWriter.value(it2.next().toString());
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
    }

    public static synchronized void dumpTsv(Writer writer) throws IOException {
        if (!enableTracing) {
            writer.write("Tracing disabled");
            return;
        }
        writer.write("component\tevent\ttimestamp\tpresentation\textra\n");
        for (Map.Entry<String, Map<String, EventLogger>> entry : componentsToEventsToLogs.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, EventLogger> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                o46<EventLog> it = entry2.getValue().getLogs().iterator();
                while (it.hasNext()) {
                    EventLog next = it.next();
                    writer.write(Util.formatInvariant("%s\t%s\t%dms\t%s\t%s\n", key, key2, Long.valueOf(next.eventTimeMs), presentationTimeToString(next.presentationTimeUs), next.extra));
                }
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
            try {
                jsonWriter.beginObject();
                o46<Map.Entry<String, List<String>>> it = COMPONENTS_TO_EVENTS.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, List<String>> next = it.next();
                    String key = next.getKey();
                    List<String> value = next.getValue();
                    jsonWriter.name(key);
                    Map<String, EventLogger> map = componentsToEventsToLogs.get(key);
                    jsonWriter.beginObject();
                    for (String str : value) {
                        jsonWriter.name(str);
                        if (map == null || !map.containsKey(str)) {
                            jsonWriter.value("No events");
                        } else {
                            ((EventLogger) Assertions.checkNotNull(map.get(str))).toJson(jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                jsonWriter.endObject();
                return stringWriter.toString();
            } finally {
                Util.closeQuietly(jsonWriter);
            }
        } catch (IOException unused) {
            return "\"Error generating trace summary\"";
        }
    }

    private static String getCodecComponent(boolean z, boolean z2) {
        return z ? z2 ? COMPONENT_VIDEO_DECODER : COMPONENT_AUDIO_DECODER : z2 ? COMPONENT_VIDEO_ENCODER : COMPONENT_AUDIO_ENCODER;
    }

    public static synchronized void logCodecEvent(boolean z, boolean z2, String str, long j, String str2, Object... objArr) {
        logEvent(getCodecComponent(z, z2), str, j, str2, objArr);
    }

    public static synchronized void logEvent(String str, String str2, long j, String str3, Object... objArr) {
        if (enableTracing) {
            long jElapsedRealtime = Clock.DEFAULT.elapsedRealtime() - startTimeMs;
            Map<String, Map<String, EventLogger>> map = componentsToEventsToLogs;
            if (!map.containsKey(str)) {
                map.put(str, new LinkedHashMap());
            }
            Map<String, EventLogger> map2 = map.get(str);
            if (!map2.containsKey(str2)) {
                map2.put(str2, new EventLogger());
            }
            map2.get(str2).addLog(new EventLog(j, jElapsedRealtime, Util.formatInvariant(str3, objArr)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String presentationTimeToString(long j) {
        if (j == -9223372036854775807L) {
            return "UNSET";
        }
        if (j == Long.MIN_VALUE) {
            return "EOS";
        }
        return j + com.igexin.push.g.o.f7373a;
    }

    public static synchronized void reset() {
        componentsToEventsToLogs.clear();
        startTimeMs = Clock.DEFAULT.elapsedRealtime();
    }

    public static synchronized void logEvent(String str, String str2, long j) {
        logEvent(str, str2, j, "", new Object[0]);
    }
}
