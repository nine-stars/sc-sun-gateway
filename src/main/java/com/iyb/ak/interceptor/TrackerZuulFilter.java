package com.iyb.ak.interceptor;

import com.iyb.ak.constants.SecurityConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


@Slf4j
public class TrackerZuulFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return -1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();

		if(StringUtils.isNotEmpty(GlobalProcessIdFilter.getGloblPid()))
			ctx.addZuulRequestHeader(SecurityConstants.GLOBAL_PID, GlobalProcessIdFilter.getGloblPid());
		if(StringUtils.isNotEmpty(GlobalProcessIdFilter.getAccessToken()))
			ctx.addZuulRequestHeader(SecurityConstants.ACCESS_TOKEN, GlobalProcessIdFilter.getAccessToken());
		if(StringUtils.isNotEmpty(GlobalProcessIdFilter.getUserUuid()))
			ctx.addZuulRequestHeader(SecurityConstants.USER_UUID, GlobalProcessIdFilter.getUserUuid());
		if(StringUtils.isNotEmpty(GlobalProcessIdFilter.getCompUuid()))
			ctx.addZuulRequestHeader(SecurityConstants.COMPUUID, GlobalProcessIdFilter.getCompUuid());
		if(StringUtils.isNotEmpty(GlobalProcessIdFilter.getEmplUuid()))
			ctx.addZuulRequestHeader(SecurityConstants.EMPL_UUID, GlobalProcessIdFilter.getEmplUuid());

		return null;
	}
}