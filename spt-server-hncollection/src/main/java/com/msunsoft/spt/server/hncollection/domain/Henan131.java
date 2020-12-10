package com.msunsoft.spt.server.hncollection.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.msunsoft.spt.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
    *
    * </p>
 *
 * @author zxl
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("HENAN_131")
public class Henan131 extends BaseDomain {

    private static final long serialVersionUID = 1L;

    /**
     * 统一社会信用代码
     */
    @TableField("TYSHXYDM")
    private String tyshxydm;

    /**
     * 组织机构代码
     */
    @TableField("ZZJGDM")
    private String zzjgdm;

    /**
     * 机构名称
     */
    @TableField("JGMC")
    private String jgmc;

    /**
     * 登记注册类型代码
     */
    @TableField("DJZCLXDM")
    private String djzclxdm;

    /**
     * 机构分类管理代码
     */
    @TableField("JGFLGLDM")
    private String jgflgldm;

    /**
     * 单位所在乡镇街道名称
     */
    @TableField("DWSZXZJDMC")
    private String dwszxzjdmc;

    /**
     * 设置/主办单位代码
     */
    @TableField("SZZBDWDM")
    private String szzbdwdm;

    /**
     * 医疗卫生机构类别代码
     */
    @TableField("YLWSJGLBDM")
    private String ylwsjglbdm;

    /**
     * 行政区划代码
     */
    @TableField("XZQHDM")
    private String xzqhdm;

    /**
     * 乡镇街道代码
     */
    @TableField("XZJDDM")
    private String xzjddm;

    /**
     * 政府办医疗卫生机构隶属关系代码
     */
    @TableField("ZFBYLWSJGLSGXDM")
    private String zfbylwsjglsgxdm;

    /**
     * 单位所在地是否民族自治地方
     */
    @TableField("DWSZDSFMZZZDF")
    private String dwszdsfmzzzdf;

    /**
     * 是否分支机构
     */
    @TableField("SFFZJG")
    private String sffzjg;

    /**
     * 主院地址
     */
    @TableField("ZYDZ")
    private String zydz;

    /**
     * 主院经度
     */
    @TableField("ZYJD")
    private String zyjd;

    /**
     * 主院纬度
     */
    @TableField("ZYWD")
    private String zywd;

    /**
     * 分院1（非分支机构）地址
     */
    @TableField("FY1FFZJGDZ")
    private String fy1ffzjgdz;

    /**
     * 分院2（非分支机构）地址
     */
    @TableField("FY2FFZJGDZ")
    private String fy2ffzjgdz;

    /**
     * 分院1（非分支机构）经度
     */
    @TableField("FY1FFZJGJD")
    private String fy1ffzjgjd;

    /**
     * 分院1（非分支机构）纬度
     */
    @TableField("FY1FFZJGWD")
    private String fy1ffzjgwd;

    /**
     * 分院2（非分支机构）经度
     */
    @TableField("FY2FFZJGJD")
    private String fy2ffzjgjd;

    /**
     * 分院2（非分支机构）纬度
     */
    @TableField("FY2FFZJGWD")
    private String fy2ffzjgwd;

    /**
     * 邮政编码
     */
    @TableField("YZBM")
    private String yzbm;

    /**
     * 联系电话
     */
    @TableField("LXDH")
    private String lxdh;

    /**
     * 单位电子邮箱
     */
    @TableField("DWDZYX")
    private String dwdzyx;

    /**
     * 单位网站域名
     */
    @TableField("DWWZYM")
    private String dwwzym;

    /**
     * 单位成立时间（年）
     */
    @TableField("DWCLSJN")
    private String dwclsjn;

    /**
     * 法人代表(单位负责人)
     */
    @TableField("FRDBDWFZR")
    private String frdbdwfzr;

    /**
     * 第二名称是否为社区卫生服务中心
     */
    @TableField("DEMCSFWSQWSFWZX")
    private String demcsfwsqwsfwzx;

    /**
     * 下设直属分站(院、所)个数
     */
    @TableField("XSZSFZYSGS")
    private Integer xszsfzysgs;

    /**
     * 其中社区卫生服务站个数
     */
    @TableField("QZSQWSFWZGS")
    private Integer qzsqwsfwzgs;

    /**
     * 政府主管部门确定的医院级别
     */
    @TableField("ZFZGBMQDDYYJB")
    private String zfzgbmqddyyjb;

    /**
     * 评定的医院等次
     */
    @TableField("PDDYYDC")
    private String pddyydc;

    /**
     * 是否政府主管部门确定的区域医疗中心
     */
    @TableField("SFZFZGBMQDDQYYLZX")
    private String sfzfzgbmqddqyylzx;

    /**
     * 区域医疗中心类别
     */
    @TableField("QYYLZXLB")
    private String qyylzxlb;

    /**
     * 区域医疗中心级别
     */
    @TableField("QYYLZXJB")
    private String qyylzxjb;

    /**
     * 政府主管部门确定的临床重点专科个数（国家级）
     */
    @TableField("ZFZGBMQDDLCCDZKGSGJJ")
    private Integer zfzgbmqddlccdzkgsgjj;

    /**
     * 政府主管部门确定的临床重点专科个数（省级）
     */
    @TableField("ZFZGBMQDDLCCDZKGSSHJ")
    private Integer zfzgbmqddlccdzkgsshj;

    /**
     * 政府主管部门确定的临床重点专科个数（市级）
     */
    @TableField("ZFZGBMQDDLCCDZKGSSIJ")
    private Integer zfzgbmqddlccdzkgssij;

    /**
     * 年内政府投资的临床重点专科建设项目个数（国家级）
     */
    @TableField("NNZFTZDLCCDZKJSXMGSGJJ")
    private Integer nnzftzdlccdzkjsxmgsgjj;

    /**
     * 年内政府投资的临床重点专科建设项目个数（省级）
     */
    @TableField("NNZFTZDLCCDZKJSXMGSSHJ")
    private Integer nnzftzdlccdzkjsxmgsshj;

    /**
     * 年内政府投资的临床重点专科建设项目个数（市级）
     */
    @TableField("NNZFTZDLCCDZKJSXMGSSIJ")
    private Integer nnzftzdlccdzkjsxmgssij;

    /**
     * 是否达到建设标准
     */
    @TableField("SFDDJSBZ")
    private String sfddjsbz;

    /**
     * 是否120急救网络覆盖医院
     */
    @TableField("SF120JJWLFGYY")
    private String sf120jjwlfgyy;

    /**
     * 是否国务院或卫生健康行政部门公布的住院医师规范化培训基地
     */
    @TableField("SFGWYHWSJKXZBMGBDZYYSGFHPXJD")
    private String sfgwyhwsjkxzbmgbdzyysgfhpxjd;

    /**
     * 当年招收人数
     */
    @TableField("DNZSRS")
    private Integer dnzsrs;

    /**
     * 当年招收全科医生人数
     */
    @TableField("DNZSQKYSRS")
    private Integer dnzsqkysrs;

    /**
     * 当年招收中医类别全科医生人数
     */
    @TableField("DNZSZYLBQKYSRS")
    private Integer dnzszylbqkysrs;

    /**
     * 当年在培人数
     */
    @TableField("DNZPRS")
    private Integer dnzprs;

    /**
     * 当年在培全科医生人数
     */
    @TableField("DNZPQKYSRS")
    private Integer dnzpqkysrs;

    /**
     * 当年在培中医类别全科医生人数
     */
    @TableField("DNZPZYLBQKYSRS")
    private Integer dnzpzylbqkysrs;

    /**
     * 当年结业人数
     */
    @TableField("DNJYRS")
    private Integer dnjyrs;

