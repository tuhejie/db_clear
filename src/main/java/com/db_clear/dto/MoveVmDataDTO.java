package com.db_clear.dto;

/**
 * @Author ：Created by tuhj
 * @Date ：Created in 2018-12-08 15:37
 * @Description ：
 */
public class MoveVmDataDTO {

    private String numMark;

    public String getNumMark() {
        return numMark;
    }

    public void setNumMark(String numMark) {
        this.numMark = numMark;
    }

    @Override
    public String toString() {
        return "MoveVmDataDTO{" +
                "numMark='" + numMark + '\'' +
                '}';
    }
}
