package com.msunsoft.spt.common.core.validator;

import com.msunsoft.spt.common.core.annotation.IsMobile;
import com.msunsoft.spt.common.core.entity.constant.RegexpConstant;
import com.msunsoft.spt.common.core.utils.SptUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验是否为合法的手机号码
 *
 * @author Schoder
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE;
                return SptUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
