package org.json;

import java.util.LinkedHashMap;
import java.util.Map;

public class JSONObject {
    private final Map<String, Object> values = new LinkedHashMap<>();

    public JSONObject() {}

    public JSONObject(String ignored) throws JSONException {}

    public JSONObject put(String key, Object value) throws JSONException {
        values.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        boolean first = true;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            if (!first) {
                builder.append(',');
            }
            first = false;
            builder.append('"').append(entry.getKey()).append('"').append(':');
            Object value = entry.getValue();
            if (value == null) {
                builder.append("null");
            } else if (value instanceof Number || value instanceof Boolean) {
                builder.append(value);
            } else {
                builder.append('"').append(value.toString().replace("\"", "\\\"")).append('"');
            }
        }
        builder.append('}');
        return builder.toString();
    }
}
