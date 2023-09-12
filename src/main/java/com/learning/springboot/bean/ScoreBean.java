package com.learning.springboot.bean;

public class ScoreBean {
    private String userid;
    private String subject;
    private Integer score;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreBean{" +
                "userid='" + userid + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
