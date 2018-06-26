package com.db_clear.entities.auto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mq_vm")
public class Vm implements Serializable {
	/**
	 * 售货机id
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 售货机编号。由采购时录入
	 */
	@Column(name = "vm_number")
	private String vmNumber;

	/**
	 * 售货机别名
	 */
	@Column(name = "vm_alias")
	private String vmAlias;

	/**
	 * 二维码的标识
	 */
	@Column(name = "numMark")
	private String nummark;

	/**
	 * 售货机mac地址或者硬件编码。由出厂时录入
	 */
	@Column(name = "mac_address")
	private String macAddress;

	/**
	 * 2g卡的ccid
	 */
	private String ccid;

	/**
	 * vm名称。由运营商自定义
	 */
	private String name;

	/**
	 * 运营状态 0：未运营 1：运营中
	 */
	@Column(name = "vm_status")
	private Integer vmStatus;

	/**
	 * 机器故障锁定不能购买，0：未锁定，1锁定
	 */
	@Column(name = "fault_lock")
	private Integer faultLock;

	/**
	 * 组合机的各个柜子的型号id, 12,34,21
	 */
	@Column(name = "vm_property_info")
	private String vmPropertyInfo;

	/**
	 * 属性表的id
	 */
	@Column(name = "property_id")
	private Long propertyId;

	/**
	 * 0：非组合机机型 1：组合机（代表主柜 ）
	 */
	@Column(name = "model_type")
	private Integer modelType;

	/**
	 * 对应的主柜和副柜的索引，按顺序从0开始排列，例如：0,1,2,3 0：代表第一台机器，1：第二台机器
	 */
	@Column(name = "group_indexes")
	private String groupIndexes;

	/**
	 * 货道类型
	 */
	@Column(name = "product_road_type")
	private String productRoadType;

	/**
	 * 总行数
	 */
	@Column(name = "sum_row")
	private Integer sumRow;

	/**
	 * 机器格子数
	 */
	@Column(name = "sum_box")
	private Integer sumBox;

	/**
	 * 省名
	 */
	private String proviceName;
	/**
	 * 市名
	 */
	private String cityName;
	/**
	 * 区县名
	 */
	private String areaName;
	/**
	 * 所在区域
	 */
	private String region;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 最后一次任务提醒时间
	 */
	@Column(name = "last_task_time")
	private Date lastTaskTime;

	/**
	 * 经度
	 */
	private Double longitude;

	/**
	 * 纬度
	 */
	private Double latitude;

	/**
	 * 加密后的售货机的机器码
	 */
	@Column(name = "vm_code")
	private String vmCode;

	/**
	 * 0：正常，1:待补货 ，2：待维修(现在待维修就是未连接，后期会加其他)
	 */
	@Column(name = "task_type")
	private Integer taskType;

	/**
	 * 巡视员id（user表中的id）
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 是否删除0:正常 1:已经删除
	 */
	@Column(name = "is_deleted")
	private Byte isDeleted;

	/**
	 * 是否联网 0：未联网，1：联网
	 */
	@Column(name = "is_online")
	private Integer isOnline;

	/**
	 * 在售格子数
	 */
	@Column(name = "on_box")
	private Integer onBox;

	/**
	 * 开始运营时间
	 */
	@Column(name = "start_operate_time")
	private Date startOperateTime;

	/**
	 * 是否支持分组 0:不支持 false，1：支持 true；
	 */
	@Column(name = "is_support_group")
	private Boolean isSupportGroup;

	@Column(name = "batch_number")
	private String batchNumber;

	/**
	 * 主板编码
	 */
	@Column(name = "mainboard_code")
	private String mainboardCode;

	/**
	 * 是否设置了位置，0：否，1：设置了
	 */
	@Column(name = "is_set_position")
	private Boolean isSetPosition;

	/**
	 * 二维码
	 */
	private String qrcode;

	/**
	 * 是否绑定过机器二维码 0-未绑定 1-已绑定
	 */
	@Column(name = "is_bind_vm")
	private Boolean isBindVm;

	/**
	 * 是否绑定过格子二维码 0-未绑定 1-已绑定
	 */
	@Column(name = "is_bind_box")
	private Boolean isBindBox;

	/**
	 * 当前的运营商。如果为0，表示未分配。查询未分配柜机的时候，可以通过这个来查询
	 */
	@Column(name = "currentOperatorId")
	private Long currentoperatorid;

	/**
	 * 售货机描述
	 */
	private String description;

	/**
	 * 设置成待维修之前的状态，-1表示没有
	 */
	@Column(name = "front_quality_status")
	private Integer frontQualityStatus;

	/**
	 * 质检端标识机器的状态，0:待激活 1：待检测 2： 检测中 3：待维修 4：已合格，5:已分配，1、2一起归为待质检
	 */
	@Column(name = "quality_status")
	private Integer qualityStatus;

	/**
	 * 绑定主板序列号是否正确 0： 否 1：是
	 */
	@Column(name = "is_correctBindingMacAddress")
	private Boolean isCorrectbindingmacaddress;

	/**
	 * 货到检测是否通过 0：否 1：是
	 */
	@Column(name = "is_throughRoadTest")
	private Boolean isThroughroadtest;

	/**
	 * 其他硬件部分是否通过检测 0：否 1：是
	 */
	@Column(name = "is_throughOtherHardwareTest")
	private Boolean isThroughotherhardwaretest;

