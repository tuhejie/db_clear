package com.db_clear.entities.auto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_vm_box")
public class VmBox implements Serializable {
    /**
     * 柜子id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 格子编号
     */
    @Column(name = "box_number")
    private String boxNumber;

    /**
     * 售货机id
     */
    @Column(name = "vm_id")
    private Long vmId;

    /**
     * 对应的主柜和副柜的索引，按顺序从0开始排列,0:代表主柜子,不是组合机的话，代表当前机器;1:代表第一个副柜子
     */
    @Column(name = "group_index")
    private Integer groupIndex;

    /**
     * 对应主柜或者副柜的型号
     */
    @Column(name = "vm_property_id")
    private Long vmPropertyId;

    /**
     * 商品id（operator_product表），为 -1 的话没有商品
     */
    @Column(name = "ope_product_id")
    private Long opeProductId;

    /**
     * 格子状态，0：正常， 1：售罄， 2：清货 ， 3：空 
     */
    @Column(name = "box_status")
    private Byte boxStatus;

    /**
     * 是否关门，0：未关门， 1：关门了
     */
    @Column(name = "is_lock")
    private Byte isLock;

    /**
     * 格子属性id
     */
    @Column(name = "property_id")
    private Long propertyId;

    private Integer layer;

    /**
     * 行号
     */
    private Integer row;

    /**
     * 列号
     */
    private Integer column;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 格子锁定状态：1：可正常购买 2：被订单锁定中
     */
    @Column(name = "lock_status")
    private Integer lockStatus;

    /**
     * 对应 mq_customer 主键id
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * box所在的柜机的索引号。要和 box_number 有对应关系，如果有副柜的话，连续向后递增排列。比如 index1 对应的序号是 a01,
     */
    @Column(name = "box_index")
    private Integer boxIndex;

    /**
     * box所在的柜机分组里面的索引，每台机器从0开始
     */
    @Column(name = "box_index2")
    private Integer boxIndex2;

    /**
     * 格子能容纳商品的总数
     */
    @Column(name = "sum_stock")
    private Integer sumStock;

    /**
     * 格子中当前商品的总数
     */
    @Column(name = "current_stock")
    private Integer currentStock;

    /**
     * 格子锁定的时间
     */
    @Column(name = "lock_time")
    private Date lockTime;

    /**
     * 单个货道的货道状态 ( 0:存在故障    1: 正常)
     */
    @Column(name = "box_road_status")
    private Integer boxRoadStatus;

    /**
     * 合并货道的父货道的id，非合并的货道为null
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 货道可拆分的数量，0：表示不可拆分
     */
    @Column(name = "split_quantity")
    private Integer splitQuantity;

    /**
     * 是否可用：0否 1是,主要用于拆分货道
     */
    @Column(name = "is_enable")
    private Integer isEnable;

    /**
     * 货道开柜类型 0：无反馈电磁铁 1：有反馈电磁铁 2、两线电机 3、三线电机
     */
    @Column(name = "open_type")
    private Integer openType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取柜子id
     *
     * @return id - 柜子id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置柜子id
     *
     * @param id 柜子id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取格子编号
     *
     * @return box_number - 格子编号
     */
    public String getBoxNumber() {
        return boxNumber;
    }

    /**
     * 设置格子编号
     *
     * @param boxNumber 格子编号
     */
    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    /**
     * 获取售货机id
     *
     * @return vm_id - 售货机id
     */
    public Long getVmId() {
        return vmId;
    }

    /**
     * 设置售货机id
     *
     * @param vmId 售货机id
     */
    public void setVmId(Long vmId) {
        this.vmId = vmId;
    }

    /**
     * 获取对应的主柜和副柜的索引，按顺序从0开始排列,0:代表主柜子,不是组合机的话，代表当前机器;1:代表第一个副柜子
     *
     * @return group_index - 对应的主柜和副柜的索引，按顺序从0开始排列,0:代表主柜子,不是组合机的话，代表当前机器;1:代表第一个副柜子
     */
    public Integer getGroupIndex() {
        return groupIndex;
    }

    /**
     * 设置对应的主柜和副柜的索引，按顺序从0开始排列,0:代表主柜子,不是组合机的话，代表当前机器;1:代表第一个副柜子
     *
     * @param groupIndex 对应的主柜和副柜的索引，按顺序从0开始排列,0:代表主柜子,不是组合机的话，代表当前机器;1:代表第一个副柜子
     */
    public void setGroupIndex(Integer groupIndex) {
        this.groupIndex = groupIndex;
    }

