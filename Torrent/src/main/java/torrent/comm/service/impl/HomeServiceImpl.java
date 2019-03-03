package torrent.comm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import torrent.comm.dao.HomeDao;
import torrent.comm.service.HomeService;

@Service( value="homeService")
public class HomeServiceImpl implements HomeService{

	@Resource(name="homeDao")
	private HomeDao homeDao;

	@Override
	public List<HashMap<String, Object>> getMenuList() {
		return homeDao.getMenuList();
	}
	
	
	
}