	/**
	 * 是否通过温度检测 0：否 1：是
	 */
	@Column(name = "is_throughTemperatureTest")
	private Boolean isThroughtemperaturetest;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 商圈id
	 */
	@Column(name = "biz_area_id")
	private Long bizAreaId;

	/**
	 * 策略Id
	 */
	@Column(name = "plotId")
	private Long plotid;

	/**
	 * 是否开启自动化温度控制,0:未开启,1;开启
	 */
	@Column(name = "is_open_auto_temp_control")
	private Boolean isOpenAutoTempControl;

	/**
	 * 售货机广告版本号
	 */
	@Column(name = "version_id")
	private Integer versionId;

	/**
	 * 最后一次补货时间
	 */
	@Column(name = "last_supply_time")
	private Date lastSupplyTime;

	/**
	 * 制造商id
	 */
	@Column(name = "manufacturer_id")
	private Integer manufacturerId;

	/**
	 * 质检状态, 0000 -> 4个字节分别表示 货道，温度，网络，设备信息状态
	 */
	@Column(name = "test_state")
	private String testState;

	/**
	 * 关联的价格模板的id
	 */
	@Column(name = "price_template_id")
	private Long priceTemplateId;

	/**
	 * 价格模板变更时间
	 */
	@Column(name = "price_template_update_time")
	private Date priceTemplateUpdateTime;

	/**
	 * 质检端最近一次激活板子的时间
	 */
	@Column(name = "activate_time")
	private Date activateTime;

	/**
	 * 质检端的报错内容
	 */
	private String content;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取售货机id
	 *
	 * @return id - 售货机id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置售货机id
	 *
	 * @param id
	 *            售货机id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取售货机编号。由采购时录入
	 *
	 * @return vm_number - 售货机编号。由采购时录入
	 */
	public String getVmNumber() {
		return vmNumber;
	}

	/**
	 * 设置售货机编号。由采购时录入
	 *
	 * @param vmNumber
	 *            售货机编号。由采购时录入
	 */
	public void setVmNumber(String vmNumber) {
		this.vmNumber = vmNumber;
	}

	/**
	 * 获取售货机别名
	 *
	 * @return vm_alias - 售货机别名
	 */
	public String getVmAlias() {
		return vmAlias;
	}

	/**
	 * 设置售货机别名
	 *
	 * @param vmAlias
	 *            售货机别名
	 */
	public void setVmAlias(String vmAlias) {
		this.vmAlias = vmAlias;
	}

	/**
	 * 获取二维码的标识
	 *
	 * @return numMark - 二维码的标识
	 */
	public String getNummark() {
		return nummark;
	}

	/**
	 * 设置二维码的标识
	 *
	 * @param nummark
	 *            二维码的标识
	 */
	public void setNummark(String nummark) {
		this.nummark = nummark;
	}

	/**
	 * 获取售货机mac地址或者硬件编码。由出厂时录入
	 *
	 * @return mac_address - 售货机mac地址或者硬件编码。由出厂时录入
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * 设置售货机mac地址或者硬件编码。由出厂时录入
	 *
	 * @param macAddress
	 *            售货机mac地址或者硬件编码。由出厂时录入
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * 获取2g卡的ccid
	 *
	 * @return ccid - 2g卡的ccid
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 设置2g卡的ccid
	 *
	 * @param ccid
	 *            2g卡的ccid
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 获取vm名称。由运营商自定义
	 *
	 * @return name - vm名称。由运营商自定义
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置vm名称。由运营商自定义
	 *
	 * @param name
	 *            vm名称。由运营商自定义
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取运营状态 0：未运营 1：运营中
	 *
	 * @return vm_status - 运营状态 0：未运营 1：运营中
	 */
	public Integer getVmStatus() {
		return vmStatus;
	}

	/**
	 * 设置运营状态 0：未运营 1：运营中
	 *
	 * @param vmStatus
	 *            运营状态 0：未运营 1：运营中
	 */
	public void setVmStatus(Integer vmStatus) {
		this.vmStatus = vmStatus;
	}

	/**
	 * 获取机器故障锁定不能购买，0：未锁定，1锁定
	 *
	 * @return fault_lock - 机器故障锁定不能购买，0：未锁定，1锁定
	 */
	public Integer getFaultLock() {
		return faultLock;
	}

	/**
	 * 设置机器故障锁定不能购买，0：未锁定，1锁定
	 *
	 * @param faultLock
	 *            机器故障锁定不能购买，0：未锁定，1锁定
	 */
	public void setFaultLock(Integer faultLock) {
		this.faultLock = faultLock;
	}

	/**
	 * 获取组合机的各个柜子的型号id, 12,34,21
	 *
	 * @return vm_property_info - 组合机的各个柜子的型号id, 12,34,21
	 */
	public String getVmPropertyInfo() {
		return vmPropertyInfo;
	}

	/**
	 * 设置组合机的各个柜子的型号id, 12,34,21
	 *
	 * @param vmPropertyInfo
	 *            组合机的各个柜子的型号id, 12,34,21
	 */
	public void setVmPropertyInfo(String vmPropertyInfo) {
		this.vmPropertyInfo = vmPropertyInfo;
	}

	/**
	 * 获取属性表的id
	 *
	 * @return property_id - 属性表的id
	 */
	public Long getPropertyId() {
		return propertyId;
	}

	/**
	 * 设置属性表的id
	 *
	 * @param propertyId
	 *            属性表的id
	 */
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * 获取0：非组合机机型 1：组合机（代表主柜 ）
	 *
	 * @return model_type - 0：非组合机机型 1：组合机（代表主柜 ）
	 */
	public Integer getModelType() {
		return modelType;
	}

