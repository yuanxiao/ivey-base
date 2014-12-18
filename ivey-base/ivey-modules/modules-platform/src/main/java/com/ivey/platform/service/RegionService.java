package com.ivey.platform.service;

import java.util.List;

import com.ivey.base.service.BaseService;
import com.ivey.platform.entity.dto.RegionDto;

public interface RegionService extends BaseService {

	public List<RegionDto> findAll();

}