    /**
     * 获取对应主柜或者副柜的型号
     *
     * @return vm_property_id - 对应主柜或者副柜的型号
     */
    public Long getVmPropertyId() {
        return vmPropertyId;
    }

    /**
     * 设置对应主柜或者副柜的型号
     *
     * @param vmPropertyId 对应主柜或者副柜的型号
     */
    public void setVmPropertyId(Long vmPropertyId) {
        this.vmPropertyId = vmPropertyId;
    }

    /**
     * 获取商品id（operator_product表），为 -1 的话没有商品
     *
     * @return ope_product_id - 商品id（operator_product表），为 -1 的话没有商品
     */
    public Long getOpeProductId() {
        return opeProductId;
    }

    /**
     * 设置商品id（operator_product表），为 -1 的话没有商品
     *
     * @param opeProductId 商品id（operator_product表），为 -1 的话没有商品
     */
    public void setOpeProductId(Long opeProductId) {
        this.opeProductId = opeProductId;
    }

    /**
     * 获取格子状态，0：正常， 1：售罄， 2：清货 ， 3：空 
     *
     * @return box_status - 格子状态，0：正常， 1：售罄， 2：清货 ， 3：空 
     */
    public Byte getBoxStatus() {
        return boxStatus;
    }

    /**
     * 设置格子状态，0：正常， 1：售罄， 2：清货 ， 3：空 
     *
     * @param boxStatus 格子状态，0：正常， 1：售罄， 2：清货 ， 3：空 
     */
    public void setBoxStatus(Byte boxStatus) {
        this.boxStatus = boxStatus;
    }

    /**
     * 获取是否关门，0：未关门， 1：关门了
     *
     * @return is_lock - 是否关门，0：未关门， 1：关门了
     */
    public Byte getIsLock() {
        return isLock;
    }

