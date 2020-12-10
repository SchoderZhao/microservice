package com.msunsoft.spt.common.core.entity;

import java.util.HashMap;

/**
 * @author Schoder
 */
public class SptResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public SptResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public SptResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public SptResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
