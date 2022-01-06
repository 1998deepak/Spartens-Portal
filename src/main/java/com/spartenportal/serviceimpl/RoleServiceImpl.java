package com.spartenportal.serviceimpl;

/**
 * @author Ashwini Dhikale
 * @date 25/12/2021
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spartenportal.bean.RolesBean;
import com.spartenportal.entity.Roles;
import com.spartenportal.mapper.RolesMapper;
import com.spartenportal.repository.RolesRepository;
import com.spartenportal.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private RolesMapper rolesMapper;

	@Override
	public List<RolesBean> fetchRoleList() {
		List<RolesBean> roles = new ArrayList<>();
		List<Roles> data = rolesRepository.findAll();
		if (!CollectionUtils.isEmpty(data)) {
			data.forEach(data1 -> roles.add(rolesMapper.mapToBean(data1)));
		}
		return roles;
	}

	@Override
	public RolesBean fetchRolebyName(String roleName) {
		RolesBean fetchedRoleData = null;
		Optional<Roles> role = rolesRepository.fetchRoleByName(roleName);
		if (role.isPresent()) {
			Roles roles = role.get();
			fetchedRoleData = rolesMapper.mapToBean(roles);
		}
		return fetchedRoleData;
	}

	@Override
	public Roles findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		Roles role = rolesRepository.findByRoleName(roleName);
		return role;
	
	}
}
