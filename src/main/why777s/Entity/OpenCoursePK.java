package Entity;

import java.io.Serializable;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class OpenCoursePK implements Serializable {
    private String cid;
    private String tid;
    private String semester;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenCoursePK that = (OpenCoursePK) o;

        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (semester != null ? !semester.equals(that.semester) : that.semester != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        return result;
    }
}
