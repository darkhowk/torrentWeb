package torrent.comm.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import comm.util.CommSession;

@Repository(value="homeDao")
public class HomeDao extends CommSession {

	private SqlSession session;

    public List<HashMap<String, Object>> getMenuList() {
		return session.selectList("HOME.getMenuList");
	}
}
