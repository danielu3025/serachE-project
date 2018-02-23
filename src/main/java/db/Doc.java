package db;

public class Doc {

    private long docIndex;
    private String docName;
    private String docLocation;
    private boolean active;
    
    public Doc() {
    }

    public long getDocIndex() {
        return docIndex;
    }

    public void setDocIndex(long docIndex) {
        this.docIndex = docIndex;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocLocation() {
        return docLocation;
    }

    public void setDocLocation(String docLocation) {
        this.docLocation = docLocation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
