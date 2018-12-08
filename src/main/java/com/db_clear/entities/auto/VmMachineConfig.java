package com.db_clear.entities.auto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_vm_machine_config")
public class VmMachineConfig implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 柜机ID
     */
    @Column(name = "vm_id")
    private Integer vmId;

    /**
     * 柜机的mac_address，如果机器还没有注册，则只能通过mac_address来查找
     */
    @Column(name = "mac_address")
    private String macAddress;

    /**
     * 配置用途。比如  server , client_cache 等，均可以根据业务自定义
     */
    @Column(name = "config_usage")
    private String configUsage;

    /**
     * 配置的版本信息，每次变更之后版本号都会增加
     */
    @Column(name = "config_version")
    private Integer configVersion;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否已清除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 配置描述，保存的内容为json
     */
    @Column(name = "config_desc")
    private String configDesc;

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
     * 获取柜机ID
     *
     * @return vm_id - 柜机ID
     */
    public Integer getVmId() {
        return vmId;
    }

    /**
     * 设置柜机ID
     *
     * @param vmId 柜机ID
     */
    public void setVmId(Integer vmId) {
        this.vmId = vmId;
    }

    /**
     * 获取柜机的mac_address，如果机器还没有注册，则只能通过mac_address来查找
     *
     * @return mac_address - 柜机的mac_address，如果机器还没有注册，则只能通过mac_address来查找
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * 设置柜机的mac_address，如果机器还没有注册，则只能通过mac_address来查找
     *
     * @param macAddress 柜机的mac_address，如果机器还没有注册，则只能通过mac_address来查找
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * 获取配置用途。比如  server , client_cache 等，均可以根据业务自定义
     *
     * @return config_usage - 配置用途。比如  server , client_cache 等，均可以根据业务自定义
     */
    public String getConfigUsage() {
        return configUsage;
    }

    /**
     * 设置配置用途。比如  server , client_cache 等，均可以根据业务自定义
     *
     * @param configUsage 配置用途。比如  server , client_cache 等，均可以根据业务自定义
     */
    public void setConfigUsage(String configUsage) {
        this.configUsage = configUsage;
    }

    /**
     * 获取配置的版本信息，每次变更之后版本号都会增加
     *
     * @return config_version - 配置的版本信息，每次变更之后版本号都会增加
     */
    public Integer getConfigVersion() {
        return configVersion;
    }

    /**
     * 设置配置的版本信息，每次变更之后版本号都会增加
     *
     * @param configVersion 配置的版本信息，每次变更之后版本号都会增加
     */
    public void setConfigVersion(Integer configVersion) {
        this.configVersion = configVersion;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否已清除
     *
     * @return is_deleted - 是否已清除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否已清除
     *
     * @param isDeleted 是否已清除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取配置描述，保存的内容为json
     *
     * @return config_desc - 配置描述，保存的内容为json
     */
    public String getConfigDesc() {
        return configDesc;
    }

    /**
     * 设置配置描述，保存的内容为json
     *
     * @param configDesc 配置描述，保存的内容为json
     */
    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
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
        VmMachineConfig other = (VmMachineConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVmId() == null ? other.getVmId() == null : this.getVmId().equals(other.getVmId()))
            && (this.getMacAddress() == null ? other.getMacAddress() == null : this.getMacAddress().equals(other.getMacAddress()))
            && (this.getConfigUsage() == null ? other.getConfigUsage() == null : this.getConfigUsage().equals(other.getConfigUsage()))
            && (this.getConfigVersion() == null ? other.getConfigVersion() == null : this.getConfigVersion().equals(other.getConfigVersion()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getConfigDesc() == null ? other.getConfigDesc() == null : this.getConfigDesc().equals(other.getConfigDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVmId() == null) ? 0 : getVmId().hashCode());
        result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
        result = prime * result + ((getConfigUsage() == null) ? 0 : getConfigUsage().hashCode());
        result = prime * result + ((getConfigVersion() == null) ? 0 : getConfigVersion().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getConfigDesc() == null) ? 0 : getConfigDesc().hashCode());
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
        sb.append(", macAddress=").append(macAddress);
        sb.append(", configUsage=").append(configUsage);
        sb.append(", configVersion=").append(configVersion);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", configDesc=").append(configDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}