    /**
     * 当年结业全科医生人数
     */
    @TableField("DNJYQKYSRS")
    private Integer dnjyqkysrs;

    /**
     * 当年结业中医类别全科医生人数
     */
    @TableField("DNJYZYLBQKYSRS")
    private Integer dnjyzylbqkysrs;

    /**
     * 是否政府认定的全科医生实践基地
     */
    @TableField("SFZFRDDQKYSSJJD")
    private String sfzfrddqkyssjjd;

    /**
     * 医保定点医疗机构
     */
    @TableField("YBDDYLJG")
    private String ybddyljg;

    /**
     * 是否与医保经办机构直接结算
     */
    @TableField("SFYYBJBJGZJJS")
    private String sfyybjbjgzjjs;

    /**
     * 是否与新农合经办机构直接结算
     */
    @TableField("SFYXNHJBJGZJJS")
    private String sfyxnhjbjgzjjs;

    /**
     * 信息系统建设情况
     */
    @TableField("XXXTJSQK")
    private String xxxtjsqk;

    /**
     * 药房总数
     */
    @TableField("YFZS")
    private Integer yfzs;

    /**
     * 门诊药房数
     */
    @TableField("MZYFS")
    private Integer mzyfs;

    /**
     * 住院药房数
     */
    @TableField("ZYYFS")
    private Integer zyyfs;

    /**
     * 中药房数
     */
    @TableField("ZYFS")
    private Integer zyfs;

    /**
     * 是否取得母婴保健技术服务执业许可证
     */
    @TableField("SFQDMYBJJSFWZYXKZ")
    private String sfqdmybjjsfwzyxkz;

    /**
     * 是否开展卫生监督协管服务
     */
    @TableField("SFKZWSJDXGFW")
    private String sfkzwsjdxgfw;

    /**
     * 是否开展互联网诊疗服务
     */
    @TableField("SFKZHLWZLFW")
    private String sfkzhlwzlfw;

    /**
     * 是否第二名称为互联网医院
     */
    @TableField("SFDEMCWHLWYY")
    private String sfdemcwhlwyy;

    /**
     * 是否参与医联体
     */
    @TableField("SFCYYLT")
    private String sfcyylt;

    /**
     * 参与医联体形式
     */
    @TableField("CYYLTXS")
    private String cyyltxs;

    /**
     * 编制人数
     */
    @TableField("BZRS")
    private Integer bzrs;

    /**
     * 在编人数
     */
    @TableField("ZBRS")
    private Integer zbrs;

    /**
     * 在岗职工数
     */
    @TableField("ZGZGS")
    private Integer zgzgs;

    /**
     * 卫生技术人员人数
     */
    @TableField("WSJSRYRS")
    private Integer wsjsryrs;

    /**
     * 执业医师人数
     */
    @TableField("ZYYSRS")
    private Integer zyysrs;

    /**
     * 执业医师临床类别人数
     */
    @TableField("ZYYSLCLBRS")
    private Integer zyyslclbrs;

    /**
     * 执业医师中医类别人数
     */
    @TableField("ZYYSZYLBRS")
    private Integer zyyszylbrs;

    /**
     * 执业医师口腔类别人数
     */
    @TableField("ZYYSKQLBRS")
    private Integer zyyskqlbrs;

    /**
     * 执业医师公共卫生类别人数
     */
    @TableField("ZYYSGGWSLBRS")
    private Integer zyysggwslbrs;

    /**
     * 执业助理医师人数
     */
    @TableField("ZYZLYSRS")
    private Integer zyzlysrs;

    /**
     * 执业助理医师临床类别人数
     */
    @TableField("ZYZLYSLCLBRS")
    private Integer zyzlyslclbrs;

    /**
     * 执业助理医师中医类别人数
     */
    @TableField("ZYZLYSZYLBRS")
    private Integer zyzlyszylbrs;

    /**
     * 执业助理医师口腔类别人数
     */
    @TableField("ZYZLYSKQLBRS")
    private Integer zyzlyskqlbrs;

    /**
     * 执业助理医师公共卫生类别人数
     */
    @TableField("ZYZLYSGGWSLBRS")
    private Integer zyzlysggwslbrs;

    /**
     * 执业(助理)医师中注册为全科医学专业的人数
     */
    @TableField("ZYZLYSZZCWQKYXZYDRS")
    private Integer zyzlyszzcwqkyxzydrs;

    /**
     * 执业(助理)医师中取得全科医生培训合格证书的人数
     */
    @TableField("ZYZLYSZQDQKYSPXHGZSDRS")
    private Integer zyzlyszqdqkyspxhgzsdrs;

    /**
     * 执业(助理)医师中注册多地点执业的医师数
     */
    @TableField("ZYZLYSZZCDDDZYDYSS")
    private Integer zyzlyszzcdddzydyss;

    /**
     * 注册护士人数
     */
    @TableField("ZCHSRS")
    private Integer zchsrs;

    /**
     * 助产士人数
     */
    @TableField("ZCSRS")
    private Integer zcsrs;

    /**
     * 药师(士)人数
     */
    @TableField("YSSRS")
    private Integer yssrs;

    /**
     * 西药师(士)人数
     */
    @TableField("XYSSRS")
    private Integer xyssrs;

    /**
     * 中药师(士)人数
     */
    @TableField("ZYSSRS")
    private Integer zyssrs;

    /**
     * 检验技师(士)人数
     */
    @TableField("JYJSSRS")
    private Integer jyjssrs;

    /**
     * 影像技师(士)人数
     */
    @TableField("YXJSSRS")
    private Integer yxjssrs;

    /**
     * 其他卫生技术人员人数
     */
    @TableField("QTWSJSRYRS")
    private Integer qtwsjsryrs;

    /**
     * 见习医师人数
     */
    @TableField("JXYSRS")
    private Integer jxysrs;

    /**
     * 见习医师中中医人数
     */
    @TableField("JXYSZZYRS")
    private Integer jxyszzyrs;

    /**
     * 其他技术人员人数
     */
    @TableField("QTJSRYRS")
    private Integer qtjsryrs;

    /**
     * 管理人员人数
     */
    @TableField("GLRYRS")
    private Integer glryrs;

    /**
     * 工勤技能人员人数
     */
    @TableField("GQJNRYRS")
    private Integer gqjnryrs;

    /**
     * 离退休人员人数
     */
    @TableField("LTXRYRS")
    private Integer ltxryrs;

    /**
     * 年内退休人员人数
     */
    @TableField("NNTXRYRS")
    private Integer nntxryrs;

    /**
     * 年内培训情况人数
     */
    @TableField("NNPXQKRS")
    private Integer nnpxqkrs;

    /**
     * 参加政府举办的岗位培训人次数
     */
    @TableField("CJZFJBDGWPXRCS")
    private Integer cjzfjbdgwpxrcs;

    /**
     * 接受继续医学教育人数
     */
    @TableField("JSJXYXJYRS")
    private Integer jsjxyxjyrs;

    /**
     * 进修半年以上人数
     */
    @TableField("JXBNYSRS")
    private Integer jxbnysrs;

    /**
     * 年内人员流动情况流入
     */
    @TableField("NNRYLDQKLR")
    private Integer nnryldqklr;

    /**
     * 年内人员流动情况流出
     */
    @TableField("NNRYLDQKLC")
    private Integer nnryldqklc;

    /**
     * 在职人员中取得母婴保健技术服务资质的人员人数
     */
    @TableField("ZZRYZQDMYBJJSFWZZDRYRS")
    private Integer zzryzqdmybjjsfwzzdryrs;

    /**
     * 编制床位数
     */
    @TableField("BZCWS")
    private Integer bzcws;

