package com.msunsoft.spt.auth.service.impl;

import com.msunsoft.spt.auth.manager.UserManager;

import com.msunsoft.spt.common.core.entity.SptAuthUser;
import com.msunsoft.spt.common.core.entity.constant.ParamsConstant;
import com.msunsoft.spt.common.core.entity.constant.SocialConstant;
import com.msunsoft.spt.common.core.entity.system.SystemUser;
import com.msunsoft.spt.common.core.utils.SptUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Schoder
 */
@Service
@RequiredArgsConstructor
public class SptUserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest httpServletRequest = SptUtil.getHttpServletRequest();
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus())) {
                notLocked = true;
            }
            String password = systemUser.getPassword();
            String loginType = (String) httpServletRequest.getAttribute(ParamsConstant.LOGIN_TYPE);
            if (StringUtils.equals(loginType, SocialConstant.SOCIAL_LOGIN)) {
                password = passwordEncoder.encode(SocialConstant.getSocialLoginPassword());
            }

            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.NO_AUTHORITIES;
            if (StringUtils.isNotBlank(permissions)) {
                grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
            }
            SptAuthUser authUser = new SptAuthUser(systemUser.getUsername(), password, true, true, true, notLocked,
                    grantedAuthorities);

            BeanUtils.copyProperties(systemUser, authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }
}
