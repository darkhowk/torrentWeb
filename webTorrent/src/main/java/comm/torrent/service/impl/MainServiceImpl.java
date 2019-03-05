package comm.torrent.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import comm.torrent.dao.MainDao;
import comm.torrent.service.MainService;

@Service( value="mainService")
public class MainServiceImpl implements MainService{

	@Resource(name="mainDao")
	private MainDao mainDao;

	@Override
	public List<HashMap<String, Object>> getMenuList() {
		return mainDao.getMenuList();
	}
	
	
	
}