    /**
     * 实有床位数
     */
    @TableField("SYCWS")
    private Integer sycws;

    /**
     * 特需服务床位数
     */
    @TableField("TXFWCWS")
    private Integer txfwcws;

    /**
     * 负压病房床位数
     */
    @TableField("FYBFCWS")
    private Integer fybfcws;

    /**
     * 实际开放总床日数
     */
    @TableField("SJKFZCRS")
    private Integer sjkfzcrs;

    /**
     * 实际占用总床日数
     */
    @TableField("SJZYZCRS")
    private Integer sjzyzcrs;

    /**
     * 出院者占用总床日数
     */
    @TableField("CYZZYZCRS")
    private Integer cyzzyzcrs;

    /**
     * 观察床数
     */
    @TableField("GCCS")
    private Integer gccs;

    /**
     * 全年开设家庭病床总数
     */
    @TableField("QNKSJTBCZS")
    private Integer qnksjtbczs;

    /**
     * 年末房屋建筑面积
     */
    @TableField("NMFWJZMJ")
    private Integer nmfwjzmj;

    /**
     * 建筑面积业务用房面积
     */
    @TableField("JZMJYWYFMJ")
    private Integer jzmjywyfmj;

    /**
     * 危房面积
     */
    @TableField("WFMJ")
    private Integer wfmj;

    /**
     * 年末租房面积
     */
    @TableField("NMZFMJ")
    private Integer nmzfmj;

    /**
     * 租房面积业务用房面积
     */
    @TableField("ZFMJYWYFMJ")
    private Integer zfmjywyfmj;

    /**
     * 本年房屋租金
     */
    @TableField("BNFWZJ")
    private BigDecimal bnfwzj;

    /**
     * 本年批准基建项目数
     */
    @TableField("BNPZJJXMS")
    private Integer bnpzjjxms;

    /**
     * 本年批准基建项目建筑面积
     */
    @TableField("BNPZJJXMJZMJ")
    private Integer bnpzjjxmjzmj;

    /**
     * 本年实际完成投资额
     */
    @TableField("BNSJWCTZE")
    private BigDecimal bnsjwctze;

    /**
     * 财政性投资额
     */
    @TableField("CZXTZE")
    private BigDecimal czxtze;

    /**
     * 单位自有资金
     */
    @TableField("DWZYZJ")
    private BigDecimal dwzyzj;

    /**
     * 银行贷款
     */
    @TableField("YXDK")
    private BigDecimal yxdk;

    /**
     * 本年房屋竣工面积
     */
    @TableField("BNFWJGMJ")
    private Integer bnfwjgmj;

    /**
     * 本年新增固定资产
     */
    @TableField("BNXZGDZC")
    private BigDecimal bnxzgdzc;

    /**
     * 本年因新扩建增加床位
     */
    @TableField("BNYXKJZJCW")
    private Integer bnyxkjzjcw;

    /**
     * 万元以上设备总价值
     */
    @TableField("WYYSSBZJZ")
    private BigDecimal wyyssbzjz;

    /**
     * 万元以上设备台数
     */
    @TableField("WYYSSBTS")
    private Integer wyyssbts;

    /**
     * 10-49万元设备台数
     */
    @TableField("SDSJWYSBTS")
    private Integer sdsjwysbts;

    /**
     * 50-99万元设备台数
     */
    @TableField("WSDJSJWYSBTS")
    private Integer wsdjsjwysbts;

    /**
     * 100万元及以上设备台数
     */
    @TableField("YBWWYJYSSBTS")
    private Integer ybwwyjyssbts;

    /**
     * 总收入
     */
    @TableField("ZSR")
    private BigDecimal zsr;

    /**
     * 医疗收入
     */
    @TableField("YLSR")
    private BigDecimal ylsr;

    /**
     * 门诊收入
     */
    @TableField("MZSR")
    private BigDecimal mzsr;

    /**
     * 门诊收入挂号收入
     */
    @TableField("MZSRGHSR")
    private BigDecimal mzsrghsr;

    /**
     * 门诊收入诊察收入
     */
    @TableField("MZSRZCSR")
    private BigDecimal mzsrzcsr;

    /**
     * 门诊收入检查收入
     */
    @TableField("MZSRJCSR")
    private BigDecimal mzsrjcsr;

    /**
     * 门诊收入化验收入
     */
    @TableField("MZSRHYSR")
    private BigDecimal mzsrhysr;

    /**
     * 门诊收入治疗收入
     */
    @TableField("MZSRZLSR")
    private BigDecimal mzsrzlsr;

    /**
     * 门诊收入手术收入
     */
    @TableField("MZSRSSSR")
    private BigDecimal mzsrsssr;

    /**
     * 门诊收入卫生材料收入
     */
    @TableField("MZSRWSCLSR")
    private BigDecimal mzsrwsclsr;

    /**
     * 门诊收入高值耗材收入
     */
    @TableField("MZSRGZHCSR")
    private BigDecimal mzsrgzhcsr;

    /**
     * 门诊收入药品收入
     */
    @TableField("MZSRYPSR")
    private BigDecimal mzsrypsr;

    /**
     * 门诊收入西药收入
     */
    @TableField("MZSRXYSR")
    private BigDecimal mzsrxysr;

    /**
     * 门诊收入中草药收入
     */
    @TableField("MZSRZCAOYSR")
    private BigDecimal mzsrzcaoysr;

    /**
     * 门诊收入中成药收入
     */
    @TableField("MZSRZCYSR")
    private BigDecimal mzsrzcysr;

    /**
     * 门诊收入药事服务费收入
     */
    @TableField("MZSRYSFWFSR")
    private BigDecimal mzsrysfwfsr;

    /**
     * 其他门诊收入
     */
    @TableField("QTMZSR")
    private BigDecimal qtmzsr;

    /**
     * 住院收入
     */
    @TableField("ZYSR")
    private BigDecimal zysr;

    /**
     * 住院收入床位收入
     */
    @TableField("ZYSRCWSR")
    private BigDecimal zysrcwsr;

    /**
     * 住院收入诊察收入
     */
    @TableField("ZYSRZCSR")
    private BigDecimal zysrzcsr;

    /**
     * 住院收入检查收入
     */
    @TableField("ZYSRJCSR")
    private BigDecimal zysrjcsr;

    /**
     * 住院收入化验收入
     */
    @TableField("ZYSRHYSR")
    private BigDecimal zysrhysr;

    /**
     * 住院收入治疗收入
     */
    @TableField("ZYSRZLSR")
    private BigDecimal zysrzlsr;

    /**
     * 住院收入手术收入
     */
    @TableField("ZYSRSSSR")
    private BigDecimal zysrsssr;

    /**
     * 住院收入护理收入
     */
    @TableField("ZYSRHLSR")
    private BigDecimal zysrhlsr;

    /**
     * 住院收入卫生材料收入
     */
    @TableField("ZYSRWSCLSR")
    private BigDecimal zysrwsclsr;

    /**
     * 住院收入高值耗材收入
     */
    @TableField("ZYSRGZHCSR")
    private BigDecimal zysrgzhcsr;

    /**
     * 住院收入药品收入
     */
    @TableField("ZYSRYPSR")
    private BigDecimal zysrypsr;

    /**
     * 住院收入西药收入
     */
    @TableField("ZYSRXYSR")
    private BigDecimal zysrxysr;

    /**
     * 住院收入中草药收入
     */
    @TableField("ZYSRZCAOYSR")
    private BigDecimal zysrzcaoysr;

    /**
     * 住院收入中成药收入
     */
    @TableField("ZYSRZCYSR")
    private BigDecimal zysrzcysr;

