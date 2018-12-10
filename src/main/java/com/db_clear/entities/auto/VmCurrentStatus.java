package com.db_clear.entities.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_vm_current_status")
public class VmCurrentStatus implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 售货机的id
     */
    @Column(name = "vm_id")
    private Long vmId;

    /**
     * 当前的运营商。如果为0，表示未分配。
     */
    @Column(name = "operator_id")
    private Long operatorId;

    /**
     * 1: 正常 2：故障 3：已报废
     */
    @Column(name = "fault_status")
    private Integer faultStatus;

    /**
     *  0:断网   1:正常
     */
    @Column(name = "network_status")
    private Integer networkStatus;

    /**
     * 温度℃
     */
    private Integer temperature;

    /**
     * 2g卡号码
     */
    @Column(name = "card2g_number")
    private String card2gNumber;

    /**
     * 2g卡状态(0~10：弱，10~20：一般，20~40：强，99：无信号)
     */
    @Column(name = "card2g_status")
    private Integer card2gStatus;

    /**
     * 2g流量
     */
    @Column(name = "card2g_flow")
    private BigDecimal card2gFlow;

    /**
     * 状态数据更新时间
     */
    @Column(name = "collecting_time")
    private Date collectingTime;

    /**
     * 货道状态  ( 0:存在故障    1: 正常)
     */
    @Column(name = "road_status")
    private Integer roadStatus;

    /**
     *  钱币报警，0:故障  1:正常
     */
    @Column(name = "coin_status")
    private Integer coinStatus;

    /**
     * sim卡上网的类型 0:未检测到 1:2g  2:3g  3:4g 4:WIFI
     */
    @Column(name = "card_type")
    private Integer cardType;

    /**
     * 主控板软件版本号
     */
    private String softversion;

    /**
     * 驱动板硬件版本号
     */
    private String hardversion;

    /**
     * sim卡 imsi 号
     */
    @Column(name = "card2g_imsi")
    private String card2gImsi;

    /**
     * 系统采集的纬度，-1:未采集到
     */
    private Double latitude;

    /**
     * 系统采集的经度，-1:未采集到
     */
    private Double longitude;

    /**
     * 系统采集的基站定位信息 格式为lac,cid  (error表示未采集到)
     */
    @Column(name = "lac_tac_ci")
    private String lacTacCi;

    /**
     * 2G/4G模块的imei
     */
    private String imei;

    /**
     * 主控板类型, 1-集成板, 2-安卓板
     */
    @Column(name = "board_type")
    private Integer boardType;

    /**
     * 板子连接的服务ID
     */
    @Column(name = "server_id")
    private String serverId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取售货机的id
     *
     * @return vm_id - 售货机的id
     */
    public Long getVmId() {
        return vmId;
    }

    /**
     * 设置售货机的id
     *
     * @param vmId 售货机的id
     */
    public void setVmId(Long vmId) {
        this.vmId = vmId;
    }

    /**
     * 获取当前的运营商。如果为0，表示未分配。
     *
     * @return operator_id - 当前的运营商。如果为0，表示未分配。
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 设置当前的运营商。如果为0，表示未分配。
     *
     * @param operatorId 当前的运营商。如果为0，表示未分配。
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取1: 正常 2：故障 3：已报废
     *
     * @return fault_status - 1: 正常 2：故障 3：已报废
     */
    public Integer getFaultStatus() {
        return faultStatus;
    }

    /**
     * 设置1: 正常 2：故障 3：已报废
     *
     * @param faultStatus 1: 正常 2：故障 3：已报废
     */
    public void setFaultStatus(Integer faultStatus) {
        this.faultStatus = faultStatus;
    }

    /**
     * 获取 0:断网   1:正常
     *
     * @return network_status -  0:断网   1:正常
     */
    public Integer getNetworkStatus() {
        return networkStatus;
    }

    /**
     * 设置 0:断网   1:正常
     *
     * @param networkStatus  0:断网   1:正常
     */
    public void setNetworkStatus(Integer networkStatus) {
        this.networkStatus = networkStatus;
    }

    /**
     * 获取温度℃
     *
     * @return temperature - 温度℃
     */
    public Integer getTemperature() {
        return temperature;
    }

    /**
     * 设置温度℃
     *
     * @param temperature 温度℃
     */
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * 获取2g卡号码
     *
     * @return card2g_number - 2g卡号码
     */
    public String getCard2gNumber() {
        return card2gNumber;
    }

    /**
     * 设置2g卡号码
     *
     * @param card2gNumber 2g卡号码
     */
    public void setCard2gNumber(String card2gNumber) {
        this.card2gNumber = card2gNumber;
    }

    /**
     * 获取2g卡状态(0~10：弱，10~20：一般，20~40：强，99：无信号)
     *
     * @return card2g_status - 2g卡状态(0~10：弱，10~20：一般，20~40：强，99：无信号)
     */
    public Integer getCard2gStatus() {
        return card2gStatus;
    }

    /**
     * 设置2g卡状态(0~10：弱，10~20：一般，20~40：强，99：无信号)
     *
     * @param card2gStatus 2g卡状态(0~10：弱，10~20：一般，20~40：强，99：无信号)
     */
    public void setCard2gStatus(Integer card2gStatus) {
        this.card2gStatus = card2gStatus;
    }

    /**
     * 获取2g流量
     *
     * @return card2g_flow - 2g流量
     */
    public BigDecimal getCard2gFlow() {
        return card2gFlow;
    }

    /**
     * 设置2g流量
     *
     * @param card2gFlow 2g流量
     */
    public void setCard2gFlow(BigDecimal card2gFlow) {
        this.card2gFlow = card2gFlow;
    }

    /**
     * 获取状态数据更新时间
     *
     * @return collecting_time - 状态数据更新时间
     */
    public Date getCollectingTime() {
        return collectingTime;
    }

    /**
     * 设置状态数据更新时间
     *
     * @param collectingTime 状态数据更新时间
     */
    public void setCollectingTime(Date collectingTime) {
        this.collectingTime = collectingTime;
    }

    /**
     * 获取货道状态  ( 0:存在故障    1: 正常)
     *
     * @return road_status - 货道状态  ( 0:存在故障    1: 正常)
     */
    public Integer getRoadStatus() {
        return roadStatus;
    }

    /**
     * 设置货道状态  ( 0:存在故障    1: 正常)
     *
     * @param roadStatus 货道状态  ( 0:存在故障    1: 正常)
     */
    public void setRoadStatus(Integer roadStatus) {
        this.roadStatus = roadStatus;
    }

    /**
     * 获取 钱币报警，0:故障  1:正常
     *
     * @return coin_status -  钱币报警，0:故障  1:正常
     */
    public Integer getCoinStatus() {
        return coinStatus;
    }

    /**
     * 设置 钱币报警，0:故障  1:正常
     *
     * @param coinStatus  钱币报警，0:故障  1:正常
     */
    public void setCoinStatus(Integer coinStatus) {
        this.coinStatus = coinStatus;
    }

    /**
     * 获取sim卡上网的类型 0:未检测到 1:2g  2:3g  3:4g 4:WIFI
     *
     * @return card_type - sim卡上网的类型 0:未检测到 1:2g  2:3g  3:4g 4:WIFI
     */
    public Integer getCardType() {
        return cardType;
    }

    /**
     * 设置sim卡上网的类型 0:未检测到 1:2g  2:3g  3:4g 4:WIFI
     *
     * @param cardType sim卡上网的类型 0:未检测到 1:2g  2:3g  3:4g 4:WIFI
     */
    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取主控板软件版本号
     *
     * @return softversion - 主控板软件版本号
     */
    public String getSoftversion() {
        return softversion;
    }

    /**
     * 设置主控板软件版本号
     *
     * @param softversion 主控板软件版本号
     */
    public void setSoftversion(String softversion) {
        this.softversion = softversion;
    }

    /**
     * 获取驱动板硬件版本号
     *
     * @return hardversion - 驱动板硬件版本号
     */
    public String getHardversion() {
        return hardversion;
    }

    /**
     * 设置驱动板硬件版本号
     *
     * @param hardversion 驱动板硬件版本号
     */
    public void setHardversion(String hardversion) {
        this.hardversion = hardversion;
    }

    /**
     * 获取sim卡 imsi 号
     *
     * @return card2g_imsi - sim卡 imsi 号
     */
    public String getCard2gImsi() {
        return card2gImsi;
    }

    /**
     * 设置sim卡 imsi 号
     *
     * @param card2gImsi sim卡 imsi 号
     */
    public void setCard2gImsi(String card2gImsi) {
        this.card2gImsi = card2gImsi;
    }

    /**
     * 获取系统采集的纬度，-1:未采集到
     *
     * @return latitude - 系统采集的纬度，-1:未采集到
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置系统采集的纬度，-1:未采集到
     *
     * @param latitude 系统采集的纬度，-1:未采集到
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取系统采集的经度，-1:未采集到
     *
     * @return longitude - 系统采集的经度，-1:未采集到
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置系统采集的经度，-1:未采集到
     *
     * @param longitude 系统采集的经度，-1:未采集到
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取系统采集的基站定位信息 格式为lac,cid  (error表示未采集到)
     *
     * @return lac_tac_ci - 系统采集的基站定位信息 格式为lac,cid  (error表示未采集到)
     */
    public String getLacTacCi() {
        return lacTacCi;
    }

    /**
     * 设置系统采集的基站定位信息 格式为lac,cid  (error表示未采集到)
     *
     * @param lacTacCi 系统采集的基站定位信息 格式为lac,cid  (error表示未采集到)
     */
    public void setLacTacCi(String lacTacCi) {
        this.lacTacCi = lacTacCi;
    }

    /**
     * 获取2G/4G模块的imei
     *
     * @return imei - 2G/4G模块的imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * 设置2G/4G模块的imei
     *
     * @param imei 2G/4G模块的imei
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * 获取主控板类型, 1-集成板, 2-安卓板
     *
     * @return board_type - 主控板类型, 1-集成板, 2-安卓板
     */
    public Integer getBoardType() {
        return boardType;
    }

    /**
     * 设置主控板类型, 1-集成板, 2-安卓板
     *
     * @param boardType 主控板类型, 1-集成板, 2-安卓板
     */
    public void setBoardType(Integer boardType) {
        this.boardType = boardType;
    }

    /**
     * 获取板子连接的服务ID
     *
     * @return server_id - 板子连接的服务ID
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * 设置板子连接的服务ID
     *
     * @param serverId 板子连接的服务ID
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VmCurrentStatus other = (VmCurrentStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVmId() == null ? other.getVmId() == null : this.getVmId().equals(other.getVmId()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getFaultStatus() == null ? other.getFaultStatus() == null : this.getFaultStatus().equals(other.getFaultStatus()))
            && (this.getNetworkStatus() == null ? other.getNetworkStatus() == null : this.getNetworkStatus().equals(other.getNetworkStatus()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getCard2gNumber() == null ? other.getCard2gNumber() == null : this.getCard2gNumber().equals(other.getCard2gNumber()))
            && (this.getCard2gStatus() == null ? other.getCard2gStatus() == null : this.getCard2gStatus().equals(other.getCard2gStatus()))
            && (this.getCard2gFlow() == null ? other.getCard2gFlow() == null : this.getCard2gFlow().equals(other.getCard2gFlow()))
            && (this.getCollectingTime() == null ? other.getCollectingTime() == null : this.getCollectingTime().equals(other.getCollectingTime()))
            && (this.getRoadStatus() == null ? other.getRoadStatus() == null : this.getRoadStatus().equals(other.getRoadStatus()))
            && (this.getCoinStatus() == null ? other.getCoinStatus() == null : this.getCoinStatus().equals(other.getCoinStatus()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getSoftversion() == null ? other.getSoftversion() == null : this.getSoftversion().equals(other.getSoftversion()))
            && (this.getHardversion() == null ? other.getHardversion() == null : this.getHardversion().equals(other.getHardversion()))
            && (this.getCard2gImsi() == null ? other.getCard2gImsi() == null : this.getCard2gImsi().equals(other.getCard2gImsi()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLacTacCi() == null ? other.getLacTacCi() == null : this.getLacTacCi().equals(other.getLacTacCi()))
            && (this.getImei() == null ? other.getImei() == null : this.getImei().equals(other.getImei()))
            && (this.getBoardType() == null ? other.getBoardType() == null : this.getBoardType().equals(other.getBoardType()))
            && (this.getServerId() == null ? other.getServerId() == null : this.getServerId().equals(other.getServerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVmId() == null) ? 0 : getVmId().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getFaultStatus() == null) ? 0 : getFaultStatus().hashCode());
        result = prime * result + ((getNetworkStatus() == null) ? 0 : getNetworkStatus().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getCard2gNumber() == null) ? 0 : getCard2gNumber().hashCode());
        result = prime * result + ((getCard2gStatus() == null) ? 0 : getCard2gStatus().hashCode());
        result = prime * result + ((getCard2gFlow() == null) ? 0 : getCard2gFlow().hashCode());
        result = prime * result + ((getCollectingTime() == null) ? 0 : getCollectingTime().hashCode());
        result = prime * result + ((getRoadStatus() == null) ? 0 : getRoadStatus().hashCode());
        result = prime * result + ((getCoinStatus() == null) ? 0 : getCoinStatus().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getSoftversion() == null) ? 0 : getSoftversion().hashCode());
        result = prime * result + ((getHardversion() == null) ? 0 : getHardversion().hashCode());
        result = prime * result + ((getCard2gImsi() == null) ? 0 : getCard2gImsi().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLacTacCi() == null) ? 0 : getLacTacCi().hashCode());
        result = prime * result + ((getImei() == null) ? 0 : getImei().hashCode());
        result = prime * result + ((getBoardType() == null) ? 0 : getBoardType().hashCode());
        result = prime * result + ((getServerId() == null) ? 0 : getServerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vmId=").append(vmId);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", faultStatus=").append(faultStatus);
        sb.append(", networkStatus=").append(networkStatus);
        sb.append(", temperature=").append(temperature);
        sb.append(", card2gNumber=").append(card2gNumber);
        sb.append(", card2gStatus=").append(card2gStatus);
        sb.append(", card2gFlow=").append(card2gFlow);
        sb.append(", collectingTime=").append(collectingTime);
        sb.append(", roadStatus=").append(roadStatus);
        sb.append(", coinStatus=").append(coinStatus);
        sb.append(", cardType=").append(cardType);
        sb.append(", softversion=").append(softversion);
        sb.append(", hardversion=").append(hardversion);
        sb.append(", card2gImsi=").append(card2gImsi);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", lacTacCi=").append(lacTacCi);
        sb.append(", imei=").append(imei);
        sb.append(", boardType=").append(boardType);
        sb.append(", serverId=").append(serverId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}