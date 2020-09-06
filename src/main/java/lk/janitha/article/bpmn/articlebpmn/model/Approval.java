package lk.janitha.article.bpmn.articlebpmn.model;

public class Approval {
    private String id;
    private String status;

    public Approval() {
    }

    public Approval(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