    /**
     * 设置是否关门，0：未关门， 1：关门了
     *
     * @param isLock 是否关门，0：未关门， 1：关门了
     */
    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
    }

    /**
     * 获取格子属性id
     *
     * @return property_id - 格子属性id
     */
    public Long getPropertyId() {
        return propertyId;
    }

    /**
     * 设置格子属性id
     *
     * @param propertyId 格子属性id
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return layer
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * @param layer
     */
    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /**
     * 获取行号
     *
     * @return row - 行号
     */
    public Integer getRow() {
        return row;
    }

    /**
     * 设置行号
     *
     * @param row 行号
     */
    public void setRow(Integer row) {
        this.row = row;
    }

    /**
     * 获取列号
     *
     * @return column - 列号
     */
    public Integer getColumn() {
        return column;
    }

    /**
     * 设置列号
     *
     * @param column 列号
     */
    public void setColumn(Integer column) {
        this.column = column;
    }

    /**
     * 获取二维码
     *
     * @return qrcode - 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置二维码
     *
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 获取格子锁定状态：1：可正常购买 2：被订单锁定中
     *
     * @return lock_status - 格子锁定状态：1：可正常购买 2：被订单锁定中
     */
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置格子锁定状态：1：可正常购买 2：被订单锁定中
     *
     * @param lockStatus 格子锁定状态：1：可正常购买 2：被订单锁定中
     */
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * 获取对应 mq_customer 主键id
     *
     * @return customer_id - 对应 mq_customer 主键id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置对应 mq_customer 主键id
     *
     * @param customerId 对应 mq_customer 主键id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取box所在的柜机的索引号。要和 box_number 有对应关系，如果有副柜的话，连续向后递增排列。比如 index1 对应的序号是 a01,
     *
     * @return box_index - box所在的柜机的索引号。要和 box_number 有对应关系，如果有副柜的话，连续向后递增排列。比如 index1 对应的序号是 a01,
     */
    public Integer getBoxIndex() {
        return boxIndex;
    }

    /**
     * 设置box所在的柜机的索引号。要和 box_number 有对应关系，如果有副柜的话，连续向后递增排列。比如 index1 对应的序号是 a01,
     *
     * @param boxIndex box所在的柜机的索引号。要和 box_number 有对应关系，如果有副柜的话，连续向后递增排列。比如 index1 对应的序号是 a01,
     */
    public void setBoxIndex(Integer boxIndex) {
        this.boxIndex = boxIndex;
    }

    /**
     * 获取box所在的柜机分组里面的索引，每台机器从0开始
     *
     * @return box_index2 - box所在的柜机分组里面的索引，每台机器从0开始
     */
    public Integer getBoxIndex2() {
        return boxIndex2;
    }

    /**
     * 设置box所在的柜机分组里面的索引，每台机器从0开始
     *
     * @param boxIndex2 box所在的柜机分组里面的索引，每台机器从0开始
     */
    public void setBoxIndex2(Integer boxIndex2) {
        this.boxIndex2 = boxIndex2;
    }

    /**
     * 获取格子能容纳商品的总数
     *
     * @return sum_stock - 格子能容纳商品的总数
     */
    public Integer getSumStock() {
        return sumStock;
    }

    /**
     * 设置格子能容纳商品的总数
     *
     * @param sumStock 格子能容纳商品的总数
     */
    public void setSumStock(Integer sumStock) {
        this.sumStock = sumStock;
    }

    /**
     * 获取格子中当前商品的总数
     *
     * @return current_stock - 格子中当前商品的总数
     */
    public Integer getCurrentStock() {
        return currentStock;
    }

    /**
     * 设置格子中当前商品的总数
     *
     * @param currentStock 格子中当前商品的总数
     */
    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    /**
     * 获取格子锁定的时间
     *
     * @return lock_time - 格子锁定的时间
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * 设置格子锁定的时间
     *
     * @param lockTime 格子锁定的时间
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * 获取单个货道的货道状态 ( 0:存在故障    1: 正常)
     *
     * @return box_road_status - 单个货道的货道状态 ( 0:存在故障    1: 正常)
     */
    public Integer getBoxRoadStatus() {
        return boxRoadStatus;
    }

    /**
     * 设置单个货道的货道状态 ( 0:存在故障    1: 正常)
     *
     * @param boxRoadStatus 单个货道的货道状态 ( 0:存在故障    1: 正常)
     */
    public void setBoxRoadStatus(Integer boxRoadStatus) {
        this.boxRoadStatus = boxRoadStatus;
    }

    /**
     * 获取合并货道的父货道的id，非合并的货道为null
     *
     * @return parent_id - 合并货道的父货道的id，非合并的货道为null
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置合并货道的父货道的id，非合并的货道为null
     *
     * @param parentId 合并货道的父货道的id，非合并的货道为null
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取货道可拆分的数量，0：表示不可拆分
     *
     * @return split_quantity - 货道可拆分的数量，0：表示不可拆分
     */
    public Integer getSplitQuantity() {
        return splitQuantity;
    }

    /**
     * 设置货道可拆分的数量，0：表示不可拆分
     *
     * @param splitQuantity 货道可拆分的数量，0：表示不可拆分
     */
    public void setSplitQuantity(Integer splitQuantity) {
        this.splitQuantity = splitQuantity;
    }

    /**
     * 获取是否可用：0否 1是,主要用于拆分货道
     *
     * @return is_enable - 是否可用：0否 1是,主要用于拆分货道
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否可用：0否 1是,主要用于拆分货道
     *
     * @param isEnable 是否可用：0否 1是,主要用于拆分货道
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取货道开柜类型 0：无反馈电磁铁 1：有反馈电磁铁 2、两线电机 3、三线电机
     *
     * @return open_type - 货道开柜类型 0：无反馈电磁铁 1：有反馈电磁铁 2、两线电机 3、三线电机
     */
    public Integer getOpenType() {
        return openType;
    }

    /**
     * 设置货道开柜类型 0：无反馈电磁铁 1：有反馈电磁铁 2、两线电机 3、三线电机
     *
     * @param openType 货道开柜类型 0：无反馈电磁铁 1：有反馈电磁铁 2、两线电机 3、三线电机
     */
    public void setOpenType(Integer openType) {
        this.openType = openType;
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
        VmBox other = (VmBox) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBoxNumber() == null ? other.getBoxNumber() == null : this.getBoxNumber().equals(other.getBoxNumber()))
            && (this.getVmId() == null ? other.getVmId() == null : this.getVmId().equals(other.getVmId()))
            && (this.getGroupIndex() == null ? other.getGroupIndex() == null : this.getGroupIndex().equals(other.getGroupIndex()))
            && (this.getVmPropertyId() == null ? other.getVmPropertyId() == null : this.getVmPropertyId().equals(other.getVmPropertyId()))
            && (this.getOpeProductId() == null ? other.getOpeProductId() == null : this.getOpeProductId().equals(other.getOpeProductId()))
            && (this.getBoxStatus() == null ? other.getBoxStatus() == null : this.getBoxStatus().equals(other.getBoxStatus()))
            && (this.getIsLock() == null ? other.getIsLock() == null : this.getIsLock().equals(other.getIsLock()))
            && (this.getPropertyId() == null ? other.getPropertyId() == null : this.getPropertyId().equals(other.getPropertyId()))
            && (this.getLayer() == null ? other.getLayer() == null : this.getLayer().equals(other.getLayer()))
            && (this.getRow() == null ? other.getRow() == null : this.getRow().equals(other.getRow()))
            && (this.getColumn() == null ? other.getColumn() == null : this.getColumn().equals(other.getColumn()))
            && (this.getQrcode() == null ? other.getQrcode() == null : this.getQrcode().equals(other.getQrcode()))
            && (this.getLockStatus() == null ? other.getLockStatus() == null : this.getLockStatus().equals(other.getLockStatus()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getBoxIndex() == null ? other.getBoxIndex() == null : this.getBoxIndex().equals(other.getBoxIndex()))
            && (this.getBoxIndex2() == null ? other.getBoxIndex2() == null : this.getBoxIndex2().equals(other.getBoxIndex2()))
            && (this.getSumStock() == null ? other.getSumStock() == null : this.getSumStock().equals(other.getSumStock()))
            && (this.getCurrentStock() == null ? other.getCurrentStock() == null : this.getCurrentStock().equals(other.getCurrentStock()))
            && (this.getLockTime() == null ? other.getLockTime() == null : this.getLockTime().equals(other.getLockTime()))
            && (this.getBoxRoadStatus() == null ? other.getBoxRoadStatus() == null : this.getBoxRoadStatus().equals(other.getBoxRoadStatus()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSplitQuantity() == null ? other.getSplitQuantity() == null : this.getSplitQuantity().equals(other.getSplitQuantity()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
            && (this.getOpenType() == null ? other.getOpenType() == null : this.getOpenType().equals(other.getOpenType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBoxNumber() == null) ? 0 : getBoxNumber().hashCode());
        result = prime * result + ((getVmId() == null) ? 0 : getVmId().hashCode());
        result = prime * result + ((getGroupIndex() == null) ? 0 : getGroupIndex().hashCode());
        result = prime * result + ((getVmPropertyId() == null) ? 0 : getVmPropertyId().hashCode());
        result = prime * result + ((getOpeProductId() == null) ? 0 : getOpeProductId().hashCode());
        result = prime * result + ((getBoxStatus() == null) ? 0 : getBoxStatus().hashCode());
        result = prime * result + ((getIsLock() == null) ? 0 : getIsLock().hashCode());
        result = prime * result + ((getPropertyId() == null) ? 0 : getPropertyId().hashCode());
        result = prime * result + ((getLayer() == null) ? 0 : getLayer().hashCode());
        result = prime * result + ((getRow() == null) ? 0 : getRow().hashCode());
        result = prime * result + ((getColumn() == null) ? 0 : getColumn().hashCode());
        result = prime * result + ((getQrcode() == null) ? 0 : getQrcode().hashCode());
        result = prime * result + ((getLockStatus() == null) ? 0 : getLockStatus().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getBoxIndex() == null) ? 0 : getBoxIndex().hashCode());
        result = prime * result + ((getBoxIndex2() == null) ? 0 : getBoxIndex2().hashCode());
        result = prime * result + ((getSumStock() == null) ? 0 : getSumStock().hashCode());
        result = prime * result + ((getCurrentStock() == null) ? 0 : getCurrentStock().hashCode());
        result = prime * result + ((getLockTime() == null) ? 0 : getLockTime().hashCode());
        result = prime * result + ((getBoxRoadStatus() == null) ? 0 : getBoxRoadStatus().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getSplitQuantity() == null) ? 0 : getSplitQuantity().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getOpenType() == null) ? 0 : getOpenType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", boxNumber=").append(boxNumber);
        sb.append(", vmId=").append(vmId);
        sb.append(", groupIndex=").append(groupIndex);
        sb.append(", vmPropertyId=").append(vmPropertyId);
        sb.append(", opeProductId=").append(opeProductId);
        sb.append(", boxStatus=").append(boxStatus);
        sb.append(", isLock=").append(isLock);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", layer=").append(layer);
        sb.append(", row=").append(row);
        sb.append(", column=").append(column);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", lockStatus=").append(lockStatus);
        sb.append(", customerId=").append(customerId);
        sb.append(", boxIndex=").append(boxIndex);
        sb.append(", boxIndex2=").append(boxIndex2);
        sb.append(", sumStock=").append(sumStock);
        sb.append(", currentStock=").append(currentStock);
        sb.append(", lockTime=").append(lockTime);
        sb.append(", boxRoadStatus=").append(boxRoadStatus);
        sb.append(", parentId=").append(parentId);
        sb.append(", splitQuantity=").append(splitQuantity);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", openType=").append(openType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}