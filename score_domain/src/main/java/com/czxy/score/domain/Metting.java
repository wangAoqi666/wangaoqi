package com.czxy.score.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tab_metting")
public class Metting {
  @Id
  private Integer mettingId;
  private String mettingName;
  private Integer mettingSize;
  private Date mettingStarttime;
  private Date mettingEndtime;
  private Date mettingOrdertime;
  private String remark;
  private String status;
  private String username;
  private Integer roomId;
  private Room room;
  private List<User> userList = new ArrayList<>();

  @Override
  public String toString() {
    return "Metting{" +
            "mettingId=" + mettingId +
            ", mettingName='" + mettingName + '\'' +
            ", mettingSize=" + mettingSize +
            ", mettingStarttime=" + mettingStarttime +
            ", mettingEndtime=" + mettingEndtime +
            ", mettingOrdertime=" + mettingOrdertime +
            ", remark='" + remark + '\'' +
            ", status='" + status + '\'' +
            ", username='" + username + '\'' +
            ", roomId=" + roomId +
            ", room=" + room +
            ", userList=" + userList +
            '}';
  }

  public Integer getMettingId() {
    return mettingId;
  }

  public void setMettingId(Integer mettingId) {
    this.mettingId = mettingId;
  }

  public String getMettingName() {
    return mettingName;
  }

  public void setMettingName(String mettingName) {
    this.mettingName = mettingName;
  }

  public Integer getMettingSize() {
    return mettingSize;
  }

  public void setMettingSize(Integer mettingSize) {
    this.mettingSize = mettingSize;
  }

  public Date getMettingStarttime() {
    return mettingStarttime;
  }

  public void setMettingStarttime(Date mettingStarttime) {
    this.mettingStarttime = mettingStarttime;
  }

  public Date getMettingEndtime() {
    return mettingEndtime;
  }

  public void setMettingEndtime(Date mettingEndtime) {
    this.mettingEndtime = mettingEndtime;
  }

  public Date getMettingOrdertime() {
    return mettingOrdertime;
  }

  public void setMettingOrdertime(Date mettingOrdertime) {
    this.mettingOrdertime = mettingOrdertime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public Metting() {
  }

  public Metting(Integer mettingId, String mettingName, Integer mettingSize, Date mettingStarttime, Date mettingEndtime, Date mettingOrdertime, String remark, String status, String username, Integer roomId, Room room, List<User> userList) {
    this.mettingId = mettingId;
    this.mettingName = mettingName;
    this.mettingSize = mettingSize;
    this.mettingStarttime = mettingStarttime;
    this.mettingEndtime = mettingEndtime;
    this.mettingOrdertime = mettingOrdertime;
    this.remark = remark;
    this.status = status;
    this.username = username;
    this.roomId = roomId;
    this.room = room;
    this.userList = userList;
  }
}
