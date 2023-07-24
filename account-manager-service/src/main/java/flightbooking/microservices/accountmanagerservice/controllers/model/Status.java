
package flightbooking.microservices.accountmanagerservice.controllers.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("SUCCESS")
    SUCCESS("SUCCESS"),
    @JsonProperty("ERROR")
    ERROR("ERROR"),
    @JsonProperty("WARNING")
    WARNING("WARNING"),
    @JsonProperty("FAILED")
    FAILED("FAILED"),
    @JsonProperty("WAITING")
    WAITING("WAITING");
    private final String value;
    private final static Map<String, Status> VALUE_CACHE = new HashMap<String, Status>();

    static {
        for (Status c: values()) {
            VALUE_CACHE.put(c.value, c);
        }
    }

    private Status(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static Status fromValue(String value) {
        return VALUE_CACHE.get(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