    /**
     * 住院收入药事服务费收入
     */
    @TableField("ZYSRYSFWFSR")
    private BigDecimal zysrysfwfsr;

    /**
     * 其他住院收入
     */
    @TableField("QTZYSR")
    private BigDecimal qtzysr;

    /**
     * 门诊和住院药品收入中基本药物收入
     */
    @TableField("MZHZYYPSRZJBYWSR")
    private BigDecimal mzhzyypsrzjbywsr;

    /**
     * 财政补助收入
     */
    @TableField("CZBZSR")
    private BigDecimal czbzsr;

    /**
     * 财政补助基本支出
     */
    @TableField("CZBZJBZC")
    private BigDecimal czbzjbzc;

    /**
     * 财政补助项目支出
     */
    @TableField("CZBZXMZC")
    private BigDecimal czbzxmzc;

    /**
     * 基本建设资金
     */
    @TableField("JBJSZJ")
    private BigDecimal jbjszj;

    /**
     * 科教项目收入
     */
    @TableField("KJXMSR")
    private BigDecimal kjxmsr;

    /**
     * 其他收入
     */
    @TableField("QTSR")
    private BigDecimal qtsr;

    /**
     * 城镇职工基本医疗保险
     */
    @TableField("CZZGJBYLBX")
    private BigDecimal czzgjbylbx;

    /**
     * 城乡居民基本医疗保险
     */
    @TableField("CXJMJBYLBX")
    private BigDecimal cxjmjbylbx;

    /**
     * 新型农村合作医疗补偿收入
     */
    @TableField("XXNCHZYLBCSR")
    private BigDecimal xxnchzylbcsr;

    /**
     * 总费用/支出
     */
    @TableField("ZFYZC")
    private BigDecimal zfyzc;

    /**
     * 医疗业务成本
     */
    @TableField("YLYWCB")
    private BigDecimal ylywcb;

    /**
     * 临床服务成本
     */
    @TableField("LCFWCB")
    private BigDecimal lcfwcb;

    /**
     * 医疗技术成本
     */
    @TableField("YLJSCB")
    private BigDecimal yljscb;

    /**
     * 医疗辅助成本
     */
    @TableField("YLFZCB")
    private BigDecimal ylfzcb;

    /**
     * 财政项目补助支出
     */
    @TableField("CZXMBZZC")
    private BigDecimal czxmbzzc;

    /**
     * 科教项目支出
     */
    @TableField("KJXMZC")
    private BigDecimal kjxmzc;

    /**
     * 管理费用
     */
    @TableField("GLFY")
    private BigDecimal glfy;

    /**
     * 离退休费
     */
    @TableField("LTXF")
    private BigDecimal ltxf;

    /**
     * 其他支出
     */
    @TableField("QTZC")
    private BigDecimal qtzc;

    /**
     * 人员经费
     */
    @TableField("RYJF")
    private BigDecimal ryjf;

    /**
     * 基本工资
     */
    @TableField("JBGZ")
    private BigDecimal jbgz;

    /**
     * 津贴补贴
     */
    @TableField("JTBT")
    private BigDecimal jtbt;

    /**
     * 奖金
     */
    @TableField("JJ")
    private BigDecimal jj;

    /**
     * 社会保障缴费
     */
    @TableField("SHBZJF")
    private BigDecimal shbzjf;

    /**
     * 绩效工资
     */
    @TableField("JXGZ")
    private BigDecimal jxgz;

    /**
     * 伙食补助
     */
    @TableField("HSBZ")
    private BigDecimal hsbz;

    /**
     * 卫生材料费
     */
    @TableField("WSCLF")
    private BigDecimal wsclf;

    /**
     * 药品费
     */
    @TableField("YPF")
    private BigDecimal ypf;

    /**
     * 基本药物支出
     */
    @TableField("JBYWZC")
    private BigDecimal jbywzc;

    /**
     * 总资产
     */
    @TableField("ZZC")
    private BigDecimal zzc;

    /**
     * 流动资产
     */
    @TableField("LDZC")
    private BigDecimal ldzc;

    /**
     * 非流动资产
     */
    @TableField("FLDZC")
    private BigDecimal fldzc;

    /**
     * 固定资产
     */
    @TableField("GDZC")
    private BigDecimal gdzc;

    /**
     * 在建工程
     */
    @TableField("ZJGC")
    private BigDecimal zjgc;

    /**
     * 无形资产
     */
    @TableField("WXZC")
    private BigDecimal wxzc;

    /**
     * 负债与净资产
     */
    @TableField("FZYJZC")
    private BigDecimal fzyjzc;

    /**
     * 流动负债
     */
    @TableField("LDFZ")
    private BigDecimal ldfz;

    /**
     * 非流动负债
     */
    @TableField("FLDFZ")
    private BigDecimal fldfz;

    /**
     * 长期负债
     */
    @TableField("CQFZ")
    private BigDecimal cqfz;

    /**
     * 净资产
     */
    @TableField("JZC")
    private BigDecimal jzc;

    /**
     * 事业基金
     */
    @TableField("SYJJ")
    private BigDecimal syjj;

    /**
     * 专用基金
     */
    @TableField("ZYJJ")
    private BigDecimal zyjj;

    /**
     * 其他净资产
     */
    @TableField("QTJZC")
    private BigDecimal qtjzc;

    /**
     * 总诊疗人次数
     */
    @TableField("ZZLRCS")
    private Long zzlrcs;

    /**
     * 门诊人次数
     */
    @TableField("MZRCS")
    private Long mzrcs;

    /**
     * 急诊人次数
     */
    @TableField("JZRCS")
    private Long jzrcs;

    /**
     * 急诊人次数死亡人数
     */
    @TableField("JZRCSSWRS")
    private Long jzrcsswrs;

    /**
     * 家庭卫生服务人次数
     */
    @TableField("JTWSFWRCS")
    private Long jtwsfwrcs;

    /**
     * 互联网诊疗服务人次数
     */
    @TableField("HLWZLFWRCS")
    private Long hlwzlfwrcs;

    /**
     * 预约诊疗人次数
     */
    @TableField("YYZLRCS")
    private Long yyzlrcs;

    /**
     * 观察室留观病例数
     */
    @TableField("GCSLGBLS")
    private Long gcslgbls;

    /**
     * 观察室留观病例死亡人数
     */
    @TableField("GCSLGBLSWRS")
    private Long gcslgblswrs;

    /**
     * 健康检查人次数
     */
    @TableField("JKJCRCS")
    private Long jkjcrcs;

    /**
     * 入院人数
     */
    @TableField("RYRS")
    private Long ryrs;

    /**
     * 出院人数
     */
    @TableField("CYRS")
    private Long cyrs;

    /**
     * 出院转往基层医疗卫生机构人数
     */
    @TableField("CYZWJCYLWSJGRS")
    private Long cyzwjcylwsjgrs;

    /**
     * 死亡人数
     */
    @TableField("SWRS")
    private Long swrs;

    /**
     * 住院病人手术人次数
     */
    @TableField("ZYBRSSRCS")
    private Long zybrssrcs;

    /**
     * 门诊处方总数
     */
    @TableField("MZCFZS")
    private Long mzcfzs;

    /**
     * 使用抗菌药物的处方数
     */
    @TableField("SYKJYWDCFS")
    private Long sykjywdcfs;

    /**
     * 中医处方数
     */
    @TableField("ZYCFS")
    private Long zycfs;

    /**
     * 肾透析人次数
     */
    @TableField("STXRCS")
    private Long stxrcs;

    /**
     * 药物不良反应报告例数
     */
    @TableField("YWBLFYBGLS")
    private Long ywblfybgls;

