package com.db_clear.entities.auto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_vm_code")
public class VmCode implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * vm 软件编码字串
     */
    private String vmcode;

    /**
     * 打印模板的id
     */
    @Column(name = "print_modal_id")
    private Short printModalId;

    /**
     * 属于 vm 的还是 vmbox 的。 0:未分配 ; 1: vm ； 2: vmbox
     */
    private Integer belong;

    /**
     * 绑定的 vm 的 id ，或者绑定的 vmbox所属的 vm id
     */
    @Column(name = "vm_id")
    private Long vmId;

    /**
     * 绑定的 vmbox 的 id ；如果绑定的是 vm ，那么这个值是 0
     */
    @Column(name = "vmbox_id")
    private Long vmboxId;

    private String qrcode;

    /**
     * 创建记录的时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 生成的批次
     */
    private String batch;

    /**
     * 生成二维码时针对的是 vm 模板
     */
    @Column(name = "vm_modal_id")
    private Short vmModalId;

    /**
     * 生成二维码时针对的是 box 模板
     */
    @Column(name = "vm_box_modal_id")
    private Short vmBoxModalId;

    /**
     * 二维码和机器的绑定状态 (0，或者null 是未绑定 ； 1：已绑定二维码和机器 )
     */
    private Short status;

    /**
     * 绑定二维码和机器的人
     */
    @Column(name = "bind_person_id")
    private Short bindPersonId;

    /**
     * 1:巡视员 2.质检员
     */
    @Column(name = "bind_person_type")
    private Short bindPersonType;

    /**
     * 数字标签。打印在二维码背景上的
     */
    @Column(name = "numMark")
    private String nummark;

    /**
     * 制造商ID
     */
    @Column(name = "manufacturer_id")
    private Integer manufacturerId;

    /**
     * 二维码类型，1：系统码 2：第三方码
     */
    private Integer type;

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
     * 获取vm 软件编码字串
     *
     * @return vmcode - vm 软件编码字串
     */
    public String getVmcode() {
        return vmcode;
    }

    /**
     * 设置vm 软件编码字串
     *
     * @param vmcode vm 软件编码字串
     */
    public void setVmcode(String vmcode) {
        this.vmcode = vmcode;
    }

    /**
     * 获取打印模板的id
     *
     * @return print_modal_id - 打印模板的id
     */
    public Short getPrintModalId() {
        return printModalId;
    }

    /**
     * 设置打印模板的id
     *
     * @param printModalId 打印模板的id
     */
    public void setPrintModalId(Short printModalId) {
        this.printModalId = printModalId;
    }

    /**
     * 获取属于 vm 的还是 vmbox 的。 0:未分配 ; 1: vm ； 2: vmbox
     *
     * @return belong - 属于 vm 的还是 vmbox 的。 0:未分配 ; 1: vm ； 2: vmbox
     */
    public Integer getBelong() {
        return belong;
    }

    /**
     * 设置属于 vm 的还是 vmbox 的。 0:未分配 ; 1: vm ； 2: vmbox
     *
     * @param belong 属于 vm 的还是 vmbox 的。 0:未分配 ; 1: vm ； 2: vmbox
     */
    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    /**
     * 获取绑定的 vm 的 id ，或者绑定的 vmbox所属的 vm id
     *
     * @return vm_id - 绑定的 vm 的 id ，或者绑定的 vmbox所属的 vm id
     */
    public Long getVmId() {
        return vmId;
    }

    /**
     * 设置绑定的 vm 的 id ，或者绑定的 vmbox所属的 vm id
     *
     * @param vmId 绑定的 vm 的 id ，或者绑定的 vmbox所属的 vm id
     */
    public void setVmId(Long vmId) {
        this.vmId = vmId;
    }

    /**
     * 获取绑定的 vmbox 的 id ；如果绑定的是 vm ，那么这个值是 0
     *
     * @return vmbox_id - 绑定的 vmbox 的 id ；如果绑定的是 vm ，那么这个值是 0
     */
    public Long getVmboxId() {
        return vmboxId;
    }

    /**
     * 设置绑定的 vmbox 的 id ；如果绑定的是 vm ，那么这个值是 0
     *
     * @param vmboxId 绑定的 vmbox 的 id ；如果绑定的是 vm ，那么这个值是 0
     */
    public void setVmboxId(Long vmboxId) {
        this.vmboxId = vmboxId;
    }

    /**
     * @return qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * @param qrcode
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 获取创建记录的时间
     *
     * @return createTime - 创建记录的时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建记录的时间
     *
     * @param createtime 创建记录的时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取生成的批次
     *
     * @return batch - 生成的批次
     */
    public String getBatch() {
        return batch;
    }

    /**
     * 设置生成的批次
     *
     * @param batch 生成的批次
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * 获取生成二维码时针对的是 vm 模板
     *
     * @return vm_modal_id - 生成二维码时针对的是 vm 模板
     */
    public Short getVmModalId() {
        return vmModalId;
    }

    /**
     * 设置生成二维码时针对的是 vm 模板
     *
     * @param vmModalId 生成二维码时针对的是 vm 模板
     */
    public void setVmModalId(Short vmModalId) {
        this.vmModalId = vmModalId;
    }

    /**
     * 获取生成二维码时针对的是 box 模板
     *
     * @return vm_box_modal_id - 生成二维码时针对的是 box 模板
     */
    public Short getVmBoxModalId() {
        return vmBoxModalId;
    }

    /**
     * 设置生成二维码时针对的是 box 模板
     *
     * @param vmBoxModalId 生成二维码时针对的是 box 模板
     */
    public void setVmBoxModalId(Short vmBoxModalId) {
        this.vmBoxModalId = vmBoxModalId;
    }

    /**
     * 获取二维码和机器的绑定状态 (0，或者null 是未绑定 ； 1：已绑定二维码和机器 )
     *
     * @return status - 二维码和机器的绑定状态 (0，或者null 是未绑定 ； 1：已绑定二维码和机器 )
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置二维码和机器的绑定状态 (0，或者null 是未绑定 ； 1：已绑定二维码和机器 )
     *
     * @param status 二维码和机器的绑定状态 (0，或者null 是未绑定 ； 1：已绑定二维码和机器 )
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取绑定二维码和机器的人
     *
     * @return bind_person_id - 绑定二维码和机器的人
     */
    public Short getBindPersonId() {
        return bindPersonId;
    }

    /**
     * 设置绑定二维码和机器的人
     *
     * @param bindPersonId 绑定二维码和机器的人
     */
    public void setBindPersonId(Short bindPersonId) {
        this.bindPersonId = bindPersonId;
    }

    /**
     * 获取1:巡视员 2.质检员
     *
     * @return bind_person_type - 1:巡视员 2.质检员
     */
    public Short getBindPersonType() {
        return bindPersonType;
    }

    /**
     * 设置1:巡视员 2.质检员
     *
     * @param bindPersonType 1:巡视员 2.质检员
     */
    public void setBindPersonType(Short bindPersonType) {
        this.bindPersonType = bindPersonType;
    }

    /**
     * 获取数字标签。打印在二维码背景上的
     *
     * @return numMark - 数字标签。打印在二维码背景上的
     */
    public String getNummark() {
        return nummark;
    }

    /**
     * 设置数字标签。打印在二维码背景上的
     *
     * @param nummark 数字标签。打印在二维码背景上的
     */
    public void setNummark(String nummark) {
        this.nummark = nummark;
    }

    /**
     * 获取制造商ID
     *
     * @return manufacturer_id - 制造商ID
     */
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    /**
     * 设置制造商ID
     *
     * @param manufacturerId 制造商ID
     */
    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * 获取二维码类型，1：系统码 2：第三方码
     *
     * @return type - 二维码类型，1：系统码 2：第三方码
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置二维码类型，1：系统码 2：第三方码
     *
     * @param type 二维码类型，1：系统码 2：第三方码
     */
    public void setType(Integer type) {
        this.type = type;
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
        VmCode other = (VmCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVmcode() == null ? other.getVmcode() == null : this.getVmcode().equals(other.getVmcode()))
            && (this.getPrintModalId() == null ? other.getPrintModalId() == null : this.getPrintModalId().equals(other.getPrintModalId()))
            && (this.getBelong() == null ? other.getBelong() == null : this.getBelong().equals(other.getBelong()))
            && (this.getVmId() == null ? other.getVmId() == null : this.getVmId().equals(other.getVmId()))
            && (this.getVmboxId() == null ? other.getVmboxId() == null : this.getVmboxId().equals(other.getVmboxId()))
            && (this.getQrcode() == null ? other.getQrcode() == null : this.getQrcode().equals(other.getQrcode()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getVmModalId() == null ? other.getVmModalId() == null : this.getVmModalId().equals(other.getVmModalId()))
            && (this.getVmBoxModalId() == null ? other.getVmBoxModalId() == null : this.getVmBoxModalId().equals(other.getVmBoxModalId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBindPersonId() == null ? other.getBindPersonId() == null : this.getBindPersonId().equals(other.getBindPersonId()))
            && (this.getBindPersonType() == null ? other.getBindPersonType() == null : this.getBindPersonType().equals(other.getBindPersonType()))
            && (this.getNummark() == null ? other.getNummark() == null : this.getNummark().equals(other.getNummark()))
            && (this.getManufacturerId() == null ? other.getManufacturerId() == null : this.getManufacturerId().equals(other.getManufacturerId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVmcode() == null) ? 0 : getVmcode().hashCode());
        result = prime * result + ((getPrintModalId() == null) ? 0 : getPrintModalId().hashCode());
        result = prime * result + ((getBelong() == null) ? 0 : getBelong().hashCode());
        result = prime * result + ((getVmId() == null) ? 0 : getVmId().hashCode());
        result = prime * result + ((getVmboxId() == null) ? 0 : getVmboxId().hashCode());
        result = prime * result + ((getQrcode() == null) ? 0 : getQrcode().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getVmModalId() == null) ? 0 : getVmModalId().hashCode());
        result = prime * result + ((getVmBoxModalId() == null) ? 0 : getVmBoxModalId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBindPersonId() == null) ? 0 : getBindPersonId().hashCode());
        result = prime * result + ((getBindPersonType() == null) ? 0 : getBindPersonType().hashCode());
        result = prime * result + ((getNummark() == null) ? 0 : getNummark().hashCode());
        result = prime * result + ((getManufacturerId() == null) ? 0 : getManufacturerId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vmcode=").append(vmcode);
        sb.append(", printModalId=").append(printModalId);
        sb.append(", belong=").append(belong);
        sb.append(", vmId=").append(vmId);
        sb.append(", vmboxId=").append(vmboxId);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", createtime=").append(createtime);
        sb.append(", batch=").append(batch);
        sb.append(", vmModalId=").append(vmModalId);
        sb.append(", vmBoxModalId=").append(vmBoxModalId);
        sb.append(", status=").append(status);
        sb.append(", bindPersonId=").append(bindPersonId);
        sb.append(", bindPersonType=").append(bindPersonType);
        sb.append(", nummark=").append(nummark);
        sb.append(", manufacturerId=").append(manufacturerId);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}