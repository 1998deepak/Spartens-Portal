package com.spartenportal.mapper;

import com.spartenportal.bean.PolociesBean;
import com.spartenportal.entity.Policies;

public class PoliciesMapper {
	public PolociesBean mapToBean(Policies policy) {
		PolociesBean policyBean = new PolociesBean();
		policyBean.setPolicyId(policy.getPolicyId());
		policyBean.setPolicyName(policy.getPolicyName());
		policyBean.setPolicyType(policy.getPolicyType());
		policyBean.setPolicyPath(policy.getPolicyPath());
		policyBean.setUploadDate(policy.getUploadDate());
		policyBean.setModifyDate(policy.getModifyDate());
		return policyBean;
	}
	
	public Policies mapToEntity(PolociesBean policyBean) {
		Policies policy = new Policies();
		policy.setPolicyId(policyBean.getPolicyId());
		policy.setPolicyName(policyBean.getPolicyName());
		policy.setPolicyType(policyBean.getPolicyType());
		policy.setPolicyPath(policyBean.getPolicyPath());
		policy.setUploadDate(policyBean.getUploadDate());
		policy.setModifyDate(policyBean.getModifyDate());
		return policy;	
	}
	
}