    /**
     * 医疗纠纷例数
     */
    @TableField("YLJFLS")
    private Long yljfls;

    /**
     * 临床用血总量
     */
    @TableField("LCYXZL")
    private Integer lcyxzl;

    /**
     * 全血量
     */
    @TableField("QXL")
    private Integer qxl;

    /**
     * 红细胞量
     */
    @TableField("HXBL")
    private Integer hxbl;

    /**
     * 血浆量
     */
    @TableField("XJL")
    private Integer xjl;

    /**
     * 血小板量
     */
    @TableField("XXBL")
    private Integer xxbl;

    /**
     * 年末服务(常住)人口数
     */
    @TableField("NMFWCZRKS")
    private Long nmfwczrks;

    /**
     * 0-6岁儿童数
     */
    @TableField("LDLSETS")
    private Integer ldlsets;

    /**
     * 0-3岁儿童数
     */
    @TableField("LDSSETS")
    private Integer ldssets;

    /**
     * 65岁及以上人口数
     */
    @TableField("LSWSJYSRKS")
    private Integer lswsjysrks;

    /**
     * 年末居民健康档案累计建档人数
     */
    @TableField("NMJMJKDALJJDRS")
    private Long nmjmjkdaljjdrs;

    /**
     * 规范化电子建档人数
     */
    @TableField("GFHDZJDRS")
    private Long gfhdzjdrs;

    /**
     * 年内公众健康咨询活动总受益人数
     */
    @TableField("NNGZJKZXHDZSYRS")
    private Long nngzjkzxhdzsyrs;

    /**
     * 年内健康知识讲座总受益人数
     */
    @TableField("NNJKZSJZZSYRS")
    private Long nnjkzsjzzsyrs;

    /**
     * 年内0-6岁儿童预防接种人次数
     */
    @TableField("NNLDLSETYFJZRCS")
    private Long nnldlsetyfjzrcs;

    /**
     * 年末0-6岁儿童健康管理人数
     */
    @TableField("NMLDLSETJKGLRS")
    private Long nmldlsetjkglrs;

    /**
     * 年末孕产妇早孕建册人数
     */
    @TableField("NMYCFZYJCRS")
    private Long nmycfzyjcrs;

    /**
     * 年末65岁以上老人健康管理人数
     */
    @TableField("NMLSWSYSLRJKGLRS")
    private Long nmlswsyslrjkglrs;

    /**
     * 年末高血压患者累计管理人数
     */
    @TableField("NMGXYHZLJGLRS")
    private Long nmgxyhzljglrs;

    /**
     * 年末糖尿病患者累计管理人数
     */
    @TableField("NMTNBHZLJGLRS")
    private Long nmtnbhzljglrs;

    /**
     * 年末严重精神障碍管理人数
     */
    @TableField("NMYCJSZAGLRS")
    private Long nmycjszaglrs;

    /**
     * 年末肺结核患者健康管理人数
     */
    @TableField("NMFJHHZJKGLRS")
    private Long nmfjhhzjkglrs;

    /**
     * 年内传染病和突发公共卫生事件报告例数
     */
    @TableField("NNCRBHTFGGWSSJBGLS")
    private Long nncrbhtfggwssjbgls;

    /**
     * 卫生监督协管巡查次数
     */
    @TableField("WSJDXGXCCS")
    private Long wsjdxgxccs;

    /**
     * 年末中医药健康管理人数
     */
    @TableField("NMZYYJKGLRS")
    private Long nmzyyjkglrs;

    /**
     * 0-3岁儿童中医药健康管理人数
     */
    @TableField("LDSSETZYYJKGLRS")
    private Long ldssetzyyjkglrs;

    /**
     * 65岁以上老人中医药健康管理人数
     */
    @TableField("LSWSYSLRZYYJKGLRS")
    private Long lswsyslrzyyjkglrs;

    /**
     * 预防保健科实有床位
     */
    @TableField("YFBJKSYCW")
    private Integer yfbjksycw;

    /**
     * 预防保健科门急诊人次
     */
    @TableField("YFBJKMJZRC")
    private Integer yfbjkmjzrc;

    /**
     * 预防保健科出院人数
     */
    @TableField("YFBJKCYRS")
    private Integer yfbjkcyrs;

    /**
     * 全科医疗科实有床位
     */
    @TableField("QKYLKSYCW")
    private Integer qkylksycw;

    /**
     * 全科医疗科门急诊人次
     */
    @TableField("QKYLKMJZRC")
    private Integer qkylkmjzrc;

    /**
     * 全科医疗科出院人数
     */
    @TableField("QKYLKCYRS")
    private Integer qkylkcyrs;

    /**
     * 内科实有床位
     */
    @TableField("NKSYCW")
    private Integer nksycw;

    /**
     * 内科门急诊人次
     */
    @TableField("NKMJZRC")
    private Integer nkmjzrc;

    /**
     * 内科出院人数
     */
    @TableField("NKCYRS")
    private Integer nkcyrs;

    /**
     * 外科实有床位
     */
    @TableField("WKSYCW")
    private Integer wksycw;

    /**
     * 外科门急诊人次
     */
    @TableField("WKMJZRC")
    private Integer wkmjzrc;

    /**
     * 外科出院人数
     */
    @TableField("WKCYRS")
    private Integer wkcyrs;

    /**
     * 妇产科实有床位
     */
    @TableField("FCKSYCW")
    private Integer fcksycw;

    /**
     * 妇产科门急诊人次
     */
    @TableField("FCKMJZRC")
    private Integer fckmjzrc;

    /**
     * 妇产科出院人数
     */
    @TableField("FCKCYRS")
    private Integer fckcyrs;

    /**
     * 妇女保健科实有床位
     */
    @TableField("FNBJKSYCW")
    private Integer fnbjksycw;

    /**
     * 妇女保健科门急诊人次
     */
    @TableField("FNBJKMJZRC")
    private Integer fnbjkmjzrc;

    /**
     * 妇女保健科出院人数
     */
    @TableField("FNBJKCYRS")
    private Integer fnbjkcyrs;

    /**
     * 儿科实有床位
     */
    @TableField("EKSYCW")
    private Integer eksycw;

    /**
     * 儿科门急诊人次
     */
    @TableField("EKMJZRC")
    private Integer ekmjzrc;

    /**
     * 儿科出院人数
     */
    @TableField("EKCYRS")
    private Integer ekcyrs;

    /**
     * 小儿外科实有床位
     */
    @TableField("XEWKSYCW")
    private Integer xewksycw;

    /**
     * 小儿外科门急诊人次
     */
    @TableField("XEWKMJZRC")
    private Integer xewkmjzrc;

    /**
     * 小儿外科出院人数
     */
    @TableField("XEWKCYRS")
    private Integer xewkcyrs;

    /**
     * 儿童保健科实有床位
     */
    @TableField("ETBJKSYCW")
    private Integer etbjksycw;

    /**
     * 儿童保健科门急诊人次
     */
    @TableField("ETBJKMJZRC")
    private Integer etbjkmjzrc;

    /**
     * 儿童保健科出院人数
     */
    @TableField("ETBJKCYRS")
    private Integer etbjkcyrs;

    /**
     * 眼科实有床位
     */
    @TableField("YKSYCW")
    private Integer yksycw;

    /**
     * 眼科门急诊人次
     */
    @TableField("YKMJZRC")
    private Integer ykmjzrc;

    /**
     * 眼科出院人数
     */
    @TableField("YKCYRS")
    private Integer ykcyrs;

    /**
     * 耳鼻咽喉科实有床位
     */
    @TableField("EBYHKSYCW")
    private Integer ebyhksycw;