	/**
	 * 设置0：非组合机机型 1：组合机（代表主柜 ）
	 *
	 * @param modelType
	 *            0：非组合机机型 1：组合机（代表主柜 ）
	 */
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}

	/**
	 * 获取对应的主柜和副柜的索引，按顺序从0开始排列，例如：0,1,2,3 0：代表第一台机器，1：第二台机器
	 *
	 * @return group_indexes - 对应的主柜和副柜的索引，按顺序从0开始排列，例如：0,1,2,3 0：代表第一台机器，1：第二台机器
	 */
	public String getGroupIndexes() {
		return groupIndexes;
	}

	/**
	 * 设置对应的主柜和副柜的索引，按顺序从0开始排列，例如：0,1,2,3 0：代表第一台机器，1：第二台机器
	 *
	 * @param groupIndexes
	 *            对应的主柜和副柜的索引，按顺序从0开始排列，例如：0,1,2,3 0：代表第一台机器，1：第二台机器
	 */
	public void setGroupIndexes(String groupIndexes) {
		this.groupIndexes = groupIndexes;
	}

	/**
	 * 获取货道类型
	 *
	 * @return product_road_type - 货道类型
	 */
	public String getProductRoadType() {
		return productRoadType;
	}

	/**
	 * 设置货道类型
	 *
	 * @param productRoadType
	 *            货道类型
	 */
	public void setProductRoadType(String productRoadType) {
		this.productRoadType = productRoadType;
	}

	/**
	 * 获取总行数
	 *
	 * @return sum_row - 总行数
	 */
	public Integer getSumRow() {
		return sumRow;
	}

	/**
	 * 设置总行数
	 *
	 * @param sumRow
	 *            总行数
	 */
	public void setSumRow(Integer sumRow) {
		this.sumRow = sumRow;
	}

	/**
	 * 获取机器格子数
	 *
	 * @return sum_box - 机器格子数
	 */
	public Integer getSumBox() {
		return sumBox;
	}

	/**
	 * 设置机器格子数
	 *
	 * @param sumBox
	 *            机器格子数
	 */
	public void setSumBox(Integer sumBox) {
		this.sumBox = sumBox;
	}

	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取所在区域
	 *
	 * @return region - 所在区域
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 设置所在区域
	 *
	 * @param region
	 *            所在区域
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 获取详细地址
	 *
	 * @return address - 详细地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置详细地址
	 *
	 * @param address
	 *            详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取最后一次任务提醒时间
	 *
	 * @return last_task_time - 最后一次任务提醒时间
	 */
	public Date getLastTaskTime() {
		return lastTaskTime;
	}

	/**
	 * 设置最后一次任务提醒时间
	 *
	 * @param lastTaskTime
	 *            最后一次任务提醒时间
	 */
	public void setLastTaskTime(Date lastTaskTime) {
		this.lastTaskTime = lastTaskTime;
	}

	/**
	 * 获取经度
	 *
	 * @return longitude - 经度
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 *
	 * @param longitude
	 *            经度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取纬度
	 *
	 * @return latitude - 纬度
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度
	 *
	 * @param latitude
	 *            纬度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取加密后的售货机的机器码
	 *
	 * @return vm_code - 加密后的售货机的机器码
	 */
	public String getVmCode() {
		return vmCode;
	}

	/**
	 * 设置加密后的售货机的机器码
	 *
	 * @param vmCode
	 *            加密后的售货机的机器码
	 */
	public void setVmCode(String vmCode) {
		this.vmCode = vmCode;
	}

	/**
	 * 获取 0：正常，1:待补货 ，2：待维修(现在待维修就是未连接，后期会加其他)
	 *
	 * @return task_type - 0：正常，1:待补货 ，2：待维修(现在待维修就是未连接，后期会加其他)
	 */
	public Integer getTaskType() {
		return taskType;
	}

	/**
	 * 设置 0：正常，1:待补货 ，2：待维修(现在待维修就是未连接，后期会加其他)
	 *
	 * @param taskType
	 *            0：正常，1:待补货 ，2：待维修(现在待维修就是未连接，后期会加其他)
	 */
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	/**
	 * 获取巡视员id（user表中的id）
	 *
	 * @return user_id - 巡视员id（user表中的id）
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置巡视员id（user表中的id）
	 *
	 * @param userId
	 *            巡视员id（user表中的id）
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取是否删除0:正常 1:已经删除
	 *
	 * @return is_deleted - 是否删除0:正常 1:已经删除
	 */
	public Byte getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置是否删除0:正常 1:已经删除
	 *
	 * @param isDeleted
	 *            是否删除0:正常 1:已经删除
	 */
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 获取是否联网 0：未联网，1：联网
	 *
	 * @return is_online - 是否联网 0：未联网，1：联网
	 */
	public Integer getIsOnline() {
		return isOnline;
	}

	/**
	 * 设置是否联网 0：未联网，1：联网
	 *
	 * @param isOnline
	 *            是否联网 0：未联网，1：联网
	 */
	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	/**
	 * 获取在售格子数
	 *
	 * @return on_box - 在售格子数
	 */
	public Integer getOnBox() {
		return onBox;
	}

	/**
	 * 设置在售格子数
	 *
	 * @param onBox
	 *            在售格子数
	 */
	public void setOnBox(Integer onBox) {
		this.onBox = onBox;
	}

	/**
	 * 获取开始运营时间
	 *
	 * @return start_operate_time - 开始运营时间
	 */
	public Date getStartOperateTime() {
		return startOperateTime;
	}

	/**
	 * 设置开始运营时间
	 *
	 * @param startOperateTime
	 *            开始运营时间
	 */
	public void setStartOperateTime(Date startOperateTime) {
		this.startOperateTime = startOperateTime;
	}

	/**
	 * 获取是否支持分组 0:不支持 false，1：支持 true；
	 *
	 * @return is_support_group - 是否支持分组 0:不支持 false，1：支持 true；
	 */
	public Boolean getIsSupportGroup() {
		return isSupportGroup;
	}

	/**
	 * 设置是否支持分组 0:不支持 false，1：支持 true；
	 *
	 * @param isSupportGroup
	 *            是否支持分组 0:不支持 false，1：支持 true；
	 */
	public void setIsSupportGroup(Boolean isSupportGroup) {
		this.isSupportGroup = isSupportGroup;
	}

	/**
	 * @return batch_number
	 */
	public String getBatchNumber() {
		return batchNumber;
	}

	/**
	 * @param batchNumber
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	/**
	 * 获取主板编码
	 *
	 * @return mainboard_code - 主板编码
	 */
	public String getMainboardCode() {
		return mainboardCode;
	}

	/**
	 * 设置主板编码
	 *
	 * @param mainboardCode
	 *            主板编码
	 */
	public void setMainboardCode(String mainboardCode) {
		this.mainboardCode = mainboardCode;
	}

	/**
	 * 获取是否设置了位置，0：否，1：设置了
	 *
	 * @return is_set_position - 是否设置了位置，0：否，1：设置了
	 */
	public Boolean getIsSetPosition() {
		return isSetPosition;
	}

	/**
	 * 设置是否设置了位置，0：否，1：设置了
	 *
	 * @param isSetPosition
	 *            是否设置了位置，0：否，1：设置了
	 */
	public void setIsSetPosition(Boolean isSetPosition) {
		this.isSetPosition = isSetPosition;
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
	 * @param qrcode
	 *            二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	/**
	 * 获取是否绑定过机器二维码 0-未绑定 1-已绑定
	 *
	 * @return is_bind_vm - 是否绑定过机器二维码 0-未绑定 1-已绑定
	 */
	public Boolean getIsBindVm() {
		return isBindVm;
	}

	/**
	 * 设置是否绑定过机器二维码 0-未绑定 1-已绑定
	 *
	 * @param isBindVm
	 *            是否绑定过机器二维码 0-未绑定 1-已绑定
	 */
	public void setIsBindVm(Boolean isBindVm) {
		this.isBindVm = isBindVm;
	}

	/**
	 * 获取是否绑定过格子二维码 0-未绑定 1-已绑定
	 *
	 * @return is_bind_box - 是否绑定过格子二维码 0-未绑定 1-已绑定
	 */
	public Boolean getIsBindBox() {
		return isBindBox;
	}

	/**
	 * 设置是否绑定过格子二维码 0-未绑定 1-已绑定
	 *
	 * @param isBindBox
	 *            是否绑定过格子二维码 0-未绑定 1-已绑定
	 */
	public void setIsBindBox(Boolean isBindBox) {
		this.isBindBox = isBindBox;
	}

	/**
	 * 获取当前的运营商。如果为0，表示未分配。查询未分配柜机的时候，可以通过这个来查询
	 *
	 * @return currentOperatorId - 当前的运营商。如果为0，表示未分配。查询未分配柜机的时候，可以通过这个来查询
	 */
	public Long getCurrentoperatorid() {
		return currentoperatorid;
	}

	/**
	 * 设置当前的运营商。如果为0，表示未分配。查询未分配柜机的时候，可以通过这个来查询
	 *
	 * @param currentoperatorid
	 *            当前的运营商。如果为0，表示未分配。查询未分配柜机的时候，可以通过这个来查询
	 */
	public void setCurrentoperatorid(Long currentoperatorid) {
		this.currentoperatorid = currentoperatorid;
	}

	/**
	 * 获取售货机描述
	 *
	 * @return description - 售货机描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置售货机描述
	 *
	 * @param description
	 *            售货机描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取设置成待维修之前的状态，-1表示没有
	 *
	 * @return front_quality_status - 设置成待维修之前的状态，-1表示没有
	 */
	public Integer getFrontQualityStatus() {
		return frontQualityStatus;
	}

	/**
	 * 设置设置成待维修之前的状态，-1表示没有
	 *
	 * @param frontQualityStatus
	 *            设置成待维修之前的状态，-1表示没有
	 */
	public void setFrontQualityStatus(Integer frontQualityStatus) {
		this.frontQualityStatus = frontQualityStatus;
	}

	/**
	 * 获取质检端标识机器的状态，0:待激活 1：待检测 2： 检测中 3：待维修 4：已合格，5:已分配，1、2一起归为待质检
	 *
	 * @return quality_status - 质检端标识机器的状态，0:待激活 1：待检测 2： 检测中 3：待维修
	 *         4：已合格，5:已分配，1、2一起归为待质检
	 */
	public Integer getQualityStatus() {
		return qualityStatus;
	}

	/**
	 * 设置质检端标识机器的状态，0:待激活 1：待检测 2： 检测中 3：待维修 4：已合格，5:已分配，1、2一起归为待质检
	 *
	 * @param qualityStatus
	 *            质检端标识机器的状态，0:待激活 1：待检测 2： 检测中 3：待维修 4：已合格，5:已分配，1、2一起归为待质检
	 */
	public void setQualityStatus(Integer qualityStatus) {
		this.qualityStatus = qualityStatus;
	}

	/**
	 * 获取绑定主板序列号是否正确 0： 否 1：是
	 *
	 * @return is_correctBindingMacAddress - 绑定主板序列号是否正确 0： 否 1：是
	 */
	public Boolean getIsCorrectbindingmacaddress() {
		return isCorrectbindingmacaddress;
	}

	/**
	 * 设置绑定主板序列号是否正确 0： 否 1：是
	 *
	 * @param isCorrectbindingmacaddress
	 *            绑定主板序列号是否正确 0： 否 1：是
	 */
	public void setIsCorrectbindingmacaddress(Boolean isCorrectbindingmacaddress) {
		this.isCorrectbindingmacaddress = isCorrectbindingmacaddress;
	}

	/**
	 * 获取货到检测是否通过 0：否 1：是
	 *
	 * @return is_throughRoadTest - 货到检测是否通过 0：否 1：是
	 */
	public Boolean getIsThroughroadtest() {
		return isThroughroadtest;
	}

	/**
	 * 设置货到检测是否通过 0：否 1：是
	 *
	 * @param isThroughroadtest
	 *            货到检测是否通过 0：否 1：是
	 */
	public void setIsThroughroadtest(Boolean isThroughroadtest) {
		this.isThroughroadtest = isThroughroadtest;
	}

	/**
	 * 获取其他硬件部分是否通过检测 0：否 1：是
	 *
	 * @return is_throughOtherHardwareTest - 其他硬件部分是否通过检测 0：否 1：是
	 */
	public Boolean getIsThroughotherhardwaretest() {
		return isThroughotherhardwaretest;
	}

	/**
	 * 设置其他硬件部分是否通过检测 0：否 1：是
	 *
	 * @param isThroughotherhardwaretest
	 *            其他硬件部分是否通过检测 0：否 1：是
	 */
	public void setIsThroughotherhardwaretest(Boolean isThroughotherhardwaretest) {
		this.isThroughotherhardwaretest = isThroughotherhardwaretest;
	}

	/**
	 * 获取是否通过温度检测 0：否 1：是
	 *
	 * @return is_throughTemperatureTest - 是否通过温度检测 0：否 1：是
	 */
	public Boolean getIsThroughtemperaturetest() {
		return isThroughtemperaturetest;
	}

	/**
	 * 设置是否通过温度检测 0：否 1：是
	 *
	 * @param isThroughtemperaturetest
	 *            是否通过温度检测 0：否 1：是
	 */
	public void setIsThroughtemperaturetest(Boolean isThroughtemperaturetest) {
		this.isThroughtemperaturetest = isThroughtemperaturetest;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取商圈id
	 *
	 * @return biz_area_id - 商圈id
	 */
	public Long getBizAreaId() {
		return bizAreaId;
	}

	/**
	 * 设置商圈id
	 *
	 * @param bizAreaId
	 *            商圈id
	 */
	public void setBizAreaId(Long bizAreaId) {
		this.bizAreaId = bizAreaId;
	}

	/**
	 * 获取策略Id
	 *
	 * @return plotId - 策略Id
	 */
	public Long getPlotid() {
		return plotid;
	}

	/**
	 * 设置策略Id
	 *
	 * @param plotid
	 *            策略Id
	 */
	public void setPlotid(Long plotid) {
		this.plotid = plotid;
	}

	/**
	 * 获取是否开启自动化温度控制,0:未开启,1;开启
	 *
	 * @return is_open_auto_temp_control - 是否开启自动化温度控制,0:未开启,1;开启
	 */
	public Boolean getIsOpenAutoTempControl() {
		return isOpenAutoTempControl;
	}

	/**
	 * 设置是否开启自动化温度控制,0:未开启,1;开启
	 *
	 * @param isOpenAutoTempControl
	 *            是否开启自动化温度控制,0:未开启,1;开启
	 */
	public void setIsOpenAutoTempControl(Boolean isOpenAutoTempControl) {
		this.isOpenAutoTempControl = isOpenAutoTempControl;
	}

	/**
	 * 获取售货机广告版本号
	 *
	 * @return version_id - 售货机广告版本号
	 */
	public Integer getVersionId() {
		return versionId;
	}

	/**
	 * 设置售货机广告版本号
	 *
	 * @param versionId
	 *            售货机广告版本号
	 */
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	/**
	 * 获取最后一次补货时间
	 *
	 * @return last_supply_time - 最后一次补货时间
	 */
	public Date getLastSupplyTime() {
		return lastSupplyTime;
	}

	/**
	 * 设置最后一次补货时间
	 *
	 * @param lastSupplyTime
	 *            最后一次补货时间
	 */
	public void setLastSupplyTime(Date lastSupplyTime) {
		this.lastSupplyTime = lastSupplyTime;
	}

	/**
	 * 获取制造商id
	 *
	 * @return manufacturer_id - 制造商id
	 */
	public Integer getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * 设置制造商id
	 *
	 * @param manufacturerId
	 *            制造商id
	 */
	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * 获取质检状态, 0000 -> 4个字节分别表示 货道，温度，网络，设备信息状态
	 *
	 * @return test_state - 质检状态, 0000 -> 4个字节分别表示 货道，温度，网络，设备信息状态
	 */
	public String getTestState() {
		return testState;
	}

	/**
	 * 设置质检状态, 0000 -> 4个字节分别表示 货道，温度，网络，设备信息状态
	 *
	 * @param testState
	 *            质检状态, 0000 -> 4个字节分别表示 货道，温度，网络，设备信息状态
	 */
	public void setTestState(String testState) {
		this.testState = testState;
	}

	/**
	 * 获取关联的价格模板的id
	 *
	 * @return price_template_id - 关联的价格模板的id
	 */
	public Long getPriceTemplateId() {
		return priceTemplateId;
	}

	/**
	 * 设置关联的价格模板的id
	 *
	 * @param priceTemplateId
	 *            关联的价格模板的id
	 */
	public void setPriceTemplateId(Long priceTemplateId) {
		this.priceTemplateId = priceTemplateId;
	}

	/**
	 * 获取价格模板变更时间
	 *
	 * @return price_template_update_time - 价格模板变更时间
	 */
	public Date getPriceTemplateUpdateTime() {
		return priceTemplateUpdateTime;
	}

	/**
	 * 设置价格模板变更时间
	 *
	 * @param priceTemplateUpdateTime
	 *            价格模板变更时间
	 */
	public void setPriceTemplateUpdateTime(Date priceTemplateUpdateTime) {
		this.priceTemplateUpdateTime = priceTemplateUpdateTime;
	}

	/**
	 * 获取质检端最近一次激活板子的时间
	 *
	 * @return activate_time - 质检端最近一次激活板子的时间
	 */
	public Date getActivateTime() {
		return activateTime;
	}

	/**
	 * 设置质检端最近一次激活板子的时间
	 *
	 * @param activateTime
	 *            质检端最近一次激活板子的时间
	 */
	public void setActivateTime(Date activateTime) {
		this.activateTime = activateTime;
	}

	/**
	 * 获取质检端的报错内容
	 *
	 * @return content - 质检端的报错内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置质检端的报错内容
	 *
	 * @param content
	 *            质检端的报错内容
	 */
	public void setContent(String content) {
		this.content = content;
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
		Vm other = (Vm) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getVmNumber() == null ? other.getVmNumber() == null
						: this.getVmNumber().equals(other.getVmNumber()))
				&& (this.getVmAlias() == null ? other.getVmAlias() == null
						: this.getVmAlias().equals(other.getVmAlias()))
				&& (this.getNummark() == null ? other.getNummark() == null
						: this.getNummark().equals(other.getNummark()))
				&& (this.getMacAddress() == null ? other.getMacAddress() == null
						: this.getMacAddress().equals(other.getMacAddress()))
				&& (this.getCcid() == null ? other.getCcid() == null : this.getCcid().equals(other.getCcid()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getVmStatus() == null ? other.getVmStatus() == null
						: this.getVmStatus().equals(other.getVmStatus()))
				&& (this.getFaultLock() == null ? other.getFaultLock() == null
						: this.getFaultLock().equals(other.getFaultLock()))
				&& (this.getVmPropertyInfo() == null ? other.getVmPropertyInfo() == null
						: this.getVmPropertyInfo().equals(other.getVmPropertyInfo()))
				&& (this.getPropertyId() == null ? other.getPropertyId() == null
						: this.getPropertyId().equals(other.getPropertyId()))
				&& (this.getModelType() == null ? other.getModelType() == null
						: this.getModelType().equals(other.getModelType()))
				&& (this.getGroupIndexes() == null ? other.getGroupIndexes() == null
						: this.getGroupIndexes().equals(other.getGroupIndexes()))
				&& (this.getProductRoadType() == null ? other.getProductRoadType() == null
						: this.getProductRoadType().equals(other.getProductRoadType()))
				&& (this.getSumRow() == null ? other.getSumRow() == null : this.getSumRow().equals(other.getSumRow()))
				&& (this.getSumBox() == null ? other.getSumBox() == null : this.getSumBox().equals(other.getSumBox()))
				&& (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
				&& (this.getAddress() == null ? other.getAddress() == null
						: this.getAddress().equals(other.getAddress()))
				&& (this.getLastTaskTime() == null ? other.getLastTaskTime() == null
						: this.getLastTaskTime().equals(other.getLastTaskTime()))
				&& (this.getLongitude() == null ? other.getLongitude() == null
						: this.getLongitude().equals(other.getLongitude()))
				&& (this.getLatitude() == null ? other.getLatitude() == null
						: this.getLatitude().equals(other.getLatitude()))
				&& (this.getVmCode() == null ? other.getVmCode() == null : this.getVmCode().equals(other.getVmCode()))
				&& (this.getTaskType() == null ? other.getTaskType() == null
						: this.getTaskType().equals(other.getTaskType()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getIsDeleted() == null ? other.getIsDeleted() == null
						: this.getIsDeleted().equals(other.getIsDeleted()))
				&& (this.getIsOnline() == null ? other.getIsOnline() == null
						: this.getIsOnline().equals(other.getIsOnline()))
				&& (this.getOnBox() == null ? other.getOnBox() == null : this.getOnBox().equals(other.getOnBox()))
				&& (this.getStartOperateTime() == null ? other.getStartOperateTime() == null
						: this.getStartOperateTime().equals(other.getStartOperateTime()))
				&& (this.getIsSupportGroup() == null ? other.getIsSupportGroup() == null
						: this.getIsSupportGroup().equals(other.getIsSupportGroup()))
				&& (this.getBatchNumber() == null ? other.getBatchNumber() == null
						: this.getBatchNumber().equals(other.getBatchNumber()))
				&& (this.getMainboardCode() == null ? other.getMainboardCode() == null
						: this.getMainboardCode().equals(other.getMainboardCode()))
				&& (this.getIsSetPosition() == null ? other.getIsSetPosition() == null
						: this.getIsSetPosition().equals(other.getIsSetPosition()))
				&& (this.getQrcode() == null ? other.getQrcode() == null : this.getQrcode().equals(other.getQrcode()))
				&& (this.getIsBindVm() == null ? other.getIsBindVm() == null
						: this.getIsBindVm().equals(other.getIsBindVm()))
				&& (this.getIsBindBox() == null ? other.getIsBindBox() == null
						: this.getIsBindBox().equals(other.getIsBindBox()))
				&& (this.getCurrentoperatorid() == null ? other.getCurrentoperatorid() == null
						: this.getCurrentoperatorid().equals(other.getCurrentoperatorid()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getFrontQualityStatus() == null ? other.getFrontQualityStatus() == null
						: this.getFrontQualityStatus().equals(other.getFrontQualityStatus()))
				&& (this.getQualityStatus() == null ? other.getQualityStatus() == null
						: this.getQualityStatus().equals(other.getQualityStatus()))
				&& (this.getIsCorrectbindingmacaddress() == null ? other.getIsCorrectbindingmacaddress() == null
						: this.getIsCorrectbindingmacaddress().equals(other.getIsCorrectbindingmacaddress()))
				&& (this.getIsThroughroadtest() == null ? other.getIsThroughroadtest() == null
						: this.getIsThroughroadtest().equals(other.getIsThroughroadtest()))
				&& (this.getIsThroughotherhardwaretest() == null ? other.getIsThroughotherhardwaretest() == null
						: this.getIsThroughotherhardwaretest().equals(other.getIsThroughotherhardwaretest()))
				&& (this.getIsThroughtemperaturetest() == null ? other.getIsThroughtemperaturetest() == null
						: this.getIsThroughtemperaturetest().equals(other.getIsThroughtemperaturetest()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getBizAreaId() == null ? other.getBizAreaId() == null
						: this.getBizAreaId().equals(other.getBizAreaId()))
				&& (this.getPlotid() == null ? other.getPlotid() == null : this.getPlotid().equals(other.getPlotid()))
				&& (this.getIsOpenAutoTempControl() == null ? other.getIsOpenAutoTempControl() == null
						: this.getIsOpenAutoTempControl().equals(other.getIsOpenAutoTempControl()))
				&& (this.getVersionId() == null ? other.getVersionId() == null
						: this.getVersionId().equals(other.getVersionId()))
				&& (this.getLastSupplyTime() == null ? other.getLastSupplyTime() == null
						: this.getLastSupplyTime().equals(other.getLastSupplyTime()))
				&& (this.getManufacturerId() == null ? other.getManufacturerId() == null
						: this.getManufacturerId().equals(other.getManufacturerId()))
				&& (this.getTestState() == null ? other.getTestState() == null
						: this.getTestState().equals(other.getTestState()))
				&& (this.getPriceTemplateId() == null ? other.getPriceTemplateId() == null
						: this.getPriceTemplateId().equals(other.getPriceTemplateId()))
				&& (this.getPriceTemplateUpdateTime() == null ? other.getPriceTemplateUpdateTime() == null
						: this.getPriceTemplateUpdateTime().equals(other.getPriceTemplateUpdateTime()))
				&& (this.getActivateTime() == null ? other.getActivateTime() == null
						: this.getActivateTime().equals(other.getActivateTime()))
				&& (this.getContent() == null ? other.getContent() == null
						: this.getContent().equals(other.getContent()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getVmNumber() == null) ? 0 : getVmNumber().hashCode());
		result = prime * result + ((getVmAlias() == null) ? 0 : getVmAlias().hashCode());
		result = prime * result + ((getNummark() == null) ? 0 : getNummark().hashCode());
		result = prime * result + ((getMacAddress() == null) ? 0 : getMacAddress().hashCode());
		result = prime * result + ((getCcid() == null) ? 0 : getCcid().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getVmStatus() == null) ? 0 : getVmStatus().hashCode());
		result = prime * result + ((getFaultLock() == null) ? 0 : getFaultLock().hashCode());
		result = prime * result + ((getVmPropertyInfo() == null) ? 0 : getVmPropertyInfo().hashCode());
		result = prime * result + ((getPropertyId() == null) ? 0 : getPropertyId().hashCode());
		result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
		result = prime * result + ((getGroupIndexes() == null) ? 0 : getGroupIndexes().hashCode());
		result = prime * result + ((getProductRoadType() == null) ? 0 : getProductRoadType().hashCode());
		result = prime * result + ((getSumRow() == null) ? 0 : getSumRow().hashCode());
		result = prime * result + ((getSumBox() == null) ? 0 : getSumBox().hashCode());
		result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
		result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
		result = prime * result + ((getLastTaskTime() == null) ? 0 : getLastTaskTime().hashCode());
		result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
		result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
		result = prime * result + ((getVmCode() == null) ? 0 : getVmCode().hashCode());
		result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
		result = prime * result + ((getIsOnline() == null) ? 0 : getIsOnline().hashCode());
		result = prime * result + ((getOnBox() == null) ? 0 : getOnBox().hashCode());
		result = prime * result + ((getStartOperateTime() == null) ? 0 : getStartOperateTime().hashCode());
		result = prime * result + ((getIsSupportGroup() == null) ? 0 : getIsSupportGroup().hashCode());
		result = prime * result + ((getBatchNumber() == null) ? 0 : getBatchNumber().hashCode());
		result = prime * result + ((getMainboardCode() == null) ? 0 : getMainboardCode().hashCode());
		result = prime * result + ((getIsSetPosition() == null) ? 0 : getIsSetPosition().hashCode());
		result = prime * result + ((getQrcode() == null) ? 0 : getQrcode().hashCode());
		result = prime * result + ((getIsBindVm() == null) ? 0 : getIsBindVm().hashCode());
		result = prime * result + ((getIsBindBox() == null) ? 0 : getIsBindBox().hashCode());
		result = prime * result + ((getCurrentoperatorid() == null) ? 0 : getCurrentoperatorid().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getFrontQualityStatus() == null) ? 0 : getFrontQualityStatus().hashCode());
		result = prime * result + ((getQualityStatus() == null) ? 0 : getQualityStatus().hashCode());
		result = prime * result
				+ ((getIsCorrectbindingmacaddress() == null) ? 0 : getIsCorrectbindingmacaddress().hashCode());
		result = prime * result + ((getIsThroughroadtest() == null) ? 0 : getIsThroughroadtest().hashCode());
		result = prime * result
				+ ((getIsThroughotherhardwaretest() == null) ? 0 : getIsThroughotherhardwaretest().hashCode());
		result = prime * result
				+ ((getIsThroughtemperaturetest() == null) ? 0 : getIsThroughtemperaturetest().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getBizAreaId() == null) ? 0 : getBizAreaId().hashCode());
		result = prime * result + ((getPlotid() == null) ? 0 : getPlotid().hashCode());
		result = prime * result + ((getIsOpenAutoTempControl() == null) ? 0 : getIsOpenAutoTempControl().hashCode());
		result = prime * result + ((getVersionId() == null) ? 0 : getVersionId().hashCode());
		result = prime * result + ((getLastSupplyTime() == null) ? 0 : getLastSupplyTime().hashCode());
		result = prime * result + ((getManufacturerId() == null) ? 0 : getManufacturerId().hashCode());
		result = prime * result + ((getTestState() == null) ? 0 : getTestState().hashCode());
		result = prime * result + ((getPriceTemplateId() == null) ? 0 : getPriceTemplateId().hashCode());
		result = prime * result
				+ ((getPriceTemplateUpdateTime() == null) ? 0 : getPriceTemplateUpdateTime().hashCode());
		result = prime * result + ((getActivateTime() == null) ? 0 : getActivateTime().hashCode());
		result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", vmNumber=").append(vmNumber);
		sb.append(", vmAlias=").append(vmAlias);
		sb.append(", nummark=").append(nummark);
		sb.append(", macAddress=").append(macAddress);
		sb.append(", ccid=").append(ccid);
		sb.append(", name=").append(name);
		sb.append(", vmStatus=").append(vmStatus);
		sb.append(", faultLock=").append(faultLock);
		sb.append(", vmPropertyInfo=").append(vmPropertyInfo);
		sb.append(", propertyId=").append(propertyId);
		sb.append(", modelType=").append(modelType);
		sb.append(", groupIndexes=").append(groupIndexes);
		sb.append(", productRoadType=").append(productRoadType);
		sb.append(", sumRow=").append(sumRow);
		sb.append(", sumBox=").append(sumBox);
		sb.append(", region=").append(region);
		sb.append(", address=").append(address);
		sb.append(", lastTaskTime=").append(lastTaskTime);
		sb.append(", longitude=").append(longitude);
		sb.append(", latitude=").append(latitude);
		sb.append(", vmCode=").append(vmCode);
		sb.append(", taskType=").append(taskType);
		sb.append(", userId=").append(userId);
		sb.append(", isDeleted=").append(isDeleted);
		sb.append(", isOnline=").append(isOnline);
		sb.append(", onBox=").append(onBox);
		sb.append(", startOperateTime=").append(startOperateTime);
		sb.append(", isSupportGroup=").append(isSupportGroup);
		sb.append(", batchNumber=").append(batchNumber);
		sb.append(", mainboardCode=").append(mainboardCode);
		sb.append(", isSetPosition=").append(isSetPosition);
		sb.append(", qrcode=").append(qrcode);
		sb.append(", isBindVm=").append(isBindVm);
		sb.append(", isBindBox=").append(isBindBox);
		sb.append(", currentoperatorid=").append(currentoperatorid);
		sb.append(", description=").append(description);
		sb.append(", frontQualityStatus=").append(frontQualityStatus);
		sb.append(", qualityStatus=").append(qualityStatus);
		sb.append(", isCorrectbindingmacaddress=").append(isCorrectbindingmacaddress);
		sb.append(", isThroughroadtest=").append(isThroughroadtest);
		sb.append(", isThroughotherhardwaretest=").append(isThroughotherhardwaretest);
		sb.append(", isThroughtemperaturetest=").append(isThroughtemperaturetest);
		sb.append(", createTime=").append(createTime);
		sb.append(", bizAreaId=").append(bizAreaId);
		sb.append(", plotid=").append(plotid);
		sb.append(", isOpenAutoTempControl=").append(isOpenAutoTempControl);
		sb.append(", versionId=").append(versionId);
		sb.append(", lastSupplyTime=").append(lastSupplyTime);
		sb.append(", manufacturerId=").append(manufacturerId);
		sb.append(", testState=").append(testState);
		sb.append(", priceTemplateId=").append(priceTemplateId);
		sb.append(", priceTemplateUpdateTime=").append(priceTemplateUpdateTime);
		sb.append(", activateTime=").append(activateTime);
		sb.append(", content=").append(content);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}