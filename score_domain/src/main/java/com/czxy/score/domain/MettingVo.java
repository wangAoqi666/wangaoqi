package com.czxy.score.domain;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
public class MettingVo {
    private Metting metting;
    private String startTime;
    private String endTime;
    private String createTime;

    @Override
    public String toString() {
        return "MettingVo{" +
                "metting=" + metting +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Metting getMetting() {
        return metting;
    }

    public void setMetting(Metting metting) {
        this.metting = metting;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public MettingVo() {
    }

    public MettingVo(Metting metting, String startTime, String endTime, String createTime) {
        this.metting = metting;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
    }
}