    /**
     * 耳鼻咽喉科门急诊人次
     */
    @TableField("EBYHKMJZRC")
    private Integer ebyhkmjzrc;

    /**
     * 耳鼻咽喉科出院人数
     */
    @TableField("EBYHKCYRS")
    private Integer ebyhkcyrs;

    /**
     * 口腔科实有床位
     */
    @TableField("KQKSYCW")
    private Integer kqksycw;

    /**
     * 口腔科门急诊人次
     */
    @TableField("KQKMJZRC")
    private Integer kqkmjzrc;

    /**
     * 口腔科出院人数
     */
    @TableField("KQKCYRS")
    private Integer kqkcyrs;

    /**
     * 皮肤科实有床位
     */
    @TableField("PFKSYCW")
    private Integer pfksycw;

    /**
     * 皮肤科门急诊人次
     */
    @TableField("PFKMJZRC")
    private Integer pfkmjzrc;

    /**
     * 皮肤科出院人数
     */
    @TableField("PFKCYRS")
    private Integer pfkcyrs;

    /**
     * 医疗美容科实有床位
     */
    @TableField("YLMRKSYCW")
    private Integer ylmrksycw;

    /**
     * 医疗美容科门急诊人次
     */
    @TableField("YLMRKMJZRC")
    private Integer ylmrkmjzrc;

    /**
     * 医疗美容科出院人数
     */
    @TableField("YLMRKCYRS")
    private Integer ylmrkcyrs;

    /**
     * 精神科实有床位
     */
    @TableField("JSKSYCW")
    private Integer jsksycw;

    /**
     * 精神科门急诊人次
     */
    @TableField("JSKMJZRC")
    private Integer jskmjzrc;

    /**
     * 精神科出院人数
     */
    @TableField("JSKCYRS")
    private Integer jskcyrs;

    /**
     * 传染科实有床位
     */
    @TableField("CRKSYCW")
    private Integer crksycw;

    /**
     * 传染科门急诊人次
     */
    @TableField("CRKMJZRC")
    private Integer crkmjzrc;

    /**
     * 传染科出院人数
     */
    @TableField("CRKCYRS")
    private Integer crkcyrs;

    /**
     * 结核病科实有床位
     */
    @TableField("JHBKSYCW")
    private Integer jhbksycw;

    /**
     * 结核病科门急诊人次
     */
    @TableField("JHBKMJZRC")
    private Integer jhbkmjzrc;

    /**
     * 结核病科出院人数
     */
    @TableField("JHBKCYRS")
    private Integer jhbkcyrs;

    /**
     * 地方病科实有床位
     */
    @TableField("DFBKSYCW")
    private Integer dfbksycw;

    /**
     * 地方病科门急诊人次
     */
    @TableField("DFBKMJZRC")
    private Integer dfbkmjzrc;

    /**
     * 地方病科出院人数
     */
    @TableField("DFBKCYRS")
    private Integer dfbkcyrs;

    /**
     * 肿瘤科实有床位
     */
    @TableField("ZLKSYCW")
    private Integer zlksycw;

    /**
     * 肿瘤科门急诊人次
     */
    @TableField("ZLKMJZRC")
    private Integer zlkmjzrc;

    /**
     * 肿瘤科出院人数
     */
    @TableField("ZLKCYRS")
    private Integer zlkcyrs;

    /**
     * 急诊医学科实有床位
     */
    @TableField("JZYXKSYCW")
    private Integer jzyxksycw;

    /**
     * 急诊医学科门急诊人次
     */
    @TableField("JZYXKMJZRC")
    private Integer jzyxkmjzrc;

    /**
     * 急诊医学科出院人数
     */
    @TableField("JZYXKCYRS")
    private Integer jzyxkcyrs;

    /**
     * 康复医学科实有床位
     */
    @TableField("KFYXKSYCW")
    private Integer kfyxksycw;

    /**
     * 康复医学科门急诊人次
     */
    @TableField("KFYXKMJZRC")
    private Integer kfyxkmjzrc;

    /**
     * 康复医学科出院人数
     */
    @TableField("KFYXKCYRS")
    private Integer kfyxkcyrs;

    /**
     * 运动医学科实有床位
     */
    @TableField("YDYXKSYCW")
    private Integer ydyxksycw;

    /**
     * 运动医学科门急诊人次
     */
    @TableField("YDYXKMJZRC")
    private Integer ydyxkmjzrc;

    /**
     * 运动医学科出院人数
     */
    @TableField("YDYXKCYRS")
    private Integer ydyxkcyrs;

    /**
     * 职业病科实有床位
     */
    @TableField("ZYBKSYCW")
    private Integer zybksycw;

    /**
     * 职业病科门急诊人次
     */
    @TableField("ZYBKMJZRC")
    private Integer zybkmjzrc;

    /**
     * 职业病科出院人数
     */
    @TableField("ZYBKCYRS")
    private Integer zybkcyrs;

    /**
     * 临终关怀科实有床位
     */
    @TableField("LZGHKSYCW")
    private Integer lzghksycw;

    /**
     * 临终关怀科门急诊人次
     */
    @TableField("LZGHKMJZRC")
    private Integer lzghkmjzrc;

    /**
     * 临终关怀科出院人数
     */
    @TableField("LZGHKCYRS")
    private Integer lzghkcyrs;

    /**
     * 疼痛科实有床位
     */
    @TableField("TTKSYCW")
    private Integer ttksycw;

    /**
     * 疼痛科门急诊人次
     */
    @TableField("TTKMJZRC")
    private Integer ttkmjzrc;

    /**
     * 疼痛科出院人数
     */
    @TableField("TTKCYRS")
    private Integer ttkcyrs;

    /**
     * 重症医学科实有床位
     */
    @TableField("CZYXKSYCW")
    private Integer czyxksycw;

    /**
     * 重症医学科门急诊人次
     */
    @TableField("CZYXKMJZRC")
    private Integer czyxkmjzrc;

    /**
     * 重症医学科出院人数
     */
    @TableField("CZYXKCYRS")
    private Integer czyxkcyrs;

    /**
     * 中医科实有床位
     */
    @TableField("ZYKSYCW")
    private Integer zyksycw;

    /**
     * 中医科门急诊人次
     */
    @TableField("ZYKMJZRC")
    private Integer zykmjzrc;

    /**
     * 中医科出院人数
     */
    @TableField("ZYKCYRS")
    private Integer zykcyrs;

    /**
     * 维吾尔医学科实有床位
     */
    @TableField("WWEYXKSYCW")
    private Integer wweyxksycw;

    /**
     * 维吾尔医学科门急诊人次
     */
    @TableField("WWEYXKMJZRC")
    private Integer wweyxkmjzrc;

    /**
     * 维吾尔医学科出院人数
     */
    @TableField("WWEYXKCYRS")
    private Integer wweyxkcyrs;

    /**
     * 藏医学科实有床位
     */
    @TableField("CYXKSYCW")
    private Integer cyxksycw;

    /**
     * 藏医学科门急诊人次
     */
    @TableField("CYXKMJZRC")
    private Integer cyxkmjzrc;

    /**
     * 藏医学科出院人数
     */
    @TableField("CYXKCYRS")
    private Integer cyxkcyrs;

    /**
     * 蒙医学科实有床位
     */
    @TableField("MYXKSYCW")
    private Integer myxksycw;

    /**
     * 蒙医学科门急诊人次
     */
    @TableField("MYXKMJZRC")
    private Integer myxkmjzrc;

    /**
     * 蒙医学科出院人数
     */
    @TableField("MYXKCYRS")
    private Integer myxkcyrs;

