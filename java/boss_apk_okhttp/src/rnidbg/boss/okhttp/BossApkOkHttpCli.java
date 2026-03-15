package rnidbg.boss.okhttp;

import java.nio.charset.StandardCharsets;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.a0;
import okhttp3.d0;
import okhttp3.f0;
import okhttp3.h0;
import okhttp3.i0;

public final class BossApkOkHttpCli {
    private BossApkOkHttpCli() {}

    public static void main(String[] args) {
        Envelope envelope;
        try {
            RequestSpec spec = RequestSpec.parse(args);
            envelope = execute(spec);
        } catch (Throwable error) {
            envelope = Envelope.error(error);
        }
        System.out.println(envelope.toJson());
    }

    private static Envelope execute(RequestSpec spec) throws Exception {
        f0 client = new f0.b()
                .f(15, TimeUnit.SECONDS)
                .t(20, TimeUnit.SECONDS)
                .w(20, TimeUnit.SECONDS)
                .r(Collections.singletonList(Protocol.HTTP_1_1))
                .d();
        h0.a builder = new h0.a().url(spec.url);
        for (Header header : spec.headers) {
            builder.addHeader(header.name, header.value);
        }

        i0 requestBody = null;
        if (spec.bodyBase64 != null) {
            byte[] bodyBytes = Base64.getDecoder().decode(spec.bodyBase64);
            d0 mediaType = spec.contentType != null ? d0.c(spec.contentType) : null;
            requestBody = i0.create(mediaType, bodyBytes);
        }

        if ("GET".equals(spec.method) && requestBody == null) {
            builder.get();
        } else {
            builder.method(spec.method, requestBody);
        }

        Response response = client.a(builder.build()).execute();
        try {
            byte[] responseBodyBytes = response.body() != null ? response.body().e() : new byte[0];
            DecodedBody decodedBody = DecodedBody.fromBytes(responseBodyBytes);
            return Envelope.success(
                    response.code(),
                    decodedBody.text,
                    Base64.getEncoder().encodeToString(responseBodyBytes),
                    decodedBody.utf8Valid,
                    responseBodyBytes.length,
                    response.message(),
                    response.protocol().toString(),
                    response.headers());
        } finally {
            response.close();
        }
    }

    private static final class RequestSpec {
        final String method;
        final String url;
        final List<Header> headers;
        final String bodyBase64;
        final String contentType;

        RequestSpec(String method, String url, List<Header> headers, String bodyBase64, String contentType) {
            this.method = method;
            this.url = url;
            this.headers = headers;
            this.bodyBase64 = bodyBase64;
            this.contentType = contentType;
        }

