package com.msunsoft.spt.auth.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Schoder
 */
@Data
public class BindUser implements Serializable {

    private static final long serialVersionUID = -3890998115990166651L;

    @NotBlank(message = "{required}")
    private String bindUsername;
    @NotBlank(message = "{required}")
    private String bindPassword;
}
