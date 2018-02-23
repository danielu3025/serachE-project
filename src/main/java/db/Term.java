package db;

public class Term {

    private long termIndex;
    private String termName;
    private long numberOfDocs;
    
    public Term() {
        super();
    }
    
    public long getTermIndex() {
        return termIndex;
    }
    public void setTermIndex(long termIndex) {
        this.termIndex = termIndex;
    }
    public String getTermName() {
        return termName;
    }
    public void setTermName(String termName) {
        this.termName = termName;
    }
    public long getNumberOfDocs() {
        return numberOfDocs;
    }
    public void setNumberOfDocs(long numberOfDocs) {
        this.numberOfDocs = numberOfDocs;
    }
}