        static RequestSpec parse(String[] args) {
            String method = "GET";
            String url = null;
            String bodyBase64 = null;
            String contentType = null;
            List<Header> headers = new ArrayList<>();

            for (int i = 0; i < args.length; i++) {
                String current = args[i];
                if ("--method".equals(current) && i + 1 < args.length) {
                    method = args[++i].trim().toUpperCase();
                } else if ("--url".equals(current) && i + 1 < args.length) {
                    url = args[++i];
                } else if ("--header".equals(current) && i + 1 < args.length) {
                    headers.add(Header.parse(args[++i]));
                } else if ("--body-base64".equals(current) && i + 1 < args.length) {
                    bodyBase64 = args[++i];
                } else if ("--content-type".equals(current) && i + 1 < args.length) {
                    contentType = args[++i];
                } else {
                    throw new IllegalArgumentException("unsupported argument: " + current);
                }
            }

            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("missing --url");
            }
            return new RequestSpec(method, url, headers, bodyBase64, contentType);
        }
    }

    private static final class Header {
        final String name;
        final String value;

        Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        static Header parse(String text) {
            int split = text.indexOf(':');
            if (split <= 0) {
                throw new IllegalArgumentException("header must be key:value");
            }
            String name = text.substring(0, split).trim();
            String value = text.substring(split + 1).trim();
            return new Header(name, value);
        }
    }

    private static final class Envelope {
        final int status;
        final String body;
        final String bodyBase64;
        final boolean bodyUtf8;
        final int bodySize;
        final String message;
        final String protocol;
        final a0 headers;
        final String error;

        Envelope(
                int status,
                String body,
                String bodyBase64,
                boolean bodyUtf8,
                int bodySize,
                String message,
                String protocol,
                a0 headers,
                String error) {
            this.status = status;
            this.body = body;
            this.bodyBase64 = bodyBase64;
            this.bodyUtf8 = bodyUtf8;
            this.bodySize = bodySize;
            this.message = message;
            this.protocol = protocol;
            this.headers = headers;
            this.error = error;
        }

        static Envelope success(
                int status,
                String body,
                String bodyBase64,
                boolean bodyUtf8,
                int bodySize,
                String message,
                String protocol,
                a0 headers) {
            return new Envelope(status, body, bodyBase64, bodyUtf8, bodySize, message, protocol, headers, null);
        }

        static Envelope error(Throwable error) {
            String message = error.toString();
            if (error.getMessage() != null && !error.getMessage().isEmpty()) {
                message = error.getMessage();
            }
            return new Envelope(500, "", "", true, 0, "", "", null, message);
        }

        String toJson() {
            StringBuilder json = new StringBuilder();
            json.append('{');
            json.append("\"status\":").append(this.status).append(',');
            json.append("\"body\":").append(jsonString(this.body)).append(',');
            json.append("\"body_base64\":").append(jsonString(this.bodyBase64)).append(',');
            json.append("\"body_utf8\":").append(this.bodyUtf8).append(',');
            json.append("\"body_size\":").append(this.bodySize).append(',');
            json.append("\"message\":").append(jsonString(this.message)).append(',');
            json.append("\"protocol\":").append(jsonString(this.protocol)).append(',');
            json.append("\"headers\":").append(headersToJson(this.headers)).append(',');
            json.append("\"engine\":\"boss_apk_okhttp\"");
            if (this.error != null) {
                json.append(",\"error\":").append(jsonString(this.error));
            }
            json.append('}');
            return json.toString();
        }
    }

    private static final class DecodedBody {
        final String text;
        final boolean utf8Valid;

        DecodedBody(String text, boolean utf8Valid) {
            this.text = text;
            this.utf8Valid = utf8Valid;
        }

        static DecodedBody fromBytes(byte[] bytes) {
            if (bytes == null || bytes.length == 0) {
                return new DecodedBody("", true);
            }
            try {
                return new DecodedBody(
                        StandardCharsets.UTF_8
                                .newDecoder()
                                .onMalformedInput(CodingErrorAction.REPORT)
                                .onUnmappableCharacter(CodingErrorAction.REPORT)
                                .decode(java.nio.ByteBuffer.wrap(bytes))
                                .toString(),
                        true);
            } catch (CharacterCodingException ignored) {
                return new DecodedBody("", false);
            }
        }
    }

    private static String headersToJson(a0 headers) {
        if (headers == null) {
            return "{}";
        }
        StringBuilder json = new StringBuilder();
        json.append('{');
        for (int i = 0; i < headers.i(); i++) {
            if (i > 0) {
                json.append(',');
            }
            json.append(jsonString(headers.e(i)));
            json.append(':');
            json.append(jsonString(headers.k(i)));
        }
        json.append('}');
        return json.toString();
    }

    private static String jsonString(String value) {
        if (value == null) {
            return "null";
        }
        StringBuilder out = new StringBuilder();
        out.append('"');
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            switch (ch) {
                case '\\':
                    out.append("\\\\");
                    break;
                case '"':
                    out.append("\\\"");
                    break;
                case '\b':
                    out.append("\\b");
                    break;
                case '\f':
                    out.append("\\f");
                    break;
                case '\n':
                    out.append("\\n");
                    break;
                case '\r':
                    out.append("\\r");
                    break;
                case '\t':
                    out.append("\\t");
                    break;
                default:
                    if (ch < 0x20) {
                        out.append(String.format("\\u%04x", (int) ch));
                    } else {
                        out.append(ch);
                    }
                    break;
            }
        }
        out.append('"');
        return out.toString();
    }
}
