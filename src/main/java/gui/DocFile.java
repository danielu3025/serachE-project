package gui;

import java.io.File;

public class DocFile {
    String path;
    Boolean isActive;
    File file;

    public DocFile(String path, Boolean isActive) {
        this.path = path;
        this.isActive = isActive;
        this.file = new File(path);
    }

    public DocFile(String path, Boolean isActive, File file) {
        this.path = path;
        this.isActive = isActive;
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
