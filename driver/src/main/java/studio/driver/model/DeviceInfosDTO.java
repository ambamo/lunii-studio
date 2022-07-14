package studio.driver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class DeviceInfosDTO {
    private String uuid;
    private String serial;
    private String firmware;
    private String driver; // PackFormat
    private boolean error;
    private boolean plugged;
    private StorageDTO storage;

    @Getter
    @AllArgsConstructor
    public static final class StorageDTO {
        private long size;
        private long free;
        private long taken;
    }
}