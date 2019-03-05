package comm.torrent.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.util.CommSession;

@Repository(value="mainDao")
public class MainDao extends CommSession {

	@Autowired
	private SqlSession session;

    public List<HashMap<String, Object>> getMenuList() {
		return session.selectList("MAIN.getMenuList");
	}
}