    /**
     * 彝医学科实有床位
     */
    @TableField("YYXKSYCW")
    private Integer yyxksycw;

    /**
     * 彝医学科门急诊人次
     */
    @TableField("YYXKMJZRC")
    private Integer yyxkmjzrc;

    /**
     * 彝医学科出院人数
     */
    @TableField("YYXKCYRS")
    private Integer yyxkcyrs;

    /**
     * 傣医学科实有床位
     */
    @TableField("DYXKSYCW")
    private Integer dyxksycw;

    /**
     * 傣医学科门急诊人次
     */
    @TableField("DYXKMJZRC")
    private Integer dyxkmjzrc;

    /**
     * 傣医学科出院人数
     */
    @TableField("DYXKCYRS")
    private Integer dyxkcyrs;

    /**
     * 其他民族医学科实有床位
     */
    @TableField("QTMZYXKSYCW")
    private Integer qtmzyxksycw;

    /**
     * 其他民族医学科门急诊人次
     */
    @TableField("QTMZYXKMJZRC")
    private Integer qtmzyxkmjzrc;

    /**
     * 其他民族医学科出院人数
     */
    @TableField("QTMZYXKCYRS")
    private Integer qtmzyxkcyrs;

    /**
     * 中西医结合科实有床位
     */
    @TableField("ZXYJHKSYCW")
    private Integer zxyjhksycw;

    /**
     * 中西医结合科门急诊人次
     */
    @TableField("ZXYJHKMJZRC")
    private Integer zxyjhkmjzrc;

    /**
     * 中西医结合科出院人数
     */
    @TableField("ZXYJHKCYRS")
    private Integer zxyjhkcyrs;

    /**
     * 其他科实有床位
     */
    @TableField("QTKSYCW")
    private Integer qtksycw;

    /**
     * 其他科门急诊人次
     */
    @TableField("QTKMJZRC")
    private Integer qtkmjzrc;

    /**
     * 其他科出院人数
     */
    @TableField("QTKCYRS")
    private Integer qtkcyrs;

    /**
     * 内科（中医）实有床位
     */
    @TableField("NKZYSYCW")
    private Integer nkzysycw;

    /**
     * 内科（中医）门急诊人次
     */
    @TableField("NKZYMJZRC")
    private Integer nkzymjzrc;

    /**
     * 内科（中医）出院人数
     */
    @TableField("NKZYCYRS")
    private Integer nkzycyrs;

    /**
     * 外科（中医）实有床位
     */
    @TableField("WKZYSYCW")
    private Integer wkzysycw;

    /**
     * 外科（中医）门急诊人次
     */
    @TableField("WKZYMJZRC")
    private Integer wkzymjzrc;

    /**
     * 外科（中医）出院人数
     */
    @TableField("WKZYCYRS")
    private Integer wkzycyrs;

    /**
     * 妇产科（中医）实有床位
     */
    @TableField("FCKZYSYCW")
    private Integer fckzysycw;

    /**
     * 妇产科（中医）门急诊人次
     */
    @TableField("FCKZYMJZRC")
    private Integer fckzymjzrc;

    /**
     * 妇产科（中医）出院人数
     */
    @TableField("FCKZYCYRS")
    private Integer fckzycyrs;

    /**
     * 儿科（中医）实有床位
     */
    @TableField("EKZYSYCW")
    private Integer ekzysycw;

    /**
     * 儿科（中医）门急诊人次
     */
    @TableField("EKZYMJZRC")
    private Integer ekzymjzrc;

    /**
     * 儿科（中医）出院人数
     */
    @TableField("EKZYCYRS")
    private Integer ekzycyrs;

    /**
     * 皮肤科（中医）实有床位
     */
    @TableField("PFKZYSYCW")
    private Integer pfkzysycw;

    /**
     * 皮肤科（中医）门急诊人次
     */
    @TableField("PFKZYMJZRC")
    private Integer pfkzymjzrc;

    /**
     * 皮肤科（中医）出院人数
     */
    @TableField("PFKZYCYRS")
    private Integer pfkzycyrs;

    /**
     * 眼科（中医）实有床位
     */
    @TableField("YKZYSYCW")
    private Integer ykzysycw;

    /**
     * 眼科（中医）门急诊人次
     */
    @TableField("YKZYMJZRC")
    private Integer ykzymjzrc;

    /**
     * 眼科（中医）出院人数
     */
    @TableField("YKZYCYRS")
    private Integer ykzycyrs;

    /**
     * 耳鼻咽喉科（中医）实有床位
     */
    @TableField("EBYHKZYSYCW")
    private Integer ebyhkzysycw;

    /**
     * 耳鼻咽喉科（中医）门急诊人次
     */
    @TableField("EBYHKZYMJZRC")
    private Integer ebyhkzymjzrc;

    /**
     * 耳鼻咽喉科（中医）出院人数
     */
    @TableField("EBYHKZYCYRS")
    private Integer ebyhkzycyrs;

    /**
     * 口腔科（中医）实有床位
     */
    @TableField("KQKZYSYCW")
    private Integer kqkzysycw;

    /**
     * 口腔科（中医）门急诊人次
     */
    @TableField("KQKZYMJZRC")
    private Integer kqkzymjzrc;

    /**
     * 口腔科（中医）出院人数
     */
    @TableField("KQKZYCYRS")
    private Integer kqkzycyrs;

    /**
     * 肿瘤科（中医）实有床位
     */
    @TableField("ZLKZYSYCW")
    private Integer zlkzysycw;

    /**
     * 肿瘤科（中医）门急诊人次
     */
    @TableField("ZLKZYMJZRC")
    private Integer zlkzymjzrc;

    /**
     * 肿瘤科（中医）出院人数
     */
    @TableField("ZLKZYCYRS")
    private Integer zlkzycyrs;

    /**
     * 骨伤科（中医）实有床位
     */
    @TableField("GSKZYSYCW")
    private Integer gskzysycw;

    /**
     * 骨伤科（中医）门急诊人次
     */
    @TableField("GSKZYMJZRC")
    private Integer gskzymjzrc;

    /**
     * 骨伤科（中医）出院人数
     */
    @TableField("GSKZYCYRS")
    private Integer gskzycyrs;

    /**
     * 肛肠科（中医）实有床位
     */
    @TableField("GCKZYSYCW")
    private Integer gckzysycw;

    /**
     * 肛肠科（中医）门急诊人次
     */
    @TableField("GCKZYMJZRC")
    private Integer gckzymjzrc;

    /**
     * 肛肠科（中
     */
    @TableField("GCKZ")
    private Integer gckz;

    /**
     * 老年病科（中医）实有床位
     */
    @TableField("LNBKZYSYCW")
    private Integer lnbkzysycw;

    /**
     * 老年病科（中医）门急诊人次
     */
    @TableField("LNBKZYMJZRC")
    private Integer lnbkzymjzrc;

    /**
     * 老年病科（中医）出院人数
     */
    @TableField("LNBKZYCYRS")
    private Integer lnbkzycyrs;

    /**
     * 针灸科（中医）实有床位
     */
    @TableField("ZJKZYSYCW")
    private Integer zjkzysycw;

    /**
     * 针灸科（中医）门急诊人次
     */
    @TableField("ZJKZYMJZRC")
    private Integer zjkzymjzrc;

    /**
     * 针灸科（中医）出院人数
     */
    @TableField("ZJKZYCYRS")
    private Integer zjkzycyrs;

    /**
     * 推拿科（中医）实有床位
     */
    @TableField("TNKZYSYCW")
    private Integer tnkzysycw;

    /**
     * 推拿科（中医）门急诊人次
     */
    @TableField("TNKZYMJZRC")
    private Integer tnkzymjzrc;

