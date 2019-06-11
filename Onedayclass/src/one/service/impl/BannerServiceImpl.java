package one.service.impl;

import java.util.List;

import one.dao.face.BannerDao;
import one.dao.impl.BannerDaoImpl;
import one.service.face.BannerService;

public class BannerServiceImpl implements BannerService{
	
	// BannerDao 객체
	private BannerDao bannerDao = new BannerDaoImpl();
	
	@Override
	public List getList() {
		return bannerDao.selectAll();
	}

}
