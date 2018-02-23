package db;

public class PostingFile {

    private long termIndex;
    private long docIndex;
    private long hits;
    
    public PostingFile() {
    }

    public long getTermIndex() {
        return termIndex;
    }

    public void setTermIndex(long termIndex) {
        this.termIndex = termIndex;
    }

    public long getDocIndex() {
        return docIndex;
    }

    public void setDocIndex(long docIndex) {
        this.docIndex = docIndex;
    }

    public long getHits() {
        return hits;
    }

    public void setHits(long hits) {
        this.hits = hits;
    }
}
