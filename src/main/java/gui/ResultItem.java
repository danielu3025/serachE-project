package gui;

public class ResultItem {
    String title;
    String filePath;
    String description;

    public ResultItem(String title,String filePath, String description) {
        this.title = title;
        this.description = description;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return title +"-"+description;
    }
}