    /**
     * 推拿科（中医）出院人数
     */
    @TableField("TNKZYCYRS")
    private Integer tnkzycyrs;

    /**
     * 康复医学（中医）实有床位
     */
    @TableField("KFYXZYSYCW")
    private Integer kfyxzysycw;

    /**
     * 康复医学（中医）门急诊人次
     */
    @TableField("KFYXZYMJZRC")
    private Integer kfyxzymjzrc;

    /**
     * 康复医学（中医）出院人数
     */
    @TableField("KFYXZYCYRS")
    private Integer kfyxzycyrs;

    /**
     * 急诊科（中医）实有床位
     */
    @TableField("JZKZYSYCW")
    private Integer jzkzysycw;

    /**
     * 急诊科（中医）门急诊人次
     */
    @TableField("JZKZYMJZRC")
    private Integer jzkzymjzrc;

    /**
     * 急诊科（中医）出院人数
     */
    @TableField("JZKZYCYRS")
    private Integer jzkzycyrs;

    /**
     * 预防保健科（中医）实有床位
     */
    @TableField("YFBJKZYSYCW")
    private Integer yfbjkzysycw;

    /**
     * 预防保健科（中医）门急诊人次
     */
    @TableField("YFBJKZYMJZRC")
    private Integer yfbjkzymjzrc;

    /**
     * 预防保健科（中医）出院人数
     */
    @TableField("YFBJKZYCYRS")
    private Integer yfbjkzycyrs;

    /**
     * 其他中医科（中医）实有床位
     */
    @TableField("QTZYKZYSYCW")
    private Integer qtzykzysycw;

    /**
     * 其他中医科（中医）门急诊人次
     */
    @TableField("QTZYKZYMJZRC")
    private Integer qtzykzymjzrc;

    /**
     * 其他中医科（中医）出院人数
     */
    @TableField("QTZYKZYCYRS")
    private Integer qtzykzycyrs;

    /**
     * 维吾尔医学科（中医）实有床位
     */
    @TableField("WWEYXKZYSYCW")
    private Integer wweyxkzysycw;

    /**
     * 维吾尔医学科（中医）门急诊人次
     */
    @TableField("WWEYXKZYMJZRC")
    private Integer wweyxkzymjzrc;

    /**
     * 维吾尔医学科（中医）出院人数
     */
    @TableField("WWEYXKZYCYRS")
    private Integer wweyxkzycyrs;

    /**
     * 藏医学科（中医）实有床位
     */
    @TableField("CYXKZYSYCW")
    private Integer cyxkzysycw;

    /**
     * 藏医学科（中医）门急诊人次
     */
    @TableField("CYXKZYMJZRC")
    private Integer cyxkzymjzrc;

    /**
     * 藏医学科（中医）出院人数
     */
    @TableField("CYXKZYCYRS")
    private Integer cyxkzycyrs;

    /**
     * 蒙医学科（中医）实有床位
     */
    @TableField("MYXKZYSYCW")
    private Integer myxkzysycw;

    /**
     * 蒙医学科（中医）门急诊人次
     */
    @TableField("MYXKZYMJZRC")
    private Integer myxkzymjzrc;

    /**
     * 蒙医学科（中医）出院人数
     */
    @TableField("MYXKZYCYRS")
    private Integer myxkzycyrs;

    /**
     * 彝医学科（中医）实有床位
     */
    @TableField("YYXKZYSYCW")
    private Integer yyxkzysycw;

    /**
     * 彝医学科（中医）门急诊人次
     */
    @TableField("YYXKZYMJZRC")
    private Integer yyxkzymjzrc;

    /**
     * 彝医学科（中医）出院人数
     */
    @TableField("YYXKZYCYRS")
    private Integer yyxkzycyrs;

    /**
     * 傣医学科（中医）实有床位
     */
    @TableField("DYXKZYSYCW")
    private Integer dyxkzysycw;

    /**
     * 傣医学科（中医）门急诊人次
     */
    @TableField("DYXKZYMJZRC")
    private Integer dyxkzymjzrc;

    /**
     * 傣医学科（中医）出院人数
     */
    @TableField("DYXKZYCYRS")
    private Integer dyxkzycyrs;

    /**
     * 其他民族医学科（中医）实有床位
     */
    @TableField("QTMZYXKZYSYCW")
    private Integer qtmzyxkzysycw;

    /**
     * 其他民族医学科（中医）门急诊人次
     */
    @TableField("QTMZYXKZYMJZRC")
    private Integer qtmzyxkzymjzrc;

    /**
     * 其他民族医学科（中医）出院人数
     */
    @TableField("QTMZYXKZYCYRS")
    private Integer qtmzyxkzycyrs;

    /**
     * 中西医结合科（中医）实有床位
     */
    @TableField("ZXYJHKZYSYCW")
    private Integer zxyjhkzysycw;

    /**
     * 中西医结合科（中医）门急诊人次
     */
    @TableField("ZXYJHKZYMJZRC")
    private Integer zxyjhkzymjzrc;

    /**
     * 中西医结合科（中医）出院人数
     */
    @TableField("ZXYJHKZYCYRS")
    private Integer zxyjhkzycyrs;

    /**
     * 中医特色指标年内中医治未病服务人次数
     */
    @TableField("ZYTSZBNNZYZWBFWRCS")
    private Integer zytszbnnzyzwbfwrcs;

    /**
     * 中医特色指标年末开展中医医疗技术总数
     */
    @TableField("ZYTSZBNMKZZYYLJSZS")
    private Integer zytszbnmkzzyyljszs;

    /**
     * 中医特色指标年末中药制剂室面积
     */
    @TableField("ZYTSZBNMZYZJSMJ")
    private Integer zytszbnmzyzjsmj;

    /**
     * 中医特色指标年末中药制剂品种数
     */
    @TableField("ZYTSZBNMZYZJPZS")
    private Integer zytszbnmzyzjpzs;

    /**
     * 中医特色指标年末5000元以上中医诊疗设备台数
     */
    @TableField("ZYTSZBNMWQYYSZYZLSBTS")
    private Integer zytszbnmwqyyszyzlsbts;

    /**
     * 电针治疗设备台数
     */
    @TableField("DZZLSBTS")
    private Integer dzzlsbts;

    /**
     * 中药熏洗设备台数
     */
    @TableField("ZYXXSBTS")
    private Integer zyxxsbts;

    /**
     * 中医电疗设备台数
     */
    @TableField("ZYDLSBTS")
    private Integer zydlsbts;

    /**
     * 中医磁疗设备台数
     */
    @TableField("ZYCLSBTS")
    private Integer zyclsbts;

    /**
     * 中医康复训练设备台数
     */
    @TableField("ZYKFXLSBTS")
    private Integer zykfxlsbts;

    /**
     * 煎药机台（套）数
     */
    @TableField("JYJTTS")
    private Integer jyjtts;

    /**
     * 单位负责人
     */
    @TableField("DWFZR")
    private String dwfzr;

    /**
     * 统计负责人
     */
    @TableField("TJFZR")
    private String tjfzr;

    /**
     * 填表人
     */
    @TableField("TBR")
    private String tbr;

    /**
     * 联系电话
     */
    @TableField("TBRLXDH")
    private String tbrlxdh;

    /**
     * 报出日期年
     */
    @TableField("BCRQN")
    private String bcrqn;

    /**
     * 报出日期月
     */
    @TableField("BCRQY")
    private String bcrqy;

    /**
     * 报出日期日
     */
    @TableField("BCRQR")
    private String bcrqr;

    /**
     * 主鍵
     */
    @TableId(value="ID",type=IdType.UUID)
    private String id;


}
