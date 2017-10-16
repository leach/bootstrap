package com.anythy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="securityConfig")
public class SecuritySettings {
    private String permitAll = "/api";
    private String deniedPage = "/deny";
    private String failureUrl = "/login?error";
    private String loginUrl = "/login";
    private String loginSuccessUrl = "/home";
    private String logoutUrl = "/logout";
    private String logoutSuccssUrl = "/goodbye";
    private String urlRoles;

    public String getPermitAll() {
        return permitAll;
    }

    public void setPermitAll(String permitAll) {
        this.permitAll = permitAll;
    }

    public String getDeniedPage() {
        return deniedPage;
    }

    public void setDeniedPage(String deniedPage) {
        this.deniedPage = deniedPage;
    }

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public void setLoginSuccessUrl(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getLogoutSuccssUrl() {
        return logoutSuccssUrl;
    }

    public void setLogoutSuccssUrl(String logoutSuccssUrl) {
        this.logoutSuccssUrl = logoutSuccssUrl;
    }

    public String getUrlRoles() {
        return urlRoles;
    }

    public void setUrlRoles(String urlRoles) {
        this.urlRoles = urlRoles;
    }

    public String getFailureUrl() {
        return failureUrl;
    }

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
