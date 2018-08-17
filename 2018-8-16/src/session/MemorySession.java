package session;

import java.util.HashMap;
import java.util.Map;

public class MemorySession implements MySession {
    private Map<String, Object> data = new HashMap<>();
    private String id;

    public MemorySession() {
    }

    public MemorySession(String id) {
        this.id = id;
    }

    @Override
    public String id() {

        return this.id;
    }

    @Override
    public Object get(String key) {
        return data.get(key);
    }

    @Override
    public void set(String key, Object value) {
        data.put(key, value);
    }
}
